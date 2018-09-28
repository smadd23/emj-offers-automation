Feature: Offer Load NegativeTest Scenarios with NO AUTH

  Background: Set up Environment for Testing
    Given The Test Environment is Defined for POST call
      |currentTestEnvironemnt|dev  |
      |apiGroupName|OfferLoadAPI|
      |apiName|OfferLoadAPI|



    Scenario: Load using unsupported data
      When Business user loads unsupported data file
      |InvalidOfferTest.json|
      Then  API Response is asserted for Status Code Bad Request

    Scenario: load data with null value and irrelavent  data value  in mandatory fields
      When Business user loads null or irrelevant data in mandatory fields
        |OffercheckwithnullAggregateOfferId.json|
        |OffercheckwithnullExternalOfferId.json|
        |OffercheckwithnullOfferStatus.json|
        |OffercheckwithnullProgramcode.json|
        |OfferwithAggregateIdasSpecialCharectors.json|
        |OfferWithExternalOfferIdasSpecialCharectors.json|
        |OfferWithOfferStatusasSpecialCharectors.json|
        |OfferwithProgramCodeasSpecialCharectors.json|

      Then  API Response is asserted as Status Code Bad Request
#
#
#
#
#
#
#
#
#
