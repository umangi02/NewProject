package com.manta.wallet.pageobjects.biometric;

import org.openqa.selenium.By;

import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BiometricSO extends BaseAppDriver {

	AndroidDriver<MobileElement> appDriver;
	Generics generics;

	public BiometricSO(AndroidDriver<MobileElement> appDriver) {
		this.appDriver = appDriver;
		generics = new Generics(appDriver);

	}

	By skipNowButton = new By.ById(APP_PACKAGE + ":id/skip_button");

	public boolean isSkipNowDisplayed() {
		return generics.isElementPresent(skipNowButton);
	}

	public void clickSkipBiometric() {
		appDriver.findElement(skipNowButton).click();
	}

}