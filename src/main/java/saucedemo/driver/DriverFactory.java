package saucedemo.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> threadlocalDriver = new ThreadLocal<WebDriver>();
	
	public static void setDriver(WebDriver wdriver) {
		threadlocalDriver.set(wdriver);
	}
	
	public static WebDriver getDriver() {
		return threadlocalDriver.get();
	}
	
	public static void quitDriver() {
		threadlocalDriver.get().quit();
		threadlocalDriver.remove();
	}
}
