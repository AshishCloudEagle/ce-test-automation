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
import com.cloudeagle.framework.helper.Navigation.NavigationHelper;
import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;

public class AdminPage extends PageBase {

	private WebDriver driver;
	private final static Logger log = LoggerHelper.getLogger(AdminPage.class);
	GenericHelper gHelper;
	WaitHelper wHelper;
	ButtonHelper bHelper;
	NavigationHelper nHelper;

	public AdminPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		gHelper = new GenericHelper(driver);
		wHelper = new WaitHelper(driver, ObjectRepo.reader);
		bHelper = new ButtonHelper(driver);
		nHelper = new NavigationHelper(driver);
	}

	/** Web Elements */

	@FindBy(xpath = "//*[text()='Admin' and contains(@class,'menuName')]")
	@CacheLookup
	private WebElement menuAdmin;

	@FindBy(xpath = "//*[text()='Single Sign On' and contains(@class,'tab')]")
	@CacheLookup
	private WebElement singleSignOnBtn;

	@FindBy(xpath = "//li[text()='Integrations']")
	@CacheLookup
	private WebElement Integrations;

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
		wHelper.waitForElementToBeClickable(menuAdmin);
		bHelper.click(menuAdmin);
		log.info("User clicks on Vendors");
	}

	public void verifyURL(String url) {
		if (!url.equalsIgnoreCase(nHelper.getCurrentUrl()))
			Assert.assertTrue(false, "Url mis match");
	}

	public void verifySidebar() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(menuIntegrations), "Integrations Menu is not displaying");
		Assert.assertTrue(gHelper.IsElementPresentQuick(menuAlertSettings), "Alert Settins Menu is not displaying");
		Assert.assertTrue(gHelper.IsElementPresentQuick(menuRolesUsers), "Roles & Users Menu is not displaying");
		Assert.assertTrue(gHelper.IsElementPresentQuick(menuCompanySettings),
				"Company Settings Menu is not displaying");
	}

	public void verifyIntegrationToolsList() {
		Assert.assertTrue(gHelper.IsElementPresentQuick(IntegrationList),
				"Integration List is not displaying");
	}

	public void clickOnIntegrations() {
		wHelper.waitForElementToBeClickable(Integrations);
		bHelper.click(Integrations);
		log.info("User clicks on Integrations");
	}

	public void clickOnSingleSignOn() {
		wHelper.waitForElementToBeClickable(singleSignOnBtn);
		bHelper.click(singleSignOnBtn);
		log.info("User clicks on Single Sign On");
	}
}
