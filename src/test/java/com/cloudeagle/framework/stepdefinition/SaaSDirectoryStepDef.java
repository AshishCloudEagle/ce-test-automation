package com.cloudeagle.framework.stepdefinition;

import com.cloudeagle.constants.Constants;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
import com.cloudeagle.helper.PageObject.SaaSDirectoryPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SaaSDirectoryStepDef {
	SaaSDirectoryPage saasP = new SaaSDirectoryPage(ObjectRepo.driver);
	GenericHelper gH = new GenericHelper(ObjectRepo.driver);

	@When("^user navigate to saas directory page$")
	public void user_navigate_to_saas_directory_page() throws Throwable {
		saasP.clickOnSaaSDirectorySideMenu();
		gH.verifyURL(Constants.URL + ObjectRepo.reader.getSaaSDirectoryURL());
	}

	@Then("^user must be able to view saas directory header$")
	public void verify_saas_directory_header() throws Throwable {
		saasP.verifyHeader();
	}

	@When("^user search with vendor name$")
	public void user_search_with_vendor_name() throws Throwable {
		saasP.seachVendor(ObjectRepo.reader.getSaaSDirectoryVendorName());

	}

	@Then("^user must be able to view product list for searched vendor$")
	public void user_must_be_able_to_view_product_list_for_searched_vendor() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		saasP.verifyProductList();
	}

	@And("^verify one product under the searched vendor$")
	public void verify_one_product_under_the_searched_vendor() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		saasP.verifyResult(ObjectRepo.reader.getSaaSDirVendorProductName());
	}

	@When("^user search with category name$")
	public void user_search_with_category_name() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		saasP.searchCategory(ObjectRepo.reader.getSaaSDirectoryCategoryName());
	}

	@Then("^user must be able to view product list for searched category$")
	public void user_must_be_able_to_view_product_list_for_searched_category() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		saasP.verifyProductList();
	}

	@And("^verify one product under the searched category$")
	public void verify_one_product_under_the_searched_category() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		saasP.verifyResult(ObjectRepo.reader.getSaaSDirCategoryProductName());
	}
}
