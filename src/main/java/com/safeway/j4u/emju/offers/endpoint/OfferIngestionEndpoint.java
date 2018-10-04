package com.safeway.j4u.emju.offers.endpoint;

import static com.safeway.j4u.emju.offers.util.OffersConstants.API_OFFERS_ROOT;
import static com.safeway.j4u.emju.offers.util.OffersConstants.APPLICATION_VND_SAFEWAY_V1_JSON;

import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.StatusType;
import com.safeway.j4u.emju.offers.service.OfferIngestionService;
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

@RestController
@RequestMapping(path = API_OFFERS_ROOT, consumes=APPLICATION_VND_SAFEWAY_V1_JSON, produces = APPLICATION_VND_SAFEWAY_V1_JSON)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OfferIngestionEndpoint {

	private final OfferIngestionService offerInjestionService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Disposable> createOffer(@Valid @RequestBody Offer offer) {
		return offerInjestionService.save(offer);
	}

	@PutMapping
	public Mono<Disposable> updateOffer(@Valid @RequestBody Offer offer) {
		return offerInjestionService.save(offer);
	}

	@PutMapping(path = "/status")
	public Mono<Map<String, String>> updateOfferStatus(@Size(min=1) @RequestBody Set<String> externalOfferIds,
			@NotEmpty @RequestParam(required = true, name = "value") String status) {
		return offerInjestionService.updateStatus(StatusType.valueOf(status), externalOfferIds);
	}
}
