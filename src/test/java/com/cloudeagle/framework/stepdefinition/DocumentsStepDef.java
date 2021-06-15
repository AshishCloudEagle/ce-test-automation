package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.DocumentsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DocumentsStepDef {

	DocumentsPage docP = new DocumentsPage(ObjectRepo.driver);
	WaitHelper wH = new WaitHelper(ObjectRepo.driver, ObjectRepo.reader);

	@When("^user navigate to documents page$")
	public void user_navigate_to_documents_page() throws Throwable {
		wH.staticWait(10);
		docP.clickOnDocumentsSideMenu();
	}

	@And("^user click on published documents$")
	public void click_on_published_documents() throws Throwable {
		wH.staticWait(10);
		docP.clickOnPublishedDocuments();
	}

	@Then("^user must be able to view documents table$")
	public void verify_aplications_table() throws Throwable {
		docP.verifyDocumentsDataTable(ObjectRepo.reader.getDocumentVendorName());
	}

}
