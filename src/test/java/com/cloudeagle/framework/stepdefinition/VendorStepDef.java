package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.VendorPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VendorStepDef {

	VendorPage vP = new VendorPage(ObjectRepo.driver);
	WaitHelper wH = new WaitHelper(ObjectRepo.driver, ObjectRepo.reader);

	@When("^user navigate to vendor page$")
	public void user_navigate_to_vendor_page() throws Throwable {
		wH.staticWait(10);
		vP.clickOnVendorSideMenu();
	}

	@Then("^user must be able to view header$")
	public void verify_external_data_table() throws Throwable {
		vP.verifyHeader();
	}

	@And("^user must be able to view vendor table$")
	public void verify_Vendor_Table() throws Throwable {
		vP.verifyVendorDataTable(ObjectRepo.reader.getVendorName());
	}

}
