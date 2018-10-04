package com.safeway.j4u.emju.offers.api.framework.support.common;

import static com.safeway.j4u.emju.offers.api.framework.support.constants.ResourceEndpointUri.SLASH_DELIMITER;
import static io.restassured.RestAssured.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.repackaged.com.google.gson.JsonObject;
import com.google.appengine.repackaged.com.google.gson.JsonParser;
import com.safeway.j4u.emju.offers.api.framework.support.constants.GlobalConstants;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

/** Class contains all operations related to RestAssured Calls. */
public class BaseApiTest extends ConfigTestBase {

  protected static final String JSON_SCHEMA_PATH = "./src/test/resources/testdata/jsonschema/";
  protected static final String JSON_RESPONSE_PATH = "./src/test/resources/testdata/response/";
  protected static final String JSON_BODYDATA_PATH = "./src/test/resources/testdata/bodydata/";
  protected String tokenId = null;
  protected JSONObject tokenJsonDataObj;
  protected JSONArray currentTsDataRowsJsonArray;
  protected JSONArray currentResDataRowsJsonArray;
  protected JSONObject currentTsJsonObject;
  protected JSONObject appAuthEnvDataJsonObject;
  protected String expectedJsonString;
  protected static  String authenticatedGalleryEndpoint;
  protected String apiEndPoint;
  protected JsonObject expectedJsonObject;
  protected JsonObject actualJsonObject;
  protected JsonParser jsonParser;
  protected static Map<String, Object> queryParams;
  protected static Map<String, Object> headerParams;
  protected Map<String, Object> formParams;
  protected Map<String, Object> pathParams;
  protected List<String> pathParam;
  protected List<String> pathParamsNames;
  protected static String testCaseName;
  public static Response response = null;
  /**
   * Invokes the service using Rest-Assured API's.
   *
   * @param methodType the httpd method type
   * @param restServiceUri the endpoint uri
   * @param queryParams the query params
   * @param pathParams the path params
   * @param headerParams the header params
   * @param getCallParamsProcess the get call param enum type
   * @param pathParamsNames the path params name
   * @param bodyDataFile the request body
   * @return the response from the endpoint
   */
  public Response invokeService(
      HTTPMethod methodType,
      String restServiceUri,
      Map<String, Object> queryParams,
      Map<String, Object> pathParams,
      Map<String, Object> headerParams,
      Map<String, Object> formParams,
      String getCallParamsProcess,
      List<String> pathParamsNames,
      File bodyDataFile) {

    //RestAssured.useRelaxedHTTPSValidation();
    RestAssured.urlEncodingEnabled = false;
    //resetProxy();
    switch (methodType) {
      case GET:
        if (getCallParamsProcess.equalsIgnoreCase("query")) {

          response =
              given().params(queryParams).when().get(restServiceUri).then().extract().response();
        } else if (getCallParamsProcess.equalsIgnoreCase("headers")) {
          response =
              given().headers(headerParams).when().get(restServiceUri).then().extract().response();

        } else if (getCallParamsProcess.equalsIgnoreCase("path")) {
          // Below is the method call to append {storeId} to RequestURI
          restServiceUri = buildPathParameter(restServiceUri, pathParamsNames);
          response =
              given().pathParams(pathParams).when().get(restServiceUri).then().extract().response();
        } else if (getCallParamsProcess.equalsIgnoreCase("QueryHeaders")) {
          response =
              given()
                  .params(queryParams)
                  .proxy(restServiceUri)
                  .headers(headerParams)
                  .when()
                  .get(restServiceUri)
                  .then()
                  .extract()
                  .response();
        } else if (getCallParamsProcess.equalsIgnoreCase("QueryPath")) {
          // Below is the method call to append {storeId} to RequestURI
          restServiceUri = buildPathParameter(restServiceUri, pathParamsNames);
          response =
              given()
                  .params(queryParams)
                  .pathParams(pathParams)
                  .when()
                  .get(restServiceUri)
                  .then()
                  .extract()
                  .response();
        } else if (getCallParamsProcess.equalsIgnoreCase("PathHeaders")) {
          // Below is the method call to append {storeId} to RequestURI
          restServiceUri = buildPathParameter(restServiceUri, pathParamsNames);
          response =
              given()
                  .pathParams(pathParams)
                  .headers(headerParams)
                  .when()
                  .get(restServiceUri)
                  .then()
                  .extract()
                  .response();
        } else if (getCallParamsProcess.equalsIgnoreCase("AllParams")) {

          // Below is the method call to append {storeId} to RequestURI
          restServiceUri = buildPathParameter(restServiceUri, pathParamsNames);
          response =
              given()
                  .pathParams(pathParams)
                  .params(queryParams)
                  .headers(headerParams)
                  .when()
                  .config(config)
                  .get(restServiceUri)
                  .then()
                  .extract()
                  .response();
        } else if (getCallParamsProcess.equalsIgnoreCase("NoParams")) {
          response = given().proxy(restServiceUri).get(restServiceUri).then().extract().response();
        }
        break;

      case POST:
        if (getCallParamsProcess.equalsIgnoreCase("query")) {
          response =
              given()
                  .queryParams(queryParams)
                  .body(bodyDataFile)
                  .when()
                  .post(restServiceUri)
                  .then()
                  .extract()
                  .response();
        } else if (getCallParamsProcess.equalsIgnoreCase("headers")) {
          response =
              given()
                  .headers(headerParams)
                  .body(bodyDataFile)
                  .when()
                  .post(restServiceUri)
                  .then()
                  .extract()
                  .response();
        } else if (getCallParamsProcess.equalsIgnoreCase("formparams")) {
          response =
              given()
                  .headers(headerParams)
                  .formParams(formParams)
                  .when()
                  .post(restServiceUri)
                  .then()
                  .extract()
                  .response();

        } else if (getCallParamsProcess.equalsIgnoreCase("path")) {
          restServiceUri =
              buildPathParameter(
                  restServiceUri, pathParamsNames); // to build path string in the url
          response =
              given()
                  .pathParams(pathParams)
                  .body(bodyDataFile)
                  .when()
                  .post(restServiceUri)
                  .then()
                  .extract()
                  .response();

        } else if (getCallParamsProcess.equalsIgnoreCase("QueryHeaders")) {

          response =
              given()
                  .headers(headerParams)
                  .queryParams(queryParams)
                  .body(bodyDataFile)
                  .when()
                  .post(restServiceUri)
                  .then()
                  .extract()
                  .response();

        } else if (getCallParamsProcess.equalsIgnoreCase("QueryPath")) {
          restServiceUri =
              buildPathParameter(
                  restServiceUri, pathParamsNames); // to build path string in the url
          response =
              given()
                  .queryParams(queryParams)
                  .pathParams(pathParams)
                  .body(bodyDataFile)
                  .when()
                  .post(restServiceUri)
                  .then()
                  .extract()
                  .response();

        } else if (getCallParamsProcess.equalsIgnoreCase("PathHeaders")) {
          restServiceUri =
              buildPathParameter(
                  restServiceUri, pathParamsNames); // to build path string in the url
          response =
              given()
                  .headers(headerParams)
                  .pathParams(pathParams)
                  .body(bodyDataFile)
                  .when()
                  .post(restServiceUri)
                  .then()
                  .extract()
                  .response();
        }
        break;
      case HEAD:
        break;

      case PUT:
        if (getCallParamsProcess.equalsIgnoreCase("headers")) {
          response =
              given()
                  .headers(headerParams)
                  .body(bodyDataFile)
                  .when()
                  .put(restServiceUri)
                  .then()
                  .extract()
                  .response();
        }
        break;

      case DELETE:
        if (getCallParamsProcess.equalsIgnoreCase("headers")) {
          response =
              given()
                  .headers(headerParams)
                  .when()
                  .delete(restServiceUri)
                  .then()
                  .extract()
                  .response();
        }
        break;

      case PATCH:
        if (getCallParamsProcess.equalsIgnoreCase("query")) {
          response =
              given().queryParams(queryParams).body(bodyDataFile).when().patch(restServiceUri);
        } else if (getCallParamsProcess.equalsIgnoreCase("headers")) {
          response =
              given()
                  .headers(headerParams)
                  .body(bodyDataFile)
                  .when()
                  .patch(restServiceUri)
                  .then()
                  .extract()
                  .response();

        } else if (getCallParamsProcess.equalsIgnoreCase("path")) {
          restServiceUri =
              buildPathParameter(
                  restServiceUri, pathParamsNames); // to build path string in the url
          response = given().pathParams(pathParams).body(bodyDataFile).when().patch(restServiceUri);

        } else if (getCallParamsProcess.equalsIgnoreCase("QueryHeaders")) {

          response =
              given()
                  .headers(headerParams)
                  .queryParams(queryParams)
                  .body(bodyDataFile)
                  .when()
                  .patch(restServiceUri);

        } else if (getCallParamsProcess.equalsIgnoreCase("QueryPath")) {
          restServiceUri =
              buildPathParameter(
                  restServiceUri, pathParamsNames); // to build path string in the url
          response =
              given()
                  .queryParams(queryParams)
                  .pathParams(pathParams)
                  .body(bodyDataFile)
                  .when()
                  .patch(restServiceUri);

        } else if (getCallParamsProcess.equalsIgnoreCase("PathHeaders")) {
          restServiceUri =
              buildPathParameter(
                  restServiceUri, pathParamsNames); // to build path string in the url
          response =
              given()
                  .headers(headerParams)
                  .pathParams(pathParams)
                  .body(bodyDataFile)
                  .when()
                  .patch(restServiceUri);
        }
        break;
      default:
        Assert.fail("Unsupported format");
        break;
    }
    return (response);
  }

  /**
   * Build the path parameter.
   *
   * @param restServiceUri the endpoint uri
   * @param pathParamsNames the path param names
   * @return the endpoint build with path params
   */
  public String buildPathParameter(String restServiceUri, List<String> pathParamsNames) {
    try {

      for (int cnt = 0; cnt < pathParamsNames.size(); cnt++) {
        String decodedVal = getPathParamDecoded(pathParamsNames.get(cnt).toString());
        if (cnt == 0) {
          restServiceUri = restServiceUri + SLASH_DELIMITER + decodedVal;
        } else {
          restServiceUri = restServiceUri + decodedVal + SLASH_DELIMITER;
        }
      }
    } catch (Exception e) {
      Assert.fail(e.getMessage());
    }
    return (restServiceUri);
  }

  /**
   * Return the decoded UTF-8 path param.
   *
   * @param pathParam the path param
   * @return the decoded UTF-8 path param.
   * @throws Exception an unsupported encoding exception
   */
  public String getPathParamDecoded(String pathParam) throws Exception {
    return (URLDecoder.decode(pathParam, "UTF-8"));
  }

  /**
   * Returns true if response content type has json.
   *
   * @param response the response from service
   * @return
   */
  public boolean verifyResponseContentType(Response response) {
    boolean retVal = false;
    if (response.contentType().contains("json")) {
      retVal = true;
    } else {
      retVal = false;
    }
    return (retVal);
  }

  /**
   * Returns token created.
   *
   * @return the auth token
   */
  protected String getAuthToken(String username, String password) {
    tokenJsonDataObj =
        dataExtractor.getJSONParseTokenTestData(
            GlobalConstants.testEnvironment,
            globalConstants.tokenServiceGroupName,
            globalConstants.tokenServiceApiName);
    return (getTokenId(tokenJsonDataObj, username, password));
  }

  /**
   * Gets an authentication based on environment.
   *
   * @param tokenDataJsonObj auth token credential
   * @return the auth token
   */
  private String getTokenId(JSONObject tokenDataJsonObj, String username, String password) {
    RestAssured.reset();
    Response response =
        given()
            .param("username", username)
            .param("password", password)
            .when()
            .post(tokenDataJsonObj.get("uri").toString())
            .then()
            .statusCode(200)
            .extract()
            .response();
    return response.getBody().asString().substring(9).trim();
  }

  /**
   * Gets an authentication from OKTA token based on environment.
   *
   * @param username to use to get token
   * @param password to use to get token
   * @return Token provided by OKTA
   */
  protected String getOktaToken(String username, String password) {
    resetProxy();
    tokenJsonDataObj =
        dataExtractor.getJSONParseTokenTestData(
            GlobalConstants.testEnvironment,
            globalConstants.tokenServiceGroupName,
            globalConstants.tokenServiceApiName);
    switch (GlobalConstants.testEnvironment.toUpperCase()) {
      case "QAI":
        tokenId = getOktaTokenIdQai(tokenJsonDataObj, username, password);
        break;
      default:
        tokenId = getOktaTokenId(tokenJsonDataObj, username, password);
        break;
    }
    return tokenId;
  }

  /**
   * Method to implement retrieval of token from OKTA.
   *
   * @param tokenDataJsonObj is the JSON object parsed
   * @param username to use to get token
   * @param password to use to get token
   * @return token parsed from response.
   */
  private String getOktaTokenId(JSONObject tokenDataJsonObj, String username, String password) {

    Response response =
        given()
            .auth()
            .preemptive()
            .basic(
                tokenDataJsonObj.get("ClientId").toString(),
                tokenDataJsonObj.get("ClientSecret").toString())
            .headers(
                "Accept",
                tokenDataJsonObj.get("Accept").toString(),
                "Content-Type",
                "application/x-www-form-urlencoded")
            .formParams(
                "grant_type",
                tokenDataJsonObj.get("grant_type").toString(),
                "username",
                username,
                "password",
                password,
                "scope",
                tokenDataJsonObj.get("scope").toString())
            .when()
            .post(tokenDataJsonObj.get("uri").toString())
            .then()
            .extract()
            .response();
    return response.getBody().jsonPath().getString("access_token");
  }

  /**
   * Current method is to extract the token id for QAI environment.
   *
   * @param tokenDataJsonObj contains required test data
   * @param username to use for a scenario
   * @param password to use for a scenario
   * @return token id in QAI environment
   */
  private String getOktaTokenIdQai(JSONObject tokenDataJsonObj, String username, String password) {
    HashMap<String, Object> hashMap = new HashMap<>();
    hashMap.put("userId", username);
    hashMap.put("password", password);
    hashMap.put("rememberMe", "false");
    hashMap.put("source", "WEB");
    hashMap.put("banner", "tomthumb");
    Response response =
        given()
            .relaxedHTTPSValidation()
            .headers(
                GlobalConstants.ACCEPT, tokenDataJsonObj.get("Accept").toString(),
                GlobalConstants.CONTENTTYPE, tokenDataJsonObj.get("Content").toString(),
                GlobalConstants.BANNERID, tokenDataJsonObj.get("x-swy_banner").toString())
            .body(hashMap)
            .when()
            .post(tokenDataJsonObj.get("uri").toString())
            .then()
            .extract()
            .response();
    return response.getBody().jsonPath().getString("token");
  }

  /**
   * Converts the Json string to pojo.
   *
   * @param jsonAsString the response from the service
   * @param classType the generic class type
   * @return the generic class
   */
  protected <T> T stringToPojo(String jsonAsString, Class<T> classType) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(jsonAsString, classType);
    } catch (IOException e) {
      Assert.fail(e.getMessage());
    }
    return null;
  }
  protected String getComplexJsonAsString(String resource) {
    JSONParser parser = new JSONParser();
    Object obj = null;
    try {
      obj = parser.parse(new FileReader(resource));
    } catch (IOException | ParseException e) {
      Assert.fail(e.getMessage());
    }
    JSONArray jsonArray = (JSONArray) obj;
    JSONObject jsonObject = (JSONObject)jsonArray.get(0);
    return jsonObject.toJSONString();
  }
  /**
   * Converts the Pojo to File. In case there is a requirement to overwrite/update the testdata.json
   * file this method can be used
   */
  protected void pojoToFile(String jsonAsString, String filePath) {
    try {
      FileWriter file = new FileWriter(filePath);
      file.write(jsonAsString);
      file.close();

    } catch (IOException e) {
      Assert.fail(e.getMessage());
    }
  }

  /**
   * Creates a string from JSON.
   *
   * @param resource the file name
   * @return json as string
   */
  protected String getJsonAsString(String resource) {
    JSONParser parser = new JSONParser();
    Object obj = null;
    try {
      obj = parser.parse(new FileReader(resource));
    } catch (IOException | ParseException e) {
      Assert.fail(e.getMessage());
    }
    JSONObject jsonObject = (JSONObject) obj;
    return jsonObject.toJSONString();
  }

  /** Set the proxy globally. */
  protected void setProxy() {
    // RestAssured.proxy("xphxbc02-int.safeway.com", Integer.parseInt("8080"));
     RestAssured.proxy("xphxbc02-int.safeway.com", Integer.parseInt("8080"));
    //RestAssured.proxy("phxproxyvip.safeway.com", Integer.parseInt("8080"));
  }

  /** Reset the Proxy globally. */
  protected void resetProxy() {
    RestAssured.reset();
  }

  /** Sets the SSL Config. */
  protected void setSslConfig() {
    RestAssured.config = RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames());
  }

  /**
   * Get the application authentication data based on the environment details
   *
   * @return a map containing client ID and client secret
   */
  protected Map<String, Object> getAppAuthenticationData() {
    Map<String, Object> appAuthData = new HashMap<String, Object>();
    dataExtractor = new DataExtractor();
    appAuthEnvDataJsonObject =
        dataExtractor.getJSONParseAppAuthenticationData(
            GlobalConstants.testEnvironment,
            GlobalConstants.appAuthServiceGroupName,
            GlobalConstants.appAuthServiceFileName);
    appAuthData.put("X-IBM-Client-Id", appAuthEnvDataJsonObject.get("X-IBM-Client-Id").toString());
    appAuthData.put(
        "X-IBM-Client-Secret", appAuthEnvDataJsonObject.get("X-IBM-Client-Secret").toString());
    return appAuthData;
  }

  public void setTestCaseName(String name){
    this.testCaseName=name;
  }
  public String getTestCaseName(){
   return testCaseName;
  }
}
