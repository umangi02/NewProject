package com.manta.wallet.pageobjects.send;

import org.openqa.selenium.By;

import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class sendSO extends BaseAppDriver {
	
	AndroidDriver<MobileElement> appDriver;
	Generics generics;

	public sendSO(AndroidDriver<MobileElement> appDriver) {
		this.appDriver = appDriver;
		generics = new Generics(appDriver);
	}

	By avilabelBlanceLabel = new By.ById(APP_PACKAGE+":id/balanceTV");
	By transferAmountText = new By.ById(APP_PACKAGE+":id/etAmount");
	By errorMessageForExceedBalnaceText = new By.ById(APP_PACKAGE+":id/message_textView");
	By otpProcess = new By.ById(APP_PACKAGE+":/id");
	By selectContactButton = new By.ById(APP_PACKAGE+":id/btnSend");
	By searchContactField = new By.ById(APP_PACKAGE+":id/edt_contact");
	By addNoteField = new By.ById(APP_PACKAGE+":id/etAddNote");
	By suggestionForContactText = new By.ById(APP_PACKAGE+":id/tv_contact_name");
	By suggestionForAddNoteText = new By.ById(APP_PACKAGE+":id/tv_contact_username");
	By scanningTheReceiverQRCode = new By.ById(APP_PACKAGE+":id/qrImage");
	By BackIcon = new By.ById(APP_PACKAGE+":id/toolbar_backarrow");
	By sendButton = new By.ById(APP_PACKAGE+":id/sendBtn");
	
	By confirmationLabel = new By.ById(APP_PACKAGE+":id/toolbar_title");
	By amountToTransfer = new By.ById(APP_PACKAGE+":id/tvAmount");
	By noteAddedByUser = new By.ById(APP_PACKAGE+":id/noteTV");
	By FeeText = new By.ById(APP_PACKAGE+":id/lbl_fee_charges");
	By availableInstantlyText = new By.ById(APP_PACKAGE+":id/");
	By balanceAfterCompletingThePayment = new By.ById(APP_PACKAGE+":id/tv_balance");
	By sliderButton = new By.ById(APP_PACKAGE+":id/background_rl");
	By backArrow = new By.ById(APP_PACKAGE+":id/toolbar_backarrow");
	By errorMessageForMoneyNotTransferSuccessfull = new By.ById(APP_PACKAGE+":id/");
	By messageAfterSuccessfulTransfer = new By.ById(APP_PACKAGE+":/id");
	By viewReceiptButton = new By.ById(APP_PACKAGE+":/id");
	
	
	public boolean isAvailableBalanceDisplayed() {
		return generics.isElementPresent(avilabelBlanceLabel);
	}
	
	public boolean isTransferAmountDisplayed() {
		return generics.isElementPresent(transferAmountText);
	}

	public boolean isErrorMessageForExceedBalnaceDisplayed() {
		return generics.isElementPresent(errorMessageForExceedBalnaceText);
	}

	public boolean isConfirmationDisplayed() {
		return generics.isElementPresent(confirmationLabel);
	}

	public boolean isAmountToTransfer() {
		return generics.isElementPresent(amountToTransfer);
	}

	public boolean isNoteAddedByUser() {
		return generics.isElementPresent(noteAddedByUser);
	}

	public boolean isFeeText() {
		return generics.isElementPresent(FeeText);
	}

	public boolean isAvailableInstantlyText() {
		return generics.isElementPresent(availableInstantlyText);
	}

	public boolean isBalanceAfterCompletingThePayment() {
		return generics.isElementPresent(balanceAfterCompletingThePayment);
	}

	public boolean isEmailDisplayed() {
		return generics.isElementPresent(errorMessageForMoneyNotTransferSuccessfull);
	}

	public boolean isMessageAfterSuccesfullTransferDisplayed() {
		return generics.isElementPresent(messageAfterSuccessfulTransfer);
	}

	

	public void clickSend() {
		appDriver.findElement(sendButton).click();
	}


	public void clickSelectContact() {
		appDriver.findElement(selectContactButton).click();
	}


	public void clickSelectContactField() {
		appDriver.findElement(searchContactField).click();
	}


	public void clickBackArrow() {
		appDriver.findElement(backArrow).click();
	}


	public void clickSlider() {
		appDriver.findElement(sliderButton).click();
	}


	public void clickSearchContactField() {
		appDriver.findElement(searchContactField).click();
	}

	public void clickAddNoteField() {
		appDriver.findElement(addNoteField).click();
	}

	public void clickScanningTheReceiverQRCode() {
		appDriver.findElement(scanningTheReceiverQRCode).click();
	}

	public void clickViewReceipt() {
		appDriver.findElement(viewReceiptButton).click();
	}

	
	

}
