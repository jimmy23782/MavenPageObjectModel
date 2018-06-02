package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.qa.Utils.MyListner;
//import com.pack.config.Configuration;
import com.qa.Utils.TestUtil;

public class myBaseClass {
	//private  WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventFiringWebDriver;
	public static MyListner myListnerClass;
	public myBaseClass() {
		prop = new Properties();

		FileInputStream fi;
		try {
			fi = new FileInputStream(
					"D:\\GitWorkspace\\MavenPageObjectModel\\com.joy.mercurytours.selenium\\src\\main\\java\\com\\qa\\config\\config.property");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static WebDriver setDriver() {
		WebDriver driver = null;
		String Browsername = prop.getProperty("Browser");
		String URL3 = prop.getProperty("URL1");
		switch (Browsername) {
		case "chrome": {
			String driverPath = prop.getProperty("ChromeDriver");
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			//Reporter.log("running test"+ );
			break;
		}

		case "FF": {
			System.out.println("Firefx");
			//String driverPathfirefox = prop.getProperty("ChromeDriver");
			// System.setProperty("webdriver.chrome.driver", driverPathfirefox);
			// driver = initChromeDriver(URL2);
		}
		}
		// WebDriver driver = new ChromeDriver();
		eventFiringWebDriver = new EventFiringWebDriver(driver);
		myListnerClass= new MyListner();
		eventFiringWebDriver.register(myListnerClass);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_Time_out, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
		driver.get(URL3);
		
		
		// return driver;

		return driver;

	}

}
