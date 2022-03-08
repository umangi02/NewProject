package com.manta.framework.common;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;
import com.manta.framework.configuration.Configuration;
import com.manta.framework.utilities.Path;
import com.manta.framework.utilities.Randoms;


import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Generics implements Configuration {

	private final WebDriver generalDriver;
	private final WebDriverWait wait;

	public Generics(WebDriver driver) {
		this.generalDriver = driver;
		wait = new WebDriverWait(generalDriver, Integer.parseInt(WEB_DRIVER_WAIT));
	}

	/**
	 * Pause for given seconds
	 *
	 * @param sec Time in Seconds
	 */
	public static void pause(int sec) {
		try {
			Thread.sleep(sec * 1000L);
		} catch (InterruptedException interruptedException) {
			System.out.println("Failure in Pause.");
		}
	}

	/**
	 * To clear and send the value to the text field
	 *
	 * @param lastName WebElement
	 * @param value      String Value
	 */
	public static void type(WebElement lastName, String value) {
		clear(lastName);
		lastName.sendKeys(value);
	}

	/**
	 * To clear the value from the text field
	 *
	 * @param webElement WebElement
	 */
	public static void clear(WebElement webElement) {
		webElement.clear();
	}

	/**
	 * To click on particular WebElement using Java Script
	 *
	 * @param element WebElement
	 */
	public void clickOnJS(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor executor = (JavascriptExecutor) generalDriver;
		executor.executeScript("arguments[0].click();", element);
	}

	/**
	 * To get text from the element
	 *
	 * @param element WebElement
	 * @return Text from the WebElement
	 */
	public static String getText(WebElement element) {
		return element.getText().trim();
	}

	/**
	 * To check if element is available in page or not
	 *
	 * @param element WebElement
	 * @return if web element display or not
	 */
	public static boolean isElementPresent(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException nse) {
			return false;
		}
	}

	/**
	 * To check if element is available in page or not using locator
	 *
	 * @param locator Locator
	 * @return if web element display or not
	 */
	public boolean isElementPresent(By locator) {
		implicitWaitOf(0);
		try {
			MobileElement element = generalDriver.findElement(locator);
			implicitWaitOf(Integer.parseInt(APP_IMPLICIT_WAIT));
			return element.isDisplayed();
		} catch (NoSuchElementException nse) {
			implicitWaitOf(Integer.parseInt(APP_IMPLICIT_WAIT));
			return false;
		}
	}

	/**
	 * To scroll the screen horizontally
	 *
	 * @param yPercent Locator
	 */
	public void horizontalScroll(double yPercent) {
		Dimension dim = generalDriver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * yPercent);
		int startx = (int) (width * 0.80);
		int endx = (int) (width * 0.35);
		TouchAction swipe = new TouchAction((PerformsTouchActions) generalDriver).press(PointOption.point(startx, y))
				.waitAction(waitOptions(ofMillis(800))).moveTo(PointOption.point(endx, y)).release().perform();

	}

	/**
	 * To check if element is enabled or disabled
	 * 
	 * @param element WebElement
	 */
	public boolean isElementEnabled(By element) {
		return generalDriver.findElement(element).isEnabled();
	}

	/**
	 * To scroll to particular element
	 * 
	 * @param elementText String text to select
	 */
	public void scrollToElementViaText(String elementText) {
		generalDriver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().textContains(\"" + elementText + "\").instance(0))"));
	}

	/**
	 * To select value from dropdown
	 *
	 * @param element WebElement
	 * @param text    String text to select
	 */
	public void selectValueFromDropDown(WebElement element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * To perform mouse hover over element
	 *
	 * @param element WebElement
	 */
	public void moveTo(WebElement element) {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		Actions action = new Actions(generalDriver);
		action.moveToElement(element).build().perform();
	}

	/**
	 * To wait till visibility of all elements
	 *
	 * @param elements WebElements
	 */
	public void waitForElementVisible(WebElement... elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	/**
	 * To wait till visibility of all elements using By class.
	 *
	 * @param element WebElement
	 */
	public void waitForElementVisible(By element) {
		implicitWaitOf(0);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		implicitWaitOf(Integer.parseInt(APP_IMPLICIT_WAIT));
	}

	/**
	 * To wait till visibility of all elements using By class.
	 *
	 * @param element WebElement
	 * @param timeToWait time to wait for element
	 */
	public boolean waitForElementVisible(By element, int timeToWait) {
		try {
			implicitWaitOf(0);
			Wait wait = new WebDriverWait(generalDriver, timeToWait);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			implicitWaitOf(Integer.parseInt(APP_IMPLICIT_WAIT));
			return true;
		} catch (Exception ex) {
			implicitWaitOf(Integer.parseInt(APP_IMPLICIT_WAIT));
			return false;
		}
	}

	/**
	 * To scroll to particular element
	 *
	 * @param element WebElement
	 */
	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) generalDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		pause(2);
	}

	/**
	 * To switch on another window
	 *
	 */
	public void switchToWindow() {

		String mainWindowHandle = generalDriver.getWindowHandle();
		Set<String> allWindowHandles = generalDriver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				generalDriver.switchTo().window(ChildWindow);
			}
		}
	}

	/**
	 * To close current browser window and switch
	 *
	 */
	public void closeCurrentWindow() {
		generalDriver.close();
		switchToWindow();
	}

	/**
	 * To until element is clickable
	 *
	 * @param element WebElement
	 */
	public void isClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * To until element is clickable
	 *
	 * @param element MobileElement
	 */
	public void isMobileElementClickable(MobileElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * To crop an image
	 *
	 * @param imageToCrop MobileElement
	 * @return HashMap<String, Integer> annotation Crop Point Details
	 */
	public HashMap<String, Integer> cropImage(MobileElement imageToCrop) {

		int centerX = imageToCrop.getCenter().getX();
		int centerY = imageToCrop.getCenter().getY();

		HashMap<String, Integer> annotationCropPoint = new HashMap<String, Integer>();

		Point startPoint = new Point(centerX - Randoms.getRandomNumberBetween(100, 150),
				centerY - Randoms.getRandomNumberBetween(100, 150));

		Point endPoint = new Point(centerX + Randoms.getRandomNumberBetween(100, 150),
				centerY + Randoms.getRandomNumberBetween(100, 150));

		new TouchAction<>((AndroidDriver) generalDriver).press(PointOption.point(startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endPoint))
				.release().perform();

		annotationCropPoint.put("startPointX", startPoint.getX());
		annotationCropPoint.put("startPointY", startPoint.getY());
		annotationCropPoint.put("endPointX", endPoint.getX());
		annotationCropPoint.put("endPointY", endPoint.getY());

		return annotationCropPoint;

	}

	/**
	 * To crop an image
	 *
	 * @param imageToCropInQuadMode in quadrilateral mode MobileElement
	 * @return HashMap<String, Integer> annotation Crop Point Details
	 */
	public HashMap<String, Integer> cropImageQuadrilateralMode(MobileElement imageToCropInQuadMode) {

		int centerX = imageToCropInQuadMode.getCenter().getX();
		int centerY = imageToCropInQuadMode.getCenter().getY();

		HashMap<String, Integer> annotationCropPoint = new HashMap<String, Integer>();

		Point centrePoint = new Point(centerX, centerY);

		Point startPoint = new Point(centerX - Randoms.getRandomNumberBetween(100, 150),
				centerY - Randoms.getRandomNumberBetween(100, 150));

		Point endPoint = new Point(centerX + Randoms.getRandomNumberBetween(100, 150),
				centerY + Randoms.getRandomNumberBetween(100, 150));

		Point dragPoint1 = new Point(endPoint.getX() + Randoms.getRandomNumberBetween(50, 100), endPoint.getY() + Randoms.getRandomNumberBetween(50, 100));//bottom right
		Point dragPoint2 = new Point(startPoint.getX() - Randoms.getRandomNumberBetween(50, 100), startPoint.getY() + Randoms.getRandomNumberBetween(50, 100));// top left
		Point topLeftPoint = new Point(startPoint.getX(), startPoint.getY());// top left
		Point dragPoint3 = new Point(endPoint.getX() + Randoms.getRandomNumberBetween(50, 100), startPoint.getY() - Randoms.getRandomNumberBetween(50, 100));//top right
		Point topRightPoint = new Point(endPoint.getX(), startPoint.getY());// top left
		Point dragPoint4 = new Point(startPoint.getX() - Randoms.getRandomNumberBetween(50, 100), endPoint.getY() + Randoms.getRandomNumberBetween(50, 100));//bottom left
		Point bottomLeftPoint = new Point(startPoint.getX(), endPoint.getY());// top left


		new TouchAction<>((AndroidDriver) generalDriver).press(PointOption.point(startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endPoint))
				.release().perform();

		new TouchAction<>((AndroidDriver) generalDriver).tap(PointOption.point(centrePoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).release();

		new TouchAction<>((AndroidDriver) generalDriver).press(PointOption.point(endPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(dragPoint1))
				.release().perform();

		new TouchAction<>((AndroidDriver) generalDriver).press(PointOption.point(topLeftPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(dragPoint2))
				.release().perform();

		new TouchAction<>((AndroidDriver) generalDriver).press(PointOption.point(topRightPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(dragPoint3))
				.release().perform();

		new TouchAction<>((AndroidDriver) generalDriver).press(PointOption.point(bottomLeftPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(dragPoint4))
				.release().perform();

		annotationCropPoint.put("dragPoint1X", dragPoint1.getX());
		annotationCropPoint.put("dragPoint1Y", dragPoint1.getY());
		annotationCropPoint.put("dragPoint2X", dragPoint2.getX());
		annotationCropPoint.put("dragPoint2Y", dragPoint2.getY());
		annotationCropPoint.put("dragPoint3X", dragPoint3.getX());
		annotationCropPoint.put("dragPoint3Y", dragPoint3.getY());
		annotationCropPoint.put("dragPoint4X", dragPoint4.getX());
		annotationCropPoint.put("dragPoint4Y", dragPoint4.getY());

		System.out.println("Points :" + annotationCropPoint);

		return annotationCropPoint;

	}

	/**
	 * To perform crop operation by passing screen width ratio.
	 *
	 * @param element     mobile element on which crop needs to be performed.
	 * @param screenRatio horizontal percentage of screen to start annotation.
	 * @return HashMap<String, Integer> annotation Crop Point Details
	 */
	public HashMap<String, Integer> cropImage(MobileElement element, double screenRatio) {

		HashMap<String, Integer> annotationCropPoint = new HashMap<String, Integer>();

		Dimension imageSize = element.getSize();
		int imageXOffset = (int) Math.round(imageSize.width * screenRatio / 100);
		int imageYOffset = imageSize.height / 2;
		Point startPoint = new Point(imageXOffset, imageYOffset);
		Point endPoint = new Point(imageXOffset + 100, imageYOffset + 100);

		new TouchAction<>((AndroidDriver) generalDriver).press(PointOption.point(startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endPoint))
				.release().perform();

		annotationCropPoint.put("startPointX", startPoint.getX());
		annotationCropPoint.put("startPointY", startPoint.getY());
		annotationCropPoint.put("endPointX", endPoint.getX());
		annotationCropPoint.put("endPointY", endPoint.getY());

		return annotationCropPoint;
	}

	/**
	 * To swipe towards next screen
	 *
	 */
	public void swipeToNextScreen() {
		int locationXStart, locationXEnd;

		int locationX = generalDriver.manage().window().getSize().width;
		int locationY = generalDriver.manage().window().getSize().height / 2;

		locationXStart = (int) Math.round(locationX * 0.90);
		locationXEnd = (int) Math.round(locationX * 0.10);

		new TouchAction<>((AndroidDriver) generalDriver).press(PointOption.point(locationXStart, locationY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(locationXEnd, locationY)).release().perform();
	}

	/**
	 * To swipe towards previous screen
	 *
	 */
	public void swipeToPreviousScreen() {
		int locationXStart, locationXEnd;

		int locationX = generalDriver.manage().window().getSize().width;
		int locationY = generalDriver.manage().window().getSize().height / 2;

		locationXStart = (int) Math.round(locationX * 0.10);
		locationXEnd = (int) Math.round(locationX * 0.90);

		new TouchAction<>((AndroidDriver) generalDriver).press(PointOption.point(locationXStart, locationY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(locationXEnd, locationY)).release().perform();
	}

	/**
	 * To set implicit wait
	 *
	 * @param seconds Integer
	 */
	public void implicitWaitOf(int seconds) {
		generalDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/**
	 * Returns current android activity.
	 *
	 * @return String value of current android activity name.
	 */
	public String getCurrentActivity() {
		return ((AndroidDriver) generalDriver).currentActivity();
	}

	/**
	 * Wait until element is invisible on screen.
	 *
	 * @param element element which needs to be invisible.
	 */
	public void waitForInvisibilityOfElement(By element) {
		implicitWaitOf(0);
		wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.invisibilityOfElementLocated(element));
		implicitWaitOf(Integer.parseInt(APP_IMPLICIT_WAIT));
	}

	/**
	 * Wait until element is invisible on screen.
	 *
	 * @param element element which needs to be invisible.
	 */
	public void waitForInvisibilityOfElement(By element, int timeInSec) {
		WebDriverWait wait = new WebDriverWait(generalDriver,timeInSec);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}

	/**
	 * Press back button of android phone.
	 */
	public void pressBack() {
		((AndroidDriver) generalDriver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	}

	/**
	 * Long Press on element.
	 *
	 * @param element MobileElement
	 */
	public void longPress(MobileElement element) {
		new TouchAction<>((AndroidDriver) generalDriver).longPress(PointOption.point(element.getCenter()))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).release().perform();
	}

	/**
	 * To perform scroll Down
	 *
	 */
	public void scrollDown() {

		int locationXStart = generalDriver.manage().window().getSize().width / 2;
		int locationYStart = (int) (generalDriver.manage().window().getSize().height * 0.80);
		int locationYEnd = (int) (generalDriver.manage().window().getSize().height * 0.20);

		new TouchAction<>((AndroidDriver) generalDriver).press(PointOption.point(locationXStart, locationYStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(locationXStart, locationYEnd)).release().perform();
	}

	/**
	 * Check the given checkbox element.
	 *
	 * @param checkbox WebElement of the checkbox to check.
	 */
	public static void check(WebElement checkbox) {
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	/**
	 * uncheck the given checkbox element.
	 *
	 * @param checkbox WebElement of the checkbox to uncheck..
	 */
	public static void uncheck(WebElement checkbox) {
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}

	/**
	 * To draw a line on image.
	 * 
	 * @param imageToPaint MobileElement
	 * @return HashMap<String, Integer> annotation StraightLine Points Details
	 */
	public HashMap<String, Integer> drawStraightLine(MobileElement imageToPaint) {

		int centerX = imageToPaint.getCenter().getX();
		int centerY = imageToPaint.getCenter().getY();

		HashMap<String, Integer> annotationPaintPoints = new HashMap<String, Integer>();

		Point startPoint = new Point(centerX - Randoms.getRandomNumberBetween(100, 200),
				centerY - Randoms.getRandomNumberBetween(100, 200));

		Point endPoint = new Point(centerX + Randoms.getRandomNumberBetween(100, 200),
				centerY + Randoms.getRandomNumberBetween(100, 200));

		new TouchAction<>((AndroidDriver) generalDriver).press(PointOption.point(startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endPoint))
				.release().perform();

		annotationPaintPoints.put("startPointX", startPoint.getX());
		annotationPaintPoints.put("startPointY", startPoint.getY());
		annotationPaintPoints.put("endPointX", endPoint.getX());
		annotationPaintPoints.put("endPointY", endPoint.getY());

		return annotationPaintPoints;
	}

	/**
	 * To draw curve line on image.
	 * 
	 * @param imageToPaint MobileElement
	 * @return HashMap<String, Integer> annotationCurvedLinePoint Details
	 */
	public HashMap<String, Integer> drawCurvedLine(MobileElement imageToPaint) {
		int centerX = imageToPaint.getCenter().getX();
		int centerY = imageToPaint.getCenter().getY();

		HashMap<String, Integer> annotationCurvedLinePoints = new HashMap<String, Integer>();

		Point startPoint = new Point(centerX - Randoms.getRandomNumberBetween(200, 300),
				centerY - Randoms.getRandomNumberBetween(200, 400));

		Point endPoint = new Point(centerY - Randoms.getRandomNumberBetween(100, 200),
				centerY - Randoms.getRandomNumberBetween(100, 200));

		new TouchAction<>((AndroidDriver) generalDriver).press(PointOption.point(startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endPoint))
				.release().perform();

		annotationCurvedLinePoints.put("startCurvedPointX", startPoint.getX());
		annotationCurvedLinePoints.put("startCurvedPointY", startPoint.getY());
		annotationCurvedLinePoints.put("endCurvedPointX", endPoint.getX());
		annotationCurvedLinePoints.put("endCurvedPointY", endPoint.getY());

		return annotationCurvedLinePoints;
	}

	/**
	 * To refresh screen
	 */
	public void screenRefresh() {
		Dimension screenSize = generalDriver.manage().window().getSize();

		int startY = (int) (screenSize.height * 0.90);
		int endy = (int) (screenSize.height * 0.20);
		int startX = screenSize.width / 2;

		new TouchAction<>((AndroidDriver) generalDriver).press(PointOption.point(startX, endy))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(startX, startY))
				.release().perform();

	}

	/**
	 * To turn on/off location
	 */
	public void locationDisableEnable(String location) {
		String locStatus = "0";
		if(location.equalsIgnoreCase("enable")) {
			locStatus = "3";
		}
		List<String> locArgs = Arrays.asList("put", "secure location_mode "+ locStatus +"");
		Map<String, Object> locCmd = ImmutableMap
				.of("command", "settings", "args", locArgs);
		((AndroidDriver) generalDriver).executeScript("mobile: shell", locCmd);
	}

	/**
	 * To refresh Website Page
	 */
	public void pageRefresh() {
		generalDriver.navigate().refresh();
	}

	/**
	 * To upload image
	 * 
	 * @param imageName String text to select
	 */
	public void uploadImage(String imageName) {
		try {
			String testDataPath = Path.getProjectDir() + File.separator + "resources" + File.separator + "testdata"
					+ File.separator + "images" + File.separator;
			((AndroidDriver) generalDriver).pushFile("/sdcard/download/" + imageName,
					new File(testDataPath + imageName));
			((AndroidDriver) generalDriver).findElement(By.id(APP_PACKAGE + ":id/galleryIv")).click();
			((AndroidDriver) generalDriver)
					.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Show roots']")).click();
			((AndroidDriver) generalDriver)
					.findElement(By.xpath("//*[@class='android.widget.ListView']//*[contains(@text,'Downloads')]"))
					.click();
			((AndroidDriver) generalDriver).findElement(By.id("com.google.android.documentsui:id/icon_thumb")).click();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	/**
	 * To perform doubleTap on Screen
	 */
	public void doubleTap() {				
		
		int locationX = generalDriver.manage().window().getSize().width / 2 ;
		int locationY = generalDriver.manage().window().getSize().height / 2;
		
		new TouchAction((AndroidDriver) generalDriver).press(PointOption.point(locationX, locationY)).release().perform().press(PointOption.point(locationX, locationY)).release().perform();
	}
}
