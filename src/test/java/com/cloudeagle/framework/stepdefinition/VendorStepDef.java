package com.cloudeagle.framework.stepdefinition;

import org.junit.Assert;

import com.cloudeagle.constants.Constants;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.VendorPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VendorStepDef {

	VendorPage vP = new VendorPage(ObjectRepo.driver);
	GenericHelper gH = new GenericHelper(ObjectRepo.driver);
	WaitHelper wHelper = new WaitHelper(ObjectRepo.driver, ObjectRepo.reader);

	@When("^user navigate to vendor page$")
	public void user_navigate_to_vendor_page() throws Throwable {
		vP.clickOnVendorSideMenu();
		wHelper.hardWait(3000);
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getVendorURL()))
			vP.log("Vendor URL verified", false);
		else {
			vP.log("Vendor URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@Then("^user must be able to view vendors header$")
	public void verify_vendors_header() throws Throwable {
		vP.verifyHeader();
	}

	@And("^user must be able to view vendor table$")
	public void verify_vendor_table() throws Throwable {
		vP.verifyVendorDataTable(ObjectRepo.reader.getVendorName());
	}

}
