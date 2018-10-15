package com.safeway.j4u.emju.offers.service;

import static java.util.Objects.nonNull;
import static org.springframework.util.CollectionUtils.isEmpty;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.utils.UUIDs;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.entity.OfferSearchCursorCache;
import com.safeway.j4u.emju.offers.mapper.OfferDetailsToOfferMapper;
import com.safeway.j4u.emju.offers.mapper.OfferToOfferDetailsMapper;
import com.safeway.j4u.emju.offers.model.OfferSearchCriteria;
import com.safeway.j4u.emju.offers.model.OfferSearchFacetCount;
import com.safeway.j4u.emju.offers.model.PaginatedOffer;
import com.safeway.j4u.emju.offers.model.SearchCountCriteria;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.InsertOptions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class OffersSearchService {

  @Autowired
  private OfferDetailsToOfferMapper offerDetailsToOfferMapper;
  @Autowired
  private CassandraTemplate cassandraTemplate;
  @Autowired
  private OfferSearchQueryBuilder offerSearchQueryBuilder;
  @Autowired
  private ObjectMapper objectMapper;
  @Value("${offer.search.query.maxPageSize}")
  private int maxPageSize;
  @Value("${offer.search.cursorCache.row.ttl.ttlInMinutes}")
  private int cursorCacheTtlMinutes;

  public Mono<PaginatedOffer> searchOffers(String search, SearchCountCriteria searchCountCriteria)
      throws Exception {
    return searchPaginatedOffers(
        OfferSearchServiceHelper.getSearchCriteria(search, this.maxPageSize), searchCountCriteria);
  }

  private Mono<PaginatedOffer> searchPaginatedOffers(List<OfferSearchCriteria> searchCriteria,
      SearchCountCriteria searchCountCriteria) throws Exception {

    List<OfferDetails> offerDetails = Lists.newArrayList();
    OfferSearchCursorCache ostc = null;
    Integer requestedPage = null;
    List<OfferSearchCriteria> searchCriteriaFromTokenCache = Lists.newArrayList();
    UUID sId = OfferSearchServiceHelper.getSId(searchCriteria);

    if (Objects.nonNull(sId)) {
      // Get all page pointers if exists from the control table
      ostc = cassandraTemplate.selectOne(offerSearchQueryBuilder.pageTokenStatement(sId),
          OfferSearchCursorCache.class);

      requestedPage = OfferSearchServiceHelper.getPage(searchCriteria);

      if (requestedPage != 1 && Objects.isNull(ostc.getCursorMark().get(requestedPage))) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
            "Cannot be fetched as requested page is beyond cursor mark");
      }

      searchCriteriaFromTokenCache =
          OfferSearchServiceHelper.queryToCriteria(ostc.getSearchQuery());
    }

    List<OfferSearchCriteria> effectivesearchCriteria =
        Objects.nonNull(sId) ? searchCriteriaFromTokenCache : searchCriteria;

    ResultSet resultSet = cassandraTemplate.getCqlOperations()
        .queryForResultSet(offerSearchQueryBuilder.buildAttributesClause(effectivesearchCriteria,
            (Objects.nonNull(ostc) && Objects.nonNull(requestedPage))
                ? ostc.getCursorMark().get(requestedPage)
                : null));

    int remaining = resultSet.getAvailableWithoutFetching();
    for (Row row : resultSet) {
      offerDetails.add(cassandraTemplate.getConverter().read(OfferDetails.class, row));
      if (--remaining == 0) {
        break;
      }
    }

    PaginatedOffer po =
        buildPaginatedOffer(OfferSearchServiceHelper.criteriaToQuery(searchCriteria), sId,
            requestedPage, resultSet, ostc);
    if (!isEmpty(offerDetails)) {
      if (searchCountCriteria.isIncludeFacetCounts()) {
        String facetCounts = cassandraTemplate.selectOne(
            offerSearchQueryBuilder.facetCountStatement(effectivesearchCriteria), String.class);
        po.setFacetCounts(
            nonNull(facetCounts) ? objectMapper.readValue(facetCounts, OfferSearchFacetCount.class)
                : null);
      }
      if (searchCountCriteria.isIncludeTotalCount()) {
        po.setTotalCount(cassandraTemplate.selectOne(
            offerSearchQueryBuilder.totalCountStatement(effectivesearchCriteria), Long.class));
      }
    }

    return Flux.fromIterable(offerDetails).map(od -> offerDetailsToOfferMapper.toOffer(od)).collectList()
        .map(o -> new PaginatedOffer(o, po.getSid(), po.getCurrent(), po.getFacetCounts(),
            po.getTotalCount()));
  }


  private PaginatedOffer buildPaginatedOffer(String searchQuery, UUID sid, Integer page,
      ResultSet outputDBResult, OfferSearchCursorCache ostc) {

    UUID newSid = null;
    String nextPagePointer = outputDBResult.getExecutionInfo().getPagingState() != null
        ? outputDBResult.getExecutionInfo().getPagingState().toString()
        : null;

    if (Objects.nonNull(nextPagePointer)) {
      OfferSearchCursorCache newOstc = new OfferSearchCursorCache();
      if (Objects.nonNull(sid)) {
        newOstc.setSearchId(ostc.getSearchId());
        newOstc.setSearchQuery(ostc.getSearchQuery());
        Map<Integer, String> pageTokenMap = ostc.getCursorMark();
        pageTokenMap.putIfAbsent(page + 1, nextPagePointer);
        newOstc.setCursorMark(pageTokenMap);
      } else {
        newSid = UUIDs.timeBased();
        newOstc.setSearchId(newSid);
        newOstc.setSearchQuery(searchQuery);
        Map<Integer, String> pageTokenMap = new HashMap<Integer, String>();
        pageTokenMap.put(2, nextPagePointer);
        newOstc.setCursorMark(pageTokenMap);
      }
      cassandraTemplate.insert(newOstc,
          InsertOptions.builder().ttl(cursorCacheTtlMinutes * 60).build());
    }

    PaginatedOffer po = new PaginatedOffer();
    page = Objects.nonNull(sid) ? page : 1;
    sid = Objects.nonNull(newSid) ? newSid : sid;
    po.setSid(Objects.nonNull(sid) ? sid.toString() : null);
    po.setCurrent(Objects.nonNull(nextPagePointer) ? page.toString() : null);
    return po;
  }
}

