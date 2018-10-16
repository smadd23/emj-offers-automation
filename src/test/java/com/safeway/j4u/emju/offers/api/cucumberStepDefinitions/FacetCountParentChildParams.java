package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class FacetCountParentChildParams extends BaseApiTest {

@When("^Business User searches offers using offerStatus with facet$")
public void testGetOfferSearchByOfferStatus(List<String> methodName) {
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
@Test()
@When("^Business User searches offers using ExternalOfferID with facet$")
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
    authenticatedGalleryEndpoint +=
            ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q") + ResourceEndpointUri.FACET_DELIMITER;
}

@When("^Business User searches offers using StoreID with facet$")
public void testGetOfferSearchByStoreId(List<String> methodName) {
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

@When("^Business User searches offers using PostalCode with facet$")
public void testGetOfferSearchByPostalCode(List<String> methodName) {
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

@When("^Business User searches offers using Start Date with facet$")
public void testGetOfferSearchByStartDate(List<String> methodName) throws UnsupportedEncodingException {
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

@When("^Business User searches offers using End Date with facet$")
public void testGetOfferSearchByEndDate(List<String> methodName) throws UnsupportedEncodingException {
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
@When("^Business User searches offers using Offer Program Code with facet$")
public void testGetOfferSearchByOfferProgramCode(List<String> methodName) {
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

//    /*Child Param Test Scenarios*/
@When("^Business User searches offers using StartDate & PostalCode with facet$")
public void testGetOfferSearchByStartDateandPostalCode(List<String> methodName) {
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


@When("^Business User searches offers using EndDate & StartDate with facet$")
public void testGetOfferSearchByEndDateandStartDate(List<String> methodName) {
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

@When("^Business User searches offers using OfferStatus & EndDate with facet$")
public void testGetOfferSearchByOfferStatusandEnddate(List<String> methodName) throws UnsupportedEncodingException {
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

@When("^Business User searches offers using StoreId & ProgramCode with facet$")
public void businessUserSearchesOffersUsingStoreIdProgramCode(List<String> methodName) throws UnsupportedEncodingException {
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
