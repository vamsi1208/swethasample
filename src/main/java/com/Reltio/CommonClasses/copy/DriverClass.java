// BaseClass to launch browser

package com.Reltio.CommonClasses.copy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverClass
{
	// Initializing the WebDriver
	public static WebDriver driver=null;
	
	private DriverClass(){};
	
	// Launching the Browser and Passing the URL
	public static WebDriver getDriver()
	
	
	{
		try
		{
			if(driver==null)
			{
				System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\Drivers\\chromedriver.exe");
				//driver=new ChromeDriver();
				
				ChromeOptions Chr_obj = new ChromeOptions();    
				Chr_obj.addArguments("disable-infobars");

				driver = new ChromeDriver(Chr_obj);
				
				Read_PropertyFile obj_url = new Read_PropertyFile();
				
				driver.get(obj_url.passurl());

				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			}
		}
		catch(Exception e)
		{
			System.out.println("Cannot create the Webdriver Instance"+e.getMessage());
		}
		return driver;
		
	}

}
