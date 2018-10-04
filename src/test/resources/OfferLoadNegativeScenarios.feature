Feature: Offer Load NegativeTest Scenarios with NO AUTH
  Background: Set up Environment for Testing Offer Load API
    Given The Test Environment is Defined for POST call
      |currentTestEnvironment|dev|
      |apiGroupName|OfferSearchRunners|
      |apiName|OfferLoadAPI|
    And Parameters are intialized


  Scenario: Load using unsupported data
    When Business user loads unsupported data file
      |InvalidOfferTest.json|
    Then API Response is extracted
    Then API Response is asserted as Status Code Bad Request

  Scenario: Load offer with null AggregatOfferId
    When  Business user loads Offer with null AggregateOfferId
      |OffercheckwithnullAggregateOfferId.json|
    Then API Response is extracted
    Then API Response is asserted as Status Code Bad Request

  Scenario: Load  Offer with null ExternalOfferId
    When Business user loads offer with null ExternalOfferId
      |OffercheckwithnullExternalOfferId.json|
    Then API Response is extracted
    Then API Response is asserted as Status Code Server Error

  Scenario: Load  Offer with nullOfferStatus
    When Business User loads data with null offerstatus
      |OffercheckwithnullOfferStatus.json|
    Then API Response is extracted
    Then API Response is asserted as Status Code Bad Request

  Scenario: Load  Offer with null programcode
    When Business User loads data with null programcode
      |OffercheckwithnullProgramcode.json|
    Then API Response is extracted
    Then API Response is asserted as Status Code Bad Request

  Scenario: Load  Offer with SpecialCharectors for AggregateOfferID
    When Business User loads data with SpecialCharectors for AggregateOfferID
      |OfferwithAggregateIdasSpecialCharectors.json|
    Then API Response is extracted
    Then API Response is asserted as Status Code Bad Request

  Scenario: Load  Offer with SpecialCharectors for ExternalOfferID
    When Business User loads data with SpecialCharectors for ExternalOfferID
      |OfferWithExternalOfferIdasSpecialCharectors.json|
    Then API Response is extracted
    Then API Response is asserted as Status Code Bad Request

  Scenario: Load  Offer with SpecialCharectors for OfferStatus
    When Business User loads data  SpecialCharectors for OfferStatus
      |OfferWithOfferStatusasSpecialCharectors.json|
    Then API Response is extracted
    Then API Response is asserted as Status Code Bad Request

  Scenario: Load  Offer with  SpecialCharectors for Programcode
    When Business User loads data with SpecialCharectors for Programcode
      |OfferwithProgramCodeasSpecialCharectors.json|
    Then API Response is extracted
    Then API Response is asserted as Status Code Bad Request

