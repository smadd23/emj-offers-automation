package com.albertsons.api.cucumberStepDefinitions;

import com.albertsons.api.framework.support.common.BaseApiTest;
import com.albertsons.api.framework.support.constants.GlobalConstants;
import com.google.appengine.api.urlfetch.HTTPMethod;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class MandatoryFiledscheck extends BaseApiTest {
    public Response response = null;
    String scenarioName = null;

    @Before
    public void before(Scenario sc) {
        scenarioName = sc.getName();
        System.out.println("Scenario Name:" + scenarioName);
    }

    @When("^Business user loads null or irrelevant data in mandatory fields$")
    public void userchecksmandatoryfileds(List<String> testdatafile) {
        apiEndPoint ="https://offers.apps.np.stratus.albertsons.com/api/offers";
        headerParams = new HashMap<String, Object>();
        headerParams.put(GlobalConstants.CONTENTTYPE, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
        headerParams.put(GlobalConstants.ACCEPT, GlobalConstants.APPLICATION_VND_V1.toUpperCase());
        setProxy();
        setSslConfig();
        for (int i = 0; i < testdatafile.size(); i++) {

            File bodyFile = new File(JSON_BODYDATA_PATH + testdatafile.get(i).toString());
            response =
                    invokeService(
                            HTTPMethod.POST,
                            apiEndPoint,
                            null,
                            null,
                            headerParams,
                            null,
                            GlobalConstants.GetCallArgs.HEADERPARAM.toString(),
                            null,
                            bodyFile);
        }

    }



    @Then("^ API Response is asserted as Status Code Bad Request$")
    public void apiResponseIsAssertedAsStatusCodeBadRequest() {
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    }
}
