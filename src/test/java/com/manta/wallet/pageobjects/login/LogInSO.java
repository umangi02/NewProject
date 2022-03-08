package com.manta.wallet.pageobjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LogInSO extends BaseAppDriver {

	AndroidDriver<MobileElement> appDriver;
	Generics generics;

	public LogInSO(AndroidDriver<MobileElement> appDriver) {
		this.appDriver = appDriver;
		generics = new Generics(appDriver);
	}

	By emailTextField = new By.ById(APP_PACKAGE + ":id/emailTIL");
	By passwordTextField = new By.ById(APP_PACKAGE + ":id/passwordTIL");
	By continueButton = new By.ById(APP_PACKAGE + ":id/continueBtn");
	By signInButton = new By.ById(APP_PACKAGE + ":id/signInBtn");
	By emailVerifiedLabel = new By.ById(APP_PACKAGE + ":id/dialogInfoTitleTextView");
	By noButton = new By.ById(APP_PACKAGE + ":id/dialogInfoNegativeButton");
	By yesButton = new By.ById(APP_PACKAGE + ":id/dialogInfoPositiveButton");
	By forgotButton = new By.ById(APP_PACKAGE + ":id/forgotPasswordBtn");
	By invalidEmailText = new By.ById(APP_PACKAGE + ":id/emailTIL");
	By invalidPasswordText = new By.ById(APP_PACKAGE + ":id/passwordTIL");
	By showPasswordButton = new By.ByXPath("//android.widget.ImageButton[@content-desc=\"Show password\"]");
	By forgotPasswordLabel = new By.ById(APP_PACKAGE + ":id/titleTV");
	By requestLinkButton = new By.ById(APP_PACKAGE + ":id/request_link_button");
	By signinWithGoogle = new By.ById(APP_PACKAGE + ":id/sign_in_tv");
	By loginButton = new By.ById(APP_PACKAGE + ":id/llAlreadyMember");
	By googleAccountButton = new By.ById(APP_PACKAGE + ":id/og_apd_internal_image_view");

	public boolean isEmailDisplayed() {
		return generics.isElementPresent(emailTextField);
	}

	public boolean isPasswordDisplayed() {
		return generics.isElementPresent(passwordTextField);
	}

	public boolean isSignInDisplayed() {
		return generics.isElementPresent(signInButton);
	}

	public boolean isForgotPasswordDisplayed() {
		return generics.isElementPresent(forgotButton);
	}

	public boolean isRequestLink() {
		return generics.isElementPresent(requestLinkButton);
	}

	public String isHidePasswordShown() {
		return appDriver.findElement(showPasswordButton).getAttribute("password");
	}

	public void typeEmail(String email) {
		WebElement txtEmail = appDriver.findElement(emailTextField).findElement(By.xpath("//android.widget.EditText"));
		generics.type(txtEmail, email);
	}

	public void typePassword(String password) {
		WebElement txtPassword = appDriver.findElement(passwordTextField)
				.findElement(By.xpath("//android.widget.EditText"));
		generics.type(txtPassword, password);
	}

	public void clickSignIn() {
		appDriver.findElement(signInButton).click();
	}

	public void clickContinue() {
		appDriver.findElement(continueButton).click();
	}

	private void clickNo() {
		appDriver.findElement(noButton).click();
	}

	private void clickYes() {
		appDriver.findElement(yesButton).click();

	}

	public void clickForgotPassword() {
		appDriver.findElement(forgotButton).click();
	}

	public void clickRequestLink() {
		appDriver.findElement(requestLinkButton).click();
	}

	public void clickSigninWithGoogle() {
		appDriver.findElement(signinWithGoogle).click();
	}

	public String getEmailvalidation() {
		return generics
				.getText(appDriver.findElement(invalidEmailText).findElementByXPath("//android.widget.TextView"));

	}

	public String getPasswordValidation() {
		return generics
				.getText(appDriver.findElement(invalidPasswordText).findElementByClassName("android.widget.TextView"));

	}

	public String getForgotPassword() {
		return generics.getText(appDriver.findElement(forgotPasswordLabel));

	}

	public Boolean isEmailvalidationDisplayed() {
		try {
			return generics.isElementPresent(
					appDriver.findElement(invalidEmailText).findElementByClassName("android.widget.TextView"));
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean isPasswordValidationDisplayed() {
		try {
			return generics.isElementPresent(
					appDriver.findElement(invalidPasswordText).findElementByClassName("android.widget.TextView"));
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isEmailVerifiedPopupDisplayed() {
		return generics.isElementPresent(emailVerifiedLabel);
	}

	public void clickShowPasword() {
		appDriver.findElement(showPasswordButton).click();

	}

	public void clickLogIn() {
		appDriver.findElement(loginButton).findElement(By.className("android.widget.TextView"));

	}

	public void logIn(String email, String password) {
		typeEmail(email);
		typePassword(password);
		clickSignIn();
	}

	public void clearSignin() {
		appDriver.findElement(emailTextField).findElement(By.xpath("//android.widget.EditText")).clear();
		appDriver.findElement(passwordTextField).findElement(By.xpath("//android.widget.EditText")).clear();
	}

	public void clickGoogleAccount() {
		appDriver.findElement(googleAccountButton).click();
	}

}
