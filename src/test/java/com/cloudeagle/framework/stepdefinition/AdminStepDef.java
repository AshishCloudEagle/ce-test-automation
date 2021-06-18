package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.constants.Constants;
import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.AdminPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdminStepDef {

	AdminPage aP = new AdminPage(ObjectRepo.driver);
	WaitHelper wH = new WaitHelper(ObjectRepo.driver, ObjectRepo.reader);

	@When("^user navigate to admin page$")
	public void user_navigate_to_admin_page() throws Throwable {
		wH.staticWait(10);
		aP.clickOnAdminSideMenu();
	}

	@Then("^user must be landing on admin page$")
	public void verify_admin_page() throws Throwable {
		aP.verifyURL(Constants.URL + ObjectRepo.reader.getAdminURL());
	}

	@And("^user must be able to view admin sidebar menus$")
	public void verify_sidebar_menu() throws Throwable {
		aP.verifySidebar();
	}

	@When("^user navigate to on admin single sign on page$")
	public void user_navigate_to_admin_single_sign_on_page() throws Throwable {
		wH.staticWait(10);
		aP.clickOnAdminSideMenu();
		aP.clickOnIntegrations();
		aP.clickOnSingleSignOn();
	}

	@Then("^user must be landing on admin single sign on page$")
	public void verify_admin_single_sign_on_page() throws Throwable {
		aP.verifyURL(Constants.URL + ObjectRepo.reader.getAdminURL());
	}

	@And("^user must be able to view integration tools list$")
	public void verify_integration_tools_list() throws Throwable {
		aP.verifyIntegrationToolsList();
	}

}
