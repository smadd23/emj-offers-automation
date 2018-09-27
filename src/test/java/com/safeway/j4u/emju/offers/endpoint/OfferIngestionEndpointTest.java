package com.safeway.j4u.emju.offers.endpoint;

import static org.junit.Assert.assertTrue;

import java.time.ZonedDateTime;
import java.util.Collections;

import org.assertj.core.util.Arrays;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.safeway.j4u.emju.offers.helpers.OfferHelper;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.StatusType;
import com.safeway.j4u.emju.offers.util.OffersConstants;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.main.web-application-type=reactive"})
@AutoConfigureWebTestClient
@ActiveProfiles("test")
public class OfferIngestionEndpointTest {
	
	@Autowired
	private WebTestClient webClient;
	
	@Test
	public void offerCreateWithValidSCOfferDataIsSavedSuccessfully() {
		this.webClient.post().uri("/api/offer/")
				.body(BodyInserters
						.fromObject(OfferHelper.createSCOfferSendByOMSDuringPromoteToEOC("2510N0817H05_820001", null)))
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectBody();
		this.webClient.post().uri("/api/offer/")
				.body(BodyInserters
						.fromObject(OfferHelper.createSCOfferSendByOMSDuringPromoteToEOC("2510N0817H05_820002", null)))
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectBody();
		this.webClient.put().uri("/api/offer/")
				.body(BodyInserters
						.fromObject(OfferHelper.createSCOfferSendByOMSDuringPromoteToEOC("2510N0817H05_820003", null)))
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectBody();
		this.webClient.put().uri("/api/offer/")
				.body(BodyInserters
						.fromObject(OfferHelper.createSCOfferSendByOMSDuringPromoteToEOC("2510N0817H05_820004", null)))
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectStatus().isOk();
		
	}

	@Test
	public void offerCreateAndUpdateWithValidSCOfferDataIsSavedSuccessfully() {
		this.webClient.put().uri("/api/offer/")
				.body(BodyInserters.fromObject(
						OfferHelper.createSCOfferSendByOMSDuringPromoteToPreview("2510N0817H05_820001", null)))
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectBody();

		assertTrue(this.webClient.get().uri("/api/offer?q=externalOfferId=2510N0817H05_820001")
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().returnResult(Offer.class)
				.getResponseBody().collectList().flatMap(offers -> {
					if ((offers.get(0)
							.getInfo().getId().getExternalOfferId().equalsIgnoreCase("2510N0817H05_820001"))) {
						return Mono.just(true);
					} else {
						return Mono.just(false);
					}
				}).block().booleanValue());
	}
	
	@Test
	public void offerCreateWithOfferIdFromExternalSystems() {
		this.webClient.put().uri("/api/offer/")
				.body(BodyInserters.fromObject(
						OfferHelper.createSCOfferSendByOMSDuringPromoteToPreview("2510N0817H05_820005", 12345L)))
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectBody();

		assertTrue(this.webClient.get().uri("/api/offer?q=externalOfferId=2510N0817H05_820005")
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().returnResult(Offer.class)
				.getResponseBody().collectList().flatMap(offers -> {
					if ((offers.get(0).getInfo().getId().getOfferId().equals(12345L))) {
						return Mono.just(true);
					} else {
						return Mono.just(false);
					}
				}).block().booleanValue());
	}
	
	@Test
	public void updateOfferStatusToActive() {
		this.webClient.put().uri("/api/offer")
				.body(BodyInserters.fromObject(
						OfferHelper.createSCOfferSendByOMSDuringPromoteToPreview("2510N0817H05_820002", null)))
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectBody();

		String[] offerIds = new String[] { "2510N0817H05_820002" };
		this.webClient.put().uri("/api/offer/status?value=" + StatusType.A.name())
				.body(BodyInserters.fromObject(Arrays.asList(offerIds)))
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectBody();

		assertTrue(this.webClient.get().uri("/api/offer?q=externalOfferId=2510N0817H05_820002")
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange()
				.returnResult(Offer.class)
				.getResponseBody().collectList().flatMap(offers -> {
					return Mono.just(offers.get(0).getInfo().getOfferStatus().equals(StatusType.A));
				}).block());
	}

	@Test
	public void updateOfferStatusToDeactiveAndVerifyDisplayEndDate() {
		String[] offerIds = new String[] { "2510N0817H05_820003" };
		this.webClient.put().uri("/api/offer/status?value=" + StatusType.D.name())
				.body(BodyInserters.fromObject(Arrays.asList(offerIds)))
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectBody();

		// Give 2s, Make sure save is completed as Mono/Flux are lazy
		try {
			Thread.currentThread().sleep(2000L);
		} catch (InterruptedException e) {
			//ignore
		}

		assertTrue(this.webClient.get().uri("/api/offer?q=externalOfferId=2510N0817H05_820003")
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().returnResult(Offer.class)
				.getResponseBody().collectList().flatMap(offers -> {
					if ((offers.get(0).getInfo().getOfferStatus().equals(StatusType.D))
							&& (offers.get(0).getRules().getEndDate().getDisplayEffectiveEndDate().toLocalDate()
									.compareTo(ZonedDateTime.now().toLocalDate()) == 0)) {
						return Mono.just(true);
					} else {
						return Mono.just(false);
					}
				}).block().booleanValue());
	}

	@Test
	public void updateOfferStatusToExpireAndVerifyOfferAndDisplayEndDate() {
		String[] offerIds = new String[] { "2510N0817H05_820004" };
		this.webClient.put().uri("/api/offer/status?value=" + StatusType.E.name())
				.body(BodyInserters.fromObject(Arrays.asList(offerIds)))
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectStatus().isOk();

		// Give 2s, Make sure save is completed as Mono/Flux are lazy
		try {
			Thread.currentThread().sleep(2000L);
		} catch (InterruptedException e) {
			//ignore
		}

		assertTrue(this.webClient.get().uri("/api/offer?q=externalOfferId=2510N0817H05_820004")
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().returnResult(Offer.class)
				.getResponseBody().collectList().flatMap(offers -> {
					if ((offers.get(0).getInfo().getOfferStatus().equals(StatusType.E))
							&& (offers.get(0).getRules().getEndDate().getDisplayEffectiveEndDate().toLocalDate()
									.compareTo(ZonedDateTime.now().toLocalDate()) == 0)
							&& (offers.get(0).getRules().getEndDate().getOfferEffectiveEndDate().toLocalDate()
									.compareTo(ZonedDateTime.now().toLocalDate()) == 0)) {
						return Mono.just(true);
					} else {
						return Mono.just(false);
					}
				}).block().booleanValue());
	}
	
	@Test
	public void offerStatusUpdateWithInvalidStatusThrowsInternalServerError() {
		Long[] offerIds = new Long[] {575L};
		this.webClient.put().uri("/api/offer/status?value=TEST")
		.body(BodyInserters.fromObject(Arrays.asList(offerIds)))
		.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectStatus()
		.is5xxServerError();
	}

	@Test
	public void offerStatusUpdateWithoutRequestParam() {
		Long[] offerIds = new Long[] {575L};
		this.webClient.put().uri("/api/offer/status")
		.body(BodyInserters.fromObject(Arrays.asList(offerIds)))
		.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectStatus()
		.is5xxServerError();
	}
	
	@Test
	public void offerStatusUpdateWithOfferIdListMoreThanConfiguredThrowsReturnsBadRequest() {
		Long[] offerIds = new Long[] {575L,576L};
		this.webClient.put().uri("/api/offer/status?value=" + StatusType.A)
		.body(BodyInserters.fromObject(Arrays.asList(offerIds)))
		.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectStatus()
		.isBadRequest();
	}
	
	@Test
	public void offerStatusUpdateWithEmptyOfferListThrowsReturnsBadRequest() {
		this.webClient.put().uri("/api/offer/status?value=" + StatusType.A)
		.body(BodyInserters.fromObject(Collections.emptyList()))
		.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectStatus()
		.isBadRequest();
	}

	//TODO: Should we return not found offers back to client when status update???
	@Test
	public void offerStatusUpdateWithInvalidExternalOfferId() {
		String[] offerIds = new String[] { "2510N0817H05_820999" };
		this.webClient.put().uri("/api/offer/status?value=" + StatusType.A)
				.body(BodyInserters.fromObject(Arrays.asList(offerIds)))
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange()
				.expectStatus().isOk();
	}

}
