/**
 * Name: LoginPage.java
 * Description: Creating Methods for the Login Page(includes: Username, Password and Login button)
 * @author Srihari and Swethana
 * @version 1.0.0
*/

package com.Reltio.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Reltio.CommonClasses.Excel_Reader;
import com.Reltio.CommonClasses.Read_PropertyFile;

public class LoginPage {

	/*
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button/span[contains(text(),'Log in')]")
	WebElement loginButton;

	@FindBy(linkText = "Forgot your password?")
	WebElement forgotPasswordLink;

	@FindBy(partialLinkText = "Privacy")
	WebElement privacyPolicyLink;

	// Constructor to Initialize the WebElements
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Set user name in text box
	public void setUsername(String strUsername) {
		try {
			username.sendKeys(strUsername);
		} catch (Exception e) {
			// TODO: handle exception

		}

	}

	// Set password in password text box
	public void setPassword(String strPassword) {
		try {
			password.sendKeys(strPassword);
		} catch (Exception e) {
			// TODO: handle exception

		}

	}

	// Click on login button
	public void clickLogin() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
	}

	// Login with Invalid Credentials
	public void loginWithInvalidCredentials() throws Exception {
		Read_PropertyFile prop = new Read_PropertyFile();

		for (int loginiterator = 2; loginiterator <= 5; loginiterator++) {
			try {
				String Username = Excel_Reader.getCellData(prop.excelFile(), prop.loginSheet(), loginiterator, 0);
				String Password = Excel_Reader.getCellData(prop.excelFile(), prop.loginSheet(), loginiterator, 1);
				this.loginToReltio(Username, Password);

				if (loginiterator == 4) {

					driver.findElement(By
							.xpath(Excel_Reader.getCellData(prop.excelFile(), prop.loginSheet(), loginiterator, 3).split("\n")[0]))
							.getText();

					String actual = driver.findElement(By.xpath(
							(Excel_Reader.getCellData(prop.excelFile(), prop.loginSheet(), loginiterator, 3).split("\n"))[0]))
							.getText()
							+ "\n" + driver
									.findElement(By.xpath((Excel_Reader
											.getCellData(prop.excelFile(), prop.loginSheet(), loginiterator, 3).split("\n"))[1]))
									.getText();
					assertEquals(actual, Excel_Reader.getCellData(prop.excelFile(), prop.loginSheet(), loginiterator, 2));
					System.out.println(Excel_Reader.getCellData(prop.excelFile(), prop.loginSheet(), loginiterator, 2));

				} else {
					assertEquals(driver
							.findElement(By.xpath(Excel_Reader.getCellData(prop.excelFile(), prop.loginSheet(), loginiterator, 3)))
							.getText(), Excel_Reader.getCellData(prop.excelFile(), prop.loginSheet(), loginiterator, 2));

				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		assertEquals(driver.findElement(By.xpath(Excel_Reader.getCellData(prop.excelFile(), prop.loginSheet(), 5, 3)))
				.getText(), Excel_Reader.getCellData(prop.excelFile(), prop.loginSheet(), 5, 2));
	}

	// Login with Valid Credentials
	public void loginWithValidCredentials() {
		Read_PropertyFile prop = new Read_PropertyFile();

		try {
			String Username = Excel_Reader.getCellData(prop.excelFile(), prop.loginSheet(), 7, 0);
			String Password = Excel_Reader.getCellData(prop.excelFile(), prop.loginSheet(), 7, 1);
			this.loginToReltio(Username, Password);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	// Clear the User name and Password fields
	public void clearValues() {
		username.clear();
		password.clear();
	}

	/**
	 * 
	 * This POM method will be exposed in test case to login in the application
	 * 
	 * @param strUsername
	 * 
	 * @param strPassword
	 * 
	 * @return
	 * 
	 */
	public void loginToReltio(String strUsername, String strPassword) {
		this.clearValues();
		this.setUsername(strUsername);
		this.setPassword(strPassword);
		this.clickLogin();

	}

}
