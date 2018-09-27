package com.safeway.j4u.emju.offers.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.eq;

import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.mapper.OfferDetailsMapper;
import com.safeway.j4u.emju.offers.model.EndDate;
import com.safeway.j4u.emju.offers.model.Id;
import com.safeway.j4u.emju.offers.model.Info;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.OfferSearchCriteria;
import com.safeway.j4u.emju.offers.model.Rules;
import com.safeway.j4u.emju.offers.model.StatusType;
import com.safeway.j4u.emju.offers.repository.CassandraUtility;
import com.safeway.j4u.emju.offers.repository.OfferDetailsRepository;
import com.safeway.j4u.emju.offers.util.OfferIdGenerator;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

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
public class OfferSearchServiceTest {

  @InjectMocks
  private OffersSearchService offerSrchSvc;

  @Mock
  private OfferDetailsMapper offerDetailsMapper;

  @Mock
  private OfferIdGenerator offerIdGenerator;

  @Mock
  private OfferDetailsRepository offerDetailsRepository;
  
  @Mock
  private OfferSearchQueryBuilder offerSearchQueryBuilder;

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private ReactiveCassandraTemplate cassandraTemplate;

  @Mock
  ReactiveCqlOperations reactiveCqlOperations;

  @Value("${offer.row.ttl.additionalTtlDays:0}")
  private int additionalTtlDays;

  @Value("${offer.updateStatus.acceptableNumberOfOffers:3}")
  private int acceptableNumberOfOffersForUpdateStatus;

  private ArgumentCaptor<OfferDetails> offerDetailsArgumentCaptor = ArgumentCaptor.forClass(OfferDetails.class);
  
  private ArgumentCaptor<List<OfferSearchCriteria>> offerSearchCriteriaArgumentCaptor = ArgumentCaptor.forClass(List.class);

  @Test
  public void searchOffersCriteriaWhenOfferIdIsGiven() {
    
    String search = "offerId=1;offerStatus=A";   
    offerSrchSvc.searchOffers(search);
    
    verify(offerSearchQueryBuilder).buildAttributesClause(offerSearchCriteriaArgumentCaptor.capture());
    assertThat(offerSearchCriteriaArgumentCaptor.getValue().size(),greaterThan(0));
  }
  
  @Test
  public void searchOffersCriteriaWhenExternalOfferIdIsGiven() {
    
    String search = "externalOfferId=1";   
    offerSrchSvc.searchOffers(search);
    
    verify(offerSearchQueryBuilder).buildAttributesClause(offerSearchCriteriaArgumentCaptor.capture());
    assertThat(offerSearchCriteriaArgumentCaptor.getValue().size(),greaterThan(0));
  }
  
  @Test
  public void searchOffersCriteriaWhenOfferStatusIsGiven() {
    
    String search = "externalOfferId=1;offerStatus=GG";   
    offerSrchSvc.searchOffers(search);
    
    verify(offerSearchQueryBuilder).buildAttributesClause(offerSearchCriteriaArgumentCaptor.capture());
    assertThat(offerSearchCriteriaArgumentCaptor.getValue().size(),greaterThan(0));
  }
  
  @Test(expected = ResponseStatusException.class)
  public void searchOffersInvalidCriteria() {
    
    String search = "d$1";    
    offerSrchSvc.searchOffers(search);

  }
  
  @Test(expected = ResponseStatusException.class)
  public void searchOffersInvalidCriteria1() {
    
    String search = "externalOfferId";    
    offerSrchSvc.searchOffers(search);

  }
  


  

 /* @Test
  public void searchOffersMapperWhenOfferIdAloneIsGiven() {
    
    String search = "offerId=1";
    Flux<OfferDetails> offerDetails = Flux.just(OfferDetails.builder().offerId(1L).build());
    when(cassandraTemplate.select(eq(any(Select.class)),OfferDetails.class)).thenReturn(offerDetails);
    when(offerDetails.map(eq(any(Function.class)))).thenReturn(Flux.just(Offer.builder().build()));
    
    offerSrchSvc.searchOffers(search).subscribe();
    
    verify(offerDetailsMapper).toOffer(offerDetailsArgumentCaptor.capture());
    assertThat(offerDetailsArgumentCaptor.getValue().getOfferId(), equalTo(1L));
    
  }*/

}
