package com.manta.wallet.tests.forgotpassword;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;
import com.manta.framework.drivermanager.BaseWebDriver;
import com.manta.framework.utilities.Randoms;
import com.manta.framework.utilities.Report;
import com.manta.wallet.pageobjects.forgotpassword.ForgotPasswordSO;
import com.manta.wallet.pageobjects.login.LogInSO;
import com.manta.wallet.pageobjects.profile.ProfileSO;
import com.manta.wallet.pageobjects.signup.SignUpSO;
import com.manta.wallet.pageobjects.verifyemail.VerifyEmailPO;
import com.manta.wallet.pageobjects.verifyresetpassword.VerifyResetPasswordPO;
import com.manta.wallet.pageobjects.wallet.WalletSO;

public class ForgotPasswordTest extends BaseAppDriver {

	SignUpSO signupScreen;
	LogInSO loginScreen;
	ProfileSO profileScreen;
	VerifyEmailPO verifyEmailPage;
	ForgotPasswordSO forgotPasswordScreen;
	VerifyResetPasswordPO verifyResetPasswordPage;
	WalletSO walletScreen;

	Generics generics;
	String userEmail;
	String userPassword;

	@BeforeMethod
	public void setUp() {
		signupScreen = new SignUpSO(appDriver);
		loginScreen = new LogInSO(appDriver);
		profileScreen = new ProfileSO(appDriver);
		walletScreen = new WalletSO(appDriver);
		generics = new Generics(appDriver);
		forgotPasswordScreen = new ForgotPasswordSO(appDriver);
	}

	@Test(description = "Verify User is able to Navigate Forgot Password Screen By Clicking Forgot Password Button On login Screen.")
	public void testForgotPassword() {

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		loginScreen.clickForgotPassword();
		Report.log(Status.PASS, "Click on Forgot password button.");

		Assert.assertEquals(forgotPasswordScreen.getForgotPassword(), "Forgot Password");
		Report.log(Status.PASS, loginScreen.getForgotPassword() + " header on Forgot Password screen.");

	}

	@Test(description = "Verify User should not be able to click the Request Link button if the Email Address field is left empty successfully.")
	public void testForgotPasswordRequestLinkWithBlankUserName() {

		userEmail = "";

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		loginScreen.clickForgotPassword();
		Report.log(Status.PASS, "Click on Forgot password button.");

		forgotPasswordScreen.ForgotPasswordProcess(userEmail);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");

		generics.pause(2);
		Assert.assertEquals(forgotPasswordScreen.getEmailvalidation(), "Email required");
		Report.log(Status.PASS, forgotPasswordScreen.getEmailvalidation() + " validation on Forgot Password screen.");

		generics.pause(2);
	}

	@Test(description = "Verify User is get an error message if the Email Address entered by the user does not match any email address in the system successfully.")
	public void testForgotPasswordRequestLinkWithInValidUserName() {

		String user = Randoms.getRandomCharacters(4);
		userEmail = user + "@mailinator.com";

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		loginScreen.clickForgotPassword();
		Report.log(Status.PASS, "Click on Forgot password button.");

		forgotPasswordScreen.ForgotPasswordProcess(userEmail);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");

		generics.pause(2);
		Assert.assertEquals(forgotPasswordScreen.getEmailvalidation(), "User not found!");
		Report.log(Status.PASS, forgotPasswordScreen.getEmailvalidation() + " validation on Forgot Password screen.");

		generics.pause(2);
	}

	@Test(description = "Verify User is able to receive a link to their Email Address for recovering their password by clicking on the Request Link button in the Forgot Password Page successfully.")
	public void testForgotPasswordRequestLinkWithValidUserName() {

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

		loginScreen.clickForgotPassword();
		Report.log(Status.PASS, "Click on Forgot password button.");

		forgotPasswordScreen.ForgotPasswordProcess(userEmail);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");

		generics.pause(2);
		Assert.assertTrue(forgotPasswordScreen.isCheckEmailDisplayed(), "Check Your Email not found!");
		Report.log(Status.PASS, "User is able to access request link and navigate on Check Your Email Screen.");

	}

	@Test(description = "Verify User is able to navigate to the Password Reset page by clicking on the link sent to their registered Email Address successfully.")
	public void testNavigateResetPasswordRequestLink() {

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

		loginScreen.clickForgotPassword();
		Report.log(Status.PASS, "Click on Forgot password button.");

		forgotPasswordScreen.ForgotPasswordProcess(userEmail);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");

		Assert.assertTrue(forgotPasswordScreen.isCheckEmailDisplayed(), "Check Your Email not found!");
		Report.log(Status.PASS, "User is able to access request link and navigate on Check Your Email Screen.");

		generics.pause(2);

		webDriver = new BaseWebDriver().initializeWebDriver(BROWSER_NAME);
		Report.log(Status.PASS, "Open Chrome Browser.");
		verifyResetPasswordPage = new VerifyResetPasswordPO(webDriver);

		verifyResetPasswordPage.verifyResetPasswordLink(user);
		Report.log(Status.PASS, "Verify User Reset Password Link.");

		ArrayList<String> resetPasswordTab = new ArrayList<String>(webDriver.getWindowHandles());
		webDriver.switchTo().window(resetPasswordTab.get(1));

		generics.pause(2);

		Assert.assertTrue(verifyResetPasswordPage.isResetPasswordPageDisplayed(), "Reset Password Page not Displayed.");
		Report.log(Status.PASS,
				"User is able to navigate on reset password page By click on reset password verification link.");

	}

	@Test(description = "Verify Password Reset Page must contain the fields/buttons New Password, Retype Password and  Save button.")
	public void testVerifyResetPasswordPage() {

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

		loginScreen.clickForgotPassword();
		Report.log(Status.PASS, "Click on Forgot password button.");

		forgotPasswordScreen.ForgotPasswordProcess(userEmail);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");

		generics.pause(2);

		Assert.assertTrue(forgotPasswordScreen.isCheckEmailDisplayed(), "Check Your Email not found!");
		Report.log(Status.PASS, "User is able to access request link and navigate on Check Your Email Screen.");

		generics.pause(2);

		webDriver = new BaseWebDriver().initializeWebDriver(BROWSER_NAME);
		Report.log(Status.PASS, "Open Chrome Browser.");
		verifyResetPasswordPage = new VerifyResetPasswordPO(webDriver);

		verifyResetPasswordPage.verifyResetPasswordLink(user);
		Report.log(Status.PASS, "Verify User Reset Password Link.");

		ArrayList<String> resetPasswordTab = new ArrayList<String>(webDriver.getWindowHandles());
		webDriver.switchTo().window(resetPasswordTab.get(1));

		generics.pause(2);

		Assert.assertTrue(verifyResetPasswordPage.isResetPasswordPageDisplayed(), "Reset Password Page not Displayed.");
		Report.log(Status.PASS,
				"User is able to navigate on reset password page By click on reset password verification link.");

		Assert.assertTrue(verifyResetPasswordPage.isnewPasswordDisplayed(), "new password field not displayed.");
		Report.log(Status.PASS, "New Password field displayed on Reset Password page.");
		Assert.assertTrue(verifyResetPasswordPage.isSaveDisplayed(), "Save Button is not displayed.");
		Report.log(Status.PASS, "Save Button displayed on Reset Password page.");

	}

	@Test(description = "Verify  User is able to get a Password reset message after successful validation of all entered password fields and on clicking Save button succesfully.")
	public void testVerifyPasswordResetMessage() {

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

		loginScreen.clickForgotPassword();
		Report.log(Status.PASS, "Click on Forgot password button.");

		forgotPasswordScreen.ForgotPasswordProcess(userEmail);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");

		webDriver = new BaseWebDriver().initializeWebDriver(BROWSER_NAME);
		Report.log(Status.PASS, "Open Chrome Browser.");
		verifyResetPasswordPage = new VerifyResetPasswordPO(webDriver);

		verifyResetPasswordPage.verifyResetPasswordLink(user);
		Report.log(Status.PASS, "Verify User Reset Password Link.");

		generics.pause(3);

		ArrayList<String> resetPasswordTab = new ArrayList<String>(webDriver.getWindowHandles());
		webDriver.switchTo().window(resetPasswordTab.get(1));

		generics.pause(2);

		String newPassword = "Password1*";
		verifyResetPasswordPage.typeNewPassword(newPassword);

		verifyResetPasswordPage.clickSavePassword();
		Report.log(Status.PASS, "Click on Save Password button on Reset Password Page .");

		ArrayList<String> passwordChangedTab = new ArrayList<String>(webDriver.getWindowHandles());
		webDriver.switchTo().window(passwordChangedTab.get(1));

		generics.pause(2);

		Assert.assertTrue(verifyResetPasswordPage.isPasswordChangedDisplayed(), "Password changed Text not Displayed.");
		Report.log(Status.PASS, "User is able to Reset Password Successfully.");

	}

	@Test(description = "Verify User is able to login to their account with the New Password successfully.")
	public void testVerifyLoginWithNewPassword() {

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

		loginScreen.clickForgotPassword();
		Report.log(Status.PASS, "Click on Forgot password button.");

		forgotPasswordScreen.ForgotPasswordProcess(userEmail);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");

		generics.pause(2);

		Assert.assertTrue(forgotPasswordScreen.isCheckEmailDisplayed(), "Check Your Email not found!");
		Report.log(Status.PASS, "User is able to access request link and navigate on Check Your Email Screen.");

		generics.pause(2);

		webDriver = new BaseWebDriver().initializeWebDriver(BROWSER_NAME);
		Report.log(Status.PASS, "Open Chrome Browser.");
		verifyResetPasswordPage = new VerifyResetPasswordPO(webDriver);

		verifyResetPasswordPage.verifyResetPasswordLink(user);
		Report.log(Status.PASS, "Verify User Reset Password Link.");

		ArrayList<String> resetPasswordTab = new ArrayList<String>(webDriver.getWindowHandles());
		webDriver.switchTo().window(resetPasswordTab.get(1));

		generics.pause(2);

		String newPassword = "Password1*";
		verifyResetPasswordPage.typeNewPassword(newPassword);

		verifyResetPasswordPage.clickSavePassword();
		Report.log(Status.PASS, "Verify User click Save Password button .");

		generics.pause(2);

		signupScreen.clickBackToSignIn();
		Report.log(Status.PASS, "Click on Back To Sign In button.");

		loginScreen.logIn(userEmail, newPassword);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + USEREMAIL + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + newPassword + "</b>");
		Report.log(Status.PASS, "Click on Sign in button.");
		
		generics.pause(2);

		Assert.assertTrue(forgotPasswordScreen.isTellUsAboutYourselfDisplayed(), "Tell us about yourself not displayed.");
		Report.log(Status.PASS, "User is able to login with new Password successfully.");

	}

	@Test(description = "Verify  User is not able to login to their account with the Old Password.")
	public void testVerifyLoginWithOldPassword() {

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

		loginScreen.clickForgotPassword();
		Report.log(Status.PASS, "Click on Forgot password button.");

		forgotPasswordScreen.ForgotPasswordProcess(userEmail);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");

		generics.pause(3);

		Assert.assertTrue(forgotPasswordScreen.isCheckEmailDisplayed(), "Check Your Email not found!");
		Report.log(Status.PASS, "User is able to access request link and navigate on Check Your Email Screen.");

		generics.pause(2);

		webDriver = new BaseWebDriver().initializeWebDriver(BROWSER_NAME);
		Report.log(Status.PASS, "Open Chrome Browser.");
		verifyResetPasswordPage = new VerifyResetPasswordPO(webDriver);

		verifyResetPasswordPage.verifyResetPasswordLink(user);
		Report.log(Status.PASS, "Verify User Reset Password Link.");

		ArrayList<String> resetPasswordTab = new ArrayList<String>(webDriver.getWindowHandles());
		webDriver.switchTo().window(resetPasswordTab.get(1));

		generics.pause(2);

		String newPassword = "Password1*";
		verifyResetPasswordPage.typeNewPassword(newPassword);

		verifyResetPasswordPage.clickSavePassword();
		Report.log(Status.PASS, "Verify User click Save Password button .");

		generics.pause(2);

		signupScreen.clickBackToSignIn();
		Report.log(Status.PASS, "Click on Back To Sign In button.");

		loginScreen.logIn(USEREMAIL, PASSWORD);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + USEREMAIL + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + PASSWORD + "</b>");
		Report.log(Status.PASS, "Click on Sign in button.");

		generics.pause(2);

		Assert.assertEquals(forgotPasswordScreen.getIncorrectPasswordValidation(),
				"Incorrect Password. Try again or click Forgot password to reset it.");
		Report.log(Status.PASS,
				forgotPasswordScreen.getIncorrectPasswordValidation() + " validation message on screen.");

	}

	@Test(description = "Verify User is getting an error message if the password entered by the user is not secure and strong.")
	public void testVerifyResetPasswordStrongAndSecure() {

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

		loginScreen.clickForgotPassword();
		Report.log(Status.PASS, "Click on Forgot password button.");

		forgotPasswordScreen.ForgotPasswordProcess(userEmail);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");

		generics.pause(2);

		Assert.assertTrue(forgotPasswordScreen.isCheckEmailDisplayed(), "Check Your Email not found!");
		Report.log(Status.PASS, "User is able to access request link and navigate on Check Your Email Screen.");

		generics.pause(2);

		webDriver = new BaseWebDriver().initializeWebDriver(BROWSER_NAME);
		Report.log(Status.PASS, "Open Chrome Browser.");
		verifyResetPasswordPage = new VerifyResetPasswordPO(webDriver);

		verifyResetPasswordPage.verifyResetPasswordLink(user);
		Report.log(Status.PASS, "Verify User Reset Password Link.");

		ArrayList<String> resetPasswordTab = new ArrayList<String>(webDriver.getWindowHandles());
		webDriver.switchTo().window(resetPasswordTab.get(1));

		generics.pause(2);

		String weakPassword = "Pa*";
		verifyResetPasswordPage.typeNewPassword(weakPassword);

		verifyResetPasswordPage.clickSavePassword();
		Report.log(Status.PASS, "Verify User click Save Password button .");

		Assert.assertEquals(verifyResetPasswordPage.getStrongPasswordValidation(),
				"Strong passwords have at least 6 characters and a mix of letters and numbers");
		Report.log(Status.PASS,
				verifyResetPasswordPage.getStrongPasswordValidation() + " validation message on screen.");

	}


	@Test(description = "Verify User is getting an error message if password field empty.")
	public void testVerifyEmptyPasswordField() {

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

		loginScreen.clickForgotPassword();
		Report.log(Status.PASS, "Click on Forgot password button.");

		forgotPasswordScreen.ForgotPasswordProcess(userEmail);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + userEmail + "</b>");

		generics.pause(2);

		Assert.assertTrue(forgotPasswordScreen.isCheckEmailDisplayed(), "Check Your Email not found!");
		Report.log(Status.PASS, "User is able to access request link and navigate on Check Your Email Screen.");

		generics.pause(2);

		webDriver = new BaseWebDriver().initializeWebDriver(BROWSER_NAME);
		Report.log(Status.PASS, "Open Chrome Browser.");
		verifyResetPasswordPage = new VerifyResetPasswordPO(webDriver);

		verifyResetPasswordPage.verifyResetPasswordLink(user);
		Report.log(Status.PASS, "Verify User Reset Password Link.");

		ArrayList<String> resetPasswordTab = new ArrayList<String>(webDriver.getWindowHandles());
		webDriver.switchTo().window(resetPasswordTab.get(1));

		generics.pause(2);

		verifyResetPasswordPage.clickSavePassword();
		Report.log(Status.PASS, "Verify User click Save Password button .");

		generics.pause(2);

		Assert.assertEquals(verifyResetPasswordPage.getEnterPasswordValidation(), "Enter your password");
		Report.log(Status.PASS,
				verifyResetPasswordPage.getEnterPasswordValidation() + " validation message on screen.");

	}
}