package ecommerceTestProject.ecomTest.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	private static Properties properties;

	static {
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
			properties = new Properties();
			properties.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config.properties file");
		}
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}
}
