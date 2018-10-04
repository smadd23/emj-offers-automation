Feature: OfferSearch "GrandChild++ Parameters" Test Scenarios with "NO AUTH"
  Background: Set up Environment for Testing
    Given The Test Environment is Defined
      |currentTestEnvironment|dev  |
      |apiGroupName|offerSearchRunners|
      |apiName|get_offersByParentParams|
    And Parameters are intialized

  Scenario: Search offers using ExternalOfferID, OfferStatus, EndDate & StoreId
    When Business User searches offers ExternalOfferID, OfferStatus, EndDate & StoreId
      |testGetOfferSearchByEndDateAndOfferStatus&ExternalOfferIdAndStoreID|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for ALL attributes
      |responseThree|

  Scenario: Search offers using OfferStatus,PriceCode, StoreID & ExternalOfferID
    When Business User searches offers using OfferStatus, PriceCode & StoreID & ExternalOfferID
      |testGetOfferSearchByPriceCdAndStoreIdAndOfferStatusAndExternalOfferId|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for ALL attributes
      |responseFours|
