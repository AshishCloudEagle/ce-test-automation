package com.cloudeagle.helper.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cloudeagle.framework.helper.BasePageObject.PageBase;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.helper.Logger.LoggerHelper;

public class ApplicationsPage extends PageBase {

	private WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(ApplicationsPage.class);
	GenericHelper gH;

	public ApplicationsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gH = new GenericHelper(driver);

	}

	/** Web Elements */

	@FindBy(xpath = "//*[text()='Applications' and contains(@class,'menuName')]")
	@CacheLookup
	private WebElement menuApplications;

	@FindBy(xpath = "//input[@placeholder='Search']")
	@CacheLookup
	private WebElement search;

	By header = By.xpath("//div[contains(@class,'menuHeading')]//*[text()='VENDORS']");

	By excelTable = By.xpath("(//table)[1]");

	String excelData = "(//table)[1]//td//*[text()='%s']//parent::td//following-sibling::td//*[text()='%s']";

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public void clickOnApplicationsSideMenu() {
		menuApplications.click();
		log.info("User clicks on Applications");
	}

	public void enterSearchCriteria(String searchText) {
		search.sendKeys(searchText);
		log.info(searchText);
	}

	public void verifyApplicationsDataTable(String searchText, String vendorName) {
		enterSearchCriteria(searchText);
		Assert.assertTrue(gH.IsElementPresentQuick(excelTable), "Applications Data Table is not visible");
		Assert.assertTrue(gH.IsElementPresentQuick(By.xpath(String.format(excelData, searchText, vendorName))),
				"Applications Data searched row is not visible");
	}

	public void verifyHeader() {
		Assert.assertTrue(gH.IsElementPresentQuick(header), "Vendor Header is not visible");
	}

}
