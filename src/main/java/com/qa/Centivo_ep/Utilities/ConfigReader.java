package com.qa.Centivo_ep.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	public static Properties prop;
	public static FileInputStream ip;

	public static Properties initializePropertiesFile() throws Exception {
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\Config.properties");
		prop.load(ip);

		return prop;
	}

}
