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

public class DocumentsPage extends PageBase {

	private WebDriver driver;

	GenericHelper gHelper;
	ButtonHelper bHelper;
	TextBoxHelper tHelper;

	public DocumentsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gHelper = new GenericHelper(driver);
		bHelper = new ButtonHelper(driver);
		tHelper = new TextBoxHelper(driver);
	}

	/** Web Elements */

	@FindBy(xpath = "//*[text()='Documents' and contains(@class,'menuName')]")
	@CacheLookup
	private WebElement menuDocuments;

	@FindBy(xpath = "//*[text()='Published Documents']")
	@CacheLookup
	private WebElement publishedDocuments;

	@FindBy(xpath = "//*[text()='Uploaded Documents']")
	@CacheLookup
	private WebElement uploadedDocuments;

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

	public void clickOnDocumentsSideMenu() {
		bHelper.click(menuDocuments);
		log("User clicks on Documents", false);
	}

	public void enterSearchCriteria(String searchText) {
		tHelper.sendKeys(search, searchText);
		log("Enter " + searchText + " in search box", false);
	}

	public void verifyPublishedDocumentsDataTable(String searchText) {
		enterSearchCriteria(searchText);
		boolean status = gHelper.IsElementPresentQuick(excelTable);
		if (status)
			log("Documents Data Table is visible", false);
		else
			log("Documents Data Table is not visible", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(By.xpath(String.format(excelData, searchText)));
		if (status)
			log("Documents Data searched row is visible", false);
		else
			log("Documents Data searched row is not visible", true);
		Assert.assertTrue(status);
	}

	public void verifyHeader() {
		boolean status = gHelper.IsElementPresentQuick(header);
		if (status)
			log("Vendor Header is visible", false);
		else
			log("Vendor Header is not visible", true);
		Assert.assertTrue(status);
	}

	public void clickOnPublishedDocuments() {
		bHelper.click(publishedDocuments);
		log("User clicks on Published Documents", false);
	}

	public void verifyUploadeddDocumentsDataTable(String searchText) {
		enterSearchCriteria(searchText);
		boolean status = gHelper.IsElementPresentQuick(excelTable);
		if (status)
			log("Documents Data Table is visible", false);
		else
			log("Documents Data Table is not visible", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(By.xpath(String.format(excelData, searchText)));
		if (status)
			log("Documents Data searched row is visible", false);
		else
			log("Documents Data searched row is not visible", true);
		Assert.assertTrue(status);
	}

	public void clickOnUploadedDocuments() {
		bHelper.click(uploadedDocuments);
		log("User clicks on Published Documents", false);
	}
}
