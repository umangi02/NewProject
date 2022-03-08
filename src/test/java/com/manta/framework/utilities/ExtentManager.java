package com.manta.framework.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;
	private static String reportFileName = "manta-app-Report" + ".html";
	private static String fileSeparator = System.getProperty("file.separator");
	private static String reportFilepath = System.getProperty("user.dir") + fileSeparator + "ExtentReports";
	private static String reportFileLocation = reportFilepath + fileSeparator + reportFileName;

	/**
	 * Create and return the instance of the report.
	 *
	 * @return report instance.
	 */
	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	/**
	 * Configuring and creating instance.
	 *
	 * @return returning the instance.
	 */
	public static ExtentReports createInstance() {
		String fileName = getReportPath(reportFilepath);

		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(reportFileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(reportFileName);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}

	/**
	 * Create report directory and return path.
	 *
	 * @param path absolute path for storing report
	 * @return file path of stored report
	 */
	private static String getReportPath(String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				System.out.println("Directory: " + path + " is created!");
				return reportFileLocation;
			} else {
				System.out.println("Failed to create directory: " + path);
				return System.getProperty("user.dir");
			}
		} else {
			System.out.println("Directory already exists: " + path);
		}
		return reportFileLocation;
	}

}
