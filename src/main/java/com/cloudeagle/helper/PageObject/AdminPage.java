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

public class AdminPage extends PageBase {

	private WebDriver driver;
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

	@FindBy(xpath = "//*[text()='Finance Systems' and contains(@class,'tab')]")
	@CacheLookup
	private WebElement finanaceSystemBtn;

	@FindBy(xpath = "//li[text()='Dashboard Settings']")
	@CacheLookup
	private WebElement dashboardSettings;

	@FindBy(xpath = "//li//div[text()='Action NEEDED Settings']")
	@CacheLookup
	private WebElement actionNeededSettings;

	@FindBy(xpath = "//li[text()='Roles & Users']")
	@CacheLookup
	private WebElement rolesAndUsers;

	@FindBy(xpath = "//*[text()='USERS' and contains(@class,'tab')]")
	@CacheLookup
	private WebElement users;

	@FindBy(xpath = "//*[text()='ROLES' and contains(@class,'tab')]")
	@CacheLookup
	private WebElement roles;

	@FindBy(xpath = "//*[text()='DEPARTMENTS' and contains(@class,'tab')]")
	@CacheLookup
	private WebElement departments;

	@FindBy(xpath = "//*[text()='Add Users']")
	@CacheLookup
	private WebElement newUser;

	@FindBy(xpath = "//*[text()='Create Role']")
	@CacheLookup
	private WebElement createRole;

	@FindBy(xpath = "//*[text()='Create Department']")
	@CacheLookup
	private WebElement createDepartMent;

	@FindBy(xpath = "//input[@placeholder='Search']")
	@CacheLookup
	private WebElement search;

	@FindBy(xpath = "//li[text()='Integrations']")
	@CacheLookup
	private WebElement Integrations;

	@FindBy(xpath = "//li[text()='Company Settings']")
	@CacheLookup
	private WebElement companySettings;

	By tableRecords = By.xpath("(//table//tbody)[1]");

	By newUserHeader = By.xpath("//div[contains(@class,'header')]//*[text()='Add New User']");

	By newRoleHeader = By.xpath("//div[contains(@class,'header')]//*[text()='Create Role']");

	By newDepartmentHeader = By.xpath("//div[contains(@class,'header')]//*[text()='Add Department']");

	String tableRowUser = "((//table)[1]//td[@title='%s'])[1]";

	String tableRowRole = "(//table//td//span[text()='%s'])[1]";

	By menuIntegrations = By.xpath("//li[text()='Integrations']");

	By menuDashboardSettings = By.xpath("//li[text()='Dashboard Settings']");

	By menuRolesUsers = By.xpath("//li[text()='Roles & Users']");

	By menuCompanySettings = By.xpath("//li[text()='Company Settings']");

	By IntegrationList = By.xpath("(//li[contains(@class,'options')])[last()]");

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public void clickOnAdminSideMenu() {
		bHelper.click(menuAdmin);
		log("User clicks on Admin", false);
	}

	public void verifySidebar() {
		boolean status = gHelper.IsElementPresentQuick(menuIntegrations);
		if (status)
			log("Integrations Menu is displaying", false);
		else
			log("Integrations Menu is not displaying", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuDashboardSettings);
		if (status)
			log("Dashboard Settins Menu is displaying", false);
		else
			log("Dashboard Settins Menu is not displaying", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuRolesUsers);
		if (status)
			log("Roles & Users Menu is displaying", false);
		else
			log("Roles & Users Menu is not displaying", true);
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuCompanySettings);
		if (status)
			log("Company Settings Menu is displaying", false);
		else
			log("Company Settings Menu is not displaying", true);
		Assert.assertTrue(status);
	}

	public void verifyIntegrationToolsList() {
		boolean status = gHelper.IsElementPresentQuick(IntegrationList);
		if (status)
			log("Integration List is displaying", false);
		else
			log("Integration List is not displaying", true);
		Assert.assertTrue(status);
	}

	public void clickOnIntegrations() {
		bHelper.click(Integrations);
		log("User clicks on Integrations", false);
	}

	public void clickOnSingleSignOn() {
		bHelper.click(singleSignOnBtn);
		log("User clicks on Single Sign On", false);
	}

	public void clickOnUserFinanceSystems() {
		bHelper.click(finanaceSystemBtn);
		log("User clicks on Finance Systems", false);
	}

	public void verifyFinanceSystemsIntegrationToolsList() {
		boolean status = gHelper.IsElementPresentQuick(IntegrationList);
		if (status)
			log("Integration List is displaying", false);
		else
			log("Integration List is not displaying", true);
		Assert.assertTrue(status);
	}

	public void clickOnDashboardSettings() {
		bHelper.click(dashboardSettings);
		log("User clicks on Dashboard Settings", false);
	}

	public void clickOnDashActionNeededSettings() {
		bHelper.click(actionNeededSettings);
		log("User clicks on action Needed Settings", false);
	}

	public void clickOnRolesAndUsers() {
		bHelper.click(rolesAndUsers);
		log("User clicks on Roles And Users", false);
	}

	public void enterSearchCriteria(String searchText) {
		tHelper.sendKeys(search, searchText);
		log("User enter " + searchText + " in search box", false);
	}

	public void verifyTable(String searchText, String tableName) {
		enterSearchCriteria(searchText);
		boolean status = gHelper.IsElementPresentQuick(tableRecords);
		if (status)
			log(tableName + "Table is visible", false);
		else
			log(tableName + "Table is not visible", true);
		Assert.assertTrue(status);
		if (tableName == "Role") {
			status = gHelper.IsElementPresentQuick(By.xpath(String.format(tableRowRole, searchText)));
		}
		if (tableName == "User") {
			status = gHelper.IsElementPresentQuick(By.xpath(String.format(tableRowUser, searchText)));

		}
		if (tableName == "Dept") {
			status = gHelper.IsElementPresentQuick(By.xpath(String.format(tableRowRole, searchText)));
		}

		if (status)
			log(tableName + "searched row is visible", false);
		else
			log(tableName + "searched row is not visible", true);
		Assert.assertTrue(status);
	}

	public void clickOnUser() {
		bHelper.click(users);
		log("User clicks on Users", false);
	}

	public void clickOnNewUser() {
		bHelper.click(newUser);
		log("User clicks on New User", false);
	}

	public void verifyNewUserPopup() {
		boolean status = gHelper.IsElementPresentQuick(newUserHeader);
		if (status)
			log("Add New User header is displaying", false);
		else
			log("Add New User header is not displaying", true);
		Assert.assertTrue(status);
	}

	public void clickOnRoles() {
		bHelper.click(roles);
		log("User clicks on Roles", false);
	}

	public void clickOnCreateRole() {
		bHelper.click(createRole);
		log("User clicks on Create Role", false);
	}

	public void verifyNewRolePopup() {
		boolean status = gHelper.IsElementPresentQuick(newRoleHeader);
		if (status)
			log("Add New Role header is displaying", false);
		else
			log("Add New Role header is not displaying", true);
		Assert.assertTrue(status);
	}

	public void clickOnDepartments() {
		bHelper.click(departments);
		log("User clicks on departments", false);
	}

	public void clickOnCreateDepartment() {
		bHelper.click(createDepartMent);
		log("User clicks on Create Department", false);
	}

	public void verifyNewDepartmentPopup() {
		boolean status = gHelper.IsElementPresentQuick(newDepartmentHeader);
		if (status)
			log("Add New Department header is displaying", false);
		else
			log("Add New Department header is not displaying", true);
		Assert.assertTrue(status);
	}

	public void clickOnSettings() {
		bHelper.click(companySettings);
		log("User clicks on Seetings", false);
	}
}
