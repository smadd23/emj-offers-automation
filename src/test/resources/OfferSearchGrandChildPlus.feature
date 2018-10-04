#Feature: OfferSearch "GrandChild++ Parameters" Test Scenarios with "NO AUTH"
#  Background: Set up Environment for Testing GrandChildPlus Parameters
#    Given The Test Environment is Defined for GrandChildPlus Parameters
#      |currentTestEnvironemnt|dev  |
#      |apiGroupName|offerSearchRunners|
#      |apiName|get_offersByParentParams|
#    And Parameters are intialized for GrandChildPlus Parameters
#
#  Scenario: Search offers using ExternalOfferID, OfferStatus, EndDate & StoreId
#    When Business User searches offers ExternalOfferID, OfferStatus, EndDate & StoreId
#      |testGetOfferSearchByEndDateAndOfferStatus&ExternalOfferIdAndStoreID|
#    Then API Response is extracted for GrandChildPlus Parameters
#    And API Response is asserted for Success Status Code for GrandChildPlus Parameters
#    And API Response is asserted for ALL attributes
#      |responseThree|
#
#  Scenario: Search offers using OfferStatus,PriceCode, StoreID & ExternalOfferID
#    When Business User searches offers using OfferStatus, PriceCode & StoreID & ExternalOfferID
#      |testGetOfferSearchByPriceCdAndStoreIdAndOfferStatusAndExternalOfferId|
#    Then API Response is extracted for GrandChildPlus Parameters
#    And API Response is asserted for Success Status Code for GrandChildPlus Parameters
#    And API Response is asserted for ALL attributes
#      |responseFours|
