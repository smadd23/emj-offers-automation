Feature: OfferSearch "Parent & Child Parameters" Test Scenarios with "NO AUTH"
  Background: Set up Environment for Testing
    Given The Test Environment is Defined
      |currentTestEnvironment|dev  |
      |apiGroupName|offerSearchRunners|
      |apiName|get_offersByParamsFacetCount|
    And Parameters are intialized

  Scenario: Search offers using offerStatus
    When Business User searches offers using offerStatus with facet
      |testGetOfferSearchByOfferStatus|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed


  Scenario: Search offers using ExternalOfferID
    When Business User searches offers using ExternalOfferID with facet
      |testGetOfferSearchByExternalOfferId|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed
#
  Scenario: Search offers using StoreID
    When Business User searches offers using StoreID with facet
      |testGetOfferSearchByStoreId|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed

  Scenario: Search offers using PostalCode
    When Business User searches offers using PostalCode with facet
      |testGetOfferSearchByPostalCode|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed

#
  Scenario: Search offers using Start Date
    When Business User searches offers using Start Date with facet
      |testGetOfferSearchByStartDate|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed

#
  Scenario: Search offers using End Date
    When Business User searches offers using End Date with facet
      |testGetOfferSearchByEndDate|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
#    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed


  Scenario: Search offers using Offer Program Code
    When Business User searches offers using Offer Program Code with facet
      |testGetOfferSearchByOfferProgramCode|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed


##     child Parameters
#
  Scenario: Search offers using StartDate and PostalCode
    When Business User searches offers using StartDate & PostalCode with facet
      |testGetOfferSearchByStartDateandPostalCode|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed

  Scenario: Search offers using OfferStatus and EndDate
    When Business User searches offers using OfferStatus & EndDate with facet
      |testGetOfferSearchByOfferStatusandEnddate|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed


  Scenario: Search offers using EndDate and StartDate
    When Business User searches offers using EndDate & StartDate with facet
      |testGetOfferSearchByEndDateandStartDate|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed



  Scenario: Search offers using StoreId and ProgramCode
    When Business User searches offers using StoreId & ProgramCode with facet
      |testGetOfferSearchByStoreIdandProgramCode|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed


#  Grand child Scenarios
  Scenario: Search offers using Startdate and OfferProgramcode and offerStatus
    When Business User searches offers using Startdate & OfferProgramcode & offerStatus with facet
      |testGetOfferSearchByStartdateAndOfferProgramCodeAndOfferStatus|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed

  Scenario: Search offers using PostalCode and StoreId  and Enddate
    When Business User searches offers using PostalCode and StoreId and Enddate with facet
      |testGetOfferSearchByPostalCodeAndStoreIdAndEnddate|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed

  Scenario: Search offers using StartDate and EndDate and PostalCd and OfferStatus and StoreId and OfferProgramcode
    When Business User searches offers using StartDate and EndDate and PostalCd and OfferStatus and StoreId and OfferProgramcode with facet
      |testGetOfferSearchByStartDateAndEndDateAndPostalCodeAndOfferStatusAndStoreIdAndOfferProgramcode|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And facetcount for each Category is  asserted against the API response
#    And Category with null count should not be displayed