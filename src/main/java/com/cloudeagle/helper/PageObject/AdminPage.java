package com.cloudeagle.helper.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cloudeagle.framework.helper.BasePageObject.PageBase;
import com.cloudeagle.framework.helper.Button.ButtonHelper;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.helper.Logger.LoggerHelper;
import com.cloudeagle.framework.helper.TextBox.TextBoxHelper;

public class AdminPage extends PageBase {

	private WebDriver driver;
	private final static Logger log = LoggerHelper.getLogger(AdminPage.class);
	GenericHelper gHelper;
	ButtonHelper bHelper;
	TextBoxHelper tHelper;

	public AdminPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gHelper = new GenericHelper(driver);
		bHelper = new ButtonHelper(driver);
		tHelper = new TextBoxHelper(driver);
	}

	/** Web Elements */

	@FindBy(xpath = "//*[text()='Admin' and contains(@class,'menuName')]")
	@CacheLookup
	private WebElement menuAdmin;

	@FindBy(xpath = "//*[text()='Single Sign On' and contains(@class,'tab')]")
	@CacheLookup
	private WebElement singleSignOnBtn;

	@FindBy(xpath = "//li[text()='Alert Settings']")
	@CacheLookup
	private WebElement alertSettings;

	@FindBy(xpath = "//li[text()='Roles & Users']")
	@CacheLookup
	private WebElement rolesAndUsers;

	@FindBy(xpath = "//*[text()='USERS' and contains(@class,'tab')]")
	@CacheLookup
	private WebElement users;

	@FindBy(xpath = "//*[text()='Add Users']")
	@CacheLookup
	private WebElement newUser;

	@FindBy(xpath = "//input[@placeholder='Search']")
	@CacheLookup
	private WebElement search;

	@FindBy(xpath = "//li[text()='Integrations']")
	@CacheLookup
	private WebElement Integrations;

	By excelTable = By.xpath("(//table)[1]");

	By newUserHeader = By.xpath("//*[text()='Add New User']");

	String excelData = "(//table)[1]//td[@title='%s']";

	By menuIntegrations = By.xpath("//li[text()='Integrations']");

	By menuAlertSettings = By.xpath("//li[text()='Alert Settings']");

	By menuRolesUsers = By.xpath("//li[text()='Roles & Users']");

	By menuCompanySettings = By.xpath("//li[text()='Company Settings']");

	By IntegrationList = By.xpath("(//li[contains(@class,'options')])[last()]");

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public void clickOnAdminSideMenu() {
		bHelper.click(menuAdmin);
		log.info("User clicks on Vendors");
	}

	public void verifySidebar() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(menuIntegrations), "Integrations Menu is not displaying");
		Assert.assertTrue(gHelper.IsElementPresentQuick(menuAlertSettings), "Alert Settins Menu is not displaying");
		Assert.assertTrue(gHelper.IsElementPresentQuick(menuRolesUsers), "Roles & Users Menu is not displaying");
		Assert.assertTrue(gHelper.IsElementPresentQuick(menuCompanySettings),
				"Company Settings Menu is not displaying");
	}

	public void verifyIntegrationToolsList() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(IntegrationList), "Integration List is not displaying");
	}

	public void clickOnIntegrations() {
		bHelper.click(Integrations);
		log.info("User clicks on Integrations");
	}

	public void clickOnSingleSignOn() {
		bHelper.click(singleSignOnBtn);
		log.info("User clicks on Single Sign On");
	}

	public void clickOnuserFinanceSystems() {
		bHelper.click(singleSignOnBtn);
		log.info("User clicks on Single Sign On");
	}

	public void verifyFinanceSystemsIntegrationToolsList() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(IntegrationList), "Integration List is not displaying");
	}

	public void clickOnAlertSettings() {
		bHelper.click(alertSettings);
		log.info("User clicks on Alert Settings");
	}

	public void clickOnRolesAndUsers() {
		bHelper.click(rolesAndUsers);
		log.info("User clicks on Roles And Users");
	}

	public void enterSearchCriteria(String searchText) {
		tHelper.sendKeys(search, searchText);
		log.info(searchText);
	}

	public void verifyTable(String searchText) {
		enterSearchCriteria(searchText);
		Assert.assertTrue(gHelper.IsElementPresentQuick(excelTable), "Excel Data Table is not visible");
		Assert.assertTrue(gHelper.IsElementPresentQuick(By.xpath(String.format(excelData, searchText))),
				"Excel Data searched row is not visible");
	}

	public void clickOnUser() {
		bHelper.click(users);
		log.info("User clicks on Users");
	}

	public void clickOnNewUser() {
		bHelper.click(newUser);
		log.info("User clicks on New User");
	}

	public void verifyNewUserPopup() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(newUserHeader), "Add New User header is not displaying");
	}
}
