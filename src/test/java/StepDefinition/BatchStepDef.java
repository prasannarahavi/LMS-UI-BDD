package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverFactory;
import Pages.ProgramPage;
import Pages.BatchPage;
import Utilities.BaseLogger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BatchStepDef extends BaseLogger {
	
	WebDriver driver = DriverFactory.getDriver();
    BatchPage batchpage = new BatchPage(driver);
    ProgramPage programpage = new ProgramPage(driver);
    
    @Given("Admin is on Homepage after successful login")
    public void admin_is_on_homepage_after_successful_login() {
    	   programpage.DoLogin();
   	    boolean HomePageTitle = programpage.OnHomepage();
   	    log.info("HomePage is displayed : "+HomePageTitle);
   	 
    }

    @When("Admin clicks on Batch tab on the navigation bar")
    public void admin_clicks_on_batch_tab_on_the_navigation_bar() {
      batchpage.ClickBatchMenu();
    }

    @Then("admin should be navigated to manage batch page")
    public void admin_should_be_navigated_to_manage_batch_page() {
      batchpage.GetManageBatch();
      Assert.assertTrue(batchpage.GetManageBatch());
    }
    
    @Then("Admin should see sub menu in menu bar as {string} under Batch module")
    public void admin_should_see_sub_menu_in_menu_bar_as_under_batch_module(String ExpectedSubMenu) {
    String ActualSubMenu = batchpage.GetsubMenuText();
    System.out.println(ActualSubMenu);
	Assert.assertEquals(ExpectedSubMenu, ActualSubMenu);
		log.info("Expected SubMenu is : "+ActualSubMenu);
	 
    }

    @Then("Admin should see the {string} Heading")
    public void admin_should_see_the_heading(String heading) {
    	Assert.assertEquals(heading, batchpage.GetHeaadingText());
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String icon) {
      Assert.assertTrue(batchpage.getIcons(icon));
    }
    
    @Then("{string} should be displayed in each rom")
    public void should_be_displayed_in_each_rom(String rowIcon) throws InterruptedException {
    	Thread.sleep(3000);
        Assert.assertTrue(batchpage.getEditIcon(rowIcon));
    }

    @Then("Datatable {string} should be displayed")
    public void datatable_should_be_displayed(String header) {
      Assert.assertEquals(header, batchpage.getheaderText(header));
    }

    @Then("Checkbox should be displayed in header row")
    public void checkbox_should_be_displayed_in_header_row() {
      Assert.assertTrue(batchpage.GetChkBox());
    }

    @Then("Admin should see the sort icon next to all Datatable headers")
    public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
      Assert.assertTrue(batchpage.GetsortIcon());
    }

    @When("Admin clicks on Add New batch under the Batch tab")
    public void admin_clicks_on_add_new_batch_under_the_batch_tab() {
      batchpage.ClickAddBatch();
    }

    @Then("Admin should see the Batch Details dialog box")
    public void admin_should_see_the_batch_details_dialog_box() {
      Assert.assertTrue(batchpage.Getbox(), "No box is present");
    }

    @Then("Admin should see {string} on the dialogue box")
    public void admin_should_see_on_the_dialogue_box(String fieldText) {
    	Assert.assertEquals(fieldText,batchpage.getDBFieldText(fieldText).replace("*", "").trim());
    	// Assert.assertEquals(fieldText, batchpage.getDBFieldText(fieldText));
    }

    @Then("Admin should see the program status field with dropdown")
    public void admin_should_see_the_program_status_field_with_dropdown() {
      Assert.assertTrue(batchpage.Getdropdown());
    }

    @Then("Admin should see the status radio button")
    public void admin_should_see_the_status_radio_button() {
    	System.out.println("Done before");
      Assert.assertTrue(batchpage.GetradioBtn());
  	System.out.println("Done");
    }

    @Given("Admin is on Batch Details dialog box")
    public void admin_is_on_batch_details_dialog_box() {
    	batchpage.ClickAddBatch();
    }

    @When("Admin selects program name present in the dropdown")
    public void admin_selects_program_name_present_in_the_dropdown() throws InterruptedException {
      batchpage.selectdropdownText();
    }

    @Then("Admin should see selected program name in the batch name prefix box")
    public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() throws InterruptedException {
     Assert.assertEquals("JavaSel-DependInjectn", batchpage.getdropdownText());
    }

    @When("Admin enters {string} in batch name suffix box")
    public void admin_enters_in_batch_name_suffix_box(String string) {
      
    }

    @Then("Admin should get error message below the text box of respective field")
    public void admin_should_get_error_message_below_the_text_box_of_respective_field() {
      
    }

    @When("Admin enters alphabets in batch name prefix box")
    public void admin_enters_alphabets_in_batch_name_prefix_box() {
      
    }

    @Then("Admin should see empty text box")
    public void admin_should_see_empty_text_box() {
      
    }

    @When("Admin enters the data only to the mandatory fields {string} {string} {string} {string} and clicks save button")
    public void admin_enters_the_data_only_to_the_mandatory_fields_and_clicks_save_button(String string, String string2, String string3, String string4) {
      
    }

    @Then("Admin should get a successful message {string}")
    public void admin_should_get_a_successful_message(String string) {
      
    }

    @When("Add new batch with leaving space in mandatory field {string} {string} {string} {string} and clicks save button")
    public void add_new_batch_with_leaving_space_in_mandatory_field_and_clicks_save_button(String string, String string2, String string3, String string4) {
      
    }

    @Then("Admin should get a error message on the respective mandatory field {string}")
    public void admin_should_get_a_error_message_on_the_respective_mandatory_field(String string) {
      
    }

    @When("Admin enters the data only to the mandatory fields {string} {string} {string} {string} and clicks cancel button")
    public void admin_enters_the_data_only_to_the_mandatory_fields_and_clicks_cancel_button(String string, String string2, String string3, String string4) throws InterruptedException {
      batchpage.ClickCloseBtn();
    }

    @Then("Admin should see the batch details popup closes without creating any batch")
    public void admin_should_see_the_batch_details_popup_closes_without_creating_any_batch() {
    	
    	Assert.assertFalse(batchpage.Getbox(), "box is present");
    }

    @When("Admin clicks on the close icon")
    public void admin_clicks_on_the_close_icon() {
      batchpage.ClickCloseIcon();
    }

    @Then("batch details pop up closes")
    public void batch_details_pop_up_closes() throws InterruptedException {
    	Thread.sleep(3000);
    	Assert.assertFalse(batchpage.Getbox(), "box is present");
    }

}
