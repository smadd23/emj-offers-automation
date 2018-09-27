//package com.albertsons.api.cucumberStepDefinitions;
//
//import com.albertsons.api.framework.support.common.BaseApiTest;
//import com.albertsons.api.framework.support.constants.GlobalConstants;
//import com.albertsons.api.framework.support.constants.ResourceEndpointUri;
//import com.albertsons.api.framework.support.pojo.galleryservices.OfferSearch;
//import com.google.appengine.api.urlfetch.HTTPMethod;
//import cucumber.api.PendingException;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import org.apache.http.HttpStatus;
//import org.json.simple.JSONObject;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//
//public class NegativeScenarios extends BaseApiTest {
//    private String testCaseName;
//    public Response response;
//    private Map<String, String> env;
//
//    /** Initialize before each test. */
//    @BeforeClass(alwaysRun = true)
//    @Given("^The Test Environment is Defined$")
//    public void beforeMethodNC(Map<String, String> env) throws Exception {
//        this.env = env;
//        String currentTestEnv = env.get("currentTestEnvironemnt");
//        String apiGroupName = env.get("apiGroupName");
//        String apiName = env.get("apiName");
//        setupSuite(currentTestEnv,apiGroupName,apiName);
//    }
//
//    /** Initialize before each test. */
//    @BeforeMethod(alwaysRun = true)
//    @And("^Parameters are intialized$")
//    public void parametersAreIntializedNC()  {
//        queryParams = new HashMap<String, Object>();
//        headerParams = new HashMap<String, Object>();
//        authenticatedGalleryEndpoint =
//                dataExtractor.getTestEnvironmentEndPoint(GlobalConstants.testEnvironment);
//    }
//
//    @When("^Business User searches offers using No Parameters$")
//    public void businessUserSearchesOffersUsingNoParameters(List<String> methodName) {
//        testCaseName = methodName.get(0);
//        currentTsDataRowsJsonArray =
//                dataExtractor.getJSONParseTestData(
//                        GlobalConstants.testEnvironment,
//                        GlobalConstants.currentTestAPIGroupName,
//                        GlobalConstants.currentTestAPI,
//                        testCaseName);
//        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
//        queryParams.put("q", currentTsJsonObject.get("q"));
//        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
//        authenticatedGalleryEndpoint +=
//                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
//    }
//
//    @Then("^API Response is extracted$")
//    public void apiResponseIsExtracted() {
//        // Need to set Proxy if connected to Safeway Network
//        setProxy();
//        setSslConfig();
//        // Invoke the service
//        response =
//                invokeService(
//                        HTTPMethod.GET,
//                        authenticatedGalleryEndpoint,
//                        null,
//                        null,
//                        headerParams,
//                        null,
//                        GlobalConstants.GetCallArgs.HEADERPARAM.toString(),
//                        null,
//                        null);
//
//    }
//
//    @And("^API Response is asserted for Bad Request Status Code$")
//    public void apiResponseIsAssertedForBadRequestStatusCode(){
//        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
//    }
//
//    @And("^API Response is asserted for Internal Server Error$")
//    public void apiResponseIsAssertedForInternalServerError() {
//        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_INTERNAL_SERVER_ERROR);
//    }
//
//    @When("^Business User searches offers using Partial Parameters$")
//    public void businessUserSearchesOffersUsingPartialParameters(List<String> methodName) {
//        testCaseName = methodName.get(0);
//        currentTsDataRowsJsonArray =
//                dataExtractor.getJSONParseTestData(
//                        GlobalConstants.testEnvironment,
//                        GlobalConstants.currentTestAPIGroupName,
//                        GlobalConstants.currentTestAPI,
//                        testCaseName);
//        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
//        queryParams.put("q", currentTsJsonObject.get("q"));
//        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
//        authenticatedGalleryEndpoint +=
//                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
//    }
//
//    @When("^Business User searches offers using Invalid Parameters$")
//    public void businessUserSearchesOffersUsingInvalidParameters(List<String> methodName) {
//        testCaseName = methodName.get(0);
//        currentTsDataRowsJsonArray =
//                dataExtractor.getJSONParseTestData(
//                        GlobalConstants.testEnvironment,
//                        GlobalConstants.currentTestAPIGroupName,
//                        GlobalConstants.currentTestAPI,
//                        testCaseName);
//        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
//        queryParams.put("q", currentTsJsonObject.get("q"));
//        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
//        authenticatedGalleryEndpoint +=
//                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
//    }
//    @And("^API Response is asserted for NOT FOUND status code$")
//    public void apiResponseIsAssertedForNOTFOUNDStatusCode(){
//        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_NOT_FOUND);
//        //Assert.assertEquals(response.getStatusCode(),HttpStatus.SC
//    }
//
//    @When("^Business User searches offers using Special Character Values$")
//    public void businessUserSearchesOffersUsingSpecialCharacterValues(List<String> methodName) {
//        testCaseName = methodName.get(0);
//        currentTsDataRowsJsonArray =
//                dataExtractor.getJSONParseTestData(
//                        GlobalConstants.testEnvironment,
//                        GlobalConstants.currentTestAPIGroupName,
//                        GlobalConstants.currentTestAPI,
//                        testCaseName);
//        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
//        queryParams.put("q", currentTsJsonObject.get("q"));
//        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
//        authenticatedGalleryEndpoint +=
//                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
//    }
//
//    @And("^API Response is asserted for User Friendly message$")
//    public void apiResponseIsAssertedForUserFriendlyMessage() {
//        JsonPath jsonPathEvaluator = response.jsonPath();
//        String actual = jsonPathEvaluator.get("message");
//        Assert.assertFalse(actual.contains("Query; CQL [SELECT offer_id,"));
//    }
//
//    @When("^Business User searches offers using Unavaialable parameters$")
//    public void businessUserSearchesOffersUsingUnavaialableParameters(List<String> methodName) {
//        testCaseName = methodName.get(0);
//        currentTsDataRowsJsonArray =
//                dataExtractor.getJSONParseTestData(
//                        GlobalConstants.testEnvironment,
//                        GlobalConstants.currentTestAPIGroupName,
//                        GlobalConstants.currentTestAPI,
//                        testCaseName);
//        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
//        queryParams.put("q", currentTsJsonObject.get("q"));
//        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
//        authenticatedGalleryEndpoint +=
//                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
//    }
//
//    @When("^Business User searches offers using WRONG storeID$")
//    public void businessUserSearchesOffersUsingWRONGStoreID(List<String> methodName) {
//        testCaseName = methodName.get(0);
//        currentTsDataRowsJsonArray =
//                dataExtractor.getJSONParseTestData(
//                        GlobalConstants.testEnvironment,
//                        GlobalConstants.currentTestAPIGroupName,
//                        GlobalConstants.currentTestAPI,
//                        testCaseName);
//        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
//        queryParams.put("q", currentTsJsonObject.get("q"));
//        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
//        authenticatedGalleryEndpoint +=
//                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER + currentTsJsonObject.get("q");
//    }
//
//    @And("^API Response is asserted for NOT ACCEPTABLE status code$")
//    public void apiResponseIsAssertedForNOTACCEPTABLEStatusCode(){
//        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_ACCEPTABLE);
//    }
//
//    @When("^Business User searches offers using Missing Parameters$")
//    public void businessUserSearchesOffersUsingMissingParameters(List<String> methodName) throws UnsupportedEncodingException {
//        testCaseName = methodName.get(0);
//        currentTsDataRowsJsonArray =
//                dataExtractor.getJSONParseTestData(
//                        GlobalConstants.testEnvironment,
//                        GlobalConstants.currentTestAPIGroupName,
//                        GlobalConstants.currentTestAPI,
//                        testCaseName);
//        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
//        queryParams.put("q", currentTsJsonObject.get("q"));
//        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
//        authenticatedGalleryEndpoint +=
//                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
//    }
//
//
//    @When("^Business User searches offers using Lengthy Values$")
//    public void businessUserSearchesOffersUsingLengthyValues(List<String> methodName) throws UnsupportedEncodingException {
//        testCaseName = methodName.get(0);
//        currentTsDataRowsJsonArray =
//                dataExtractor.getJSONParseTestData(
//                        GlobalConstants.testEnvironment,
//                        GlobalConstants.currentTestAPIGroupName,
//                        GlobalConstants.currentTestAPI,
//                        testCaseName);
//        currentTsJsonObject = (JSONObject) currentTsDataRowsJsonArray.get(0);
//        queryParams.put("q", currentTsJsonObject.get("q"));
//        headerParams.put(GlobalConstants.CACHECONTROL, "no-cache");
//        authenticatedGalleryEndpoint +=
//                ResourceEndpointUri.OFFER_SEARCH + ResourceEndpointUri.QUERY_DELIMITER +URLEncoder.encode(currentTsJsonObject.get("q").toString(),"UTF-8");
//    }
//
//}
//
