/**
 * Name: Dashboard.java
 * Description: Verifying the Login is Successful or not and Clicking on the Search Menu 
 * @author Srihari and Swethana
 * @version 1.0.0
*/

package com.Reltio.PageFactory;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Reltio.CommonClasses.WaitClass;

public class DashBoard {
	/*
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

	@FindBy(xpath = "//div[contains(text(),'DASHBOARD')]")
	WebElement Dashboard_Menu;

	@FindBy(xpath = "//DIV[@qxselectable='off'][text()='SEARCH']")
	WebElement Search_Menu;

	// Constructor to Initialize the WebElements
	public DashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Verify if Dash board Menu is present
	public void verifyLogin() {
		WebDriverWait wait = new WebDriverWait(driver, 65);
		//WaitClass.preOfEleLocated(wait, byPath);
		wait.until(ExpectedConditions.elementToBeClickable(Dashboard_Menu));
		assertEquals("DASHBOARD", Dashboard_Menu.getText(), "Login is not Successful");
	}

	// Click on the Search Menu
	public void clickOnSearchMenu() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(Search_Menu));
		Search_Menu.click();
		// assertEquals(Advanced_Link, expected, message);
	}

}
