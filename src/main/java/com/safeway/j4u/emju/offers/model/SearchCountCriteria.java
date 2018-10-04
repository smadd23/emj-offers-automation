package com.safeway.j4u.emju.offers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SearchCountCriteria {

  private boolean includeFacetCounts;

  private boolean includeTotalCount;

}
