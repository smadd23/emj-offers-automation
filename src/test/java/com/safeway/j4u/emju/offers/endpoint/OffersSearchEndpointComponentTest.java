package com.safeway.j4u.emju.offers.endpoint;

import static com.safeway.j4u.emju.offers.util.OffersConstants.API_OFFERS_ROOT;
import static com.safeway.j4u.emju.offers.util.OffersConstants.APPLICATION_VND_SAFEWAY_V1_JSON;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import com.safeway.j4u.emju.offers.entity.OfferDetails;
import com.safeway.j4u.emju.offers.helpers.OfferHelper;
import com.safeway.j4u.emju.offers.model.PaginatedOffer;
import com.safeway.j4u.emju.offers.model.ProgramCodeType;
import com.safeway.j4u.emju.offers.model.StatusType;
import com.safeway.j4u.emju.offers.repository.OfferDetailsRepository;
import com.safeway.j4u.emju.offers.service.OfferSearchQueryBuilder;
import java.util.HashSet;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.main.web-application-type=reactive"})
@AutoConfigureWebTestClient
@ActiveProfiles("test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OffersSearchEndpointComponentTest {

  @Autowired
  private WebTestClient webClient;

  @Autowired
  private OfferDetailsRepository offerDetailsRepo;

  @Autowired
  private OfferSearchQueryBuilder queryBuilder;

  @Autowired
  private ReactiveCassandraTemplate cassandraTemplate;

  @Autowired
  private CassandraTemplate cassandraTemplate1;

  // @Before
  public void setUp() throws Exception {
    Mono<OfferDetails> deleteAndCreateOffer1 = this.offerDetailsRepo.deleteById(1043L)
        .then(this.offerDetailsRepo.save(OfferHelper.createOfferDetails("2510N0817H05_827777",
            1043L, ProgramCodeType.SC, StatusType.A, "2018-08-01T00:00:01.235-07:00",
            "2018-08-05T00:00:01.235-07:00", "10", new HashSet<Integer>() {
              {
                add(94404);
                add(94568);
              }
            }, new HashSet<String>() {
              {
                add("999888");
                add("777666");
                add("555444");
              }
            })));
    deleteAndCreateOffer1.block();
    // StepVerifier.create(deleteAndCreateOffer1).expectNextCount(1).verifyComplete();

    Mono<OfferDetails> deleteAndCreateOffer2 = this.offerDetailsRepo.deleteById(1044L)
        .then(this.offerDetailsRepo.save(OfferHelper.createOfferDetails("2510N0817H05_825555",
            1044L, ProgramCodeType.MF, StatusType.P, "2018-09-01T00:00:01.235-07:00",
            "2018-11-01T00:00:01.235-07:00", "10", new HashSet<Integer>() {
              {
                add(94086);
                add(63043);
              }
            }, new HashSet<String>() {
              {
                add("100100");
                add("200200");
                add("300300");
              }
            })));
    deleteAndCreateOffer2.block();

    Mono<OfferDetails> deleteAndCreateOffer3 = this.offerDetailsRepo.deleteById(1045L)
        .then(this.offerDetailsRepo.save(OfferHelper.createOfferDetails("2510N0817H05_825556",
            1045L, ProgramCodeType.SC, StatusType.A, "2018-09-01T00:00:01.235-07:00",
            "2018-11-01T00:00:01.235-07:00", "10", new HashSet<Integer>() {
              {
                add(94555);
                add(94588);
                add(94568);
              }
            }, new HashSet<String>() {
              {
                add("100100");
                add("200200");
              }
            })));
    deleteAndCreateOffer3.block();

    Mono<OfferDetails> deleteAndCreateOffer4 = this.offerDetailsRepo.deleteById(1046L)
        .then(this.offerDetailsRepo.save(OfferHelper.createOfferDetails("2510N0817H05_825557",
            1046L, ProgramCodeType.SC, StatusType.A, "2018-09-01T00:00:01.235-07:00",
            "2018-11-01T00:00:01.235-07:00", "10", new HashSet<Integer>() {
              {
                add(94555);
              }
            }, new HashSet<String>() {
              {
                add("200200");
              }
            })));
    deleteAndCreateOffer4.block();

    Mono<OfferDetails> deleteAndCreateOffer5 = this.offerDetailsRepo.deleteById(1047L)
        .then(this.offerDetailsRepo.save(OfferHelper.createOfferDetails("2510N0817H05_825558",
            1047L, ProgramCodeType.SC, StatusType.A, "2018-09-01T00:00:01.235-07:00",
            "2018-11-01T00:00:01.235-07:00", "10", new HashSet<Integer>() {
              {
                add(94025);
                add(94404);
              }
            }, new HashSet<String>() {
              {
                add("345678");
              }
            })));
    deleteAndCreateOffer5.block();

    Thread.currentThread().sleep(10000L);
  }

  @Test
  public void testSearchOffersByExternalOfferId() throws Exception {
    setUp();

    StepVerifier
        .create(this.webClient.get().uri(API_OFFERS_ROOT + "?q=externalOfferId=2510N0817H05_825555")
            .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
            .returnResult(PaginatedOffer.class).getResponseBody())
        .consumeNextWith(o -> {
          assertThat(o.getOffers().get(0).getInfo().getOfferStatus(), is(equalTo(StatusType.P)));
          assertThat(o.getOffers().get(0).getInfo().getId().getOfferId(), is(equalTo(1044L)));
        }).verifyComplete();
  }

  @Test
  public void testSearchOffersByOfferId() {
    StepVerifier.create(this.webClient.get().uri(API_OFFERS_ROOT + "?q=offerId=1043")
        .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
        .returnResult(PaginatedOffer.class).getResponseBody()).consumeNextWith(o -> {
          assertThat(o.getOffers().get(0).getInfo().getOfferStatus(), is(equalTo(StatusType.A)));
          assertThat(o.getOffers().get(0).getInfo().getId().getExternalOfferId(),
              is(equalTo("2510N0817H05_827777")));
        }).verifyComplete();
  }

  @Test
  public void testSearchOffersByOfferStatusActive() {
    StepVerifier.create(this.webClient.get().uri(API_OFFERS_ROOT + "?q=offerStatus=A")
        .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
        .returnResult(PaginatedOffer.class).getResponseBody()).consumeNextWith(o -> {
          assertThat(o.getOffers().get(0).getInfo().getOfferStatus(), is(equalTo(StatusType.A)));
          assertThat(o.getOffers().get(0).getInfo().getOfferProgramCode(),
              is(equalTo(ProgramCodeType.SC)));
        }).verifyComplete();
  }

  @Test
  public void testSearchOffersByOfferStatusActiveOrPreview() {
    StepVerifier.create(this.webClient.get().uri(API_OFFERS_ROOT + "?q=offerStatus=(A OR P)")
        .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
        .returnResult(PaginatedOffer.class).getResponseBody()).consumeNextWith(o -> {
          assertThat(o.getOffers().get(0).getInfo().getOfferProgramCode(),
              is(equalTo(ProgramCodeType.SC)));
        }).verifyComplete();
  }

  @Test
  public void testSearchOffersByOfferStatusActiveOrPreviewAndExternalOfferId() {
    StepVerifier.create(this.webClient.get()
        .uri(API_OFFERS_ROOT + "?q=offerStatus=(A OR P);externalOfferId=2510N0817H05_827777")
        .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
        .returnResult(PaginatedOffer.class).getResponseBody()).consumeNextWith(o -> {
          assertThat(o.getOffers().get(0).getInfo().getOfferProgramCode(),
              is(equalTo(ProgramCodeType.SC)));
          assertThat(o.getOffers().get(0).getInfo().getOfferStatus(), is(equalTo(StatusType.A)));
          assertThat(o.getOffers().get(0).getInfo().getId().getOfferId(), is((equalTo(1043L))));
        }).verifyComplete();
  }

  @Test
  public void testSearchOffersByOfferType() {
    StepVerifier.create(this.webClient.get()
        .uri(API_OFFERS_ROOT + "?q=offerProgramCd=SC;externalOfferId=2510N0817H05_827777")
        .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
        .returnResult(PaginatedOffer.class).getResponseBody()).consumeNextWith(o -> {
          assertThat(o.getOffers().get(0).getInfo().getOfferStatus(), is(equalTo(StatusType.A)));
          assertThat(o.getOffers().get(0).getInfo().getId().getOfferId(), is((equalTo(1043L))));
        }).verifyComplete();
  }

  @Test
  public void testSearchOffersByOfferStatusActiveOrPreviewAndOfferType() {
    StepVerifier.create(
        this.webClient.get().uri(API_OFFERS_ROOT + "?q=offerStatus=(A OR P);offerProgramCd=SC;")
            .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
            .returnResult(PaginatedOffer.class).getResponseBody())
        .consumeNextWith(o -> {
          assertThat(o.getOffers().get(0).getInfo().getOfferProgramCode(),
              is(equalTo(ProgramCodeType.SC)));
          assertThat(o.getOffers().get(1).getInfo().getOfferProgramCode(),
              is(equalTo(ProgramCodeType.SC)));
          assertThat(o.getOffers().get(2).getInfo().getOfferProgramCode(),
              is(equalTo(ProgramCodeType.SC)));
        }).verifyComplete();
  }

  @Test
  public void testSearchOffersByPriceCode() {
    StepVerifier.create(this.webClient.get().uri(API_OFFERS_ROOT + "?q=priceCd=10;postalCd=94086")
        .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
        .returnResult(PaginatedOffer.class).getResponseBody()).consumeNextWith(o -> {
          assertThat(o.getOffers().get(0).getInfo().getOfferStatus(), is(equalTo(StatusType.P)));
          assertThat(o.getOffers().get(0).getInfo().getId().getOfferId(), is(equalTo(1044L)));
        }).verifyComplete();
  }

  @Test
  public void testSearchOffersByPostalCd() {
    StepVerifier.create(this.webClient.get().uri(API_OFFERS_ROOT + "?q=postalCd=63043")
        .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
        .returnResult(PaginatedOffer.class).getResponseBody()).consumeNextWith(o -> {
          assertThat(o.getOffers().get(0).getInfo().getOfferStatus(), is(equalTo(StatusType.P)));
          assertThat(o.getOffers().get(0).getInfo().getId().getOfferId(), is(equalTo(1044L)));
        }).verifyComplete();
  }

  @Test
  public void testSearchOffersByStartDtEndDt() {
    StepVerifier.create(this.webClient.get()
        .uri(API_OFFERS_ROOT
            + "?q=startDt=[2018-07-31T00:00:00Z TO *];endDt=[* TO 2018-08-07T09:00:00Z]")
        .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
        .returnResult(PaginatedOffer.class).getResponseBody()).consumeNextWith(o -> {
          assertThat(o.getOffers().get(0).getInfo().getOfferStatus(), is(equalTo(StatusType.A)));
          assertThat(o.getOffers().get(0).getInfo().getId().getOfferId(), is(equalTo(1043L)));
        }).verifyComplete();
  }

  @Test
  public void testSearchOffersByStore() throws Exception {
    StepVerifier
        .create(this.webClient.get().uri(API_OFFERS_ROOT + "?q=storeId=200200;postalCd=63043")
            .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
            .returnResult(PaginatedOffer.class).getResponseBody())
        .consumeNextWith(o -> {
          assertThat(o.getOffers().get(0).getInfo().getOfferStatus(), is(equalTo(StatusType.P)));
          assertThat(o.getOffers().get(0).getInfo().getId().getOfferId(), is(equalTo(1044L)));
        }).verifyComplete();
  }

  @Test
  public void testSearchPaginatedOffersByStore() throws Exception {
    StepVerifier.create(this.webClient.get().uri(API_OFFERS_ROOT + "?q=storeId=345678;limit=2")
        .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
        .returnResult(PaginatedOffer.class).getResponseBody()).consumeNextWith(o -> {
          assertThat(o.getOffers().get(0).getInfo().getOfferStatus(), is(equalTo(StatusType.A)));
          assertThat(o.getOffers().get(0).getInfo().getId().getOfferId(), is(equalTo(1047L)));
          assertThat(o.getSid(), is(nullValue()));
          assertThat(o.getCurrent(), is(nullValue()));
        }).verifyComplete();

    Flux<PaginatedOffer> po =
        this.webClient.get().uri(API_OFFERS_ROOT + "?q=storeId=200200;limit=2")
            .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
            .returnResult(PaginatedOffer.class).getResponseBody();

    StepVerifier.create(po).consumeNextWith(o -> {
      assertThat(o.getOffers().get(0).getInfo().getOfferStatus(), is(notNullValue()));
      assertThat(o.getOffers().get(0).getInfo().getId().getOfferId(), is(notNullValue()));
      assertThat(o.getSid(), is(notNullValue()));
      assertThat(o.getCurrent(), is(notNullValue()));

      Integer current = Integer.valueOf(o.getCurrent());

      Flux<PaginatedOffer> po1 = this.webClient.get()
          .uri(API_OFFERS_ROOT + "?q=sid=" + o.getSid() + ";next=" + current + 1)
          .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
          .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
          .returnResult(PaginatedOffer.class).getResponseBody();

      po1.doOnNext(oo -> {
        assertThat(oo.getSid(), is(notNullValue()));
        assertThat(oo.getCurrent(), is("3"));
      });

      Flux<PaginatedOffer> po2 = this.webClient.get()
          .uri(API_OFFERS_ROOT + "?q=sid=" + o.getSid() + ";next=" + current + 2)
          .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
          .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
          .returnResult(PaginatedOffer.class).getResponseBody();

      po2.doOnNext(ooo -> {
        assertThat(ooo.getSid(), is(notNullValue()));
        assertThat(ooo.getCurrent(), is("4"));
      });

    }).verifyComplete();
  }

  @Test
  public void testSearchPaginatedOffersByStoreAndPostalCd() throws Exception {
    StepVerifier.create(
        this.webClient.get().uri(API_OFFERS_ROOT + "?q=storeId=345678;postalCd=94025;limit=2")
            .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
            .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
            .returnResult(PaginatedOffer.class).getResponseBody())
        .consumeNextWith(o -> {
          assertThat(o.getOffers().get(0).getInfo().getOfferStatus(), is(equalTo(StatusType.A)));
          assertThat(o.getOffers().get(0).getInfo().getId().getOfferId(), is(equalTo(1047L)));
          assertThat(o.getOffers().get(0).getInfo().getOfferProgramCode(),
              is(equalTo(ProgramCodeType.SC)));

          assertThat(o.getSid(), is(nullValue()));
          assertThat(o.getCurrent(), is(nullValue()));
        }).verifyComplete();
  }

  @Test
  public void testSearchPaginatedOffersByDate() throws Exception {

    Flux<PaginatedOffer> po = this.webClient.get()
        .uri(API_OFFERS_ROOT
            + "?q=startDt=[2018-07-31T00:00:00Z TO *];endDt=[* TO 2018-08-07T09:00:00Z];limit=1")
        .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
        .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
        .returnResult(PaginatedOffer.class).getResponseBody();

    StepVerifier.create(po).consumeNextWith(o -> {
      assertThat(o.getOffers().get(0).getInfo().getOfferStatus(), is(notNullValue()));
      assertThat(o.getOffers().get(0).getInfo().getId().getOfferId(), is(notNullValue()));
      assertThat(o.getSid(), is(notNullValue()));
      assertThat(o.getCurrent(), is(notNullValue()));

      Integer current = Integer.valueOf(o.getCurrent());

      Flux<PaginatedOffer> po1 = this.webClient.get()
          .uri(API_OFFERS_ROOT + "?q=sid=" + o.getSid() + ";next=" + current + 1)
          .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
          .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
          .returnResult(PaginatedOffer.class).getResponseBody();

      po1.doOnNext(oo -> {
        assertThat(oo.getSid(), is(notNullValue()));
        assertThat(oo.getCurrent(), is("3"));
      });

      Flux<PaginatedOffer> po2 = this.webClient.get()
          .uri(API_OFFERS_ROOT + "?q=sid=" + o.getSid() + ";next=" + current + 2)
          .accept(MediaType.valueOf(APPLICATION_VND_SAFEWAY_V1_JSON))
          .header(HttpHeaders.CONTENT_TYPE, APPLICATION_VND_SAFEWAY_V1_JSON).exchange()
          .returnResult(PaginatedOffer.class).getResponseBody();

      po2.doOnNext(ooo -> {
        assertThat(ooo.getSid(), is(notNullValue()));
        assertThat(ooo.getCurrent(), is("4"));
      });

    }).verifyComplete();
  }

}
