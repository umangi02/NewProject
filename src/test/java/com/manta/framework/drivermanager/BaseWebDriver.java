package com.manta.framework.drivermanager;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.manta.framework.common.Generics;
import com.manta.framework.configuration.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseWebDriver extends BaseDriverManager {

	/**
	 * To perform set of actions before suite start executing.
	 *
	 * @param context To set context for TestNG Listeners.
	 */
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext context) {
		context.setAttribute("platform", "web");
	}

	/**
	 * To initialize the driver before executing the test cases
	 *
	 * @param context TestNG listener context
	 */
	@BeforeMethod(alwaysRun = true)
	public void setUp(ITestContext context) {
		initializeWebDriver(BROWSER_NAME);
		context.setAttribute("WebDriver", webDriver);
	}

	/**
	 * Setup browser as per configurations.
	 *
	 * @param browserName chrome, firefox, edge or headless.
	 * @return WebDriver instance of created browser.
	 * @throws MalformedURLException
	 */
	public WebDriver initializeWebDriver(String browserName) {

		if (Configuration.getTestEnvironment().equalsIgnoreCase("remote")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			try {
				webDriver = new RemoteWebDriver(new URL(Configuration.getSeleniumURL()), chromeOptions);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else {
			switch (browserName.toLowerCase()) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				webDriver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				webDriver = new EdgeDriver();
				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				webDriver = new ChromeDriver();
				break;
			case "headless":
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				webDriver = new ChromeDriver(options);
				break;
			}
		}

		if (webDriver != null) {
			webDriver.get(BASE_URL);
			new Generics(webDriver).implicitWaitOf(Integer.parseInt(WEB_IMPLICIT_WAIT));
		}

		return webDriver;
	}

	/**
	 * Return the current instance of browser.
	 *
	 * @return WebDriver instance.
	 */
	public WebDriver getWebDriver() {
		return webDriver;
	}

	/**
	 * To close the resources once the test execution is completed
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		webDriver.quit();
	}

}
