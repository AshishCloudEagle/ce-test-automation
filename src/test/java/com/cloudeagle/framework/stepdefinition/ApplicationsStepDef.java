package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.ApplicationsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApplicationsStepDef {

	ApplicationsPage aP = new ApplicationsPage(ObjectRepo.driver);

	@When("^user navigate to applications page$")
	public void user_navigate_to_applications_page() throws Throwable {
		aP.clickOnApplicationsSideMenu();
	}

	@Then("^user must be able to view applications header$")
	public void verify_applications_header() throws Throwable {
		aP.verifyHeader();
	}

	@And("^user must be able to view applications table$")
	public void verify_aplications_table() throws Throwable {
		aP.verifyApplicationsDataTable(ObjectRepo.reader.getApplicationName(),
				ObjectRepo.reader.getApplicationVendorName());
	}

}
