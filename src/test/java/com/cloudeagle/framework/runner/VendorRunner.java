
package com.cloudeagle.framework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/Vendor.feature" }, glue = {
		"classpath:com.cloudeagle.framework.stepdefinition",
		"classpath:com.cloudeagle.framework.helper" }, plugin = { "pretty", "json:target/VendorRunner.json" })

public class VendorRunner extends AbstractTestNGCucumberTests {

}
