package com.cloudeagle.framework.stepdefinition;

import org.junit.Assert;

import com.cloudeagle.constants.Constants;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.ExternalDataPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExternalDataStepDef {

	ExternalDataPage extP = new ExternalDataPage(ObjectRepo.driver);
	GenericHelper gH = new GenericHelper(ObjectRepo.driver);
	WaitHelper wH = new WaitHelper(ObjectRepo.driver, ObjectRepo.reader);

	@When("^user navigate to on demand sync page$")
	public void user_navigate_to_on_demand_sync_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnOnDemandSync();
	}

	@Then("^user must be landing on on-demand sync page$")
	public void user_must_be_landing_on_on_demand_sync_page() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataOnDemandSyncSingleSignOnURL()))
			extP.log("External Data - On Demand Sync URL verified", false);
		else {
			extP.log("External Data - On Demand Sync URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@Then("^user must be able to view side bar options$")
	public void user_must_be_able_to_view_side_bar_options() throws Throwable {
		extP.verifySidebarOptions();
	}

	@When("^user navigate to on demand sync single sign on page$")
	public void user_navigate_to_on_demand_sync_single_sign_on_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
//		extP.clickOnOnDemandSync();
//		extP.clickOnSingleSignOn();
	}

	@Then("^user must be landing on on-demand sync single sign on page$")
	public void user_must_be_landing_on_on_demand_sync_single_sign_on_page() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataOnDemandSyncSingleSignOnURL()))
			extP.log("External Data - On Demand Sync - Single Sign On URL verified", false);
		else {
			extP.log("External Data - On Demand Sync - Single Sign On URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@Then("^user must be able to view single sign on header$")
	public void user_must_be_able_to_view_single_sign_on_header() throws Throwable {
		extP.verifySingleSignOn();
	}

	@When("^user navigate to on demand sync finance systems page$")
	public void user_navigate_to_on_demand_sync_finance_systems_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
//		extP.clickOnOnDemandSync();
		extP.clickOnFinanceSystems();
	}

	@Then("^user must be landing on on-demand sync finance systems page$")
	public void user_must_be_landing_on_on_demand_sync_finance_systems_page() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataOnDemandSyncFinanceSystemsURL()))
			extP.log("External Data - On Demand Sync - Finance Systems URL verified", false);
		else {
			extP.log("External Data - On Demand Sync - Finance Systems URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@Then("^user must be able to view finance systems header$")
	public void user_must_be_able_to_view_finance_systems_header() throws Throwable {
		extP.verifyFinanceSystem();
	}

	@When("^user navigate to transactions excel data upload page$")
	public void user_navigate_to_transactions_excel_data_upload_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnExcelDataUpload();
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataUploadTransactionsURL()))
			extP.log("External - Transactions Data Upload Documents URL verified", false);
		else {
			extP.log("External - Transactions Data Upload Documents URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@Then("^user must be able to view transactions data upload table$")
	public void user_must_be_able_to_view_transactions_data_upload_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getFileName());
	}

	@When("^user click on upload button for transactions$")
	public void user_click_on_upload_button_for_transactions() throws Throwable {
		extP.clickOnUploadFileBtn();
	}

	@Then("^user must be able to view upload model for transactions$")
	public void user_must_be_able_to_view_upload_model_for_transactions() throws Throwable {
		extP.verifyUploadModel();
	}

	@When("^user navigate to vendor metadata upload page$")
	public void user_navigate_to_vendor_metadata_upload_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnExcelDataUpload();
		extP.clickOnVendorMetadataTab();
		System.out.println(Constants.URL + ObjectRepo.reader.getExternalDataVendorMetadataURL());
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataVendorMetadataURL()))
			extP.log("External - Vendor Metadata page URL verified", false);
		else {
			extP.log("External - Vendor Metadata page URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@Then("^user must be able to view vendor metadata upload table$")
	public void user_must_be_able_to_view_vendor_metadata_upload_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getVendorMetadataFileName());
	}

	@When("^user click on upload button for vendor metadata$")
	public void user_click_on_upload_button_for_vendor_metadata() throws Throwable {
		extP.clickOnUploadFileBtn();
	}

	@Then("^user must be able to view upload model for vendor metadata$")
	public void user_must_be_able_to_view_upload_model_for_vendor_metadata() throws Throwable {
		extP.verifyUploadModel();
	}

	@When("^user navigate to application metadata upload page$")
	public void user_navigate_to_application_metadata_upload_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnExcelDataUpload();
		extP.clickOnApplicationMetadataTab();
		System.out.println(Constants.URL + ObjectRepo.reader.getExternalDataApplicationMetadataURL());
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataApplicationMetadataURL()))
			extP.log("External - Application Metadata page URL verified", false);
		else {
			extP.log("External - Application Metadata page URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@Then("^user must be able to view application metadata upload table$")
	public void user_must_be_able_to_view_application_metadata_upload_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getApplicationMetadataFileName());
	}

	@When("^user click on upload button for application metadata$")
	public void user_click_on_upload_button_for_application_metadata() throws Throwable {
		extP.clickOnUploadFileBtn();
	}

	@Then("^user must be able to view upload model for application metadata$")
	public void user_must_be_able_to_view_upload_model_for_application_metadata() throws Throwable {
		extP.verifyUploadModel();
	}

	@When("^user navigate to data from finance systems new vendors found page$")
	public void user_navigate_to_data_from_finance_systems_new_vendors_found_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnDataFromFinanceSystems();
		extP.clickOnNewVendorsFound();
	}

	@Then("^user must be landing on data from finance systems new vendors found page$")
	public void user_must_be_landing_on_data_from_finance_systems_new_vendors_found_page() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFinanceSystemsNewVendorFoundURL()))
			extP.log("External Data - Data From Finance Systems URL verified", false);
		else {
			extP.log("External Data - Data From Finance Systems URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@Then("^user must be able to view new vendors found table$")
	public void user_must_be_able_to_view_new_vendors_found_table() throws Throwable {
		extP.verifySearchedTableData(ObjectRepo.reader.getNewVendorName());
	}

	@When("^user click on existing vendor$")
	public void user_click_on_existing_vendor() throws Throwable {
		extP.clickOnExistingVendor();
	}

	@Then("^user must be able to view slider$")
	public void user_must_be_able_to_view_slider() throws Throwable {
		extP.verifySlider();
	}

	@Then("^user must be able to view existing vendor records$")
	public void user_must_be_able_to_view_existing_vendor_records() throws Throwable {
		Thread.sleep(10000);
		extP.verifyExistingVendorRecords();
	}

	@Then("^user close the slider$")
	public void user_close_the_slider() throws Throwable {
		extP.closeSlider();
	}

	@When("^user navigate to data from finance systems confirmed vendors page$")
	public void user_navigate_to_data_from_finance_systems_confirmed_vendors_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnDataFromFinanceSystems();
		extP.clickOnConfirmedVendors();
	}

	@Then("^user must be landing on data from finance systems confirmed vendors page$")
	public void user_must_be_landing_on_data_from_finance_systems_confirmed_vendors_page() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFinanceSystemsConfirmedVendorsURL()))
			extP.log("External Data - Data From Finance Systems - Confirmed Vendors URL verified", false);
		else {
			extP.log("External Data - Data From Finance Systems - Confirmed Vendors URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@Then("^user must be able to view confirmed vendors table$")
	public void user_must_be_able_to_view_confirmed_vendors_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getConfirmedVendorName());
	}

	@When("^user navigate to data from finance systems rejected vendors page$")
	public void user_navigate_to_data_from_finance_systems_rejected_vendors_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnDataFromFinanceSystems();
		extP.clickOnRejectedVendors();
	}

	@Then("^user must be landing on data from finance systems rejected vendors page$")
	public void user_must_be_landing_on_data_from_finance_systems_rejected_vendors_page() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFinanceSystemsRejectedVendorsURL()))
			extP.log("External Data - Data From Finance Systems - Rejected Vendors URL verified", false);
		else {
			extP.log("External Data - Data From Finance Systems - Rejected Vendors URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@Then("^user must be able to view rejected vendors table$")
	public void user_must_be_able_to_view_rejected_vendors_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getRejectedVendorName());
	}

	@When("^user navigate to data from sso systems new apps found page$")
	public void user_navigate_to_data_from_sso_systems_new_apps_found_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnDataFromSSOSystems();
		extP.clickOnNewAppsFound();
	}

	@Then("^user must be landing on data from sso systems new apps found page$")
	public void user_must_be_landing_on_data_from_sso_systems_new_apps_found_page() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFromSSOSystemsNewAppsFoundURL()))
			extP.log("External Data - Data From SSO - New App URL verified", false);
		else {
			extP.log("External Data - Data From SSO - New App URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@Then("^user must be able to view new apps found table$")
	public void user_must_be_able_to_view_new_apps_found_table() throws Throwable {
		extP.verifySearchedTableData(ObjectRepo.reader.getNewAppName());
	}

	@When("^user click on match not found tab$")
	public void user_click_on_match_not_found_tab() throws Throwable {
		extP.clickOnMatchNotFoundtab();
	}

	@Then("^user must be able to view match not found vendor table$")
	public void user_must_be_able_to_view_match_not_found_vendor_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getNewAppName());
	}

	@When("^user click on existing application for new app found page$")
	public void user_click_on_existing_application_for_new_app_found_page() throws Throwable {
		extP.clickOnExistingApplication();
	}

	@Then("^user must be able to view slider of application for new app found page$")
	public void user_must_be_able_to_view_slider_of_application_for_new_app_found_page() throws Throwable {
		extP.verifyApplicationSlider();
	}

	@Then("^user must be able to view existing application records for new app found page$")
	public void user_must_be_able_to_view_existing_application_records_for_new_app_found_page() throws Throwable {
		wH.hardWait(10000);
		extP.verifyExistingApplicationRecords();
	}

	@When("^user navigate to data from sso systems confirmed apps page$")
	public void user_navigate_to_data_from_sso_systems_confirmed_apps_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnDataFromSSOSystems();
		extP.clickOnConfirmedApps();
	}

	@Then("^user must be landing on data from sso systems confirmed apps page$")
	public void user_must_be_landing_on_data_from_sso_systems_confirmed_apps_page() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFromSSOSystemsConfirmedAppsURL()))
			extP.log("External Data - Data From SSO - Confirmed App URL verified", false);
		else {
			extP.log("External Data - Data From SSO - Confirmed App URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@Then("^user must be able to view confirmed apps table$")
	public void user_must_be_able_to_view_confirmed_apps_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getConfirmedApp());
	}

	@When("^user navigate to data from sso systems rejected apps page$")
	public void user_navigate_to_data_from_sso_systems_rejected_apps_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnDataFromSSOSystems();
		extP.clickOnRejectedApps();
	}

	@Then("^user must be landing on data from sso systems rejected apps page$")
	public void user_must_be_landing_on_data_from_sso_systems_rejected_apps_page() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFromSSOSystemsRejectedAppsURL()))
			extP.log("External Data - Data From SSO - Rejected App URL verified", false);
		else {
			extP.log("External Data - Data From SSO - Rejected App URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@Then("^user must be able to view rejected apps table$")
	public void user_must_be_able_to_view_rejected_apps_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getRejectedApp());
	}

	@When("^user click on existing application for rejected app page$")
	public void user_click_on_existing_application_for_rejected_app_page() throws Throwable {
		extP.clickOnExistingApplication();
	}

	@Then("^user must be able to view slider of application for rejected app page$")
	public void user_must_be_able_to_view_slider_of_application_for_rejected_app_page() throws Throwable {
		extP.verifyApplicationSlider();
	}

	@Then("^user must be able to view existing application records for rejected apps$")
	public void user_must_be_able_to_view_existing_application_records_for_rejected_apps() throws Throwable {
		wH.hardWait(10000);
		extP.verifyExistingApplicationRecordsRejectedAppTab(ObjectRepo.reader.getExistingAppName());
	}

}