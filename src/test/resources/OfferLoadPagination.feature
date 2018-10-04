Feature: Offer Load API Positive Test Scenarios
  Background: Set up Environment
    Given The Test Environment is Defined
      |currentTestEnvironment|dev|
      |apiGroupName|OfferSearchRunners|
      |apiName|OfferLoadAPI|
    And Parameters are intialized


  Scenario: Load atleast ten offers with offerstatus A
    When Business User loads <ALL> offers with offerstatus A
    Examples:
      |ALL|
      |OfferLoad-1.json|
      |OfferLoad-2.json|
      |OfferLoad-3.json|
      |OfferLoad-4.json|
      |OfferLoad-5.json|
      |OfferLoad-6.json|
      |OfferLoad-7.json|
      |OfferLoad-8.json|
      |OfferLoad-9.json|
      |OfferLoad-10.json|

    Then API Response is extracted for POST call
    Then API Response is asserted for Created Status Code
