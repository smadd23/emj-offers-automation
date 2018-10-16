Feature: Offer Search Pagination ALL Positive Test Scenarios
  Background: Set up Environment
    Given The Test Environment is Defined
      |currentTestEnvironment|dev|
      |apiGroupName|OfferSearchRunners|
      |apiName|get_pagination_data|
    And Parameters are intialized

#   Parent Param Scenarios
    Scenario: StoreId Search with Limit
    Given Business user searches offers using StoreIdAndlimit
      |OfferSearchStoreIdLimitTen|
      Then API Response is extracted
      And API Response is asserted for Success Status Code
      And API Response is read for a valid SearchID
       And API Response is asserted for counts matching the limit
          |counts|10|
      And Forward page search is called One Page at a time
        |InitialPage|2|
      And Previous page search is called One Page at a time
        |LastPage|5|

  Scenario: Search by OfferStatus with Limit
    Given Business user searches offers using OfferStatus with limit
      |OfferSearchOfferStatusLimitFive|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is read for a valid SearchID
     And API Response is asserted for counts matching the limit
      |counts|5|
    And Forward page search is called One Page at a time
      |InitialPage|2|
    And Previous page search is called One Page at a time
      |LastPage|5|

  Scenario: Search by StartDate with Limit
    Given Business user searches offers using StartDate with limit
      |OfferSearchStartDateLimitFive|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is read for a valid SearchID
     And API Response is asserted for counts matching the limit
       |counts|5|
    And Forward page search is called One Page at a time
      |InitialPage|2|
    And Previous page search is called One Page at a time
      |LastPage|4|

  Scenario: Search by EndDate with Limit
    Given Business user searches offers using EndDate with limit
      |OfferSearchEndDateLimitTwenty|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is read for a valid SearchID
     And API Response is asserted for counts matching the limit
       |counts|20|
    And Forward page search is called One Page at a time
      |InitialPage|2|
    And Previous page search is called One Page at a time
      |LastPage|3|

  Scenario: Search by OfferProgramCode with Limit
    Given Business user searches offers using Offer Program Code with limit
      |OfferSearchProgramCodeLimitFive|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is read for a valid SearchID
     And API Response is asserted for counts matching the limit
       |counts|5|
    And Forward page search is called One Page at a time
      |InitialPage|2|
    And Previous page search is called One Page at a time
      |LastPage|9|

#    Child Param Scenarios
  Scenario: Search by StartDate And StoreId with Limit
    Given Business user searches offers using StartDate And StoreId with limit
      |OfferSearchStartDateStoreIdLimitThree|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is read for a valid SearchID
     And API Response is asserted for counts matching the limit
       |counts|3|
    And Forward page search is called One Page at a time
      |InitialPage|2|
    And Previous page search is called One Page at a time
      |LastPage|4|

  Scenario: Search by StartDate And EndDate with Limit
    Given Business user searches offers using StartDate And EndDate with limit
      |OfferSearchStartDateEndDateLimitThree|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is read for a valid SearchID
    And API Response is asserted for counts matching the limit
      |counts|3|
    And Forward page search is called One Page at a time
      |InitialPage|2|
    And Previous page search is called One Page at a time
      |LastPage|6|

  Scenario: Search by OfferStatus And StoreID with Limit
    Given Business user searches offers using OfferStatus StoreID with limit
      |OfferSearchOfferStatusStoreIdLimitFive|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is read for a valid SearchID
     And API Response is asserted for counts matching the limit
       |counts|5|
    And Forward page search is called One Page at a time
      |InitialPage|2|
    And Previous page search is called One Page at a time
      |LastPage|5|

  Scenario: Search by EndDate And StoreId with Limit
    Given Business user searches offers using EndDate And StoreId with limit
      |OfferSearchEndDateStoreIdLimitTen|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is read for a valid SearchID
     And API Response is asserted for counts matching the limit
       |counts|10|
    And Forward page search is called One Page at a time
      |InitialPage|2|
    And Previous page search is called One Page at a time
      |LastPage|6|

#    GrandChild Param Scenarios
  Scenario: Search by StoreId ProgramCode and OfferStatus
    Given Business user searches offers using StoreId ProgramCode and OfferStatus with limit
    |OfferSearchStoreIdProgramCodeOfferStatusLimitFive|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is read for a valid SearchID
    And API Response is asserted for counts matching the limit
      |counts|5|
    And Forward page search is called One Page at a time
      |InitialPage|2|
    And Previous page search is called One Page at a time
      |LastPage|5|

  Scenario: Search by StoreId StartDate and OfferStatus
    Given Business user searches offers using StoreId StartDate and OfferStatus with limit
      |OfferSearchStoreIdStartDateOfferStatusLimitFive|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is read for a valid SearchID
    And API Response is asserted for counts matching the limit
      |counts|5|
    And Forward page search is called One Page at a time
      |InitialPage|2|
    And Previous page search is called One Page at a time
      |LastPage|5|

  Scenario: Search by StoreId StartDate and OfferStatus
    Given Business user searches offers using StoreId StartDate and OfferStatus with limit
      |OfferSearchStoreIdStartDateOfferStatusOfferProgramCodeLimitFive|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is read for a valid SearchID
    And API Response is asserted for counts matching the limit
      |counts|5|
    And Forward page search is called One Page at a time
      |InitialPage|2|
    And Previous page search is called One Page at a time
      |LastPage|5|

#  GrandChildPlus Param Scenarios
  Scenario: Search by StoreId StartDate and OfferStatus and OfferProgramCode
    Given Business user searches offers using StoreId StartDate and OfferStatus with limit
      |OfferSearchStoreIdStartDateOfferStatusOfferProgramCodeLimitFive|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is read for a valid SearchID
    And API Response is asserted for counts matching the limit
      |counts|5|
    And Forward page search is called One Page at a time
      |InitialPage|2|
    And Previous page search is called One Page at a time
      |LastPage|5|

  Scenario: Search by StartDate and EndDate and OfferStatus and StoreId
    Given Business user searches offers using StartDate EndDate StoreId and OfferStatus with limit
      |OfferSearchStartDateEndDateStoreIdOfferStatusLimitThree|
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is read for a valid SearchID
    And API Response is asserted for counts matching the limit
      |counts|5|
    And Forward page search is called One Page at a time
      |InitialPage|2|
    And Previous page search is called One Page at a time
      |LastPage|4|

  Scenario Outline: StoreID search with limit functionality
    When Business user searches offers using StoreId And <Limit>
    Then API Response is extracted
    And API Response is asserted for Success Status Code
    And API Response is asserted for counts matching the limit <value>
    Scenarios:
      |Limit|value|
      |OfferSearchStoreIdLimitOne|1|
      |OfferSearchStoreIdLimitTwo|2|
      |OfferSearchStoreIdLimitThree|3|
      |OfferSearchStoreIdLimitFour|4 |
      |OfferSearchStoreIdLimitFive|5 |

#  Scenario Outline: Pre-Determined Iterative Forward Pagination Functionality Test
#      When Pre-Determined Next Page search <iteratively> called One Page at a time
#      Then API Response is extracted
#      And API Response is asserted for Success Status Code
#    And API Response is asserted for existing page value
#    Scenarios:
#    |iteratively|
#    |2          |
#    |3          |
#    |4          |
#    |5          |

#  Scenario Outline: Pre-Determined Iterative Backward Pagination Functionality Test
#    When Pre-Determined Previous Page search <iteratively> called One Page at a time
#    Then API Response is extracted
#    And API Response is asserted for Success Status Code
#    And API Response is asserted for existing page value
#    Scenarios:
#      |iteratively|
#      |5          |
#      |4          |
#      |3          |
#      |2          |
#      |1          |

#  Scenario Outline: OfferStatus search with limit functionality
#    When Business user searches offers using OfferStatus And <Limit>
#    Then API Response is extracted
#    And API Response is asserted for Success Status Code
#    And API Response is asserted for counts matching the limit <value>
#    Scenarios:
#      |Limit|value|
#      |OfferSearchStatusLimitOne|1|
#      |OfferSearchStatusLimitTwo|2|
#      |OfferSearchStatusLimitThree|3|
#      |OfferSearchStatusLimitFour|4 |
#      |OfferSearchStatusLimitFive|5 |




