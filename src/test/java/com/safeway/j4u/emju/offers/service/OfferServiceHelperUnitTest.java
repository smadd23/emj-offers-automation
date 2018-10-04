package com.safeway.j4u.emju.offers.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.datastax.driver.core.Statement;
import com.safeway.j4u.emju.offers.mapper.OfferDetailsMapper;
import com.safeway.j4u.emju.offers.model.EndDate;
import com.safeway.j4u.emju.offers.model.Id;
import com.safeway.j4u.emju.offers.model.Info;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.Rules;
import com.safeway.j4u.emju.offers.repository.CassandraUtility;
import java.time.ZonedDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.data.cassandra.core.cql.ReactiveCqlOperations;
import reactor.core.publisher.Mono;

@RunWith(MockitoJUnitRunner.class)
public class OfferServiceHelperUnitTest {

  @InjectMocks
  private OfferServiceHelper offerServiceHelper;

  @Mock
  private CassandraUtility cassandraUtility;

  @Mock
  private ReactiveCassandraTemplate reactiveCassandraTemplate;

  @Mock
  private ReactiveCqlOperations reactiveCqlOperations;

  @Mock
  private OfferDetailsMapper offerDetailsMapper;

  private ArgumentCaptor<Offer> offerArgumentCaptor = ArgumentCaptor.forClass(Offer.class);

  @Test
  public void batchInsert() {

    Offer offer = Offer.builder()
        .info(Info.builder()
            .id(Id.builder().externalOfferId("1").build()).build())
        .rules(Rules.builder()
            .endDate(EndDate.builder()
                .offerEffectiveEndDate(ZonedDateTime.now()).build()).build()).build();

    when(reactiveCassandraTemplate.getReactiveCqlOperations()).thenReturn(reactiveCqlOperations);
    when(reactiveCqlOperations.execute(any(Statement.class))).thenReturn(Mono.just(true));

    offerServiceHelper.batchInsert(offer);

    verify(reactiveCqlOperations).execute(any(Statement.class));
    verify(offerDetailsMapper).from(offerArgumentCaptor.capture());
    assertThat(offerArgumentCaptor.getValue().getInfo().getId().getExternalOfferId(), equalTo("1"));

  }



}
