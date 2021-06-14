package com.cloudeagle.helper.PageObject;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.cloudeagle.framework.helper.BasePageObject.PageBase;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.helper.Logger.LoggerHelper;

public class DashboardPage extends PageBase {

	private WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(DashboardPage.class);
	GenericHelper gH;

	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gH = new GenericHelper(driver);

	}

	/** Web Elements */

	@FindBy(xpath = "//div[contains(@class,'apphome_fName__1MEME')]")
	@CacheLookup
	private WebElement usename;

	@FindBy(xpath = "//div[contains(@class,'apphome_fName__1MEME')]//following-sibling::div")
	@CacheLookup
	private WebElement serverInstance;

	@FindBy(xpath = "//img[@alt='logo']")
	@CacheLookup
	private WebElement logoImg;

	@FindBy(xpath = "//*[text()='Number of Vendors']//following-sibling::h4")
	@CacheLookup
	private WebElement noOfVendors;

	@FindBy(xpath = "//*[text()='Number of Applications']//following-sibling::h4")
	@CacheLookup
	private WebElement noOfApplication;

	@FindBy(xpath = "//*[text()='Spend YTD']//following-sibling::h4")
	@CacheLookup
	private WebElement spendYTD;

	@FindBy(xpath = "//*[text()='Savings']//following-sibling::h4")
	@CacheLookup
	private WebElement savings;

	private By menuDashboard = By.xpath("//*[text()='Dashboard' and contains(@class,'menuName')]");

	private By menuVendors = By.xpath("//*[text()='Vendors' and contains(@class,'menuName')]");

	private By menuApplications = By.xpath("//*[text()='Applications' and contains(@class,'menuName')]");

	private By menuDocuments = By.xpath("//*[text()='Documents' and contains(@class,'menuName')]");

	private By menuSaaSDirectory = By.xpath("//*[text()='SaaS Directory' and contains(@class,'menuName')]");

	private By menuVendorResearch = By.xpath("//*[text()='Vendor Research' and contains(@class,'menuName')]");

	private By menuExternalData = By.xpath("//*[text()='External Data' and contains(@class,'menuName')]");

	private By menuAdmin = By.xpath("//*[text()='Admin' and contains(@class,'menuName')]");

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public String getUserName() {
		String text = usename.getText();
		log.info(text);
		return text;
	}

	public String getServerInstanceName() {
		String text = serverInstance.getText();
		log.info(text);
		return text;
	}

	public String getNumberOfVendors() {
		String text = noOfVendors.getText();
		log.info(text);
		return text;
	}

	public String getNumberOfApplication() {
		String text = noOfApplication.getText();
		log.info(text);
		return text;
	}

	public String getSpendYTD() {
		String text = spendYTD.getText();
		log.info(text);
		return text;
	}

	public String getSavings() {
		String text = savings.getText();
		log.info(text);
		return text;
	}

	public void verifyUserDetailsOnDashboardPage(String adminUserName, String serverName) {
		String usename = getUserName();
		String serverInstance = getServerInstanceName();
		if (!usename.equalsIgnoreCase(adminUserName)) {
			log.error("User name is not displaying on dashboard page");
			Assert.assertTrue("User name is not displaying on dashboard page", false);
		}
		if (!serverInstance.equalsIgnoreCase(serverName)) {
			log.error("Server instance name is not displaying on dashboard page");
			Assert.assertTrue("Server instance name is not displaying on dashboard page", false);
		}
	}

	public void clickOnLogo() {
		logoImg.click();
		log.info("User clicks on logo");
	}

	public void varifyPageHeadersOnDashboardPage() {
		String vendors = getNumberOfVendors();
		String application = getNumberOfApplication();
		String ytd = getSpendYTD();
		ytd = ytd.substring(1).replaceAll(",", "").trim();
		String saving = getSavings();
		saving = saving.substring(1).replaceAll(",", "").trim();
		System.err.println("###########" + vendors);
		System.err.println("###########" + application);
		System.err.println("###########" + ytd);
		System.err.println("###########" + saving);
		if (Integer.parseInt(vendors) <= 0) {
			log.error("Number of Vendors are <= 0");
			Assert.assertTrue("Number of Vendors are <= 0", false);
		}
		if (Integer.parseInt(application) <= 0) {
			log.error("Number of Applications are <= 0");
			Assert.assertTrue("Number of Applications are <= 0", false);
		}
		if (Integer.parseInt(ytd) <= 0) {
			log.error("Number of Vendors are <= 0");
			Assert.assertTrue("Number of Vendors are <= 0", false);
		}
		if (Integer.parseInt(saving) <= 0) {
			log.error("Number of Vendors are <= 0");
			Assert.assertTrue("Number of Vendors are <= 0", false);
		}
	}

	public void varifySideBarMenusOnDashboardPage() {
		Assert.assertTrue("Dasboard Menu is not displaying", gH.IsElementPresentQuick(menuDashboard));
		Assert.assertTrue("Vendors Menu is not displaying", gH.IsElementPresentQuick(menuVendors));
		Assert.assertTrue("Applications Menu is not displaying", gH.IsElementPresentQuick(menuApplications));
		Assert.assertTrue("Documents Menu is not displaying", gH.IsElementPresentQuick(menuDocuments));
		Assert.assertTrue("SaaS Directory Menu is not displaying", gH.IsElementPresentQuick(menuSaaSDirectory));
		Assert.assertTrue("Vendor Research Menu is not displaying", gH.IsElementPresentQuick(menuVendorResearch));
		Assert.assertTrue("External Data Menu is not displaying", gH.IsElementPresentQuick(menuExternalData));
		Assert.assertTrue("Admin Menu is not displaying", gH.IsElementPresentQuick(menuAdmin));
	}
}
