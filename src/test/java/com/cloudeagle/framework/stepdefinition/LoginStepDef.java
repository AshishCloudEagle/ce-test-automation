package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.LandingPage;
import com.cloudeagle.helper.PageObject.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef {

	LoginPage lp = new LoginPage(ObjectRepo.driver);
	LandingPage landP = new LandingPage(ObjectRepo.driver);

	@Given("^user reached on login screen$")
	public void user_reached_on_login_screen() throws Throwable {
		ObjectRepo.driver.get(ObjectRepo.reader.getURL());
	}

	@When("^user enters credentials and click on Sign in button$")
	public void user_enters_credentials_and_click_on_sign_in_button() throws Throwable {
		lp.enterUserName(ObjectRepo.reader.getUserName());
		lp.enterPass(ObjectRepo.reader.getPassword());
		lp.ClickSignIn();

	}

	@Then("^user must reached to landing page validate by title$")
	public void user_reached_must_reached_to_landing_page() throws Throwable {
		landP.verifylandingPageTitle();
	}
}
