package com.safeway.j4u.emju.offers.api.framework.support.constants;

import org.json.simple.JSONObject;

/** Created by kedupuganti on 8/18/2017. */
public class GlobalConstants {

  // Declarations of Paths for differnt types of files
  public static final String testDataFilePathWindows =
      System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\";
  public static final String testDataFilePathMac =
      System.getProperty("user.dir") + "//src//test//resources//testdata//";
  public static final String testDataFilePathLinux =
      System.getProperty("user.dir") + "/src/test/resources/testdata/";

  // Declarations of Header Constants
  public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";
  public static final String APPLICATION_JSON = "application/json";
  public static final String APPLICATION_TEXT_HTML = "text/html";
  public static final String APPLICATION_VND_V1 = "application/vnd.safeway.v1+json";
  public static final String APPLICATION_VND_V1_CHARSET_UTF_8 =
      "application/vnd.safeway.v1+json;charset=UTF-8";
  public static final String APPLICATION_VND_V1_MERGE_PATCH =
      "application/vnd.safeway.v1.merge-patch+json";
  public static final String USER_AGENT_BROWSER =
      "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0";
  public static final String CORRELATION_ID_UCA_QAI = "dc1ddfce-39ed-11e8-b467-0ed5f89f718b";
  public static final String WEB_PORTAL = "web-Portal";
  public static final String NO_CACHE = "no-cache";

  // Declarations of Global Constants for Header Parameters
  public static final String AUTHORIZATION = "Authorization";
  public static final String ACCEPT = "Accept";
  public static final String BANNERID = "X-SWY_BANNER";
  public static final String CLIENTID = "x-swy-client-id";
  public static final String CONTENTTYPE = "Content-Type";
  public static final String SSOTOKEN = "SWY_SSO_TOKEN";
  public static final String USERAGENT = "User-Agent";
  public static final String CORRELATIONID = "x-swy-correlation-id";
  public static final String DATEANDTIME = "x-swy-date";
  public static final String CACHECONTROL = "Cache-Control";

  // Declarations of Response Variables and Error Codes
  public static final String NOTACCEPTABLE = "Not Acceptable";
  public static final String UNAUTHORIZED = "Unauthorized";
  public static final String IACUA0 = "IACUA0000";
  public static final String IACUA1 = "IACUA0001";
  public static final String IACUA5 = "IACUA0005";
  public static final String IACUA9 = "IACUA0009";
  public static final String TECHNICALDIFF =
      "We are currently experiencing technical difficulties. "
          + "Please try again later or contact customer care at 1-877-258-2799.";

  // Expired Token
  public static final String EXPIREDTOKEN =
      "eyJraWQiOiJHT1RLUXY2NG40N3ZRVjVuaGNGSVVveVNtaWhtQTM5V0N4TFNxVXY4W"
          + "FVrIiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULkV5T0ZnTWJ"
          + "razhiSUFVcjFvSmN6WWN1ajRSckY0TlBONjB3clBCSW9YVGMiLCJpc3MiOiJo"
          + "dHRwczovL2Ficy1xYTEub2t0YXByZXZpZXcuY29tL29hdXRoMi9hdXNkdnV5Y3"
          + "VsUklZaXRYZzBoNyIsImF1ZCI6IkFsYmVydHNvbnMiLCJpYXQiOjE1MjUyMTk3N"
          + "jIsImV4cCI6MTUyNTIyMDY2MiwiY2lkIjoiMG9hZDhhaXd0N1pBN3NXY3owaDciLC"
          + "J1aWQiOiIwMHVldHJ0cWR2SFVDZmRSbTBoNyIsInNjcCI6WyJvcGVuaWQiLCJwcm9"
          + "maWxlIl0sInN0ciI6Ijk3MSIsInppcCI6IjkzNDU0Iiwic3ViIjoidGVzdGF1dG9tY"
          + "XRlNi5hcGlAZXhhbXBsZS5jb20iLCJoaWQiOiIxMDAwMDAxMjIwOTciLCJkbm0iOiJT"
          + "dWpheSIsImFsbiI6IjQwMjQwNjEwNDI2IiwiZ2lkIjoiMjEwLTE3My0xNTI0Njc3MDMwM"
          + "DAyIiwicGhuIjoiNTg1OTY4NzIwOSIsImJhbiI6InRvbXRodW1iIn0.nIXnYiIMEPSBsA_"
          + "vWtB1E6_IPxc2KNN5bfY9J7x0D472CH1olEQGTtFwLHBz2hsE6DPQ117s2j3WC1p2wZhnwtBLQ"
          + "WfkUP-BYNjch3PcUk367HsjDIHZhWTVgxi9JhKRNqFyFMaVmoVfwVd8GmUuc99ueYEXjZ8B2QU5"
          + "McDEsHXWg0ArD-d4fo8dHT54Ze7UcMfQdVZHjMY_EA3lzi6nhFp7A50srt-oEAergPBwv7R9cac"
          + "PHvJZXWxrsOs6VIhiRHgLZFNQpYPzO-UC04of0v0nQvJ7s787RP2tBNjY_RP8heDGX2ki_7JCMf"
          + "sQ5lhDUunCuSm_BCTCDjUzO8r4g";

  public static int stepNo = 0;
  public static String stepExpected = null;
  public static String testEnvironment = null;
  public static String currentTestAPI = null;
  public static String currentTestAPIGroupName = null;
  public static String localEnvironment = "https://api-dvpub.albertsons.com/abs/dvpub";
  // public static String localEnvironment = "https://api-dev3.safeway.com/abs/dvpub";

  // Copient Environment
  public static String CopientlocalEnvironment = "https://logixbvt.safeway.com/connectors";
  public static String CopientlocalEnvironmentDev = "https://logixdev-beta.safeway.com/connectors";

  // Copient Header Parameter
  public static String CopientHeaderParameter = "application/x-www-form-urlencoded";
  public static String CopientFormParameterExternalSourceId = "ExternalSourceID";
  public static String CopientFormParameterOfferXml = "OfferXml";
  public static String ClipBundleFormParameterCustomerData = "CustomerOfferData";
  public static String CustomerUpdateFormParameterGuid = "GUID";
  public static String CustomerUpdateFormParameterCustomerXml = "CustomerXML";
  public static String endPoint = null;
  public static String J4UendPoint = null;
  public static String zipCode = "zipcode";
  public static String id = "id";
  public static String brand = "brand";
  public static String serachKeywords = "keywords";
  public static String storeId = "storeid";
  public String stepDescription = null;
  public String stepPassActual = null;
  public String stepFailActual = null;
  public String hostOsName = null;
  public JSONObject currentTsDataRowJsonObj = null;
  public String tokenServiceGroupName = "tokenservice";
  public String tokenServiceApiName = "token_service";

  // Application authentication env
  public static String appAuthServiceGroupName = "authentication";
  public static String appAuthServiceFileName = "app_authentication";

  public enum ReportStatus {
    PASS {
      @Override
      public String toString() {
        return "Pass";
      }
    },
    FAIL {
      @Override
      public String toString() {
        return "Fail";
      }
    },
    SKIP {
      @Override
      public String toString() {
        return "Skip";
      }
    },
    INFO {
      @Override
      public String toString() {
        return "Info";
      }
    }
  }

  public enum GetCallArgs {
    QUERYPARAM {
      @Override
      public String toString() {
        return "Query";
      }
    },
    HEADERPARAM {
      @Override
      public String toString() {
        return "Headers";
      }
    },
    FORMPARAM {
      @Override
      public String toString() {
        return "formparams";
      }
    },
    PATHPARAM {
      @Override
      public String toString() {
        return "Path";
      }
    },
    QUERYHEADERS {
      @Override
      public String toString() {
        return "QueryHeaders";
      }
    },
    QUERYPATH {
      @Override
      public String toString() {
        return "QueryPath";
      }
    },
    PATHHEADERS {
      @Override
      public String toString() {
        return "PathHeaders";
      }
    },
    NOPARAMS {
      @Override
      public String toString() {
        return "NoParams";
      }
    },
    ALLPARAMS {
      @Override
      public String toString() {
        return "AllParams";
      }
    }
  }

  public enum VerifyTextOptions {
    EXACTMATCH, EXACTMATCHIGNORECASE, PARTIAL
  }

  public enum VerifyValueOptions {
    EQUALTO, GREATERTHAN, LESSTHAN
  }

  public enum RegisterNewUserSetting {
    ENV {
      @Override
      public String toString() {
        switch (testEnvironment.toUpperCase()) {
          case "QA1":
            return "https://ngcp-qa1.safeway.com/iass/service/register";
          case "QA2":
            return "https://ngcp-qa2.safeway.com/iass/service/register";
          case "PROD":
            return "https://www.safeway.com/iass/service/register";
          case "NIMBUS-QA2":
            return "https://b2bgw-qa.safeway.com/iass/service/register";
          case "NIMBUS-QA2-ECOM":
            return "https://b2bgw-qa.safeway.com/ecom/api";
          default:
            return "https://www.safeway.com/iass/service/register";
        }
      }
    },
    WEBENV {
      @Override
      public String toString() {
        switch (testEnvironment.toUpperCase()) {
          case "QA1":
            return "https://ngcp-qa1.safeway.com/";
          case "QA2":
            return "https://ngcp-qa2.safeway.com/";
          case "PROD":
            return "https://www.safeway.com/";
          case "NIMBUS-QA2":
            return "https://b2bgw-qa.safeway.com/";
          case "QAI":
            return "https://ngcp-qi.safeway.com";
          default:
            return "https://www.safeway.com/";
        }
      }
    }
  }
}
