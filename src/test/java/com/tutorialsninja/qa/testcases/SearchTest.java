package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorials.qa.pages.HomePage;
import com.tutorials.qa.pages.SearchPage;
import com.tutrials.ninja.qa.base.Base;

public class SearchTest extends Base{

	
	SearchPage searchpage;
	HomePage homepage;
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		loadprop();
		driver=initializebrowserOpenApplicationUrl("chrome");	
		 homepage=new HomePage(driver);
	}
	
	public void teardown() {
	driver.quit();	
	}
	@Test(priority=1)
	public void verifysearchWithValidProduct() {
		
	/*
		homepage.enterProductIntoSearchBoxSearch(dataprop.getProperty("ValidProduct"));
		
		homepage.Clicksearchbutton();
		//driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("ValidProduct"));
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();	
		*/
		 searchpage= new SearchPage(driver);
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	
		 
		 homepage.searchForAproduct(dataprop.getProperty("ValidProduct"));
		
		Assert.assertTrue(searchpage.displayStatusOfHPValidProduct(),"Valid product HP is not displayed in the search results");
	
		driver.quit();}
	@Test(priority=2)
	public void verifySearchWithInvalid() {
		/*driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("invalidProduct"));
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();	 
		
		
		homepage.searchForAproduct(dataprop.getProperty("invalidProduct"));*/
		
		 //searchpage= new SearchPage(driver);
//String actualSearchmsg=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();

//String actualSearchmsg=searchpage.retriveNoproductMessageText();
		homepage.enterProductIntoSearchBoxSearch(dataprop.getProperty("invalidProduct"));
searchpage=homepage.Clicksearchbutton();
		//homepage.searchForAproduct(dataprop.getProperty("invalidProduct"));
Assert.assertEquals(searchpage.retriveNoproductMessageText(),dataprop.getProperty("NoProductSeacrhTextInSearchResult"),"No product in search results is displyed");
driver.quit();
		
		//Assert.assertEquals(actualSearchmsg,dataprop.getProperty("NoProductSeacrhTextInSearchResult"),"No product in search results is displyed");
		
		
	}
	@Test(priority=3,dependsOnMethods= {"verifysearchWithValidProduct","verifySearchWithInvalid"})
	public void verifySearchWithoutAnyproduct() {
		
		
		searchpage =homepage.Clicksearchbutton();
		//String actualSearchmsg=searchpage.retriveNoproductMessageText();
		
		/*driver.findElement(By.name("search")).sendKeys("");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();	
		String actualSearchmsg=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText(); */
		
		Assert.assertEquals(searchpage.retriveNoproductMessageText(),dataprop.getProperty("NoProductSeacrhTextInSearchResult"),"No product in search results is displyed");
		driver.quit();

}
	

}