package com.safeway.j4u.emju.offers.endpoint;

import static com.safeway.j4u.emju.offers.util.OffersConstants.API_OFFERS_ROOT;
import static com.safeway.j4u.emju.offers.util.OffersConstants.APPLICATION_VND_SAFEWAY_V1_JSON;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.util.StringUtils.isEmpty;

import com.safeway.j4u.emju.offers.model.PaginatedOffer;
import com.safeway.j4u.emju.offers.model.SearchCountCriteria;
import com.safeway.j4u.emju.offers.service.OffersSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
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
import springfox.documentation.annotations.ApiIgnore;

@Api(description = "Set of endpoints for retrieving Offer based on the search criteria")
@RestController
@RequestMapping(path = API_OFFERS_ROOT, produces=APPLICATION_VND_SAFEWAY_V1_JSON)
public class OfferSearchEndpoint {

  private OffersSearchService offersService;

  @Value("${offer.search.query.maxLength:2000}")
  private int queryLength;

  @Autowired
  public OfferSearchEndpoint(OffersSearchService offersService) {
    this.offersService = offersService;
  }

  @ApiOperation(value = "Retrieves Offers satisfying search criteria and uses only three(3) request query parameters including 'q','includeFacetCounts' and/or 'includeTotalCount' ",
      authorizations = {
          @Authorization(value="offerRead", scopes = {})
      })
  @GetMapping
  public Mono<PaginatedOffer> search(
      @ApiParam(name="q",value = "Sample Queries below:\n"
          + "\tofferStatus=(A OR P)\n"
          + "\texternalOfferId=0520H2915_000123\n"
          + "\tstoreId=300300\n"
          + "\tstoreId=(300300 OR 200200)\n"
          + "\tstoreId=(1461 OR 2000);offerProgramCd=SC\n"
          + "\tstartDt=[2018-09-01T00:00:00Z TO \\*];endDt=[\\* TO 2018-12-31T11:59:59Z];offerProgramCd=SC\n"
          + "\tstoreId=(2000 OR 1461);offerStatus=(A OR P);priceCd=TE\n",
          example = "offerStatus=A")
      @RequestParam(value = "q") String search,

      @ApiParam(name="includeFacetCounts", value = "true", defaultValue = "false")
      @RequestParam(value = "includeFacetCounts", required = false,
          defaultValue = "false") boolean includeFacetCounts,

      @ApiParam(name="includeTotalCount", value = "true", defaultValue = "true")
      @RequestParam(value = "includeTotalCount", required = false,
          defaultValue = "true") boolean includeTotalCount,
      @ApiIgnore ServerHttpRequest serverHttpRequest) throws Exception {
    Set<String> allowed =
        new HashSet<>(Arrays.asList("q", "includeFacetCounts", "includeTotalCount"));
    if (!allowed.containsAll(serverHttpRequest.getQueryParams().keySet())) {
      throw new ResponseStatusException(BAD_REQUEST, "Invalid Request: Unknown params.");
    } else if (isEmpty(search) || search.length() > queryLength) {
      throw new ResponseStatusException(BAD_REQUEST,
          "Invalid Request: Query must not be empty and length must not exceed " + queryLength
              + "characters");
    }

    return offersService.searchOffers(search,
        new SearchCountCriteria(includeFacetCounts, includeTotalCount));
  }
}
