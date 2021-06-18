package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.constants.Constants;
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
		wH.staticWait(5);
		extP.clickOnExcelDataUpload();
		wH.staticWait(5);
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
		wH.staticWait(5);
		extP.clickOnOnDemandSync();
		wH.staticWait(5);
		extP.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataOnDemandSyncSingleSignOnURL());
	}

	@When("^user navigate to on demand sync single sign on page$")
	public void user_navigate_to_on_demand_sync_single_sign_on_page() throws Throwable {
		wH.staticWait(10);
		extP.clickOnExternalDataSideMenu();
		wH.staticWait(5);
		extP.clickOnOnDemandSync();
		wH.staticWait(5);
		extP.clickOnSingleSignOn();
	}

	@When("^user navigate to on demand sync finance systems page$")
	public void user_navigate_to_on_demand_sync_finance_systems_page() throws Throwable {
		wH.staticWait(10);
		extP.clickOnExternalDataSideMenu();
		wH.staticWait(5);
		extP.clickOnOnDemandSync();
		wH.staticWait(5);
		extP.clickOnFinanceSystems();
	}

	@Then("^user must be landing on on-demand sync page$")
	public void verify_on_demand_sync() throws Throwable {
		extP.verifyOnDemandSync();
	}

	@Then("^user must be landing on on-demand sync single sign on page$")
	public void verify_on_demand_sync_single_sign_on() throws Throwable {
		extP.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataOnDemandSyncSingleSignOnURL());
	}

	@Then("^user must be landing on on-demand sync finance systems page$")
	public void verify_on_demand_sync_finance_system() throws Throwable {
		extP.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataOnDemandSyncFinanceSystemsURL());
	}

	@And("^user must be able to view sidebar options$")
	public void verify_sidebar_options() throws Throwable {
		extP.verifySidebarOptions();
	}

	@And("^user must be able to view single sign on header$")
	public void verify_single_sign_on_header() throws Throwable {
		extP.verifySingleSignOn();
	}

	@And("^user must be able to view finance systems header$")
	public void verify_finance_systems_header() throws Throwable {
		extP.verifyFinanceSystem();
	}

	@When("^user navigate to data from finance systems new vendors found page$")
	public void user_navigate_to_data_from_finance_systems_new_vendors_found_page() throws Throwable {
		wH.staticWait(10);
		extP.clickOnExternalDataSideMenu();
		wH.staticWait(5);
		extP.clickOnDataFromFinanceSystems();
		wH.staticWait(5);
		extP.clickOnNewVendorsFound();
	}

	@Then("^user must be landing on data from finance systems new vendors found page$")
	public void verify_data_from_finance_systems_new_vendors_found() throws Throwable {
		extP.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFinanceSystemsNewVendorFoundURL());
	}

	@And("^user must be able to view new vendors found table$")
	public void verify_new_vendors_found_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getNewVendorName());
	}

	@When("^user click on existing vendor$")
	public void user_click_on_existing_vendor() throws Throwable {
		extP.clickOnExistingVendor();
	}

	@Then("^user must be able to view slider$")
	public void verify_sliderr() throws Throwable {
		extP.verifySlider();
	}

	@And("^user must be able to view existing vendor records$")
	public void verify_existing_vendor_recordsr() throws Throwable {
		extP.verifyExistingVendorRecords(ObjectRepo.reader.getVendorName());
	}

	@And("^user close the slider$")
	public void user_close_the_slider() throws Throwable {
		extP.closeSlider();
	}

	@When("^user navigate to data from finance systems confirmed vendors page$")
	public void user_navigate_to_data_from_finance_systems_confirmed_vendors_page() throws Throwable {
		wH.staticWait(10);
		extP.clickOnExternalDataSideMenu();
		wH.staticWait(5);
		extP.clickOnDataFromFinanceSystems();
		wH.staticWait(5);
		extP.clickOnConfirmedVendors();
	}

	@Then("^user must be landing on data from finance systems confirmed vendors page$")
	public void verify_data_from_finance_systems_confirmed_vendors() throws Throwable {
		extP.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFinanceSystemsConfirmedVendorsURL());
	}

	@And("^user must be able to view confirmed vendors table$")
	public void verify_confirmed_vendors_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getConfirmedVendorName());
	}

	@When("^user navigate to data from finance systems rejected vendors page$")
	public void user_navigate_to_data_from_finance_systems_rejected_vendors_page() throws Throwable {
		wH.staticWait(10);
		extP.clickOnExternalDataSideMenu();
		wH.staticWait(5);
		extP.clickOnDataFromFinanceSystems();
		wH.staticWait(5);
		extP.clickOnRejectedVendors();
	}

	@Then("^user must be landing on data from finance systems rejected vendors page$")
	public void verify_data_from_finance_systems_rejected_vendors() throws Throwable {
		extP.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFinanceSystemsRejectedVendorsURL());
	}

	@And("^user must be able to view rejected vendors table$")
	public void verify_rejected_vendors_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getRejectedVendorName());
	}

	@When("^user navigate to data from sso systems new apps found page$")
	public void user_navigate_to_data_from_sso_systems_new_app_found_page() throws Throwable {
		wH.staticWait(10);
		extP.clickOnExternalDataSideMenu();
		wH.staticWait(5);
		extP.clickOnDataFromSSOSystems();
		wH.staticWait(5);
		extP.clickOnNewAppsFound();
	}

	@Then("^user must be landing on data from sso systems new apps found page$")
	public void verify_data_from_sso_systems_new_app_found() throws Throwable {
		extP.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFromSSOSystemsNewAppsFoundURL());
	}

	@And("^user must be able to view new apps found table$")
	public void verify_new_apps_found_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getNewAppName());
	}

	@When("^user click on existing application$")
	public void user_click_on_existing_application() throws Throwable {
		extP.clickOnExistingApplication();
	}

	@Then("^user must be able to view slider of application$")
	public void verify_application_slider() throws Throwable {
		extP.verifyApplicationSlider();
	}

	@And("^user must be able to view existing application records$")
	public void verify_existing_application_records() throws Throwable {
		extP.verifyExistingVendorRecords(ObjectRepo.reader.getExistingAppName());
	}

	@When("^user navigate to data from sso systems confirmed apps page$")
	public void user_click_on_data_from_sso_systems_confirmed_apps() throws Throwable {
		wH.staticWait(10);
		extP.clickOnExternalDataSideMenu();
		wH.staticWait(5);
		extP.clickOnDataFromSSOSystems();
		wH.staticWait(5);
		extP.clickOnConfirmedApps();
	}

	@Then("^user must be landing on data from sso systems confirmed apps page$")
	public void verify_confirmed_apps() throws Throwable {
		extP.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFromSSOSystemsConfirmedAppsURL());
	}

	@And("^user must be able to view confirmed apps table$")
	public void verify_confirmed_app_records() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getConfirmedApp());
	}

	@When("^user navigate to data from sso systems rejected apps page$")
	public void user_click_on_data_from_sso_systems_rejected_apps() throws Throwable {
		wH.staticWait(10);
		extP.clickOnExternalDataSideMenu();
		wH.staticWait(5);
		extP.clickOnDataFromSSOSystems();
		wH.staticWait(5);
		extP.clickOnRejectedApps();
	}

	@Then("^user must be landing on data from sso systems rejected apps page$")
	public void verify_rejected_apps() throws Throwable {
		extP.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFromSSOSystemsRejectedAppsURL());
	}

	@And("^user must be able to view rejected apps table$")
	public void verify_rejected_app_records() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getRejectedApp());
	}
}
