
package com.cloudeagle.framework.helper.TextBox;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cloudeagle.framework.helper.Generic.GenericHelper;
import com.cloudeagle.framework.helper.Logger.LoggerHelper;

/**
 * @author krana
 * 
 *
 */
public class TextBoxHelper extends GenericHelper {

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(TextBoxHelper.class);

	public TextBoxHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
		oLog.debug("TextBoxHelper : " + this.driver.hashCode());
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
		oLog.info("Locator : " + element);
		return element.getText();
	}

	public void sendKeys(WebElement locator, String value) {
		oLog.info("Locator : " + locator + " Value : " + value);
		locator.sendKeys(value);
	}

}
