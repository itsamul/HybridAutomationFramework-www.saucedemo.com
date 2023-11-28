package saucedemo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class DataReader {
	private static Logger log = LogManager.getLogger(DataReader.class);

	private DataReader() {}
	
	public static String getPropertyValue(String key) {
		Properties property = new Properties();
		try {
			FileInputStream fis = new FileInputStream(FrameworkConstants.DATA_PROPERTIES_FILE_PATH);
			property.load(fis);
			log.info("data.properties file loaded.");
		} catch (FileNotFoundException e) {
			log.error("data.properties file not found." + e.getMessage());
		} catch (IOException e) {
			log.error("Unable to open data.properties file." + e.getMessage());
		}
		log.info("Value of key '" + key + "' in the data.properties file is '" + property.getProperty(key) + "'.");
		return  property.getProperty(key);
	}
}
