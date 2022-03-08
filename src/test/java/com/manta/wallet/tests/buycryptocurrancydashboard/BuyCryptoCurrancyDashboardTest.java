package com.manta.wallet.tests.buycryptocurrancydashboard;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;
import com.manta.framework.utilities.Report;
import com.manta.wallet.pageobjects.addfunds.AddFundsSO;
import com.manta.wallet.pageobjects.biometric.BiometricSO;
import com.manta.wallet.pageobjects.buycryptocurrancyDashbord.BuyCryptoCurrancyDashbordSO;
import com.manta.wallet.pageobjects.crypto.CryptoSO;
import com.manta.wallet.pageobjects.login.LogInSO;
import com.manta.wallet.pageobjects.phoneno.AddPhoneNumberSO;
import com.manta.wallet.pageobjects.profile.ProfileSO;
import com.manta.wallet.pageobjects.signup.SignUpSO;
import com.manta.wallet.pageobjects.verifyemail.VerifyEmailPO;
import com.manta.wallet.pageobjects.wallet.WalletSO;

public class BuyCryptoCurrancyDashboardTest extends BaseAppDriver {

	SignUpSO signupScreen;
	LogInSO loginScreen;
	ProfileSO profileScreen;
	BiometricSO biometricScreen;
	AddPhoneNumberSO phoneNoScreen;
	VerifyEmailPO verifyEmailPage;
	WalletSO walletScreen;
	BuyCryptoCurrancyDashbordSO buyCryptoCurrancyDashboardScreen;
	CryptoSO cryptoScreen;
	AddFundsSO addFundsScreen;

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
		buyCryptoCurrancyDashboardScreen = new BuyCryptoCurrancyDashbordSO(appDriver);
		cryptoScreen = new CryptoSO(appDriver);
		addFundsScreen = new AddFundsSO(appDriver);
		generics = new Generics(appDriver);
	}

	@Test(description = "Verify user should be able to navigate different Crypto Currency screen.")
	public void testVerifyUserNavigateCryptoCurrancyScreen() {

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

		walletScreen.clickCryptoLabel();
		Report.log(Status.PASS, "Click on crypto label.");

		generics.pause(2);

		cryptoScreen.clickCryptoIcon();
		Report.log(Status.PASS, "Click on crypto icon.");

		buyCryptoCurrancyDashboardScreen.clickBitcoin();
		Report.log(Status.PASS, "Click on Bitcoin");

		buyCryptoCurrancyDashboardScreen.clickEthereum();
		Report.log(Status.PASS, "Click on Ethereum");

		buyCryptoCurrancyDashboardScreen.clickSolana();
		Report.log(Status.PASS, "Click on Solana");

		buyCryptoCurrancyDashboardScreen.clickDoge();
		Report.log(Status.PASS, "Click on Doge");

		buyCryptoCurrancyDashboardScreen.clickLiteCoin();
		Report.log(Status.PASS, "Click on LiteCoin");

		buyCryptoCurrancyDashboardScreen.clickFTX();
		Report.log(Status.PASS, "Click on FTX");

		buyCryptoCurrancyDashboardScreen.clickChainLink();
		Report.log(Status.PASS, "Click on ChainLink");

		buyCryptoCurrancyDashboardScreen.clickPolygon();
		Report.log(Status.PASS, "Click on Polygon");

		buyCryptoCurrancyDashboardScreen.clickAave();
		Report.log(Status.PASS, "Click on Aave");

		buyCryptoCurrancyDashboardScreen.clickTron();
		Report.log(Status.PASS, "Click on Tron");

		buyCryptoCurrancyDashboardScreen.clickThronChain();
		Report.log(Status.PASS, "Click on ThronChain");

	}

	@Test(description = "Verify user should be able to select specific activity.")
	public void testVerifyUserSelectActivity() {

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

		walletScreen.clickCryptoLabel();
		Report.log(Status.PASS, "Click on crypto label.");

		generics.pause(2);

		cryptoScreen.clickCryptoIcon();
		Report.log(Status.PASS, "Click on crypto icon.");

		buyCryptoCurrancyDashboardScreen.clickBitcoin();
		Report.log(Status.PASS, "Click on Bitcoin");

		buyCryptoCurrancyDashboardScreen.clickShowActivity();
		Report.log(Status.PASS, "Click on show activity");

		buyCryptoCurrancyDashboardScreen.clickAll();
		Report.log(Status.PASS, "Click on Bitcoin");

		generics.pause(2);

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isBoughtDisplayed(), "All activity not displayed.");
		Report.log(Status.PASS, "Verify All activity is visible.");

		buyCryptoCurrancyDashboardScreen.clickShowActivity();
		Report.log(Status.PASS, "Click on show activity");

		buyCryptoCurrancyDashboardScreen.clickBuyCheckBox();
		Report.log(Status.PASS, "Click on Buy");

		generics.pause(2);

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isBoughtDisplayed(), "All activity not displayed.");
		Report.log(Status.PASS, "Verify All activity is visible.");

		buyCryptoCurrancyDashboardScreen.clickShowActivity();
		Report.log(Status.PASS, "Click on show activity");

		buyCryptoCurrancyDashboardScreen.clickSellCheckBox();
		Report.log(Status.PASS, "Click on Sell");

		generics.pause(2);

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isSoldDisplayed(), "Sold not displayed.");
		Report.log(Status.PASS, "Verify Sold is visible.");

		buyCryptoCurrancyDashboardScreen.clickShowActivity();
		Report.log(Status.PASS, "Click on show activity");

		buyCryptoCurrancyDashboardScreen.clickDeposite();
		Report.log(Status.PASS, "Click on Deposite");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isReceiveDisplayed(), "Receive not displayed.");
		Report.log(Status.PASS, "Verify Receive is visible.");

		buyCryptoCurrancyDashboardScreen.clickShowActivity();
		Report.log(Status.PASS, "Click on show activity");

	}

	@Test(description = "Verify crypto bitcoin screen elements.")
	public void testVerifyCryptoBitcoinScreen() {

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

		walletScreen.clickCryptoLabel();
		Report.log(Status.PASS, "Click on crypto label.");

		generics.pause(3);

		cryptoScreen.clickCryptoIcon();
		Report.log(Status.PASS, "Click on crypto icon.");

		generics.pause(2);

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isBackArrowDisplayed(), "Arrow not displayed.");
		Report.log(Status.PASS, "Verify Arrow is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isAvailableBalanceDisplayed(), "Balance not displayed.");
		Report.log(Status.PASS, "Verify Arrow is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isCryptoCodeTYextDisplayed(), "Crypto code not displayed.");
		Report.log(Status.PASS, "Verify Crypto code is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isCryptoPriceDisplayed(), "Crypto Price not displayed.");
		Report.log(Status.PASS, "Verify Crypto Price is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isCryptoPercentageDisplayed(),
				"Crypto Percentage not displayed.");
		Report.log(Status.PASS, "Verify Crypto Percentage is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isTotalCryptoPriceDisplayed(),
				"Total Crypto Price not displayed.");
		Report.log(Status.PASS, "Verify Total Crypto Price is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isCurrentCryptoPriceDisplayed(),
				"Current Crypto Price not displayed.");
		Report.log(Status.PASS, "Verify Current Crypto Price is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isReceiveDisplayed(), "Receive not displayed.");
		Report.log(Status.PASS, "Verify Receive is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isViewChartDispalyed(), "View Chart not displayed.");
		Report.log(Status.PASS, "Verify View Chart is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isShowActivityDisplayed(), "Show Activity not displayed.");
		Report.log(Status.PASS, "Verify Show Activity is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isBuyButtonDisplayed(), "Buy Button not displayed.");
		Report.log(Status.PASS, "Verify Buy Button is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isSellButtonDisplayed(), "Sell Button not displayed.");
		Report.log(Status.PASS, "Verify Sell Button is visible.");

	}

	@Test(description = "Verify user should be able to navigate deposit screen by clicking receive button.")
	public void testVerifyNavigateDepositeScreen() {

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

		walletScreen.clickCryptoLabel();
		Report.log(Status.PASS, "Click on crypto label.");

		generics.pause(3);

		cryptoScreen.clickCryptoIcon();
		Report.log(Status.PASS, "Click on crypto icon.");

		generics.pause(2);

		buyCryptoCurrancyDashboardScreen.clickReceive();
		Report.log(Status.PASS, "Click on Receive.");

		Assert.assertEquals(addFundsScreen.getDeposite(), "Deposit");
		Report.log(Status.PASS, addFundsScreen.getDeposite() + " validation message on Add Funds screen.");

	}

	@Test(description = "Verify user should be able to navigate chart screen by clicking view chart button in the colored card. ")
	public void testVerifyNavigateChartScreen() {

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

		walletScreen.clickCryptoLabel();
		Report.log(Status.PASS, "Click on crypto label.");

		generics.pause(3);

		cryptoScreen.clickCryptoIcon();
		Report.log(Status.PASS, "Click on crypto icon.");

		generics.pause(2);

		buyCryptoCurrancyDashboardScreen.clickViewChart();
		Report.log(Status.PASS, "Click on View chart.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isChartDisplayed(), "Line Chart not displayed.");
		Report.log(Status.PASS, "Verify Line Chart is visible.");

	}

	@Test(description = "User should be able to scroll down and check all their past transactions and activities in the Cryptocurrency Screen.")
	public void testVerifyScrollDownCryptoCurrancyScreen() {

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

		walletScreen.clickCryptoLabel();
		Report.log(Status.PASS, "Click on crypto label.");

		generics.pause(3);

		cryptoScreen.clickCryptoIcon();
		Report.log(Status.PASS, "Click on crypto icon.");

		generics.pause(2);

		generics.scrollDown();

	}

	@Test(description = "User should be able to check the activity, date, time, amount of Cryptocurrency, cost of the Cryptocurrency in the transaction cards.")
	public void testVerifyTransactionCard() {

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

		walletScreen.clickCryptoLabel();
		Report.log(Status.PASS, "Click on crypto label.");

		generics.pause(3);

		cryptoScreen.clickCryptoIcon();
		Report.log(Status.PASS, "Click on crypto icon.");

		generics.pause(6);

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isUpDownDisplayed(), "Up down not displayed.");
		Report.log(Status.PASS, "Verify Up down is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isCryptoActivityDisplayed(),
				"Crypto Activity not displayed.");
		Report.log(Status.PASS, "Verify Crypto Activity is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isCryptoDateAndTimeDisplayed(),
				"Date And Time not displayed.");
		Report.log(Status.PASS, "Verify Date And Time is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isCryptoTvValueDisplayed(), "Crypto Value not displayed.");
		Report.log(Status.PASS, "Verify Crypto Value is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isCryptoTvRealValueDisplayed(),
				"Crypto USD Value not displayed.");
		Report.log(Status.PASS, "Verify Crypto USD Value is visible.");

	}

	@Test(description = "Verify user should be able to navigate buy screen by clicking Buy button.")
	public void testVerifyNavigateBuyCryptoCurrancyScreen() {

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

		walletScreen.clickCryptoLabel();
		Report.log(Status.PASS, "Click on crypto label.");

		generics.pause(3);

		cryptoScreen.clickCryptoIcon();
		Report.log(Status.PASS, "Click on crypto icon.");

		generics.pause(2);

		buyCryptoCurrancyDashboardScreen.clickBuy();
		Report.log(Status.PASS, "Click on Buy Button.");

		Assert.assertEquals(buyCryptoCurrancyDashboardScreen.getBuy(), "Buy");
		Report.log(Status.PASS, addFundsScreen.getBuy() + " validation message on Buy Crypto Currancy screen.");

	}

	@Test(description = "Verify user should be able to navigate Sell screen by clicking sell button.")
	public void testVerifyNavigateSellCryptoCurrancyScreen() {

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

		walletScreen.clickCryptoLabel();
		Report.log(Status.PASS, "Click on crypto label.");

		generics.pause(3);

		cryptoScreen.clickCryptoIcon();
		Report.log(Status.PASS, "Click on crypto icon.");

		generics.pause(2);

		buyCryptoCurrancyDashboardScreen.clickSell();
		Report.log(Status.PASS, "Click on Sell Button.");

		Assert.assertEquals(buyCryptoCurrancyDashboardScreen.getSell(), "Sell");
		Report.log(Status.PASS,
				buyCryptoCurrancyDashboardScreen.getSell() + " validation message on Sell Crypto Currancy screen.");

	}

	@Test(description = "Verify Buy crypto currancy bitcoin screen elements.")
	public void testVerifyBuyCryptoCurrancy() {

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

		walletScreen.clickCryptoLabel();
		Report.log(Status.PASS, "Click on crypto label.");

		generics.pause(3);

		cryptoScreen.clickCryptoIcon();
		Report.log(Status.PASS, "Click on crypto icon.");

		generics.pause(2);

		buyCryptoCurrancyDashboardScreen.clickBuy();
		Report.log(Status.PASS, "Click on Buy Button.");

		Assert.assertEquals(buyCryptoCurrancyDashboardScreen.getBuy(), "Buy");
		Report.log(Status.PASS, addFundsScreen.getBuy() + " validation message on Buy Crypto Currancy screen.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isBackArrowDisplayed(), "Wallet not displayed.");
		Report.log(Status.PASS, "Verify Wallet is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isBuyDisplayed(), "Wallet not displayed.");
		Report.log(Status.PASS, "Verify Wallet is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isMaxDisplayed(), "Wallet not displayed.");
		Report.log(Status.PASS, "Verify Wallet is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isExchangeDisplayed(), "Wallet not displayed.");
		Report.log(Status.PASS, "Verify Wallet is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isGreenDotDisplayed(), "Wallet not displayed.");
		Report.log(Status.PASS, "Verify Wallet is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isKeyBoardDisplayed(), "Wallet not displayed.");
		Report.log(Status.PASS, "Verify Wallet is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isBuyingPowerDisplayed(), "Wallet not displayed.");
		Report.log(Status.PASS, "Verify Wallet is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isPriceOfCryptoInUSDDisplayed(), "Wallet not displayed.");
		Report.log(Status.PASS, "Verify Wallet is visible.");
		

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isTextFieldToEntyerAmountDisplayed(),
				"Wallet not displayed.");
		Report.log(Status.PASS, "Verify Wallet is visible.");

		Assert.assertTrue(buyCryptoCurrancyDashboardScreen.isCurrancyConversionValueDisplayed(),
				"Wallet not displayed.");
		Report.log(Status.PASS, "Verify Wallet is visible.");

	}

}