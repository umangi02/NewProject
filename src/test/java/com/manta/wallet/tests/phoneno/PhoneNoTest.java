package com.manta.wallet.tests.phoneno;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;
import com.manta.framework.drivermanager.BaseWebDriver;
import com.manta.framework.utilities.Randoms;
import com.manta.framework.utilities.Report;
import com.manta.wallet.pageobjects.biometric.BiometricSO;
import com.manta.wallet.pageobjects.login.LogInSO;
import com.manta.wallet.pageobjects.phoneno.AddPhoneNumberSO;
import com.manta.wallet.pageobjects.profile.ProfileSO;
import com.manta.wallet.pageobjects.signup.SignUpSO;
import com.manta.wallet.pageobjects.verifyemail.VerifyEmailPO;
import com.manta.wallet.pageobjects.wallet.WalletSO;

public class PhoneNoTest extends BaseAppDriver {

	SignUpSO signupScreen;
	LogInSO loginScreen;
	ProfileSO profileScreen;
	BiometricSO biometricScreen;
	AddPhoneNumberSO phoneNoScreen;
	VerifyEmailPO verifyEmailPage;
	WalletSO walletScreen;

	Generics generics;
	String userEmail;
	String userPassword;
	String userPassword_Invalid;
	String userInvalidEmail;
	String countryName = "India";
	String firstName = "Qa";
	String lastName = "Automation";
	String invalidPhoneNo = "9895";
	String phoneNo = "9999999999";
	String otpValue = "123456";

	@BeforeMethod
	public void setUp() {
		signupScreen = new SignUpSO(appDriver);
		loginScreen = new LogInSO(appDriver);
		profileScreen = new ProfileSO(appDriver);
		biometricScreen = new BiometricSO(appDriver);
		phoneNoScreen = new AddPhoneNumberSO(appDriver);
		walletScreen = new WalletSO(appDriver);
		generics = new Generics(appDriver);
	}

	@Test(description = "Verify User should get an error message if user enters an invalid Phone Number")
	public void testAddInvalidPhoneNumber() {

		goToAddphoneNoScreen();
		phoneNoScreen.addPhoneDetails(countryName, invalidPhoneNo);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Country Code: " + "<b>" + countryName + "</b>");
		Report.log(Status.INFO, "Phone No: " + "<b>" + invalidPhoneNo + "</b>");

		Report.log(Status.PASS, phoneNoScreen.getPhoneValidation() + " validation message on phone screen.");
	}

	@Test(description = "Verify User should get an error message, if the OTP enter wrong .")
	public void testAddPhoneNumberWithInvalidOTP() {

		goToAddphoneNoScreen();
		phoneNoScreen.addPhoneDetails(countryName, phoneNo);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Country Code:" + "<b>" + countryName + "</b>");
		Report.log(Status.INFO, "Phone No:" + "<b>" + phoneNo + "</b>");

		phoneNoScreen.clickRequestOtp();

		phoneNoScreen.addOtpDetails(otpValue);
		
		generics.pause(2);
		

	}

	private void goToAddphoneNoScreen() {

		String userName = Randoms.getRandomCharacters(3);
		userEmail = userName + "@mailinator.com";

		signupScreen.signUp(userEmail, PASSWORD);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + PASSWORD + "</b>");
		Report.log(Status.PASS, "User Signed Up Successfully.");

		webDriver = new BaseWebDriver().initializeWebDriver(BROWSER_NAME);
		Report.log(Status.PASS, "Open Chrome Browser.");
		verifyEmailPage = new VerifyEmailPO(webDriver);

		verifyEmailPage.verifyEmail(userName);
		Report.log(Status.PASS, "Verify User Email.");

		generics.pause(2);

		signupScreen.clickBackToSignIn();
		Report.log(Status.PASS, "Click on Back To Sign In button.");

		loginScreen.logIn(userEmail, PASSWORD);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + PASSWORD + "</b>");
		Report.log(Status.PASS, "User logged in successfully.");

		profileScreen.addUserDetails(countryName, firstName, lastName, userName);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Country: " + "<b>" + countryName + "</b>");
		Report.log(Status.INFO, "First Name: " + "<b>" + firstName + "</b>");
		Report.log(Status.INFO, "Last Name: " + "<b>" + lastName + "</b>");
		Report.log(Status.INFO, "User Name: " + "<b>" + userName + "</b>");
		Report.log(Status.PASS, "Add User Profile Details.");

		biometricScreen.clickSkipBiometric();
		Report.log(Status.PASS, "Click on Skip Now for Biometric button.");

	}

}
