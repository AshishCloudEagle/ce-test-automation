package com.cloudeagle.helper.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.cloudeagle.framework.helper.BasePageObject.PageBase;
import com.cloudeagle.framework.helper.DropDown.DropDownHelper;
import com.cloudeagle.framework.helper.Javascript.JavaScriptHelper;
import com.cloudeagle.framework.helper.Logger.LoggerHelper;
import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.list.ListHelper;
import com.cloudeagle.framework.settings.ObjectRepo;

public class StaffMemberPage extends PageBase {

	private WebDriver driver;
	WaitHelper wHelper = new WaitHelper(ObjectRepo.driver, null);
	ListHelper listHelper = new ListHelper(ObjectRepo.driver);
	DropDownHelper drpHelper = new DropDownHelper(ObjectRepo.driver);
	JavaScriptHelper jsHelp = new JavaScriptHelper(ObjectRepo.driver);
	private final static Logger log = LoggerHelper.getLogger(StaffMemberPage.class);

	// String random2 = RandomStringUtils.randomAlphabetic(3);

	
	SoftAssert softAssert1= new SoftAssert();

	
	
	
	public StaffMemberPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	/** Webelement **/

	@FindBy(xpath = "//a[contains(text(),'Users')]")
	@CacheLookup
	private static WebElement userss;

	By userssBy = By.xpath("//a[contains(text(),'Users')]");
	
	
	By movrBy = By.xpath("(//A[@class='nav-submenu-link'])[7]");
			

	// a[contains(text(),'Users')]

	// (//A[@class='nav-link ifit-underline-from-center'])[4]
	// "//a[contains(text(),'Tool')]"

	@FindBy(xpath = "//BUTTON[@id='btnAddClient']")
	@CacheLookup
	private static WebElement createNewMOVRBTTN;

	@FindBy(xpath = "//INPUT[@id='txtFirstName']")
	@CacheLookup
	private static WebElement firstName;

	@FindBy(xpath = "//INPUT[@id='txtLastName']")
	@CacheLookup
	private static WebElement lastName;

	@FindBy(xpath = "//INPUT[@id='txtEmail']")
	@CacheLookup
	private static WebElement emailAddress;

	@FindBy(xpath = "//INPUT[@id='txtMobile']")
	@CacheLookup
	private static WebElement mobileNumber;

	@FindBy(xpath = "//INPUT[@id='txtAddress']")
	@CacheLookup
	private static WebElement address1;

	@FindBy(xpath = "//INPUT[@id='txtPostal']")
	@CacheLookup
	private static WebElement postalNumber;

	@FindBy(xpath = "//TEXTAREA[@id='txtNotes']")
	@CacheLookup
	private static WebElement notes;

	@FindBy(xpath = "//BUTTON[@id='btnSaveProspect']")
	@CacheLookup
	private static WebElement saveMovrBTTN;

	@FindBy(xpath = "(//BUTTON[@class='dropdown-item'][text()='Details'])[1]")
	@CacheLookup
	private static WebElement prospectDetailIcon;

	@FindBy(xpath = "//div[contains(@class,'dropdown-menu show')]")
	@CacheLookup
	private static WebElement source;

	@FindBy(xpath = "//ul[@class='dropdown-menu inner show']//li//a//span[2]")
	@CacheLookup
	private static WebElement sourceDRPList;
	
	
	@FindBy(xpath = "//label[normalize-space()='Automation DND']")
	@CacheLookup
	private static WebElement packageReviewINScheduleBooking;
	
	
	//LABEL[text()='Automation DND']"
	
	@FindBy(xpath = "//li[normalize-space()='Remote Payment']")
	@CacheLookup
	private static WebElement remotePaymentText;
	
	
	@FindBy(xpath = "//li[normalize-space()='Payment Now']")
	@CacheLookup
	private static WebElement paymentNowText;
	
	
	
	@FindBy(xpath = "//td[normalize-space()='Annual Membership']")
	@CacheLookup
	private static WebElement annualMemberShip;
	
	
	
	@FindBy(xpath = "//h3[normalize-space()='Variable Package Cart']")
	@CacheLookup
	private static WebElement variablePkgCart;
	
	
	@FindBy(xpath = "//TD[@class='ifnc-prdsrvc'][text()='Annual Membership']")
	@CacheLookup
	private static WebElement packageInfoOnThankYouScreen1;
	
	@FindBy(xpath = "//TD[@class='ifnc-prdsrvc'][text()='Yoga']")
	@CacheLookup
	private static WebElement packageInfoOnThankYouScreen2;
	
	
	@FindBy(xpath = "//h5[normalize-space()='Annual Membership']")
	@CacheLookup
	private static WebElement annualMemberShipUnderPackageTab;
	
	
	@FindBy(xpath = "//h5[normalize-space()='Variable Package']")
	@CacheLookup
	private static WebElement variablePackageUnderPackageTab;
	
	
	
	
	
	
	
	

	By sourceBox = By.xpath("(//BUTTON[@type='button'])[7]");
	By sourceList = By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span[2]");

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
		System.out.println(" Inside Click Usr");

		userss = wHelper.handleStaleElement(userssBy, 5, 20);
		//wHelper.waitForElementToBeClickable(userss);
		userss.click();

		log.info(userss);
	}

	public void ClickMOVR() throws InterruptedException {
		
		
		System.err.println("Inside Click Movr");
		movr = wHelper.handleStaleElement(movrBy, 5, 20);

		wHelper.waitForElementToBeClickable(movrBy);

		movr.click();

		log.info(movr);

	}

	public void ClickNewMOVR() throws InterruptedException {

		wHelper.waitForVisibilityLoader();
		wHelper.waitForElementToBeClickable(createNewMOVRBTTN);
		createNewMOVRBTTN.click();
		log.info(createNewMOVRBTTN);

		wHelper.waitForVisibilityLoader();
		wHelper.waitForElementToBeClickable(firstName);

	}

	public void sendFirstName(CharSequence... keysToSend) {

		wHelper.waitForVisibility(firstName);
		firstName.sendKeys(keysToSend);

	}

	public void sendLastName(CharSequence... keysToSend) {

		wHelper.waitForVisibility(lastName);

		lastName.sendKeys(keysToSend);

	}

	public void sendemailAddress(CharSequence... keysToSend) {

		wHelper.waitForVisibility(emailAddress);

		emailAddress.sendKeys(keysToSend);

	}

	public void sendMobileNumber(CharSequence... keysToSend) {

		wHelper.waitForVisibility(mobileNumber);

		mobileNumber.sendKeys(keysToSend);

	}

	public void sendAddress(CharSequence... keysToSend) {

		wHelper.waitForVisibility(address1);

		address1.sendKeys(keysToSend);

	}

	public void sendPostal(CharSequence... keysToSend) {

		wHelper.waitForVisibility(postalNumber);

		postalNumber.sendKeys(keysToSend);

	}

	public void sendNotes(CharSequence... keysToSend) {

		wHelper.waitForVisibility(notes);

		notes.sendKeys(keysToSend);

	}

	public void createMOVRBTTN() throws InterruptedException {

		saveMovrBTTN.click();
		log.info(saveMovrBTTN);

	}

	public void SelectSourceFromDRP() throws InterruptedException {

		drpHelper.selectDataFromListOfDRP(sourceList, "Phone", sourceBox);

	}

	By tableList = By.xpath("//table[@id ='tblClientList']//tr//td[1]");

	public void verifyRecordInList(String Text) throws InterruptedException {

		wHelper.waitForVisibilityLoader();
		wHelper.waitForVisbleOfElement(createNewMOVRBTTN);
		listHelper.goToMOVRDetailScreen(Text, tableList);

		cllickMOVRDetail();

	}

	@FindBy(xpath = "//div[@class='dropdown-menu show']//button[@title='Detail'][normalize-space()='Details']")
	@CacheLookup
	private static WebElement moverDetail;

	@FindBy(xpath = "//div[@class='dropdown-menu show']//button[@title='Detail'][normalize-space()='Details']")
	@CacheLookup
	private static WebElement trainerDetail;


	
	By movrDetailBy=By.xpath("//div[@class='dropdown-menu show']//button[@title='Detail'][normalize-space()='Details']");
	
	public void cllickMOVRDetail() throws InterruptedException {

			
		System.out.println("Inside cllickMOVRDetail ");

		moverDetail = wHelper.handleStaleElement(movrDetailBy, 5, 20);
		wHelper.waitForElementToBeClickable(moverDetail);
		moverDetail.click();

		log.info(moverDetail);
	}

	public void validateData(String Name, String LastName, String MobileNumber, String PostalCode)
			throws InterruptedException {

		By firstNameBy = By.xpath("//INPUT[@id='txtFirstName']");
		By lastnameBY = By.xpath("//INPUT[@id='txtLastName']");
		By PostalBy = By.xpath("//INPUT[@id='txtPostalcode']");
		By mobileNumberBY = By.xpath("//INPUT[@id='txtMobile']");

		
		softAssert1.assertEquals(wHelper.handleStaleElement(firstNameBy, 5, 20).getAttribute("Value"), Name);
		softAssert1.assertEquals(wHelper.handleStaleElement(lastnameBY, 5, 20).getAttribute("Value"), LastName);
		softAssert1.assertEquals(wHelper.handleStaleElement(mobileNumberBY, 5, 20).getAttribute("innerHTML"), MobileNumber);
		softAssert1.assertEquals(wHelper.handleStaleElement(PostalBy, 5, 20).getAttribute("Value"), PostalCode);

	
		
		
		
		softAssert1.assertAll();

	//	Assert.assertEquals(wHelper.handleStaleElement(firstNameBy, 5, 20).getAttribute("Value"), Name);
		//Assert.assertEquals(wHelper.handleStaleElement(lastnameBY, 5, 20).getAttribute("Value"), LastName);
	//	Assert.assertEquals(wHelper.handleStaleElement(mobileNumberBY, 5, 20).getAttribute("Value"), MobileNumber);
	//	Assert.assertEquals(wHelper.handleStaleElement(PostalBy, 5, 20).getAttribute("Value"), PostalCode);

	}

	// Second Scenario@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2

	@FindBy(id = "btnCDBookConsult")
	@CacheLookup
	private static WebElement bookConsultantBttn;

	@FindBy(xpath = "//INPUT[@id='txtConsultDate']")
	@CacheLookup
	private static WebElement dateAndTime;

	@FindBy(xpath = "//DIV[@role='option'][text()='Today']/following::div[position()=1]")
	@CacheLookup
	private WebElement nextDate;

	@FindBy(xpath = "//BUTTON[@id='btnBookConsult']")
	@CacheLookup
	private WebElement bookBttn;

	@FindBy(xpath = "//DIV[@tabindex='0'][text()='Set']")
	@CacheLookup
	private WebElement setBttn;

	@FindBy(xpath = "(//A[@class='nav-submenu-link'])[7]")
	@CacheLookup
	private static WebElement movr;

	@FindBy(xpath = "(//A[@class='nav-submenu-link'])[8]")
	@CacheLookup
	private static WebElement teamMenu;

	By teamMenuBy = By.xpath("(//A[@class='nav-submenu-link'])[8]");

	@FindBy(xpath = "(//INPUT[@type='search'])[3]")
	@CacheLookup
	private static WebElement trainerName;

	public void clickBookConsultBttn() throws InterruptedException {

		wHelper.waitForVisibilityLoader();
		System.out.println("After visibility loader in click bookconsulty bttn");

		wHelper.waitForElementToBeClickable(bookConsultantBttn);

		bookConsultantBttn.click();

//		jsHelp.clickUsingJS(bookConsultantBttn);

		log.info(bookConsultantBttn);
		wHelper.waitForVisibilityLoader();

	}

	public void clickDateAndTime() {
		try {
			System.out.println("dateAndTime");
			wHelper.waitForElementToBeClickable(dateAndTime);
			dateAndTime.click();
		} catch (Exception e) {
			log.info("Error while clicking Arrow image in Home Page");
		}
	}

	public void clickNextDate() {
		try {
			System.out.println("nextDate");
			wHelper.waitForElementToBeClickable(nextDate);
			nextDate.click();
		} catch (Exception e) {
			log.info("nextDate");
		}
	}

	public void clickSET() {
		try {
			System.out.println("setBttn");
			wHelper.waitForElementToBeClickable(setBttn);
			setBttn.click();
		} catch (Exception e) {
			log.info("setBttn");
		}
	}

	By sourcePersonDRPDWN = By.xpath("(//BUTTON[@type='button'])[15]");
	By salesPersonList = By.xpath("//select[@id='ddlSaveSalesPerson']//option");

	public void selectSalesManager() throws InterruptedException {

		drpHelper.selectDataFromListOfDRP(salesPersonList, "Kevin Green", sourcePersonDRPDWN);

	}

	public void clickBookBttn() {
		try {
			System.out.println("bookBttn");
			wHelper.waitForElementToBeClickable(bookBttn);
			bookBttn.click();

		} catch (Exception e) {
			log.info("bookBttn");
		}
	}

	public void clickUser() throws InterruptedException {

		wHelper.waitForElementToBeClickable(movr);

		movr.click();

		log.info(movr);

	}

	public void clickTeam() throws InterruptedException {

		teamMenu = wHelper.handleStaleElement(teamMenuBy, 5, 20);

		wHelper.waitForElementToBeClickable(teamMenu);

		teamMenu.click();

		log.info(teamMenu);

	}

	public void trainerName(CharSequence... keysToSend) throws InterruptedException {

		System.out.println("inside trainerName");

		wHelper.waitForElementToBeClickable(trainerName);
//		wHelper.waitForVisibility(trainerName);

		Thread.sleep(4000);
		trainerName.sendKeys(keysToSend);

	}

	@FindBy(xpath = "//P[@class='ift-cell-title'][text()='Kevin Green']/following::div[position()=1]")
	@CacheLookup
	private static WebElement trainerDetailcon;

	@FindBy(xpath = "//A[@id='lnkSchedule']")
	@CacheLookup
	private static WebElement liveTAB;

	public void clickTrainerDetailIcon() throws InterruptedException {

		System.out.println("inside clickTrainerDetailIcon");
		wHelper.waitForElementToBeClickable(trainerDetailcon);

		trainerDetailcon.click();

		log.info(trainerDetailcon);

		cllickTrainerDetailIconLabel();
	}

	public void cllickTrainerDetailIconLabel() throws InterruptedException {

		System.out.println("Inside cllickTrainerDetailIconLabel ");
		wHelper.waitForElementToBeClickable(trainerDetail);
		trainerDetail.click();

		// Thread.sleep(4000);
		log.info(trainerDetail);
	}

	@FindBy(xpath = "//SPAN[@class='fc-icon fc-icon-chevron-right']")
	@CacheLookup
	private static WebElement nextDateICON;

	public void dataAddedInTrainerListing() throws InterruptedException {

		wHelper.waitForVisibilityLoader();

		wHelper.waitForElementToBeClickable(liveTAB);

		liveTAB.click();

		log.info(liveTAB);

		wHelper.waitForVisibilityLoader();

		nextDateICON.click();

		log.info(nextDateICON);

		wHelper.waitForVisibilityLoader();

	}

	@FindBy(xpath = "//SPAN[@class='fc-icon fc-icon-chevron-right']")
	@CacheLookup
	private static WebElement nextDsddateICON;

	public void validateAddedSLOT(String MovrName) throws InterruptedException {

		String slotName = "//p[contains(text(),'" + MovrName + "')]";
		By addedSLOT = By.xpath(slotName);
		WebElement ele = ObjectRepo.driver.findElement(addedSLOT);

		//Assert.assertEquals(ele.isDisplayed(), true);
		softAssert1.assertEquals(ele.isDisplayed(), true);

		ele.click();
		softAssert1.assertAll();

	}

	@FindBy(xpath = "//button[@type='button']//i[@class='fas fa-trash-alt']")
	@CacheLookup
	private static WebElement deleteSlotIcon;

	@FindBy(xpath = "//button[normalize-space()='Delete']")
	@CacheLookup
	private static WebElement deleteBttnOnConfirmation;

	public void deleteSlotAndVerify(String MovrName) throws InterruptedException {

		wHelper.waitForElementToBeClickable(deleteSlotIcon);
		deleteSlotIcon.click();

		wHelper.waitForElementToBeClickable(deleteBttnOnConfirmation);
		deleteBttnOnConfirmation.click();

		wHelper.waitForVisibilityLoader();

		// wHelper.waitForDeletePopup();

		// wHelper.waitForVisibilityLoader();

		String slotName = "//p[contains(text(),'" + MovrName + "')]";
		By addedSLOT = By.xpath(slotName);
		// WebElement ele = ObjectRepo.driver.findElement(By.xpath(slotName));

		// By liveTabBY =By.xpath("//A[@id='lnkSchedule']");

		// wHelper.waitForElementVisible(liveTabBY,5,10);
		wHelper.hardWait(5000);

		//Assert.assertEquals(isElementPresent(addedSLOT), false);
		
		
		softAssert1.assertEquals(isElementPresent(addedSLOT), false);
		// Assert.assertEquals(wHelper.handleStaleElement(addedSLOT, 5,
		// 20),isElementPresent(addedSLOT),false);

	}

	public boolean isElementPresent(By locatorKey) {
		try {
			driver.findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * public boolean isElementVisible(String cssLocator){ return
	 * driver.findElement(By.cssSelector(cssLocator)).isDisplayed(); }
	 */

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Third Scenarios@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2

	@FindBy(xpath = "//a[normalize-space()='Packages']")
	@CacheLookup
	private static WebElement packageTab;

	@FindBy(xpath = "//SPAN[text()='Add Package']")
	@CacheLookup
	private static WebElement addPackageBttn;

	@FindBy(xpath = "//td[text()='Annual Membership (Membership)']/following::div[position()=2]")
	@CacheLookup
	private static WebElement annualMembership;

	@FindBy(xpath = "//button[normalize-space()='Proceed']")
	@CacheLookup
	private static WebElement proceedBttn;

	@FindBy(xpath = "//button[normalize-space()='ADD-ons']")
	@CacheLookup
	private static WebElement addONBttn;

	@FindBy(xpath = "//label[@for='addons_3']//i[@class='fas fa-check-circle']")
	@CacheLookup
	private static WebElement yogaSession;

	@FindBy(xpath = "//BUTTON[@id='btnSaveAddons']")
	@CacheLookup
	private static WebElement addToPackageBttn;

	/*
	 * @FindBy(xpath = "//label[normalize-space()='Variable']")
	 * 
	 * @CacheLookup private static WebElement variableToggleBttn;
	 */
	
	@FindBy(xpath = "//label[normalize-space()='Variable']")
	@CacheLookup
	private static WebElement variableToggleBttn;

	//label[@for='variable-package-940730']
	////LABEL[@class='ios-checkbox custom-control-label mt-0'][text()='Variable']
	
	@FindBy(xpath = "//A[@id='btnScheduleBooking']")
	@CacheLookup
	private static WebElement scheduleBookingBttn;
	
	
	@FindBy(xpath = "//div[contains(text(),'Select TRNR')]")
	@CacheLookup
	private static WebElement selectTrainerField;

	
	@FindBy(xpath = "//SPAN[@class='text'][text()='Automation DND']")
	@CacheLookup
	private static WebElement selectTrainer;

	
	
	@FindBy(xpath = "//BUTTON[@type='button'][text()='Select All']")
	@CacheLookup
	private static WebElement trainerSelectAll;

	
	
	@FindBy(xpath = "//a[@class='right-arrow calendar-custom-arrow']/following::div[position()=1]//h6")
	@CacheLookup
	private static WebElement trainerSlot;

	@FindBy(xpath = "//a[@class='right-arrow calendar-custom-arrow']")
	@CacheLookup
	private static WebElement trainerSlotNextWeek;

	
	
	
	

	
	@FindBy(xpath = "//label[@for='0-ift-coach-100641`6`7`May 29, 2021']//h6[contains(text(),'Automation')]")
	@CacheLookup
	private static WebElement trainerSlot2;

	
	@FindBy(xpath = "//button[@id='addsession-available-session-slot-confirm-btn']")
	@CacheLookup
	private static WebElement trainerSlotConfirmBttn;

	
	@FindBy(xpath = "//a[normalize-space()='review']")
	@CacheLookup
	private static WebElement reviewBttn;
	
	
	 
	
	@FindBy(xpath = "//button[@class ='btn btn-link collapsed']")
	@CacheLookup
	private static WebElement sessionExpand;
	
	@FindBy(xpath = "	//a[normalize-space()='Waiver']")
	@CacheLookup
	private static WebElement waiverBttn;
	
	
	@FindBy(xpath = "	//a[normalize-space()='payment now']")
	@CacheLookup
	private static WebElement paymentNowBttn;
	

	@FindBy(xpath = "//input[@aria-label='Search']")
	@CacheLookup
	private static WebElement trainerTextField;
	
	@FindBy(xpath = "//button[normalize-space()='Add card']")
	@CacheLookup
	private static WebElement addCardBttn;
	
	
	@FindBy(xpath = "//input[@id='txtNameOnCard']")
	@CacheLookup
	private static WebElement nameOnCard;
	
	
	@FindBy(xpath = "//input[@id='txtCreditCardNo']")
	@CacheLookup
	private static WebElement cardNumber;
	
	
	@FindBy(xpath = "//input[@id='txtCVV']")
	@CacheLookup
	private static WebElement cardCVVNumber;
	
	@FindBy(xpath = "//input[@id='txtCCEmail']")
	@CacheLookup
	private static WebElement cardHolderEmail;
	
	
	@FindBy(xpath = "//input[@id='txtCCAddress1']")
	@CacheLookup
	private static WebElement cardHolderAddress;
	
	
	
	@FindBy(xpath = "//input[@id='txtCCCity']")
	@CacheLookup
	private static WebElement cardHolderCity;
	
	
	
	@FindBy(xpath = "//input[@id='txtCCPostalCode']")
	@CacheLookup
	private static WebElement cardHolderPostalCode;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	@CacheLookup
	private static WebElement saveCardInfoBttn;
	
	
	
	@FindBy(xpath = "//input[@id='txtDiscount']")
	@CacheLookup
	private static WebElement discountTextField;


	@FindBy(xpath = "//button[@id='btnApplyDiscount']")
	@CacheLookup
	private static WebElement applyDiscountBttn;
	
	
	
	
	@FindBy(xpath = "//a[normalize-space()='pay']")
	@CacheLookup
	private static WebElement payBtnAfterAddingCardInfo;
	
	
	
	@FindBy(xpath = "//a[normalize-space()='Packages']")
	By packageTabBY = By.xpath("//a[normalize-space()='Packages']");
	
	
	
	@FindBy(xpath = "//div[@id='accordion']//div[1]//div[1]//button[1]")
	@CacheLookup
	private static WebElement expandArrowPackageOne;
	
	@FindBy(xpath = "//div[@class='row']//div[2]//div[1]//button[1]")
	@CacheLookup
	private static WebElement expandArrowPackageTwo;
	

	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void clickPackageTab() throws InterruptedException {

		wHelper.waitForVisibilityLoader();
		System.out.println("clickPackageTab");

		packageTab = wHelper.handleStaleElement(packageTabBY, 5, 20);
		wHelper.waitForElementToBeClickable(packageTab);
		packageTab.click();

		log.info(packageTab);
	}

	public void clickAddPackageBttn() throws InterruptedException {

		// wHelper.waitForVisibilityLoader();
		System.out.println("addPackageBttn");

		// userss = wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(addPackageBttn);
		addPackageBttn.click();

		log.info(addPackageBttn);
	}

	public void clickAnnualMembership() throws InterruptedException {

		// wHelper.waitForVisibilityLoader();
		System.out.println("clickAnnualMembership");

		// userss = wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(annualMembership);
		annualMembership.click();

		log.info(annualMembership);
	}

	public void clickProceedMembership() throws InterruptedException {

		// wHelper.waitForVisibilityLoader();
		System.out.println("clickAnnualMembership");

		// userss = wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(proceedBttn);
		proceedBttn.click();

		log.info(proceedBttn);
	}

	public void clickAddOnBttn() throws InterruptedException {

	//	wHelper.waitForVisibilityLoader();
		System.out.println("clickAddOnBttn");

		// userss = wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(addONBttn);
		addONBttn.click();

		log.info(addONBttn);
	}

	public void clickYogaSession() throws InterruptedException {

		// wHelper.waitForVisibilityLoader();
		System.out.println("yogaSession");

//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(yogaSession);
		yogaSession.click();

		log.info(yogaSession);
	}

	public void clickAddToPackageBttn() throws InterruptedException {

		
		System.out.println("addToPackageBttn");

		wHelper.waitForElementToBeClickable(addToPackageBttn);
		addToPackageBttn.click();

		log.info(addToPackageBttn);
	}

	public void clickVariableToggleBttn() throws InterruptedException {

		// wHelper.waitForVisibilityLoader();
		System.out.println("variableToggleBttn");

//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		
	//	wHelper.waitForElementVisible2(variableToggleBttn, 5, 20);
		//wHelper.waitForElementToBeClickable(variableToggleBttn);
		wHelper.hardWait(3000);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", variableToggleBttn);
		js.executeScript("window.scrollBy(0,-100);", variableToggleBttn);
		Actions actions = new Actions(driver);
		actions.moveToElement(variableToggleBttn).click().build().perform();
		

		
		
//		wHelper.waitForVisibility(variableToggleBttn);
		
	//	variableToggleBttn.click();

		log.info(variableToggleBttn);
	}
	
	

	public void clickScheduleBookingBttn() throws InterruptedException {

		// wHelper.waitForVisibilityLoader();
		System.out.println("scheduleBookingBttn");

//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(scheduleBookingBttn);
		scheduleBookingBttn.click();

		log.info(scheduleBookingBttn);
	}
	
	
	
	public void clickSelectTrainerField() throws InterruptedException {

		 wHelper.waitForVisibilityLoader();
		System.out.println("selectTrainerField");

		//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(selectTrainerField);
		selectTrainerField.click();

		log.info(selectTrainerField);
	}
	
	
	
	
	
	
	
	public void selectTrainer() throws InterruptedException {

		 //wHelper.waitForVisibilityLoader();
		System.out.println("selectTrainer");
		
		

		//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(selectTrainer);
		selectTrainer.click();

		log.info(selectTrainer);
	}
	
	
	
	public void sendTrainerName(CharSequence... keysToSend) {

		wHelper.waitForVisibility(trainerTextField);
		trainerTextField.sendKeys(keysToSend);

	}
	
	public void clickTrainerSelectAll() throws InterruptedException {

		 //wHelper.waitForVisibilityLoader();
		System.out.println("trainerSelectAll");

		//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(trainerSelectAll);
		trainerSelectAll.click();

		log.info(trainerSelectAll);
	}
	
	
	
	
	public void clickNextWeekArrowForTrainerSlot() throws InterruptedException {

		 //wHelper.waitForVisibilityLoader();
		System.out.println("trainerSlotNextWeek");

		//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(trainerSlotNextWeek);
		trainerSlotNextWeek.click();

		log.info(trainerSlotNextWeek);
	}
	
	
	
	
	public void clickTrainerSlot() throws InterruptedException {

		 //wHelper.waitForVisibilityLoader();
		System.out.println("trainerSlot");

		//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(trainerSlot);
		trainerSlot.click();

		log.info(trainerSlot);
	}
	
	
	
	public void clickTrainerSlotConfirmBttn() throws InterruptedException {

		 //wHelper.waitForVisibilityLoader();
		System.out.println("trainerSlotConfirmBttn");

		//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(trainerSlotConfirmBttn);
		trainerSlotConfirmBttn.click();

		log.info(trainerSlotConfirmBttn);
	}
	
	
	
	
	public void clickReviewBttn() throws InterruptedException {

		 wHelper.waitForVisibilityLoader();
		System.out.println("reviewBttn");

		//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(reviewBttn);
		reviewBttn.click();

		log.info(reviewBttn);
	}
	
	
	public void clickSessionExpand() throws InterruptedException {

		 //wHelper.waitForVisibilityLoader();
		System.out.println("sessionExpand");

		//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(sessionExpand);
		sessionExpand.click();

		log.info(sessionExpand);
	}
	
	
	
	// verify slot is added %%%%%%%%%%%%%%%%%%%%5
	
	
	
	
	public void clickWaiverBttn() throws InterruptedException {

		 //wHelper.waitForVisibilityLoader();
		System.out.println("waiverBttn");

		//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(waiverBttn);
		waiverBttn.click();

		log.info(waiverBttn);
	}
	
	
	//loader and verfy text repmote  paymente and payment now
	

	public void clickAddCardBttn() throws InterruptedException {

		 wHelper.waitForVisibilityLoader();
		System.out.println("addCardBttn");

		//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(addCardBttn);
		addCardBttn.click();

		log.info(addCardBttn);
	}
	
	
	
	

	public void clickPaymentNowBttn() throws InterruptedException {

		// wHelper.waitForVisibilityLoader();
		System.out.println("paymentNowBttn");

		//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForVisibility(paymentNowBttn);
		//wHelper.waitForElementToBeClickable(paymentNowBttn);
		paymentNowBttn.click();

		log.info(paymentNowBttn);
	}
	
	
	
	

	public void clickAddCardnfoBttn() throws InterruptedException {

		 wHelper.waitForVisibilityLoader();
		System.out.println("addCardBttn");

		//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(addCardBttn);
		addCardBttn.click();

		log.info(addCardBttn);
	}
	
	
	
	

	public void addCardHolderName(CharSequence... keysToSend) {

		wHelper.waitForVisibility(nameOnCard);
		nameOnCard.sendKeys(keysToSend);

	}
	
	
	public void addCardNumber(CharSequence... keysToSend) {

		wHelper.waitForVisibility(cardNumber);
		cardNumber.sendKeys(keysToSend);

	}
	
	
	
	
	public void addCardCVVNumber(CharSequence... keysToSend) {

		wHelper.waitForVisibility(cardCVVNumber);
		cardCVVNumber.sendKeys(keysToSend);

	}
	
	
	
	
	
	public void addCardHolderEmail(CharSequence... keysToSend) {

		wHelper.waitForVisibility(cardHolderEmail);
		cardHolderEmail.sendKeys(keysToSend);

	}
	
	
	
	public void addCardHolderAddress(CharSequence... keysToSend) {

		wHelper.waitForVisibility(cardHolderAddress);
		cardHolderAddress.sendKeys(keysToSend);

	}
	
	
	
	public void addCardHolderCity(CharSequence... keysToSend) {

		wHelper.waitForVisibility(cardHolderCity);
		cardHolderCity.sendKeys(keysToSend);

	}
	
	public void addCardHolderPostalCode(CharSequence... keysToSend) {

		wHelper.waitForVisibility(cardHolderPostalCode);
		cardHolderPostalCode.sendKeys(keysToSend);

	}
	
	
	
	public void clickSaveCardInfoBttn() throws InterruptedException {

		// wHelper.waitForVisibilityLoader();
	//	System.out.println("saveCardInfoBttn");

		//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(saveCardInfoBttn);
		saveCardInfoBttn.click();

		log.info(saveCardInfoBttn);
	}
	
	

	
	public void addDiscount(CharSequence... keysToSend) throws InterruptedException {
	
		wHelper.waitForVisibilityLoader();
		wHelper.waitForVisibility(discountTextField);
		discountTextField.sendKeys(keysToSend);

	}
	
	
	public void clickApplyDiscount() throws InterruptedException {

		// wHelper.waitForVisibilityLoader();
		System.out.println("applyDiscountBttn");

		//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.waitForElementToBeClickable(applyDiscountBttn);
		applyDiscountBttn.click();

		log.info(applyDiscountBttn);
	}
	

	
	public void clickPayBttnAfterAddingCardInfo() throws InterruptedException {

		wHelper.waitForVisibilityLoader();
	//	System.out.println("payBtnAfterAddingCardInfo");

		//	userss =	wHelper.handleStaleElement(userssBy, 5, 20);
		wHelper.hardWait(5000);
		wHelper.waitForElementToBeClickable(payBtnAfterAddingCardInfo);
		payBtnAfterAddingCardInfo.click();

		log.info(payBtnAfterAddingCardInfo);
	}
	
	
	
	
	public void verifySlotIsBooked() throws InterruptedException {

			
		

		
		softAssert1.assertFalse(trainerSlot.isSelected());
		

	
	
	}
	
	
	
	
	
	public void verifyTrainerSlotInSchduleBookingReview() throws InterruptedException {

	


		softAssert1.assertEquals("Automation DND", packageReviewINScheduleBooking.getAttribute("innerHTML"));

			
		
	}
	

	
	
	public void verifyGuidlinesText() throws InterruptedException {

		System.out.println("verifyGuidlinesText"+remotePaymentText.getText());
		
		System.out.println("verifyGuidlinesText"+paymentNowText.getText());
		

		softAssert1.assertEquals("Remote Payment", remotePaymentText.getText());

		softAssert1.assertEquals("Payment Now", paymentNowText.getText());

		
		
		
		
		
	}
	
	public void verifyAnnualMemberShipAndVariablePkgCartInReceivePayment() throws InterruptedException {

		System.out.println("Annual Membership"+annualMemberShip.getText());
		
		System.out.println("Variable Package Cart"+variablePkgCart.getText());
		
		
		softAssert1.assertEquals("Annual Membership", annualMemberShip.getText());

		softAssert1.assertEquals("Variable Package Cart", variablePkgCart.getText());


		
	}
	
	


	
	public void clickExpandPackage1() throws InterruptedException {


		wHelper.waitForElementToBeClickable(expandArrowPackageOne);
		expandArrowPackageOne.click();

		log.info(expandArrowPackageOne);
	}
	
	public void clickExpandPackage2() throws InterruptedException {

	//		System.out.println("expandArrowPackageTwo");


		wHelper.waitForElementToBeClickable(expandArrowPackageTwo);
		expandArrowPackageTwo.click();

		log.info(expandArrowPackageTwo);
	}
	
	
		
		
	public void verifyAnnualMemberShipOnThankYouScreen() throws InterruptedException {

	//	System.out.println("Annual Membership"+packageInfoOnThankYouScreen1.getText());
		
		
		
		softAssert1.assertEquals("Annual Membership", packageInfoOnThankYouScreen1.getText());



		
	
		
	}
	
	public void verifyYogaOnThankYouScreen() throws InterruptedException {

		
		System.out.println("yOOGAAAA"+packageInfoOnThankYouScreen2.getText());
		
		

		softAssert1.assertEquals("YogaQA", packageInfoOnThankYouScreen2.getText());


		
	
		
	}


	
	public void verifyPackageUnderPackagesTab() throws InterruptedException {

		
		System.out.println("Annual Membership>>>"+annualMemberShipUnderPackageTab.getText());
		
	System.out.println("Variable Packag>>>>"+variablePackageUnderPackageTab.getText());


	softAssert1.assertEquals("Annual MembershipQA", annualMemberShipUnderPackageTab.getText());

	softAssert1.assertEquals("Variable PackageQA", variablePackageUnderPackageTab.getText());


		
	
		
	}
	

	
	
	
	
	
	
	
	
	
	public void validateAssertAll() throws InterruptedException {
	
		System.out.println("Inside assert All");
		softAssert1.assertAll();

	
	}
	
	

}
