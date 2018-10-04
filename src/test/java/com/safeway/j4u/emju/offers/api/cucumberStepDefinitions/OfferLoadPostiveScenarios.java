package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.google.appengine.api.urlfetch.HTTPMethod;
import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices.OfferSearch;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfferLoadPostiveScenarios extends BaseApiTest {

  private String testCaseName;
  public Response response;
  private Map<String, String> env;


  @When("^Business User loads data with offerstatus A$")
  public void businessUserLoadsDataWithOfferStatusA(List<String> methodName) {
    testCaseName = methodName.get(0);
  }

  @When("^Business User loads data with offerstatus A with Future dates$")
  public void businessUserLoadsDataWithOfferStatusAWithFutureDates(List<String> methodName) {
    testCaseName = methodName.get(0);
  }
  @When("^Business User loads data with offerstatus D$")
  public void businessUserLoadsDataWithOfferStatusD(List<String> methodName) {
    testCaseName = methodName.get(0);
  }

  @When("^Business User loads data with offerstatus E$")
  public void businessUserLoadsDataWithOfferStatusE(List<String> methodName) {
    testCaseName = methodName.get(0);

  }
  @When("^Business User loads data with offerstatus L$")
  public void businessUserLoadsDataWithOfferStatusL(List<String> methodName) {
    testCaseName = methodName.get(0);
  }

  @When("^Business User loads <ALL> offers with offerstatus A$")
  public void businessUserLoadsALLOffersWithOfferstatusA(List<String> methodName) {testCaseName = methodName.get(0);}
//  @When("^User loads maximum no of offers using the Offer Load API$")
//  public void businessUserLoadsDataWithMaxnoofOffers(List<String> methodName) {
//    testCaseName = methodName.get(0);
//  }

}