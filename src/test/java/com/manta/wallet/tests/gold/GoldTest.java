package com.manta.wallet.tests.gold;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;
import com.manta.framework.utilities.Report;
import com.manta.wallet.pageobjects.biometric.BiometricSO;
import com.manta.wallet.pageobjects.crypto.CryptoSO;
import com.manta.wallet.pageobjects.gold.GoldSO;
import com.manta.wallet.pageobjects.login.LogInSO;
import com.manta.wallet.pageobjects.phoneno.AddPhoneNumberSO;
import com.manta.wallet.pageobjects.profile.ProfileSO;
import com.manta.wallet.pageobjects.signup.SignUpSO;
import com.manta.wallet.pageobjects.verifyemail.VerifyEmailPO;
import com.manta.wallet.pageobjects.wallet.WalletSO;

public class GoldTest extends BaseAppDriver {

	SignUpSO signupScreen;
	LogInSO loginScreen;
	ProfileSO profileScreen;
	BiometricSO biometricScreen;
	AddPhoneNumberSO phoneNoScreen;
	VerifyEmailPO verifyEmailPage;
	WalletSO walletScreen;
	CryptoSO cryptoScreen;
	GoldSO goldScreen;

	Generics generics;

	@BeforeMethod
	public void setUp() {
		signupScreen = new SignUpSO(appDriver);
		loginScreen = new LogInSO(appDriver);
		walletScreen = new WalletSO(appDriver);
		generics = new Generics(appDriver);
		goldScreen = new GoldSO(appDriver);
		biometricScreen = new BiometricSO(appDriver);
	}

	@Test(description = " Verify user is able to check their Cryptocurrency holdings  details  in Gold tab.")
	public void testVerifyGolddScreen() {

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


		goldScreen.clickGold();
		Report.log(Status.PASS, "Click on Gold button.");

		Assert.assertTrue(goldScreen.isGoldUSDBalancecyDisplayed(), "Gold USD Balance not displayed.");
		Report.log(Status.PASS, "Verify Gold USD Balance is visible.");

		Assert.assertTrue(goldScreen.isCashNativeBalncehDisplayed(), "Gold Native Balance not displayed.");
		Report.log(Status.PASS, "Verify Gold Native Balance is visible.");

		Assert.assertTrue(goldScreen.isCashPercentageDisplayed(), "Gold Percentage not displayed.");
		Report.log(Status.PASS, "Verify Gold Percentage is visible.");

	
	}

}
