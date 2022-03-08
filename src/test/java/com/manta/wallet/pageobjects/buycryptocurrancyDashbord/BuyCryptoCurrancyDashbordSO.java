package com.manta.wallet.pageobjects.buycryptocurrancyDashbord;

import org.openqa.selenium.By;

import com.manta.framework.common.Generics;
import com.manta.framework.drivermanager.BaseAppDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BuyCryptoCurrancyDashbordSO extends BaseAppDriver {
	AndroidDriver<MobileElement> appDriver;
	Generics generics;

	public BuyCryptoCurrancyDashbordSO(AndroidDriver<MobileElement> appDriver) {
		this.appDriver = appDriver;
		generics = new Generics(appDriver);
	}

	By backArrowIcon = new By.ById(APP_PACKAGE + ":id/toolbar_backarrow");
	By bitcoinCurrancyLabel = new By.ByXPath(
			"//android.widget.LinearLayout[@content-desc=\"Bitcoin\"]/android.widget.TextView");
	By ethereumCurancyLabel = new By.ByXPath(
			"//android.widget.LinearLayout[@content-desc=\"Ethereum\"]/android.widget.TextView");
	By solanaCurrancyLabel = new By.ByXPath(
			"//android.widget.LinearLayout[@content-desc=\"Solana\"]/android.widget.TextView");
	By dogeCurrancyLabel = new By.ByXPath(
			"//android.widget.LinearLayout[@content-desc=\"Doge\"]/android.widget.TextView");
	By liteCoinCurrancyLabel = new By.ByXPath(
			"//android.widget.LinearLayout[@content-desc=\"LiteCoin\"]/android.widget.TextView");
	By ftxCurrancyLabel = new By.ByXPath(
			"//android.widget.LinearLayout[@content-desc=\"FTX Token\"]/android.widget.TextView");
	By chainLinkCurrancyLabel = new By.ByXPath(
			"//android.widget.LinearLayout[@content-desc=\"Chainlink\"]/android.widget.TextView");
	By polygonCurrancyLabel = new By.ByXPath(
			"//android.widget.LinearLayout[@content-desc=\"Polygon\"]/android.widget.TextView");
	By aaveCurrancyLabel = new By.ByXPath(
			"//android.widget.LinearLayout[@content-desc=\"Aave\"]/android.widget.TextView");
	By tronCurrancyLabel = new By.ByXPath(
			"//android.widget.LinearLayout[@content-desc=\"TRON\"]/android.widget.TextView");
	By thorChainCurrancyLabel = new By.ByXPath(
			"//android.widget.LinearLayout[@content-desc=\"THORChain\"]/android.widget.TextView");
	By cryptoNameText = new By.ById(APP_PACKAGE + ":id/cryptoNameTV");
	By cryptoCodeText = new By.ById(APP_PACKAGE + ":id/cryptoCodeTV");
	By cryptoPrice = new By.ById(APP_PACKAGE + ":id/priceTV");
	By cryptoPercentage = new By.ById(APP_PACKAGE + ":id/percent_ll");
	By totalCryptoPrice = new By.ById(APP_PACKAGE + ":id/tv_balance_coin");
	By currentCryptoPrice = new By.ById(APP_PACKAGE + ":id/tv_current_price");
	By reciveButton = new By.ById(APP_PACKAGE + ":id/receiveBtn");
	By viewChartButton = new By.ById(APP_PACKAGE + ":id/staBtn");
	By buyButton = new By.ById(APP_PACKAGE + ":id/buyBtn");
	By sellButton = new By.ById(APP_PACKAGE + ":id/sellBtn");
	By showActivityMenu = new By.ById(APP_PACKAGE + ":id/filter_actvity_textview");
	By boughtText = new By.ByXPath("//android.widget.TextView[contains(@text,'Bought')]");
	By soldText = new By.ByXPath("//android.widget.TextView[contains(@text,'Sold')]");
	By receivedText = new By.ByXPath("//android.widget.TextView[contains(@text,'Receive')]");
	By allCheckBox = new By.ByXPath("//android.widget.TextView[contains(@text,'All')]");
	By buyCheckBox = new By.ByXPath("//android.widget.TextView[contains(@text,'Buy')]");
	By sellChdeckBox = new By.ByXPath("//android.widget.TextView[contains(@text,'Sell')]");
	By depositeCheckBox = new By.ByXPath("//android.widget.TextView[contains(@text,'Deposit')]");

	By buyLabel = new By.ById(APP_PACKAGE + ":id/tv_title");
	By maxButton = new By.ById(APP_PACKAGE + ":id/iv_curr1");
	By exchangeButton = new By.ById(APP_PACKAGE + ":id/iv_curr");
	By greenDot = new By.ById(APP_PACKAGE + ":id/animationView");
	By keyBoard = new By.ById(APP_PACKAGE + ":id/keyboard");
	By buyingPower = new By.ById(APP_PACKAGE + ":id/balanceCL");
	By PriceOfCryptoInUSD = new By.ById(APP_PACKAGE + ":id/curr_crypto_tv");
	By textFieldToEnterAmountOfCurrancy = new By.ById(APP_PACKAGE + ":id/curr_dollar_tv");
	By currancyConvertionValue = new By.ById(APP_PACKAGE + ":id/tv_conversion");

	By confirmationLabel = new By.ById(APP_PACKAGE + ":id/toolbar_title");
	By curancyIcon = new By.ById(APP_PACKAGE + ":id/currency_icon");
	By amountOfCryptoToBuy = new By.ById(APP_PACKAGE + ":id/curr_tv");
	By currancyType = new By.ById(APP_PACKAGE + ":id/curr_type_tv");
	By buyCryptoCurrancyInUSD = new By.ById(APP_PACKAGE + ":id/currency_icon");
	By timeForUpdatePrice = new By.ById(APP_PACKAGE + "expire_textview");
	By feeChargeInUSD = new By.ById(APP_PACKAGE + ":id/tv_fees");
	By usdBalanceAfterPayment = new By.ById(APP_PACKAGE + ":id/tv_balance");
	By slideToBuyButton = new By.ById(APP_PACKAGE + ":id/sliding_button");

	By successIcon = new By.ById(APP_PACKAGE + ":id/iv_success");
	By purchaseText = new By.ById(APP_PACKAGE + ":id/purchase_txt");
	By amountText = new By.ById(APP_PACKAGE + ":id/amount_txt");
	By usdAmountText = new By.ById(APP_PACKAGE + ":id/usd_amount_txt");
	By transactionIdText = new By.ById(APP_PACKAGE + ":id/txidLabel");
	By hsjksks = new By.ById(APP_PACKAGE + ":id/tv_txid");
	By ViewReceiptButton = new By.ById(APP_PACKAGE + ":id/download_btn");

	By receiptLabel = new By.ById(APP_PACKAGE + ":id/tv_otc_buy_title");
	By cryptoCurrancyIcon = new By.ById(APP_PACKAGE + ":id/crypto_currency_icon");
	By buyDetailsLabel = new By.ById(APP_PACKAGE + ":id/tv_details");
	By textLabel = new By.ById(APP_PACKAGE + ":id/tv_desc");
	By confirmedLabel = new By.ById(APP_PACKAGE + ":id/stateTV");
	By typeText = new By.ById(APP_PACKAGE + ":id/tv_buy_type");
	By purchasedText = new By.ById(APP_PACKAGE + ":id/tv_purchased");
	By usdValueText = new By.ById(APP_PACKAGE + ":id/tv_usd_value");
	By conversionRateText = new By.ById(APP_PACKAGE + ":id/tv_conversion");
	By tradeIDText = new By.ById(APP_PACKAGE + ":id/tv_trade_id");
	By dateAndTimeText = new By.ById(APP_PACKAGE + ":id/tv_date_n_time");
	By paymentMethodText = new By.ById(APP_PACKAGE + ":id/tv_payment_method");
	By lineChartText = new By.ById(APP_PACKAGE + ":id/linechart");

	By upDownArrow = new By.ByXPath("(//android.widget.ImageView[@content-desc=\"Image\"])[6]");
	By statusLabel = new By.ById(APP_PACKAGE + ":id/tv_status");
	By dateAndTime = new By.ById(APP_PACKAGE + ":id/tv_date");
	By tvValue = new By.ById(APP_PACKAGE + ":id/tv_value");
	By tvRealValue = new By.ById(APP_PACKAGE + ":id/tv_value_2");
	By sellLabel = new By.ById(APP_PACKAGE+":id/tv_title");

	public void clickBackArrow() {
		appDriver.findElement(backArrowIcon).click();
	}

	public void clickBitcoin() {
		appDriver.findElement(bitcoinCurrancyLabel).click();
	}

	public void clickEthereum() {
		appDriver.findElement(ethereumCurancyLabel).click();
	}

	public void clickSolana() {
		appDriver.findElement(solanaCurrancyLabel).click();
	}

	public void clickDoge() {
		appDriver.findElement(dogeCurrancyLabel).click();
	}

	public void clickLiteCoin() {
		appDriver.findElement(liteCoinCurrancyLabel).click();
	}

	public void clickFTX() {
		appDriver.findElement(ftxCurrancyLabel).click();
	}

	public void clickChainLink() {
		appDriver.findElement(chainLinkCurrancyLabel).click();
	}

	public void clickPolygon() {
		appDriver.findElement(polygonCurrancyLabel).click();
	}

	public void clickAave() {
		appDriver.findElement(aaveCurrancyLabel).click();
	}

	public void clickTron() {
		appDriver.findElement(tronCurrancyLabel).click();
	}

	public void clickThronChain() {
		appDriver.findElement(thorChainCurrancyLabel).click();
	}

	public void clickReceive() {
		appDriver.findElement(reciveButton).click();
	}

	public void clickViewChart() {
		appDriver.findElement(viewChartButton).click();
	}

	public void clickBuy() {
		appDriver.findElement(buyButton).click();
	}

	public void clickSell() {
		appDriver.findElement(sellButton).click();
	}

	public void clickShowActivity() {
		appDriver.findElement(showActivityMenu).click();
	}

	public void clickAll() {
		appDriver.findElement(allCheckBox).click();
	}

	public void clickBuyCheckBox() {
		appDriver.findElement(buyCheckBox).click();
	}

	public void clickSellCheckBox() {
		appDriver.findElement(sellChdeckBox).click();
	}

	public void clickDeposite() {
		appDriver.findElement(depositeCheckBox).click();
	}

	public void clickMax() {
		appDriver.findElement(maxButton).click();
	}

	public void clickEchange() {
		appDriver.findElement(exchangeButton).click();
	}

	public void clickkeyBoard() {
		appDriver.findElement(keyBoard).click();
	}

	public void clickSlideToBuy() {
		appDriver.findElement(slideToBuyButton).click();
	}

	public void clickViewReceipt() {
		appDriver.findElement(ViewReceiptButton).click();
	}

	public boolean isAvailableBalanceDisplayed() {
		return generics.isElementPresent(cryptoNameText);
	}

	public boolean isCryptoCodeTYextDisplayed() {
		return generics.isElementPresent(cryptoCodeText);
	}

	public boolean isCryptoPriceDisplayed() {
		return generics.isElementPresent(cryptoPrice);
	}

	public boolean isCryptoPercentageDisplayed() {
		return generics.isElementPresent(cryptoPercentage);
	}

	public boolean isTotalCryptoPriceDisplayed() {
		return generics.isElementPresent(totalCryptoPrice);
	}

	public boolean isCurrentCryptoPriceDisplayed() {
		return generics.isElementPresent(currentCryptoPrice);
	}

	public boolean isBuyButtonDisplayed() {
		return generics.isElementPresent(buyButton);
	}

	public boolean isSellButtonDisplayed() {
		return generics.isElementPresent(sellButton);
	}

	public boolean isShowActivityDisplayed() {
		return generics.isElementPresent(showActivityMenu);
	}

	public boolean isViewChartDispalyed() {
		return generics.isElementPresent(viewChartButton);
	}

	public boolean isBoughtDisplayed() {
		return generics.isElementPresent(boughtText);
	}

	public boolean isSoldDisplayed() {
		return generics.isElementPresent(soldText);
	}

	public boolean isReceiveDisplayed() {
		return generics.isElementPresent(reciveButton);
	}

	public boolean isAllDisplayed() {
		return generics.isElementPresent(allCheckBox);
	}

	public boolean isBuyCheckDisplayed() {
		return generics.isElementPresent(buyCheckBox);
	}

	public boolean isDepositeDisplayed() {
		return generics.isElementPresent(depositeCheckBox);
	}

	public boolean isBackArrowDisplayed() {
		return generics.isElementPresent(backArrowIcon);
	}

	public boolean isSellDisplayed() {
		return generics.isElementPresent(sellChdeckBox);
	}

	public boolean isBitcoinDisplayed() {
		return generics.isElementPresent(bitcoinCurrancyLabel);
	}

	public boolean isEthereumDisplayed() {
		return generics.isElementPresent(ethereumCurancyLabel);
	}

	public boolean isSolanaDisplayed() {
		return generics.isElementPresent(solanaCurrancyLabel);
	}

	public boolean isDogeDisplayed() {
		return generics.isElementPresent(dogeCurrancyLabel);
	}

	public boolean isLiteCoinDisplayed() {
		return generics.isElementPresent(liteCoinCurrancyLabel);
	}

	public boolean isFtxeDisplayed() {
		return generics.isElementPresent(ftxCurrancyLabel);
	}

	public boolean isChainLinkDisplayed() {
		return generics.isElementPresent(chainLinkCurrancyLabel);
	}

	public boolean isPolygonDisplayed() {
		return generics.isElementPresent(polygonCurrancyLabel);
	}

	public boolean isAaveDisplayed() {
		return generics.isElementPresent(aaveCurrancyLabel);
	}

	public boolean isTronDisplayed() {
		return generics.isElementPresent(tronCurrancyLabel);
	}

	public boolean isThornChainDisplayed() {
		return generics.isElementPresent(thorChainCurrancyLabel);
	}

	public boolean isBuyDisplayed() {
		return generics.isElementPresent(buyLabel);
	}

	public boolean isMaxDisplayed() {
		return generics.isElementPresent(maxButton);
	}

	public boolean isExchangeDisplayed() {
		return generics.isElementPresent(exchangeButton);
	}

	public boolean isGreenDotDisplayed() {
		return generics.isElementPresent(greenDot);
	}

	public boolean isKeyBoardDisplayed() {
		return generics.isElementPresent(keyBoard);
	}

	public boolean isBuyingPowerDisplayed() {
		return generics.isElementPresent(buyingPower);
	}

	public boolean isPriceOfCryptoInUSDDisplayed() {
		return generics.isElementPresent(PriceOfCryptoInUSD);
	}

	public boolean isTextFieldToEntyerAmountDisplayed() {
		return generics.isElementPresent(textFieldToEnterAmountOfCurrancy);
	}

	public boolean isCurrancyConversionValueDisplayed() {
		return generics.isElementPresent(currancyConvertionValue);
	}

	public boolean isConfirmationDisplayed() {
		return generics.isElementPresent(confirmationLabel);
	}

	public boolean isCurrancyDisplayed() {
		return generics.isElementPresent(curancyIcon);
	}

	public boolean isAmountOfCryptoToBuyDisplayed() {
		return generics.isElementPresent(amountOfCryptoToBuy);
	}

	public boolean isCurrancyTypeDisplayed() {
		return generics.isElementPresent(currancyType);
	}

	public boolean isBuyCryptoCurrancyInUsdDisplayed() {
		return generics.isElementPresent(buyCryptoCurrancyInUSD);
	}

	public boolean isTimeForUpdateDisplayed() {
		return generics.isElementPresent(timeForUpdatePrice);
	}

	public boolean isFreeChargeInUsdDisplayed() {
		return generics.isElementPresent(feeChargeInUSD);
	}

	public boolean isUSDBalanceAfterPaymentDisplayed() {
		return generics.isElementPresent(usdBalanceAfterPayment);
	}

	public boolean isSlideToBuyDisplayed() {
		return generics.isElementPresent(slideToBuyButton);
	}

	public boolean isSuccessDisplayed() {
		return generics.isElementPresent(successIcon);
	}

	public boolean isPurchaseDisplayed() {
		return generics.isElementPresent(purchaseText);
	}

	public boolean isAmountDisplayed() {
		return generics.isElementPresent(amountText);
	}

	public boolean isUSDAmountDisplayed() {
		return generics.isElementPresent(usdAmountText);
	}

	public boolean isTransactionIdDisplayed() {
		return generics.isElementPresent(transactionIdText);
	}

	public boolean isReceiptDisplayed() {
		return generics.isElementPresent(receiptLabel);
	}

	public boolean isCryptoCurrancyDisplayed() {
		return generics.isElementPresent(cryptoCurrancyIcon);
	}

	public boolean isBuyDetailsDisplayed() {
		return generics.isElementPresent(buyDetailsLabel);
	}

	public boolean isTextDisplayed() {
		return generics.isElementPresent(textLabel);
	}

	public boolean isConfirmdDisplayed() {
		return generics.isElementPresent(confirmedLabel);
	}

	public boolean isTypeDisplayed() {
		return generics.isElementPresent(typeText);
	}

	public boolean isPurchasedDisplayed() {
		return generics.isElementPresent(purchasedText);
	}

	public boolean isUSDValueDisplayed() {
		return generics.isElementPresent(usdValueText);
	}

	public boolean isConversionRateDisplayed() {
		return generics.isElementPresent(conversionRateText);
	}

	public boolean isTradeIDDisplayed() {
		return generics.isElementPresent(tradeIDText);
	}

	public boolean isDateAndTimeDisplayed() {
		return generics.isElementPresent(dateAndTimeText);
	}

	public boolean isPaymentMethodDisplayed() {
		return generics.isElementPresent(paymentMethodText);
	}

	public boolean isChartDisplayed() {
		return generics.isElementPresent(lineChartText);
	}

	public Boolean isUpDownDisplayed() {

		return generics.isElementPresent(upDownArrow);
	}

	public Boolean isCryptoTvRealValueDisplayed() {
		try {
			return generics.isElementPresent(
					appDriver.findElement(tvRealValue).findElementByClassName("android.widget.TextView"));
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean isCryptoTvValueDisplayed() {
		try {
			return generics
					.isElementPresent(appDriver.findElement(tvValue).findElementByClassName("android.widget.TextView"));
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean isCryptoDateAndTimeDisplayed() {
		try {
			return generics.isElementPresent(
					appDriver.findElement(dateAndTime).findElementByClassName("android.widget.TextView"));
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean isCryptoActivityDisplayed() {
		try {
			return generics.isElementPresent(
					appDriver.findElement(boughtText).findElementByClassName("android.widget.TextView"));
		} catch (Exception e) {
			return false;
		}

	}
	
	public String getBuy() {
		return generics.getText(appDriver.findElement(buyLabel));

	}

	
	public String getSell() {
		return generics.getText(appDriver.findElement(sellLabel));

	}


}
