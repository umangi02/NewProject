package com.manta.framework.utilities;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Report {
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentManager.getInstance();

	/**
	 * To return current instance of test supporting multithread.
	 *
	 * @return Instance of current test.
	 */
	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	/**
	 * Appends the HTML file with all the ended tests.
	 */
	public static synchronized void endTest() {
		extent.flush();
	}

	/**
	 * Creating the test node in the report.
	 *
	 * @param testName name of current test running.
	 * @return test node.
	 */
	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}

	/**
	 * To print the step as information.
	 *
	 * @param message Step description to be printed and added in extent report.
	 */
	public static void info(String message) {
		System.out.println("> " + message);
		getTest().info(message);
	}

	/**
	 * To print the log and add step in extend report.
	 *
	 * @param status  PASS, FAIL, SKIP to set the status in extent report.
	 * @param message Step description to be printed and added in extent report.
	 */
	public static void log(Status status, String message) {
		System.out.println("> " + message);
		getTest().log(status, message);
	}
}
