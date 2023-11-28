package saucedemo.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import saucedemo.utilities.FrameworkConstants;

public class ExtentReportSetUp {
	public static ExtentReports extentReport;
	
	public static ExtentReports createReport() {
		extentReport = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants.EXTENT_REPORT_FILE_PATH);
		extentReport.attachReporter(sparkReporter);
		
		sparkReporter.config().setTheme(FrameworkConstants.EXTENT_REPORT_THEME);
		sparkReporter.config().setDocumentTitle(FrameworkConstants.EXTENT_REPORT_DOCUMENT_TITLE);
		sparkReporter.config().setReportName(FrameworkConstants.EXTENT_REPORT_REPORT_NAME);
		sparkReporter.config().setTimeStampFormat("dd-MM-YYYY HH:mm:ss");
		
		extentReport.setSystemInfo("Aplication Url", FrameworkConstants.EXTENT_REPORT_APPLICATION_URL);
		extentReport.setSystemInfo("Browser", FrameworkConstants.EXTENT_REPORT_BROWSER);
		extentReport.setSystemInfo("Automation Tester", FrameworkConstants.EXTENT_REPORT_TESTER);
		extentReport.setSystemInfo("Operating System", FrameworkConstants.EXTENT_REPORT_OPERATING_SYSTEM);
		extentReport.setSystemInfo("Java version", FrameworkConstants.EXTENT_REPORT_JAVA_VERSION);
		
		return extentReport;
	}
}
