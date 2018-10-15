package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import com.safeway.j4u.emju.offers.model.PaginatedOffer;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackgroundStepDefPOST extends BaseApiTest {
  private Map<String, String> env = new HashMap<>();
  String testCaseName;

  /** Initialize before each test. */
  @BeforeClass(alwaysRun = true)
  @Given("^The Test Environment is Defined$")
  public void beforeMethod(Map<String, String> env) throws Exception {
    this.env = env;
    String currentTestEnv = env.get("currentTestEnvironment");
    String apiGroupName = env.get("apiGroupName");
    String apiName = env.get("apiName");
    setupSuite(currentTestEnv, apiGroupName, apiName);
  }
  /** Initialize before each test. */
  @BeforeMethod(alwaysRun = true)
  @And("^Parameters are intialized$")
  public void parametersAreIntialized() {
    headerParams = new HashMap<String, Object>();
    queryParams = new HashMap<>();
    pathParams = new HashMap<>();
    authenticatedGalleryEndpoint =
            dataExtractor.getTestEnvironmentEndPoint(GlobalConstants.testEnvironment);
    //Uncomment below for POST Call//
    //headerParams.put(GlobalConstants.ACCEPT,GlobalConstants.APPLICATION_VND_V1);
    headerParams.put(GlobalConstants.CACHECONTROL, GlobalConstants.NO_CACHE);
    headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1);
    authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
  }

  @Then("^API Response is extracted for POST call$")
  public void apiResponseIsExtractedPOST() {
    File bodyFile = new File(JSON_BODYDATA_PATH + getTestCaseName());
    response =
            invokeService(
                    HTTPMethod.POST,
                    authenticatedGalleryEndpoint,
                    null,
                    null,
                    headerParams,
                    null,
                    GlobalConstants.GetCallArgs.HEADERPARAM.toString(),
                    null,
                    bodyFile);
  }

  @And("^API Response is asserted for Created Status Code$")
  public void assertStatusCode() {
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
  }

  @Then("^API Response is extracted$")
  public void apiResponseIsExtracted() {
    // Need to set Proxy if connected to Safeway Network
    // setProxy();
    setSslConfig();
    // Invoke the service
    response =
            invokeService(
                    HTTPMethod.GET,
                    authenticatedGalleryEndpoint,
                    null,
                    pathParams,
                    headerParams,
                    null,
                    GlobalConstants.GetCallArgs.HEADERPARAM.toString(),
                    null,
                    null);

  }
  @And("^API Response is asserted for Success Status Code$")
  public void assertStatusCodeGet(){
    Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);
  }

  @And("^API Response is asserted for ALL attributes$")
  public void apiResponseIsAssertedForALLAttributes(List<String> fileName) throws IOException {
    String responseFile = fileName.get(0);
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    mapper.findAndRegisterModules();
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

    PaginatedOffer actualPaginatedOffers = mapper.readValue(response.body().asString(), PaginatedOffer.class);

    PaginatedOffer expectedPaginatedOffers = mapper.readValue(new File(JSON_RESPONSE_PATH+"offerSearch/"+responseFile+".json"), PaginatedOffer.class);

    Assert.assertTrue(expectedPaginatedOffers.equals(actualPaginatedOffers));
  }
}
