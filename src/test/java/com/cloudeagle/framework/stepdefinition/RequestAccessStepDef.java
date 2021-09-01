package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.constants.Constants;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.RequestAccessPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RequestAccessStepDef {
	RequestAccessPage reqP = new RequestAccessPage(ObjectRepo.driver);
	GenericHelper gH = new GenericHelper(ObjectRepo.driver);

	@When("^user navigate to request access page$")
	public void user_navigate_to_request_access_page() throws Throwable {
		reqP.clickOnRequestAccessSideMenu();
		gH.verifyURL(Constants.URL + ObjectRepo.reader.getRequestAccessURL());
	}

	@Then("^user must be able to view request access table$")
	public void verify_request_access_table() throws Throwable {
		reqP.verifyRequestAccessDataTable(ObjectRepo.reader.getRequestAccessApplicationName());
	}

}
