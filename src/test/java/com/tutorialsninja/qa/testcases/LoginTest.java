package com.tutorialsninja.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorials.qa.pages.AccountPage;
import com.tutorials.qa.pages.HomePage;
import com.tutorials.qa.pages.Loginpage;
import com.tutorials.qa.utils.Utils;
import com.tutrials.ninja.qa.base.Base;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class LoginTest extends Base{

	
	Loginpage loginPage;
	
	public WebDriver driver;
	@BeforeMethod
	public void setUp() {
	
		loadprop();
		driver=initializebrowserOpenApplicationUrl(prop.getProperty("browser"));
		HomePage homepage=new HomePage(driver);
		loginPage=homepage.navigateToLoginOption();
	    
		/*homepage.clickOnMyAccount();
	    homepage.selectLoginOption();
		
		    driver.findElement(By.xpath("//span[text()='My Account']")).click();
		    driver.findElement(By.linkText("Login")).click();	*/
	}
	@AfterMethod
	public void terDown() {
		driver.quit();
	}
@Test(priority=1, dataProvider="supplyTestData")
public void verifyLoginWithvalidCrediantials(String email,String password) {
	
	
    //driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("ValidEmail"));
    //Loginpage loginPage=new Loginpage(driver);
   AccountPage accountPage = loginPage.login(email, password);
	/*
	loginPage.enterEmailAddress(email);
    loginPage.enterPassword(password); */
    //AccountPage accountPage=loginPage.ClickonLogin();
    
    //AccountPage accountPage=new AccountPage(driver);
    
    /*driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
    driver.findElement(By.xpath("//input[@value='Login']")).click(); */
    
    Assert.assertTrue(accountPage.getDisplayStatus(),"Edit your account information");

}
@DataProvider(name="supplyTestData")
public Object[][] supplyTestData() {
	Object[][] data= Utils.getdatafromexcel("Login");
	return data;
} 

@Test(priority=2)
public void verifyLoginWithInvalidCredentials() {
	
	
	//Loginpage login=new Loginpage(driver);
	loginPage.login(Utils.generateTimeStamp(),dataprop.getProperty("invalidPassword"));
	/*
	loginPage.enterEmailAddress(Utils.generateTimeStamp(),dataprop.getProperty("invalidPassword"));
	
	loginPage.enterPassword(dataprop.getProperty("invalidPassword"));
    //driver.findElement(By.id("input-email")).sendKeys(Utils.generateTimeStamp());
    //driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
    //driver.findElement(By.xpath("//input[@value='Login']")).click(); */
    
	
    //String actualWarningmsg=loginPage.retriveWarningmsgnotMatching();	
    //String expectedWarningMsg=dataprop.getProperty("emailPasswordNoMatchWarning");
    Assert.assertTrue(loginPage.retriveWarningmsgnotMatching().contains(dataprop.getProperty("emailPasswordNoMatchWarning")),"expected warning sg is not displyed");
    driver.quit();
}




@Test(priority=3)
public void verifyLoginWithInvalidEmailAndValidPassword() {
	
    /*driver.findElement(By.id("input-email")).sendKeys(Utils.generateTimeStamp());
    driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
    driver.findElement(By.xpath("//input[@value='Login']")).click(); */
	
	loginPage.login(Utils.generateTimeStamp(),prop.getProperty("ValidPassword"));
	/*
	Loginpage login=new Loginpage(driver);
	login.enterEmailAddress(Utils.generateTimeStamp());
	login.enterPassword(dataprop.getProperty("validPassword"));
	login.ClickonLogin();*/
	
    
	 /*String actualWarningmsg=loginPage.retriveWarningmsgnotMatching();	
	    String expectedWarningMsg=dataprop.getProperty("emailPasswordNoMatchWarning");
	  Assert.assertTrue(actualWarningmsg.contains(expectedWarningMsg),"expected warning sg is not displyed"); */

	  Assert.assertTrue(loginPage.retriveWarningmsgnotMatching().contains(dataprop.getProperty("emailPasswordNoMatchWarning")),"expected warning sg is not displyed");


}
@Test(priority=4)
public void verifyLoginWithvalidEmailAndInValidPassword() {
	
   /* driver.findElement(By.id("input-email")).sendKeys(Utils.generateTimeStamp());
    driver.findElement(By.id("input-password")).sendKeys("12345555");
    driver.findElement(By.xpath("//input[@value='Login']")).click();*/
	loginPage.login(prop.getProperty("ValidPassword"),dataprop.getProperty("invalidPassword"));
	/*Loginpage login=new Loginpage(driver);
    login.enterEmailAddress(dataprop.getProperty("validEmail"));
	login.enterPassword(dataprop.getProperty("validPassword"));
	login.ClickonLogin(); */
    
	 //String actualWarningmsg=loginPage.retriveWarningmsgnotMatching();
    //String expectedWarningMsg=dataprop.getProperty("emailPasswordNoMatchWarning");
    Assert.assertTrue(loginPage.retriveWarningmsgnotMatching().contains(dataprop.getProperty("emailPasswordNoMatchWarning")),"expected warning sg is not displyed");
    driver.quit();
}
@Test(priority=5)
public void verifyLoginWithoutProvidingCredials() {
	
    /*driver.findElement(By.id("input-email")).sendKeys("aishkm9598@gmail.com");
    driver.findElement(By.id("input-password")).sendKeys("12344556");
    driver.findElement(By.xpath("//input[@value='Login']")).click(); */
    
	loginPage.ClickonLogin();
	/*
    String actualWarningmsg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();	
    String expectedWarningMsg=dataprop.getProperty("emailPasswordNoMatchWarning"); 
    
	String actualWarningmsg=loginPage.retriveWarningmsgnotMatching();
	String expectedWarningMsg=dataprop.getProperty("emailPasswordNoMatchWarning");*/
	
    Assert.assertTrue(loginPage.retriveWarningmsgnotMatching().contains(dataprop.getProperty("emailPasswordNoMatchWarning")),"expected warning sg is not displyed");
driver.close();

}


public static String generateEmailTimeStamp() {
	Date date= new Date();
	String stamp= date.toString().replace(" ","_").replace(":","_");
	 return "amotori"+stamp+"@gmail.com";
}
}








//div[contains(@class,'alert-dismissible')]
