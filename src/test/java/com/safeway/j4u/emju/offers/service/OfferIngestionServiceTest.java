package com.safeway.j4u.emju.offers.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.model.EndDate;
import com.safeway.j4u.emju.offers.model.Id;
import com.safeway.j4u.emju.offers.model.Info;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.Rules;
import com.safeway.j4u.emju.offers.model.StatusType;
import com.safeway.j4u.emju.offers.repository.CassandraUtility;
import com.safeway.j4u.emju.offers.repository.OfferDetailsRepository;
import com.safeway.j4u.emju.offers.util.OfferIdGenerator;
import java.time.ZonedDateTime;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.data.cassandra.core.cql.ReactiveCqlOperations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(MockitoJUnitRunner.class)
public class OfferIngestionServiceTest {

  @InjectMocks
  private OfferIngestionService offerIngestionService;

  @Mock
  private OfferServiceHelper offerServiceHelper;

  @Mock
  private OfferIdGenerator offerIdGenerator;

  @Mock
  private OfferDetailsRepository offerDetailsRepository;

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private CassandraUtility cassandraUtility;

  @Mock
  private ReactiveCassandraTemplate reactiveCassandraTemplate;

  @Mock
  ReactiveCqlOperations reactiveCqlOperations;

  @Value("${offer.row.ttl.additionalTtlDays:0}")
  private int additionalTtlDays;

  @Value("${offer.updateStatus.acceptableNumberOfOffers:3}")
  private int acceptableNumberOfOffersForUpdateStatus;

  private ArgumentCaptor<Offer> offerArgumentCaptor = ArgumentCaptor.forClass(Offer.class);

  @Test
  public void newOffer() {

    Offer offer = Offer.builder()
        .info(Info.builder()
            .id(Id.builder().externalOfferId("1").build()).build())
        .rules(Rules.builder()
            .endDate(EndDate.builder()
                .offerEffectiveEndDate(ZonedDateTime.now()).build()).build()).build();
    when(offerIdGenerator.generateOfferId()).thenReturn(1L);
    when(offerServiceHelper.batchInsert(offer)).thenReturn(Mono.just(Boolean.TRUE));

    offerIngestionService.newOffer(offer);

    verify(offerServiceHelper).batchInsert(offerArgumentCaptor.capture());
    assertThat(offerArgumentCaptor.getValue().getInfo().getId().getOfferId(), equalTo(1L));

  }

  @Test
  public void mergeOffer() {

    Offer offer = Offer.builder()
        .info(Info.builder()
            .id(Id.builder().externalOfferId("1").offerId(1L).build()).build())
        .rules(Rules.builder()
            .endDate(EndDate.builder()
                .offerEffectiveEndDate(ZonedDateTime.now()).build()).build()).build();

    OfferDetails dbOfferDetails = OfferDetails.builder()
        .externalOfferId("1").offerId(1L).build();
    when(offerServiceHelper.batchInsert(offer)).thenReturn(Mono.just(Boolean.TRUE));

    offerIngestionService.mergeOffer(dbOfferDetails, offer);

    verify(offerServiceHelper).batchInsert(offerArgumentCaptor.capture());
    assertThat(offerArgumentCaptor.getValue().getInfo().getId().getOfferId(), equalTo(1L));
    assertThat(offerArgumentCaptor.getValue().getInfo().getId().getExternalOfferId(), equalTo("1"));

  }

  @Test(expected = ResponseStatusException.class)
  public void mergeOfferThrowsExceptionWhenOfferIdInDBDoesnotMatch() {

    Offer offer = Offer.builder()
        .info(Info.builder()
            .id(Id.builder().externalOfferId("1").offerId(1L).build()).build())
        .rules(Rules.builder()
            .endDate(EndDate.builder()
                .offerEffectiveEndDate(ZonedDateTime.now()).build()).build()).build();

    OfferDetails dbOfferDetails = OfferDetails.builder()
        .externalOfferId("1").offerId(2L).build();

    offerIngestionService.mergeOffer(dbOfferDetails, offer);

  }

  @Test
  public void updateStatus() {

    ReflectionTestUtils.setField(offerIngestionService, "acceptableNumberOfOffersForUpdateStatus", 2);
    Set<String> externalOfferIds = ImmutableSet.of("1", "2");

    when(offerDetailsRepository.findOfferDetailsIdsByExternalOfferIds(externalOfferIds)).thenReturn(stubTwoOfferDetails());
    when(reactiveCassandraTemplate.getReactiveCqlOperations()).thenReturn(reactiveCqlOperations);
    when(reactiveCqlOperations.execute(any(Statement.class))).thenReturn(Mono.just(true));

    offerIngestionService.updateStatus(StatusType.A, externalOfferIds).subscribe();

    verify(reactiveCassandraTemplate).getReactiveCqlOperations();
    verify(reactiveCqlOperations).execute(any(Statement.class));

  }

  @Test(expected = ResponseStatusException.class)
  public void updateStatusForMoreThanAcceptableCountOfOffers() {

    ReflectionTestUtils.setField(offerIngestionService, "acceptableNumberOfOffersForUpdateStatus", 2);
    Set<String> externalOfferIds = ImmutableSet.of("1", "2", "3");

    offerIngestionService.updateStatus(StatusType.A, externalOfferIds).subscribe();

  }

  private Flux<OfferDetails> stubTwoOfferDetails() {
    return Flux.just(OfferDetails.builder()
        .externalOfferId("1").offerId(1L).build(), OfferDetails.builder()
        .externalOfferId("2").offerId(2L).build());

  }

}
