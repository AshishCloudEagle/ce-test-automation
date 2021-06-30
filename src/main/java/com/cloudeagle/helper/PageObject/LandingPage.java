package com.cloudeagle.helper.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cloudeagle.framework.helper.BasePageObject.PageBase;
import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;

public class LandingPage extends PageBase {

	private WebDriver driver;
	WaitHelper wHelper = new WaitHelper(ObjectRepo.driver, null);

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	/** Web Elements */

	@FindBy(id = "email")
	@CacheLookup
	private WebElement emailAddress;

	@FindBy(id = "password")
	@CacheLookup
	private WebElement password;

	@FindBy(xpath = "//input[@id='username']")
	@CacheLookup
	private WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	private WebElement userPassword;

	@FindBy(xpath = "//p[contains(text(),'Log In')]")
	@CacheLookup
	private WebElement signInButton;

	@FindBy(css = "a.profile-pin-input__forgot-pin")
	@CacheLookup
	private WebElement forgotPin;

	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	@CacheLookup
	private WebElement forgotYourPassword;

	@FindBy(xpath = "//div[@class=\"sign-in-form__tertiary-actions\"]")
	@CacheLookup
	private static WebElement openAccountBtn;

	@FindBy(xpath = "//img[@src=\"/images/IF_Logo_White.svg?v=Wr8_sWXhDEojUitottz4x2sdws8QiYYNOzChWGt_hLw\"]")
	@CacheLookup
	private static WebElement welcomeScreenElement;

	@FindBy(xpath = "//img[@src=\"/images/wrkout_logo.png\"]")
	@CacheLookup
	private static WebElement welcomeScreenElementMOVR;

	@FindBy(xpath = "	//BUTTON[@id='btnManageEvent']")
	@CacheLookup
	private static WebElement createEventBttn;

	@FindBy(xpath = "	//I[@class='fas fa-cog']")
	@CacheLookup
	private static WebElement welcomeScreenManager;

	@FindBy(xpath = "	//I[@class='fas fa-chevron-right']")
	@CacheLookup
	private static WebElement welcomeScreenArrow;

	@FindBy(xpath = "	(//A[@class='sidebar-link'])[5]")
	@CacheLookup
	private static WebElement welcomeEvent;

	@FindBy(xpath = "	//div[@id='loading-text']")
	@CacheLookup
	private static WebElement LOADER;

	@FindBy(xpath = "	//INPUT[@id='EndDate']")
	@CacheLookup
	private static WebElement endDate;

	@FindBy(xpath = "//A[@id='Schedule-tab']")
	@CacheLookup
	private static WebElement tabImage;

	@FindBy(xpath = "//IMG[@src='/static/media/Cloudeeagle_logo_F.68377d43.svg'] | //img[@alt='logo']")
	@CacheLookup
	private static WebElement imgOnLandingPage;

	@FindBy(xpath = "//INPUT[@id='txtConsultDate']")
	@CacheLookup
	private static WebElement clickConsultDate;

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public void verifyHomePage() throws InterruptedException {
		wHelper.waitForElementToBeClickable(welcomeScreenElement);
		Assert.assertTrue(welcomeScreenElement.isDisplayed(), "Error after login, User is not able to see home page.");
		log("Welcome text is verified on Home Page", false);
	}

	// Verify user on Signin page

	public void verifylandingPageTitle() throws InterruptedException {
		wHelper.waitForVisibility(imgOnLandingPage);
		Assert.assertEquals(true, imgOnLandingPage.isDisplayed());
		Assert.assertTrue(driver.getTitle().contains("cloudeagle.ai"));
		log("Landing Page is verified", false);
	}

	public void verifylandingPageTitleMOVR() throws InterruptedException {
		wHelper.waitForElementToBeClickable(welcomeScreenElementMOVR);
		Assert.assertTrue(driver.getTitle().contains("Landing - WRKOUT"));
		log("Landing Page  title is verified on page", false);
	}
}
