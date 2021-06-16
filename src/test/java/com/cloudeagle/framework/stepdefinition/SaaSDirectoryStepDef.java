package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.SaaSDirectoryPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SaaSDirectoryStepDef {

	SaaSDirectoryPage saasP = new SaaSDirectoryPage(ObjectRepo.driver);
	WaitHelper wH = new WaitHelper(ObjectRepo.driver, ObjectRepo.reader);

	@When("^user navigate to saas directory page$")
	public void user_navigate_to_saas_directory_page() throws Throwable {
		wH.staticWait(10);
		saasP.clickOnSaaSDirectorySideMenu();
		saasP.verifyURL(ObjectRepo.reader.getSaaSDirectoryURL());
	}

	@Then("^user must be able to view saas directory header$")
	public void verify_saas_directory_header() throws Throwable {
		saasP.verifyHeader();
	}

	@And("^CRM Software filter should be selected$")
	public void verify_CRM_filter() throws Throwable {
		saasP.verifyCRMFilter();
	}

	@And("^verify at least one result box from Product list$")
	public void verify_result() throws Throwable {
		saasP.verifyResult(ObjectRepo.reader.getRequestAccessApplicationName());
	}

}
