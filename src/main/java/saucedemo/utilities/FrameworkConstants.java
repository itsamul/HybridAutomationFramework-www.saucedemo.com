package saucedemo.utilities;

import com.aventstack.extentreports.reporter.configuration.Theme;

public final class FrameworkConstants {
	
	private FrameworkConstants() {}
	
	private final static String RESOURCE_FOLDER = System.getProperty("user.dir") + "//src//test//resources//";
	public static final String CONFIG_PROPERTIES_FILE_PATH = RESOURCE_FOLDER + "properties//config.properties";
	public static final String DATA_PROPERTIES_FILE_PATH = RESOURCE_FOLDER + "testData//data.properties";
	
	public static final String SCREENSHOT_FILE_PATH = "Reports//";
	public static String SCREENSHOT_FILE_NAME = SCREENSHOT_FILE_PATH + "Screenshot_" + CommonUtilities.getCurrentDateTimeStamp() + ".png";
	
	// ***** EXTENTREPORTS CONSTANTS *****
	public static final String EXTENT_REPORT_FILE_PATH = "Reports/ExecutionReport.html";
	public static final String EXTENT_REPORT_DOCUMENT_TITLE = "Execution report for saucedemo website";
	public static final String EXTENT_REPORT_REPORT_NAME = "Functional Test case Report for saucedemo website";
	public static final String EXTENT_REPORT_TIME_FORMAT = "Reports/ExecutionReport.html";
	
	public static final String EXTENT_REPORT_APPLICATION_URL = ConfigReader.getPropertyValue("url");
	public static final String EXTENT_REPORT_BROWSER = ConfigReader.getPropertyValue("browser");
	public static final String EXTENT_REPORT_TESTER = "Amul Sinfal";
	public static final String EXTENT_REPORT_OPERATING_SYSTEM = System.getProperty("os.name");
	public static final String EXTENT_REPORT_JAVA_VERSION = System.getProperty("java.version");
	public static final Theme EXTENT_REPORT_THEME = Theme.DARK;

	
}
