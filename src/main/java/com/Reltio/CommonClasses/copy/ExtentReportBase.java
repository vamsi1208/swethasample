// BaseClass for extent reports to generate the html output Report

package com.Reltio.CommonClasses.copy;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportBase {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	/**
	 * To setup the extent report with the configurations
	 */
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Reltio_ExtentReport.html");
		System.out.println("path is:" + System.getProperty("user.dir"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Host Name", "Reltio");
		extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "V-Soft");

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report for Reltio POC");
		htmlReporter.config().setReportName("My Extent Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

		try {
			FileUtils.cleanDirectory(new File("./ScreenShots/"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * To verify the status of the method after each method and
	 */
	@AfterMethod
	public void getResult(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {

			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
			test.fail(result.getThrowable());
			GetScreenShot.capture(DriverClass.getDriver(), result.getName());

			// String screenShotPath =
			// GetScreenShot.capture(DriverClass.getDriver(),result.getName());
			// test.log(Status.FAIL, "Snapshot below: " +
			// test.addScreenCaptureFromPath(screenShotPath));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.BLUE));
			test.skip(result.getThrowable());
		}
	}

	/**
	 * This method is for opening the Extent Report in the Firefox Browser
	 */
	@AfterSuite
	public void tearDown() throws Exception {
		DriverClass.getDriver().quit();
		extent.flush();

		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\Drivers\\chromedriver.exe");
		// ChromeDriver driver=new ChromeDriver();

		ChromeOptions Chr_obj = new ChromeOptions();
		Chr_obj.addArguments("disable-infobars");

		ChromeDriver driver = new ChromeDriver(Chr_obj);

		/*
		 * Read_PropertyFile obj_url = new Read_PropertyFile();
		 * 
		 * driver.get(obj_url.Passurl());
		 */

		// driver.manage().window().maximize();

		// WebDriver dr = new FirefoxDriver();
		driver.get(System.getProperty("user.dir") + "\\test-output\\Reltio_ExtentReport.html");
		driver.manage().window().maximize();
		//Email_ReltoPOC_TestResult.execute();
		
	}
}
