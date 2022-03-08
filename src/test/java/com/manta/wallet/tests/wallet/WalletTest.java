package com.manta.wallet.tests.wallet;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;
import com.manta.framework.utilities.Report;
import com.manta.wallet.pageobjects.biometric.BiometricSO;
import com.manta.wallet.pageobjects.login.LogInSO;
import com.manta.wallet.pageobjects.phoneno.AddPhoneNumberSO;
import com.manta.wallet.pageobjects.profile.ProfileSO;
import com.manta.wallet.pageobjects.signup.SignUpSO;
import com.manta.wallet.pageobjects.verifyemail.VerifyEmailPO;
import com.manta.wallet.pageobjects.wallet.WalletSO;

public class WalletTest extends BaseAppDriver {

	SignUpSO signupScreen;
	LogInSO loginScreen;
	ProfileSO profileScreen;
	BiometricSO biometricScreen;
	AddPhoneNumberSO phoneNoScreen;
	VerifyEmailPO verifyEmailPage;
	WalletSO walletScreen;

	Generics generics;
	String userEmail;

	@BeforeMethod
	public void setUp() {
		signupScreen = new SignUpSO(appDriver);
		loginScreen = new LogInSO(appDriver);
		walletScreen = new WalletSO(appDriver);
		generics = new Generics(appDriver);
		biometricScreen = new BiometricSO(appDriver);
	}

	@Test(description = "Verify user is able to see the total holdings on wallet screen.")
	public void testVerifyTotalHodingsOnWalletScreen() {

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		loginScreen.logIn(USEREMAIL, PASSWORD);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + USEREMAIL + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + PASSWORD + "</b>");
		Report.log(Status.PASS, "User logged in successfully.");

		loginScreen.clickSignIn();
		Report.log(Status.PASS, "Click on Sign in button.");

		generics.pause(3);

		biometricScreen.clickSkipBiometric();
		Report.log(Status.PASS, "Click on Do not show this again Biometric button.");

		generics.pause(2);

		Assert.assertTrue(walletScreen.isUsdCurrancyValueDisplayed(), "USD Value not displayed.");
		Report.log(Status.PASS, "Verify USD Value is visible.");

		generics.pause(4);

		Assert.assertTrue(walletScreen.isUserNativeCurrancyValueDisplayed(), "Native Currancy Value not displayed.");
		Report.log(Status.PASS, "Verify Native Currancy Value is visible.");

		generics.pause(2);

	}

	@Test(description = "Verify user is able to navigate to the Wallet screen from anywhere in the application by clicking on the wallet icon.")
	public void testVerifyNavtigateToWalletScreen() {

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		loginScreen.logIn(USEREMAIL, PASSWORD);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + USEREMAIL + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + PASSWORD + "</b>");
		Report.log(Status.PASS, "User logged in successfully.");

		loginScreen.clickSignIn();
		Report.log(Status.PASS, "Click on Sign in button.");

		generics.pause(4);

		biometricScreen.clickSkipBiometric();
		Report.log(Status.PASS, "Click on Do not show this again Biometric button.");

		generics.pause(2);

		walletScreen.clickSend();
		Report.log(Status.PASS, "Click on send button.");

		generics.pause(2);

		Assert.assertEquals(walletScreen.getSend(), "Send");
		Report.log(Status.PASS, walletScreen.getSend() + " validation message on send screen.");

		generics.pause(2);

		walletScreen.clickWalletTab();
		Report.log(Status.PASS, "Click on wallet button.");

		generics.pause(2);

		Assert.assertEquals(walletScreen.getWallet(), "Wallet");
		Report.log(Status.PASS, walletScreen.getWallet() + " validation message on wallet screen.");

		walletScreen.clickAddFunds();
		Report.log(Status.PASS, "Click on Add funds button.");

		generics.pause(2);

		Assert.assertEquals(walletScreen.getAddFunds(), "Add Funds");
		Report.log(Status.PASS, walletScreen.getAddFunds() + " validation message on Add Funds screen.");

		walletScreen.clickWalletTab();
		Report.log(Status.PASS, "Click on wallet button.");

		generics.pause(2);

		Assert.assertEquals(walletScreen.getWallet(), "Wallet");
		Report.log(Status.PASS, walletScreen.getWallet() + " validation message on wallet screen.");

		walletScreen.clickSettings();
		Report.log(Status.PASS, "Click on settings button.");

		Assert.assertEquals(walletScreen.getSettings(), "Settings");
		Report.log(Status.PASS, walletScreen.getSettings() + " validation message on setting screen.");

		walletScreen.clickWalletTab();
		Report.log(Status.PASS, "Click on wallet button.");

		generics.pause(4);

		Assert.assertEquals(walletScreen.getWallet(), "Wallet");
		Report.log(Status.PASS, walletScreen.getWallet() + " validation message on wallet screen.");

	}

	@Test(description = "Verify wallet screen elements.")
	public void testVerifyWalletPage() {

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		loginScreen.logIn(USEREMAIL, PASSWORD);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + USEREMAIL + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + PASSWORD + "</b>");
		Report.log(Status.PASS, "User logged in successfully.");

		loginScreen.clickSignIn();
		Report.log(Status.PASS, "Click on Sign in button.");

		generics.pause(2);

		biometricScreen.clickSkipBiometric();
		Report.log(Status.PASS, "Click on Do not show this again Biometric button.");

		generics.pause(2);

		Assert.assertTrue(walletScreen.isWalletDisplayed(), "Wallet not displayed.");
		Report.log(Status.PASS, "Verify Wallet screen is visible.");
		Assert.assertTrue(walletScreen.isNotificationIconDisplayed(), "Notification not displayed.");
		Report.log(Status.PASS, "Verify Notification is visible.");
		Assert.assertTrue(walletScreen.isEyeIconDisplayed(), "Eye not displayed.");
		Report.log(Status.PASS, "Verify Eye  is visible.");

		generics.pause(2);
		Assert.assertTrue(walletScreen.isUsdCurrancyValueDisplayed(), "USD Value not displayed.");
		Report.log(Status.PASS, "Verify USD Value is visible.");
		generics.pause(2);
		Assert.assertTrue(walletScreen.isUserNativeCurrancyValueDisplayed(), "Native Currancy Value not displayed.");
		Report.log(Status.PASS, "Verify Native Currancy Value is visible.");
		generics.pause(2);
		Assert.assertTrue(walletScreen.isBuyingPowerDisplayed(), "Buying Power not displayed.");
		Report.log(Status.PASS, "Verify Buying Power is visible.");

		Assert.assertTrue(walletScreen.isCashDisplayed(), "Cash not displayed.");
		Report.log(Status.PASS, "Verify Cash is visible.");
		Assert.assertTrue(walletScreen.isCryptoDisplayed(), "Crypto not displayed.");
		Report.log(Status.PASS, "Verify Crypto is visible.");
		Assert.assertTrue(walletScreen.isGoldDisplayed(), "Gold not displayed.");
		Report.log(Status.PASS, "Verify Gold is visible.");

		generics.pause(4);
		Assert.assertTrue(walletScreen.isWalletTabButtonDisplayed(), "Wallet not displayed.");
		Report.log(Status.PASS, "Verify Wallet is visible.");

		generics.pause(2);
		Assert.assertTrue(walletScreen.isSendDisplayed(), "Send not displayed.");
		Report.log(Status.PASS, "Verify Send is visible.");

		generics.pause(4);

		Assert.assertTrue(walletScreen.isAddFundsDisplayed(), "Add Funds not displayed.");
		Report.log(Status.PASS, "Verify Add Funds is visible.");

		generics.pause(4);
		Assert.assertTrue(walletScreen.isSettingsDisplayed(), "Settings not displayed.");
		Report.log(Status.PASS, "Verify Settings is visible.");

	}

	@Test(description = "Verify user is able to hide or show Total Holdings and Buying Power by clicking on the eye icon in Wallet screen.")
	public void testVerifyUserHideAndShowHoldings() {

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		loginScreen.logIn(USEREMAIL, PASSWORD);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + USEREMAIL + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + PASSWORD + "</b>");
		Report.log(Status.PASS, "User logged in successfully.");

		loginScreen.clickSignIn();
		Report.log(Status.PASS, "Click on Sign in button.");

		generics.pause(2);

		biometricScreen.clickSkipBiometric();
		Report.log(Status.PASS, "Click on Do not show this again Biometric button.");

		generics.pause(2);

		Assert.assertTrue(walletScreen.isWalletDisplayed(), "Wallet not displayed.");
		Report.log(Status.PASS, "Verify Wallet is visible.");

		walletScreen.clickShowPasword();
		Assert.assertEquals(walletScreen.isHidePasswordShown(), "false");
		Report.log(Status.PASS, "Click on show password button.");

	}

	@Test(description = "Verify user is able to see buying power info by clicking on buying power button.")
	public void testVerifySeeBuyingPowerInfomation() {

		signupScreen.clickGetStarted();
		Report.log(Status.PASS, "Click on Get Started button.");

		loginScreen.logIn(USEREMAIL, PASSWORD);
		Report.log(Status.INFO, "<b>Data Entered:</b>");
		Report.log(Status.INFO, "Email: " + "<b>" + USEREMAIL + "</b>");
		Report.log(Status.INFO, "Password: " + "<b>" + PASSWORD + "</b>");
		Report.log(Status.PASS, "User logged in successfully.");

		loginScreen.clickSignIn();
		Report.log(Status.PASS, "Click on Sign in button.");

		generics.pause(2);

		biometricScreen.clickSkipBiometric();
		Report.log(Status.PASS, "Click on Do not show this again Biometric button.");

		generics.pause(4);

		walletScreen.clickBuyingPower();
		Report.log(Status.PASS, "Click on Buying Power button.");

		Assert.assertTrue(walletScreen.isBuyinPowerInformationDisplayed(), "Buying Power not displayed.");
		Report.log(Status.PASS, "Verify Buying Power is visible.");

	}

}