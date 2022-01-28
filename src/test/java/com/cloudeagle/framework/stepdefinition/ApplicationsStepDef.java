package com.cloudeagle.framework.stepdefinition;

import org.junit.Assert;

import com.cloudeagle.constants.Constants;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.ApplicationsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApplicationsStepDef {

	ApplicationsPage aP = new ApplicationsPage(ObjectRepo.driver);
	GenericHelper gH = new GenericHelper(ObjectRepo.driver);

	@When("^user navigate to applications page$")
	public void user_navigate_to_applications_page() throws Throwable {
		aP.clickOnApplicationsSideMenu();
	}

	@Then("^user must be landing on applicatios page$")
	public void user_must_be_landing_on_applicatios_page() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getApplicationURL()))
			aP.log("Application module URL verified", false);
		else {
			aP.log("Application module URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@And("^user must be able to view applications page header and table$")
	public void verify_aplications_table() throws Throwable {
		aP.verifyHeader();
		aP.verifyApplicationsDataTable(ObjectRepo.reader.getApplicationName(),
				ObjectRepo.reader.getApplicationVendorName());

	}

}
