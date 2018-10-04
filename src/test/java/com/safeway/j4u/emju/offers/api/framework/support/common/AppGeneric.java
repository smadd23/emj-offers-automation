package com.safeway.j4u.emju.offers.api.framework.support.common;

import com.relevantcodes.extentreports.LogStatus;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;
import com.safeway.j4u.emju.offers.api.framework.support.reportgeneration.ExtentTestManager;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.testng.Reporter;

/** Created by Kiran on 8/19/2017. */
public class AppGeneric {

  public GlobalConstants globalConstants = new GlobalConstants();

  public AppGeneric() {}

  /**
   * Current method is to assign details of test step.
   *
   * @param testStepName is to log the test step of execution.
   * @param testStepPassDetails when test cases pass.
   * @param testStepFailDetails when test case fails.
   * @throws Exception upon exception.
   */
  public void assignDetails(
      String testStepName, String testStepPassDetails, String testStepFailDetails)
      throws Exception {
    globalConstants.stepDescription = testStepName;
    globalConstants.stepPassActual = testStepPassDetails;
    globalConstants.stepFailActual = testStepFailDetails;
  }

  /**
   * Current method is to generate Extent Report for execution.
   *
   * @param testStepStatus provides the status update of each test step.
   * @param testName provides the test name.
   * @throws Exception throws exception.
   */
  public void generateExtentReport(String testStepStatus, String testName) throws Exception {

    if (testStepStatus.equalsIgnoreCase("Pass")) {
      ExtentTestManager.getTest()
          .log(LogStatus.PASS, globalConstants.stepDescription, globalConstants.stepPassActual);
      Reporter.log(globalConstants.stepDescription + "@@@" + globalConstants.stepPassActual);
    } else if (testStepStatus.equalsIgnoreCase("Fail")) {
      ExtentTestManager.getTest()
          .log(LogStatus.FAIL, globalConstants.stepDescription, globalConstants.stepFailActual);
    } else if (testStepStatus.equalsIgnoreCase("Info")) {
      ExtentTestManager.getTest()
          .log(LogStatus.INFO, globalConstants.stepDescription, globalConstants.stepPassActual);
      Reporter.log(globalConstants.stepDescription + "@@@" + globalConstants.stepPassActual);
    } else if (testStepStatus.equalsIgnoreCase("Skip")) {
      ExtentTestManager.getTest()
          .log(LogStatus.SKIP, globalConstants.stepDescription, globalConstants.stepPassActual);
      Reporter.log(globalConstants.stepDescription + "@@@" + globalConstants.stepPassActual);
    }
  }

  /**
   * Current method gets the current system OS.
   *
   * @return the OS type.
   * @throws Exception upon exception.
   */
  public String gethostsysos() throws Exception {

    if (System.getProperty("os.name").indexOf("Mac") >= 0) {
      globalConstants.hostOsName = "MAC";
    } else if (System.getProperty("os.name").indexOf("Windows") >= 0) {
      globalConstants.hostOsName = "WINDOWS";
    } else if (System.getProperty("os.name").indexOf("nux") >= 0) {
      globalConstants.hostOsName = "LINUX";
    } else if (System.getProperty("os.name").indexOf("nix") >= 0) {
      globalConstants.hostOsName = "UNIX";
    }
    return (globalConstants.hostOsName);
  }

  /**
   * Gets the Computer name.
   *
   * @return the computer name.
   * @throws Exception if unable to find.
   */
  public String getComputerName() throws Exception {

    String hostname = "Unknown";
    try {
      InetAddress addr;
      addr = InetAddress.getLocalHost();
      hostname = addr.getHostName();
    } catch (UnknownHostException ex) {
      ex.fillInStackTrace();
      System.out.println("Hostname can not be resolved");
    }
    return (hostname);
  }
}
