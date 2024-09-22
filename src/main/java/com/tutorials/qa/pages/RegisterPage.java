package com.tutorials.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	
	WebDriver driver;
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	
	@FindBy(id="input-lastname")
	private WebElement LastNameField;
	
	@FindBy(id="input-email")
	private WebElement EmailAddressfield;
	
	
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;

	
	@FindBy(name="agree")
	private WebElement privacypolicyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
 
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement YesNewsLetterOption;

	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailAddresswarning;
	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	
public void enterfirstName(String firstName) {
	firstNameField.sendKeys(firstName);
}

public void enterLastName(String LastName) {
	LastNameField.sendKeys(LastName);
}

public void enterEmailfield(String emailText) {
	EmailAddressfield.sendKeys(emailText);
}


public void entertelephoneField(String telephone) {
	telephoneField.sendKeys(telephone);
}

public void enterPassword(String PasswordText) {
	
		passwordField.sendKeys(PasswordText);
}
	
public void enterConfirmField(String PasswordText) {
	
passwordConfirmField.sendKeys(PasswordText);
}
	
public void SelectPrivacyPolicy() {	
	privacypolicyField.click();
}


public AccountSucessPage ClickContinueButton() {
	
	continueButton.click();
	
	return new AccountSucessPage(driver);
}


public  void SelectNewsLetter() {
	
	YesNewsLetterOption.click();
}


public String retriveduplicateEmail() {
	String duplicateEmailtext=duplicateEmailAddresswarning.getText();
    return duplicateEmailtext;
}


public AccountSucessPage registerWithMandtoryFields(String firstName,String LastName, String emailText,String telephone,String PasswordText ) {


	firstNameField.sendKeys(firstName);
	LastNameField.sendKeys(LastName);
	EmailAddressfield.sendKeys(emailText);
	telephoneField.sendKeys(telephone);
	passwordField.sendKeys(PasswordText);
	passwordConfirmField.sendKeys(PasswordText);
	privacypolicyField.click();
	YesNewsLetterOption.click();
	continueButton.click();
	return new AccountSucessPage(driver);
	
}

public void displayStatusofWarning(String privacyPolicyWarning,String first) {
	
	
	
}
}