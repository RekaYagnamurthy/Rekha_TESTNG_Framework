package com.creatio.crm.framework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {
	
	int count =0;
	int maxRetryCount =2;

	@Override
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
			if(count < maxRetryCount) {
				count++;
				return true; // retry the test
			}
		}
		return false;// do not retry the test
	}



}
