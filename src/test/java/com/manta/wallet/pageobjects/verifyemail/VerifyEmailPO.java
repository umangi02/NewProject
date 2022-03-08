package com.manta.wallet.pageobjects.verifyemail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.manta.framework.drivermanager.BaseWebDriver;

public class VerifyEmailPO extends BaseWebDriver {

	WebDriver webDriver;

	public VerifyEmailPO(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	By verifyEmailLink = new By.ByXPath("//a[contains(.,'firebaseapp.com')]");
	By userEmail = new By.ByXPath("//td[contains(.,'noreply@cbapp-f0333.firebaseapp.c')]");
	By emailBodyFrame = new By.ByXPath("//div[@id=\"pills-html\"]/iframe[1]");

	public void navigateToEmail(String userName) {
		webDriver.get(BASE_URL + userName);
	}

	public void clickUserEmail() {
		webDriver.findElement(userEmail).click();
	}

	public void clickVerifyLink() {
		WebElement element = webDriver.findElement(emailBodyFrame);
		webDriver.switchTo().frame(element);
		webDriver.findElement(verifyEmailLink).click();
	}

	public void verifyEmail(String userName) {
		navigateToEmail(userName);
		clickUserEmail();
		clickVerifyLink();
		
	}

}
