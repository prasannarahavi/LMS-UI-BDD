package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import Utilities.BaseLogger;
import Utilities.ConfigReader;
import Utilities.ElementsUtil;

public class LoginPage extends BaseLogger {
   
	 WebDriver driver = DriverFactory.getDriver();
	 ElementsUtil elementsUtil = new ElementsUtil(driver);
	 String url = ConfigReader.getProperty("baseurl");
	 
	 //1. Private By Locators:
	 private By LandingLoginPage = By.xpath("//div[@class = 'signin-content']");
	 private By onLoginPage = By.xpath("//p[contains(text(), 'Please login to LMS application')]");
	 private By Username = By.xpath("//input[@id='username']");
	 private By Password = By.xpath("//input[@id='password']");
	 private By SelectRole = By.xpath("//div[@id='mat-select-value-1']//span[contains(text(),'Select the role')]");
	 private By RoleName = By.xpath("//span[contains(text(), ' Admin ')]");
	 private By Loginbutton = By.xpath("//button[@id='login']");
	 private By HomePage = By.xpath("//span[contains(text(), ' LMS - Learning Management System ')]");
	 
	 //2. Contructor of the Page Class
	 public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        this.elementsUtil = new ElementsUtil(driver);
	    } 
	 
	 public void LoginURL()
	 {
		 driver.get(url);      
	 }
	 
	 public void OnLoginPage()
	 {
		 elementsUtil.waitForElementsToBeVisible(onLoginPage);
	 }
	 	
	 public boolean isLoginPageDisplayed()
	 {
		 return elementsUtil.isElementDisplayed(LandingLoginPage);
	 }
	 //3. Actions for the Page Class
	 
	 public void EnterUsername()
	 {
		    elementsUtil.doSendKeys(Username, "Lmshackathon@gmail.com");	        
	 }
	 
	 public void EnterPassword()
	 {
		 elementsUtil.doSendKeys(Password, "lmsAug@2026");
	        
	 }
	 
	 public void ClickSelectRole()
	 {
		 elementsUtil.doClick(SelectRole);	        
	 }
	 
	 public void SelectRole()
	 {
		 elementsUtil.doClick(RoleName);
	        
	 }
	 
	 public void ClickLogin()
	 {
		 elementsUtil.doClick(Loginbutton);
	 }
	 
	 public String OnHomePage()
	 {
		 return elementsUtil.doGetText(HomePage);
	 }
	 
	 public void DoLoginValidCredentials()
	 {
		 elementsUtil.doSendKeys(Username, "Lmshackathon@gmail.com");
	     elementsUtil.doSendKeys(Password, "lmsAug@2026");
	     elementsUtil.doClick(SelectRole);
	     elementsUtil.doClick(RoleName);
	     elementsUtil.doClick(Loginbutton);
	 }
	 	 	 
	 
}
