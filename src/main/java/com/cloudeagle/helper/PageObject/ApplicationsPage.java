package com.cloudeagle.helper.PageObject;

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
import com.cloudeagle.framework.helper.TextBox.TextBoxHelper;
import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;

public class ApplicationsPage extends PageBase {

	private WebDriver driver;

	GenericHelper gHelper;
	WaitHelper wHelper;
	ButtonHelper bHelper;
	TextBoxHelper tHelper;

	public ApplicationsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gHelper = new GenericHelper(driver);
		wHelper = new WaitHelper(driver, ObjectRepo.reader);
		bHelper = new ButtonHelper(driver);
		tHelper = new TextBoxHelper(driver);
	}

	/** Web Elements */

	@FindBy(xpath = "//*[text()='Applications' and contains(@class,'menuName')]")
	@CacheLookup
	private WebElement menuApplications;

	@FindBy(xpath = "//input[@placeholder='Search']")
	@CacheLookup
	private WebElement search;

	By header = By.xpath("//div[contains(@class,'menuHeading')]//*[text()='APPLICATIONS']");

	By appTable = By.xpath("(//table//tbody)[1]");

//	String excelData = "(//table)[1]//td//*[text()='%s']//parent::td//following-sibling::td//*[text()='%s']";
	String AppTableAppName = "(//table//td//span[text()='%s'])[1]";
	String AppTableVendorName = "(//table//td//span[text()='%s'])[1]";

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public void clickOnApplicationsSideMenu() {
		wHelper.waitForElementToBeClickable(menuApplications);
		bHelper.click(menuApplications);
		log("User clicks on Applications", false);
	}

	public void enterSearchCriteria(String searchText) {
		wHelper.waitForElementVisible(search, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		tHelper.sendKeys(search, searchText);
		log("Enter " + searchText + "in search box", false);
	}

	public void verifyApplicationsDataTable(String searchText, String vendorName) {
		boolean status = gHelper.IsElementPresentQuick(appTable);
		if (status)
			log("Applications Data Table is visible", false);
		else
			log("Applications Data Table is not visible", true);
		Assert.assertTrue(status);

		enterSearchCriteria(searchText);
		status = gHelper.IsElementPresentQuick(By.xpath(String.format(AppTableAppName, searchText)));
		if (status)
			log("Applications Data searched row is visible", false);
		else
			log("Applications Data searched row is not visible", true);
		Assert.assertTrue(status);

		status = gHelper.IsElementPresentQuick(By.xpath(String.format(AppTableVendorName, vendorName)));
		if (status)
			log("Applications Vendor is visible in row", false);
		else
			log("Applications Vendor is not visible in row", true);
		Assert.assertTrue(status);
	}

	public void verifyHeader() {
		boolean status = gHelper.IsElementPresentQuick(header);
		if (status)
			log("Applications Header is visible", false);
		else
			log("Applications Header is not visible", true);
		Assert.assertTrue(status);
	}
}
