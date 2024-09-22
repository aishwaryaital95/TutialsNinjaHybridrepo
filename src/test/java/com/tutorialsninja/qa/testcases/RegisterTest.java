package com.tutorialsninja.qa.testcases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorials.qa.pages.AccountSucessPage;
import com.tutorials.qa.pages.HomePage;
import com.tutorials.qa.pages.RegisterPage;
import com.tutorials.qa.utils.Utils;
import com.tutrials.ninja.qa.base.Base;

public class RegisterTest extends Base { 
	
	RegisterPage registerpage;
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		loadprop();
		driver=initializebrowserOpenApplicationUrl(prop.getProperty("browser"));
	    
		/*driver.get("https://tutorialsninja.com/demo/");
	    driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    driver.findElement(By.linkText("Register")).click();	 */
	
		HomePage homepage= new HomePage(driver);
		homepage.clickOnMyAccount();
		//registerpage = homepage.navigateToRegisterPage();
		registerpage=homepage.selectRegisteroption();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority=1)
public void  verifyRegisterWithMandtoryFields() throws InterruptedException {
	
	
		/*RegisterPage registerpage=new RegisterPage(driver); 
		 
		registerpage.enterfirstName(dataprop.getProperty("firstname"));
		registerpage.enterLastName(dataprop.getProperty("lastname"));
		registerpage.enterEmailfield(Utils.generateTimeStamp());
		registerpage.entertelephoneField(dataprop.getProperty("telephoneNumber"));
		registerpage.enterPassword(prop.getProperty("ValidPassword"));
		registerpage.enterConfirmField(prop.getProperty("ValidPassword"));
		registerpage.SelectPrivacyPolicy();*/
		AccountSucessPage accountsuccesspage=registerpage.registerWithMandtoryFields(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"), Utils.generateTimeStamp(), dataprop.getProperty("telephoneNumber"), prop.getProperty("ValidPassword"));
		
		// AccountSucessPage accountsuccesspage =registerpage.ClickContinueButton(); 
		
		
		/*
	    driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
	    driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
	    driver.findElement(By.id("input-email")).sendKeys(Utils.generateTimeStamp());
	    Thread.sleep(9200);
	    driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephoneNumber"));
    driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
    driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("ValidPassword"));
   
    driver.findElement(By.name("agree")).click();
    driver.findElement(By.xpath("//input[@value='Continue']")).click(); */
   
	
		//AccountSucessPage accountsuccesspage=new AccountSucessPage(driver);
		//String actualHeading= accountsuccesspage.retriveAccountSuccessPageHeading();
		Assert.assertEquals(accountsuccesspage.retriveAccountSuccessPageHeading(),dataprop.getProperty("accountSuccessfullyCreatedheading"), "Your Account Has Been Created!");
		
		/*
		String actualSucesssheading= driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
    Assert.assertEquals(actualSucesssheading, "Your Account Has Been Created!","Your Account Has Been Created!");*/

    driver.quit();
}
	@Test(priority=2)
	public void verifyingallthefiledsbygivingallthefields() {
		
		//RegisterPage registerpage=new RegisterPage(driver); 
		
		/*
	    driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
	    driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
	    driver.findElement(By.id("input-email")).sendKeys(Utils.generateTimeStamp());
	    driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephoneNumber"));
	    driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
	    driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("ValidPassword"));
	    driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	    driver.findElement(By.name("agree")).click();
	    driver.findElement(By.xpath("//input[@value='Continue']")).click(); */
	   
	/*
		registerpage.enterfirstName(dataprop.getProperty("firstname"));
		registerpage.enterLastName(dataprop.getProperty("lastname"));
		registerpage.enterEmailfield(Utils.generateTimeStamp());
		registerpage.entertelephoneField(dataprop.getProperty("telephoneNumber"));
		registerpage.enterPassword(prop.getProperty("ValidPassword"));
		registerpage.enterConfirmField(prop.getProperty("ValidPassword")); */
		
		
		registerpage.registerWithMandtoryFields(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"), Utils.generateTimeStamp(), dataprop.getProperty("telephoneNumber"), prop.getProperty("ValidPassword"));
		
		/*AccountSucessPage accountsuccesspage=registerpage.registerWithMandtoryFields(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"), Utils.generateTimeStamp(), dataprop.getProperty("telephoneNumber"), prop.getProperty("ValidPassword"));
		registerpage.SelectNewsLetter();
		registerpage.SelectPrivacyPolicy();
		registerpage.ClickContinueButton();  */
		
		
	    //driver.findElement(By.xpath("//input[@value='Continue']")).click();
	    /*String actualSucesssheading= driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
	    Assert.assertEquals(actualSucesssheading, "Your Account Has Been Created!","Your Account Has Been Created!"); */

	    AccountSucessPage accountsuccesspage=new AccountSucessPage(driver);
		String actualHeading= accountsuccesspage.retriveAccountSuccessPageHeading();
		Assert.assertEquals(actualHeading,dataprop.getProperty("accountSuccessfullyCreatedheading"), "Your Account Has Been Created!");
		
	    driver.quit();	
	}
	@Test(priority=3)
	public void verifyingAccoundWithExisitingEmailAccount() {
	//RegisterPage registerpage=new RegisterPage(driver); 
	    
		/*
		driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
	    driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
	    driver.findElement(By.id("input-email")).sendKeys(dataprop.getProperty("validEmail"));
	    driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephoneNumber"));
	    driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
	    driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("ValidPassword"));
	    driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	    driver.findElement(By.name("agree")).click();
	    driver.findElement(By.xpath("//input[@value='Continue']")).click();  
	   
		registerpage.enterfirstName(dataprop.getProperty("firstname"));
		registerpage.enterLastName(dataprop.getProperty("lastname"));
		registerpage.enterEmailfield(dataprop.getProperty("validEmail"));
		registerpage.entertelephoneField(dataprop.getProperty("telephoneNumber"));
		registerpage.enterPassword(prop.getProperty("ValidPassword"));
		registerpage.enterConfirmField(prop.getProperty("ValidPassword"));
		registerpage.SelectNewsLetter();
		registerpage.SelectPrivacyPolicy();
		registerpage.ClickContinueButton(); 
		*/
		
		
		registerpage.registerWithMandtoryFields(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"), dataprop.getProperty("validEmail"), dataprop.getProperty("telephoneNumber"), prop.getProperty("ValidPassword"));
		
		

		
			String actualString=registerpage.retriveduplicateEmail();
	//String actualString=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText(); 
	Assert.assertTrue("Warning: E-Mail Address is already registered!",actualString.contains(dataprop.getProperty("duplicateEmailWarning")));  
	    
	
	//Assert.assertTrue("Warning: E-Mail Address is already registered!",actualString.contains(dataprop.getProperty("duplicateEmailWarning")));  
    
	    //String actualWarning=registerpage.retriveduplicateEmail();
//Assert.assertTrue("Warning: E-Mail Address is already registered!",actualWarning.contains(dataprop.getProperty("duplicateEmailWarning")));
	 //Assert.assertTrue(actualWarning.contains(dataprop.getProperty("duplicateEmailWarning")),"Warning: E-Mail Address is already registered!");   
	  //Assert.assertTrue(actualString.contains("Warning: E-Mail Address is already registered!" ));
	    driver.quit();
	}
}
