package com.manta.wallet.tests.signup;

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

public class SignUpTest extends BaseAppDriver {

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

	@Test(description = "Verify Sign up form")
	public void testVerifySignUpPage() {

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		signupScreen.clickCreateNewAccount();
		Report.log(Status.PASS, "Click on Create New Account button.");

		Assert.assertTrue(signupScreen.isEmailDisplayed(), "Email field not displayed.");
		Report.log(Status.PASS, "Email field displayed on Sign up screen.");
		Assert.assertTrue(signupScreen.isPasswordDisplayed(), "Password field is not displayed.");
		Report.log(Status.PASS, "Password field displayed on Sign up screen.");
		Assert.assertTrue(signupScreen.isConfirmPasswordDisplayed(), "Confirm password field is not displayed.");
		Report.log(Status.PASS, "Confirm Password field displayed on Sign up screen.");
		Assert.assertTrue(signupScreen.isContinueDisplayed(), "Continue button is not displayed.");
		Report.log(Status.PASS, "Continue button displayed on Sign up screen.");
		Assert.assertTrue(signupScreen.isSignInDisplayed(), "Sign in  button is not displayed.");
		Report.log(Status.PASS, "Sign in button displayed on Sign up screen.");
	}

	@Test(description = "Verify user is able to sign up and log in successfully.")
	public void testSignUpLogInWithValidDetails() {

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

		profileScreen.addUserDetails(countryName, firstName, lastName, user);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Country: " + "<b>" + countryName + "</b>");
		Report.log(Status.INFO, "First Name: " + "<b>" + firstName + "</b>");
		Report.log(Status.INFO, "Last Name: " + "<b>" + lastName + "</b>");
		Report.log(Status.INFO, "User Name: " + "<b>" + user + "</b>");
		Report.log(Status.PASS, "Add User Profile Details.");

		biometricScreen.clickSkipBiometric();
		Report.log(Status.PASS, "Click on Skip Now for Biometric button.");

		phoneNoScreen.clickSkipPhoneNo();
		Report.log(Status.PASS, "Click on Skip Add Phone No button.");

		Assert.assertTrue(walletScreen.isWalletDisplayed(), "Wallet not displayed.");
		Report.log(Status.PASS, "Verify Wallet screen is visible.");

	}

	@Test(description = "Verify user is geting an error message if any of the  fields in the Sign Up Page is invalid.")
	public void testVerifySignUpWithInvalidDetails() {

		String user = Randoms.getRandomCharacters(3);
		userEmail = user + "@@mailinator";

		signupScreen.signUp(userEmail, PASSWORD_INVALID, PASSWORD);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + PASSWORD_INVALID + "</b>");
		Report.log(Status.INFO, "Confirm Password: " + "<b>" + PASSWORD + "</b>");
		Report.log(Status.PASS, "User Signed Up  With Invalid Details.");

		Assert.assertEquals(signupScreen.getEmailValidation(), "Invalid email");
		Report.log(Status.PASS, signupScreen.getEmailValidation() + " validation message on Sign up screen.");
		Assert.assertEquals(signupScreen.getPasswordLengthValidation(), "Contains at least 8 characters");
		Report.log(Status.PASS, signupScreen.getPasswordLengthValidation() + " validation message on Sign up screen.");
		Assert.assertEquals(signupScreen.getPasswordCaseValidation(),
				"Contains both lower(a-z) and uppercase letters(A-Z)");
		Report.log(Status.PASS, signupScreen.getPasswordCaseValidation() + " validation message on Sign up screen.");
		Assert.assertEquals(signupScreen.getPasswordNumericValidation(), "Contains at least one number (0–9)");
		Report.log(Status.PASS, signupScreen.getPasswordNumericValidation() + " validation message on Sign up screen.");
		Assert.assertEquals(signupScreen.getPasswordSpecialCharecterValidation(),
				"Contains at least one special character");
		Report.log(Status.PASS,
				signupScreen.getPasswordSpecialCharecterValidation() + " validation message on Sign up screen.");

		signupScreen.clickContinue();
		Report.log(Status.PASS, "Click on Continue button.");

		Assert.assertEquals(signupScreen.getConfirmPasswordValidation(), "Your passwords do not match.");
		Report.log(Status.PASS, signupScreen.getEmailValidation() + " validation message on Sign up screen.");

	}

	@Test(description = "Verify user is geting an error message if any of the *mandatory fields in the Sign Up Page is not filled.")
	public void testVerifySignUpWithBlankMandatoryFields() {

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		signupScreen.clickCreateNewAccount();
		Report.log(Status.PASS, "Click on Create New Account button.");

		generics.pause(3);
		signupScreen.clickContinue();
		Report.log(Status.PASS, "Click on Continue button.");

		generics.pause(2);

		Assert.assertEquals(signupScreen.getEmailValidation(), "Email required");
		Report.log(Status.PASS, signupScreen.getEmailValidation() + " validation message on Sign up screen.");
		Assert.assertEquals(signupScreen.getPasswordLengthValidation(), "Contains at least 8 characters");
		Report.log(Status.PASS, signupScreen.getPasswordLengthValidation() + " validation message on Sign up screen.");
		Assert.assertEquals(signupScreen.getPasswordCaseValidation(),
				"Contains both lower(a-z) and uppercase letters(A-Z)");
		Report.log(Status.PASS, signupScreen.getPasswordCaseValidation() + " validation message on Sign up screen.");
		Assert.assertEquals(signupScreen.getPasswordNumericValidation(), "Contains at least one number (0–9)");
		Report.log(Status.PASS, signupScreen.getPasswordNumericValidation() + " validation message on Sign up screen.");
		Assert.assertEquals(signupScreen.getPasswordSpecialCharecterValidation(),
				"Contains at least one special character");
		Report.log(Status.PASS,
				signupScreen.getPasswordSpecialCharecterValidation() + " validation message on Sign up screen.");
		Assert.assertEquals(signupScreen.getConfirmPasswordValidation(), "Confirm Password required");
		Report.log(Status.PASS, signupScreen.getConfirmPasswordValidation() + " validation message on Sign up screen.");

	}

	@Test(description = "Verify  User should be able to navigate to the the Sign up screen to register for a new account.")
	public void testVerifyCreateAnAccountFunctionality() {

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		signupScreen.clickCreateNewAccount();
		Report.log(Status.PASS, "Click on Create New Account button.");

		generics.pause(3);

		Assert.assertTrue(signupScreen.isCreateDollieAccountDisplayed(), "Create a Dollie account");
		Report.log(Status.PASS, "Verify Create a Dollie account on Sign up screen is visible.");

	}
}