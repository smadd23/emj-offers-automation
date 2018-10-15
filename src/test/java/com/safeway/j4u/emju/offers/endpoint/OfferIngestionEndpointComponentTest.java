package com.safeway.j4u.emju.offers.endpoint;

import static com.safeway.j4u.emju.offers.testdata.TestUtil.nonReactiveInserts;
import static com.safeway.j4u.emju.offers.util.OffersConstants.API_OFFERS_ROOT;
import static com.safeway.j4u.emju.offers.util.OffersConstants.APPLICATION_VND_SAFEWAY_V1_JSON;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.safeway.j4u.emju.offers.OffersApplication;
import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.helpers.OfferHelper;
import com.safeway.j4u.emju.offers.mapper.OfferToOfferDetailsMapper;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.PaginatedOffer;
import com.safeway.j4u.emju.offers.model.StatusType;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OffersApplication.class,
    properties = {"spring.main.web-application-type=reactive"},
    webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles("test")
public class OfferIngestionEndpointComponentTest {

  @Autowired
  private WebTestClient webClient;

  @LocalServerPort
  private int randomPort;

  @Autowired
  private CassandraTemplate cassandraTemplate;

  @Value("${spring.data.cassandra.keyspace-name}")
  private String cassandraKeyspace;

  @Autowired
  private OfferToOfferDetailsMapper offerDetailsMapper;

  @Test
  public void offerCreateWithValidSCOfferDataIsSavedSuccessfully() {

    StepVerifier.create(WebClient.create("http://localhost:" + randomPort).post()
        .uri(API_OFFERS_ROOT).contentType(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .body(BodyInserters.fromObject(
            OfferHelper.createSCOfferSendByOMSDuringPromoteToEOC("2510N0817H05_82000W", null)))
        .retrieve().bodyToMono(Object.class))
        .thenAwait(Duration.ofMillis(100L)).consumeNextWith(o -> {
          assertThat(o, is(notNullValue()));
        }).verifyComplete();

    StepVerifier.create(WebClient.create("http://localhost:" + randomPort).post()
        .uri(API_OFFERS_ROOT).contentType(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .body(BodyInserters.fromObject(
            OfferHelper.createSCOfferSendByOMSDuringPromoteToEOC("2510N0817H05_82000X", null)))
        .retrieve().bodyToMono(Object.class))
        .thenAwait(Duration.ofMillis(100L)).consumeNextWith(o -> {
          assertThat(o, is(notNullValue()));
        }).verifyComplete();

    StepVerifier.create(WebClient.create("http://localhost:" + randomPort).post()
        .uri(API_OFFERS_ROOT).contentType(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .body(BodyInserters.fromObject(
            OfferHelper.createSCOfferSendByOMSDuringPromoteToEOC("2510N0817H05_820003Y", null)))
        .retrieve().bodyToMono(Object.class))
        .thenAwait(Duration.ofMillis(100L)).consumeNextWith(o -> {
          assertThat(o, is(notNullValue()));
        }).verifyComplete();

    StepVerifier.create(WebClient.create("http://localhost:" + randomPort).post()
        .uri(API_OFFERS_ROOT).contentType(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .body(BodyInserters.fromObject(
            OfferHelper.createSCOfferSendByOMSDuringPromoteToEOC("2510N0817H05_820004Z", null)))
        .retrieve().bodyToMono(Object.class))
        .thenAwait(Duration.ofMillis(100L)).consumeNextWith(o -> {
          assertThat(o, is(notNullValue()));
        }).verifyComplete();

  }

  @Test
  public void offerCreateAndUpdateWithValidSCOfferDataIsSavedSuccessfully() {
    String[] externalOfferIds = new String[] {"2510N0817H05_820001"};
    Long[] offerIds = new Long[] {10L};
    ZonedDateTime now = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC"));
    nonReactiveInserts(cassandraTemplate, cassandraKeyspace,
        Lists.newArrayList(OfferDetails.builder().offerId(offerIds[0])
            .externalOfferId(externalOfferIds[0]).displayEffectiveEndDate(now)
            .offerEffectiveEndDate(now).offerStatus(StatusType.E.name()).build()).toArray());

    StepVerifier
        .create(WebClient.create("http://localhost:" + randomPort).put().uri(API_OFFERS_ROOT)
            .contentType(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .body(BodyInserters.fromObject(OfferHelper.createSCOfferSendByOMSDuringPromoteToPreview(
                externalOfferIds[0], null, StatusType.A)))
            .retrieve().bodyToMono(Object.class))
        .thenAwait(Duration.ofMillis(1000L)).consumeNextWith(o -> {
          assertThat(o, is(notNullValue()));
        }).verifyComplete();

    StepVerifier.create(
        this.webClient.get().uri(API_OFFERS_ROOT + "?q=externalOfferId=" + externalOfferIds[0])
            .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
            .returnResult(PaginatedOffer.class).getResponseBody())
        .consumeNextWith(o -> {
          assertThat(o.getOffers().get(0).getInfo().getId().getExternalOfferId(),
              is(equalTo(externalOfferIds[0])));
        }).verifyComplete();
  }

  //@Test
  public void offerCreateWithOfferIdFromExternalSystems() {

    String[] externalOfferIds = new String[] {"2510N0817H05_820005"};

    StepVerifier
        .create(WebClient.create("http://localhost:" + randomPort).put().uri(API_OFFERS_ROOT)
            .contentType(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .body(BodyInserters.fromObject(OfferHelper.createSCOfferSendByOMSDuringPromoteToPreview(
                externalOfferIds[0], 12345L, StatusType.A)))
            .retrieve().bodyToMono(Object.class))
        .consumeNextWith(o -> {
          assertThat(o, is(notNullValue()));
        }).verifyComplete();

    StepVerifier.create(
        this.webClient.get().uri(API_OFFERS_ROOT + "?q=externalOfferId=" + externalOfferIds[0])
            .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
            .returnResult(PaginatedOffer.class).getResponseBody())
        .consumeNextWith(o -> {
          assertThat(o.getOffers().get(0).getInfo().getId().getOfferId(), is(equalTo(12345L)));
        }).verifyComplete();
  }

  //@Test(timeout = 10000)
  public void updateOfferStatusToActive() {
    String[] externalOfferIds = new String[] {"2510N0817H05_820002"};
    Long[] offerIds = new Long[] {1L};
    ZonedDateTime now = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC"));

    nonReactiveInserts(cassandraTemplate, cassandraKeyspace, Lists
        .newArrayList(stubOfferDetails(externalOfferIds, offerIds, now, StatusType.E)).toArray());

    StepVerifier
        .create(WebClient.create("http://localhost:" + randomPort).put()
            .uri(API_OFFERS_ROOT + "/status?value=" + StatusType.A.name())
            .contentType(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .body(BodyInserters.fromObject(Arrays.asList(externalOfferIds))).retrieve()
            .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {}))
        .expectSubscription().consumeNextWith(a -> assertThat(a.size(), is(equalTo(0))))
        .thenAwait(Duration.ofMillis(2000L)).verifyComplete();

    StepVerifier
        .create(WebClient.create("http://localhost:" + randomPort).get()
            .uri(API_OFFERS_ROOT + "?q=externalOfferId=" + externalOfferIds[0])
            .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).retrieve()
            .bodyToMono(PaginatedOffer.class).flux().collectList())
        .expectSubscription()
        .consumeNextWith(
            offers -> assertThat(offers.get(0).getOffers().get(0).getInfo().getOfferStatus(),
                is(equalTo(StatusType.A))))
        .verifyComplete();
  }

  @Test
  public void updateOfferStatusToDeactiveAndVerifyDisplayEndDate() {
    String[] externalOfferIds = new String[] {"2510N0817H05_820003"};
    Long[] offerIds = new Long[] {2L};
    ZonedDateTime now = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC"));
    nonReactiveInserts(cassandraTemplate, cassandraKeyspace, Lists
        .newArrayList(stubOfferDetails(externalOfferIds, offerIds, now, StatusType.A)).toArray());

    StepVerifier
        .create(WebClient.create("http://localhost:" + randomPort).put()
            .uri(API_OFFERS_ROOT + "/status?value=" + StatusType.D.name())
            .contentType(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .body(BodyInserters.fromObject(Arrays.asList(externalOfferIds))).retrieve()
            .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {}))
        .expectSubscription().consumeNextWith(a -> assertThat(a.size(), is(equalTo(0))))
        .thenAwait(Duration.ofMillis(1000L)).verifyComplete();

    StepVerifier
        .create(WebClient.create("http://localhost:" + randomPort).get()
            .uri(API_OFFERS_ROOT + "?q=externalOfferId=" + externalOfferIds[0])
            .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).retrieve()
            .bodyToMono(PaginatedOffer.class).flux().collectList())
        .expectSubscription().consumeNextWith(offers -> {
          assertThat(offers.get(0).getOffers().get(0).getInfo().getOfferStatus(),
              is(equalTo(StatusType.D)));
          assertThat(offers.get(0).getOffers().get(0).getRules().getEndDate()
              .getDisplayEffectiveEndDate().toInstant().toEpochMilli(),
              is(not(equalTo(now.toInstant().toEpochMilli()))));
        }).verifyComplete();
  }

  @Test
  public void updateOfferStatusToExpireAndVerifyOfferEffectiveEndDateAndDisplayEffectiveDate() {
    ZonedDateTime now = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC"));
    String[] externalOfferIds = new String[] {"2510N0817H05_820004"};
    Long[] offerIds = new Long[] {3L};
    nonReactiveInserts(cassandraTemplate, cassandraKeyspace, Lists
        .newArrayList(stubOfferDetails(externalOfferIds, offerIds, now, StatusType.A)).toArray());

    StepVerifier
        .create(WebClient.create("http://localhost:" + randomPort).put()
            .uri(API_OFFERS_ROOT + "/status?value=" + StatusType.E.name())
            .contentType(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .body(BodyInserters.fromObject(Arrays.asList(externalOfferIds))).retrieve()
            .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {}))
        .expectSubscription().consumeNextWith(a -> assertThat(a.size(), is(equalTo(0))))
        .thenAwait(Duration.ofMillis(1000L)).verifyComplete();

    StepVerifier
        .create(WebClient.create("http://localhost:" + randomPort).get()
            .uri(API_OFFERS_ROOT + "?q=externalOfferId=" + externalOfferIds[0])
            .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).retrieve()
            .bodyToMono(PaginatedOffer.class).flux().collectList())
        .expectSubscription().consumeNextWith(offers -> {
          assertThat(offers.get(0).getOffers().get(0).getInfo().getOfferStatus(),
              is(equalTo(StatusType.E)));
          assertThat(offers.get(0).getOffers().get(0).getRules().getEndDate()
              .getDisplayEffectiveEndDate().toInstant().toEpochMilli(),
              is(not(equalTo(now.toInstant().toEpochMilli()))));
          assertThat(offers.get(0).getOffers().get(0).getRules().getEndDate()
              .getOfferEffectiveEndDate().toInstant().toEpochMilli(),
              is(not(equalTo(now.toInstant().toEpochMilli()))));
        }).verifyComplete();
  }

  @Test
  public void offerStatusUpdateWithInvalidStatusThrowsInternalServerError() {
    Long[] offerIds = new Long[] {575L};
    this.webClient.put().uri(API_OFFERS_ROOT + "/status?value=TEST")
        .body(BodyInserters.fromObject(Arrays.asList(offerIds)))
        .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange().expectStatus()
        .is5xxServerError();
  }

  @Test
  public void offerStatusUpdateWithoutRequestParam() {
    Long[] offerIds = new Long[] {575L};
    this.webClient.put().uri(API_OFFERS_ROOT + "/status")
        .body(BodyInserters.fromObject(Arrays.asList(offerIds)))
        .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange().expectStatus()
        .is5xxServerError();
  }

  @Test
  public void offerStatusUpdateWithOfferIdListMoreThanConfiguredThrowsReturnsBadRequest() {
    Long[] offerIds = new Long[] {575L, 576L};
    this.webClient.put().uri(API_OFFERS_ROOT + "/status?value=" + StatusType.A)
        .body(BodyInserters.fromObject(Arrays.asList(offerIds)))
        .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange().expectStatus()
        .isBadRequest();
  }

  @Test
  public void offerStatusUpdateWithEmptyOfferListThrowsReturnsBadRequest() {
    this.webClient.put().uri(API_OFFERS_ROOT + "/status?value=" + StatusType.A)
        .body(BodyInserters.fromObject(Collections.emptyList()))
        .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange().expectStatus()
        .isBadRequest();
  }

  @Test
  public void offerStatusUpdateWithInvalidExternalOfferId() {
    List<String> offerIds = ImmutableList.of("2510N0817H05_820999");
    this.webClient.put().uri(API_OFFERS_ROOT + "/status?value=" + StatusType.A)
        .body(BodyInserters.fromObject(offerIds))
        .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange().expectStatus()
        .isOk();
  }

  private OfferDetails stubOfferDetails(String[] externalOfferIds, Long[] offerIds,
      ZonedDateTime now, StatusType statusType) {
    Offer offer = OfferHelper.createSCOfferSendByOMSDuringPromoteToPreview(externalOfferIds[0],
        offerIds[0], statusType);
    offer.getRules().setEndDate(offer.getRules().getEndDate().toBuilder().offerEffectiveEndDate(now)
        .displayEffectiveEndDate(now).build());
    return offerDetailsMapper.from(offer);
  }

}
