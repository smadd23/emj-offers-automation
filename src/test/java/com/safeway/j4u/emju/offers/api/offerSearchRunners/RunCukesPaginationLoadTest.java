package com.safeway.j4u.emju.offers.api.offerSearchRunners;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/OfferLoadPagination.feature",
        glue = "com.safeway.j4u.emju.offers.api.cucumberStepDefinitions",
        plugin = {
                "json:cucumber.runtime.formatter.JSONFormatter",
                "json:target/cucumber.json",
                "html:target/cucumber-html-report"
        },
        dryRun = false,
        monochrome = true)

public class RunCukesPaginationLoadTest extends AbstractTestNGCucumberTests {}

