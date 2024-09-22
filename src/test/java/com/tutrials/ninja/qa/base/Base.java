package com.tutrials.ninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorials.qa.utils.Utils;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
public void loadprop() {
	
	 prop=new Properties();
	File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorils\\config\\config.properties");
	
	dataprop = new Properties();
	File datapropfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorials\\qa\\testdata\\testdata.properties");
	
	try {
	FileInputStream fis= new FileInputStream(datapropfile);
	dataprop.load(fis);
	}
	
	catch(Throwable e) {
		e.printStackTrace();
	}
	try {
	FileInputStream file=new FileInputStream(propFile);
	prop.load(file);
	}
catch( Throwable e) {
	e.printStackTrace();
}}

public WebDriver initializebrowserOpenApplicationUrl(String browserName) {
	
	
	
	if(browserName.equals("chrome")){
		driver=new ChromeDriver();
	}
	else if(browserName.equals("firefox")){
		driver=new FirefoxDriver();
	}
	else if(browserName.equals("edge")){
		driver=new EdgeDriver();
	}
		driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT_TIME));
		    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGE_WAIT_TIME));
		    driver.get(prop.getProperty("url")); 
	
	return driver;
}
}
