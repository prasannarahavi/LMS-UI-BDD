package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import Utilities.BaseLogger;
import Utilities.ConfigReader;
import Utilities.ElementsUtil;

public class LogoutPage extends BaseLogger {

	 WebDriver driver = DriverFactory.getDriver();
	 ElementsUtil elementsUtil = new ElementsUtil(driver);
	 String url = ConfigReader.getProperty("baseurl");
	 
	//1. Private By Locators:
	 
	 private By LogoutButton = By.xpath("//button[@id = 'logout']");
	 
	//2. Contructor of the Page Class
		public LogoutPage(WebDriver driver) {
			this.driver = driver;
			this.elementsUtil = new ElementsUtil(driver);
		} 
		
	  public void ClickLogoutButton()
	  {
		  elementsUtil.doClick(LogoutButton);
	  }
}
