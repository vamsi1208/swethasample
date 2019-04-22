package com.Reltio.TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Reltio.CommonClasses.DriverClass;
import com.Reltio.CommonClasses.ExtentReportBase;
import com.Reltio.PageFactory.Search;
import com.aventstack.extentreports.Status;

public class TestSearch extends ExtentReportBase {

	WebDriver driver = DriverClass.getDriver();

	@Test(dataProvider = "SearchProvider", dataProviderClass = DataproviderClass.class)
	public void launchSearch(String entityType, String countParameter, String countValue, String saveName) {

		try {

			Search search = new Search(driver);
			search.advancedMenu(entityType, countParameter, countValue);
			// test = extent.createTest("advancedMenu", "Successfully clicked on the Advance
			// Menu");
			System.out.println("advancedMenu");

			System.out.println("trying save search");

			search.saveSearch(saveName);
			// test = extent.createTest("saveSearch", "Successfully Saved the Search Name");

			if (search.savedSearchResultsVerification()) {
				test = extent.createTest("Verification of Search Results and saved search",
						"The Values passed from the test and values  on the Screen are mathching for " +entityType+"   "  
								+countParameter +"   "+countValue +"   "+saveName+"   " );
				Assert.assertTrue(true);
			} else {
				test = extent.createTest("Verification of Save Results",
						"The Values passed from the test and values  on the Screen are not matching" +entityType+"   "  
								+countParameter +"   "+countValue +"   "+saveName+"   " );
				Assert.assertTrue(false);
			}
			test.log(Status.PASS, "**** Advanced Search Results and Saved Search are  Verified ****");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
