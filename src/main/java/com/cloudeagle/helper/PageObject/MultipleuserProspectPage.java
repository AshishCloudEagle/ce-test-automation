package com.cloudeagle.helper.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cloudeagle.framework.helper.BasePageObject.PageBase;
import com.cloudeagle.framework.helper.DropDown.DropDownHelper;
import com.cloudeagle.framework.helper.Logger.LoggerHelper;
import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.list.ListHelper;
import com.cloudeagle.framework.settings.ObjectRepo;

public class MultipleuserProspectPage extends PageBase {

	private WebDriver driver;
	WaitHelper wHelper = new WaitHelper(ObjectRepo.driver, null);
	ListHelper listHelper = new ListHelper(ObjectRepo.driver);
	DropDownHelper drpHelper = new DropDownHelper(ObjectRepo.driver);

	private final static Logger log = LoggerHelper.getLogger(MultipleuserProspectPage.class);

	// String random2 = RandomStringUtils.randomAlphabetic(3);

	public MultipleuserProspectPage(WebDriver driver) {
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

	@FindBy(xpath = "//BUTTON[@id='btnAddProspect']")
	@CacheLookup
	private static WebElement createNewProspectBTTN;

	// @FindBy(xpath = "//LABEL[@class='ios-checkbox']")

	// @FindBy(xpath = "//div[@class='ift-ios-radiobox']")

	// driver.findElement(By.xpath(".//*[@id='idgoeshere']/parent::*")).click()
	// @FindBy(xpath = "//input[@id='ift-userclient-type']")..

	
	
	@FindBy(xpath = "//div[@class='ift-ios-radiobox']")
	@CacheLookup
	private static WebElement mulUserToggle;
	
	
//	@FindBy(xpath = ".//*[@id='ift-userclient-type']/parent::*")
	//@CacheLookup
//	private static WebElement mulUserToggle;

	@FindBy(xpath = "//INPUT[@id='txtFirstName_0']")
	@CacheLookup
	private static WebElement firstName;

	@FindBy(xpath = "//INPUT[@id='txtFirstName_1']")
	@CacheLookup
	private static WebElement firstNameUserTwo;

	@FindBy(xpath = "//INPUT[@id='txtLastName_0']")
	@CacheLookup
	private static WebElement lastName;

	@FindBy(xpath = "//INPUT[@id='txtLastName_1']")
	@CacheLookup
	private static WebElement lastNameUserTwo;

	@FindBy(xpath = "//INPUT[@id='txtEmail_0']")
	@CacheLookup
	private static WebElement emailAddress;

	@FindBy(xpath = "//INPUT[@id='txtEmail_1']")
	@CacheLookup
	private static WebElement emailAddressUserTwo;

	@FindBy(xpath = "//INPUT[@id='txtMobile_0']")
	@CacheLookup
	private static WebElement mobileNumber;

	@FindBy(xpath = "//INPUT[@id='txtMobile_1']")
	@CacheLookup
	private static WebElement mobileNumberUserTwo;

	@FindBy(xpath = "//INPUT[@id='txtAddress_0']")
	@CacheLookup
	private static WebElement address1UserOne;

	@FindBy(xpath = "//INPUT[@id='txtAddress_1']")
	@CacheLookup
	private static WebElement address1UserTwo;

	@FindBy(xpath = "//INPUT[@id='txtPostal_0']")
	@CacheLookup
	private static WebElement postalNumber;

	@FindBy(xpath = "//INPUT[@id='txtPostal_1']")
	@CacheLookup
	private static WebElement postalNumberUserTwo;

	@FindBy(xpath = "//TEXTAREA[@id='txtNotes']")
	@CacheLookup
	private static WebElement notes;

	@FindBy(xpath = "//A[@id='Person-1-tab']")
	@CacheLookup
	private static WebElement userTwoTab;

	@FindBy(xpath = "//BUTTON[@id='btnSaveProspect']")
	@CacheLookup
	private static WebElement saveProspectBTTN;

	@FindBy(xpath = "//div[@class='dropdown-menu show']//button[@title='Detail'][1]")
	@CacheLookup
	private static WebElement prospectDetailIcon;

	@FindBy(xpath = "//div[@class='dropdown-menu show']//button[@title='Detail'][1]")
	@CacheLookup
	private static WebElement prospectDetailIconUserTwo;

	@FindBy(xpath = "//div[contains(@class,'dropdown-menu show')]")
	@CacheLookup
	private static WebElement source;

	@FindBy(xpath = "//ul[@class='dropdown-menu inner show']//li//a//span[2]")
	@CacheLookup
	private static WebElement sourceDRPList;

	@FindBy(xpath = "(//I[@class='fas fa-chevron-left'])[2]")
	@CacheLookup
	private static WebElement backBttnforListing;

	@FindBy(xpath = "(//I[@class='fas fa-chevron-left'])[2]")
	@CacheLookup
	private static WebElement BackBTTN;

	By sourceBox = By.xpath("(//BUTTON[@type='button'])[14]");
	By sourceList = By.xpath("//select[@id='ddlSaveSourceType']//option");

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

	public void ClickUser() throws InterruptedException {

		wHelper.waitForVisibilityLoader();
		System.out.println("User Click");
		wHelper.waitForElementToBeClickable(userss);
		userss.click();

		log.info(userss);
	}

	public void clickeBackBttnForListing() throws InterruptedException {

		wHelper.waitForVisibilityLoader();
		System.out.println("User Click");
		wHelper.waitForElementToBeClickable(backBttnforListing);
		backBttnforListing.click();

		log.info(userss);
	}

	public void ClickMOVR() throws InterruptedException {

		wHelper.waitForElementToBeClickable(movr);

		movr.click();

		log.info(movr);

	}

	public void ClickCreateProspect() throws InterruptedException {

		wHelper.waitForVisibilityLoader();
		wHelper.waitForElementToBeClickable(createNewProspectBTTN);
		createNewProspectBTTN.click();
		log.info(createNewProspectBTTN);

		wHelper.waitForVisibilityLoader();
//		wHelper.waitForElementToBeClickable(firstName);

	}

	public void multipleUserToggle() throws InterruptedException {

		
		//wHelper.waitForElementToBeClickable(mulUserToggle);
		wHelper.waitForVisibility(mulUserToggle);


		mulUserToggle.click();

		log.info(mulUserToggle);
		
		wHelper.waitForVisibilityLoader();
		wHelper.waitForElementToBeClickable(firstName);

	}

	public void sendFirstName(CharSequence... keysToSend) {

		wHelper.waitForVisibility(firstName);
		firstName.sendKeys(keysToSend);

	}

	public void sendFirstNameUserTwo(CharSequence... keysToSend) {

		wHelper.waitForVisibility(firstNameUserTwo);
		firstNameUserTwo.sendKeys(keysToSend);

	}

	public void sendLastName(CharSequence... keysToSend) {

		wHelper.waitForVisibility(lastName);

		lastName.sendKeys(keysToSend);

	}

	public void sendLastNameUserTwo(CharSequence... keysToSend) {

		wHelper.waitForVisibility(lastNameUserTwo);

		lastNameUserTwo.sendKeys(keysToSend);

	}

	public void sendemailAddress(CharSequence... keysToSend) {

		wHelper.waitForVisibility(emailAddress);

		emailAddress.sendKeys(keysToSend);

	}

	public void sendEmailAddressUserTwo(CharSequence... keysToSend) {

		wHelper.waitForVisibility(emailAddressUserTwo);

		emailAddressUserTwo.sendKeys(keysToSend);

	}

	public void sendMobileNumber(CharSequence... keysToSend) {

		wHelper.waitForVisibility(mobileNumber);

		mobileNumber.sendKeys(keysToSend);

	}

	public void sendMobileNumberUserTwo(CharSequence... keysToSend) {

		wHelper.waitForVisibility(mobileNumberUserTwo);

		mobileNumberUserTwo.sendKeys(keysToSend);

	}

	public void sendAddress(CharSequence... keysToSend) {

		wHelper.waitForVisibility(address1UserOne);

		address1UserOne.sendKeys(keysToSend);

	}

	public void sendPostal(CharSequence... keysToSend) {

		wHelper.waitForVisibility(postalNumber);

		postalNumber.sendKeys(keysToSend);

	}

	public void sendPostalUserTwo(CharSequence... keysToSend) {

		wHelper.waitForVisibility(postalNumberUserTwo);

		postalNumberUserTwo.sendKeys(keysToSend);

	}

	public void sendNotes(CharSequence... keysToSend) {

		wHelper.waitForVisibility(notes);

		notes.sendKeys(keysToSend);

	}

	public void ClickUserTwoTab() {

		userTwoTab.click();
		log.info(userTwoTab);

	}

	public void ClicksaveProspectBTTN() throws InterruptedException {

		saveProspectBTTN.click();
		System.out.println("save prospect btn");
		log.info(saveProspectBTTN);

	}

	public void SelectSourceFromDRP() throws InterruptedException {

		drpHelper.selectDataFromListOfDRP(sourceList, "Phone", sourceBox);

	}

	public void verifyRecordInList(String Text) throws InterruptedException {

		By tableList = By.xpath("//table[@id ='tblProspectList']//tr//td[1]");

		System.out.println("inside verify");
		wHelper.waitForVisibilityLoader();
		wHelper.waitForVisbleOfElement(createNewProspectBTTN);

		listHelper.goToDetailProspectScreen(Text, tableList);

		ClickDetail();

		System.out.println("ClickDetail");

	}

	public void ClickDetail() throws InterruptedException {

		System.out.println("inside click detail");
		By prospectDetailIconBy = By.xpath("//div[@class='dropdown-menu show']//button[@title='Detail'][1]");
		prospectDetailIcon = wHelper.handleStaleElement(prospectDetailIconBy, 5, 20);
		wHelper.waitForElementToBeClickable(prospectDetailIcon);
		prospectDetailIcon.click();

		log.info(prospectDetailIcon);
	}

	public void validateData(String Name, String LastName, String MobileNumber, String PostalCode, String Notes,
			boolean back) throws InterruptedException {

		By firstNameBy = By.xpath("//INPUT[@id='txtFirstName']");
		By lastnameBY = By.xpath("//INPUT[@id='txtLastName']");
		By PostalBy = By.xpath("//INPUT[@id='txtPostalcode']");
		By mobileNumberBY = By.xpath("//INPUT[@id='txtMobile']");
		By notesBy = By.xpath("//TEXTAREA[@id='txtNotes']");

		Assert.assertEquals(wHelper.handleStaleElement(firstNameBy, 5, 20).getAttribute("Value"), Name);
		Assert.assertEquals(wHelper.handleStaleElement(lastnameBY, 5, 20).getAttribute("Value"), LastName);
		Assert.assertEquals(wHelper.handleStaleElement(mobileNumberBY, 5, 20).getAttribute("Value"), MobileNumber);
		Assert.assertEquals(wHelper.handleStaleElement(PostalBy, 5, 20).getAttribute("Value"), PostalCode);
		// Assert.assertEquals(wHelper.handleStaleElement(notesBy, 5, 20).getText(),
		// Notes);
		System.out.println("all end");

		// clickeBackBttnForListing();

		if (back) {
			listHelper.clickHideenTry(BackBTTN);
		}

	}

	public void goToListingScreen() {

		listHelper.redirectionToClientListing();
		wHelper.waitForElementToBeClickable(firstName);

	}

}
