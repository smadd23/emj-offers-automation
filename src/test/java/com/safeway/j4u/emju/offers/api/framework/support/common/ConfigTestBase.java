package com.safeway.j4u.emju.offers.api.framework.support.common;

import com.relevantcodes.extentreports.LogStatus;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.reportgeneration.ExtentManager;
import com.safeway.j4u.emju.offers.api.framework.support.reportgeneration.ExtentTestManager;

import io.restassured.RestAssured;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.*;

/** Base class with test configuration for environment, test data and reports. */
public class ConfigTestBase {

  public AppGeneric appGeneric;
  public Generic generic;
  public DataExtractor dataExtractor;
  public GlobalConstants globalConstants;
  private String environment = null;
  private String currentApiGroupName = null;
  private String currentApiName = null;

  /**
   * Initialize the test suite.
   *
   * @param environment system under test
   * @param currentApiGroupName rest api group name
   * @param currentApiName rest api name
   * @throws Exception if any system details cannot be retrieved
   */
  @Parameters({"currentTestEnvironment", "apiGroupName", "apiName"})
  @BeforeClass
  public void setupSuite(String environment, String currentApiGroupName, String currentApiName)
      throws Exception {
    appGeneric = new AppGeneric();
    generic = new Generic();
    dataExtractor = new DataExtractor();
    globalConstants = new GlobalConstants();
    // Set Proxy for Safeway VDI Machines to run Rest-Assured Test Scripts
    if (appGeneric.gethostsysos().equalsIgnoreCase("windows")) {
      if (!(appGeneric.getComputerName().contains("CSC"))) {
        RestAssured.proxy("xphxbc02-int.safeway.com", Integer.parseInt("8080"));
      }
    }
    this.environment = environment;
    if (this.environment != null) { // through jenkins execution
      this.environment = environment;
      this.currentApiGroupName = currentApiGroupName;
      this.currentApiName = currentApiName;
      GlobalConstants.testEnvironment = this.environment;
      GlobalConstants.currentTestAPIGroupName = this.currentApiGroupName;
      GlobalConstants.currentTestAPI = this.currentApiName;
    } else { // through local execution
      GlobalConstants.testEnvironment = environment;
      GlobalConstants.currentTestAPIGroupName = currentApiGroupName;
      GlobalConstants.currentTestAPI = currentApiName;
    }
  }

  /**
   * Initialize the extent report before each test method.
   *
   * @param method instance of the {@code Method.class} }
   */
  @BeforeMethod
  public void setupReport(Method method) {
    ExtentTestManager.startTest(method.getName());
  }

  /**
   * Holds results parameters.
   *
   * @param result of each test case.
   */
  @AfterMethod
  protected void afterMethod(ITestResult result) {
//    if (result.getStatus() == ITestResult.FAILURE) {
//      ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed", result.getThrowable());
//    } else if (result.getStatus() == ITestResult.SKIP) {
//      ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped", result.getThrowable());
//    } else {
//      ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed", "Test passed");
//    }

//    ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
//    ExtentManager.getReporter().flush();
  }

  /**
   * Current method is to Print the Stack trace of a thrown Exception.
   *
   * @param t holds the throwable exception.
   * @return
   */
  protected String getStackTrace(Throwable t) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    t.printStackTrace(pw);
    return sw.toString();
  }
}
