package com.tutorials.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-password")
	private WebElement paaswordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordnotmatchingwarning;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterEmailAddress(String emailText) {
	emailAddressField.sendKeys(emailText);
	}
	
	public void enterPassword(String password) {
		paaswordField.sendKeys(password);
	}
	
	
	
	public AccountPage ClickonLogin() {
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	public  AccountPage login(String emailText,String password) {
	
		emailAddressField.sendKeys(emailText);
		paaswordField.sendKeys(password);
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	public String retriveWarningmsgnotMatching() {
	
		String warningtext=emailPasswordnotmatchingwarning.getText();
		return warningtext;
	}
	
	
}
