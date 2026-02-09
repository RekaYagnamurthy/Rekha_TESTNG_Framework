package com.creatio.crm.framework.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.creatio.crm.framework.reports.Reports;

public class TestListener extends Reports implements ITestListener {

	String testName;

	public void onTestStart(ITestResult result) {
		testName = result.getMethod().getMethodName();
		startReporting(testName);
		logger.info("The execution of the test case " + testName + " is started");
	}

	public void onTestSuccess(ITestResult result) {
		testName = result.getMethod().getMethodName();
		logger.pass("The execution of the test case " + testName + " is successfully completed without any issues");
		endReport();
	}

	public void onTestFailure(ITestResult result) {
		testName = result.getMethod().getMethodName();
		logger.fail("The execution of the test case " + testName + " is failed");
		logger.fail("The reason for the failure is: " + result.getThrowable().getMessage());
		endReport();
	}

	public void onTestSkipped(ITestResult result) {
		testName = result.getMethod().getMethodName();
		logger.warning("The execution of the test case " + testName + " is skipped");
		logger.warning("The reason for the skipping is: " + result.getThrowable().getMessage());
		endReport();
	}

}
