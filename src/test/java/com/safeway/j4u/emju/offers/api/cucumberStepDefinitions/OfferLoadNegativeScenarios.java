package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.google.appengine.api.urlfetch.HTTPMethod;
import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfferLoadNegativeScenarios extends BaseApiTest {
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

    @When("^Business user loads unsupported data file$")
    public void businesUserLoadsUnSupportedData(List<String> methodName) {
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
    @And("^API Response is asserted as Status Code Bad Request$")
    public void assertStatusCode() {
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test()
    @And("^API Response is asserted as Status Code Server Error$")
    public void assertStatusCodeasError() {
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }
//    @When("^Business user loads Offer with null AggregateOfferId$")
//    public void businessUserLoadsOfferwithNullAggregateOfferId(List<String> methodName) {
//        testCaseName = methodName.get(0);
//        headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
//        headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
//        authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
//    }
    @When("^Business user loads offer with null ExternalOfferId$")
    public void businessUserLoadsDataWithNullExternalOfferId(List<String> methodName) {
        testCaseName = methodName.get(0);
        headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
        headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
        authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
    }
    @When("^Business User loads data with null offerstatus$")
    public void businessUserLoadsDataWithNullOfferStatus(List<String> methodName) {
        testCaseName = methodName.get(0);
        headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
        headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
        authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
    }
    @When("^Business User loads data with null programcode$")
    public void businessUserLoadsDataWithNullProgramCode(List<String> methodName) {
        testCaseName = methodName.get(0);
        headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
        headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
        authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
    }
//    @When("^Business User loads data with SpecialCharectors for AggregateOfferID$")
//    public void businessUserLoadsDataWithSpecialCharectorsforAggregateOfferId(List<String> methodName) {
//        testCaseName = methodName.get(0);
//        headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
//        headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
//        authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
//    }
//    @When("^Business User loads data with SpecialCharectors for ExternalOfferID$")
//    public void businessUserLoadsDataWithSpecialCharectorsforExternalOfferId(List<String> methodName) {
//        testCaseName = methodName.get(0);
//        headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
//        headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
//        authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
//    }
    @When("^Business User loads data  SpecialCharectors for OfferStatus$")
    public void businessUserLoadsDataWithSpecialCharectorsForOfferStatus(List<String> methodName) {
        testCaseName = methodName.get(0);
        headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
        headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
        authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
    }
    @When("^Business User loads data with SpecialCharectors for Programcode$")
    public void businessUserLoadsDataWithSpecialCharectorsforProgramCode(List<String> methodName) {
        testCaseName = methodName.get(0);
        headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
        headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
        authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
    }


}
