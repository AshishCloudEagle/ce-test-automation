package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.ApplicationsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApplicationsStepDef {

	ApplicationsPage vP = new ApplicationsPage(ObjectRepo.driver);
	WaitHelper wH = new WaitHelper(ObjectRepo.driver, ObjectRepo.reader);

	@When("^user navigate to applications page$")
	public void user_navigate_to_applications_page() throws Throwable {
		wH.staticWait(10);
		vP.clickOnApplicationsSideMenu();
	}

	@Then("^user must be able to view Applications header$")
	public void verify_applications_header() throws Throwable {
		vP.verifyHeader();
	}

	@And("^user must be able to view applications table$")
	public void verify_aplications_table() throws Throwable {
		vP.verifyApplicationsDataTable(ObjectRepo.reader.getApplicationName(),
				ObjectRepo.reader.getApplicationVendorName());
	}

}
