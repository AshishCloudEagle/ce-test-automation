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

public class VendorPage extends PageBase {

	private WebDriver driver;
	private final static Logger log = LoggerHelper.getLogger(VendorPage.class);
	GenericHelper gHelper;
	WaitHelper wHelper;
	ButtonHelper bHelper;
	TextBoxHelper tHelper;
	NavigationHelper nHelper;

	public VendorPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gHelper = new GenericHelper(driver);
		wHelper = new WaitHelper(driver, ObjectRepo.reader);
		bHelper = new ButtonHelper(driver);
		tHelper = new TextBoxHelper(driver);
		nHelper = new NavigationHelper(driver);
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
		wHelper.waitForElementToBeClickable(menuVendors);
		bHelper.click(menuVendors);
		log.info("User clicks on Vendors");
	}

	public void enterSearchCriteria(String searchText) {
		wHelper.waitForElementVisible(search, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		tHelper.sendKeys(search, searchText);
		log.info(searchText);
	}

	public void verifyVendorDataTable(String searchText) {
		enterSearchCriteria(searchText);
		Assert.assertTrue(gHelper.IsElementPresentQuick(excelTable), "Vendor Data Table is not visible");
		Assert.assertTrue(gHelper.IsElementPresentQuick(By.xpath(String.format(excelData, searchText))),
				"Vendor Data searched row is not visible");
	}

	public void verifyHeader() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(header), "Vendor Header is not visible");
	}

	public void verifyURL(String url) {
		if(!url.equalsIgnoreCase(nHelper.getCurrentUrl()))
			Assert.assertTrue(false, "Url mis match");
	}
}
