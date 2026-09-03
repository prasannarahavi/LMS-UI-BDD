package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverFactory;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.LogoutPage;
import Utilities.BaseLogger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepDef extends BaseLogger {

	WebDriver driver = DriverFactory.getDriver();
	LoginPage loginpage = new LoginPage(driver);
	HomePage homepage = new HomePage(driver);
	LogoutPage logoutpage = new LogoutPage(driver);
	
	@Given("Admin is in home page")
	public void admin_is_in_home_page() {
	   loginpage.LoginURL();
	   loginpage.DoLoginValidCredentials();
	   homepage.HomePageTitle();
	   log.info("Admin is in HomePage");
	}

	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
	    logoutpage.ClickLogoutButton();
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
	    boolean isLoginPageDisplayed = loginpage.isLoginPageDisplayed();
	    Assert.assertTrue(isLoginPageDisplayed);
	    log.info("Admin is redirected to login page : " + isLoginPageDisplayed );
	}
}
