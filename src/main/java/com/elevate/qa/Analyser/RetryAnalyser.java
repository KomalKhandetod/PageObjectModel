package com.elevate.qa.Analyser;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	
	int counter = 0;
	int RetryLimit = 2;
	
	public boolean retry(ITestResult result) {
		if(counter<RetryLimit) {
			counter++;
			return true;
		}
		return false;
	}
	

}
