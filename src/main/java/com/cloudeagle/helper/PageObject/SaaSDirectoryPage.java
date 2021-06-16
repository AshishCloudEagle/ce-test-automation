package com.cloudeagle.helper.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cloudeagle.constants.Constants;
import com.cloudeagle.framework.helper.BasePageObject.PageBase;
import com.cloudeagle.framework.helper.Button.ButtonHelper;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.helper.Logger.LoggerHelper;
import com.cloudeagle.framework.helper.Navigation.NavigationHelper;
import com.cloudeagle.framework.helper.TextBox.TextBoxHelper;
import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;

public class SaaSDirectoryPage extends PageBase {

	private WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(SaaSDirectoryPage.class);
	GenericHelper gHelper;
	WaitHelper wHelper;
	ButtonHelper bHelper;
	TextBoxHelper tHelper;
	NavigationHelper nHelper;

	public SaaSDirectoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gHelper = new GenericHelper(driver);
		wHelper = new WaitHelper(driver, ObjectRepo.reader);
		bHelper = new ButtonHelper(driver);
		tHelper = new TextBoxHelper(driver);
		nHelper = new NavigationHelper(driver);
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
		wHelper.waitForElementToBeClickable(menuSaaSDirectory);
		bHelper.click(menuSaaSDirectory);
		log.info("User clicks on SaaS Directory");
	}

	public void enterSearchCriteria(String searchText) {
		wHelper.waitForElementVisible(search, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		tHelper.sendKeys(search, searchText);
		log.info(searchText);
	}

	public void verifyResult(String searchText) {
		enterSearchCriteria(searchText);
		Assert.assertTrue(gHelper.IsElementPresentQuick(By.xpath(String.format(result, searchText))),
				"SaaS Directory result  is not visible");
	}

	public void verifyURL(String url) {
		if (!url.equalsIgnoreCase(nHelper.getCurrentUrl()))
			Assert.assertTrue(false, "Url mis match");
	}

	public void verifyHeader() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(header), "SaaS Directory header is not visible");
	}

	public void verifyCRMFilter() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(crm), "CRM filter is not selected");
	}

}
