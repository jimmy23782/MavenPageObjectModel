package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.Utils.TestUtil;

public class LoginPage {
	protected WebDriver driver;
	
	@FindBy(id="inputEmail")
	WebElement userName;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//*[@name='rememberme']")
	WebElement RememberMeChkBox;	
	@FindBy(id="login")
	WebElement LoginBtn;
	@FindBy(linkText="Forgot Password?")
	WebElement ForgotPassword;
	@FindBy(xpath="//div[@class='header-lined']/h1")
	WebElement forgotPasswordHeader;
	@FindBy(xpath="//img[@alt='PHPTRAVELS']")
	WebElement PHPTravelsLogo;
	
	TestUtil TestUtil;
	
	public LoginPage( WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	public PHPHomePage Login(String username,String pwd)
	{
		userName.sendKeys(username);
		password.sendKeys(pwd);
		RememberMeChkBox.click();
		LoginBtn.click();
		return new PHPHomePage(driver);
	}
	
	
	public void ClickForgotPasswordLink()
	{
		ForgotPassword.click();
	}
	public void VerifyForgotPassword()
	{
	
		//TestUtil
		//TestUtil.waitForElement(forgotPasswordHeader);
		forgotPasswordHeader.getText().contains("Lost Password Reset");
		Assert.assertTrue(forgotPasswordHeader.getText().contains("Lost Password Reset"), "Lost Password Reset Page Not Found");
		//PHPTravelsLogo.click();
	}
	
	
	public String VerifyLoginPageTitle()
	{
		System.out.println( "title of the page is "+driver.getTitle());
		
		return driver.getTitle();
	}
	}
	
	
	
	
	
	
