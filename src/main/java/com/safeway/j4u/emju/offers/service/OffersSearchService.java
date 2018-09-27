package com.safeway.j4u.emju.offers.service;

import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.mapper.OfferDetailsMapper;
import com.safeway.j4u.emju.offers.mapper.OfferSearchCriteriaKeyMapper;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.OfferSearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Flux;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OffersSearchService {

	private OfferDetailsMapper offerDetailsMapper;
	private ReactiveCassandraTemplate cassandraTemplate;
	private OfferSearchQueryBuilder offerSearchQueryBuilder;

	public Flux<Offer> searchOffers(String search) {
		List<OfferSearchCriteria> srchCriteria = new ArrayList<OfferSearchCriteria>();

		try {
			if (search != null) {
				Pattern pattern = Pattern.compile("(\\w+?)(=|<|>|>=|<=)([a-zA-Z0-9_,\\:\\*\\[\\]\\(\\)\\s-]+?);");
				Matcher matcher = pattern.matcher(search + ";");
				boolean matchFound = false;

				while (matcher.find()) {
					srchCriteria.add(new OfferSearchCriteria(
							OfferSearchCriteriaKeyMapper.valueOf(matcher.group(1)).getColumn(matcher.group(3)),
							matcher.group(2), OfferSearchCriteriaKeyMapper.valueOf(matcher.group(1))
									.getDynamicColumnValue(matcher.group(3))));
					matchFound = true;
				}
				
				if (matchFound == false)
				{
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
				}
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
		}

		return cassandraTemplate.select(offerSearchQueryBuilder.buildAttributesClause(srchCriteria), OfferDetails.class)
				.map(offerDetails -> offerDetailsMapper.toOffer(offerDetails));
	}

}