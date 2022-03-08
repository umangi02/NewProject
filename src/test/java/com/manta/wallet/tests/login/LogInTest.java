package com.manta.wallet.tests.login;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;
import com.manta.framework.utilities.Randoms;
import com.manta.framework.utilities.Report;
import com.manta.wallet.pageobjects.biometric.BiometricSO;
import com.manta.wallet.pageobjects.login.LogInSO;
import com.manta.wallet.pageobjects.phoneno.AddPhoneNumberSO;
import com.manta.wallet.pageobjects.profile.ProfileSO;
import com.manta.wallet.pageobjects.signup.SignUpSO;
import com.manta.wallet.pageobjects.verifyemail.VerifyEmailPO;
import com.manta.wallet.pageobjects.wallet.WalletSO;

public class LogInTest extends BaseAppDriver {

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

	@Test(description = "Verify user is geting an error message if the email address is not verified.")
	public void testVerifyEmailFieldIsNotVerified() {

		String user = Randoms.getRandomCharacters(3);
		userEmail = user + "@mailinator.com";

		signupScreen.signUp(userEmail, PASSWORD, PASSWORD);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + PASSWORD + "</b>");
		Report.log(Status.INFO, "Confirm Password: " + "<b>" + PASSWORD + "</b>");
		Report.log(Status.PASS, "User Signed Up Successfully.");

		signupScreen.clickBackToSignIn();
		Report.log(Status.PASS, "Click on Back To Sign In button.");

		loginScreen.logIn(userEmail, PASSWORD);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + PASSWORD + "</b>");
		Report.log(Status.PASS, "User logged in successfully.");

		generics.pause(3);

		Assert.assertTrue(loginScreen.isEmailVerifiedPopupDisplayed(), "Verified email Popup not displayed.");
		Report.log(Status.PASS, "Verify Email Verification Popup is visible.");

	}

	@Test(description = "Verify Sign In Screen.")
	public void testVerifySigninScreen() {

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		Assert.assertTrue(loginScreen.isEmailDisplayed(), "Email field not displayed.");
		Report.log(Status.PASS, "Email field on Log in screen.");
		Assert.assertTrue(loginScreen.isPasswordDisplayed(), "Password field not displayed.");
		Report.log(Status.PASS, "Password field on Log in screen.");
		Assert.assertTrue(loginScreen.isSignInDisplayed(), "Sign in Button not displayed.");
		Report.log(Status.PASS, "Sign in Button on Log in screen.");
		Assert.assertTrue(loginScreen.isForgotPasswordDisplayed(), "Forgot Password link not displayed.");
		Report.log(Status.PASS, "Forgot Password link on Sign up screen.");
		Assert.assertTrue(signupScreen.isCreateNewAccountDisplayed(), "Create an account button  not displayed.");
		Report.log(Status.PASS, "Create an account button on Sign up screen.");

	}

	@Test(description = "Verify user enter invalid data in signin screen .")
	public void testSigninWithInvalidDetails() {

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		String user = Randoms.getRandomCharacters(3);
		userEmail = user + "@@mailinator.com";

		loginScreen.logIn(userEmail, PASSWORD_INVALID);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + PASSWORD_INVALID + "</b>");

		Assert.assertEquals(loginScreen.getEmailvalidation(), "Invalid email");
		Report.log(Status.PASS, loginScreen.getEmailvalidation() + " validation message on Sign in screen.");

		Assert.assertEquals(loginScreen.getPasswordValidation(), "Invalid password");
		Report.log(Status.PASS, loginScreen.getPasswordValidation() + " validation message on Sign in screen.");

		loginScreen.clickShowPasword();
		Assert.assertEquals(loginScreen.isHidePasswordShown(), "false");
		Report.log(Status.PASS, "Click on show password button.");

	}

	@Test(description = "Verify user getting an error message if any of the field is left empty before clicking on the Login button.")
	public void testSigninWithFilledDetails() {

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		loginScreen.clearSignin();

		loginScreen.clickSignIn();
		Report.log(Status.PASS, "Click on Sign in button.");

		generics.pause(3);

		Assert.assertEquals(loginScreen.getEmailvalidation(), "Email required");
		Report.log(Status.PASS, loginScreen.getEmailvalidation() + " validation message on Sign in screen.");

		Assert.assertEquals(loginScreen.getPasswordValidation(), "Password required");
		Report.log(Status.PASS, loginScreen.getPasswordValidation() + " validation message on Sign in screen.");

		loginScreen.typeEmail(USEREMAIL);

		Assert.assertFalse(loginScreen.isEmailvalidationDisplayed(), "Email validation Displayed");
		Report.log(Status.PASS, "Email validation not displayed.");

		generics.pause(2);
		loginScreen.typePassword(PASSWORD);

		Assert.assertFalse(loginScreen.isPasswordValidationDisplayed(), "Password validation Displayed");
		Report.log(Status.PASS, "Password validation not displayed.");

	}

	@Test(description = "Verify User is able to access Forgot Password screen.")
	public void testForgotPasswordLink() {

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		loginScreen.clickForgotPassword();
		Report.log(Status.PASS, "Click on Forgot password button.");

		Assert.assertEquals(loginScreen.getForgotPassword(), "Forgot Password");
		Report.log(Status.PASS, loginScreen.getForgotPassword() + " header on Forgot Password screen.");

	}

	@Test(description = "Verify User should be able to Signin with Google Account.")
	public void testSigninWithGoogle() {

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		loginScreen.clickSigninWithGoogle();
		Report.log(Status.PASS, "Click on Sign in with Google button.");

		generics.pause(2);

		loginScreen.clickGoogleAccount();
		Report.log(Status.PASS, "Click on Google Account button.");

	}

	@Test(description = "Verify User is able to sign-in to their account credentials by clicking on the Login button.")
	public void testSigninWithCredentialsDetails() {

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		loginScreen.logIn(USEREMAIL, PASSWORD);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + USEREMAIL + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + PASSWORD + "</b>");
		Report.log(Status.PASS, "Click on Sign in button.");

		biometricScreen.clickSkipBiometric();
		Report.log(Status.PASS, "Click on Do not show this again Biometric button.");

		Assert.assertTrue(walletScreen.isWalletDisplayed(), "Wallet not displayed.");
		Report.log(Status.PASS, "Verify Wallet screen is visible.");

	}
}