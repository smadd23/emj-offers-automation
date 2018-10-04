package com.safeway.j4u.emju.offers.service;

import static java.util.Objects.nonNull;
import static org.springframework.util.CollectionUtils.isEmpty;

import com.datastax.driver.core.utils.UUIDs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.InsertOptions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.entity.OfferSearchCursorCache;
import com.safeway.j4u.emju.offers.mapper.OfferDetailsMapper;
import com.safeway.j4u.emju.offers.mapper.OfferSearchCriteriaKeyMapper;
import com.safeway.j4u.emju.offers.model.OfferSearchCriteria;
import com.safeway.j4u.emju.offers.model.OfferSearchFacetCount;
import com.safeway.j4u.emju.offers.model.PaginatedOffer;
import com.safeway.j4u.emju.offers.model.SearchCountCriteria;
import com.safeway.j4u.emju.offers.util.OfferIdGenerator;
import com.safeway.j4u.emju.offers.util.OffersConstants;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class OffersSearchService {

  @Autowired
  private OfferDetailsMapper offerDetailsMapper;
  @Autowired
  private CassandraTemplate cassandraTemplate;
  @Autowired
  private OfferSearchQueryBuilder offerSearchQueryBuilder;
  @Autowired
  private OfferIdGenerator offerIdGenerator;
  @Autowired
  private ObjectMapper objectMapper;
  @Value("${offer.search.query.maxPageSize}")
  private int maxPageSize;
  @Value("${offer.search.cursorCache.row.ttl.ttlInMinutes}")
  private int cursorCacheTtlMinutes;

  public Mono<PaginatedOffer> searchOffers(String search, SearchCountCriteria searchCountCriteria) {
    try {
      return getPaginatedOffer(getSearchCriteria(search), searchCountCriteria);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
    }
  }

  private List<OfferSearchCriteria> getSearchCriteria(String search) {
    List<OfferSearchCriteria> searchCriteria = Lists.newArrayList();
    if (search != null) {
      try {
        Pattern pattern = Pattern.compile(OffersConstants.URL_PATTERN);
        Matcher matcher = pattern.matcher(search + ";");
        boolean criteriaFound = false;

        while (matcher.find()) {
          searchCriteria.add(new OfferSearchCriteria(
              OfferSearchCriteriaKeyMapper.valueOf(matcher.group(1)).getColumn(matcher.group(3)),
              matcher.group(2), OfferSearchCriteriaKeyMapper.valueOf(matcher.group(1))
                  .getDynamicColumnValue(matcher.group(3))));
          criteriaFound = true;
        }

        if (criteriaFound == false) {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
        } else {
          searchCriteria.stream().forEach(srchCriteria -> {
            if (srchCriteria.getKey().equalsIgnoreCase("limit")) {
              if (Integer.parseInt((String) srchCriteria.getValue()) > maxPageSize) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Requested page size exceeded limit");
              }
            }
          });
        }
      } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
      }
    }
    return searchCriteria;
  }

  private Mono<PaginatedOffer> getPaginatedOffer(List<OfferSearchCriteria> searchCriteria,
      SearchCountCriteria searchCountCriteria) throws Exception {

    List<OfferDetails> offerDetails = Lists.newArrayList();
    OfferSearchCursorCache ostc = null;
    Integer requestedPage = null;
    List<OfferSearchCriteria> searchCriteriaFromTokenCache = new ArrayList<OfferSearchCriteria>();
    UUID sId = getSId(searchCriteria);

    if (Objects.nonNull(sId)) {
      // Get all page pointers if exists from the control table
      ostc = cassandraTemplate.selectOne(offerSearchQueryBuilder.pageTokenStatement(sId),
          OfferSearchCursorCache.class);

      requestedPage = getPage(searchCriteria);

      if (requestedPage != 1 && Objects.isNull(ostc.getCursorMark().get(requestedPage))) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
            "Cannot be fetched as requested page is beyond cursor mark");
      }

      searchCriteriaFromTokenCache = queryToCriteria(ostc.getSearchQuery());
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

    PaginatedOffer po = buildPaginatedOffer(searchCriteria, resultSet, ostc);
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

    return Flux.fromIterable(offerDetails).map(od -> offerDetailsMapper.toOffer(od)).collectList()
        .map(o -> new PaginatedOffer(o, po.getSid(), po.getCurrent(), po.getFacetCounts(),
            po.getTotalCount()));
  }


  private PaginatedOffer buildPaginatedOffer(List<OfferSearchCriteria> searchCriteria,
      ResultSet outputDBResult, OfferSearchCursorCache ostc) {

    UUID sid = getSId(searchCriteria);
    UUID newSid = null;
    Integer page = getPage(searchCriteria);
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
        newOstc.setSearchQuery(criteriaToQuery(searchCriteria));
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
    po.setCurrent(nextPagePointer != null ? page.toString() : null);
    return po;
  }

  private String criteriaToQuery(List<OfferSearchCriteria> srchCriteriaList) {
    StringBuilder searchQuery = new StringBuilder();

    srchCriteriaList.stream().forEach(srchCriteria -> {
      if (!srchCriteria.getKey().equalsIgnoreCase("sid")
          && !srchCriteria.getKey().equalsIgnoreCase("next")) {
        searchQuery.append(srchCriteria.getKey() + "=" + srchCriteria.getValue() + ";");
      }
    });

    return searchQuery.toString();
  }

  private List<OfferSearchCriteria> queryToCriteria(String searchQuery) {
    List<OfferSearchCriteria> srchCriteriaList = new ArrayList<OfferSearchCriteria>();

    for (String s : Arrays.asList(searchQuery.split(";"))) {
      String[] criterian = s.split("=");
      srchCriteriaList.add(new OfferSearchCriteria(criterian[0], "=", criterian[1]));
    }

    return srchCriteriaList;
  }

  private Integer getPage(List<OfferSearchCriteria> searchCriteria) {
    for (OfferSearchCriteria s : searchCriteria) {
      if (s.getKey().equalsIgnoreCase("next")) {
        String pageStr = (String) s.getValue();
        return Integer.valueOf(pageStr);
      }
    }

    return null;
  }

  private UUID getSId(List<OfferSearchCriteria> searchCriteria) {
    for (OfferSearchCriteria s : searchCriteria) {
      if (s.getKey().equalsIgnoreCase("sid")) {
        return UUID.fromString((String) s.getValue());
      }
    }

    return null;
  }
}

