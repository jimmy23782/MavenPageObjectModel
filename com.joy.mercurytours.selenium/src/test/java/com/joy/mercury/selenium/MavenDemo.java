package com.joy.mercury.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class MavenDemo {
  @Test
  public void First() {
	  
	  System.out.println("My First maven Program");
  }
  
  @Test
  public void Sum() {
	  System.out.println("my Second Maven Program is summation");
	  int a = 150;
	  int b = 100;
	  Assert.assertEquals(250, a+b);
	  
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
