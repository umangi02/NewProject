package com.manta.framework.drivermanager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.manta.framework.common.Generics;
import com.manta.framework.configuration.Configuration;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

@Listeners(com.manta.framework.utilities.TestListener.class)
public class BaseAppDriver extends BaseDriverManager {

	private DesiredCapabilities capability = new DesiredCapabilities();

	/**
	 * To perform set of actions after suite start executing.
	 */
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext context) {
		appDriver = new AndroidDriver<>(Configuration.getRemoteGridURL(), capability);
		appDriver.removeApp("io.appium.settings");
		appDriver.removeApp("io.appium.uiautomator2.server");
		appDriver.removeApp("io.appium.uiautomator2.server.test");
		context.setAttribute("platform", "app");
	}
	
	/**
	 * To initialize the driver before executing the test cases
	 *
	 * @param context
	 */
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "udid", "systemPort" })
	public void setUp(ITestContext context, @Optional("") String udid, @Optional("") String systemPort) {

		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		capability.setCapability(MobileCapabilityType.FULL_RESET, false);
		capability.setCapability(MobileCapabilityType.NO_RESET, false);
		capability.setCapability(MobileCapabilityType.APP, Configuration.getApkPath());
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
		capability.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		capability.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		capability.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		System.setProperty("file.encoding", "UTF-8");

		if (udid.length() == 0) {
			udid = Configuration.getDeviceId();
		}
		if (systemPort.length() == 0) {
			systemPort = Configuration.getSystemPort();
		}
		capability.setCapability(MobileCapabilityType.UDID, udid);
		capability.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
		appDriver = new AndroidDriver<>(Configuration.getRemoteGridURL(), capability);
		new Generics(appDriver).implicitWaitOf(Integer.parseInt(APP_IMPLICIT_WAIT));
		context.setAttribute("AppDriver", appDriver);
	}

	/**
	 * To close the resources once the test execution is completed
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		// Close browser session if it was open during testing.
		if (webDriver != null) {
			webDriver.quit();
		}

		// Close appium session.
		capability.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, false);
		capability.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, false);
		appDriver.quit();
	}

}
