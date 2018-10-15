package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import java.util.List;
import java.util.Map;

public class OfferLoadPostiveScenarios extends BaseApiTest {

  private String testCaseName;
  public Response response;
  private Map<String, String> env;


  @When("^Business User loads data with offerstatus A$")
  public void businessUserLoadsDataWithOfferStatusA(List<String> methodName) {
    setTestCaseName(methodName.get(0));
  }

  @When("^Business User loads data with offerstatus A with Future dates$")
  public void businessUserLoadsDataWithOfferStatusAWithFutureDates(List<String> methodName) {
    setTestCaseName(methodName.get(0));
  }
  @When("^Business User loads data with offerstatus D$")
  public void businessUserLoadsDataWithOfferStatusD(List<String> methodName) {
    setTestCaseName(methodName.get(0));
  }

  @When("^Business User loads data with offerstatus E$")
  public void businessUserLoadsDataWithOfferStatusE(List<String> methodName) {
    setTestCaseName(methodName.get(0));

  }
  @When("^Business User loads data with offerstatus L$")
  public void businessUserLoadsDataWithOfferStatusL(List<String> methodName) {
    setTestCaseName(methodName.get(0));
  }


}