package com.tutorials.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorials.qa.utils.ExtentReporter;
import com.tutorials.qa.utils.Utils;

public class MyListerners implements ITestListener  {
	ExtentReports extentReport;
	ExtentTest extentTest;
	String testname;
	public void onStart(ITestContext context) {
		
		
			try {
				 extentReport = ExtentReporter.generateExtentReport();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		System.out.println("Execution of project started");
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		 extentTest=extentReport.createTest(result.getName());
		extentTest.log(Status.INFO,testname+" started executing");
	System.out.println("Execution of project started");	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	 
	extentTest.log(Status.PASS,result.getName()+" got successfully executed");
	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		
	WebDriver driver=null;	
		//System.out.println("Screenshot taken");
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(testname);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String destinationScreenshotPath=Utils.captureScreenshot(driver, result.getName()); 
		
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL,result.getName()+"got failed");
		System.out.println(result.getThrowable());
		
		
		
			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+"got skipped");
		
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
	
		
		extentReport.flush();
		
		String pathofextent=System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReport=new File(pathofextent);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finish executing the project");
	}

	
	
}



	
