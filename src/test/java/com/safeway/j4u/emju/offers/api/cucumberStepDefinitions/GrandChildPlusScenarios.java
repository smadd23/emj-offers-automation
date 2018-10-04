package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.google.appengine.api.urlfetch.HTTPMethod;
import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices.OfferSearch;

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
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GrandChildPlusScenarios extends BaseApiTest {

    @When("^Business User searches offers ExternalOfferID, OfferStatus, EndDate & StoreId$")
    public void businessUserSearchesOffersExternalOfferIDOfferStatusEndDateStoreId(List<String> methodName) throws UnsupportedEncodingException {
        setTestCaseName(methodName.get(0));
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
                 ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
    }

    @When("^Business User searches offers using OfferStatus, PriceCode & StoreID & ExternalOfferID$")
    public void businessUserSearchesOffersUsingOfferStatusPriceCodeStoreIDExternalOfferID(List<String> methodName) throws UnsupportedEncodingException {
        setTestCaseName(methodName.get(0));
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
                ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
    }
    @And("^API Response is asserted for Success Status Code for GrandChildPlus Parameters$")
    public void apiResponseIsAssertedForSuccessStatusCodeForGrandChildPlusParameters(){
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);
    }
}
