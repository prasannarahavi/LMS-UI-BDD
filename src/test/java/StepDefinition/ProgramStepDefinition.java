package StepDefinition;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverFactory;
import Pages.ProgramPage;
import Utilities.BaseLogger;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramStepDefinition extends BaseLogger {
	
	WebDriver driver = DriverFactory.getDriver();
    ProgramPage programpage = new ProgramPage(driver);
    
	@Given("Admin is on home page after Login")
	public void admin_is_on_home_page_after_login() {
	    programpage.DoLogin();
	    boolean HomePageTitle = programpage.OnHomepage();
	    log.info("HomePage is displayed : "+HomePageTitle);
	  
	}

	@When("Admin clicks Program on the navigation bar")
	public void admin_clicks_program_on_the_navigation_bar() {
	    programpage.ClickProgramMenu();
	    
	}

	@Then("Admin should be navigated to Program page")
	public void admin_should_be_navigated_to_program_page() {
	    boolean isDisplayed = programpage.GetManageProgram();
	    Assert.assertTrue(isDisplayed);
		log.info("Manage Program page is displayed : "+isDisplayed);
	    
	}

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String ExpectedSubMenu) {
		String ActualSubMenu = programpage.AddNewProgramMenu();
		Assert.assertEquals(ExpectedSubMenu, ActualSubMenu);
		log.info("Expected SubMenu is : "+ActualSubMenu);
	    
	}

	@Then("Admin should see the heading {string}")
	public void admin_should_see_the_heading(String ExpectedHeading) {
	    String ActualHeading = programpage.GetProgramTitle();
	    Assert.assertEquals(ExpectedHeading, ActualHeading);
		log.info("Expected Heading is : "+ActualHeading);
	}

	@Then("Admin should see manage program heading aligned on the left side")
	public void admin_should_see_manage_program_heading_aligned_on_the_left_side() {
	    boolean isLeftAligned = programpage.isManageProgramLeftAligned();
	    Assert.assertTrue(isLeftAligned);
	    log.info("Manage Program Heading is LeftAligned  : "+ isLeftAligned);
	}

	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
		boolean isDeletebuttondisabled = programpage.isDeletebuttonLeftDisabled();
	    Assert.assertTrue(isDeletebuttondisabled);
	    log.info("Delete Button on top left is disabled : "+ isDeletebuttondisabled);
	    
	}

	@Then("Admin should see Search bar")
	public void admin_should_see_search_bar() {
		boolean isSearchBardisplayed = programpage.isSearchBoxDisplay();
	    Assert.assertTrue(isSearchBardisplayed);
	    log.info("Search Bar is displayed : "+ isSearchBardisplayed);
	    
	}

	@Then("Admin should see search... placeholder text")
	public void admin_should_see_search_placeholder_text() {
		boolean isSearchplaceholderdisplayed = programpage.Searchplaceholdertext();
	    Assert.assertTrue(isSearchplaceholderdisplayed);
	    log.info("Search PlaceHolder is displayed : "+ isSearchplaceholderdisplayed);
	    
	}

	@Then("Admin should see data table with {string} on Manage Program Page")
	public void admin_should_see_data_table_with_on_manage_program_page(String ExpectedColumnHeading) {
		String ActualColumnHeading = programpage.GetDataTableHeader(ExpectedColumnHeading);
	    Assert.assertEquals(ExpectedColumnHeading, ActualColumnHeading);
		log.info("Expected Heading is : "+ActualColumnHeading);
	}

	@Then("Admin should see checkbox default state as unchecked beside Program Name column header")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header() {
	    boolean isProgramHeaderCheckboxdisplayed = programpage.isProgramNameCheckboxUnchecked();
	    Assert.assertTrue(isProgramHeaderCheckboxdisplayed);
	    log.info("Program Header Checkbox is in default state as unchecked : "+ isProgramHeaderCheckboxdisplayed);
	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		boolean isSortIconDisplayed = programpage.isSortIconPresent();
	  Assert.assertTrue(isSortIconDisplayed);
      log.info("Sort Icon is Present : "+ isSortIconDisplayed);
	}

	@Then("Admin should see the following pagination controls below the table:")
	public void admin_should_see_the_following_pagination_controls(DataTable dataTable) {
	    List<String> ExpectedControls = dataTable.asList(String.class);
	    List<String> ActualControls = programpage.GetPaginationControls(ExpectedControls);
	    Assert.assertEquals(ActualControls, ExpectedControls,
	            "Pagination controls not displayed as expected");
	    log.info("Admin verified all pagination controls: " + ExpectedControls);
	}	
	
	@Then("Admin should see the footer as {string}")
	public void admin_should_see_the_footer_as(String ExpectedFooter) {
		String ActualFooter= programpage.getFooter();
		Assert.assertEquals(ExpectedFooter, ActualFooter);
		log.info("Expected Footer is : "+ ActualFooter);
	    
	}
	
	@Given("Admin is on Program Page")
	public void admin_is_on_program_page() {
	    programpage.DoLogin();
	    programpage.ClickProgramMenu();
	    programpage.GetManageProgram();
	    
	}

	@When("Admin clicks on Add New Program under the Program menu bar")
	public void admin_clicks_on_add_new_program_under_the_program_menu_bar() {
	    programpage.AddNewProgramMenu();
	    programpage.ClickAddNewProgram();
	    
	}

	@Then("Admin should see Program Details dialog box")
	public void admin_should_see_program_details_dialog_box() {
		boolean isProgramDetailsDialogBoxDisplayed = programpage.isProgramDetailsDiaplogBoxDisplayed();
		Assert.assertTrue(isProgramDetailsDialogBoxDisplayed);
	    log.info("Program Details dialog Box is Present : "+ isProgramDetailsDialogBoxDisplayed);
	}

	@Then("Admin should see  title as {string}")
	public void admin_should_see_title_as(String ExpectedTitle) {
	    String ActualTitle = programpage.GetProgramDetailsText();
	    Assert.assertEquals(ExpectedTitle, ActualTitle);
		log.info("Expected Title is : "+ ActualTitle);
	    
	}

	@Then("Admin should see red  asterisk mark beside mandatory field {string}")
	public void admin_should_see_red_asterisk_mark_beside_mandatory_field(String fieldName) {
		boolean isDisplayed = programpage.isRedAsterikdisplayed(fieldName);
	    Assert.assertTrue(isDisplayed, "Red asterisk not displayed for mandatory field: " + fieldName);
	    log.info("Verified mandatory asterisk for field: " + fieldName);
	    
	}

	@Then("Admin should see the {string}")
	public void admin_should_see_the(String FieldTextBox) {
		boolean isDisplayed = programpage.isTextBoxDisplayed(FieldTextBox);
	    Assert.assertTrue(isDisplayed, "Input Text Box is not avaialble : " + FieldTextBox);
	    log.info("Admin is able to see : " + FieldTextBox);
	}

	@Then("Admin should see {string} radio buttons")
	public void admin_should_see_radio_buttons(String Options) {
		boolean isDisplayed = programpage.isRadioButtonDisplayed(Options);
	    Assert.assertTrue(isDisplayed, "Radio button not displayed: " + Options);
	    log.info("Verified radio button is displayed: " + Options);
	    
	}
	
	@Given("Admin is on Program details dialog box")
	public void admin_is_on_program_details_dialog_box() {
		programpage.DoLogin();
	    programpage.ClickProgramMenu();
	    programpage.GetManageProgram();
	    programpage.AddNewProgramMenu();
	    programpage.ClickAddNewProgram();
	    programpage.isProgramDetailsDiaplogBoxDisplayed();
	    
	}

	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() {
	    programpage.OnClickSaveButton();
	    
	}

	@Then("Admin gets message {string} is required")
	public void admin_gets_message_is_required(String FieldMessage) { 
		boolean isDisplayed = programpage.isRequiredMessageDisplayed(FieldMessage);
	    Assert.assertTrue(isDisplayed, "Radio button not displayed: " + FieldMessage);
	    log.info("Mandatory required message is displayed for : " + FieldMessage);	
	}

	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
	    programpage.OnClickCancelButton();
	    
	}

	@Then("Admin can see Program Details form disappears")
	public void admin_can_see_program_details_form_disappears() {  
		boolean isDisplayed = programpage.isProgramDetailsDialogDisappeared();
		Assert.assertTrue(isDisplayed);
	    log.info("Program Details form disappeared: " + isDisplayed);
	 
	}

	@When("Admin clicks X button")
	public void admin_clicks_x_button() {
	    programpage.OnClickXIcon();
	    
	}

	@When("Admin enter valid details for mandatory fields and Click on save button")
	public void admin_enter_valid_details_for_mandatory_fields_and_click_on_save_button() {
	    
	    programpage.getValidProgramDetails();
	}

	@Then("Admin gets message {string}")
	public void admin_gets_message(String ExpectedMessage) {
		String ActualMessage = programpage.isSuccessProgramMessageDisplay();
		Assert.assertEquals(ExpectedMessage, ActualMessage);
	    log.info("Admin can see the message as: " + ActualMessage);
	    
	}

	@When("Admin enters a numeric value as the Program Name")
	public void admin_enters_a_numeric_value_as_the_program_name() {
	    
	    programpage.getInValidProgramDetails();
	}

	@Then("Admin should see error message as {string}")
	public void admin_should_see_error_message_as(String ExpectedErrorMessage) {
		String ActualErrorMessage = programpage.isErrorProgramMessageDisplay();
		Assert.assertEquals(ExpectedErrorMessage, ActualErrorMessage);
	    log.info("Admin can see the message as: " + ActualErrorMessage);
	    
	}	
	
	
}