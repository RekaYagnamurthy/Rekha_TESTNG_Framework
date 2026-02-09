package com.creatio.crm.framework.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.creatio.crm.framework.constants.Constants;
import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.utilities.PropUtil;

public class BasePage extends Reports{

//This class will contain all the common methods related to browser configurations and web-driver.

	// This class will contain all the common methods related to browser configurations and web-driver
		private static WebDriver driver;
		Properties prop = PropUtil.readData("Config.properties");

		// Common method to launch the browser window
		
		@BeforeMethod(alwaysRun = true)
		public void setupBrowser() {
			String browserName = prop.getProperty("browser.name");
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else {
				Assert.fail("Browser not supported");
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		}
		
		// Common method to close the browser window
		
		@AfterMethod(alwaysRun = true)
		public void tearDownBrowser() {
			if (driver != null) {
				driver.quit();
			}
		}
		
		// Method to get the WebDriver instance
		public static WebDriver getDriver() {
			return driver;
		}
		
		// Method to set the WebDriver instance
		public static void setDriver(WebDriver driverInstance) {
			driver = driverInstance;
		}
		
}