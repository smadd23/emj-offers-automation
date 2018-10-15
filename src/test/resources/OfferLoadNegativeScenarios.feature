Feature: Offer Load NegativeTest Scenarios with NO AUTH
  Background: Set up Environment for Testing
    Given The Test Environment is Defined
      |currentTestEnvironment|dev  |
      |apiGroupName|offerSearchRunners|
      |apiName|get_offersByParentParams|
    And Parameters are intialized

  Scenario: Load using unsupported data
    When Business user loads unsupported data file
      |InvalidOfferTest.json|
    Then API Response is extracted for POST call
    Then API Response is asserted as Status Code Bad Request

  Scenario: Load  Offer with null ExternalOfferId
    When Business user loads offer with null ExternalOfferId
      |OffercheckwithnullExternalOfferId.json|
    Then API Response is extracted for POST call
    Then API Response is asserted as Status Code Server Error

  Scenario: Load  Offer with nullOfferStatus
    When Business User loads data with null offerstatus
      |OffercheckwithnullOfferStatus.json|
    Then API Response is extracted for POST call
    Then API Response is asserted as Status Code Bad Request

  Scenario: Load  Offer with null programcode
    When Business User loads data with null programcode
      |OffercheckwithnullProgramcode.json|
    Then API Response is extracted for POST call
    Then API Response is asserted as Status Code Bad Request

  Scenario: Load  Offer with SpecialCharectors for OfferStatus
    When Business User loads data  SpecialCharectors for OfferStatus
      |OfferWithOfferStatusasSpecialCharectors.json|
    Then API Response is extracted for POST call
    Then API Response is asserted as Status Code Bad Request

  Scenario: Load  Offer with  SpecialCharectors for Programcode
    When Business User loads data with SpecialCharectors for Programcode
      |OfferwithProgramCodeasSpecialCharectors.json|
    Then API Response is extracted for POST call
    Then API Response is asserted as Status Code Bad Request

