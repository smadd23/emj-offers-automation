package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.google.appengine.api.urlfetch.HTTPMethod;
import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices.OfferSearch;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfferLoadPostiveScenarios extends BaseApiTest {

  private String testCaseName;
  public Response response;
  private Map<String, String> env;

  /** Initialize before each test. */
  @BeforeClass(alwaysRun = true)
  @Given("^The Test Environment is Defined for POST call$")
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
    authenticatedGalleryEndpoint =
        dataExtractor.getTestEnvironmentEndPoint(GlobalConstants.testEnvironment);
  }

  @When("^Business User loads data with offerstatus A$")
  public void businessUserLoadsDataWithOfferStatusA(List<String> methodName) {
    testCaseName = methodName.get(0);
    headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
    headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
    authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
  }

  @Test()
  @Then("^API Response is extracted$")
  public void apiResponseIsExtracted() {
    File bodyFile = new File(JSON_BODYDATA_PATH + testCaseName);
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

  @Test()
  @And("^API Response is asserted for Success Status Code$")
  public void assertStatusCode() {
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
  }
  @When("^Business User loads data with offerstatus A with Future dates$")
  public void businessUserLoadsDataWithOfferStatusAWithFutureDates(List<String> methodName) {
    testCaseName = methodName.get(0);
    headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
    headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
    authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
  }
  @When("^Business User loads data with offerstatus D$")
  public void businessUserLoadsDataWithOfferStatusD(List<String> methodName) {
    testCaseName = methodName.get(0);
    headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
    headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
    authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
  }
  @When("^Business User loads data with offerstatus E$")
  public void businessUserLoadsDataWithOfferStatusE(List<String> methodName) {
    testCaseName = methodName.get(0);
    headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
    headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
    authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
  }
  @When("^Business User loads data with offerstatus L$")
  public void businessUserLoadsDataWithOfferStatusL(List<String> methodName) {
    testCaseName = methodName.get(0);
    headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
    headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
    authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
  }
//  @When("^User loads maximum no of offers using the Offer Load API$")
//  public void businessUserLoadsDataWithMaxnoofOffers(List<String> methodName) {
//    testCaseName = methodName.get(0);
//    headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
//    headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
//    authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
//  }

}