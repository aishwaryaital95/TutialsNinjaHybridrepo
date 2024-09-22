package com.tutorials.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport() throws IOException {
		ExtentReports extentReport=new ExtentReports();
		File extentReoprtFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(extentReoprtFile);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("tutorialsninja test Automation Results");
		spark.config().setDocumentTitle("TN automation Report");
		spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extentReport.attachReporter(spark);
		
		
		Properties configprop= new Properties();
		File configPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorils\\config\\config.properties");
		FileInputStream fisConfigProp=new FileInputStream(configPropFile);
		configprop.load(fisConfigProp);
		extentReport.setSystemInfo("Application URL",configprop.getProperty("url"));
		extentReport.setSystemInfo("Browser name",configprop.getProperty("browser"));
		extentReport.setSystemInfo("Email",configprop.getProperty("ValidEmail")); 
		extentReport.setSystemInfo("Password",configprop.getProperty("ValidPassword"));
		extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));		
		extentReport.setSystemInfo("Username",System.getProperty("user.name"));	
		extentReport.setSystemInfo("java version",System.getProperty("java.version"));
		
		return extentReport;
	}
}
