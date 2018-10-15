package com.safeway.j4u.emju.offers.endpoint;

import static com.safeway.j4u.emju.offers.util.OffersConstants.API_OFFERS_ROOT;
import static com.safeway.j4u.emju.offers.util.OffersConstants.APPLICATION_VND_SAFEWAY_V1_JSON;

import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.StatusType;
import com.safeway.j4u.emju.offers.service.OfferIngestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import java.util.Map;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

@Api(description = "Set of endpoints for creating, updating Offer and Offer Status")
@RestController
@RequestMapping(path = API_OFFERS_ROOT, consumes=APPLICATION_VND_SAFEWAY_V1_JSON, produces = APPLICATION_VND_SAFEWAY_V1_JSON)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OfferIngestionEndpoint {

	private final OfferIngestionService offerInjestionService;

	@ApiOperation(value = "Creates a new Offer", authorizations = {
			@Authorization(value="offerWrite", scopes = {})
	})

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Disposable> createOffer(@Valid @RequestBody Offer offer) {
		return offerInjestionService.save(offer);
	}

	@ApiOperation(value = "Updates a new Offer")
	@PutMapping
	public Mono<Disposable> updateOffer(@Valid @RequestBody Offer offer) {
		return offerInjestionService.save(offer);
	}

	@ApiOperation(value = "Updates status for given Offers")
	@PutMapping(path = "/status")
	public Mono<Map<String, String>> updateOfferStatus(
			@ApiParam(name = "externalOfferIds", value = "Set of sample external ids ['0520H2915_000123','2520B2546_000155']")
			@Size(min=1) @RequestBody Set<String> externalOfferIds,
			@ApiParam(value = "Offer Status", allowableValues = "A, D, E, L, O, P") @NotEmpty @RequestParam(required = true, name = "value") String status) {
		return offerInjestionService.updateStatus(StatusType.valueOf(status), externalOfferIds);
	}
}
