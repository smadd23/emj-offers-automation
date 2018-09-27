package com.safeway.j4u.emju.offers.service;

import com.datastax.driver.core.querybuilder.Batch;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.safeway.j4u.emju.offers.mapper.OfferDetailsMapper;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.repository.CassandraUtility;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class OfferServiceHelper {

  @Autowired
  private CassandraUtility cassandraUtility;
  @Autowired
  private ReactiveCassandraTemplate reactiveCassandraTemplate;
  @Autowired
  private OfferDetailsMapper offerDetailsMapper;
  @Value("${offer.row.ttl.additionalTtlDays:0}")
  private int additionalTtlDays;
  @Value("${offer.updateStatus.acceptableNumberOfOffers:500}")
  private int acceptableNumberOfOffersForUpdateStatus;

  protected Mono<Boolean> batchInsert(Offer offer) {
    Collection<Insert> offerDetailsInserts = cassandraUtility.batchInserts(reactiveCassandraTemplate,
        offer.getRules().getEndDate().getOfferEffectiveEndDate(), additionalTtlDays,
        offerDetailsMapper.from(offer));
    Batch batch = QueryBuilder.batch();
    offerDetailsInserts.forEach(batch::add);
    return reactiveCassandraTemplate.getReactiveCqlOperations().execute(batch);
  }

}
