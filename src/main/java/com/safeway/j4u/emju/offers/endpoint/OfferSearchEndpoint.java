package com.safeway.j4u.emju.offers.endpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.safeway.j4u.emju.offers.mapper.OfferSearchCriteriaKeyMapper;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.OfferSearchCriteria;
import com.safeway.j4u.emju.offers.service.OffersSearchService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/offer")
public class OfferSearchEndpoint {

	private OffersSearchService offersService;

	@Autowired
	public OfferSearchEndpoint(OffersSearchService offersService) {
		this.offersService = offersService;
	}

	@GetMapping(path = "", produces = "application/json;charset=UTF-8")
	public Flux<Offer> search(@RequestParam(value = "q") String search) {

		return offersService.searchOffers(search);
	}

}