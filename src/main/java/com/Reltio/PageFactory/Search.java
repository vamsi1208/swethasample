package com.Reltio.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Reltio.CommonClasses.BaseFunc;
import com.Reltio.CommonClasses.WaitClass;

public class Search {

	WebDriver driver;
	WebDriverWait wait;
	String entityType;
	String countParameter;
	String saveName;
	String countValue;
	static int searchIterator = 1;

	public enum EntityType {
		AllEntityTypes, Location, IDN, Company, HCO, GPO, HCP, Contact
	};

	static Map<String, String> comparatorMap = new HashMap<>();

	// Elements in Advance Search Menu

	private By searchButton = By.xpath("//div[@qxselectable='on'][text()='Search']");

	private By resetButton = By.xpath(".//div[text()='Search']/parent::div/following-sibling::div/div[text()='Reset']");
	private By advancedMenu = By.xpath(".//div[contains(text(),'Advanced')]");

	private By dynamicCheckbox(String entity) {
		return By.xpath(
				".//div[text()='" + entity + "' and @qxanonymous='true']/following-sibling::div[@qxanonymous='true']");
	}

	private By addressCriteria = By.xpath(
			".//div[text()='Address']/parent::div/following-sibling::div/div[@class='reltio-advanced-search-filter qx-reltio-input']");

	private By addressSelection = By.xpath("//div[text()='Address']/parent::div/following-sibling::div/div[2]");

	private By dynamicDropDownValue(String countParameter) {
		return By.xpath(".//div[contains(@data-reltio-id,'Address')]/div/div/div[@data-reltio-id='" + countParameter
				+ "']/div[1]");
	}

	private By addressCount = By
			.xpath("//div[text()='Address']/parent::div/following-sibling::div/div[2]/div/input[1]");

	// Elements to Saving Search Results section

	private By savedSearch = By.xpath("//div[text()='Saved Searches']");

	private By newName = By.xpath(
			"//input[@class='qx-abstract-field qx-placeholder-color reltio-saved-search-input qx-reltio-stringfield']");

	private By saveButton = By.xpath("//div[text()='Save']");

	private By closeButton = By.xpath("//div[text()='Saved Searches']/parent::div[1]/div[1]/div[1]");

	// Elements on the Saved Search Results section

	private By resultEntityType(String entityType) {
		return By.xpath("//div[contains(@class, 'reltio-search-facet-widget')]/div[text()='" + entityType + "']");
	}

	private By resultEntityTypeOn = By
			.xpath("//div[contains(@class, 'reltio-search-facet-widget')]/div[text()='Address']");

	private By resultEntityCountCriteria(String countParameter) {
		return By.xpath("//div[contains(@class, 'reltio-search-facet-widget')]/div[text()='"
				+ comparatorMap.get(countParameter) + "']");
	}

	private By resultEntityCount = By
			.xpath("//div[contains(@class, 'reltio-search-facet-widget')]/div[text()=':']/following-sibling::div[1]");

	public void advancedMenu(String entitytype, String countParameter, String countValue) throws InterruptedException {
		System.out.println("Beginning searchIterator" + searchIterator);
		// i = determineIterationforEntityType(entity type);
		System.out.println("After Function searchIterator" + searchIterator);

		By reset2Button = null;
		By search2Button = null;
		By dynCheckBox = null;
		By addrCriter = null;
		By addSelec = null;
		By dynamicDrp = null;
		By addCount = null;
		if (searchIterator > 1) {
			System.out.println("Beginning searchIterator" + searchIterator);

			reset2Button = By.xpath(
					"(.//div[text()='Search']/parent::div/following-sibling::div/div[text()='Reset'])[" + searchIterator + "]");
			search2Button = By.xpath("(.//div[@qxselectable='on'][text()='Search'])[" + searchIterator + "]");
			dynCheckBox = By.xpath("(.//div[text()='" + entitytype
					+ "' and @qxanonymous='true']/following-sibling::div[@qxanonymous='true'])[" + searchIterator + "]");
			addrCriter = By.xpath(
					"(.//div[text()='Address']/parent::div/following-sibling::div/div[@class='reltio-advanced-search-filter qx-reltio-input'])["
							+ searchIterator + "]");
			addSelec = By.xpath("(.//div[text()='Address']/parent::div/following-sibling::div/div[2])[" + searchIterator + "]");
			dynamicDrp = By.xpath("(.//div[contains(@data-reltio-id,'Address')]/div/div/div[@data-reltio-id='"
					+ countParameter + "']/div[1])[" + searchIterator + "]");
			addCount = By.xpath(
					"(.//div[text()='Address']/parent::div/following-sibling::div/div[2]/div/input[1])[" + searchIterator + "]");

		}
		this.entityType = entitytype;
		this.countParameter = countParameter;
		this.countValue = countValue;

		if (searchIterator == 1) {
			System.out.println("entitytype" + entitytype);

			BaseFunc.click(driver, advancedMenu, "Click on Advance");
			System.out.println("Clicked on Advance");

			WaitClass.preOfEleLocated(wait, searchButton);
			System.out.println("Found the   searchButton");

			WaitClass.preOfEleLocated(wait, resetButton);
			System.out.println("found  the reset button");

			BaseFunc.click(driver, resetButton, "resetButton");
			//Thread.sleep(5000);
			BaseFunc.click(driver, dynamicCheckbox(entityType), "dynamicCheckbox");

			//Thread.sleep(5000);
			System.out.println("clicked on the dynamicCheckbox");

			BaseFunc.click(driver, addressCriteria, "addressCriteria");
			// driver.findElement(addressCriteria).click();
			//Thread.sleep(2000);

			BaseFunc.click(driver, dynamicDropDownValue(countParameter), "countParameter");
			// driver.findElement(dynamicDropDownValue(countParameter)).click();

			// driver.findElement(dropDownValue).click();
			System.out.println("clicked on the addressCriteria");

			// dropDownValue
			driver.findElement(addressCount).sendKeys(countValue);
			//Thread.sleep(2000);
			System.out.println("clicked on the addressCount");

			BaseFunc.click(driver, searchButton, "Click on searchButton");
			System.out.println("hello clicked on search button");

		} else {

			System.out.println("entitytype" + entitytype);
			BaseFunc.click(driver, advancedMenu, "Click on Advance");
			System.out.println("Clicked on Advance");
			WaitClass.preOfEleLocated(wait, search2Button);
			System.out.println("Found the   search2Button");

		//	Thread.sleep(3000);
			WaitClass.preOfEleLocated(wait, reset2Button);
			System.out.println("found  the reset button");
			BaseFunc.click(driver, reset2Button, "reset2Button");
			//Thread.sleep(3000);
			BaseFunc.click(driver, dynCheckBox, "dynamicCheckbox");
			// driver.findElement(resetButton).click();
			Thread.sleep(3000);
			System.out.println("clicked on the dynamicCheckbox");

			driver.findElement(addrCriter).click();
			Thread.sleep(2000);
			driver.findElement(dynamicDrp).click();

			System.out.println("clicked on the addressCriteria");

			driver.findElement(addCount).sendKeys(countValue);
			Thread.sleep(2000);
			System.out.println("clicked on the addressCount");

			BaseFunc.click(driver, search2Button, "Click on search2Button");
			System.out.println("hello clicked on search button");

		}

		searchIterator++;

		
	}

	public void saveSearch(String saveName) throws InterruptedException {

		System.out.println("saveSearch");
		this.saveName = saveName;
		driver.findElement(savedSearch).click();
		Thread.sleep(3000);
		driver.findElement(newName).sendKeys(saveName);
		Thread.sleep(3000);
		driver.findElement(saveButton).click();
		Thread.sleep(3000);
		driver.findElement(closeButton).click();

	}

	public boolean savedSearchResultsVerification() throws InterruptedException {

		System.out.println("advancedMenuSearchButton");
		System.out.println(saveName);

		String count = driver.findElement(By.xpath("(//DIV[@qxselectable='on'])[19]")).getText();

		// int countInHeader = Integer.parseInt(count.split(":")[1].trim());

		List<WebElement> total_links = driver
				.findElements(By.xpath(".//div[@qxselectable='on']/div[text()='" + entityType + "']"));

		System.out.println("total_links" + total_links.size());
		if (count.contains(String.valueOf(total_links.size()))) {
			System.out.println("The search counts are matching");
		} else {
			System.out.println("The search counts are not matching");
		}

		String eCount = driver.findElement(resultEntityCount).getText();
		String eCountCriteria = driver.findElement(resultEntityCountCriteria(countParameter)).getText();
		String etype = driver.findElement(resultEntityType(entityType)).getText();
		String eTypeOn = driver.findElement(resultEntityTypeOn).getText();

		System.out.println("countValue " + countValue);
		System.out.println("eCountCriteria " + eCountCriteria);
		System.out.println("entityType " + entityType);

		System.out.println("resultEntityCount" + eCount);
		System.out.println("resultEntityCountCriteria" + eCountCriteria);
		System.out.println("resultEntityType" + etype);
		System.out.println("resultEntityTypeOn" + eTypeOn);

		System.out.println(countValue.trim().equalsIgnoreCase(eCount.trim()));
		// System.out.println(eCountCriteria.trim().equalsIgnoreCase(countParameter.trim()));
		System.out.println(entityType.trim().equalsIgnoreCase(etype.trim()));

		if (countValue.trim().equalsIgnoreCase(eCount.trim()) && entityType.trim().equalsIgnoreCase(etype.trim())) {
			return true;
		} else {
			return false;
		}

	}

	public Search(WebDriver driver) {
		intialitzeMap();
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);

	}

	private static void intialitzeMap() {
		comparatorMap.put("count.equals", "count equals"); 
		comparatorMap.put("count.not.equals", "count not equal"); 
		comparatorMap.put("count.less", "count less"); 
		comparatorMap.put("count.less.or.equals", "count less or equal");
		comparatorMap.put("count.greater", "count greater"); 
		comparatorMap.put("count.greater.or.equals", "count greater or equal");

	}

}
