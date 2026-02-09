package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropUtil {
	
	//Common method to read the data from property file.
	public static Properties readData(String fileName) {
		
		// Initialize the Properties class to store all the properties from the property file.
		Properties prop = new Properties();
		
		try {

			// Read the properties file by using FileInputStream class.
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Config\\"+fileName);

			// Load all the data from the file to 'prop' variable
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace(); //print the exception in the console
		}
		
		return prop;
	}

}
