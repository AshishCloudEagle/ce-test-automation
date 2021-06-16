package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.ExternalDataPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExternalDataStepDef {

	ExternalDataPage extP = new ExternalDataPage(ObjectRepo.driver);
	WaitHelper wH = new WaitHelper(ObjectRepo.driver, ObjectRepo.reader);

	@When("^user navigate to external data upload page$")
	public void user_navigate_to_external_data_upload_page() throws Throwable {
		wH.staticWait(10);
		extP.clickOnExternalDataSideMenu();
		extP.clickOnExcelDataUpload();
		extP.verifyURL(ObjectRepo.reader.getExternalDataUploadURL());
	}

	@Then("^user must be able to view external data upload table$")
	public void verify_external_data_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getFileName());
	}

	@When("^user click on upload button$")
	public void user_click_on_upload_button() throws Throwable {
		extP.clickOnUploadFileBtn();
	}

	@Then("^user must be able to view upload model$")
	public void verify_upload_model() throws Throwable {
		extP.verifyUploadModel();
	}

	@When("^user navigate to on demand sync page$")
	public void user_navigate_toon_demand_sync_page() throws Throwable {
		wH.staticWait(10);
		extP.clickOnExternalDataSideMenu();
		extP.clickOnOnDemandSync();
		extP.verifyURL(ObjectRepo.reader.getExternalDataOnDemandSyncURL());
	}

	@Then("^user must be landing on on-demand sync page$")
	public void verify_on_demand_sync() throws Throwable {
		extP.verifyOnDemandSync();
	}

	@And("^user must be able to view sidebar options$")
	public void verify_sidebar_options() throws Throwable {
		extP.verifySidebarOptions();
	}

	@And("^user must be able to view single sign on header$")
	public void verify_single_sign_on_header() throws Throwable {
		extP.clickOnSingleSignOn();
		extP.verifySingleSignOn();
	}
}
