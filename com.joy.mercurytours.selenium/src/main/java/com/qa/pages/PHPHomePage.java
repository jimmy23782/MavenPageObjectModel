package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.Utils.TestUtil;

public class PHPHomePage {

	protected WebDriver driver;
	
	@FindBy(xpath="//*[@id='Secondary_Navbar-Account']/a")
	WebElement HelloUserLink;
	@FindBy(xpath="//div[@id='primary-nav']/ul/li[2]/a")
	WebElement ServicesTab;
	@FindBy(linkText="Order New Services")
	WebElement OrderNewServicesOption;
	@FindBy(xpath="//*[@id='order-boxes']/div[3]/form/div[1]/div[3]/div/label/strong")
	WebElement AdvancePaymntOption;
	@FindBy(xpath="//*[@class='btn btn-primary btn-lg']")
	WebElement ContinueBtn;
	@FindBy(id="Primary_Navbar-Services-View_Available_Addons")
	WebElement ViewAvailableAddons;
	
	TestUtil TestUtil;
	
	public PHPHomePage( WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	public void VerfyLogin()
	{
		Assert.assertTrue(HelloUserLink.getText().contains("Jim"),"Assertion of  Login Failed");
		
	}
	public void ClickOnOrderNewservices()
	{driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
		ServicesTab.click();
		//TestUtil.waitForElement(OrderNewServicesOption);
		OrderNewServicesOption.click();
	}
	public void ViewAvailableAddons()
	{
		ServicesTab.click();
		ViewAvailableAddons.click();	
	}
	public void NewservicesAdvancePayment()
	{
		AdvancePaymntOption.click();
		ContinueBtn.click();
		ContinueBtn.click();
		
	}
	
	}
	
	
	
	

