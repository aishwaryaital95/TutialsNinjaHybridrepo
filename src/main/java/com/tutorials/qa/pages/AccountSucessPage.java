package com.tutorials.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSucessPage {
	WebDriver driver;
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement AccountSuccessPageHeading;

	
	public  AccountSucessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public String retriveAccountSuccessPageHeading() {
		
		String accountSuccessPageHeadingtext=AccountSuccessPageHeading.getText();
		return accountSuccessPageHeadingtext;
	}
	
	
}
