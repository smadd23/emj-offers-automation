package com.safeway.j4u.emju.offers.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class OfferSearchFacetCount {

  @JsonAlias("offer_program_cd")
  private Map<String, Integer> offerProgramCode;

  @JsonAlias("categories_set")
  private Map<String, Integer> categories;

  @JsonAlias("events_set")
  private Map<String, Integer> events;
}
