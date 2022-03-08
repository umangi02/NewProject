package com.manta.wallet.tests.addfunds;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;
import com.manta.framework.utilities.Report;
import com.manta.wallet.pageobjects.addfunds.AddFundsSO;
import com.manta.wallet.pageobjects.biometric.BiometricSO;
import com.manta.wallet.pageobjects.login.LogInSO;
import com.manta.wallet.pageobjects.phoneno.AddPhoneNumberSO;
import com.manta.wallet.pageobjects.profile.ProfileSO;
import com.manta.wallet.pageobjects.signup.SignUpSO;
import com.manta.wallet.pageobjects.verifyemail.VerifyEmailPO;
import com.manta.wallet.pageobjects.wallet.WalletSO;

public class AddFundsTest extends BaseAppDriver {

	SignUpSO signupScreen;
	LogInSO loginScreen;
	ProfileSO profileScreen;
	BiometricSO biometricScreen;
	AddPhoneNumberSO phoneNoScreen;
	VerifyEmailPO verifyEmailPage;
	WalletSO walletScreen;
	AddFundsSO addFundsScreen;

	Generics generics;
	String userEmail;

	@BeforeMethod
	public void setUp() {
		signupScreen = new SignUpSO(appDriver);
		loginScreen = new LogInSO(appDriver);
		walletScreen = new WalletSO(appDriver);
		generics = new Generics(appDriver);
		biometricScreen = new BiometricSO(appDriver);
		addFundsScreen = new AddFundsSO(appDriver);
	}

	@Test(description = "Verify User able to navigate to the Add Funds screen from anywhere.")
	public void testVerifyNavtigateToAddFundsScreen() {

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

		walletScreen.clickWalletTab();
		Report.log(Status.PASS, "Click on wallet button.");

		generics.pause(2);

		Assert.assertEquals(walletScreen.getWallet(), "Wallet");
		Report.log(Status.PASS, walletScreen.getWallet() + " validation message on wallet screen.");

		generics.pause(2);

		walletScreen.clickAddFunds();
		Report.log(Status.PASS, "Click on Add funds button.");

		generics.pause(2);

		Assert.assertEquals(walletScreen.getAddFunds(), "Add Funds");
		Report.log(Status.PASS, walletScreen.getAddFunds() + " validation message on Add Funds screen.");

		walletScreen.clickSend();
		Report.log(Status.PASS, "Click on send button.");

		generics.pause(2);

		Assert.assertEquals(walletScreen.getSend(), "Send");
		Report.log(Status.PASS, walletScreen.getSend() + " validation message on send screen.");

		generics.pause(2);

		walletScreen.clickAddFunds();
		Report.log(Status.PASS, "Click on Add funds button.");

		generics.pause(2);

		Assert.assertEquals(walletScreen.getAddFunds(), "Add Funds");
		Report.log(Status.PASS, walletScreen.getAddFunds() + " validation message on Add Funds screen.");

		walletScreen.clickSettings();
		Report.log(Status.PASS, "Click on settings button.");

		Assert.assertEquals(walletScreen.getSettings(), "Settings");
		Report.log(Status.PASS, walletScreen.getSettings() + " validation message on setting screen.");

		generics.pause(2);

		walletScreen.clickAddFunds();
		Report.log(Status.PASS, "Click on Add funds button.");

		generics.pause(2);

		Assert.assertEquals(walletScreen.getAddFunds(), "Add Funds");
		Report.log(Status.PASS, walletScreen.getAddFunds() + " validation message on Add Funds screen.");
	}

	@Test(description = "Verify Add Funds screen elements.")
	public void testVerifyAddFundsPage() {

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

		walletScreen.clickAddFunds();
		Report.log(Status.PASS, "Click on Add funds button.");

		generics.pause(2);

		Assert.assertTrue(walletScreen.isAddFundsLabelDisplayed(), "Add Funds not displayed.");
		Report.log(Status.PASS, "Verify Add Funds label is visible.");

		Assert.assertTrue(walletScreen.isNotificationIconDisplayed(), "Notification not displayed.");
		Report.log(Status.PASS, "Verify Notification is visible.");

		Assert.assertTrue(addFundsScreen.isUserNameDisplayed(), "username not displayed.");
		Report.log(Status.PASS, "Verify username is visible.");

		Assert.assertTrue(addFundsScreen.isOTCFundingsDisplayed(), "OTC funding not displayed.");
		Report.log(Status.PASS, "Verify OTC funding is visible.");

		Assert.assertTrue(addFundsScreen.isTurboDepositeDisplayed(), "Turbo Deposite not displayed.");
		Report.log(Status.PASS, "Verify Turbo Deposite is visible.");

		Assert.assertTrue(addFundsScreen.isDespositeCryptoDisplayed(), "Deposite Crypto not displayed.");
		Report.log(Status.PASS, "Verify Deposite Crypto is visible.");

		generics.scrollDown();

		Assert.assertTrue(addFundsScreen.isReciveUsingQRCodeDisplayed(), "Receive using QR Code not displayed.");
		Report.log(Status.PASS, "Verify Receive using QR Code is visible.");

	}

	@Test(description = "Verify User should be able to navigate to OTC Home Screen.")
	public void testVerifyOTCHomeScreen() {

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
		
		walletScreen.clickAddFunds();
		Report.log(Status.PASS, "Click on Add funds button.");


		addFundsScreen.clickOTCHome();
		Report.log(Status.PASS, "Click on OTC Home button.");

		generics.pause(2);

		Assert.assertEquals(addFundsScreen.getBuy(), "Buy");
		Report.log(Status.PASS, addFundsScreen.getBuy() + " validation message on Add Funds screen.");

	}
	
	@Test(description = "Verify User should be able to navigate to OTC Home Screen.")
	public void testVerifyTurboDepositeScreen() {

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
		
		walletScreen.clickAddFunds();
		Report.log(Status.PASS, "Click on Add funds button.");


		addFundsScreen.clickTurboDeposite();
		Report.log(Status.PASS, "Click on Turbo Deposite button.");

		generics.pause(2);

		Assert.assertEquals(addFundsScreen.getSelectCountry(), "Select Currency");
		Report.log(Status.PASS, addFundsScreen.getSelectCountry() + " validation message on Add Funds screen.");

	}

	@Test(description = "Verify User should be able to navigate to OTC Home Screen.")
	public void testVerifyDepositeCryptoScreen() {

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

		walletScreen.clickAddFunds();
		Report.log(Status.PASS, "Click on Add funds button.");

		addFundsScreen.clickDepositeCrypto();
		Report.log(Status.PASS, "Click on Deposite Crypto button.");

		generics.pause(2);

		Assert.assertEquals(addFundsScreen.getDeposite(), "Deposit");
		Report.log(Status.PASS, addFundsScreen.getDeposite() + " validation message on Add Funds screen.");

	}
	
	@Test(description = "Verify User should be able to navigate to OTC Home Screen.")
	public void testVerifyReciveUsingQRCodeScreen() {

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
		
		walletScreen.clickAddFunds();
		Report.log(Status.PASS, "Click on Add funds button.");

		
		generics.scrollDown();

		addFundsScreen.clickReciveQRCode();
		Report.log(Status.PASS, "Click on Recive using QR Code button.");

		generics.pause(2);

		Assert.assertEquals(addFundsScreen.getReceiveMoney(), "Receive Money");
		Report.log(Status.PASS, addFundsScreen.getReceiveMoney() + " validation message on Add Funds screen.");

	}


}