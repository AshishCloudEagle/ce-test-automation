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

public class VendorPage extends PageBase {

	private WebDriver driver;
	private final static Logger log = LoggerHelper.getLogger(VendorPage.class);
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

	String excelData = "(//table)[1]//td//*[text()='%s']";

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public void clickOnVendorSideMenu() {
		bHelper.click(menuVendors);
		log.info("User clicks on Vendors");
	}

	public void enterSearchCriteria(String searchText) {
		tHelper.sendKeys(search, searchText);
		log.info("User enter " + searchText + " in search box");
	}

	public void verifyVendorDataTable(String searchText) {
		enterSearchCriteria(searchText);
		boolean status = gHelper.IsElementPresentQuick(excelTable);
		if (!status)
			log.error("Vendor Data Table is not visible");
		else
			log.info("Vendor Data Table is visible");
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(By.xpath(String.format(excelData, searchText)));
		if (!status)
			log.error("Vendor Data searched row is not visible");
		else
			log.info("Vendor Data searched row is visible");
		Assert.assertTrue(status);
	}

	public void verifyHeader() {
		boolean status = gHelper.IsElementPresentQuick(header);
		if (!status)
			log.error("Vendor Header is not visible");
		else
			log.info("Vendor Header is visible");
		Assert.assertTrue(status);
	}
}
