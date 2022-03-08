package com.manta.wallet.pageobjects.wallet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class WalletSO extends BaseAppDriver {
	AndroidDriver<MobileElement> appDriver;
	Generics generics;

	public WalletSO(AndroidDriver<MobileElement> appDriver) {
		this.appDriver = appDriver;
		generics = new Generics(appDriver);
	}

	By walletLabel = new By.ById(APP_PACKAGE + ":id/toolbar");
	By notificationIcon = new By.ById(APP_PACKAGE + ":id/iv_bell");
	By eyeIcon = new By.ById(APP_PACKAGE + ":id/eye_icon");
	By usdCurrancyValue = new By.ById(APP_PACKAGE + ":id/balance_tv");
	By userNativeCurrancyValue = new By.ById(APP_PACKAGE + ":id/local_balance");
	By buyingPowerButton = new By.ById(APP_PACKAGE + ":id/locked_balance");
	By cashLabel = new By.ByXPath("//android.widget.LinearLayout[@content-desc=\"Cash\"]");
	By cryptoLabel = new By.ByXPath("//android.widget.LinearLayout[@content-desc=\"Crypto\"]");
	By goldLabel = new By.ByXPath("//android.widget.LinearLayout[@content-desc=\"Gold\"]");
	By walletTabButton = new By.ByXPath("//android.widget.TextView[contains(@text,'Wallet')]");
	By sendTabButton = new By.ByXPath("//android.widget.TextView[contains(@text,'Send')]");
	By addFundsTabButton = new By.ByXPath("//android.widget.TextView[contains(@text,'Add Funds')]");
	By settingsTabButton = new By.ByXPath("//android.widget.TextView[contains(@text,'Settings')]");
	By sendLabel = new By.ById(APP_PACKAGE + ":id/title");
	By addFundsLabel = new By.ById(APP_PACKAGE + ":id/title");
	By settingsLabel = new By.ById(APP_PACKAGE + ":id/tv_otc_buy_title");
	By buyingPowerInfomation = new By.ById(APP_PACKAGE + ":id/infoTitle");
	By errorOkButton = new By.ById(APP_PACKAGE + ":id/dialogInfoPositiveButton");

	public String getWallet() {
		return generics.getText(appDriver.findElement(walletLabel).findElement(By.xpath("//android.widget.TextView")));

	}

	public boolean isWalletDisplayed() {
		WebElement element = appDriver.findElement(walletLabel).findElement(By.xpath("//android.widget.TextView"));
		return generics.isElementPresent(element);
	}

	public boolean isNotificationIconDisplayed() {
		return generics.isElementPresent(notificationIcon);
	}

	public boolean isEyeIconDisplayed() {
		return generics.isElementPresent(eyeIcon);
	}

	public boolean isUsdCurrancyValueDisplayed() {
		return generics.isElementPresent(usdCurrancyValue);
	}

	public boolean isUserNativeCurrancyValueDisplayed() {
		return generics.isElementPresent(userNativeCurrancyValue);
	}

	public boolean isBuyingPowerDisplayed() {
		return generics.isElementPresent(buyingPowerButton);
	}

	public boolean isCashDisplayed() {
		return generics.isElementPresent(cashLabel);
	}

	public boolean isCryptoDisplayed() {
		return generics.isElementPresent(cryptoLabel);
	}

	public boolean isGoldDisplayed() {
		return generics.isElementPresent(goldLabel);
	}

	public boolean isWalletTabButtonDisplayed() {
		return generics.isElementPresent(walletTabButton);
	}

	public boolean isSendDisplayed() {
		return generics.isElementPresent(sendTabButton);
	}

	public boolean isAddFundsDisplayed() {
		return generics.isElementPresent(addFundsTabButton);
	}

	public boolean isSettingsDisplayed() {
		return generics.isElementPresent(settingsTabButton);
	}

	public void clickWalletTab() {
		generics.waitForElementVisible(walletTabButton);
		appDriver.findElement(walletTabButton).click();
	}

	public void clickSend() {
		generics.waitForElementVisible(sendTabButton);
		appDriver.findElement(sendTabButton).click();
	}

	public String getSend() {
		return generics.getText(appDriver.findElement(sendLabel));

	}

	public String getAddFunds() {
		return generics.getText(appDriver.findElement(addFundsLabel));

	}

	public String getSettings() {
		return generics.getText(appDriver.findElement(settingsLabel));

	}

	public boolean isAddFundsLabelDisplayed() {
		generics.waitForElementVisible(addFundsTabButton);
		return generics.isElementPresent(addFundsLabel);

	}

	public boolean isSettingsLabelDisplayed() {
		return generics.isElementPresent(settingsLabel);
	}

	public void clickAddFunds() {
		generics.waitForElementVisible(addFundsTabButton);
		appDriver.findElement(addFundsTabButton).click();
	}

	public void clickSettings() {
		generics.waitForElementVisible(settingsTabButton);
		appDriver.findElement(settingsTabButton).click();
	}

	public String isHidePasswordShown() {
		return appDriver.findElement(eyeIcon).getAttribute("password");
	}

	public void clickShowPasword() {
		appDriver.findElement(eyeIcon).click();

	}

	public void clickBuyingPower() {
		appDriver.findElement(buyingPowerButton).click();
	}

	public boolean isBuyinPowerInformationDisplayed() {
		return generics.isElementPresent(buyingPowerInfomation);
	}

	public void clickErrorOk() {
		appDriver.findElement(errorOkButton).click();
	}
	
	public void clickCryptoLabel() {
		appDriver.findElement(cryptoLabel).click();

	}



}
