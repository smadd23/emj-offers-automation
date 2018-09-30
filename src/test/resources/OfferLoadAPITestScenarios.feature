Feature: Offer Load API Test Scenarios



  Background: Set up Environment for Testing Offer Load API
    Given The Test Environment is Defined for POST call
      |currentTestEnvironment|dev  |
      |apiGroupName|OfferLoadAPI|
      |apiName|OfferLoadAPI|


  Scenario: Load Min offer using the offer load API
    When User loads atleast one offer using the Offer Load API
      |MinOfferTest_OffStatusA.json|
      |MinOfferTest_OffStatusAwithFuturedates.json|
      |MinOfferTest_OffStatusD.json|
      |MinOfferTest_OffStatusE.json|
      |MinOfferTest_OffStatusL.json|


    Then API Response is asserted fo Status Code CREATED

  Scenario: Load Max offer using the offer load API
    When User loads maximum no of offers using the Offer Load API
      |MaxOfferTest.json|


    Then API Response is asserted for Status Code CREATED1
