package com.cloudeagle.framework.stepdefinition;

import org.junit.Assert;

import com.cloudeagle.constants.Constants;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.ExternalDataPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExternalDataStepDef {
	ExternalDataPage extP = new ExternalDataPage(ObjectRepo.driver);
	GenericHelper gH = new GenericHelper(ObjectRepo.driver);
	WaitHelper wH = new WaitHelper(ObjectRepo.driver, ObjectRepo.reader);

	//Transactions tab
	@When("^When user navigate to transactions excel data upload page$")
	public void user_navigate_to_transactions_excel_data_upload_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnExcelDataUpload();
		System.out.println(Constants.URL + ObjectRepo.reader.getExternalDataUploadTransactionsURL());
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataUploadTransactionsURL()))
			extP.log("External - Transactions Data Upload Documents URL verified", false);
		else {
			extP.log("External - Transactions Data Upload Documents URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@Then("^user must be able to view transactions data upload table$")
	public void verify_external_data_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getFileName());
	}

	@When("^user click on upload button for transactions$")
	public void user_click_on_upload_button() throws Throwable {
		extP.clickOnUploadFileBtn();
	}

	@Then("^user must be able to view upload model for transactions$")
	public void verify_upload_model() throws Throwable {
		extP.verifyUploadModel();
	}

//Vendor Metadata tab
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
	public void verify_vendor_metadata_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getFileName());
	}

	@When("^user click on upload button for vendor metadata$")
	public void user_click_on_upload_button_vendor_Metadata() throws Throwable {
		extP.clickOnUploadFileBtn();
	}

	@Then("^user must be able to view upload model for vendor metadata$")
	public void verify_upload_model_vendor_Metadata() throws Throwable {
		extP.verifyUploadModel();
	}

	
//Application Metadata tab
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
	public void verify_application_metadata_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getFileName());
	}

	@When("^user click on upload button for application metadata$")
	public void user_click_on_upload_button_application_Metadata() throws Throwable {
		extP.clickOnUploadFileBtn();
	}

	@Then("^user must be able to view upload model for application metadata$")
	public void verify_upload_model_application_Metadata() throws Throwable {
		extP.verifyUploadModel();
	}
	
	@When("^user navigate to on demand sync page$")
	public void user_navigate_toon_demand_sync_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnOnDemandSync();
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataOnDemandSyncSingleSignOnURL()))
			extP.log("External Data - On Demand Sync URL verified", false);
		else {
			extP.log("External Data - On Demand Sync URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@When("^user navigate to on demand sync single sign on page$")
	public void user_navigate_to_on_demand_sync_single_sign_on_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnOnDemandSync();
		extP.clickOnSingleSignOn();
	}

	@When("^user navigate to on demand sync finance systems page$")
	public void user_navigate_to_on_demand_sync_finance_systems_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnOnDemandSync();
		extP.clickOnFinanceSystems();
	}

	@Then("^user must be landing on on-demand sync page$")
	public void verify_on_demand_sync() throws Throwable {
		extP.verifyOnDemandSync();
	}

	@Then("^user must be landing on on-demand sync single sign on page$")
	public void verify_on_demand_sync_single_sign_on() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataOnDemandSyncSingleSignOnURL()))
			extP.log("External Data - On Demand Sync - Single Sign On URL verified", false);
		else {
			extP.log("External Data - On Demand Sync - Single Sign On URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@Then("^user must be landing on on-demand sync finance systems page$")
	public void verify_on_demand_sync_finance_system() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataOnDemandSyncFinanceSystemsURL()))
			extP.log("External Data - On Demand Sync - Finance Systems URL verified", false);
		else {
			extP.log("External Data - On Demand Sync - Finance Systems URL mis match", true);
			Assert.assertTrue(false);
		}
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
		extP.clickOnExternalDataSideMenu();
		extP.clickOnDataFromFinanceSystems();
		extP.clickOnNewVendorsFound();
	}

	@Then("^user must be landing on data from finance systems new vendors found page$")
	public void verify_data_from_finance_systems_new_vendors_found() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFinanceSystemsNewVendorFoundURL()))
			extP.log("External Data - Data From Finance Systems URL verified", false);
		else {
			extP.log("External Data - Data From Finance Systems URL mis match", true);
			Assert.assertTrue(false);
		}
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
	public void verify_existing_vendor_records() throws Throwable {
		Thread.sleep(30000);
		extP.verifyExistingVendorRecords(ObjectRepo.reader.getExistingVendorName());
	}

	@And("^user close the slider$")
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
	public void verify_data_from_finance_systems_confirmed_vendors() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFinanceSystemsConfirmedVendorsURL()))
			extP.log("External Data - Data From Finance Systems - Confirmed Vendors URL verified", false);
		else {
			extP.log("External Data - Data From Finance Systems - Confirmed Vendors URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@And("^user must be able to view confirmed vendors table$")
	public void verify_confirmed_vendors_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getConfirmedVendorName());
	}

	@When("^user navigate to data from finance systems rejected vendors page$")
	public void user_navigate_to_data_from_finance_systems_rejected_vendors_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnDataFromFinanceSystems();
		extP.clickOnRejectedVendors();
	}

	@Then("^user must be landing on data from finance systems rejected vendors page$")
	public void verify_data_from_finance_systems_rejected_vendors() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFinanceSystemsRejectedVendorsURL()))
			extP.log("External Data - Data From Finance Systems - Rejected Vendors URL verified", false);
		else {
			extP.log("External Data - Data From Finance Systems - Rejected Vendors URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@And("^user must be able to view rejected vendors table$")
	public void verify_rejected_vendors_table() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getRejectedVendorName());
	}

	@When("^user navigate to data from sso systems new apps found page$")
	public void user_navigate_to_data_from_sso_systems_new_app_found_page() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnDataFromSSOSystems();
		extP.clickOnNewAppsFound();
	}

	@Then("^user must be landing on data from sso systems new apps found page$")
	public void verify_data_from_sso_systems_new_app_found() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFromSSOSystemsNewAppsFoundURL()))
			extP.log("External Data - Data From SSO - New App URL verified", false);
		else {
			extP.log("External Data - Data From SSO - New App URL mis match", true);
			Assert.assertTrue(false);
		}
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
			extP.verifyExistingApplicationRecords(ObjectRepo.reader.getExistingAppName());
	}

	@When("^user navigate to data from sso systems confirmed apps page$")
	public void user_click_on_data_from_sso_systems_confirmed_apps() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnDataFromSSOSystems();
		extP.clickOnConfirmedApps();
	}

	@Then("^user must be landing on data from sso systems confirmed apps page$")
	public void verify_confirmed_apps() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFromSSOSystemsConfirmedAppsURL()))
			extP.log("External Data - Data From SSO - Confirmed App URL verified", false);
		else {
			extP.log("External Data - Data From SSO - Confirmed App URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@And("^user must be able to view confirmed apps table$")
	public void verify_confirmed_app_records() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getConfirmedApp());
	}

	@When("^user navigate to data from sso systems rejected apps page$")
	public void user_click_on_data_from_sso_systems_rejected_apps() throws Throwable {
		extP.clickOnExternalDataSideMenu();
		extP.clickOnDataFromSSOSystems();
		extP.clickOnRejectedApps();
	}

	@Then("^user must be landing on data from sso systems rejected apps page$")
	public void verify_rejected_apps() throws Throwable {
		if (gH.verifyURL(Constants.URL + ObjectRepo.reader.getExternalDataDataFromSSOSystemsRejectedAppsURL()))
			extP.log("External Data - Data From SSO - Rejected App URL verified", false);
		else {
			extP.log("External Data - Data From SSO - Rejected App URL mis match", true);
			Assert.assertTrue(false);
		}
	}

	@And("^user must be able to view rejected apps table$")
	public void verify_rejected_app_records() throws Throwable {
		extP.verifyExcelDataTable(ObjectRepo.reader.getRejectedApp());
	}
}
