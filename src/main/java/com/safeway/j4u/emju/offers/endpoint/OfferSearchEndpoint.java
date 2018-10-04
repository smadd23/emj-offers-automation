package com.safeway.j4u.emju.offers.endpoint;

import static com.safeway.j4u.emju.offers.util.OffersConstants.API_OFFERS_ROOT;
import static com.safeway.j4u.emju.offers.util.OffersConstants.APPLICATION_VND_SAFEWAY_V1_JSON;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.util.StringUtils.isEmpty;

import com.safeway.j4u.emju.offers.model.PaginatedOffer;
import com.safeway.j4u.emju.offers.model.SearchCountCriteria;
import com.safeway.j4u.emju.offers.service.OffersSearchService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = API_OFFERS_ROOT, consumes=APPLICATION_VND_SAFEWAY_V1_JSON, produces=APPLICATION_VND_SAFEWAY_V1_JSON)
public class OfferSearchEndpoint {

  private OffersSearchService offersService;

  @Value("${offer.search.query.maxLength:2000}")
  private int queryLength;

  @Autowired
  public OfferSearchEndpoint(OffersSearchService offersService) {
    this.offersService = offersService;
  }

  @GetMapping
  public Mono<PaginatedOffer> search(@RequestParam(value = "q") String search,
      @RequestParam(value = "includeFacetCounts", required = false, defaultValue = "false") boolean includeFacetCounts,
      @RequestParam(value = "includeTotalCount", required = false, defaultValue = "true") boolean includeTotalCount,
      ServerHttpRequest serverHttpRequest) {
    Set<String> allowed = new HashSet<>(Arrays.asList("q", "includeFacetCounts", "includeTotalCount"));
    if (!allowed.containsAll(serverHttpRequest.getQueryParams().keySet())) {
      throw new ResponseStatusException(BAD_REQUEST,"Invalid Request: Unknown params.");
    } else if (isEmpty(search) || search.length() > queryLength) {
      throw new ResponseStatusException(BAD_REQUEST,
          "Invalid Request: Query must not be empty and length must not exceed " + queryLength
              + "characters");
    }

    return offersService.searchOffers(search, new SearchCountCriteria(includeFacetCounts, includeTotalCount));
  }
}