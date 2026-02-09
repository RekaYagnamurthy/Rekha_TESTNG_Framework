package com.creatio.crm.framework.reports;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	
	//This class will contain all the common methods related to HTML report generation by using Extent Reports.
	
	public static ExtentHtmlReporter html; // white paper
	public static ExtentReports extent; //printer
	public static ExtentTest logger; //ink
	
	
	//Method to set up the report.
	
	@BeforeSuite(alwaysRun=true)
	public static void setupReport() {
		html = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\AutomationReport.html");//create empty html report
		extent = new ExtentReports();//create extent report object
		extent.attachReporter(html);//attach the html report to extent report to start using it.
	}
	
	//Method to start the printing process for a specific test case.
	public static void startReporting(String testCaseName) {
		logger = extent.createTest(testCaseName);
	}
	
	//Method to end the printing process.
	public static void endReport() {
		extent.flush();
	}
	
	//Method to attach screenshot within the report.
	public static void attachScreenshot(String path) {
		try {
			logger.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
