package com.qa.Tests;

import org.testng.annotations.Test;

import com.qa.Utils.TestUtil;
import com.qa.base.myBaseClass;
import com.qa.pages.LoginPage;
import com.qa.pages.MercuryHomePage;
import com.qa.pages.PHPHomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class PHPLoginTest extends myBaseClass {
	
	private WebDriver driver;
	LoginPage loginPage;
	PHPHomePage  PHPHomePage;
	
 
	@BeforeMethod
	 public void setUp() {
		System.out.println("inside before method of PHPLoginTest");
			driver =setDriver();
			loginPage = new LoginPage(driver);	
			
		}
   @Test(priority=2,description="This TC is to  Login and verify",dataProvider="getLoginCredentials")
   public void login(String username,String pwd)
   {  Reporter.log(driver.getWindowHandle());
	   System.out.println("inside after method of verify Login");
	   Assert.assertEquals("Client Area - PHPTRAVELS", loginPage.VerifyLoginPageTitle());
	   PHPHomePage =loginPage.Login(username,pwd);
	   PHPHomePage.VerfyLogin(); 
   }
   @Test(priority=1,description="This TC is to  Forgot Password")
   public void ForgotPassword()
   {   driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
	   Assert.assertEquals("Client Area - PHPTRAVELS", loginPage.VerifyLoginPageTitle());
	   loginPage.ClickForgotPasswordLink();
	   loginPage.VerifyForgotPassword();
	   
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
	    Reporter.log(driver.getWindowHandle());
	   driver.quit();
	   System.out.println("inside after method of MercuryHomePageTest");
   }
   

}
