package com.manta.wallet.pageobjects.phoneno;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AddPhoneNumberSO extends BaseAppDriver {
	AndroidDriver<MobileElement> appDriver;
	Generics generics;

	public AddPhoneNumberSO(AndroidDriver<MobileElement> appDriver) {
		this.appDriver = appDriver;
		generics = new Generics(appDriver);
	}

	By countryDropDown = new By.ById(APP_PACKAGE + ":id/countryTIL");
	By addPhoneNoButton = new By.ById(APP_PACKAGE + ":id/addPhoneNoBtn");
	By countryCodeDropDown = new By.ById(APP_PACKAGE + ":id/tvCountryCode");
	By phoneNoTextField = new By.ById(APP_PACKAGE + ":id/edtPhone");
	By requestOtpButton = new By.ById(APP_PACKAGE + ":id/btnRequestOtp");
	By okButton = new By.ById(APP_PACKAGE + ":id/dialogInfoPositiveButton");
	By skipPhoneNoButton = new By.ById(APP_PACKAGE + ":id/skip_button");
	By invalidPhoneno = new By.ById(APP_PACKAGE + ":id/textinput_error");
	By otpField = new By.ById(APP_PACKAGE + ":id/edtOtp");
	By verifyOtpButton = new By.ById(APP_PACKAGE + ":id/btnVerifyOtp");
	By errorOkButton = new By.ById(APP_PACKAGE + ":id/dialogInfoPositiveButton");
	By searchEditText = new By.ById(APP_PACKAGE + ":id/edt_search");
	By resendOtpCodeLink = new By.ById(APP_PACKAGE + ":id/request_otp_button");
	
	public void clickSkipPhoneNo() {
		appDriver.findElement(skipPhoneNoButton).click();
	}

	public void clickVerifyOtpButton() {
		appDriver.findElement(verifyOtpButton).click();
	}

	public void clickErrorOk() {
		appDriver.findElement(errorOkButton).click();
	}

	public boolean isAddPhoneNODisplayed() {
		return generics.isElementPresent(addPhoneNoButton);
	}

	public void clickAddPhoneNo() {
		generics.waitForElementVisible(addPhoneNoButton);
		appDriver.findElement(addPhoneNoButton).click();
	}

	private void selectCountryCode(String countryName) {
		appDriver.findElement(countryCodeDropDown).click();
		generics.type(appDriver.findElement(searchEditText), countryName);
		appDriver.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + countryName + "')]")).click();
	}

	private void typePhoneNo(String phoneNo) {
		WebElement txtPoneNo = appDriver.findElement(phoneNoTextField)
				.findElement(By.xpath("//android.widget.EditText"));
		generics.type(txtPoneNo, phoneNo);
	}

	public void clickRequestOtp() {
		appDriver.findElement(requestOtpButton).click();
	}

	public void typeOtpField(String otpValue) {
		generics.type(appDriver.findElement(otpField), otpValue);
	}

	public void clickOk() {
		appDriver.findElement(okButton).click();
	}

	public String getPhoneValidation() {

		return generics
				.getText(appDriver.findElement(invalidPhoneno).findElementByClassName("android.widget.TextView"));
	}

	public void addPhoneDetails(String codeValue, String phoneNoValue) {
		clickAddPhoneNo();
		selectCountryCode(codeValue);
		typePhoneNo(phoneNoValue);

		// clickRequestOtp();
		// clickOk();
		// generics.pressBack();

	}

	public void addOtpDetails(String otpValue) {
		typeOtpField(otpValue);
		clickVerifyOtpButton();
		clickErrorOk();
		clickResendOtpCodeLink();

	}
	
	public void clickResendOtpCodeLink() {
		appDriver.findElement(resendOtpCodeLink).click();
	}

	
}
