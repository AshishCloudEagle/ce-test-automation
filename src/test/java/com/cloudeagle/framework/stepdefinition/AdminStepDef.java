package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.constants.Constants;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.AdminPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdminStepDef {

	AdminPage aP = new AdminPage(ObjectRepo.driver);
	GenericHelper gH = new GenericHelper(ObjectRepo.driver);

	@When("^user navigate to admin page$")
	public void user_navigate_to_admin_page() throws Throwable {
		aP.clickOnAdminSideMenu();
	}

	@Then("^user must be landing on admin page$")
	public void verify_admin_page() throws Throwable {
		gH.verifyURL(Constants.URL + ObjectRepo.reader.getAdminURL());
	}

	@And("^user must be able to view admin sidebar menus$")
	public void verify_sidebar_menu() throws Throwable {
		aP.verifySidebar();
	}

	@When("^user navigate to on admin single sign on page$")
	public void user_navigate_to_admin_single_sign_on_page() throws Throwable {
		aP.clickOnAdminSideMenu();
		aP.clickOnIntegrations();
		aP.clickOnSingleSignOn();
	}

	@Then("^user must be landing on admin single sign on page$")
	public void verify_admin_single_sign_on_page() throws Throwable {
		gH.verifyURL(Constants.URL + ObjectRepo.reader.getAdminURL());
	}

	@And("^user must be able to view integration tools list$")
	public void verify_integration_tools_list() throws Throwable {
		aP.verifyIntegrationToolsList();
	}

	@When("^user navigate to on admin integration finance systems page$")
	public void user_navigate_to_admin_finance_systems_page() throws Throwable {
		aP.clickOnAdminSideMenu();
		aP.clickOnIntegrations();
		aP.clickOnuserFinanceSystems();
	}

	@Then("^user must be landing on admin integration finance systems page$")
	public void verify_admin_finance_systems() throws Throwable {
		gH.verifyURL(Constants.URL + ObjectRepo.reader.getAdminFinanceSystemsURL());
	}

	@And("^user must be able to view finance systems integration tools list$")
	public void verify_finance_systems_integration_tools_list() throws Throwable {
		aP.verifyFinanceSystemsIntegrationToolsList();
	}

	@When("^user navigate to on admin alert page$")
	public void user_navigate_to_admin_alert_page() throws Throwable {
		aP.clickOnAdminSideMenu();
		aP.clickOnAlertSettings();
	}

	@Then("^user must be landing on admin alert page$")
	public void verify_admin_alert() throws Throwable {
		gH.verifyURL(Constants.URL + ObjectRepo.reader.getAdminAlertURL());
	}

	@When("^user navigate to on admin roles and users page$")
	public void user_navigate_to_admin_roles_and_users_page() throws Throwable {
		aP.clickOnAdminSideMenu();
		aP.clickOnRolesAndUsers();
		aP.clickOnUser();
	}

	@Then("^user must be landing on roles and users page$")
	public void verify_admin_roles_and_users() throws Throwable {
		gH.verifyURL(Constants.URL + ObjectRepo.reader.getAdminRolesAndUsersUsersURL());
	}

	@And("^user must be able to view roles and users table$")
	public void verify_admin_roles_and_users_table() throws Throwable {
		aP.verifyTable(ObjectRepo.reader.getUserName());
	}

	@When("^user click on add new user$")
	public void user_click_on_add_new_user() throws Throwable {
		aP.clickOnNewUser();
	}

	@Then("^user must be able to view add new user model$")
	public void verify_new_user_popup() throws Throwable {
		aP.verifyNewUserPopup();
	}

	@When("^user navigate to on admin roles and users roles page$")
	public void user_navigate_to_admin_roles_and_users_roles_page() throws Throwable {
		aP.clickOnAdminSideMenu();
		aP.clickOnRolesAndUsers();
		aP.clickOnRoles();
	}

	@Then("^user must be landing on roles and users roles page$")
	public void verify_admin_roles_and_users_roles() throws Throwable {
		gH.verifyURL(Constants.URL + ObjectRepo.reader.getAdminRolesAndUsersRolesURL());
	}

	@And("^user must be able to view roles and users roles table$")
	public void verify_admin_roles_and_users_roles_table() throws Throwable {
		aP.verifyTable(ObjectRepo.reader.getRole());
	}

	@When("^user click on create role$")
	public void user_click_on_create_role() throws Throwable {
		aP.clickOnCreateRole();
	}

	@Then("^user must be able to view create role model$")
	public void verify_create_role_model() throws Throwable {
		aP.verifyNewRolePopup();
	}
}
