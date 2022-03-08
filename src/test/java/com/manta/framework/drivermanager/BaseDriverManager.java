package com.manta.framework.drivermanager;
import org.openqa.selenium.WebDriver;

import com.manta.framework.configuration.Configuration;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class BaseDriverManager implements Configuration {

	protected AndroidDriver<MobileElement> appDriver;
	protected WebDriver webDriver;

}
