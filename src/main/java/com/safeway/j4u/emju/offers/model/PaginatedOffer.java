package com.safeway.j4u.emju.offers.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Builder
@ToString
public class PaginatedOffer {
  private List<Offer> offers;
  private String sid;
  private String current;

  @JsonInclude(Include.NON_NULL)
  private OfferSearchFacetCount facetCounts;
  @JsonInclude(Include.NON_NULL)
  private Long totalCount;
}
