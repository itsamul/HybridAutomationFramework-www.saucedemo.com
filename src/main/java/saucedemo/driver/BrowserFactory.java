package saucedemo.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
	
	public WebDriver initializeBrowser(String browserName) {
		WebDriver driver = null;
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			driver = new ChromeDriver(chromeOptions);
		} else if(browserName.equalsIgnoreCase("Firefox")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("-priavte");
			driver = new FirefoxDriver(firefoxOptions);
		} else if(browserName.equalsIgnoreCase("Edge")) {
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("-inpriavte");
			driver = new EdgeDriver(edgeOptions);
		}
		return driver;
	}
}
