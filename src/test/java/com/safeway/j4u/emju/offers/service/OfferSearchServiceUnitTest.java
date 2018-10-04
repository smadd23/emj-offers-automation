package com.safeway.j4u.emju.offers.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.cql.CqlOperations;
import org.springframework.data.cassandra.core.cql.ReactiveCqlOperations;
import org.springframework.web.server.ResponseStatusException;
import com.datastax.driver.core.Statement;
import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.mapper.OfferDetailsMapper;
import com.safeway.j4u.emju.offers.model.OfferSearchCriteria;
import com.safeway.j4u.emju.offers.model.SearchCountCriteria;
import com.safeway.j4u.emju.offers.repository.OfferDetailsRepository;
import com.safeway.j4u.emju.offers.util.OfferIdGenerator;

@RunWith(MockitoJUnitRunner.class)
public class OfferSearchServiceUnitTest {

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
  private ReactiveCassandraTemplate cassandraReactiveTemplate;

  @Mock
  ReactiveCqlOperations reactiveCqlOperations;

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private CassandraTemplate cassandraTemplate;

  @Mock
  private CqlOperations cqlOperations;

  @Mock
  private CassandraConverter cassandraConverter;

  @Mock
  private String aString;

  @Value("${offer.search.query.maxPageSize}")
  private int maxPageSize;

  @Value("${offer.search.cursorCache.row.ttl.ttlInMinutes}")
  private int cursorCacheTtlMinutes;

  private ArgumentCaptor<OfferDetails> offerDetailsArgumentCaptor =
      ArgumentCaptor.forClass(OfferDetails.class);

  private ArgumentCaptor<List<OfferSearchCriteria>> offerSearchCriteriaArgumentCaptor =
      ArgumentCaptor.forClass(List.class);

  private ArgumentCaptor<String> pageArgumentCaptor = ArgumentCaptor.forClass(String.class);

  @Test
  public void searchOffersCriteriaWhenOfferIdIsGiven() throws Exception {

    String search = "offerId=1;offerStatus=A";
    offerSrchSvc.searchOffers(search, new SearchCountCriteria(false, false));

    verify(offerSearchQueryBuilder).buildAttributesClause(
        offerSearchCriteriaArgumentCaptor.capture(), pageArgumentCaptor.capture());

    assertThat(offerSearchCriteriaArgumentCaptor.getValue().size(), greaterThan(0));
    assertThat(pageArgumentCaptor.getValue(), is(nullValue()));
  }

  @Test
  public void searchOffersCriteriaWhenExternalOfferIdIsGiven() throws Exception {

    String search = "externalOfferId=1";
    offerSrchSvc.searchOffers(search, new SearchCountCriteria(false, false));

    verify(offerSearchQueryBuilder).buildAttributesClause(
        offerSearchCriteriaArgumentCaptor.capture(), pageArgumentCaptor.capture());

    assertThat(offerSearchCriteriaArgumentCaptor.getValue().size(), greaterThan(0));
    assertThat(pageArgumentCaptor.getValue(), is(nullValue()));
  }

  // @Test
  public void searchOffersCriteriaWhenOfferStatusIsGiven() throws Exception {

    String search = "externalOfferId=1;offerStatus=A";
    offerSrchSvc.searchOffers(search, new SearchCountCriteria(false, false));

    when(cassandraTemplate.selectOne(any(Statement.class), String.class))
        .thenReturn(any(String.class));
    when(cassandraTemplate.selectOne(any(Statement.class), eq(Long.class)))
        .thenReturn(any(Long.class));

    verify(offerSearchQueryBuilder).buildAttributesClause(
        offerSearchCriteriaArgumentCaptor.capture(), pageArgumentCaptor.capture());
    assertThat(offerSearchCriteriaArgumentCaptor.getValue().size(), greaterThan(0));

    verify(offerSearchQueryBuilder)
        .facetCountStatement(offerSearchCriteriaArgumentCaptor.capture());
    assertThat(offerSearchCriteriaArgumentCaptor.getValue().size(), greaterThan(0));

    verify(offerSearchQueryBuilder)
        .totalCountStatement(offerSearchCriteriaArgumentCaptor.capture());
    assertThat(offerSearchCriteriaArgumentCaptor.getValue().size(), greaterThan(0));
  }

  @Test(expected = ResponseStatusException.class)
  public void searchOffersInvalidCriteriaWithInvalidSearchField() {

    String search = "d$1";
    offerSrchSvc.searchOffers(search, new SearchCountCriteria(false, false));

  }

  @Test(expected = ResponseStatusException.class)
  public void searchOffersInvalidCriteriaWithNoValue() {

    String search = "externalOfferId";
    offerSrchSvc.searchOffers(search, new SearchCountCriteria(false, false));

  }
}
