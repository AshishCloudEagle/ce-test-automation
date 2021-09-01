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

public class RequestAccessPage extends PageBase {

	private WebDriver driver;
	GenericHelper gHelper;
	ButtonHelper bHelper;
	TextBoxHelper tHelper;

	public RequestAccessPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gHelper = new GenericHelper(driver);
		bHelper = new ButtonHelper(driver);
		tHelper = new TextBoxHelper(driver);
	}

	/** Web Elements */

	@FindBy(xpath = "//*[text()='Request Access' and contains(@class,'menuName')]")
	@CacheLookup
	private WebElement menuRequestAccess;

	@FindBy(xpath = "//input[@placeholder='Search']")
	@CacheLookup
	private WebElement search;

	By header = By.xpath("//div[contains(@class,'menuHeading')]//*[text()='APPLICATIONS']");

	By excelTable = By.xpath("(//table)[1]");

	String excelData = "(//table)[1]//td//*[text()='%s']";

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public void clickOnRequestAccessSideMenu() {
		bHelper.click(menuRequestAccess);
		log("User clicks on Request Access", false);
	}

	public void enterSearchCriteria(String searchText) {
		tHelper.sendKeys(search, searchText);
		log("Enter " + searchText + " in search box", false);
	}

	public void verifyRequestAccessDataTable(String searchText) {
		enterSearchCriteria(searchText);
		boolean status = gHelper.IsElementPresentQuick(excelTable);
		if (status)
			log("Request Access Data Table is visible", false);
		else
			log("Request Access Data Table is not visible", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(By.xpath(String.format(excelData, searchText)));
		if (status)
			log("Request Access Data searched row is visible", false);
		else
			log("Request Access Data searched row is not visible", true);
		Assert.assertTrue(status);
	}

}
