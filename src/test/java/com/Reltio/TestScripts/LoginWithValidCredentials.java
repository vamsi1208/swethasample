package com.Reltio.TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Reltio.CommonClasses.DriverClass;
import com.Reltio.CommonClasses.ExtentReportBase;
import com.Reltio.PageFactory.LoginPage;
import com.Reltio.PageFactory.DashBoard;
import com.aventstack.extentreports.Status;

public class LoginWithValidCredentials extends ExtentReportBase {
	WebDriver driver;

	/**
	 * This test case will execute the LoginToReltio of the LoginPage by passing the
	 * user name and password
	 */
	@Test
	public void Login_With_Valid_Credentials() throws Exception {
		test = extent.createTest("Login With Valid Credentials");
		driver = DriverClass.getDriver();
		LoginPage obj = new LoginPage(driver);

		obj.loginWithValidCredentials();

		DashBoard Dobj = new DashBoard(driver);
		Dobj.verifyLogin();
		test.log(Status.PASS, "**** Login Passed ****");

		Dobj.clickOnSearchMenu();

	}
}
