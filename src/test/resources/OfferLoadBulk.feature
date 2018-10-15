Feature: Offer Load API Positive Test Scenarios
  Background: Set up Environment
    Given The Test Environment is Defined
      |currentTestEnvironment|dev|
      |apiGroupName|OfferSearchRunners|
      |apiName|OfferLoadAPI|
    And Parameters are intialized

  Scenario Outline: Load atleast ten offers with offerstatus A
    When Business User Loads <Multiple> Offers with OfferStatus A
    Then API Response is extracted for POST call
    Then API Response is asserted for Created Status Code
  Scenarios:
    |Multiple|
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

  Scenario Outline: Load atleast ten offers with offerstatus E
    When Business User Loads <Multiple> Offers with Offerstatus E
    Then API Response is extracted for POST call
    Then API Response is asserted for Created Status Code
    Scenarios:
      |Multiple|
      |OfferLoad1E.json|
      |OfferLoad-2E.json|
      |OfferLoad-3E.json|
      |OfferLoad-4E.json|
      |OfferLoad-5E.json|
      |OfferLoad-6E.json|
      |OfferLoad-7E.json|
      |OfferLoad-8E.json|
      |OfferLoad-9E.json|
      |OfferLoad-10E.json|