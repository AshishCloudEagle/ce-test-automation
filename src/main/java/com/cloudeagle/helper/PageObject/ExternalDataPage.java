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

public class ExternalDataPage extends PageBase {

	private WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(ExternalDataPage.class);
	GenericHelper gHelper;
	WaitHelper wHelper;
	ButtonHelper bHelper;
	TextBoxHelper tHelper;
	NavigationHelper nHelper;

	public ExternalDataPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gHelper = new GenericHelper(driver);
		bHelper = new ButtonHelper(driver);
		wHelper = new WaitHelper(driver, ObjectRepo.reader);
		tHelper = new TextBoxHelper(driver);
		nHelper = new NavigationHelper(driver);
	}

	/** Web Elements */

	@FindBy(xpath = "//*[text()='External Data' and contains(@class,'menuName')]")
	@CacheLookup
	private WebElement menuExternalData;

	@FindBy(xpath = "//li[text()='Excel Data Upload']")
	@CacheLookup
	private WebElement excelDataUpload;

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

	@FindBy(xpath = "//*[text()='Existing Applications' and contains(@class,'drawer')]")
	@CacheLookup
	private WebElement existingApplication;

	By excelTable = By.xpath("(//table)[1]");

	By uploadModel = By.xpath("//*[contains(@id,'rcDialog')]");

	By singleSignOn = By.xpath("//li[text()='Single Sign On']");

	By financeSystems = By.xpath("//li[text()='Finance Systems']");

	By menuOnDemandSync = By.xpath("//li[text()='On-Demand Sync']");

	By menuDataFromFinanceSystems = By.xpath("//li[text()='Data From Finance Systems']");

	By menuDataFromSSOSystems = By.xpath("//li[text()='Data From SSO Systems']");

	By menuExcelDataUpload = By.xpath("//li[text()='Excel Data Upload']");

	String excelData = "(//table)[1]//td[@title='%s']";

	String drawerExcelData = "(//td//*[text()='%s'])[1]";

	By activePage = By.xpath("//*[text()='On-Demand Sync' and contains(@class,'Active')]");

	By slider = By.xpath("//*[(text()='Existing Vendors' or text()='Existing vendors') and contains(@class,'drawer')]");

	By applicationSlider = By.xpath("//*[text()='Existing Applications' and contains(@class,'drawer')]");

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public void clickOnExternalDataSideMenu() {
		wHelper.waitForElementToBeClickable(menuExternalData);
		bHelper.click(menuExternalData);
		log.info("User clicks on External Data");
	}

	public void clickOnExcelDataUpload() {
		wHelper.waitForElementToBeClickable(excelDataUpload);
		bHelper.click(excelDataUpload);
		log.info("User clicks on Excel Data Upload");
	}

	public void enterSearchCriteria(String searchText) {
		wHelper.waitForElementVisible(search, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		tHelper.sendKeys(search, searchText);
		log.info(searchText);
	}

	public void enterDrawerSearchCriteria(String searchText) {
		wHelper.staticWait(5);
		wHelper.waitForElementVisible(drawerSearch, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		tHelper.sendKeys(drawerSearch, searchText);
		log.info(searchText);
	}

	public void verifyExcelDataTable(String searchText) {
		enterSearchCriteria(searchText);
		Assert.assertTrue(gHelper.IsElementPresentQuick(excelTable), "Excel Data Table is not visible");
		Assert.assertTrue(gHelper.IsElementPresentQuick(By.xpath(String.format(excelData, searchText))),
				"Excel Data searched row is not visible");
	}

	public void clickOnUploadFileBtn() {
		wHelper.waitForElementToBeClickable(btnUploadFile);
		bHelper.click(btnUploadFile);
		log.info("User clicks on Upload File Button");
	}

	public void verifyUploadModel() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(uploadModel), "Upload model is not visible");
	}

	public void clickOnOnDemandSync() {
		wHelper.waitForElementToBeClickable(onDemandSync);
		bHelper.click(onDemandSync);
		log.info("User clicks on On-Demand Sync");
	}

	public void verifySingleSignOn() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(singleSignOn), "Single Sign On is not visible");
	}

	public void verifySidebarOptions() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(menuOnDemandSync), "On-Demand Sync is not visible");
		Assert.assertTrue(gHelper.IsElementPresentQuick(menuDataFromFinanceSystems),
				"Data From Finance Systems is not visible");
		Assert.assertTrue(gHelper.IsElementPresentQuick(menuDataFromSSOSystems),
				"Data From SSO Systems is not visible");
		Assert.assertTrue(gHelper.IsElementPresentQuick(menuExcelDataUpload), "Excel Data Upload is not visible");
	}

	public void verifyURL(String url) {
		if (!url.equalsIgnoreCase(nHelper.getCurrentUrl()))
			Assert.assertTrue(false, "Url mis match");
	}

	public void verifyOnDemandSync() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(activePage), "On Demand Sync is not visible");
	}

	public void clickOnSingleSignOn() {
		wHelper.waitForElementToBeClickable(singleSignOnBtn);
		bHelper.click(singleSignOnBtn);
		log.info("User clicks on Single Sign On");
	}

	public void clickOnFinanceSystems() {
		wHelper.waitForElementToBeClickable(financeSystemBtn);
		bHelper.click(financeSystemBtn);
		log.info("User clicks on Finance System");
	}

	public void verifyFinanceSystem() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(financeSystems), "Finance System is not visible");
	}

	public void clickOnDataFromFinanceSystems() {
		wHelper.waitForElementToBeClickable(dataFromFinanceSystems);
		bHelper.click(dataFromFinanceSystems);
		log.info("User clicks on Data From Finance Systems");
	}

	public void clickOnNewVendorsFound() {
		wHelper.waitForElementToBeClickable(newVendorsFoundBtn);
		bHelper.click(newVendorsFoundBtn);
		log.info("User clicks on New Vendors Found");
	}

	public void clickOnExistingVendor() {
		wHelper.waitForElementToBeClickable(existingVendorsBtn);
		bHelper.click(existingVendorsBtn);
		log.info("User clicks on Existing Vendors");
	}

	public void verifySlider() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(slider), "Slider is not visible");
	}

	public void verifyExistingVendorRecords(String searchText) {
//		enterDrawerSearchCriteria(searchText);
		Assert.assertTrue(gHelper.IsElementPresentQuick(By.xpath(String.format(drawerExcelData, searchText))),
				"Excel Data searched row is not visible");
	}

	public void closeSlider() {
		wHelper.waitForElementToBeClickable(drawerClose);
		bHelper.click(drawerClose);
		log.info("User clicks on Close");
	}

	public void clickOnConfirmedVendors() {
		wHelper.waitForElementToBeClickable(confirmedVendor);
		bHelper.click(confirmedVendor);
		log.info("User clicks on Confirmed Vendor");
	}

	public void clickOnRejectedVendors() {
		wHelper.waitForElementToBeClickable(rejectedVendors);
		bHelper.click(rejectedVendors);
		log.info("User clicks on Rejected Vendor");
	}

	public void clickOnDataFromSSOSystems() {
		wHelper.waitForElementToBeClickable(dataFromSSOSystem);
		bHelper.click(dataFromSSOSystem);
		log.info("User clicks on Data From SSO System");
	}

	public void clickOnNewAppsFound() {
		wHelper.waitForElementToBeClickable(newAppFound);
		bHelper.click(newAppFound);
		log.info("User clicks on New App Found");
	}

	public void clickOnExistingApplication() {
		wHelper.waitForElementToBeClickable(existingApplicationBtn);
		bHelper.click(existingApplicationBtn);
		log.info("User clicks on Existing Application");
	}

	public void verifyApplicationSlider() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(applicationSlider), "Slider is not visible");
	}
}
