package com.neotech.testbase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.neotech.utils.CommonMethods;

public class Listener implements ITestListener {

	public void onStart(ITestContext context) {
		System.out.println("Functionanlity test started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Functionanlity test finished");
	}

	public void onTestStart(ITestResult result) {
		// Printing logs to the console
		System.out.println("Test Will Start: " + result.getName());

		// Creating a test on the report -- to use it to log into ExtentReports
		BaseClass.test = BaseClass.report.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// Printing logs to the console
		System.out.println("Test Passed: " + result.getName());

		// Print test passed on the report
		BaseClass.test.pass("Test Passed: " + result.getName());
		
		//Take a screenshot and add it to the report
		BaseClass.test.addScreenCaptureFromPath(CommonMethods.takeScreenshot("passed/" + result.getName()));
	}

	public void onTestFailure(ITestResult result) {
		// Printing logs to the console
		System.out.println("Test Failed: " + result.getName());

		// Print test passed on the report
		BaseClass.test.fail("Test Failed: " + result.getName());
		
		//Take a screenshot and add it to the report
		BaseClass.test.addScreenCaptureFromPath(CommonMethods.takeScreenshot("failed/" + result.getName()));
	}
}

