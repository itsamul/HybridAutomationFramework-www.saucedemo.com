package saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import saucedemo.driver.BrowserFactory;
import saucedemo.driver.DriverFactory;
import saucedemo.utilities.ConfigReader;

public class BaseTest {
	private WebDriver driver, webDriver;
	
	@BeforeMethod
	public void setup() {
		String browserName = ConfigReader.getPropertyValue("browser");
		String testUrl = ConfigReader.getPropertyValue("url");
		BrowserFactory browserFactory = new BrowserFactory();
		webDriver = browserFactory.initializeBrowser(browserName);
		DriverFactory.setDriver(webDriver);
		driver = DriverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(testUrl);
	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}

