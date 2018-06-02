/*
 * Author Jimmy
 * 
 * */

package com.qa.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Utils.TestUtil;
import com.qa.base.myBaseClass;
import com.qa.pages.LoginPage;
import com.qa.pages.PHPHomePage;

public class PHPHomePageTest extends myBaseClass{
	private WebDriver driver;
	LoginPage loginPage;
	PHPHomePage  PHPHomePage;
	
 
	@BeforeMethod()
	 public void setUp() {
		System.out.println("inside before method of PHPLoginTest");
			driver =setDriver();
			loginPage = new LoginPage(driver);
			PHPHomePage = new PHPHomePage(driver);
			
			//Assert.assertEquals("Client Area - PHPTRAVELS", loginPage.VerifyLoginPageTitle());
			  
			
		}
   @Test(priority=1,description="This TC is to verify Login",dataProvider="getLoginCredentials")
   public void OrderNewServices(String username,String pwd)
   {
	   PHPHomePage =loginPage.Login(username,pwd);
	   System.out.println("inside after method of Home Page");
	   PHPHomePage.ClickOnOrderNewservices();
	   PHPHomePage.NewservicesAdvancePayment();
   }
   @Test(description="This TC is to verify Login",dataProvider="getLoginCredentials")
   public void ProductAdOns(String username,String pwd)
   { PHPHomePage =loginPage.Login(username,pwd);
	   PHPHomePage.ViewAvailableAddons();
   }
   
   @DataProvider
   public Object[][] getLoginCredentials()
   {
	   Object data [][]=TestUtil.getTestData("Sheet1");
	   return data;
	   
   }
   
   @AfterMethod
   public void WindUp()
   {
	  driver.quit();
	   System.out.println("inside after method of MercuryHomePageTest");
   }
   
   
}
