package com.safeway.j4u.emju.offers.api.cucumberStepDefinitions;

import com.safeway.j4u.emju.offers.api.framework.support.common.BaseApiTest;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

public class FacetCountParentChildParams extends BaseApiTest {

  @When("^User ([^\"]*) multiple Offers with different categorries$")
  public void userLoadsMultipleOffersWithDifferentCategorries(String methodName)  {

            testCaseName = methodName;
    }
}
