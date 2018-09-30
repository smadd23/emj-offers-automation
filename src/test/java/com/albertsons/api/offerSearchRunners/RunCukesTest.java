package com.albertsons.api.offerSearchRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/test/resources/OfferLoadNegativeScenarios.feature",
    glue = "com.albertsons.api.cucumberStepDefinitions",
    plugin = {
      "json:cucumber.runtime.formatter.JSONFormatter",
      "json:target/cucumber.json",
      "html:target/site/cucumber-pretty"
    },
    dryRun = false,
    monochrome = true)
public class RunCukesTest extends AbstractTestNGCucumberTests {}
