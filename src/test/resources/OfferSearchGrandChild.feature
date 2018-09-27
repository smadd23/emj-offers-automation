#Feature: OfferSearch "GrandChild Parameters" Test Scenarios with "NO AUTH"
#  Background: Set up Environment for Testing
#    Given The Test Environment is Defined
#      |currentTestEnvironemnt|dev  |
#      |apiGroupName|offerSearchRunners|
#      |apiName|get_offersByParentParams|
#    And Parameters are intialized
#
#  Scenario: Search offers using ExternalOfferID and StatusCode and ProgramCode
#    When Business User searches offers using ExternalOfferID and StatusCode and ProgramCode
#      |testGetOfferSearchByExternalOfferIdAndStatusAndProgramCode|
#    Then API Response is extracted
#    And API Response is asserted for Success Status Code
#    And API Response is asserted for ALL attributes
#        |responseOne|
#
#  Scenario: Search offers using EndDate and StoreID and ExternalOfferID
#    When Business User searches offers using EndDate and StoreID and ExternalOfferID
#      |testGetOfferSearchByEndDateAndStoreIdAndExternalOfferId|
#    Then API Response is extracted
#    And API Response is asserted for Success Status Code
#    And API Response is asserted for ALL attributes
#      |responseTwo|
#
