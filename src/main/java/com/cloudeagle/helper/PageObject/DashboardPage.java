package com.cloudeagle.helper.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.cloudeagle.framework.helper.BasePageObject.PageBase;
import com.cloudeagle.framework.helper.Button.ButtonHelper;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.helper.TextBox.TextBoxHelper;
import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;

public class DashboardPage extends PageBase {

	private WebDriver driver;

	GenericHelper gHelper;
	ButtonHelper bHelper;
	TextBoxHelper tHelper;
	WaitHelper wHelper;

	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gHelper = new GenericHelper(driver);
		bHelper = new ButtonHelper(driver);
		tHelper = new TextBoxHelper(driver);
		wHelper = new WaitHelper(driver, ObjectRepo.reader);
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
		String text = tHelper.getText(usename);
		log("Username is " + text, false);
		return text;
	}

	public String getServerInstanceName() {
		String text = tHelper.getText(serverInstance);
		log("Server instance name is " + text, false);
		return text;
	}

	public String getNumberOfVendors() {
		String text = tHelper.getText(noOfVendors);
		log("Number of vendors are " + text, false);
		return text;
	}

	public String getNumberOfApplication() {
		String text = tHelper.getText(noOfApplication);
		log("Number of applications are " + text, false);
		return text;
	}

	public String getSpendYTD() {
		String text = tHelper.getText(spendYTD);
		log("Spend YTD are " + text, false);
		return text;
	}

	public String getSavings() {
		String text = tHelper.getText(savings);
		log("Savings are" + text, false);
		return text;
	}

	public void verifyUserDetailsOnDashboardPage(String adminUserName, String serverName) {
		String usename = getUserName();
		String serverInstance = getServerInstanceName();
		if (!usename.equalsIgnoreCase(adminUserName)) {
			log("User name is not displaying on dashboard page", true);
			Assert.assertTrue(false);
		}
		if (!serverInstance.equalsIgnoreCase(serverName)) {
			log("Server instance name is not displaying on dashboard page", true);
			Assert.assertTrue(false);
		}
	}

	public void clickOnLogo() {
		wHelper.hardWait(5000);
		bHelper.click(logoImg);
		log("User clicks on logo", false);
	}

	public void varifyPageHeadersOnDashboardPage() {
		String vendors = getNumberOfVendors();
		String application = getNumberOfApplication();
		String ytd = getSpendYTD();
		ytd = ytd.substring(1).replaceAll(",", "").trim();
		String saving = getSavings();
		saving = saving.substring(1).replaceAll(",", "").trim();
		if (Integer.parseInt(vendors) <= 0) {
			log("Number of Vendors are <= 0", true);
			Assert.assertTrue("Number of Vendors are <= 0", false);
		}
		if (Integer.parseInt(application) <= 0) {
			log("Number of Applications are <= 0", true);
			Assert.assertTrue("Number of Applications are <= 0", false);
		}
		if (Integer.parseInt(ytd) <= 0) {
			log("Number of Vendors are <= 0", true);
			Assert.assertTrue("Number of Vendors are <= 0", false);
		}
		if (Integer.parseInt(saving) <= 0) {
			log("Number of Vendors are <= 0", true);
			Assert.assertTrue("Number of Vendors are <= 0", false);
		}
	}

	public void varifySideBarMenusOnDashboardPage() {
		boolean status = gHelper.IsElementPresentQuick(menuDashboard);
		if (status)
			log("Dasboard Menu is displaying", false);
		else
			log("Dasboard Menu is not displaying", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuVendors);
		if (status)
			log("Vendors Menu is displaying", false);
		else
			log("Vendors Menu is not displaying", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuApplications);
		if (status)
			log("Applications Menu is displaying", false);
		else
			log("Applications Menu is not displaying", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuDocuments);
		if (status)
			log("Documents Menu is displaying", false);
		else
			log("Documents Menu is not displaying", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuSaaSDirectory);
		if (status)
			log("SaaS Directory Menu is displaying", false);
		else
			log("SaaS Directory Menu is not displaying", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuVendorResearch);
		if (status)
			log("Vendor Research Menu is displaying", false);
		else
			log("Vendor Research Menu is not displaying", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuExternalData);
		if (status)
			log("External Data Menu is displaying", false);
		else
			log("External Data Menu is not displaying", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuAdmin);
		if (status)
			log("Admin Menu is displaying", false);
		else
			log("Admin Menu is not displaying", true);
		Assert.assertTrue(status);
	}
}
