package com.Reltio.CommonClasses.copy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class WaitClass {
	
	WebDriver driver;

	 WebDriverWait wait = new WebDriverWait( driver, 80);
	 
	public static WebDriverWait waitRet(WebDriver driver)
	{
		WebDriverWait wait;
		return wait = new WebDriverWait( driver, 80);
	}

	public static void 	waitforSeconds(double d) throws Exception 
	{
		Thread.sleep((long) (d*1000));
	}

	public static void setImplicitWait(WebDriver driver, long d)
	{
		driver.manage().timeouts().implicitlyWait(d, TimeUnit.SECONDS);
	}
	
	public static void preOfEleLocated(WebDriverWait wait , By byPath) throws InterruptedException
	{	
		wait.until(ExpectedConditions.presenceOfElementLocated(byPath));
	}

	/*	public static void preOfEleLocated(WebDriverWait wait , WebElement ele)
	{
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	 */

	public static void visibilityOfEle(WebDriverWait wait , WebElement ele)
	{
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void visibilityOfEle(WebDriverWait wait,By byPath)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(byPath));
	}

	public static void invisibilityOfEle(WebDriverWait wait, By byPath)
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byPath));
	}

	public static void ele2bClickable(WebDriverWait wait , WebElement ele)
	{
		visibilityOfEle(wait, ele);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void ele2bClickableAndClick(WebDriverWait wait , WebElement ele, String elementName)
	{
		visibilityOfEle(wait, ele);
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		Reporter.log(elementName + " element clicked");
	}

	public static void ele2bClickable( WebDriverWait wait , By byPath) throws InterruptedException
	{
		preOfEleLocated(wait, byPath);
		wait.until(ExpectedConditions.elementToBeClickable(byPath));
	}
	
	public static void ele2bClickableAndClick( WebDriverWait wait , By byPath, String elementName) throws InterruptedException
	{
		
		preOfEleLocated(wait, byPath);
		wait.until(ExpectedConditions.elementToBeClickable(byPath)).click();
		//Reporter.log(elementName + " element clicked");
	}

	public static void preOfAlert(WebDriver driver,WebDriverWait myWaitVar) throws Exception
	{
		myWaitVar.until(ExpectedConditions.alertIsPresent());
		WaitClass.waitforSeconds(0.5);
	}
}
