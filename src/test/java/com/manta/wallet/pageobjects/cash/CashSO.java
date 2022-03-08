package com.manta.wallet.pageobjects.cash;

import org.openqa.selenium.By;

import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CashSO extends BaseAppDriver {

	AndroidDriver<MobileElement> appDriver;
	Generics generics;

	public CashSO(AndroidDriver<MobileElement> appDriver) {
		this.appDriver = appDriver;
		generics = new Generics(appDriver);
	}

	By cashUSDBalance = new By.ById(APP_PACKAGE + ":id/tvUsdBalance");
	By cashNativeBalance = new By.ById(APP_PACKAGE + ":id/tvNativeBalance");
	By cashExchangeRate = new By.ById(APP_PACKAGE + ":id/tvExchangeRate");
	By cashLabel = new By.ByXPath("//android.widget.LinearLayout[@content-desc=\"Cash\"]");

	public void clickCash() {
		appDriver.findElement(cashLabel).click();
	}

	public boolean isCashUSDBalancecyDisplayed() {
		return generics.isElementPresent(cashUSDBalance);
	}

	public boolean isCashNativeBalncehDisplayed() {
		return generics.isElementPresent(cashNativeBalance);
	}

	public boolean isCashExchangeRateDisplayed() {
		return generics.isElementPresent(cashExchangeRate);
	}

}
