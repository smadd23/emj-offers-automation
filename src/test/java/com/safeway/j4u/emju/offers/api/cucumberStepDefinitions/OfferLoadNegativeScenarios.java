package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.google.appengine.api.urlfetch.HTTPMethod;
import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfferLoadNegativeScenarios extends BaseApiTest {

    @When("^Business user loads unsupported data file$")
    public void businesUserLoadsUnSupportedData(List<String> methodName) {
       setTestCaseName(methodName.get(0));
    }

    @Test()
    @And("^API Response is asserted as Status Code Bad Request$")
    public void assertStatusCode() {
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test()
    @And("^API Response is asserted as Status Code Server Error$")
    public void assertStatusCodeasError() {
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    @When("^Business user loads Offer with null AggregateOfferId$")
    public void businessUserLoadsOfferwithNullAggregateOfferId(List<String> methodName) {
        setTestCaseName(methodName.get(0));
    }
    @When("^Business user loads offer with null ExternalOfferId$")
    public void businessUserLoadsDataWithNullExternalOfferId(List<String> methodName) {
        setTestCaseName(methodName.get(0));
    }
    @When("^Business User loads data with null offerstatus$")
    public void businessUserLoadsDataWithNullOfferStatus(List<String> methodName) {
        testCaseName = methodName.get(0);
    }

    @When("^Business User loads data with null programcode$")
    public void businessUserLoadsDataWithNullProgramCode(List<String> methodName) {
        testCaseName = methodName.get(0);
    }

    @When("^Business User loads data with SpecialCharectors for AggregateOfferID$")
    public void businessUserLoadsDataWithSpecialCharectorsforAggregateOfferId(List<String> methodName) {
        testCaseName = methodName.get(0);
    }
    @When("^Business User loads data with SpecialCharectors for ExternalOfferID$")
    public void businessUserLoadsDataWithSpecialCharectorsforExternalOfferId(List<String> methodName) {
        testCaseName = methodName.get(0);
    }
    @When("^Business User loads data  SpecialCharectors for OfferStatus$")
    public void businessUserLoadsDataWithSpecialCharectorsForOfferStatus(List<String> methodName) {
        setTestCaseName(methodName.get(0));
    }

    @When("^Business User loads data with SpecialCharectors for Programcode$")
    public void businessUserLoadsDataWithSpecialCharectorsforProgramCode(List<String> methodName) {
        setTestCaseName(methodName.get(0));
    }


}
