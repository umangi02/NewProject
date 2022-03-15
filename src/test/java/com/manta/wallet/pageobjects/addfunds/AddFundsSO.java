package com.manta.wallet.pageobjects.addfunds;

import org.openqa.selenium.By;

import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AddFundsSO extends BaseAppDriver {

	AndroidDriver<MobileElement> appDriver;
	Generics generics;

	public AddFundsSO(AndroidDriver<MobileElement> appDriver) {
		this.appDriver = appDriver;
		generics = new Generics(appDriver);
	}

	By otcFundingLabel = new By.ByXPath("//android.widget.TextView[contains(@text,'OTC Funding')]");
	By turboDepositeLabel = new By.ByXPath("//android.widget.TextView[contains(@text,'Turbo Deposit')]");
	By cashoutLabel = new By.ByXPath("//android.widget.TextView[contains(@text,'')]");
	By depositeCryptoLabel = new By.ByXPath("//android.widget.TextView[contains(@text,'Deposit Crypto')]");
	By reciveUsingQRcodeLabel = new By.ByXPath("//android.widget.TextView[contains(@text,'Receive using QR Code')]");
	By userNameLabel = new By.ById(APP_PACKAGE + ":id/username_textView");
	By tradesLabel = new By.ById(APP_PACKAGE + ":id/traded_textview");
	By complitionLabel = new By.ById(APP_PACKAGE + ":id/ratings_textview");
	By volumeLabel = new By.ById(APP_PACKAGE + ":id/volume_textview");
	By buybutton = new By.ByXPath("//android.widget.Button[contains(@text,'Buy')]");
	By selectCountryLabel = new By.ById(APP_PACKAGE + ":id/title");
	By depositeLabel = new By.ById(APP_PACKAGE + ":id/add_method_textview");
	By reciveMoneyLabel = new By.ById(APP_PACKAGE + ":id/titleTV");

	public boolean isUserNameDisplayed() {
		return generics.isElementPresent(userNameLabel);
	}

	public boolean isTradesDisplayed() {
		return generics.isElementPresent(tradesLabel);
	}

	public boolean isComplitionDisplayed() {
		return generics.isElementPresent(complitionLabel);
	}

	public boolean isVolumeDisplayed() {
		return generics.isElementPresent(volumeLabel);
	}

	public boolean isOTCFundingsDisplayed() {
		return generics.isElementPresent(otcFundingLabel);
	}

	public boolean isTurboDepositeDisplayed() {
		return generics.isElementPresent(turboDepositeLabel);
	}

	public boolean isDespositeCryptoDisplayed() {
		return generics.isElementPresent(depositeCryptoLabel);
	}

	public boolean isReciveUsingQRCodeDisplayed() {
		return generics.isElementPresent(reciveUsingQRcodeLabel);
	}

	public void clickOTCHome() {
		appDriver.findElement(otcFundingLabel).click();

	}

	
	
	
	
	public void clickTurboDeposite() {
		appDriver.findElement(turboDepositeLabel).click();

	}

	public void clickDepositeCrypto() {
		appDriver.findElement(depositeCryptoLabel).click();

	}

	public void clickReciveQRCode() {
		appDriver.findElement(reciveUsingQRcodeLabel).click();

	}

	public String getSelectCountry() {
		return generics.getText(appDriver.findElement(selectCountryLabel));

	}

	public String getDeposite() {
		return generics.getText(appDriver.findElement(depositeLabel));

	}

	public String getReceiveMoney() {
		return generics.getText(appDriver.findElement(reciveMoneyLabel));

	}

	public String getBuy() {
		return generics.getText(appDriver.findElement(buybutton));

	}

}
