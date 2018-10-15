package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.gson.JsonArray;
import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import com.safeway.j4u.emju.offers.api.framework.support.constants.TestDataFileNames;
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

    @When("^Business User searches offers using offerStatus$")
    public void businessUserSearchesOffersUsingOfferStatus(List<String> methodName) {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @Test()
    @And("^API Response is asserted for counts$")
    public void assertCount(Map<String, Integer> counts){
        int expectedCount = response.jsonPath().getList("offers").size();
        int actualCount = Integer.parseInt((counts.get("counts").toString()));;
        Assert.assertTrue(expectedCount>=actualCount);
    }
    @Test()
    @When("^Business User searches offers using ExternalOfferID$")
    public void testGetOfferSearchByExternalOfferId(List<String> methodName) {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @When("^Business User searches offers using StoreID$")
    public void businessUserSearchesOffersUsingStoreID(List<String> methodName) {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        headerParams.put(GlobalConstants.CONTENTTYPE, "application/vnd.safeway.v1+json");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @When("^Business User searches offers using ZipCode$")
    public void businessUserSearchesOffersUsingZipCode(List<String> methodName) {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @When("^Business User searches offers using Start Date$")
    public void businessUserSearchesOffersUsingStartDate(List<String> methodName) throws UnsupportedEncodingException {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
    }

    @When("^Business User searches offers using End Date$")
    public void businessUserSearchesOffersUsingEndDate(List<String> methodName) throws UnsupportedEncodingException {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
    }

    @When("^Business User searches offers using Offer Program Code$")
    public void businessUserSearchesOffersUsingOfferProgramCode(List<String> methodName) {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    /*Child Param Test Scenarios*/
    @When("^Business User searches offers using ZipCode & Offerstatus$")
    public void businessUserSearchesOffersUsingZipCodeOfferstatus(List<String> methodName) {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    /*Child Param Test Scenarios*/
    @When("^Business User searches offers using ExternalOfferId & Offerstatus$")
    public void businessUserSearchesOffersUsingExternalOfferIdOfferstatus(List<String> methodName) {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @When("^Business User searches offers using EndDate & Offerstatus$")
    public void businessUserSearchesOffersUsingEndDateOfferstatus(List<String> methodName) throws UnsupportedEncodingException {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
    }

    @When("^Business User searches offers using StartDate & Offerstatus$")
    public void businessUserSearchesOffersUsingStartDateOfferstatus(List<String> methodName) throws UnsupportedEncodingException {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
    }
}
