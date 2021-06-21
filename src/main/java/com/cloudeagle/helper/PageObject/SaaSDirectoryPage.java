package com.cloudeagle.helper.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cloudeagle.framework.helper.BasePageObject.PageBase;
import com.cloudeagle.framework.helper.Button.ButtonHelper;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.helper.Logger.LoggerHelper;
import com.cloudeagle.framework.helper.TextBox.TextBoxHelper;

public class SaaSDirectoryPage extends PageBase {

	private WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(SaaSDirectoryPage.class);
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
		log.info("User clicks on SaaS Directory");
	}

	public void enterSearchCriteria(String searchText) {
		tHelper.sendKeys(search, searchText);
		log.info(searchText);
	}

	public void verifyResult(String searchText) {
		enterSearchCriteria(searchText);
		Assert.assertTrue(gHelper.IsElementPresentQuick(By.xpath(String.format(result, searchText))),
				"SaaS Directory result  is not visible");
	}

	public void verifyHeader() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(header), "SaaS Directory header is not visible");
	}

	public void verifyCRMFilter() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(crm), "CRM filter is not selected");
	}

}
