package com.manta.wallet.pageobjects.signup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SignUpSO extends BaseAppDriver {

	AndroidDriver<MobileElement> appDriver;
	Generics generics;

	public SignUpSO(AndroidDriver<MobileElement> appDriver) {
		this.appDriver = appDriver;
		generics = new Generics(appDriver);
	}

	By getStartedButton = new By.ById(APP_PACKAGE + ":id/btnWalkThroughGetStarted");
	By createNewAccountButton = new By.ById(APP_PACKAGE + ":id/createAccountBtn");
	By emailTextField = new By.ById(APP_PACKAGE + ":id/emailTIL");
	By passwordTextField = new By.ById(APP_PACKAGE + ":id/passwordTIL");
	By confirmPasswordTextField = new By.ById(APP_PACKAGE + ":id/confirmPasswordTIL");
	By continueButton = new By.ById(APP_PACKAGE + ":id/continueBtn");
	By signInButton = new By.ById(APP_PACKAGE + ":id/loginBtn");
	By backToSignInButton = new By.ById(APP_PACKAGE + ":id/back_to_login_button");
	By emailRequiredField = new By.ById(APP_PACKAGE + ":id/textinput_error");
	By passwordRequiredField = new By.ById(APP_PACKAGE + ":id/criteria");
	By confirmPasswordRequiredField = new By.ById(APP_PACKAGE + ":id/textinput_error");
	By invalidEmailText = new By.ById(APP_PACKAGE + ":id/textinput_error");
	By passwordLengthText = new By.ById(APP_PACKAGE + ":id/criteria1TV");
	By passwordCaseText = new By.ById(APP_PACKAGE + ":id/criteria2TV");
	By passwordNumericText = new By.ById(APP_PACKAGE + ":id/criteria3TV");
	By passwordSpecialCharecterText = new By.ById(APP_PACKAGE + ":id/criteria4TV");
	By confirmPasswordNotMatchText = new By.ById(APP_PACKAGE + ":id/textinput_error");
	By createDollieAccountLable = new By.ById(APP_PACKAGE + ":id/textView5");

	public void clickGetStarted() {
		appDriver.findElement(getStartedButton).click();
	}

	public void clickCreateNewAccount() {
		appDriver.findElement(createNewAccountButton).click();
	}

	public boolean isCreateNewAccountDisplayed() {
		return generics.isElementPresent(createNewAccountButton);
	}

	public boolean isEmailDisplayed() {
		return generics.isElementPresent(emailTextField);
	}

	public boolean isPasswordDisplayed() {
		return generics.isElementPresent(passwordTextField);
	}

	public boolean isConfirmPasswordDisplayed() {
		return generics.isElementPresent(confirmPasswordTextField);
	}

	public boolean isContinueDisplayed() {
		return generics.isElementPresent(continueButton);
	}

	public boolean isSignInDisplayed() {
		return generics.isElementPresent(signInButton);
	}

	private void typeEmail(String email) {
		WebElement txtEmail = appDriver.findElement(emailTextField).findElement(By.xpath("//android.widget.EditText"));
		generics.type(txtEmail, email);
	}

	private void typePassword(String password) {
		WebElement txtPassword = appDriver.findElement(passwordTextField)
				.findElement(By.xpath("//android.widget.EditText"));
		generics.type(txtPassword, password);
	}

	private void typeConfirmPassword(String confirmPassword) {
		WebElement txtConfirmPassword = appDriver.findElement(confirmPasswordTextField)
				.findElement(By.xpath("//android.widget.EditText"));
		generics.type(txtConfirmPassword, confirmPassword);
	}

	public void clickContinue() {
		appDriver.findElement(continueButton).click();
	}

	public void clickSignIn() {
		appDriver.findElement(signInButton).click();
	}
	

	public void clickBackToSignIn() {
		appDriver.findElement(backToSignInButton).click();
	}

	public boolean isEmailRequired() {
		return generics.isElementPresent(emailRequiredField);
	}

	public String getEmailValidation() {

		return generics
				.getText(appDriver.findElement(invalidEmailText).findElementByClassName("android.widget.TextView"));
	}

	public String getPasswordLengthValidation() {

		return generics.getText(appDriver.findElement(passwordLengthText));
	}

	public String getPasswordCaseValidation() {

		return generics.getText(appDriver.findElement(passwordCaseText));
	}

	public String getPasswordNumericValidation() {

		return generics.getText(appDriver.findElement(passwordNumericText));
	}

	public String getPasswordSpecialCharecterValidation() {

		return generics.getText(appDriver.findElement(passwordSpecialCharecterText));
	}

	public String getConfirmPasswordValidation() {

		return generics.getText(
				appDriver.findElement(confirmPasswordTextField).findElementByClassName("android.widget.TextView"));
	}

	public boolean isCreateDollieAccountDisplayed() {

		return generics.isElementPresent(appDriver.findElement(createDollieAccountLable));
	}

	public boolean isPasswordRequired() {
		return generics.isElementPresent(passwordRequiredField);
	}

	public boolean isConfirmPasswordRequired() {
		return generics.isElementPresent(confirmPasswordRequiredField);
	}

	public boolean isInvalidEmail() {
		return generics.isElementPresent(invalidEmailText);
	}

	public boolean isInvalidConfirmPassword() {
		return generics.isElementPresent(confirmPasswordNotMatchText);
	}

	public boolean isConfirmPasswordDoNotMatch() {
		return generics.isElementPresent(confirmPasswordNotMatchText);
	}

	public void signUp(String email, String password, String confirmPassword) {
		clickGetStarted();
		clickCreateNewAccount();
		typeEmail(email);
		typePassword(password);
		typeConfirmPassword(confirmPassword);

		clickContinue();
	}

	public void signUp(String email, String password) {
		clickGetStarted();
		clickCreateNewAccount();
		typeEmail(email);
		typePassword(password);
		typeConfirmPassword(password);

		clickContinue();
	}


}
