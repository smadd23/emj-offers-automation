#Feature: OfferSearch All Negative Test Scenarios with "NO AUTH"
#  Background: Set up Environment for Testing
#    Given The Test Environment is Defined
#      |currentTestEnvironemnt|dev  |
#      |apiGroupName|offerSearchRunners|
#      |apiName|get_offersByParentParams|
#    And Parameters are intialized
#
#  Scenario: Search offers using null parameters
#    When Business User searches offers using No Parameters
#      |testGetOfferSearchByNullParameter|
#    Then API Response is extracted
#    And API Response is asserted for Bad Request Status Code
#
#  Scenario: Search offers using Partial Parameters
#    When Business User searches offers using Partial Parameters
#      |testGetOfferSearchByPartialParameter|
#    Then API Response is extracted
#    And API Response is asserted for Bad Request Status Code
#
#  Scenario: Search offers using Unavailable parameters
#    When Business User searches offers using Unavaialable parameters
#      |testGetOfferSearchByUnavailableParameter|
#    Then API Response is extracted
#    And API Response is asserted for Bad Request Status Code
#
#  Scenario: Search offers using Invalid Parameters
#    When Business User searches offers using Invalid Parameters
#      |testGetOfferSearchByInvalidParameter|
#    Then API Response is extracted
#    And API Response is asserted for Bad Request Status Code
#
#  Scenario: Search offers using Missing Parameter values
#    When Business User searches offers using Missing Parameters
#      |testGetOfferSearchByMissingParamValue|
#    Then API Response is extracted
#    And API Response is asserted for Internal Server Error
#    And API Response is asserted for User Friendly message
#
#  Scenario: Search offers using Special Character values
#    When Business User searches offers using Special Character Values
#      |testGetOfferSearchBySpecialCharacters|
#    Then API Response is extracted
#    And API Response is asserted for Bad Request Status Code
#
#  Scenario: Search offers using a Lengthy Parameter value
#    When Business User searches offers using Lengthy Values
#      |testGetOfferSearchByLengthyParam|
#    Then API Response is extracted
#    And API Response is asserted for Internal Server Error
#    And API Response is asserted for User Friendly message
#
#  Scenario: Search offers using a WRONG StoreID
#    When Business User searches offers using WRONG storeID
#      |testGetOfferSearchByWrongParam|
#    Then API Response is extracted
#    And  API Response is asserted for NOT ACCEPTABLE status code
#
