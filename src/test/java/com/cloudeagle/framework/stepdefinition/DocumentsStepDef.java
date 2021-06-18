package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.constants.Constants;
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
		docP.verifyURL(Constants.URL + ObjectRepo.reader.getPublishedDocumentURL());
	}

	@And("^user click on uploaded documents$")
	public void click_on_uploaded_documents() throws Throwable {
		wH.staticWait(10);
		docP.clickOnUploadedDocuments();
		docP.verifyURL(ObjectRepo.reader.getUploadedDocumentURL());
	}

	@Then("^user must be able to view published documents table$")
	public void verify_published_documents_table() throws Throwable {
		docP.verifyPublishedDocumentsDataTable(ObjectRepo.reader.getPublishedDocumentVendorName());
	}

	@Then("^user must be able to view uploaded documents table$")
	public void verify_uploaded_documents_table() throws Throwable {
		docP.verifyUploadeddDocumentsDataTable(ObjectRepo.reader.getUploadedDocumentVendorName());
	}

}
