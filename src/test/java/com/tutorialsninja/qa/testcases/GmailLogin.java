package com.tutorialsninja.qa.testcases;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GmailLogin {
	public static void main(String[] args) {
	 {
		 //System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	WebDriver driver=new ChromeDriver();
	ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.setBinary("Binary path of the Chrome");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
driver.navigate().to("https://gmail.com");
driver.findElement(By.id("identifierId")).sendKeys(".com");
driver.findElement(By.xpath("//*[contains(text(),'Next')]")).click();	

	
	}	}

}