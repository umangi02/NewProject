package com.manta.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

	public void onStart(ITestContext context) {
		System.out.println("***** Test Suite " + context.getName() + " started ***** \n");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending *** \n"));
		Report.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "... \n"));
		Report.startTest(result.getMethod().getDescription());
		System.out.println("\n " + result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("\n *** Executed " + result.getMethod().getMethodName() + " test successfully... \n");
		Report.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed... \n");;
		String targetLocation = null;

		ITestContext context = result.getTestContext();

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName + timeStamp + ".png";
		String fileSeperator = System.getProperty("file.separator");
		String reportsPath = System.getProperty("user.dir") + fileSeperator + "ExtentReports" + fileSeperator
				+ "screenshots";

		try {
			File file = new File(reportsPath);

			if (!file.exists()) {
				if (file.mkdirs()) {
					System.out.println("Directory: " + file.getAbsolutePath() + " is created!");
				} else {
					System.out.println("Failed to create directory: " + file.getAbsolutePath());
				}

			}

			File screenshotFile = null;
			if(context.getAttribute("platform") == "web") {
				WebDriver webDriver = (WebDriver) context.getAttribute("WebDriver");
				screenshotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
			}

			if(context.getAttribute("platform") == "app") {
				AndroidDriver appDriver = (AndroidDriver) context.getAttribute("AppDriver");
				screenshotFile = ((TakesScreenshot) appDriver).getScreenshotAs(OutputType.FILE);
			}

			targetLocation = reportsPath + fileSeperator + screenShotName;

			File targetFile = new File(targetLocation);
			System.out.println("Screen shot file location - " + targetFile.getAbsolutePath());
			try {
				FileHandler.copy(screenshotFile, targetFile);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("An exception occurred while taking screenshot " + e.getMessage());
		}

		// Adding screenshot to extent reports.
		try {
			Report.getTest().fail("Screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
		} catch (Exception e) {
			System.out.println("An exception occured while Attaching a screenshot " + e.getCause());
		}
		Report.getTest().log(Status.FAIL, "Test Failed");
		Report.getTest().log(Status.FAIL, "StackTrace Result: " + result.getThrowable().toString());

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped... \n");
		Report.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}
