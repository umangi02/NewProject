package com.manta.wallet.pageobjects.forgotpassword;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;

import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ForgotPasswordSO extends BaseAppDriver {

	AndroidDriver<MobileElement> appDriver;
	Generics generics;

	public ForgotPasswordSO(AndroidDriver<MobileElement> appDriver) {
		this.appDriver = appDriver;
		generics = new Generics(appDriver);
	}

	By emailTextField = new By.ById(APP_PACKAGE + ":id/emailTIL");
	By emailVerifiedLabel = new By.ById(APP_PACKAGE + ":id/dialogInfoTitleTextView");
	By forgotButton = new By.ById(APP_PACKAGE + ":id/forgotPasswordBtn");
	By forgotPasswordLabel = new By.ById(APP_PACKAGE + ":id/titleTV");
	By requestLinkButton = new By.ById(APP_PACKAGE + ":id/request_link_button");
	By emailValidationText = new By.ById(APP_PACKAGE + ":id/compound_view_til");
	By checkYourEmailText = new By.ById(APP_PACKAGE + ":id/chech_your_email_textview");
	By incorrectPasswordText = new By.ById(APP_PACKAGE + ":id/dialogInfoMessageTextView");
	By tellUsAboutYourSelfLabel = new By.ById(APP_PACKAGE+":id/textView5");

	public boolean isForgotPasswordDisplayed() {
		return generics.isElementPresent(forgotButton);
	}

	public void typeEmail(String email) {
		generics.waitForElementVisible(emailTextField);
		WebElement txtEmail = appDriver.findElement(emailTextField).findElementByClassName("android.widget.EditText");
		generics.type(txtEmail, email);
	}

	public void clickRequestLink() {
		appDriver.findElement(requestLinkButton).click();
	}

	public String getEmailvalidation() {
		return generics
				.getText(appDriver.findElement(emailValidationText).findElementByClassName("android.widget.TextView"));

	}

	public String getForgotPassword() {
		return generics.getText(appDriver.findElement(forgotPasswordLabel));

	}

	public boolean isEmailvalidationDisplayed() {
		try {
			return generics.isElementPresent(
					appDriver.findElement(emailValidationText).findElementByClassName("android.widget.TextView"));
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isCheckEmailDisplayed() {
		return generics.isElementPresent(checkYourEmailText);
	}

	public void ForgotPasswordProcess(String email) {
		typeEmail(email);
		generics.pause(2);
		clickRequestLink();
	}

	public String getIncorrectPasswordValidation() {

		return generics.getText(appDriver.findElement(incorrectPasswordText));
	}
	
	public boolean isTellUsAboutYourselfDisplayed() {
		return generics.isElementPresent(tellUsAboutYourSelfLabel);
	}

}
