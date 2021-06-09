package com.cloudeagle.helper.PageObject;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cloudeagle.framework.helper.BasePageObject.PageBase;
import com.cloudeagle.framework.helper.Logger.LoggerHelper;
import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;
	
	public class LandingPage extends PageBase {
	
		private WebDriver driver;
		WaitHelper wHelper = new WaitHelper(ObjectRepo.driver, null);
	
		private final static Logger log = LoggerHelper.getLogger(LandingPage.class);
	
		// String random2 = RandomStringUtils.randomAlphabetic(3);
	
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

	

	private final String pageUrl = "/signin?email=";

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	// Click on Create On Now button
	public void openAccountBtnClick() {
		try {
			openAccountBtn.click();
		} catch (Exception e) {
			log.info("Error while clicking Create Now One Button on login Page");
		}
	}

	// verify user landed on home page after login

	public void verifyHomePage() throws InterruptedException {

		wHelper.waitForElementToBeClickable(welcomeScreenElement);

		Assert.assertTrue(welcomeScreenElement.isDisplayed(), "Error after login, User is not able to see home page.");
		log.info("Welcome text is verified on Home Page");
	}

	// Verify user on Signin page

	public void verifylandingPageTitle() throws InterruptedException {

	
	


		wHelper.waitForVisibility(imgOnLandingPage);
	    Assert.assertEquals(true, imgOnLandingPage.isDisplayed());
		Assert.assertTrue(driver.getTitle().contains("cloudeagle.ai"));
		log.info("Landing Page is verified");
		
		

		   
		   
		}
		
	
	public void verifylandingPageTitleMOVR() throws InterruptedException {
	

		wHelper.waitForElementToBeClickable(welcomeScreenElementMOVR);
		Assert.assertTrue(driver.getTitle().contains("Landing - WRKOUT"));
		log.info("Landing Page  title is verified on page");
	}






	public boolean saveBTTNClick2(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	

	public boolean backEventBttn2(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}


	public void openArrowClick() {
		try {
			System.out.println("Inside arrow");
			wHelper.waitForElementToBeClickable(welcomeScreenArrow);
			welcomeScreenArrow.click();
		} catch (Exception e) {
			log.info("Error while clicking Arrow image in Home Page");
		}
	}



	public boolean openArrowClick2(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}



	/*
	 * public void endDateClick1() throws InterruptedException {
	 * 
	 * System.out.println("endDate ");
	 * 
	 * endDate.click();
	 * 
	 * }
	 */

	/*
	 * public void endDateClick1() throws InterruptedException {
	 * 
	 * By endDate = By.xpath("//INPUT[@id='EndDate']");
	 * wHelper.waitForElementToBeClickable(endDate);
	 * 
	 * createEventBttnClick2(endDate);
	 * 
	 * }
	 */

	public boolean endDateClick2(By by) throws InterruptedException {

		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;

	}

	/*
	 * public void selectTimeFromCalander(String bj) {
	 * 
	 * EventDesc.sendKeys(bj); log.info(EventDesc); }
	 */


	
	@FindBy(xpath = "//BUTTON[@id='btnCDBookConsult']")
	@CacheLookup
	private static WebElement bookConsultantBttn;
	
	
	
	
	public void playCAL() throws InterruptedException {

		wHelper.waitForElementToBeClickable(welcomeScreenElement);
		

		

		
		//wHelper.waitForVisibilityLoader();
		wHelper.waitForElementToBeClickable(bookConsultantBttn);
		clickBookCon();
		
		clickConsultDate();
		clickDateandTime();
		
		
Thread.sleep(5000);		
clickSET();
		
		
		
	
	
	}
	
	
	public void clickBookCon() {
		try {
			System.out.println("clickBookCon");
			wHelper.waitForElementToBeClickable(bookConsultantBttn);
			bookConsultantBttn.click();
		} catch (Exception e) {
			log.info("Error while clicking Arrow image in Home Page");
		}
	}
	

	
	
	
	
	

	@FindBy(xpath = "//DIV[@role='option'][text()='Today']/following::div[position()=1] ")
	@CacheLookup
	private WebElement dateAndTime;

	@FindBy(xpath = "//DIV[@tabindex='0'][text()='Set']")
	@CacheLookup
	private WebElement set;


	
	

	
	public void clickDateandTime() {
		try {
			System.out.println("dateAndTime");
			wHelper.waitForElementToBeClickable(dateAndTime);
			dateAndTime.click();
		} catch (Exception e) {
			log.info("Error while clicking Arrow image in Home Page");
		}
	}
	
	public void clickSET() {
		try {
			System.out.println("set");
			wHelper.waitForElementToBeClickable(set);
			set.click();
		} catch (Exception e) {
			log.info("Error while clicking Arrow image in Home Page");
		}
	}

	
	
	
	
	
	public void clickConsultDate() {
		try {
			System.out.println("clickConsultDate");
			wHelper.waitForElementToBeClickable(clickConsultDate);
			clickConsultDate.click();
		} catch (Exception e) {
			log.info("Error while clicking Arrow image in Home Page");
		}
	}

	
	

	
/*	public void swip() {


	
	WebElement element = driver.findElement(By.xpath("//div[@id='board']/div[1]/div[1]/div[2]") );
	for (int i = 0; i < 5; i++) {
	    jse.executeScript("arguments[0].scrollTop += 200;", element);
	}*/
	
	
	//}
	
	
	
	
	
	
	

}
