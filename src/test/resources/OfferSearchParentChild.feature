Feature: OfferSearch "Parent & Child Parameters" Test Scenarios with "NO AUTH"
  Background: Set up Environment for Testing
    Given The Test Environment is Defined
      |currentTestEnvironment|dev  |
      |apiGroupName|offerSearchRunners|
      |apiName|get_offersByParentParams|
    And Parameters are intialized

  Scenario: Search offers using offerStatus
    When Business User searches offers using offerStatus
      |testGetOfferSearchByOfferStatus|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for counts
      |counts|4|

  Scenario: Search offers using ExternalOfferID
    When Business User searches offers using ExternalOfferID
      |testGetOfferSearchByExternalOfferId|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for counts
      |counts|1|

  Scenario: Search offers using StoreID
    When Business User searches offers using StoreID
      |testGetOfferSearchByStoreId|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for counts
      |counts|9|

  Scenario: Search offers using ZipCode
    When Business User searches offers using ZipCode
      |testGetOfferSearchByPostalCode|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for counts
      |counts|9|

  Scenario: Search offers using Start Date
    When Business User searches offers using Start Date
      |testGetOfferSearchByStartDate|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for counts
      |counts|2|

  Scenario: Search offers using End Date
    When Business User searches offers using End Date
      |testGetOfferSearchByEndDate|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for counts
      |counts|10|

  Scenario: Search offers using Offer Program Code
    When Business User searches offers using Offer Program Code
      |testGetOfferSearchByOfferProgramCode|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for counts
      |counts|10|

  Scenario: Search offers using ZipCode and offerStatus
    When Business User searches offers using ZipCode & Offerstatus
      |testGetOfferSearchByZipCodeandStatus|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for counts
      |counts|4|

  Scenario: Search offers using ExternalOfferId and offerStatus
    When Business User searches offers using ExternalOfferId & Offerstatus
      |testGetOfferSearchByExternalOfferIdandStatus|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for counts
      |counts|4|

  Scenario: Search offers using EndDate and offerStatus
    When Business User searches offers using EndDate & Offerstatus
      |testGetOfferSearchByEndDateandStatus|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for counts
      |counts|4|

  Scenario: Search offers using StartDate and offerStatus
    When Business User searches offers using StartDate & Offerstatus
      |testGetOfferSearchByStartDateandStatus|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for counts
      |counts|1|
