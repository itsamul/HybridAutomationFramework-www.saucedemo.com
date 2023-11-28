package saucedemo.listener;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import saucedemo.driver.DriverFactory;
import saucedemo.report.ExtentReportSetUp;
import saucedemo.utilities.FrameworkConstants;

public class TestListener implements ITestListener {

	private static Logger log = LogManager.getLogger(TestListener.class);
	public ExtentReports report;
	public static ExtentTest test;
	private String logMessage = "";

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		logMessage = "Execution of " + result.getMethod().getMethodName() + " has started.";
		log.info(logMessage);
		test.log(Status.INFO, logMessage);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logMessage = "Execution of " + result.getMethod().getMethodName() + " has passed.";
		log.info(logMessage);
		test.log(Status.PASS, logMessage);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logMessage = "Execution of " + result.getMethod().getMethodName() + " has passed.";
		log.info(logMessage);
		log.error("Exception occured : " + result.getThrowable());
		test.log(Status.FAIL, logMessage);
		test.log(Status.FAIL, result.getThrowable());
		
		File source = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		final String screenshotPath = FrameworkConstants.SCREENSHOT_FILE_NAME;
		File destination = new File(screenshotPath);
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshotPath, "Screenhot of failed test cases.");
		test.log(Status.INFO, "Screenshot added to report");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logMessage = "Execution of " + result.getMethod().getMethodName() + " has skipped.";
		log.info(logMessage);
		log.error("Exception occured : " + result.getThrowable());
		test.log(Status.SKIP, logMessage);
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		report = ExtentReportSetUp.createReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

}
