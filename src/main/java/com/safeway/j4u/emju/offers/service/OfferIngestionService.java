package com.safeway.j4u.emju.offers.service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static org.springframework.util.CollectionUtils.isEmpty;
import static reactor.core.Exceptions.propagate;

import com.datastax.driver.core.querybuilder.Batch;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.google.common.collect.Maps;
import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.mapper.OfferDetailsMapper;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.StatusType;
import com.safeway.j4u.emju.offers.model.offersetup.Response;
import com.safeway.j4u.emju.offers.repository.CassandraUtility;
import com.safeway.j4u.emju.offers.repository.OfferDetailsRepository;
import com.safeway.j4u.emju.offers.util.OfferIdGenerator;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class OfferIngestionService {

	@Autowired
	private OfferDetailsRepository offerDetailsRepository;
	@Autowired
	private OfferServiceHelper offerServiceHelper;
	@Autowired
	private ReactiveCassandraTemplate reactiveCassandraTemplate;
	@Autowired
	private CassandraUtility cassandraUtility;
	@Autowired
	private OfferIdGenerator offerIdGenerator;
	@Value("${offer.row.ttl.additionalTtlDays:0}")
	private int additionalTtlDays;
	@Value("${offer.updateStatus.acceptableNumberOfOffers:500}")
	private int acceptableNumberOfOffersForUpdateStatus;
	@Value("${offer.external.offerSetup.url}")
	private String offerSetupApiUrl;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private OfferDetailsMapper offerDetailsMapper;

	public Mono<Disposable> save(Offer offer) {
		return offerDetailsRepository.findByExternalOfferId(offer.getInfo().getId().getExternalOfferId())
				.defaultIfEmpty(OfferDetails.builder().fakeDefaultOffer(true).build())
				.map(pulledOffer -> saveOffer(pulledOffer, offer)).onErrorMap(e -> e);
	}

	private Disposable saveOffer(OfferDetails dbOffer, Offer offer) {
		return dbOffer.isFakeDefaultOffer() ? newOffer(offer) : mergeOffer(dbOffer, offer);
	}

	protected Disposable newOffer(Offer offer) {
		if (isNull(offer.getInfo().getId().getOfferId())) {
			offer.getInfo().getId().setOfferId(offerIdGenerator.generateOfferId());
		}
		Mono<Boolean> status = offerServiceHelper.batchInsert(offer);
		return status.onErrorMap(e -> e).subscribe();
	}

  protected Disposable mergeOffer(OfferDetails dbOffer, Offer offer) {
    if(nonNull(offer.getInfo().getId().getOfferId())
				&& !dbOffer.getOfferId().equals(offer.getInfo().getId().getOfferId())) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Offer Id mismatch");
    }
    offer.getInfo().getId().setOfferId(dbOffer.getOfferId());
    return offerServiceHelper.batchInsert(offer).onErrorMap(e -> e).subscribe();
  }

	public Mono<Map<String, String>> updateStatus(StatusType status, Set<String> externalOfferIds) {

		if (isEmpty(externalOfferIds) || (externalOfferIds.size() > acceptableNumberOfOffersForUpdateStatus)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("# of Offers acceptable for update must be greater than 0 and less than equal to %d",
							acceptableNumberOfOffersForUpdateStatus));
		}

		return offerDetailsRepository.findOfferDetailsIdsByExternalOfferIds(externalOfferIds)
				.collectList()
				.map(offerDetailsList -> {
					List<OfferDetails> origOfferDetailsList = offerDetailsList.stream().map(a -> a.toBuilder().build()).collect(toList());
					executeOfferDetailsInserts(offerDetailsList, status).onErrorMap(e ->{ throw propagate(e);}).subscribe();
					return publishToJ4U(origOfferDetailsList, offerDetailsList, status);
				})
				.onErrorMap(e -> e);
	}

	protected Mono<Boolean> executeOfferDetailsInserts(List<OfferDetails> offerDetailsList, StatusType status) {

		List<Insert> statements = offerDetailsList.stream()
				.map(offerDetailToBeUpdated -> setStatus(offerDetailToBeUpdated, nonNull(status) ? status : StatusType.valueOf(offerDetailToBeUpdated.getOfferStatus())))
				.collect(toList())
				.stream()
				.map(offerDetailToBeUpdated -> cassandraUtility.batchInserts(reactiveCassandraTemplate, offerDetailToBeUpdated.getOfferEffectiveEndDate(),
						additionalTtlDays,offerDetailToBeUpdated).get(0))
				.collect(toList());

		Batch batch = QueryBuilder.batch();
		statements.forEach(batch::add);
		return reactiveCassandraTemplate.getReactiveCqlOperations().execute(batch);
	}

	protected OfferDetails setStatus(OfferDetails offerDetails, StatusType status) {
		offerDetails.setOfferStatus(status.name());
		if (StatusType.D == status) {
			offerDetails.setDisplayEffectiveEndDate(ZonedDateTime.now());
		} else if (StatusType.E == status) {
			offerDetails.setDisplayEffectiveEndDate(ZonedDateTime.now());
			offerDetails.setOfferEffectiveEndDate(ZonedDateTime.now());
		}
		return offerDetails;
	}

	protected Map<String, String> publishToJ4U (List<OfferDetails> origOfferDetailsList, List<OfferDetails> offerDetailsList, StatusType status) {
		Map<String, String> errorMap = Maps.newHashMap();
		offerDetailsList.stream().filter(offerDetails -> StatusType.A.name().equals(offerDetails.getOfferStatus())).forEach((offerDetails) -> {
			ResponseEntity<Response> postResponse = null;
			try {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_XML);
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN, MediaType.TEXT_HTML));
				HttpEntity<com.safeway.j4u.emju.offers.model.offersetup.Offer> requestBody = new HttpEntity<>(offerDetailsMapper.toJ4UOffer(offerDetails), headers);
				postResponse = restTemplate
						.postForEntity(offerSetupApiUrl, requestBody, Response.class);
				if (!postResponse.getStatusCode().equals(HttpStatus.OK)) {
					errorMap.put(offerDetails.getExternalOfferId(), postResponse.getBody().toString());
				}
			} catch(Exception e) {
				errorMap.put(offerDetails.getExternalOfferId(), e.getLocalizedMessage());
			}
			Map<String, OfferDetails> mapOfOriginalOfferDetails = origOfferDetailsList.stream().collect(toMap(OfferDetails::getExternalOfferId, identity()));
			executeOfferDetailsInserts(errorMap.keySet().stream().map(mapOfOriginalOfferDetails::get).collect(toList()), null).onErrorMap(e -> e).subscribe();
		});


		return errorMap;
	}

}
