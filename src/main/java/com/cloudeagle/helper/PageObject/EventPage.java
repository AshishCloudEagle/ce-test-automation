package com.cloudeagle.helper.PageObject;

import static com.cloudeagle.constants.Constants.WAIT_EXPLICIT_SEC;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cloudeagle.framework.helper.BasePageObject.PageBase;
import com.cloudeagle.framework.helper.DropDown.DropDownHelper;
import com.cloudeagle.framework.helper.Logger.LoggerHelper;
import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.list.ListHelper;
import com.cloudeagle.framework.settings.ObjectRepo;

public class EventPage extends PageBase {

	private WebDriver driver;
	WaitHelper wHelper = new WaitHelper(ObjectRepo.driver, null);
	ListHelper listHelper = new ListHelper(ObjectRepo.driver);
	DropDownHelper drpHelper = new DropDownHelper(ObjectRepo.driver);

	private final static Logger log = LoggerHelper.getLogger(EventPage.class);

	// String random2 = RandomStringUtils.randomAlphabetic(3);

	public EventPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	/** Webelement **/

	@FindBy(xpath = "//a[contains(text(),'Users')]")
	@CacheLookup
	private static WebElement userss;

	@FindBy(xpath = "(//A[@class='nav-submenu-link'])[7]")
	@CacheLookup
	private static WebElement movr;

	@FindBy(xpath = "//TEXTAREA[@id='Description']")
	@CacheLookup
	private static WebElement EventDesc;

	@FindBy(xpath = "	//a[contains(text(),'Tool')]")
	@CacheLookup
	private static WebElement welcomeScreentool;

	@FindBy(xpath = "	//div[@id='loading-text']")
	@CacheLookup
	private static WebElement LOADER;

	@FindBy(xpath = "	//I[@class='fas fa-cog']")
	@CacheLookup
	private static WebElement welcomeScreenManager;

	@FindBy(xpath = "//INPUT[@id='Name']")
	@CacheLookup
	private static WebElement eventName;

	@FindBy(xpath = "//input[@class='filepond--browser']")
	@CacheLookup
	private static WebElement browseBttn;

	@FindBy(xpath = "//a[contains(text(),'Tool')]")
	@CacheLookup
	private static WebElement tool;

	@FindBy(xpath = "//I[@class='fas fa-cog']")
	@CacheLookup
	private static WebElement manager;

	@FindBy(xpath = "//I[@class='fas fa-chevron-right']")
	@CacheLookup
	private static WebElement sideMenu;

	@FindBy(xpath = "//SPAN[@class='sidebar-link-text'][text()='EVENTS']")
	@CacheLookup
	private static WebElement sideMenuEvent;

	@FindBy(xpath = "//BUTTON[@id='btnManageEvent']")
	@CacheLookup
	private static WebElement createEventBttn;

	@FindBy(xpath = "//BUTTON[@id='btnSaveEvent']")
	@CacheLookup
	private static WebElement saveEventBttn;

	@FindBy(xpath = "//A[@id='Schedule-tab']")
	@CacheLookup
	private static WebElement imageTAB;

	//////////////////////////////////////////////////////////////////////////////
	// Methods

	public static WebElement getWebElement(By Xpath) {

		WebElement webElement = ObjectRepo.driver.findElement(Xpath);

		return webElement;
	}

	public void loginTheApp() {

		LoginAdminApp();
		System.out.println("Inside loginTheApp completed");

	}

	public void openToolImageClick() throws InterruptedException {

		wHelper.waitForVisibilityLoader();
		System.out.println("Tool Image Click");
		wHelper.waitForElementToBeClickable(tool);
		tool.click();

		log.info(tool);

		// System.out.println("Inside tool");

		// By loaderLocator = By.xpath("//div[@id='loading-text']");

//		WebDriverWait wait = new WebDriverWait(driver, 10000);
		// wait.until(ExpectedConditions.visibilityOf(LOADER)); // wait for loader to
		// appear
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
		// // wait for loader to disappear
		// By tool = By.xpath("//a[contains(text(),'Tool')]");
//		wHelper.waitForPresenceOfElement(tool);

		// welcomeScreentool.click();

	}

	public void openManagerImageClick() {

		manager.click();

	}

	public void sideMenu() throws InterruptedException {

		// wHelper.waitForVisibilityLoader();
		//System.out.println("User Click");

		// wHelper.waitForElementToBeClickable(sideMenu);

		wHelper.waitForElementToBeClickableAndClick(sideMenu);

//sideMenu.click();

	}

	public void openEventMenu() {

		wHelper.waitForElementToBeClickable(sideMenuEvent);

		sideMenuEvent.click();

		/*
		 * try {
		 * 
		 * By sideBarEvent =
		 * By.xpath("//SPAN[@class='sidebar-link-text'][text()='EVENTS']");
		 * wHelper.waitForPresenceOfElement(sideBarEvent);
		 * 
		 * openEventClick2(sideBarEvent);
		 * 
		 * } catch (Exception e) { log.info("Error while clicking Event in Home Page");
		 * }
		 */
	}

	public void createEventBttnClick() throws InterruptedException {

		createEventBttn.click();

		/*
		 * By crBttn = By.xpath("//BUTTON[@id='btnManageEvent']");
		 * 
		 * wHelper.waitForPresenceOfElement(crBttn);
		 * 
		 * // wHelper.waitForElementToBeClickable(crBttn);
		 * 
		 * createEventBttnClick2(crBttn);
		 */

	}

	public void eventName(String ename) {

		wHelper.waitForElementToBeClickable(eventName);

		eventName.sendKeys(ename);
		log.info(ename);
	}

	public void eventDescSendData(String bj) {
		EventDesc.sendKeys(bj);
		log.info(EventDesc);
	}

	public void saveBTTNClick() throws InterruptedException {

		// By prospectDetailIconBy = By.xpath("//div[@class='dropdown-menu
		// show']//button[@title='Detail'][1]");
		// prospectDetailIcon = wHelper.handleStaleElement(prospectDetailIconBy, 5, 20);
		// wHelper.waitForElementToBeClickable(prospectDetailIcon);

		By createNewSaveBttnBy = By.xpath("//BUTTON[@id='btnSaveEvent']");
		saveEventBttn = wHelper.handleStaleElement(createNewSaveBttnBy, 5, 20);

		System.out.println("saveEventBttn" + saveEventBttn);

		wHelper.waitForElementToBeClickable(saveEventBttn);

		saveEventBttn.click();


	}

	public void addimage() throws InterruptedException {

		
		wHelper.waitForElementToBeClickableAndClick(imageTAB);

		//wHelper.waitForElementToBeClickable(imageTAB);

	//	imageTAB.click();


		String currentDirectory = System.getProperty("user.dir");
		browseBttn.sendKeys(currentDirectory + "\\TestData\\41024.jpg");

		Thread.sleep(3000);

	}

	public void backEventBttn() throws InterruptedException {

		// Thread.sleep(4000);

		By saveBttn = By.xpath("(//I[@class='fas fa-chevron-left'])[2]");

		wHelper.waitForElementToBeClickable(saveBttn);

		createEventBttnClick2(saveBttn);

	}

	public boolean createEventBttnClick2(By by) {
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

	public void validateEvent(String random) throws InterruptedException {
		System.out.println("Inside Validate");

		By list = By.xpath("//ul[@class='iftb-event-row']//li//div//h5");

		verifyEventFromList(list, random, driver);

	}

	public void verifyEventFromList(By List, String Text, WebDriver driver) throws InterruptedException {

		// System.out.println(Text +" to match");
		List<WebElement> list = driver.findElements(List);
		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i).getText());

			if (list.get(i).getText().contentEquals(Text)) {

				System.out.println("match");

				Assert.assertEquals(Text, list.get(i).getText());

				break;

			}

		}
	}

	public void ClickUser() throws InterruptedException {

		wHelper.waitForVisibilityLoader();
		System.out.println("User Click");
		wHelper.waitForElementToBeClickable(userss);
		userss.click();

		log.info(userss);
	}

	public void ClickMOVR() throws InterruptedException {

		wHelper.waitForElementToBeClickable(movr);

		movr.click();

		log.info(movr);

	}

	public void validateData(String Name, String LastName, String MobileNumber, String PostalCode, String Notes)
			throws InterruptedException {

		By firstNameBy = By.xpath("//INPUT[@id='txtFirstName']");
		By lastnameBY = By.xpath("//INPUT[@id='txtLastName']");
		By PostalBy = By.xpath("//INPUT[@id='txtPostalcode']");

		By mobileNumberBY = By.xpath("//INPUT[@id='txtMobile']");
		By notesBy = By.xpath("//TEXTAREA[@id='txtNotes']");

		Assert.assertEquals(wHelper.handleStaleElement(firstNameBy, 5, 20).getAttribute("Value"), Name);
		Assert.assertEquals(wHelper.handleStaleElement(lastnameBY, 5, 20).getAttribute("Value"), LastName);
		Assert.assertEquals(wHelper.handleStaleElement(mobileNumberBY, 5, 20).getAttribute("Value"), MobileNumber);
		Assert.assertEquals(wHelper.handleStaleElement(PostalBy, 5, 20).getAttribute("Value"), PostalCode);
		Assert.assertEquals(wHelper.handleStaleElement(notesBy, 5, 20).getText(), Notes);

	}

}
