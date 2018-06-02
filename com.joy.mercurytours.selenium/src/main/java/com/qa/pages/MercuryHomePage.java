package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.regexp.recompile;
import org.eclipse.jetty.util.security.Password;
//import org.openqa.jetty.html.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.myBaseClass;

public class MercuryHomePage {
	@FindBy(linkText = "REGISTER")	 
	WebElement RegisterLink;
	
	@FindBy(linkText = "SIGN-ON")	 
	WebElement SignOnLink;
	
	
	@FindBy(name="userName")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="login")
	WebElement SignInBtn;
	@FindBy(linkText="SIGN-OFF")
	WebElement SignOffLink;
	
	
	
	
	protected WebDriver driver;
		
	public MercuryHomePage(WebDriver driver) //throws Exception
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public boolean VerifySignOnLink() {
		return SignOnLink.isDisplayed();
	}
	public void CountLinkInMercuryHomePage() {
		//driver.findElement(SignOnLink).click();;
		List<WebElement> Links  = new ArrayList<WebElement>();
		 Links =driver.findElements(By.tagName("a"));
		for(int i=0;i<Links.size();i++)
		{
			//System.out.println("Links are "+ Links.get(i).getText());
		}
		System.out.println("total link in this page is"+Links.size());
	}
	
	public void ClickRegsterLink() {
		System.out.println("clicking on Regiter link");
		RegisterLink.click();
	}	
	public void SignIn()
	{
		//driver.findElement(By.name("userName")).sendKeys("hello");
		SignOnLink.click();
		userName.sendKeys("ass");
		password.sendKeys("ass");
		SignInBtn.click();
	}
	public boolean VerifySignIn()
	{
		
		return SignOffLink.isDisplayed(); 
		//Assert.assertTrue(mercuryHomePage.VerifyRegisterPage(), "Register: Mercury Tours");
	}
	
	public boolean VerifyRegisterPage() {
		String expectedPageTitle="Register: Mercury Tours";
		String title = driver.getTitle();
		return title.contains(expectedPageTitle);
	
	}
}
