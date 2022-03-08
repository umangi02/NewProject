package com.manta.wallet.tests.profile;

import org.testng.Assert;
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

public class ProfileTest extends BaseAppDriver {

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
	String countryName = "India";
	String firstName = "Qa";
	String lastName = "Automation";
	String phoneNo = "1234567892";

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

	@Test(description = "Verify Profile Creation screen after User signin first time")
	public void testVerifyUserProfileScreen() {

		String user = Randoms.getRandomCharacters(3);
		userEmail = user + "@mailinator.com";

		signupScreen.signUp(userEmail, PASSWORD);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + PASSWORD + "</b>");
		Report.log(Status.PASS, "User Signed Up Successfully.");

		webDriver = new BaseWebDriver().initializeWebDriver(BROWSER_NAME);
		Report.log(Status.PASS, "Open Chrome Browser.");
		verifyEmailPage = new VerifyEmailPO(webDriver);

		verifyEmailPage.verifyEmail(user);
		Report.log(Status.PASS, "Verify User Email.");

		generics.pause(2);

		signupScreen.clickBackToSignIn();
		Report.log(Status.PASS, "Click on Back To Sign In button.");

		loginScreen.logIn(userEmail, PASSWORD);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + PASSWORD + "</b>");
		Report.log(Status.PASS, "User logged in successfully.");
		
		generics.pause(5);
		
		Assert.assertTrue(profileScreen.isCountryDisplayed(), "County Drop Down not displayed.");
		Report.log(Status.PASS, "Country Drop Down on Profile screen.");
		Assert.assertTrue(profileScreen.isFirstNameDisplayed(), "First Name field not displayed.");
		Report.log(Status.PASS, "First Name field on Profile screen.");
		Assert.assertTrue(profileScreen.isLastNameDisplayed(), "Last Name field is not displayed.");
		Report.log(Status.PASS, "Last Name field on Profile screen.");
		Assert.assertTrue(profileScreen.isUserNameDisplayed(), "User Name field is not displayed.");
		Report.log(Status.PASS, "User Name field on Profile screen.");
		Assert.assertTrue(profileScreen.isReferralCodeDisplayed(), "Referral Code checkbox not displayed.");
		Report.log(Status.PASS, "Referral Code checkbox on Profile screen.");
		Assert.assertTrue(profileScreen.isContinueDisplayed(), "Continue button is not displayed.");
		Report.log(Status.PASS, "Continue button on Sign up screen.");

	}
	
	@Test(description = "Verify Profile Page after SignUp Check Validation message if wrong country spelling enter in country search field Successfully")
	public void testVerifyWrongCountryValidationInProfileScreen() {
	
		userEmail = "qwerty@mailinator.com";
		userPassword = "Hello@123";
		
		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		loginScreen.logIn(userEmail, userPassword);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + userPassword + "</b>");
		Report.log(Status.PASS, "User logged in successfully.");
		
		generics.pause(5);
		
		countryName = "Inddia" ;
		
		profileScreen.searchCountry(countryName);
		
		Assert.assertFalse(profileScreen.isCountrySuggestionDisplayed(countryName), "County Name Displayed On Profile Screen.");
		Report.log(Status.PASS, "County Name Not Displayed On Profile Screen.");
		
	}
	
	

}
