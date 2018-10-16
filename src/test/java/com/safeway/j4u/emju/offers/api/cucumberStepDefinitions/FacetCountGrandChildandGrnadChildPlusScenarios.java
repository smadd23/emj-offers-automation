package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class FacetCountGrandChildandGrnadChildPlusScenarios extends BaseApiTest {


    @When("^Business User searches offers using Startdate & OfferProgramcode & offerStatus$")
    public void testGetOfferSearchByStartdateAndOfferProgramCodeAndOfferStatus(List<String> methodName) throws UnsupportedEncodingException {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q") + ResourceEndpointUri.FACET_DELIMITER;
    }

    @When("^Business User searches offers using PostalCode and StoreId and Enddate$")
    public void testGetOfferSearchByPostalCodeAndStoreIdAndEnddate(List<String> methodName) throws UnsupportedEncodingException {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q") + ResourceEndpointUri.FACET_DELIMITER;
    }

    @When("^Business User searches offers using StartDate and EndDate and PostalCd and OfferStatus and StoreId and OfferProgramcode$")
    public void testGetOfferSearchByStartDateAndEndDateAndPostalCodeAndOfferStatusAndStoreIdAndOfferProgramcode(List<String> methodName) throws UnsupportedEncodingException {
        setTestCaseName(methodName.get(0));
        currentTsDataRowsJsonArray =
                dataExtractor.getJSONParseTestData(
                        GlobalConstants.testEnvironment,
                        GlobalConstants.currentTestAPIGroupName,
                        GlobalConstants.currentTestAPI,
                        getTestCaseName());
        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
        queryParams.put("q", currentTsJsonObject.get("q"));
        authenticatedGalleryEndpoint +=
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q") + ResourceEndpointUri.FACET_DELIMITER;
    }



}
