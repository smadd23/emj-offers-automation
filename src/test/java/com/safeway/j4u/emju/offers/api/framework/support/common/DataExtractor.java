package com.safeway.j4u.emju.offers.api.framework.support.common;

import static org.testng.AssertJUnit.fail;

import java.io.File;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;

/** Created by Kiran on 8/26/2017. */
public class DataExtractor {

  public JSONObject currentTestDataJSONObj = null;
  public JSONObject currentEnvTokenDataJSONObj = null;
  public JSONArray currentTSTestDataArray = null;
  public JSONObject currentEnvAppAuthDataJSONObj = null;
  private AppGeneric appGeneric = new AppGeneric();

  /**
   * Description: Get Test Data from the respective JSON file for test script under execution.
   *
   * @param testEnvironment
   * @param apiGroupName
   * @param apiName
   * @param testScriptName
   * @return JSON Array for selected environment
   * @throws Exception
   */
  public JSONArray getJSONParseTestData(
      String testEnvironment, String apiGroupName, String apiName, String testScriptName) {

    String filePath = null;
    // Get current OS Name and path for Test Data
    try {
      if (appGeneric.gethostsysos().equalsIgnoreCase("mac")) {
        filePath =
            GlobalConstants.testDataFilePathMac
                + apiGroupName
                + "//"
                + apiName.toUpperCase()
                + ".json";
      } else if (appGeneric.gethostsysos().equalsIgnoreCase("windows")) {
        filePath =
            GlobalConstants.testDataFilePathWindows
                + apiGroupName
                + "\\"
                + apiName.toUpperCase()
                + ".json";
      } else if ((appGeneric.gethostsysos().equalsIgnoreCase("linux"))
          || (appGeneric.gethostsysos().equalsIgnoreCase("unix"))) {
        filePath = GlobalConstants.testDataFilePathLinux + apiGroupName + "/" + apiName + ".json";
      }
      // read the json file
      FileReader reader = new FileReader(filePath);
      JSONParser jsonParser = new JSONParser();
      JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
      // handle a structure into the json object
      currentTestDataJSONObj = (JSONObject) jsonObject.get(testEnvironment);
      currentTSTestDataArray = (JSONArray) currentTestDataJSONObj.get(testScriptName);
    } catch (Exception e) {
      fail(e.getMessage());
    }
    return (currentTSTestDataArray);
  }

  /**
   * Description: Get Test Data from the respective JSON file for test script under execution
   * irrespective of Environment
   *
   * @param apiGroupName
   * @param apiName
   * @param testScriptName
   * @return
   * @throws Exception
   */
  public JSONArray getJSONParseTestDataEnvFree(
      String apiGroupName, String apiName, String testScriptName) {

    String filePath = null;
    // Get current OS Name and path for Test Data
    try {
      if (appGeneric.gethostsysos().equalsIgnoreCase("mac")) {
        filePath =
            GlobalConstants.testDataFilePathMac
                + apiGroupName
                + "//"
                + apiName.toUpperCase()
                + ".json";
      } else if (appGeneric.gethostsysos().equalsIgnoreCase("windows")) {
        filePath =
            GlobalConstants.testDataFilePathWindows
                + apiGroupName
                + "\\"
                + apiName.toUpperCase()
                + ".json";
      } else if ((appGeneric.gethostsysos().equalsIgnoreCase("linux"))
          || (appGeneric.gethostsysos().equalsIgnoreCase("unix"))) {
        filePath = GlobalConstants.testDataFilePathLinux + apiGroupName + "/" + apiName + ".json";
      }
      // read the json file
      FileReader reader = new FileReader(filePath);
      JSONParser jsonParser = new JSONParser();
      JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

      // handle a structure into the json object
      currentTSTestDataArray = (JSONArray) jsonObject.get(testScriptName);
    } catch (Exception e) {
      fail(e.getMessage());
    }
    return (currentTSTestDataArray);
  }

  /**
   * Description: Get the Token Information based on Environment
   *
   * @param testEnvironment
   * @param apiGroupName
   * @param apiName
   * @return
   * @throws Exception
   */
  public JSONObject getJSONParseTokenTestData(
      String testEnvironment, String apiGroupName, String apiName) {
    try {
      String filePath = null;
      // Get current OS Name and path for Test Data
      if (appGeneric.gethostsysos().equalsIgnoreCase("mac")) {
        filePath =
            GlobalConstants.testDataFilePathMac
                + apiGroupName
                + "//"
                + apiName.toUpperCase()
                + ".json";
      } else if (appGeneric.gethostsysos().equalsIgnoreCase("windows")) {
        filePath =
            GlobalConstants.testDataFilePathWindows
                + apiGroupName
                + "\\"
                + apiName.toUpperCase()
                + ".json";
      } else if ((appGeneric.gethostsysos().equalsIgnoreCase("linux"))
          || (appGeneric.gethostsysos().equalsIgnoreCase("unix"))) {
        filePath = GlobalConstants.testDataFilePathLinux + apiGroupName + "/" + apiName + ".json";
      }
      // read the json file
      FileReader reader = new FileReader(filePath);
      JSONParser jsonParser = new JSONParser();
      JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
      // handle a structure into the json object
      currentEnvTokenDataJSONObj = (JSONObject) jsonObject.get(testEnvironment);
    } catch (Exception e) {
      fail(e.getMessage());
    }
    return (currentEnvTokenDataJSONObj);
  }

  public String getTestEnvironmentEndPoint(String testEnvironment) {
    switch (testEnvironment.toUpperCase()) {
      case "DEV":
        GlobalConstants.endPoint = "https://emju-offers-dev.apps.np.stratus.albertsons.com/api";
        break;
      case "QAI":
        GlobalConstants.endPoint = "https://nimbus-qi.safeway.com";
        break;
      case "QA1":
        GlobalConstants.endPoint = "https://api-qa1.safeway.com/abs/qa1pub/web";
        break;
      case "QA2":
        GlobalConstants.endPoint = "https://nimbus-qa1.safeway.com";
        break;
      case "PERF":
        GlobalConstants.endPoint = "https://nimbus-prf.safeway.com";
        break;
      case "PROD":
        GlobalConstants.endPoint = "https://api-prod.safeway.com/abs/pub/web";
        break;
      case "QA":
        GlobalConstants.endPoint = "https://b2bgw-qa.safeway.com";
        break;
      case "LOY_QI":
        GlobalConstants.endPoint = "https://ngcp-qi.safeway.com";
        break;
      case "UCA_QI":
        GlobalConstants.endPoint = "https://api-dvpub.albertsons.com/abs/dvpub";
        break;
    }
    return GlobalConstants.endPoint;
  }
  /**
   * Description: Builds file path based on OS
   *
   * @param bodyDataFolderPath
   * @param bodyDatafileName
   * @return
   * @throws Exception
   */
  public File getBodyDataFile(
      String bodyDataFolderPath, String testEnvironment, String bodyDatafileName) throws Exception {
    File bodyDataFile = null;
    try {
      String bodyDataFilePath =
          GlobalConstants.testDataFilePathWindows
              + "\\"
              + bodyDataFolderPath
              + "\\"
              + testEnvironment.toLowerCase()
              + "\\"
              + bodyDatafileName;

      // Get current OS Name and path for Test Data
      if (appGeneric.gethostsysos().equalsIgnoreCase("mac")) {
        bodyDataFilePath = bodyDataFilePath.replaceAll("\\\\", "//");
        bodyDataFile = new File(bodyDataFilePath);
      } else if (appGeneric.gethostsysos().equalsIgnoreCase("windows")) {
        bodyDataFile = new File(bodyDataFilePath);
      } else if ((appGeneric.gethostsysos().equalsIgnoreCase("linux"))
          || (appGeneric.gethostsysos().equalsIgnoreCase("unix"))) {
        bodyDataFilePath = bodyDataFilePath.replaceAll("\\\\", "/");
        bodyDataFile = new File(bodyDataFilePath);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return (bodyDataFile);
  }

    /**
     * Description: Get the application authentication (clientID/secret) based on Environment
     *
     * @param testEnvironment
     * @param serviceGroupName
     * @param serviceFileName
     * @return
     * @throws Exception
     */
    public JSONObject getJSONParseAppAuthenticationData(
            String testEnvironment, String serviceGroupName, String serviceFileName) {
        try {
            String filePath = null;
            // Get current OS Name and path for Test Data
            if (appGeneric.gethostsysos().equalsIgnoreCase("mac")) {
                filePath =
                        GlobalConstants.testDataFilePathMac
                                + serviceGroupName
                                + "//"
                                + serviceFileName.toUpperCase()
                                + ".json";
            } else if (appGeneric.gethostsysos().equalsIgnoreCase("windows")) {
                filePath =
                        GlobalConstants.testDataFilePathWindows
                                + serviceGroupName
                                + "\\"
                                + serviceFileName.toUpperCase()
                                + ".json";
            } else if ((appGeneric.gethostsysos().equalsIgnoreCase("linux"))
                    || (appGeneric.gethostsysos().equalsIgnoreCase("unix"))) {
                filePath = GlobalConstants.testDataFilePathLinux + serviceGroupName + "/" + serviceFileName + ".json";
            }
            // read the json file
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            // handle a structure into the json object
            currentEnvAppAuthDataJSONObj = (JSONObject) jsonObject.get(testEnvironment);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        return (currentEnvAppAuthDataJSONObj);
    }
}
