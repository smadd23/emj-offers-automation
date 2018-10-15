package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.google.appengine.api.urlfetch.HTTPMethod;
import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfferSearchAndLoadPagination extends BaseApiTest {
    int next;
    int expectedValue;
    BackgroundStepDefPOST apiExtraction = new BackgroundStepDefPOST();

    @When("^Business User Loads (.+) Offers with OfferStatus A$")
    public void businessExamples(String method)  {
        setTestCaseName(method);
    }

    @When("^Business User Loads (.+) Offers with Offerstatus E$")
    public void businessExamplesE(String method)  {
        setTestCaseName(method);
    }

    @Given("^Business user searches offers using StoreIdAndlimit$")
    public void businessUserSearchesOffersUsingStoreIdAndLimit(List<String> methodName){
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
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @And("^API Response is asserted for counts matching the limit$")
    public void apiResponseIsAssertedForCountsMatchingTheLimitValueSpecifiedInTheSearch(Map<String, Integer> counts){
        int actualCount = response.jsonPath().getList("offers").size();
        int expectedCount = Integer.parseInt((counts.get("counts").toString()));;
        Assert.assertTrue(actualCount<=expectedCount);
    }

    @And("^API Response is read for a valid SearchID$")
    public void apiResponseIsReadForAValidSearchID() {
        searchId=response.jsonPath().get("sid");
    }

    @When("^Pre-Determined Next Page search (.+) called One Page at a time$")
    public void preDeterminedNextPageSearchIterativelyCalledOnePageAtATime(String iterate) {
        this.next = Integer.parseInt(iterate);
        String news = "?q=sid="+searchId+";next="+iterate;
        Object endpoint = (Object) authenticatedGalleryEndpoint.concat(news);
        authenticatedGalleryEndpoint = endpoint.toString();
    }

    @When("^Forward page search is called One Page at a time$")
    public void forwardPageSearchIsCalledOnePageAtATime(Map<String, Integer> readPage) {
        String currentPage;
        Integer nextPage = readPage.get("InitialPage");
        do{
        authenticatedGalleryEndpoint = "https://emju-offers-dev.apps.np.stratus.albertsons.com/api/offers";
        String news = "?q=sid="+searchId+";next="+nextPage;
        Object endpoint = (Object) authenticatedGalleryEndpoint.concat(news);
        authenticatedGalleryEndpoint = endpoint.toString();
        apiExtraction.apiResponseIsExtracted();
        apiExtraction.assertStatusCodeGet();
        currentPage =apiResponseIsAssertedForExistingPageValue(nextPage);
        nextPage = nextPage + 1;
        } while(currentPage!=null);
    }

    @When("^Previous page search is called One Page at a time$")
    public void previousPageSearchIsCalledOnePageAtATime(Map<String, Integer> readPage) {
        String current;
        Integer currentPage;
        Integer prevPage = readPage.get("LastPage");
        Map<String, Integer> forwardPage = new HashMap<>();
        forwardPage.put("InitialPage", 2);
        forwardPageSearchIsCalledOnePageAtATime(forwardPage);
        do{
            authenticatedGalleryEndpoint = "https://emju-offers-dev.apps.np.stratus.albertsons.com/api/offers";
            String news = "?q=sid="+searchId+";next="+prevPage;
            Object endpoint = (Object) authenticatedGalleryEndpoint.concat(news);
            authenticatedGalleryEndpoint = endpoint.toString();
            apiExtraction.apiResponseIsExtracted();
            apiExtraction.assertStatusCodeGet();
            current= apiResponseIsAssertedForExistingPageValue(prevPage);
            if(current==null)
                currentPage = 0;
            else
                currentPage=Integer.parseInt(current);
            prevPage =  prevPage- 1;
        } while(currentPage!=1);
    }

    @And("^API Response is asserted for existing page value$")
    public String apiResponseIsAssertedForExistingPageValue(Integer nextPage) {
        String current = response.jsonPath().getString("current");
        Integer actualCount;
    if (current != null) actualCount = Integer.parseInt(current);
    else {
      actualCount = 0;
      nextPage=0;
            }
        Assert.assertTrue(actualCount==nextPage);
        return current;
    }

    @When("^Business user searches offers using StoreId And (.+)$")
    public void businessUserSearchesOffersUsingStoreIdAndLimit(String method) {
        setTestCaseName(method);
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

    @And("^API Response is asserted for counts matching the limit (.+)$")
    public void apiResponseIsAssertedForCountsMatchingTheLimitValueSpecifiedInTheSearch(String value) {
        int actualValue = response.jsonPath().getList("offers").size();
        expectedValue = Integer.parseInt(value);
        Assert.assertTrue(actualValue==expectedValue);
    }

    @When("^Business user searches offers using OfferStatus And (.+)$")
    public void businessUserSearchesOffersUsingOfferStatusAndLimit(String method) {
        setTestCaseName(method);
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

    @When("^Pre-Determined Previous Page search (.+) called One Page at a time$")
    public void preDeterminedPreviousPageSearchIterativelyCalledOnePageAtATime(String method) {
        setTestCaseName(method);
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

    @Given("^Business user searches offers using OfferStatus with limit$")
    public void businessUserSearchesOffersUsingOfferStatusWithLimit(List<String> methodName){
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
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @Given("^Business user searches offers using StartDate with limit$")
    public void businessUserSearchesOffersUsingStartDateWithLimit(List<String> methodName) throws UnsupportedEncodingException {
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

    @Given("^Business user searches offers using Offer Program Code with limit$")
    public void businessUserSearchesOffersUsingOfferProgramCodeWithLimit(List<String> methodName){
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
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @Given("^Business user searches offers using StartDate And StoreId with limit$")
    public void businessUserSearchesOffersUsingStartDateAndStoreIdWithLimit(List<String> methodName) throws UnsupportedEncodingException {
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

    @Given("^Business user searches offers using EndDate with limit$")
    public void businessUserSearchesOffersUsingEndDateWithLimit(List<String> methodName) throws UnsupportedEncodingException {
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

    @Given("^Business user searches offers using OfferStatus StoreID with limit$")
    public void businessUserSearchesOffersUsingOfferStatusStoreIDWithLimit(List<String> methodName){
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
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }


    @Given("^Business user searches offers using EndDate And StoreId with limit$")
    public void businessUserSearchesOffersUsingEndDateAndStoreIdWithLimit(List<String> methodName) throws UnsupportedEncodingException {
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

    @Given("^Business user searches offers using StoreId ProgramCode and OfferStatus with limit$")
    public void businessUserSearchesOffersUsingStoreIdProgramCodeAndOfferStatusWithLimit(List<String> methodName){
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
                ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
    }

    @Given("^Business user searches offers using StoreId StartDate and OfferStatus with limit$")
    public void businessUserSearchesOffersUsingStoreIdStartDateAndOfferStatusWithLimit(List<String> methodName) throws UnsupportedEncodingException {
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

    @When("^Business User searches offers with No Semicolon in path parameter$")
    public void businessUserSearchesOffersWithNoSemicolonInPathParameter(List<String> methodName) throws UnsupportedEncodingException {
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

    @When("^Business User searches offers with colon in path parameter$")
    public void businessUserSearchesOffersWithColonInPathParameter(List<String> methodName) throws UnsupportedEncodingException {
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

    @When("^Business User searches offers with wrong SID in path parameter$")
    public void businessUserSearchesOffersWithWrongSIDInPathParameter(List<String> methodName) throws UnsupportedEncodingException {
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

    @Given("^Business user searches offers using StartDate And EndDate with limit$")
    public void businessUserSearchesOffersUsingStartDateAndEndDateWithLimit(List<String> methodName) throws UnsupportedEncodingException {
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

    @Given("^Business user searches offers using StartDate EndDate StoreId and OfferStatus with limit$")
    public void businessUserSearchesOffersUsingStartDateEndDateStoreIdAndOfferStatusWithLimit(List<String> methodName) throws UnsupportedEncodingException {
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
