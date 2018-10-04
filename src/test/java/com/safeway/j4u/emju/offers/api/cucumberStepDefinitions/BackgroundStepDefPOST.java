package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.google.appengine.api.urlfetch.HTTPMethod;
import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices.OfferSearch;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java8.En;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackgroundStepDefPOST extends BaseApiTest {
    private Map<String, String> env = new HashMap<>();
    String testCaseName;
    OfferSearch offerSearchExpected, offerSearchActual;

    /** Initialize before each test. */
  @BeforeClass(alwaysRun = true)
  @Given("^The Test Environment is Defined$")
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
    queryParams = new HashMap<>();
    authenticatedGalleryEndpoint =
        dataExtractor.getTestEnvironmentEndPoint(GlobalConstants.testEnvironment);
    headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
    headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
    authenticatedGalleryEndpoint += ResourceEndpointUri.OFFER_SEARCH;
  }

  @Then("^API Response is extracted for POST call$")
  public void apiResponseIsExtractedPOST() {
    File bodyFile = new File(JSON_BODYDATA_PATH + getTestCaseName());
    response =
            invokeService(
                    HTTPMethod.POST,
                    authenticatedGalleryEndpoint,null,
                    null,headerParams,null,
                    GlobalConstants.GetCallArgs.HEADERPARAM.toString(),
                    null,
                    bodyFile);
  }

  @And("^API Response is asserted for Created Status Code$")
  public void assertStatusCode() {
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
  }

  @Then("^API Response is extracted$")
  public void apiResponseIsExtracted() {
    // Need to set Proxy if connected to Safeway Network
    setProxy();
    setSslConfig();
    // Invoke the service
    response =
            invokeService(
                    HTTPMethod.GET,
                    authenticatedGalleryEndpoint,null,null,headerParams,null,
                    GlobalConstants.GetCallArgs.HEADERPARAM.toString(),
                    null,
                    null);

  }

  @And("^API Response is asserted for Success Status Code$")
  public void assertStatusCodeGet(){
    Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);
  }
  @And("^API Response is asserted for ALL attributes$")
  public void apiResponseIsAssertedForALLAttributes(List<String> fileName){
    String resourcePath = fileName.get(0);
    String filePath1 = JSON_RESPONSE_PATH + "offerSearch/"+resourcePath+".json";
    String filePath2 = null;
    String expectedJsonString =
            getComplexJsonAsString(filePath1);
    offerSearchExpected = stringToPojo(expectedJsonString, OfferSearch.class);
    String toWrite = response.getBody().asString();
    try{
      File tmpFile = File.createTempFile("test", ".json", new File(JSON_RESPONSE_PATH+"offerSearch/"));
      FileWriter writer = new FileWriter(tmpFile);
      writer.write(toWrite);
      writer.close();
      filePath2 = tmpFile.getAbsolutePath();
    }catch(Exception e){
      e.printStackTrace();
    }
    String actualJsonString = getComplexJsonAsString(filePath2);
    offerSearchActual = stringToPojo(actualJsonString,OfferSearch.class);
    Assert.assertTrue(offerSearchActual.equals(offerSearchExpected));
  }
}
