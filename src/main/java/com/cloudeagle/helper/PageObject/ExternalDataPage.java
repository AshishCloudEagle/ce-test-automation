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

public class ExternalDataPage extends PageBase {

	private WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(ExternalDataPage.class);
	GenericHelper gH;

	public ExternalDataPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gH = new GenericHelper(driver);

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

	@FindBy(xpath = "//input[@placeholder='Search']")
	@CacheLookup
	private WebElement search;

	@FindBy(xpath = "//*[text()='Upload File']")
	@CacheLookup
	private WebElement btnUploadFile;

	By excelTable = By.xpath("(//table)[1]");

	By uploadModel = By.xpath("//*[contains(@id,'rcDialog')]");
	
	By singleSignOn = By.xpath("//li[text()='Single Sign On']");

	By menuOnDemandSync = By.xpath("//li[text()='On-Demand Sync']");
	
	By menuDataFromFinanceSystems = By.xpath("//li[text()='Data From Finance Systems']");
	
	By menuDataFromSSOSystems = By.xpath("//li[text()='Data From SSO Systems']");
	
	By menuExcelDataUpload = By.xpath("//li[text()='Excel Data Upload']");
	
	String excelData = "(//table)[1]//td[@title='%s']";

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public void clickOnExternalDataSideMenu() {
		menuExternalData.click();
		log.info("User clicks on External Data");
	}

	public void clickOnExcelDataUpload() {
		excelDataUpload.click();
		log.info("User clicks on Excel Data Upload");
	}

	public void enterSearchCriteria(String searchText) {
		search.sendKeys(searchText);
		log.info(searchText);
	}

	public void verifyExcelDataTable(String searchText) {
		enterSearchCriteria(searchText);
		Assert.assertTrue(gH.IsElementPresentQuick(excelTable), "Excel Data Table is not visible");
		Assert.assertTrue(gH.IsElementPresentQuick(By.xpath(String.format(excelData, searchText))),
				"Excel Data searched row is not visible");
	}

	public void clickOnUploadFileBtn() {
		btnUploadFile.click();
		log.info("User clicks on Upload File Button");
	}

	public void verifyUploadModel() {
		Assert.assertTrue(gH.IsElementPresentQuick(uploadModel), "Upload model is not visible");
	}

	public void clickOnOnDemandSync() {
		onDemandSync.click();
		log.info("User clicks on On-Demand Sync");
	}

	public void verifySingleSignOn() {
		Assert.assertTrue(gH.IsElementPresentQuick(singleSignOn), "Single Sign On is not visible");
	}

	public void verifySidebarOptions() {
		Assert.assertTrue(gH.IsElementPresentQuick(menuOnDemandSync), "On-Demand Sync is not visible");
		Assert.assertTrue(gH.IsElementPresentQuick(menuDataFromFinanceSystems), "Data From Finance Systems is not visible");
		Assert.assertTrue(gH.IsElementPresentQuick(menuDataFromSSOSystems), "Data From SSO Systems is not visible");
		Assert.assertTrue(gH.IsElementPresentQuick(menuExcelDataUpload), "Excel Data Upload is not visible");
	}
}
