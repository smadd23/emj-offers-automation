package com.safeway.j4u.emju.offers.service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.springframework.util.CollectionUtils.isEmpty;

import java.time.ZonedDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.datastax.driver.core.querybuilder.Batch;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.StatusType;
import com.safeway.j4u.emju.offers.repository.CassandraUtility;
import com.safeway.j4u.emju.offers.repository.OfferDetailsRepository;
import com.safeway.j4u.emju.offers.util.OfferIdGenerator;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
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

	public Mono<Boolean> updateStatus(StatusType status, Set<String> externalOfferIds) {

		if (isEmpty(externalOfferIds) || (externalOfferIds.size() > acceptableNumberOfOffersForUpdateStatus)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("# of Offers acceptable for update must be greater than 0 and less than equal to %d",
							acceptableNumberOfOffersForUpdateStatus));
		}
		Flux<Insert> inserts = offerDetailsRepository.findOfferDetailsIdsByExternalOfferIds(externalOfferIds)
				.map(offerDetailToBeUpdated -> {
					offerDetailToBeUpdated.setOfferStatus(status.name());
					if (StatusType.D == status) {
						offerDetailToBeUpdated.setDisplayEffectiveEndDate(ZonedDateTime.now());
					} else if (StatusType.E == status) {
						offerDetailToBeUpdated.setDisplayEffectiveEndDate(ZonedDateTime.now());
						offerDetailToBeUpdated.setOfferEffectiveEndDate(ZonedDateTime.now());
					}
					return cassandraUtility.batchInserts(reactiveCassandraTemplate, offerDetailToBeUpdated.getOfferEffectiveEndDate(),
							additionalTtlDays, offerDetailToBeUpdated).get(0);
				}).onErrorMap(e -> e);

		return inserts.collectList().flatMap(statements -> {
			Batch batch = QueryBuilder.batch();
			statements.forEach(batch::add);
			return reactiveCassandraTemplate.getReactiveCqlOperations().execute(batch);
		}).onErrorMap(e -> e);
	}

}
