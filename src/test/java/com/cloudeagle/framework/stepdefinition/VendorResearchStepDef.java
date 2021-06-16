package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.VendorResearchPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VendorResearchStepDef {

	VendorResearchPage vP = new VendorResearchPage(ObjectRepo.driver);
	WaitHelper wH = new WaitHelper(ObjectRepo.driver, ObjectRepo.reader);

	@When("^user navigate to vendor research page$")
	public void user_navigate_to_vendor_research_page() throws Throwable {
		wH.staticWait(10);
		vP.clickOnVendorResearchSideMenu();
		vP.verifyURL(ObjectRepo.reader.getVendorResearchURL());
	}

	@Then("^user must be able to view vendors research header$")
	public void verify_vendor_research_header() throws Throwable {
		vP.verifyHeader();
	}

	@When("^user search by vendor name$")
	public void search_by_vendor_name() throws Throwable {
		vP.searchByVendorName(ObjectRepo.reader.getVendorResearchProductName());
	}

	@Then("^user must be able to view related results$")
	public void verify_results() throws Throwable {
		vP.verifyResults(ObjectRepo.reader.getVendorResearchProductName());
	}

}
