
package com.cloudeagle.framework.helper.TextBox;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cloudeagle.constants.Constants;
import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.helper.Logger.LoggerHelper;
import com.cloudeagle.framework.helper.Wait.WaitHelper;
import com.cloudeagle.framework.settings.ObjectRepo;

/**
 * @author krana
 * 
 *
 */
public class TextBoxHelper extends GenericHelper {

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(TextBoxHelper.class);
	private WaitHelper wHelper;

	public TextBoxHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
		oLog.debug("TextBoxHelper : " + this.driver.hashCode());
		wHelper = new WaitHelper(driver, ObjectRepo.reader);
	}

	public void sendKeys(By locator, String value) {
		oLog.info("Locator : " + locator + " Value : " + value);
		getElement(locator).sendKeys(value);
	}

	public void clear(By locator) {
		oLog.info("Locator : " + locator);
		getElement(locator).clear();
	}

	public String getText(By locator) {
		oLog.info("Locator : " + locator);
		return getElement(locator).getText();
	}

	public void clearAndSendKeys(By locator, String value) {
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(value);
		oLog.info("Locator : " + locator + " Value : " + value);
	}

	public String getText(WebElement element) {
		wHelper.hardWait(2000);
		wHelper.waitForElementVisible(element, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		wHelper.hardWait(2000);
		oLog.info("Locator : " + element);
		return element.getText();
	}

	public void sendKeys(WebElement locator, String value) {
		wHelper.hardWait(2000);
		wHelper.waitForElementVisible(locator, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		wHelper.hardWait(2000);
		oLog.info("Locator : " + locator + " Value : " + value);
		locator.sendKeys(value);
	}

}
