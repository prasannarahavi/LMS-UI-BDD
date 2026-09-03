package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverFactory;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.BaseLogger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDef extends BaseLogger {
	WebDriver driver = DriverFactory.getDriver(); // Get the active WebDriver instance shared across the test framework
    LoginPage loginpage = new LoginPage(driver); // Instantiate LoginPage with the driver to access its elements/actions
    HomePage homepage = new HomePage(driver); // Instantiate HomePage with the driver to access its elements/actions ("Instantiate" means to create an actual object (instance) from a class.)

   @Given("Admin is on LoginPage")
   public void admin_is_on_login_page() {
       loginpage.LoginURL();
	   loginpage.OnLoginPage();
 }

   @When("Admin clicks login button after entering a valid credential")
   public void admin_clicks_login_button_after_entering_a_valid_credential() {
      loginpage.DoLoginValidCredentials();
 }

   @Then("Admin should see {string} as title")
   public void admin_should_see_as_title(String ExpectedTitle) {
    String ActualTitle = homepage.HomePageTitle();
    Assert.assertEquals(ActualTitle, ExpectedTitle);
    log.info("Admin should see the HomePage Title as : " + ActualTitle);
    
 }

}
