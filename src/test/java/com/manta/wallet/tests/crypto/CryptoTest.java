package com.manta.wallet.tests.crypto;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;
import com.manta.framework.utilities.Report;
import com.manta.wallet.pageobjects.biometric.BiometricSO;
import com.manta.wallet.pageobjects.crypto.CryptoSO;
import com.manta.wallet.pageobjects.login.LogInSO;
import com.manta.wallet.pageobjects.phoneno.AddPhoneNumberSO;
import com.manta.wallet.pageobjects.profile.ProfileSO;
import com.manta.wallet.pageobjects.signup.SignUpSO;
import com.manta.wallet.pageobjects.verifyemail.VerifyEmailPO;
import com.manta.wallet.pageobjects.wallet.WalletSO;

public class CryptoTest extends BaseAppDriver {

	SignUpSO signupScreen;
	LogInSO loginScreen;
	ProfileSO profileScreen;
	BiometricSO biometricScreen;
	AddPhoneNumberSO phoneNoScreen;
	VerifyEmailPO verifyEmailPage;
	WalletSO walletScreen;
	CryptoSO cryptoScreen;

	Generics generics;

	@BeforeMethod
	public void setUp() {
		signupScreen = new SignUpSO(appDriver);
		loginScreen = new LogInSO(appDriver);
		walletScreen = new WalletSO(appDriver);
		generics = new Generics(appDriver);
		cryptoScreen = new CryptoSO(appDriver);
		biometricScreen = new BiometricSO(appDriver);
	}

	@Test(description = "Verify user is able to check their Cryptocurrency holdings  details  in Crypto tab.")
	public void testVerifyCryptoPage() {

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

		cryptoScreen.clickCrypto();
		Report.log(Status.PASS, "Click on Crypto button.");
		
		generics.pause(2);

		Assert.assertTrue(cryptoScreen.isCryptoCurrancyDisplayed(), "CryptoCurrancy not displayed.");
		Report.log(Status.PASS, "Verify CryptoCurrancy is visible.");

		Assert.assertTrue(cryptoScreen.isCryptoCurrancyWorthDisplayed(), "CryptoCurrancyWorth not displayed.");
		Report.log(Status.PASS, "Verify CryptoCurrancyWorth is visible.");

		Assert.assertTrue(cryptoScreen.isCryptoCurrancyPriceDisplayed(), "CryptoCurrancyPrice not displayed.");
		Report.log(Status.PASS, "Verify CryptoCurrancyPrice is visible.");

		Assert.assertTrue(cryptoScreen.isCryptoCurrancyRateDisplayed(), "CryptoCurrancyRate not displayed.");
		Report.log(Status.PASS, "Verify CryptoCurrancyRate is visible.");

		Assert.assertTrue(cryptoScreen.isCryptoCurrancyInUSDDisplayed(), "CryptoCurrancyInUSD not displayed.");
		Report.log(Status.PASS, "Verify CryptoCurrancyInUSD is visible.");

	}
}
