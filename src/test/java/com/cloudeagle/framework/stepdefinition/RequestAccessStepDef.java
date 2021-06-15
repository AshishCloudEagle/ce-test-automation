package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.RequestAccessPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RequestAccessStepDef {

	RequestAccessPage reqP = new RequestAccessPage(ObjectRepo.driver);
	WaitHelper wH = new WaitHelper(ObjectRepo.driver, ObjectRepo.reader);

	@When("^user navigate to request access page$")
	public void user_navigate_to_request_access_page() throws Throwable {
		wH.staticWait(10);
		reqP.clickOnRequestAccessSideMenu();
		reqP.verifyURL(ObjectRepo.reader.getRequestAccessURL());
	}

	@Then("^user must be able to view request access table$")
	public void verify_request_access_table() throws Throwable {
		reqP.verifyRequestAccessDataTable(ObjectRepo.reader.getRequestAccessApplicationName());
	}

}
