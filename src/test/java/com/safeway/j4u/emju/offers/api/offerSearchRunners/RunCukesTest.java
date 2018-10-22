package com.safeway.j4u.emju.offers.api.offerSearchRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = {
      "src/test/resources/OfferSearchAllScenarios.feature",
      "src/test/resources/OfferSearchPagination.feature",
      "src/test/resources/OfferSearchAllNegativeScenarios.feature",
      "src/test/resources/OfferLoadNegativeScenarios.feature",
      "src/test/resources/OfferSearchAllFacets.feature",
      "src/test/resources/PromoteOffer.feature",
    },
    // features ={"src/test/resources/OfferLoadBulk.feature",
    //            "src/test/resources/OfferLoadFacet.feature"},
    glue = "com.safeway.j4u.emju.offers.api.cucumberStepDefinitions",
    plugin = {
      "json:cucumber.runtime.formatter.JSONFormatter",
      "json:target/cucumber.json",
      "html:target/cucumber-html-report"
    },
    dryRun = false,
    monochrome = true)
public class RunCukesTest extends AbstractTestNGCucumberTests {}
