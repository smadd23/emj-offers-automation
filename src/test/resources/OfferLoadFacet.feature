Feature: Offer Load API Positive Test Scenarios
  Background: Set up Environment for Testing
    Given The Test Environment is Defined
      |currentTestEnvironment|dev  |
      |apiGroupName|offerSearchRunners|
      |apiName|get_offersByParamsFacetCount|
    And Parameters are intialized

    Scenario Outline: Load multiple offers for facet count

      When User <Loads> multiple Offers with different categorries
      Then API Response is extracted for POST call
      And API Response is asserted for Created Status Code
      Examples:
        |Loads|
        |Bread & Bakery.json|
        |Canned Goods & Soups.json|
        |Condiments, Spices & Bake.json|
        |Cookies, Snacks & Candy.json|
        |Dairy, Eggs & Cheese.json|
        |Deli.json|
        |Frozen Foods.json|
        |International Cuisine.json|
        |Paper, Cleaning & Home.json|
        |Personal Care & Health.json|
        |Pet Care.json|
        |Wine, Beer & Spirits.json|





