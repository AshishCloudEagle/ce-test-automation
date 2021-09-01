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
import com.cloudeagle.framework.helper.Wait.WaitHelper;

public class ExternalDataPage extends PageBase {

	private WebDriver driver;

	GenericHelper gHelper;
	ButtonHelper bHelper;
	TextBoxHelper tHelper;
	WaitHelper wait;

	public ExternalDataPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gHelper = new GenericHelper(driver);
		bHelper = new ButtonHelper(driver);
		tHelper = new TextBoxHelper(driver);
	}

	/** Web Elements */

	@FindBy(xpath = "//*[text()='External Data' and contains(@class,'menuName')]")
	@CacheLookup
	private WebElement menuExternalData;

	@FindBy(xpath = "//li[text()='Excel Data Upload']")
	@CacheLookup
	private WebElement excelDataUpload;

	@FindBy(xpath = "//li[div[text()='Vendor Metadata']]")
	@CacheLookup
	private WebElement vendorMetadata;
	
	@FindBy(xpath = "//li[div[text()='Application Metadata']]")
	@CacheLookup
	private WebElement applicationMetadata;
	
	@FindBy(xpath = "//li[text()='On-Demand Sync']")
	@CacheLookup
	private WebElement onDemandSync;

	@FindBy(xpath = "//li[text()='Data From Finance Systems']")
	@CacheLookup
	private WebElement dataFromFinanceSystems;

	@FindBy(xpath = "//input[@placeholder='Search']")
	@CacheLookup
	private WebElement search;

	@FindBy(xpath = "(//div[contains(@class,'drawer')]//input[@placeholder='Search'])[last()]")
	@CacheLookup
	private WebElement drawerSearch;

	@FindBy(xpath = "//*[text()='Upload File']")
	@CacheLookup
	private WebElement btnUploadFile;

	@FindBy(xpath = "//*[text()='Single Sign On' and contains(@class,'tab')]")
	@CacheLookup
	private WebElement singleSignOnBtn;

	@FindBy(xpath = "//*[text()='Finance Systems' and contains(@class,'tab')]")
	@CacheLookup
	private WebElement financeSystemBtn;

	@FindBy(xpath = "//*[text()='New Vendors Found' and contains(@class,'tab')]")
	@CacheLookup
	private WebElement newVendorsFoundBtn;

	@FindBy(xpath = "//span[text()='Existing Vendors']")
	@CacheLookup
	private WebElement existingVendorsBtn;

	@FindBy(xpath = "//span[text()='Existing Applications']")
	@CacheLookup
	private WebElement existingApplicationBtn;

	@FindBy(xpath = "(//button[contains(@class,'drawer-close')])[last()]")
	@CacheLookup
	private WebElement drawerClose;

	@FindBy(xpath = "//*[text()='Confirmed Vendors' and contains(@class,'tab')]")
	@CacheLookup
	private WebElement confirmedVendor;

	@FindBy(xpath = "//*[text()='Rejected Vendors' and contains(@class,'tab')]")
	@CacheLookup
	private WebElement rejectedVendors;

	@FindBy(xpath = "//li[text()='Data From SSO Systems']")
	@CacheLookup
	private WebElement dataFromSSOSystem;

	@FindBy(xpath = "//*[text()='New Apps Found' and contains(@class,'tab')]")
	@CacheLookup
	private WebElement newAppFound;

	@FindBy(xpath = "//*[text()='Confirmed Apps' and contains(@class,'tab')]")
	@CacheLookup
	private WebElement confirmApp;

	@FindBy(xpath = "//*[text()='Rejected Apps' and contains(@class,'tab')]")
	@CacheLookup
	private WebElement rejectedApp;

	@FindBy(xpath = "//*[text()='Existing Applications' and contains(@class,'drawer')]")
	@CacheLookup
	private WebElement existingApplication;

	By excelTable = By.xpath("(//table)[1]");

	By uploadModel = By.xpath("//*[contains(@class,'ant-modal-content')]");

	By singleSignOn = By.xpath("//li[text()='Single Sign On']");

	By financeSystems = By.xpath("//li[text()='Finance Systems']");

	By menuOnDemandSync = By.xpath("//li[text()='On-Demand Sync']");

	By menuDataFromFinanceSystems = By.xpath("//li[text()='Data From Finance Systems']");

	By menuDataFromSSOSystems = By.xpath("//li[text()='Data From SSO Systems']");

	By menuExcelDataUpload = By.xpath("//li[text()='Excel Data Upload']");

	String excelData = "(//table)[1]//tbody/tr[1]";

	String existingVendorsRecord = "(//table)[4]//tbody//tr[1]";

	String existingApplicationRecord = "(//table)[5]//tbody/tr[1]";
	
	By activePage = By.xpath("//*[text()='On-Demand Sync' and contains(@class,'Active')]");

	By slider = By.xpath("//*[(text()='Existing Vendors' or text()='Existing vendors') and contains(@class,'drawer')]");

	By applicationSlider = By.xpath("//*[text()='Existing Applications' and contains(@class,'drawer')]");

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public void clickOnExternalDataSideMenu() {
		bHelper.click(menuExternalData);
		log("User clicks on External Data", false);
	}

	public void clickOnExcelDataUpload() {
		bHelper.click(excelDataUpload);
		log("User clicks on Excel Data Upload", false);
	}
	
	public void clickOnVendorMetadataTab() {
		bHelper.click(vendorMetadata);
		log("User clicks on vendor Metadata tab", false);
	}
	
	public void clickOnApplicationMetadataTab() {
		bHelper.click(applicationMetadata);
		log("User clicks on application Metadata tab", false);
	}

	public void enterSearchCriteria(String searchText) {
		tHelper.sendKeys(search, searchText);
		log("Enter " + searchText + " in search box", false);
	}

	public void enterDrawerSearchCriteria(String searchText) {
		tHelper.sendKeys(drawerSearch, searchText);
		log("Enter " + searchText + " in search box", false);
	}

	public void verifyExcelDataTable(String searchText) {
//		enterSearchCriteria(searchText);
		boolean status = gHelper.IsElementPresentQuick(excelTable);
		if (status)
			log("Excel Data Table is visible", false);
		else
			log("Excel Data Table is not visible", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick1(excelData);
		if (status)
			log("Excel Data searched row is visible", false);
		else
			log("Excel Data searched row is not visible", true);
		Assert.assertTrue(status);
	}

	public void clickOnUploadFileBtn() {
		bHelper.click(btnUploadFile);
		log("User clicks on Upload File Button", false);
	}

	public void verifyUploadModel() {
		boolean status = gHelper.IsElementPresentQuick(uploadModel);
		if (status)
			log("Upload model is visible", false);
		else
			log("Upload model is not visible", true);
		Assert.assertTrue(status);
	}

	public void clickOnOnDemandSync() {
		bHelper.click(onDemandSync);
		log("User clicks on On-Demand Sync", false);
	}

	public void verifySingleSignOn() {
		boolean status = gHelper.IsElementPresentQuick(singleSignOn);
		if (status)
			log("Single Sign On is visible", false);
		else
			log("Single Sign On is not visible", true);
		Assert.assertTrue(status);
	}

	public void verifySidebarOptions() {
		boolean status = gHelper.IsElementPresentQuick(menuOnDemandSync);
		if (status)
			log("On-Demand Sync is visible", false);
		else
			log("On-Demand Sync is not visible", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuDataFromFinanceSystems);
		if (status)
			log("Data From Finance Systems is visible", false);
		else
			log("Data From Finance Systems is not visible", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuDataFromSSOSystems);
		if (status)
			log("Data From SSO Systems is visible", false);
		else
			log("Data From SSO Systems is not visible", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuExcelDataUpload);
		if (status)
			log("Excel Data Upload is visible", false);
		else
			log("Excel Data Upload is not visible", true);
		Assert.assertTrue(status);
	}

	public void verifyOnDemandSync() {
		boolean status = gHelper.IsElementPresentQuick(activePage);
		if (status)
			log("On Demand Sync is visible", false);
		else
			log("On Demand Sync is not visible", true);
		Assert.assertTrue(status);
	}

	public void clickOnSingleSignOn() {
		bHelper.click(singleSignOnBtn);
		log("User clicks on Single Sign On", false);
	}

	public void clickOnFinanceSystems() {
		bHelper.click(financeSystemBtn);
		log("User clicks on Finance System", false);
	}

	public void verifyFinanceSystem() {
		boolean status = gHelper.IsElementPresentQuick(financeSystems);
		if (status)
			log("Finance System is visible", false);
		else
			log("Finance System is not visible", true);
		Assert.assertTrue(status);
	}

	public void clickOnDataFromFinanceSystems() {
		bHelper.click(dataFromFinanceSystems);
		log("User clicks on Data From Finance Systems", false);
	}

	public void clickOnNewVendorsFound() {
		bHelper.click(newVendorsFoundBtn);
		log("User clicks on New Vendors Found", false);
	}

	public void clickOnExistingVendor() {
		bHelper.click(existingVendorsBtn);
		log("User clicks on Existing Vendors", false);
	}

	public void verifySlider() {
		boolean status = gHelper.IsElementPresentQuick(slider);
		if (status)
			log("Slider is visible", false);
		else
			log("Slider is not visible", true);
		Assert.assertTrue(status);
	}

	public void verifyExistingVendorRecords(String searchText) throws InterruptedException {
//		enterDrawerSearchCriteria(searchText);
		Thread.sleep(30000);
		boolean status = gHelper.IsElementPresentQuick1(existingVendorsRecord);
		if (status)
			log("Existing vendor searched row is visible", false);
		else
			log("Existing vendor searched row is not visible", true);
		Assert.assertTrue(status);
	}

	public void closeSlider() {
		bHelper.click(drawerClose);	
		log("User clicks on Close", false);
	}

	public void clickOnConfirmedVendors() {
		bHelper.click(confirmedVendor);
		log("User clicks on Confirmed Vendor", false);
	}

	public void clickOnRejectedVendors() {
		bHelper.click(rejectedVendors);
		log("User clicks on Rejected Vendor", false);
	}

	public void clickOnDataFromSSOSystems() {
		bHelper.click(dataFromSSOSystem);
		log("User clicks on Data From SSO System", false);
	}

	public void clickOnNewAppsFound() {
		bHelper.click(newAppFound);
		log("User clicks on New App Found", false);
	}

	public void clickOnExistingApplication() {
		bHelper.click(existingApplicationBtn);
		log("User clicks on Existing Application", false);
	}

	public void verifyApplicationSlider() {
		boolean status = gHelper.IsElementPresentQuick(applicationSlider);
		if (status)
			log("Slider is visible", false);
		else
			log("Slider is not visible", true);
		Assert.assertTrue(status);
	}

	public void verifyExistingApplicationRecords(String searchText) {
//		enterDrawerSearchCriteria(searchText);
		boolean status = gHelper.IsElementPresentQuick1(existingApplicationRecord);
		if (status)
			log("Existing application searched row is visible", false);
		else
			log("Existing application searched row is not visible", true);
		Assert.assertTrue(status);
	}
	
	public void clickOnConfirmedApps() {
		bHelper.click(confirmApp);
		log("User clicks on Confirmed App", false);
	}

	public void clickOnRejectedApps() {
		bHelper.click(rejectedApp);
		log("User clicks on Rejected App", false);
	}
}
