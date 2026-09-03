package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import DriverFactory.DriverFactory;
import Pages.LoginPage;
import Utilities.BaseLogger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef extends BaseLogger {

	WebDriver driver = DriverFactory.getDriver(); // Fetches the current WebDriver instance (browser session) from the DriverFactory 
	                                              // utility class, so this class can interact with the same browser used across the framework.

    LoginPage loginpage = new LoginPage(driver); // Creates an object of the LoginPage class, passing the driver reference into it.
                                                 // This gives 'loginpage' access to all locators and actions defined in LoginPage 
                                                 // (e.g., EnterUsername, EnterPassword, ClickLogin).
    
	@Given("Admin is on the browser")
	public void admin_is_on_the_browser() {
		driver = DriverFactory.getDriver();
	}

	@When("Admin enters the Valid LMS app URL")
	public void admin_enters_the_valid_lms_app_url() {
		loginpage.LoginURL();
	    
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
	   boolean isLoginPageDisplayed = loginpage.isLoginPageDisplayed();
	   Assert.assertTrue(isLoginPageDisplayed);
	   log.info("Login is displayed : "+ isLoginPageDisplayed);
	    
	}
	
	@Given("Admin is on login Page")
	public void admin_is_on_login_page() {
	    loginpage.LoginURL();
		loginpage.OnLoginPage();
	    
	}

	@When("Admin clicks login in button after entering  a valid credential")
	public void admin_clicks_login_in_button_after_entering_a_valid_credential() {
	    loginpage.DoLoginValidCredentials();
	    
	}

	@Then("Admin should land on home page")
	public void admin_should_land_on_home_page() {
	    String HomePageTitle = loginpage.OnHomePage();
	    Assert.assertEquals(HomePageTitle, "LMS - Learning Management System");
	    log.info("HomPage Title is : " + HomePageTitle );
	    
	}
}
