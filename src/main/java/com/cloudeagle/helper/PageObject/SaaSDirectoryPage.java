package com.cloudeagle.helper.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	@FindBy(xpath = "//div[div/div/div[text()='search by vendor name']]")
	@CacheLookup
	private WebElement searchVendorField;
	
	@FindBy(xpath = "//div[div[text()='search by vendor name']]//input")
	@CacheLookup
	private WebElement searchVendorinput;
	
	String selectListItem="//div//ul//li[text()='%s']";
	
	
	@FindBy(xpath = "//div[div/div/div[text()='search by category']]")
	@CacheLookup
	private WebElement searchCategoryField;

	@FindBy(xpath = "//div[div[text()='search by category']]//input")
	@CacheLookup
	private WebElement searchCategoryInput;
	
	@FindBy(xpath = "//span//span[text()='CRM Software']")
	@CacheLookup
	private WebElement clearFilter;

	String productList = "//div[contains(@class,'saasdirectory_productList')]";

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

	public void verifyHeader() {
		boolean status = gHelper.IsElementPresentQuick(header);
		if (status)
			log("SaaS Directory header is visible", false);
		else
			log("SaaS Directory header is not visible", true);
		Assert.assertTrue(status);
	}

	public void seachVendor(String vendorName) {
		bHelper.click(clearFilter);
		log("User clicks to clear selected filter", false);

		bHelper.click(searchVendorField);
		log("User clicks to clear selected filter", false);
		
		tHelper.sendKeys(searchVendorinput, vendorName + Keys.ENTER);
		log("User enter " + vendorName + " in search box", false);
		
		bHelper.click(selectListItem.replace("%s", vendorName));
		log("User clicks to clear selected filter", false);
	}

	public void verifyProductList() {
		boolean status = gHelper.IsElementPresentQuick1(productList);
		if (status)
			log("SaaS Directory result  is visible", false);
		else
			log("SaaS Directory result  is not visible", true);
		Assert.assertTrue(status);
	}

	public void verifyResult(String productName) {
		boolean status = gHelper.IsElementPresentQuick(By.xpath(String.format(result, productName)));
		if (status)
			log("SaaS Directory result  is visible", false);
		else
			log("SaaS Directory result  is not visible", true);
		Assert.assertTrue(status);
	}

	public void searchCategory(String categoryName) {
		bHelper.click(clearFilter);
		log("User clicks to clear selected filter", false);
		
		bHelper.click(searchCategoryField);
		log("User clicks to clear selected filter", false);
		
		tHelper.sendKeys(searchCategoryInput, categoryName);
		log("Enter " + categoryName + " in search box", false);
		
		bHelper.click(selectListItem.replace("%s", categoryName));
		log("User clicks to clear selected filter", false);

	}
}
