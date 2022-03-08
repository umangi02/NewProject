package com.manta.framework.configuration;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import com.manta.framework.utilities.Path;
import com.manta.framework.utilities.PropertiesFile;
import com.manta.wallet.dataprovider.ExcelData;


public interface Configuration extends ExcelData {

	String PROJECT_DIR = Path.getProjectDir();
	Properties appConfig = PropertiesFile.read(PROJECT_DIR + "/configuration/app.config.properties");
	Properties webConfig = PropertiesFile.read(PROJECT_DIR + "/configuration/web.config.properties");
	Properties genericsConfig = PropertiesFile.read(PROJECT_DIR + "/configuration/generics.config.properties");
	
	String DEVICE_ID = appConfig.getProperty("deviceID");
	String APP_NAME = appConfig.getProperty("app.name");
	String TARGET_ENV = appConfig.getProperty("target_env");
	String APP_PACKAGE = "com.mantasolutions.app.dev";
	String APP_ACTIVITY = appConfig.getProperty("app.activity");
	String APPIUM_HUB = appConfig.getProperty("appium.hub");
	String APPIUM_PORT = appConfig.getProperty("appium.port");
	String TEST_APK = PROJECT_DIR + File.separator + "resources" + File.separator + "apks" + File.separator
			+ "test.apk";
	String BASE_URL = webConfig.getProperty("baseUrl");
	String BROWSER_NAME = webConfig.getProperty("browser.name");
	String WEB_IMPLICIT_WAIT = webConfig.getProperty("default_wait");
	String APP_IMPLICIT_WAIT = appConfig.getProperty("default_wait");
	String WEB_DRIVER_WAIT = genericsConfig.getProperty("webdriver_wait");

	
	// API configurations.
	String API_BASE_URL = genericsConfig.getProperty("api_base_url");
	String API_KEY = genericsConfig.getProperty("api_key");

	/**
	 * To get remote grid URL
	 * 
	 * @return remote grid URL
	 */
	static URL getRemoteGridURL() {
		URL REMOTE_GRID_URL = null;
		try {
			REMOTE_GRID_URL = new URL(getAppiumURL());
		} catch (MalformedURLException ex) {
			System.out.println("Error occurred in Remote Grid URL.");
		}
		return REMOTE_GRID_URL;
	}

	/**
	 * To get appium URL
	 * 
	 * @return appium URL
	 */
	static String getAppiumURL() {
		String APPIUM_URL = null;
		if (System.getenv("APPIUM_URL") != null) {
			APPIUM_URL = System.getenv("APPIUM_URL");
		} else {
			APPIUM_URL = appConfig.getProperty("appium.url");
		}
		return APPIUM_URL;
	}

	/**
	 * To get selenium URL
	 * 
	 * @return selenium URL
	 */
	static String getSeleniumURL() {
		String SELENIUM_URL = null;
		if (System.getenv("SELENIUM_URL") != null) {
			SELENIUM_URL = System.getenv("SELENIUM_URL");
		} else {
			SELENIUM_URL = webConfig.getProperty("selenium.url");
		}
		return SELENIUM_URL;
	}

	/**
	 * To get APK path
	 * 
	 * @return APK path
	 */
	static String getApkPath() {
		String APK_PATH = null;

		if (System.getenv("APK_PATH") != null) {
			APK_PATH = System.getenv("APK_PATH");
		} else {
			APK_PATH = TEST_APK;
		}

		return APK_PATH;
	}

	/**
	 * To get test environment
	 * 
	 * @return test environment
	 */
	static String getTestEnvironment() {
		String TEST_ENVIRONMENT = null;

		if (System.getenv("TEST_ENVIRONMENT") != null) {
			TEST_ENVIRONMENT = System.getenv("TEST_ENVIRONMENT");
		} else {
			TEST_ENVIRONMENT = webConfig.getProperty("testEnvironment");
		}

		return TEST_ENVIRONMENT.toLowerCase();
	}

	/**
	 * To get device ID
	 * 
	 * @return device ID
	 */
	static String getDeviceId() {
		String deviceID = null;

		if (System.getenv("DEVICE_ID") != null) {
			deviceID = System.getenv("DEVICE_ID");
		} else {
			deviceID = DEVICE_ID;
		}

		return deviceID;
	}

	/**
	 * To get target environment
	 *
	 * @return target environment
	 */
	static String getTargetEnvironment() {
		String targetEnv = null;

		if (System.getenv("TARGET_ENV") != null) {
			targetEnv = System.getenv("TARGET_ENV");
		} else {
			targetEnv = TARGET_ENV;
		}

		return targetEnv;
	}

	/**
	 * To get system Port
	 * 
	 * @return systemPort
	 */
	static String getSystemPort() {
		return appConfig.getProperty("appium.systemPort");
	}
}
