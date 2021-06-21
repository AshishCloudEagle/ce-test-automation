package com.cloudeagle.helper.PageObject;

import org.apache.log4j.Logger;
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
import com.cloudeagle.framework.helper.Logger.LoggerHelper;
import com.cloudeagle.framework.helper.TextBox.TextBoxHelper;

public class VendorResearchPage extends PageBase {

	private WebDriver driver;
	private final static Logger log = LoggerHelper.getLogger(VendorResearchPage.class);
	GenericHelper gHelper;
	ButtonHelper bHelper;
	TextBoxHelper tHelper;

	public VendorResearchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gHelper = new GenericHelper(driver);
		bHelper = new ButtonHelper(driver);
		tHelper = new TextBoxHelper(driver);
	}

	/** Web Elements */

	@FindBy(xpath = "//*[text()='Vendor Research' and contains(@class,'menuName')]")
	@CacheLookup
	private WebElement menuVendors;

	@FindBy(xpath = "//*[contains(@class,'search')]//input")
	@CacheLookup
	private WebElement search;

	By header = By.xpath("//*[text()='VENDOR RESEARCH']");

	String result = "//*[contains(@class,'research_prdTitle') and text()='%s']";

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public void clickOnVendorResearchSideMenu() {
		bHelper.click(menuVendors);
		log.info("User clicks on Vendors");
	}

	public void verifyHeader() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(header), "Vendor Header is not visible");
	}

	public void searchByVendorName(String vendorName) {
		tHelper.sendKeys(search, vendorName + Keys.ENTER);
		log.info(vendorName);
	}

	public void verifyResults(String vendorName) {
		Assert.assertTrue(gHelper.IsElementPresentQuick(By.xpath(String.format(result, vendorName))),
				"Searched result is not visible");
	}
}
