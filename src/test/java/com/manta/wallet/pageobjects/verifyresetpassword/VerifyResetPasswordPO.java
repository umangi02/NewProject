package com.manta.wallet.pageobjects.verifyresetpassword;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseWebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class VerifyResetPasswordPO extends BaseWebDriver {
	

	WebDriver webDriver;
	Generics generics;

	public VerifyResetPasswordPO(WebDriver webDriver) {
		this.webDriver = webDriver;
		generics = new Generics(webDriver);
	
	
	}
	
	


	By userEmail = new By.ByXPath("//td[contains(.,'noreply@cbapp-f0333.firebaseapp.c')]");
	By emailBodyFrame = new By.ByXPath("//div[@id=\"pills-html\"]/iframe[1]");
	By resetPasswordLink = new By.ByXPath("//a[contains(.,'resetPassword')]");
	By resetPasswordHeaderText = new By.ByXPath("//h1[contains(.,'Reset your password')]");
	By newPasswordEditText = new By.ByName("newPassword");
	By saveButton = new By.ByCssSelector("button");
	By passwordChangedLabel = new By.ByXPath("//h1[contains(.,'Password changed')]");
	By weakPasswordLabel = new By.ByXPath(
			"//p[contains(.,'Strong passwords have at least 6 characters and a mix of letters and numbers')]");
	By newPasswordField = new By.ByXPath("//input[@type=\"password\"]");
	By enterPasswordText = new By.ByXPath("//p[contains(.,'Enter your password')]");
	

	public void navigateToEmail(String userName) {
		webDriver.get(BASE_URL + userName);
	}

	public void clickUserEmail() {
		webDriver.findElement(userEmail).click();
	}

	public void clickVerifyResetPasswordLink() {
		WebElement element = webDriver.findElement(emailBodyFrame);
		webDriver.switchTo().frame(element);
		webDriver.findElement(resetPasswordLink).click();
	}

	public void verifyResetPasswordLink(String userName) {
		navigateToEmail(userName);
		clickUserEmail();
		clickVerifyResetPasswordLink();
	}

	public String getResetPasswordHeader() {
		return Generics.getText(webDriver.findElement(resetPasswordHeaderText));
	}

	public boolean isResetPasswordPageDisplayed() {
		WebElement resetPasswordPage = webDriver.findElement(resetPasswordHeaderText);
		return Generics.isElementPresent(resetPasswordPage);
	}

	public boolean isnewPasswordDisplayed() {
		WebElement newPassword = webDriver.findElement(newPasswordEditText);
		return Generics.isElementPresent(newPassword);
	}

	public boolean isSaveDisplayed() {
		WebElement save = webDriver.findElement(saveButton);
		return Generics.isElementPresent(save);
	}

	public void clickSavePassword() {
		webDriver.findElement(saveButton).click();

	}

	public boolean isPasswordChangedDisplayed() {
		WebElement changePassword = webDriver.findElement(passwordChangedLabel);
		return Generics.isElementPresent(changePassword);
	}

	public String getStrongPasswordValidation() {

		return generics.getText(webDriver.findElement(weakPasswordLabel));
	}

	public void typeNewPassword(String newPassword) {

		WebElement txtNewPassword = webDriver.findElement(newPasswordField);
		generics.type(txtNewPassword, newPassword);
	}

	public String getEnterPasswordValidation() {

		return generics.getText(webDriver.findElement(enterPasswordText));
	}
	

}


