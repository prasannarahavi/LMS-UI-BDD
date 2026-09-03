package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import Utilities.BaseLogger;
import Utilities.ConfigReader;
import Utilities.ElementsUtil;

public class HomePage extends BaseLogger {
	 WebDriver driver = DriverFactory.getDriver();
	 ElementsUtil elementsUtil = new ElementsUtil(driver);
	 String url = ConfigReader.getProperty("baseurl");
	 
	//1. Private By Locators:
	 private By HomePage = By.xpath("//span[contains(text(), ' LMS - Learning Management System ')]");
	 
	//2. Contructor of the Page Class
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.elementsUtil = new ElementsUtil(driver);
	} 
	
	public String HomePageTitle()
	{
		return elementsUtil.doGetText(HomePage);
	}
}
