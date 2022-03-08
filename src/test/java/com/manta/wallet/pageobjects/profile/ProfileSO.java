package com.manta.wallet.pageobjects.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ProfileSO extends BaseAppDriver {

	AndroidDriver<MobileElement> appDriver;
	Generics generics;

	public ProfileSO(AndroidDriver<MobileElement> appDriver) {
		this.appDriver = appDriver;
		generics = new Generics(appDriver);
	}

	By countryDropDown = new By.ById(APP_PACKAGE + ":id/countryTIL");
	By firstNameTextField = new By.ById(APP_PACKAGE + ":id/firstNameTIL");
	By lastNameTextField = new By.ById(APP_PACKAGE + ":id/lastNameTIL");
	By userNameTextField = new By.ById(APP_PACKAGE + ":id/userNameTIL");
	By referralCodeCheckBox = new By.ById(APP_PACKAGE + ":id/referral_id_cb");
	By continueButton = new By.ById(APP_PACKAGE + ":id/continueBtn");
	By searchEditText = new By.ById(APP_PACKAGE + ":id/edt_search");
	By countryContainer = new By.ById(APP_PACKAGE + ":id/country_rv");	

	public boolean isCountryDisplayed() {
		return generics.isElementPresent(countryDropDown);
	}

	public boolean isFirstNameDisplayed() {
		return generics.isElementPresent(firstNameTextField);
	}

	public boolean isLastNameDisplayed() {
		return generics.isElementPresent(lastNameTextField);
	}

	public boolean isUserNameDisplayed() {
		return generics.isElementPresent(userNameTextField);
	}

	public boolean isReferralCodeDisplayed() {
		return generics.isElementPresent(referralCodeCheckBox);
	}

	public boolean isContinueDisplayed() {
		return generics.isElementPresent(continueButton);
	}

	private void selectCountry(String countryName) {
		appDriver.findElement(countryDropDown).click();
		generics.type(appDriver.findElement(searchEditText), countryName);
		generics.pause(2);
		appDriver.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + countryName + "')]")).click();
	}

	private void typeFirstName(String firstName) {
		WebElement txtFirstName = appDriver.findElement(firstNameTextField)
				.findElement(By.xpath("//android.widget.EditText"));
		generics.type(txtFirstName, firstName);
	}

	private void typeLastName(String lastName) {
		WebElement txtLastName = appDriver.findElement(lastNameTextField)
				.findElement(By.xpath("//android.widget.EditText"));
		generics.type(txtLastName, lastName);
	}

	private void typeUserName(String userName) {
		WebElement txtUserName = appDriver.findElement(userNameTextField)
				.findElement(By.xpath("//android.widget.EditText"));
		generics.type(txtUserName, userName);
	}

	public void clickContinue() {
		appDriver.findElement(continueButton).click();
	}

	public void addUserDetails(String countryValue, String firstName, String lastName, String userName) {
		selectCountry(countryValue);
		generics.pause(2);
		typeFirstName(firstName);
		typeLastName(lastName);
		typeUserName(userName);
		clickContinue();
	}

	public void searchCountry(String countryName) {
		appDriver.findElement(countryDropDown).click();
		generics.type(appDriver.findElement(searchEditText), countryName);
	}
	
	public boolean isCountrySuggestionDisplayed(String countryName) {
		try {
			MobileElement countryItem = appDriver.findElement(countryContainer).findElementByXPath("//*[contains(@text,'"+countryName+"')]");
			return Generics.isElementPresent(countryItem);
		}catch(Exception e) {
			return false;
		}
	}
}
