package com.manta.wallet.pageobjects.crypto;

import org.openqa.selenium.By;

import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CryptoSO extends BaseAppDriver {

	AndroidDriver<MobileElement> appDriver;
	Generics generics;

	public CryptoSO(AndroidDriver<MobileElement> appDriver) {
		this.appDriver = appDriver;
		generics = new Generics(appDriver);
	}

	By cryptoCurrancyLabel = new By.ById(APP_PACKAGE + ":id/textview");
	By cryptoCurrancyWorth = new By.ById(APP_PACKAGE + ":id/textview2");
	By cryptoCurrancyPrice = new By.ById(APP_PACKAGE + ":id/textview3");
	By cryptoCurrancyRate = new By.ById(APP_PACKAGE + ":id/price_change_textview");
	By cryptoCurrancyInUSD = new By.ById(APP_PACKAGE + ":id/textview4");
	By cryptoLabel = new By.ByXPath("//android.widget.LinearLayout[@content-desc=\"Crypto\"]/android.widget.TextView");
	By cryptoIcon = new By.ByXPath("(//android.widget.ImageView[@content-desc=\"Image\"])[2]");
	
	public boolean isCryptoCurrancyDisplayed() {
		return generics.isElementPresent(cryptoCurrancyLabel);
	}

	public boolean isCryptoCurrancyWorthDisplayed() {
		return generics.isElementPresent(cryptoCurrancyWorth);
	}

	public boolean isCryptoCurrancyPriceDisplayed() {
		return generics.isElementPresent(cryptoCurrancyPrice);
	}

	public boolean isCryptoCurrancyRateDisplayed() {
		return generics.isElementPresent(cryptoCurrancyRate);
	}

	public boolean isCryptoCurrancyInUSDDisplayed() {
		return generics.isElementPresent(cryptoCurrancyInUSD);
	}

	public void clickCrypto() {
		appDriver.findElement(cryptoLabel).click();
	}
	
	public void clickCryptoCurrancy() {
		appDriver.findElement(cryptoCurrancyLabel).click();
	}

	
	public void clickCryptoIcon() {
		appDriver.findElement(cryptoIcon).click();
	}

	
}
