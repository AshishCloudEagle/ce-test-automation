package com.cloudeagle.helper.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cloudeagle.framework.helper.BasePageObject.PageBase;
import com.cloudeagle.framework.helper.Button.ButtonHelper;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.helper.TextBox.TextBoxHelper;

public class SaaSDirectoryPage extends PageBase {

	private WebDriver driver;

	GenericHelper gHelper;
	ButtonHelper bHelper;
	TextBoxHelper tHelper;

	public SaaSDirectoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gHelper = new GenericHelper(driver);
		bHelper = new ButtonHelper(driver);
		tHelper = new TextBoxHelper(driver);
	}

	/** Web Elements */

	@FindBy(xpath = "//*[text()='SaaS Directory' and contains(@class,'menuName')]")
	@CacheLookup
	private WebElement menuSaaSDirectory;

	@FindBy(xpath = "//input[@placeholder='Search']")
	@CacheLookup
	private WebElement search;

	By header = By.xpath("//*[contains(text(),'SAAS Directory')]");

	By crm = By.xpath("//*[text()='CRM Software' and contains(@class,'selected-value')]");

	String result = "//*[contains(@class,'productList')]//*[text()='%s']";

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public void clickOnSaaSDirectorySideMenu() {
		bHelper.click(menuSaaSDirectory);
		log("User clicks on SaaS Directory", false);
	}

	public void enterSearchCriteria(String searchText) {
		tHelper.sendKeys(search, searchText);
		log("Enter " + searchText + " in search box", false);
	}

	public void verifyResult(String searchText) {
		enterSearchCriteria(searchText);
		boolean status = gHelper.IsElementPresentQuick(By.xpath(String.format(result, searchText)));
		if (status)
			log("SaaS Directory result  is visible", false);
		else
			log("SaaS Directory result  is not visible", true);
		Assert.assertTrue(status);
	}

	public void verifyHeader() {
		boolean status = gHelper.IsElementPresentQuick(header);
		if (status)
			log("SaaS Directory header is visible", false);
		else
			log("SaaS Directory header is not visible", true);
		Assert.assertTrue(status);
	}

	public void verifyCRMFilter() {
		boolean status = gHelper.IsElementPresentQuick(crm);
		if (status)
			log("CRM filter is selected", false);
		else
			log("CRM filter is not selected", true);
		Assert.assertTrue(status);
	}
}
