package saucedemo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class ConfigReader {
	
	private ConfigReader() {}
	
	public static String getPropertyValue(String key) {
		Properties property = new Properties();
		try {
			FileInputStream fis = new FileInputStream(FrameworkConstants.CONFIG_PROPERTIES_FILE_PATH);
			property.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  property.getProperty(key);
	}
}
