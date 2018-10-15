package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;
import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;

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

    @When("^Business User searches offers using OfferStatus, ProgramCode & StoreID & ExternalOfferID$")
    public void businessUserSearchesOffersUsingOfferStatusProgramCodeStoreIDExternalOfferID(List<String> methodName) throws UnsupportedEncodingException {
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

}
