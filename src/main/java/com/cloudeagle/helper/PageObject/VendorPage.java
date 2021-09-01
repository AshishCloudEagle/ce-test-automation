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

public class VendorPage extends PageBase {

	private WebDriver driver;
	GenericHelper gHelper;
	ButtonHelper bHelper;
	TextBoxHelper tHelper;

	public VendorPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gHelper = new GenericHelper(driver);
		bHelper = new ButtonHelper(driver);
		tHelper = new TextBoxHelper(driver);
	}

	/** Web Elements */

	@FindBy(xpath = "//*[text()='Vendors' and contains(@class,'menuName')]")
	@CacheLookup
	private WebElement menuVendors;

	@FindBy(xpath = "//input[@placeholder='Search']")
	@CacheLookup
	private WebElement search;

	By header = By.xpath("//div[contains(@class,'menuHeading')]//*[text()='VENDORS']");

	By excelTable = By.xpath("(//table)[1]");

	String excelData = "(//table)[1]//tbody/tr[1]";

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public void clickOnVendorSideMenu() {
		bHelper.click(menuVendors);
		log("User clicks on Vendors", false);
	}

	public void enterSearchCriteria(String searchText) {
		tHelper.sendKeys(search, searchText);
		log("User enter " + searchText + " in search box", false);
	}

	public void verifyVendorDataTable(String searchText) {
//		enterSearchCriteria(searchText);
		boolean status = gHelper.IsElementPresentQuick(excelTable);
		if (!status)
			log("Vendor Data Table is not visible", true);
		else
			log("Vendor Data Table is visible", false);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick1(excelData);
		if (!status)
			log("Vendor Data searched row is not visible", true);
		else
			log("Vendor Data searched row is visible", false);
		Assert.assertTrue(status);
	}

	public void verifyHeader() {
		boolean status = gHelper.IsElementPresentQuick(header);
		if (!status)
			log("Vendor Header is not visible", true);
		else
			log("Vendor Header is visible", false);
		Assert.assertTrue(status);
	}
}
