
package com.cloudeagle.framework.configuration.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cloudeagle.framework.utility.DateTimeHelper;
import com.cloudeagle.framework.utility.ResourceHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author krana
 *
 */
public class ChromeBrowser {

	public Capabilities getChromeCapabilities() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		option.addArguments(new String[] { "headless" });
		option.addArguments(new String[] { "window-size=1200x600" });
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		chrome.setCapability(ChromeOptions.CAPABILITY, option);
		return chrome;
	}

	public WebDriver getChromeDriver(Capabilities cap) {
//		System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("driver/chromedriver.exe"));
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.logfile", ResourceHelper.getResourcePath("logs/chromelogs/") + "chromelog"
				+ DateTimeHelper.getCurrentDateTime() + ".log");
		return new ChromeDriver(cap);
	}

	public WebDriver getChromeDriver(String hubUrl, Capabilities cap) throws MalformedURLException {
		return new RemoteWebDriver(new URL(hubUrl), cap);
	}

}
