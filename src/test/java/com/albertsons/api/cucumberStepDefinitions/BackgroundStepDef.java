package com.albertsons.api.cucumberStepDefinitions;

import com.albertsons.api.framework.support.common.BaseApiTest;
import com.albertsons.api.framework.support.constants.GlobalConstants;
import cucumber.api.java.en.Given;

import java.util.List;

public class BackgroundStepDef extends BaseApiTest {
    public String[] data = new String[3];

    @Given("^The Test Environment is Defined for POST call$")
    public void theTestEnvironmentIsDefined(List<List<String>> testdatafile) throws Throwable {

        for (int i = 0; i < testdatafile.size(); i++) {
            data[i] = testdatafile.get(i).get(1).toString();
            }
        GlobalConstants.testEnvironment=data[0];
        GlobalConstants.currentTestAPIGroupName=data[1];
        GlobalConstants.currentTestAPI=data[2];
    }
}