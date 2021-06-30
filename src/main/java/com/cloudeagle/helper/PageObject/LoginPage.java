package com.cloudeagle.helper.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.cloudeagle.framework.helper.BasePageObject.PageBase;

public class LoginPage extends PageBase {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	/** Web Elements */

	@FindBy(xpath = "//input[@name='emailField' and @type='text']")
	@CacheLookup
	private WebElement emailAddress;

	@FindBy(xpath = "//input[@name='passField' and @type='password']")
	@CacheLookup
	private WebElement password;

	@FindBy(xpath = "//button[contains(text(),'SIGN IN')]")
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

	@FindBy(xpath = "//div[@class=\"welcome-screen__title\"]")
	@CacheLookup
	private static WebElement welcomeScreenElement;

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public void enterUserName(String username) {
		emailAddress.sendKeys(username);
		log("Enter " + username + " in uasername text box", false);
	}

	public void enterPass(String userpwd) {
		password.sendKeys(userpwd);
		log("Enter " + userpwd + " in password text box", false);
	}

	/**
	 * Click on Sign In Button.
	 *
	 * @return the login class instance.
	 */
	public void ClickSignIn() {
		signInButton.click();
		log("Click on sign in button", false);
	}
}
