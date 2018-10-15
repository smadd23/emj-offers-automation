package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import com.safeway.j4u.emju.offers.model.Offer;
import com.safeway.j4u.emju.offers.model.PaginatedOffer;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class PromoteOfferScenarios extends BaseApiTest {

  private String testCaseName;
  public Response response;
  private Map<String, String> env;
  private static Long offerIdInFocus;
  private static String externalOfferIdInFocus;
  private ObjectMapper mapper;

  /** Initialize before each test. */
  @BeforeClass(alwaysRun = true)
  @Given("^The Test Preview system$")
  public void beforeMethod(Map<String, String> env) throws Exception {
    this.env = env;
    // Need to set Proxy if connected to Safeway Network
    if (env.get("Environment").equalsIgnoreCase("local")) {
      setProxy();
      setSslConfig();
    }
    setupSuite(env.get("Environment"), null, null);

    this.mapper = new ObjectMapper();
    this.mapper.setSerializationInclusion(Include.NON_NULL);
    // this.mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    this.mapper.findAndRegisterModules();
    this.mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    this.mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
  }

  @When("^Business creates offer in the new Preview System$")
  public void createOffer() throws JsonParseException, JsonMappingException, IOException {

    PaginatedOffer sampleOffer = this.mapper
        .readValue(new File(JSON_BODYDATA_PATH + "OfferTemplate.json"), PaginatedOffer.class);
    int Random = 10000 + (int) (Math.random() * 40000);
    externalOfferIdInFocus = "2520W321_0" + Random;
    sampleOffer.getOffers().get(0).getInfo().getId().setExternalOfferId(externalOfferIdInFocus);
    this.mapper.writeValue(new File(JSON_BODYDATA_PATH + "OfferSample.json"),
        sampleOffer.getOffers().get(0));

    response = invokeService(HTTPMethod.POST,
        dataExtractor.getTestEnvironmentEndPoint(GlobalConstants.testEnvironment)
            + ResourceEndpointUri.OFFER_SEARCH,
        null, null, new HashMap<String, Object>() {
          {
            put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
            put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
          }
        }, null, GlobalConstants.GetCallArgs.HEADERPARAM.toString(), null,
        new File(JSON_BODYDATA_PATH + "OfferSample.json"));
  }

  @Test()
  @Then("^Offer gets created in Preview$")
  public void checkforSuccessfulOfferCreation() throws InterruptedException {
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);

    Thread.currentThread().sleep(20000L);
  }

  @And("^Check whether offer is created correctly")
  public void verifyCreatedOffer() {
    // Invoke the service
    response = invokeService(HTTPMethod.GET,
        dataExtractor.getTestEnvironmentEndPoint(GlobalConstants.testEnvironment)
            + ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER
            + "externalOfferId=" + externalOfferIdInFocus,
        null, null, new HashMap<String, Object>() {
          {
            put(GlobalConstants.CACHECONTROL, "no-cache");
            put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1);
          }
        }, null, GlobalConstants.GetCallArgs.HEADERPARAM.toString(), null, null);
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
  }

  @And("^Check whether only one offer is created")
  public void verifyOnlyOneOfferIsCreated() {
    Assert.assertEquals(1, response.jsonPath().getList("offers").size());
  }

  @And("^Check whether that offer is created with status Preview")
  public void verifyOfferReadyforPreview()
      throws JsonParseException, JsonMappingException, IOException {
    verifyOfferStatus("P");
  }

  @When("^Business approves offer in the new Preview System$")
  public void promoteOffer() throws JsonGenerationException, JsonMappingException, IOException {

    final List<String> externalOfferIds = new ArrayList<String>();
    externalOfferIds.add(externalOfferIdInFocus);

    this.mapper.writeValue(new File(JSON_BODYDATA_PATH + "OfferApproved.json"), externalOfferIds);

    response = invokeService(HTTPMethod.PUT,
        dataExtractor.getTestEnvironmentEndPoint(GlobalConstants.testEnvironment)
            + ResourceEndpointUri.OFFER_SEARCH + "/status?value=A",
        null, null, new HashMap<String, Object>() {
          {
            put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
            put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
          }
        }, null, GlobalConstants.GetCallArgs.HEADERPARAM.toString(), null,
        new File(JSON_BODYDATA_PATH + "OfferApproved.json"));
  }

  @Test()
  @Then("^Offer gets approved in Preview$")
  public void checkforSuccessfulOfferApproval() {
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
  }

  @And("^Check whether that offer exists")
  public void verifyOffer() {
    // Invoke the service
    response = invokeService(HTTPMethod.GET,
        dataExtractor.getTestEnvironmentEndPoint(GlobalConstants.testEnvironment)
            + ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER
            + "externalOfferId=" + externalOfferIdInFocus,
        null, null, new HashMap<String, Object>() {
          {
            put(GlobalConstants.CACHECONTROL, "no-cache");
            put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1);
          }
        }, null, GlobalConstants.GetCallArgs.HEADERPARAM.toString(), null, null);
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
  }

  @And("^Check paginated offer")
  public void verifyPaginatedOffer()
      throws JsonParseException, JsonMappingException, IOException, InterruptedException {

    // First request
    response = invokeService(HTTPMethod.GET,
        dataExtractor.getTestEnvironmentEndPoint(GlobalConstants.testEnvironment)
            + ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER
            + "storeId=200200;limit=1",
        null, null, new HashMap<String, Object>() {
          {
            put(GlobalConstants.CACHECONTROL, "no-cache");
            put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1);
          }
        }, null, GlobalConstants.GetCallArgs.HEADERPARAM.toString(), null, null);
    System.out.println("First response  = " + response.body().asString());
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    // second page
    PaginatedOffer offerPaginated =
        this.mapper.readValue(response.body().asString(), PaginatedOffer.class);

    System.out.println("Sid received =" + offerPaginated.getSid());
    // Thread.currentThread().sleep(2000L);

    do {
      response = invokeService(HTTPMethod.GET,
          dataExtractor.getTestEnvironmentEndPoint(GlobalConstants.testEnvironment)
              + ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER + "sid="
              + offerPaginated.getSid() + ";next=2",
          null, null, new HashMap<String, Object>() {
            {
              put(GlobalConstants.CACHECONTROL, "no-cache");
              put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1);
            }
          }, null, GlobalConstants.GetCallArgs.HEADERPARAM.toString(), null, null);

      System.out.println("Second response  = " + response.body().asString());
      System.out.println("Second response code  = " + response.getStatusCode());
    } while (response.getStatusCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR);

    // Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
  }

  @And("^if exists Check the status is approved correctly")
  public void verifyOfferStatus() throws JsonParseException, JsonMappingException, IOException {
    verifyOfferStatus("A");
  }

  private void verifyOfferStatus(String offerStatus)
      throws JsonParseException, JsonMappingException, IOException {

    PaginatedOffer offerPaginated =
        this.mapper.readValue(response.body().asString(), PaginatedOffer.class);

    for (Offer o : offerPaginated.getOffers()) {
      System.out.println("Offer Id" + o.getInfo().getId().getOfferId());
      offerIdInFocus = o.getInfo().getId().getOfferId();
      System.out.println("External Offer Id" + o.getInfo().getId().getExternalOfferId());
      System.out.println("Actual Offer Status" + o.getInfo().getOfferStatus());
      System.out.println("Expected Offer Status" + offerStatus);
      System.out.println("Offer Type" + o.getInfo().getOfferProgramCode());

      Assert.assertEquals(offerStatus, o.getInfo().getOfferStatus().toString());
    }
  }

  @When("^Business promotes offer in the new Preview System$")
  public void promoteNewOffer() {}

  @Test()
  @Then("^Check whether offer exists in J4U$")
  public void checkOfferExistsInJ4U() {

    dataExtractor.getTestEnvironmentEndPoint(GlobalConstants.testEnvironment);

    String J4UUri = GlobalConstants.J4UendPoint + "/" + offerIdInFocus + "/definition";
    System.out.println("J4U endpoint = " + J4UUri);

    response = invokeService(HTTPMethod.GET, J4UUri, null, null, new HashMap<String, Object>() {
      {
      }
    }, null, GlobalConstants.GetCallArgs.HEADERPARAM.toString(), null, null);
    System.out.println("First response  = " + response.body().asString());
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
  }

  @And("^Check offer attributes match Preview")
  public void verifyOfferAttributes() throws JsonParseException, JsonMappingException, IOException {

    Assert.assertEquals(response.jsonPath().get("usageType"), "O");
    Assert.assertEquals(response.jsonPath().get("extlOfferId"), externalOfferIdInFocus);
  }
}
