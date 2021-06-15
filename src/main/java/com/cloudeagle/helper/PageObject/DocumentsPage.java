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
import com.cloudeagle.framework.helper.TextBox.TextBoxHelper;
import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;

public class DocumentsPage extends PageBase {

	private WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(DocumentsPage.class);
	GenericHelper gHelper;
	WaitHelper wHelper;
	ButtonHelper bHelper;
	TextBoxHelper tHelper;

	public DocumentsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gHelper = new GenericHelper(driver);
		wHelper = new WaitHelper(driver, ObjectRepo.reader);
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
		wHelper.waitForElementToBeClickable(menuDocuments);
		bHelper.click(menuDocuments);
		log.info("User clicks on Documents");
	}

	public void enterSearchCriteria(String searchText) {
		wHelper.waitForElementVisible(search, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		tHelper.sendKeys(search, searchText);
		log.info(searchText);
	}

	public void verifyPublishedDocumentsDataTable(String searchText) {
		enterSearchCriteria(searchText);
		Assert.assertTrue(gHelper.IsElementPresentQuick(excelTable), "Documents Data Table is not visible");
		Assert.assertTrue(gHelper.IsElementPresentQuick(By.xpath(String.format(excelData, searchText))),
				"Documents Data searched row is not visible");
	}

	public void verifyHeader() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(header), "Vendor Header is not visible");
	}

	public void clickOnPublishedDocuments() {
		wHelper.waitForElementToBeClickable(publishedDocuments);
		bHelper.click(publishedDocuments);
		log.info("User clicks on Published Documents");
	}

	public void verifyUploadeddDocumentsDataTable(String searchText) {
		enterSearchCriteria(searchText);
		Assert.assertTrue(gHelper.IsElementPresentQuick(excelTable), "Documents Data Table is not visible");
		Assert.assertTrue(gHelper.IsElementPresentQuick(By.xpath(String.format(excelData, searchText))),
				"Documents Data searched row is not visible");
	}

	public void clickOnUploadedDocuments() {
		wHelper.waitForElementToBeClickable(uploadedDocuments);
		bHelper.click(uploadedDocuments);
		log.info("User clicks on Published Documents");
	}

}
