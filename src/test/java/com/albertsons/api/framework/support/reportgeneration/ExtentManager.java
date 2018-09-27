package com.albertsons.api.framework.support.reportgeneration;

import com.relevantcodes.extentreports.ExtentReports;

/** Created by kedupuganti on 8/18/2017. */
public class ExtentManager {

  static final String filePath = "APITestExecutionReport.html";
  static ExtentReports extent;

  public static synchronized ExtentReports getReporter() {
    if (extent == null) {
      extent = new ExtentReports(filePath, true);
    }

    return extent;
  }
}
