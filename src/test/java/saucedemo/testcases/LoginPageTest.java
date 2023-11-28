package saucedemo.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import saucedemo.utilities.ConfigReader;
import saucedemo.utilities.DataReader;

public class LoginPageTest {
	private static Logger log = LogManager.getLogger(LoginPageTest.class);

	@Test
	public void loginWithValidCredentials() {
		log.info("Browsre : " + ConfigReader.getPropertyValue("browser"));
		log.info("Inside the loginWithValidCredentials");
		log.info("LoginPage Title : " + DataReader.getPropertyValue("lp_page_title"));
	}
}
