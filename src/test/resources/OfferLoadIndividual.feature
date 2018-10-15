Feature: Offer Load API Positive Test Scenarios
  Background: Set up Environment for Testing
    Given The Test Environment is Defined
      |currentTestEnvironment|dev  |
      |apiGroupName|offerSearchRunners|
      |apiName||
    And Parameters are intialized

  Scenario: Load Min Offer with offerstatus A
    When Business User loads data with offerstatus A
      |MinOfferTest_OffStatusA.json|
    Then API Response is extracted for POST call
    Then API Response is asserted for Created Status Code

  Scenario: Load Min Offer with offerstatus A with future dates
    When Business User loads data with offerstatus A with Future dates
      |MinOfferTest_OffStatusAwithFuturedates.json|
    Then API Response is extracted for POST call
    Then API Response is asserted for Created Status Code

  Scenario: Load Min Offer with offerstatus D
    When Business User loads data with offerstatus D
      |MinOfferTest_OffStatusD.json|
    Then API Response is extracted for POST call
    Then API Response is asserted for Created Status Code

  Scenario: Load Min Offer with offerstatus E
    When Business User loads data with offerstatus E
      |MinOfferTest_OffStatusE.json|
    Then API Response is extracted for POST call
    Then API Response is asserted for Created Status Code

  Scenario: Load Min Offer with offerstatus L
    When Business User loads data with offerstatus L
      |MinOfferTest_OffStatusL.json|
    Then API Response is extracted for POST call
    Then API Response is asserted for Created Status Code
