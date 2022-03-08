package com.manta.wallet.pageobjects.gold;

import org.openqa.selenium.By;

import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoldSO extends BaseAppDriver {

	AndroidDriver<MobileElement> appDriver;
	Generics generics;

	public GoldSO(AndroidDriver<MobileElement> appDriver) {
		this.appDriver = appDriver;
		generics = new Generics(appDriver);
	}

	By goldUSDBalance = new By.ById(APP_PACKAGE + ":id/tvUsdBalance");
	By goldNativeBalance = new By.ById(APP_PACKAGE + ":id/tvNativeBalance");
	By goldPercentage = new By.ById(APP_PACKAGE + ":id/tvPercentage");
	By goldLabel = new By.ByXPath("//android.widget.LinearLayout[@content-desc=\"Gold\"]");

	public void clickGold() {
		appDriver.findElement(goldLabel).click();
	}

	public boolean isGoldUSDBalancecyDisplayed() {
		return generics.isElementPresent(goldUSDBalance);
	}

	public boolean isCashNativeBalncehDisplayed() {
		return generics.isElementPresent(goldNativeBalance);
	}

	public boolean isCashPercentageDisplayed() {
		return generics.isElementPresent(goldPercentage);
	}

}
