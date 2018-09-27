package com.safeway.j4u.emju.offers.endpoint;

import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.StatusType;
import com.safeway.j4u.emju.offers.service.OfferIngestionService;
import java.util.Set;
import javax.validation.Valid;
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
@RequestMapping(path = "/api/offer")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OfferIngestionEndpoint {

	private final OfferIngestionService offerInjestionService;

	@PostMapping(path = "/")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Disposable> createOffer(@Valid @RequestBody Offer offer) {
		return offerInjestionService.save(offer);
	}

	@PutMapping(path = "/")
	public Mono<Disposable> updateOffer(@Valid @RequestBody Offer offer) {
		return offerInjestionService.save(offer);
	}

	@PutMapping(path = "/status")
	public Mono<Boolean> updateOfferStatus(@Valid @RequestBody Set<String> externalOfferIds,
			@RequestParam(required = true, name = "value") String status) {
		return offerInjestionService.updateStatus(StatusType.valueOf(status), externalOfferIds);
	}
}
