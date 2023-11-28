package saucedemo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ConfigReader {
	private static Logger log = LogManager.getLogger(ConfigReader.class);

	private ConfigReader() {}
	
	public static String getPropertyValue(String key) {
		Properties property = new Properties();
		try {
			FileInputStream fis = new FileInputStream(FrameworkConstants.CONFIG_PROPERTIES_FILE_PATH);
			property.load(fis);
			log.info("config.properties file loaded.");
		} catch (FileNotFoundException e) {
			log.error("config.properties file not found." + e.getMessage());
		} catch (IOException e) {
			log.error("Unable to open config.properties file." + e.getMessage());
		}
		log.info("Value of key '" + key + "' in the config.properties file is '" + property.getProperty(key) + "'.");
		return  property.getProperty(key);
	}
}
