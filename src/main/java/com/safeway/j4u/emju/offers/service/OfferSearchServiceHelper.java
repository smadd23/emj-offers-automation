package com.safeway.j4u.emju.offers.service;

import com.google.common.collect.Lists;
import com.safeway.j4u.emju.offers.mapper.OfferSearchCriteriaKeyMapper;
import com.safeway.j4u.emju.offers.model.OfferSearchCriteria;
import com.safeway.j4u.emju.offers.util.OffersConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OfferSearchServiceHelper {

  public static List<OfferSearchCriteria> getSearchCriteria(String search, int maxPageSize) {
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

  public static String criteriaToQuery(List<OfferSearchCriteria> srchCriteriaList) {
    StringBuilder searchQuery = new StringBuilder();

    srchCriteriaList.stream().forEach(srchCriteria -> {
      if (!srchCriteria.getKey().equalsIgnoreCase("sid")
          && !srchCriteria.getKey().equalsIgnoreCase("next")) {
        searchQuery.append(srchCriteria.getKey() + "=" + srchCriteria.getValue() + ";");
      }
    });

    return searchQuery.toString();
  }

  public static List<OfferSearchCriteria> queryToCriteria(String searchQuery) {
    List<OfferSearchCriteria> srchCriteriaList = new ArrayList<OfferSearchCriteria>();

    for (String s : Arrays.asList(searchQuery.split(";"))) {
      String[] criterian = s.split("=");
      srchCriteriaList.add(new OfferSearchCriteria(criterian[0], "=", criterian[1]));
    }

    return srchCriteriaList;
  }

  public static Integer getPage(List<OfferSearchCriteria> searchCriteria) {
    for (OfferSearchCriteria s : searchCriteria) {
      if (s.getKey().equalsIgnoreCase("next")) {
        String pageStr = (String) s.getValue();
        return Integer.valueOf(pageStr);
      }
    }

    return null;
  }

  public static UUID getSId(List<OfferSearchCriteria> searchCriteria) {
    for (OfferSearchCriteria s : searchCriteria) {
      if (s.getKey().equalsIgnoreCase("sid")) {
        return UUID.fromString((String) s.getValue());
      }
    }

    return null;
  }

}
