package com.safeway.j4u.emju.offers.endpoint;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.safeway.j4u.emju.offers.repository.OfferDetailsRepository;
import com.safeway.j4u.emju.offers.helpers.OfferHelper;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.ProgramCodeType;
import com.safeway.j4u.emju.offers.model.StatusType;
import com.safeway.j4u.emju.offers.util.OffersConstants;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "spring.main.web-application-type=reactive" })
@AutoConfigureWebTestClient
@ActiveProfiles("test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OffersSearchEndpointTest {

	@Autowired
	private WebTestClient webClient;

	@Autowired
	private OfferDetailsRepository offerDetailsRepo;

	public void setUp() throws Exception {
		this.webClient.post().uri("/api/offer/")
				.body(BodyInserters.fromObject(OfferHelper.createSCOfferSendByOMSDuringPromoteToEOC(
						"2510N0817H05_827777", 1043L, ProgramCodeType.SC, StatusType.A, "2018-08-01T00:00:01.235-07:00",
						"2018-08-05T00:00:01.235-07:00", "TE", new HashSet<String>() {
							{
								add("94404");
								add("94568");
							}
						}, new HashSet<String>() {
							{
								add("999888");
								add("777666");
								add("555444");
							}
						})))
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectBody();

		this.webClient.post().uri("/api/offer/")
				.body(BodyInserters.fromObject(OfferHelper.createSCOfferSendByOMSDuringPromoteToEOC(
						"2510N0817H05_825555", 1044L, ProgramCodeType.MF, StatusType.P, "2018-09-01T00:00:01.235-07:00",
						"2018-11-01T11:59:59.235-07:00", "AB", new HashSet<String>() {
							{
								add("94086");
								add("63043");
							}
						}, new HashSet<String>() {
							{
								add("100100");
								add("200200");
								add("300300");
							}
						})))
				.header(HttpHeaders.CONTENT_TYPE, OffersConstants.APPLICATION_JSON).exchange().expectBody();

		Thread.currentThread().sleep(10000L);

		this.offerDetailsRepo.findById(1043L).log().block();
		this.offerDetailsRepo.findById(1044L).log().block();

	}

	@Test
	public void testSearchOffersByExternalOfferId() throws Exception {
		setUp();

		assertTrue(this.webClient.get().uri("/api/offer?q=externalOfferId=2510N0817H05_825555")
				.accept(MediaType.APPLICATION_JSON_UTF8).exchange().returnResult(Offer.class).getResponseBody()
				.collectList().flatMap(offers -> {
					if ((offers.get(0).getInfo().getId().getOfferId() == 1044L)
							&& (offers.get(0).getInfo().getOfferProgramCode().equals(ProgramCodeType.MF))
							&& (offers.get(0).getInfo().getOfferStatus().equals(StatusType.P))) {
						return Mono.just(true);
					} else {
						return Mono.just(false);
					}
				}).block().booleanValue());
	}

	@Test
	public void testSearchOffersByOfferId() {
		assertTrue(this.webClient.get().uri("/api/offer?q=offerId=1043").accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange().returnResult(Offer.class).getResponseBody().collectList().flatMap(offers -> {
					if ((offers.get(0).getInfo().getId().getExternalOfferId()
							.equalsIgnoreCase("2510N0817H05_827777"))) {
						return Mono.just(true);
					} else {
						return Mono.just(false);
					}
				}).block().booleanValue());
	}

	@Test
	public void testSearchOffersByOfferStatusActive() {
		assertTrue(this.webClient.get().uri("/api/offer?q=offerStatus=A").accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange().returnResult(Offer.class).getResponseBody().collectList().flatMap(offers -> {
					if ((offers.get(0).getInfo().getId().getOfferId() != null)
							&& (offers.get(0).getInfo().getOfferProgramCode().equals(ProgramCodeType.SC))) {
						return Mono.just(true);
					} else {
						return Mono.just(false);
					}
				}).block().booleanValue());
	}

	@Test
	public void testSearchOffersByOfferStatusActiveOrPreview() {
		assertTrue(this.webClient.get().uri("/api/offer?q=offerStatus=(A OR P)").accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange().returnResult(Offer.class).getResponseBody().collectList().flatMap(offers -> {
					if ((offers.get(0).getInfo().getId().getOfferId() != null)
							&& (offers.get(0).getInfo().getOfferProgramCode().equals(ProgramCodeType.SC))) {
						return Mono.just(true);
					} else {
						return Mono.just(false);
					}
				}).block().booleanValue());
	}

	@Test
	public void testSearchOffersByOfferType() {

		assertTrue(this.webClient.get().uri("/api/offer?q=offerProgramCd=SC").accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange().returnResult(Offer.class).getResponseBody().collectList().flatMap(offers -> {
					if ((offers.get(0).getInfo().getId().getOfferId() != null)
							&& (offers.get(0).getInfo().getOfferStatus().equals(StatusType.A))) {
						return Mono.just(true);
					} else {
						return Mono.just(false);
					}
				}).block().booleanValue());
	}

	@Test
	public void testSearchOffersByPriceCode() {
		assertTrue(this.webClient.get().uri("/api/offer?q=priceCd=10;postalCd=94086")
				.accept(MediaType.APPLICATION_JSON_UTF8).exchange().returnResult(Offer.class).getResponseBody()
				.collectList().flatMap(offers -> {
					if ((offers.get(0).getInfo().getId().getOfferId() == 1044L)
							&& (offers.get(0).getInfo().getOfferStatus().equals(StatusType.P))) {
						return Mono.just(true);
					} else {
						return Mono.just(false);
					}
				}).block().booleanValue());
	}

	@Test
	public void testSearchOffersByPostalCd() {
		assertTrue(this.webClient.get().uri("/api/offer?q=postalCd=63043").accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange().returnResult(Offer.class).getResponseBody().collectList().flatMap(offers -> {
					if ((offers.get(0).getInfo().getId().getOfferId() == 1044L)
							&& (offers.get(0).getInfo().getOfferStatus().equals(StatusType.P))) {
						return Mono.just(true);
					} else {
						return Mono.just(false);
					}
				}).block().booleanValue());
	}

	@Test
	public void testSearchOffersByStartDtEndDt() {
		assertTrue(this.webClient.get()
				.uri("/api/offer?q=startDt=[2018-07-31T00:00:00Z TO *];endDt=[* TO 2018-08-07T09:00:00Z]")
				.accept(MediaType.APPLICATION_JSON_UTF8).exchange().returnResult(Offer.class).getResponseBody()
				.collectList().flatMap(offers -> {
					if ((offers.get(0).getInfo().getId().getOfferId() == 1043L)
							&& (offers.get(0).getInfo().getOfferStatus().equals(StatusType.A))) {
						return Mono.just(true);
					} else {
						return Mono.just(false);
					}
				}).block().booleanValue());
	}

	@Test
	public void testSearchOffersByStore() throws Exception {
		assertTrue(this.webClient.get().uri("/api/offer?q=storeId=200200;postalCd=63043")
				.accept(MediaType.APPLICATION_JSON_UTF8).exchange().returnResult(Offer.class).getResponseBody()
				.collectList().flatMap(offers -> {
					if ((offers.get(0).getInfo().getId().getOfferId() == 1044L)
							&& (offers.get(0).getInfo().getOfferStatus().equals(StatusType.P))) {
						return Mono.just(true);
					} else {
						return Mono.just(false);
					}
				}).block().booleanValue());

		tearDown();
	}

	public void tearDown() throws Exception {
		// tear down the test data
		this.offerDetailsRepo.deleteById(1043L).log().subscribe();
		this.offerDetailsRepo.deleteById(1044L).log().subscribe();
	}

}