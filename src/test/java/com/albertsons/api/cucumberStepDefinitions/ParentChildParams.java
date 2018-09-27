package com.albertsons.api.cucumberStepDefinitions;

import com.albertsons.api.framework.support.common.BaseApiTest;
import com.albertsons.api.framework.support.constants.GlobalConstants;
import com.albertsons.api.framework.support.constants.ResourceEndpointUri;
import com.albertsons.api.framework.support.constants.TestDataFileNames;
import com.albertsons.api.framework.support.pojo.galleryservices.OfferSearch;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.gson.JsonArray;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import java.io.File;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.*;
import javax.xml.crypto.Data;
import org.apache.http.HttpStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

        /**AUTHOR :: PUSHPAVALLI CHAR **/

public class ParentChildParams extends BaseApiTest {
    private String testCaseName;
    private OfferSearch offerSearchExpected;
    private OfferSearch offerSearchActual;
    public Response response;
    private Map<String, String> env;

            /** Initialize before each test. */
    @BeforeClass(alwaysRun = true)
    @Given("^The Test Environment is Defined$")
    public void beforeMethod(Map<String, String> env) throws Exception {
        this.env = env;
        String currentTestEnv = env.get("currentTestEnvironemnt");
        String apiGroupName = env.get("apiGroupName");
        String apiName = env.get("apiName");
        setupSuite(currentTestEnv,apiGroupName,apiName);
    }

            /** Initialize before each test. */
    @BeforeMethod(alwaysRun = true)
    @And("^Parameters are intialized$")
    public void parametersAreIntialized()  {
        queryParams = new HashMap<String, Object>();
        headerParams = new HashMap<String, Object>();
        authenticatedGalleryEndpoint =
                dataExtractor.getTestEnvironmentEndPoint(GlobalConstants.testEnvironment);
    }
    @When("^Business User searches offers using offerStatus$")
    public void businessUserSearchesOffersUsingOfferStatus(List<String> methodName) {
        testCaseName = methodName.get(0);
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        testCaseName);
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @Test()
    @Then("^API Response is extracted$")
    public void apiResponseIsExtracted() {
        // Need to set Proxy if connected to Safeway Network
        setProxy();
        setSslConfig();
        // Invoke the service
         response =
                invokeService(
                        HTTPMethod.GET,
                        authenticatedGalleryEndpoint,
                        null,
                        null,
                        headerParams,
                        null,
                        GlobalConstants.GetCallArgs.HEADERPARAM.toString(),
                        null,
                        null);
    }
    @Test()
    @And("^API Response is asserted for Success Status Code$")
    public void assertStatusCode(){
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);

    }

    @Test()
    @And("^API Response is asserted for counts$")
    public void assertCount(Map<String, Integer> counts){
        int expectedCount = response.jsonPath().getList("$").size();

        int actualCount = Integer.parseInt((counts.get("counts").toString()));;
        Assert.assertTrue(actualCount>=actualCount);
    }
    @Test()
    @When("^Business User searches offers using ExternalOfferID$")
    public void testGetOfferSearchByExternalOfferId(List<String> methodName) throws Exception {
        testCaseName = methodName.get(0);
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        testCaseName);
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @When("^Business User searches offers using StoreID$")
        public void businessUserSearchesOffersUsingStoreID(List<String> methodName) {
        testCaseName = methodName.get(0);
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        testCaseName);
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @When("^Business User searches offers using ZipCode$")
        public void businessUserSearchesOffersUsingZipCode(List<String> methodName){
        testCaseName = methodName.get(0);
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        testCaseName);
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @When("^Business User searches offers using Start Date$")
    public void businessUserSearchesOffersUsingStartDate(List<String> methodName) throws UnsupportedEncodingException {
        testCaseName = methodName.get(0);
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        testCaseName);
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
    }

    @When("^Business User searches offers using End Date$")
    public void businessUserSearchesOffersUsingEndDate(List<String> methodName) throws UnsupportedEncodingException {
        testCaseName = methodName.get(0);
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        testCaseName);
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
    }

    @When("^Business User searches offers using Offer Program Code$")
    public void businessUserSearchesOffersUsingOfferProgramCode(List<String> methodName){
        testCaseName = methodName.get(0);
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        testCaseName);
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");

    }

    /*Child Param Test Scenarios*/
    @When("^Business User searches offers using ZipCode & Offerstatus$")
    public void businessUserSearchesOffersUsingZipCodeOfferstatus(List<String> methodName) {
        testCaseName = methodName.get(0);
            currentTsDataRowsJsonArray =
                    dataExtractor.getJSONParseTestData(
            GlobalConstants.testEnvironment,
            GlobalConstants.currentTestAPIGroupName,
            GlobalConstants.currentTestAPI,
            testCaseName);
            currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
            authenticatedGalleryEndpoint +=
            ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }
    /*Child Param Test Scenarios*/
    @When("^Business User searches offers using ExternalOfferId & Offerstatus$")
    public void businessUserSearchesOffersUsingExternalOfferIdOfferstatus(List<String> methodName) {
        testCaseName = methodName.get(0);
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        testCaseName);
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @When("^Business User searches offers using EndDate & Offerstatus$")
    public void businessUserSearchesOffersUsingEndDateOfferstatus(List<String> methodName) throws UnsupportedEncodingException {
        testCaseName = methodName.get(0);
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        testCaseName);
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
    }

    @When("^Business User searches offers using StartDate & Offerstatus$")
    public void businessUserSearchesOffersUsingStartDateOfferstatus(List<String> methodName) throws UnsupportedEncodingException {
        testCaseName = methodName.get(0);
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        testCaseName);
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
    }
}
