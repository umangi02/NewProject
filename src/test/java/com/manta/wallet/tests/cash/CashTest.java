package com.manta.wallet.tests.cash;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;
import com.manta.framework.utilities.Report;
import com.manta.wallet.pageobjects.biometric.BiometricSO;
import com.manta.wallet.pageobjects.cash.CashSO;
import com.manta.wallet.pageobjects.crypto.CryptoSO;
import com.manta.wallet.pageobjects.login.LogInSO;
import com.manta.wallet.pageobjects.phoneno.AddPhoneNumberSO;
import com.manta.wallet.pageobjects.profile.ProfileSO;
import com.manta.wallet.pageobjects.signup.SignUpSO;
import com.manta.wallet.pageobjects.verifyemail.VerifyEmailPO;
import com.manta.wallet.pageobjects.wallet.WalletSO;

public class CashTest extends BaseAppDriver {

	SignUpSO signupScreen;
	LogInSO loginScreen;
	ProfileSO profileScreen;
	BiometricSO biometricScreen;
	AddPhoneNumberSO phoneNoScreen;
	VerifyEmailPO verifyEmailPage;
	WalletSO walletScreen;
	CryptoSO cryptoScreen;
	CashSO cashScreen;

	Generics generics;

	@BeforeMethod
	public void setUp() {
		signupScreen = new SignUpSO(appDriver);
		loginScreen = new LogInSO(appDriver);
		walletScreen = new WalletSO(appDriver);
		generics = new Generics(appDriver);
		cashScreen = new CashSO(appDriver);
		biometricScreen = new BiometricSO(appDriver);
	}

	@Test(description = "Verify user is able to see their Crytptocurrancy holdings deatils in Cash Tab.")
	public void testVerifyCashScreen() {

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

		cashScreen.clickCash();
		Report.log(Status.PASS, "Click on Cash button.");

		generics.pause(2);

		Assert.assertTrue(cashScreen.isCashUSDBalancecyDisplayed(), "Cash USD Balance not displayed.");
		Report.log(Status.PASS, "Verify Cash USD Balance is visible.");

		Assert.assertTrue(cashScreen.isCashNativeBalncehDisplayed(), "Cash Native Balnce not displayed.");
		Report.log(Status.PASS, "Verify Cash Native Balnce  is visible.");

		Assert.assertTrue(cashScreen.isCashExchangeRateDisplayed(), "Cash Exchange Rate not displayed.");
		Report.log(Status.PASS, "Verify Cash Exchange Rate is visible.");

	}

}
