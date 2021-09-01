package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.constants.Constants;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.DashboardPage;
import com.cloudeagle.helper.PageObject.LandingPage;
import com.cloudeagle.helper.PageObject.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashboardStepDef {

	LoginPage lp = new LoginPage(ObjectRepo.driver);
	LandingPage landP = new LandingPage(ObjectRepo.driver);
	DashboardPage dasP = new DashboardPage(ObjectRepo.driver);
	GenericHelper gH = new GenericHelper(ObjectRepo.driver);

	@Given("^user logged in successfully$")
	public void user_logged_in_successfully() throws Throwable {
		ObjectRepo.driver.get(ObjectRepo.reader.getURL());
		lp.enterUserName(ObjectRepo.reader.getUserName());
		lp.enterPass(ObjectRepo.reader.getPassword());
		lp.ClickSignIn();
		landP.verifylandingPageTitle();
	}

	@When("^user navigate to dashboard page$")
	public void user_navigate_to_dashboard_page() throws Throwable {
		dasP.clickOnLogo();
		gH.verifyURL(Constants.URL + ObjectRepo.reader.getDashboardURL());
	}

	@Then("^user must be able to view user details$")
	public void verify_dashboard_page_user_details() throws Throwable {
		dasP.verifyUserDetailsOnDashboardPage(ObjectRepo.reader.getUserName(),
				ObjectRepo.reader.getServerInstanceName());
	}

	@And("^user must be able to view page headers$")
	public void verify_dashboard_page_headers() throws Throwable {
		dasP.varifyPageHeadersOnDashboardPage();
	}

	@And("^user must be able to view sidebar menus$")
	public void verify_dashboard_page_sidebar() throws Throwable {
		dasP.varifySideBarMenusOnDashboardPage();
	}
}
