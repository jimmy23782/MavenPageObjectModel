/*package com.qa.Tests;

import org.testng.annotations.Test;

import com.qa.base.myBaseClass;
import com.qa.pages.MercuryHomePage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class MercuryHomePageTest extends myBaseClass {
	
	private WebDriver driver;
	MercuryHomePage mercuryHomePage;
 
	@BeforeMethod
	 public void setUp() {
		System.out.println("inside before method of MercuryHomePageTest");
			driver =getDriver();
			mercuryHomePage = new MercuryHomePage(driver);			
		}
   @Test(priority=2,description="This TC is to countLinks")
  public void HomePageMercury() {
	  try {
		//MercuryHomePage mercuryHomePage = new MercuryHomePage(driver);
		  System.out.println("inside Test method of MercuryHomePageTest + priority=2");
		mercuryHomePage.CountLinkInMercuryHomePage();
		mercuryHomePage.ClickRegsterLink();
		mercuryHomePage.VerifyRegisterPage();
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
   @Test(priority=1,description="This TC is to verify Login")
   public void SignIn()
   {
	   System.out.println("inside Test method of MercuryHomePageTest + priority=1");
	   mercuryHomePage.VerifySignOnLink();
	   mercuryHomePage.SignIn(); 
	   //Assert.assertTrue(mercuryHomePage.VerifySignIn());
	  
	  
   }
   @AfterMethod
   public void WindUp()
   {
	   System.out.println("inside after method of MercuryHomePageTest");
   }
   
   
   
  

}
*/