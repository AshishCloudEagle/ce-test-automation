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

	@FindBy(xpath = "//li[text()='Alert Settings']")
	@CacheLookup
	private WebElement alertSettings;

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

	By excelTable = By.xpath("(//table)[1]");

	By newUserHeader = By.xpath("//div[contains(@class,'header')]//*[text()='Add New User']");

	By newRoleHeader = By.xpath("//div[contains(@class,'header')]//*[text()='Create Role']");

	By newDepartmentHeader = By.xpath("//div[contains(@class,'header')]//*[text()='Add Department']");

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
		successLog("User clicks on Vendors");
	}

	public void verifySidebar() {
		boolean status = gHelper.IsElementPresentQuick(menuIntegrations);
		if (status)
			successLog("Integrations Menu is displaying");
		else
			failureLog("Integrations Menu is not displaying");
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuAlertSettings);
		if (status)
			successLog("Alert Settins Menu is displaying");
		else
			failureLog("Alert Settins Menu is not displaying");
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuRolesUsers);
		if (status)
			successLog("Roles & Users Menu is displaying");
		else
			failureLog("Roles & Users Menu is not displaying");
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(menuCompanySettings);
		if (status)
			successLog("Company Settings Menu is displaying");
		else
			failureLog("Company Settings Menu is not displaying");
		Assert.assertTrue(status);
	}

	public void verifyIntegrationToolsList() {
		boolean status = gHelper.IsElementPresentQuick(IntegrationList);
		if (status)
			successLog("Integration List is displaying");
		else
			failureLog("Integration List is not displaying");
		Assert.assertTrue(status);
	}

	public void clickOnIntegrations() {
		bHelper.click(Integrations);
		successLog("User clicks on Integrations");
	}

	public void clickOnSingleSignOn() {
		bHelper.click(singleSignOnBtn);
		successLog("User clicks on Single Sign On");
	}

	public void clickOnUserFinanceSystems() {
		bHelper.click(singleSignOnBtn);
		successLog("User clicks on Single Sign On");
	}

	public void verifyFinanceSystemsIntegrationToolsList() {
		boolean status = gHelper.IsElementPresentQuick(IntegrationList);
		if (status)
			successLog("Integration List is displaying");
		else
			failureLog("Integration List is not displaying");
		Assert.assertTrue(status);
	}

	public void clickOnAlertSettings() {
		bHelper.click(alertSettings);
		successLog("User clicks on Alert Settings");
	}

	public void clickOnRolesAndUsers() {
		bHelper.click(rolesAndUsers);
		successLog("User clicks on Roles And Users");
	}

	public void enterSearchCriteria(String searchText) {
		tHelper.sendKeys(search, searchText);
		successLog(searchText);
	}

	public void verifyTable(String searchText) {
		enterSearchCriteria(searchText);
		boolean status = gHelper.IsElementPresentQuick(excelTable);
		if (status)
			successLog("Excel Data Table is visible");
		else
			failureLog("Excel Data Table is not visible");
		Assert.assertTrue(status);
		status = gHelper.IsElementPresentQuick(By.xpath(String.format(excelData, searchText)));
		if (status)
			successLog("Excel Data searched row is visible");
		else
			failureLog("Excel Data searched row is not visible");
		Assert.assertTrue(status);
	}

	public void clickOnUser() {
		bHelper.click(users);
		successLog("User clicks on Users");
	}

	public void clickOnNewUser() {
		bHelper.click(newUser);
		successLog("User clicks on New User");
	}

	public void verifyNewUserPopup() {
		boolean status = gHelper.IsElementPresentQuick(newUserHeader);
		if (status)
			successLog("Add New User header is displaying");
		else
			failureLog("Add New User header is not displaying");
		Assert.assertTrue(status);
	}

	public void clickOnRoles() {
		bHelper.click(roles);
		successLog("User clicks on Roles");
	}

	public void clickOnCreateRole() {
		bHelper.click(createRole);
		successLog("User clicks on Create Role");
	}

	public void verifyNewRolePopup() {
		boolean status = gHelper.IsElementPresentQuick(newRoleHeader);
		if (status)
			successLog("Add New Role header is displaying");
		else
			failureLog("Add New Role header is not displaying");
		Assert.assertTrue(status);
	}

	public void clickOnDepartments() {
		bHelper.click(departments);
		successLog("User clicks on departments");
	}

	public void clickOnCreateDepartment() {
		bHelper.click(createDepartMent);
		successLog("User clicks on Create Department");
	}

	public void verifyNewDepartmentPopup() {
		boolean status = gHelper.IsElementPresentQuick(newDepartmentHeader);
		if (status)
			successLog("Add New Department header is displaying");
		else
			failureLog("Add New Department header is not displaying");
		Assert.assertTrue(status);
	}

	public void clickOnSettings() {
		bHelper.click(companySettings);
		successLog("User clicks on Seetings");
	}
}
