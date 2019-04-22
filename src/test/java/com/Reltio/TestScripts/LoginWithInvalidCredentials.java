//Executing the Login Page

package com.Reltio.TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Reltio.CommonClasses.DriverClass;
import com.Reltio.CommonClasses.ExtentReportBase;
import com.Reltio.PageFactory.LoginPage;
import com.aventstack.extentreports.Status;

public class LoginWithInvalidCredentials extends ExtentReportBase {
	WebDriver driver;

	/**
	 * This test case will execute the LoginToReltio of the LoginPage by passing the
	 * user name and password
	 */
	@Test
	public void Login_With_Invalid_Credentials() throws Exception {
		test = extent.createTest("Login with Invalid Credentials");
		driver = DriverClass.getDriver();
		LoginPage objlogin = new LoginPage(driver);

		objlogin.loginWithInvalidCredentials();
		test.log(Status.PASS, "**** Invalid Credentials Verified ****");

	}

}
