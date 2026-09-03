package Pages;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import DriverFactory.DriverFactory;
import Utilities.BaseLogger;
import Utilities.ConfigReader;
import Utilities.ElementsUtil;
import Utilities.ExcelReader;

public class ProgramPage extends BaseLogger {
	WebDriver driver = DriverFactory.getDriver();
	 ElementsUtil elementsUtil = new ElementsUtil(driver);
	 String url = ConfigReader.getProperty("baseurl");
	 private By Username = By.xpath("//input[@id='username']");
	 private By Password = By.xpath("//input[@id='password']");
	 private By SelectRole = By.xpath("//div[@id='mat-select-value-1']//span[contains(text(),'Select the role')]");
	 private By RoleName = By.xpath("//span[contains(text(), ' Admin ')]");
	 private By Loginbutton = By.xpath("//button[@id='login']");
	 private By HomePage = By.xpath("//span[contains(text(), ' LMS - Learning Management System ')]");
	 private By ProgramMenu = By.xpath("//span[contains(text(), 'Program')]");
	 private By ManageProgram = By.xpath("//div[contains(text(), ' Manage Program')]");
	 private By AddNewProgram = By.xpath("//button[contains(text(), 'Add New Program')]");
	 private By LeftDeletebutton = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	 private By SearchBox = By.xpath("//input[@id='filterGlobal']");
	 private By SearchPlaceholder = By.xpath("//input[@placeholder='Search...']");
	 private By ProgramNameColumn = By.xpath("//th[@psortablecolumn='programName']");
	 private By ProgramDescriptionColumn = By.xpath("//th[@psortablecolumn='programDescription']");
	 private By ProgramStatusColumn = By.xpath("//th[@psortablecolumn='programStatus']");
	 private By EditDeleteColumn = By.xpath("//th[contains(text(), ' Edit / Delete ')]");
	 private By ProgramNameCheckbox = By.xpath("//div[@class='p-checkbox-box']");
	 private By ProgramNameSortIcon = By.xpath("//th[@ng-reflect-field='programName']//i[contains(@class,'p-sortable-column-icon')]");
	 private By ProgramDescriptionSortIcon = By.xpath("//th[@ng-reflect-field='programDescription']//i[contains(@class,'p-sortable-column-icon')]");
	 private By ProgramStatusSortIcon = By.xpath("//th[@ng-reflect-field='programStatus']//i[contains(@class,'p-sortable-column-icon')]");
	 private By Paginationshowingentries = By.xpath("//span[@class= 'p-paginator-current ng-star-inserted']");
	 private By PaginationDoubleLeftIcon = By.xpath("//span[@class= 'p-paginator-icon pi pi-angle-double-left']");
	 private By PaginationSingleLeftIcon = By.xpath("//span[@class= 'p-paginator-icon pi pi-angle-left']");
	 private By PaginationPages = By.xpath("//span[@class= 'p-paginator-pages ng-star-inserted']");
	 private By PaginationSingleRightIcon = By.xpath("//span[@class= 'p-paginator-icon pi pi-angle-right']");
	 private By PaginationDoubleRightIcon = By.xpath("//span[@class= 'p-paginator-icon pi pi-angle-double-right']");
	 private By FooterText = By.xpath("//div[contains(text(),'programs')]");
	 private By ProgramDetailsDialogBox = By.xpath("//span[contains(@class,'p-dialog-header')]");
	 private By ProgramDetailsText = By.xpath("//span[contains(text(), 'Program Details')]");
	 private By RedAsterikName = By.xpath("//label[contains(text(), 'Name')]//span[contains(@style,'color: red')]");
	 private By RedAsterikStatus = By.xpath("//lable[contains(text(), 'Status')]//span[contains(@style,'color: red')]");
	 private By ActiveRadioButton = By.xpath("//p-radiobutton/parent::div[contains(., 'Active')]");
	 private By InactiveRadioButton = By.xpath("//p-radiobutton/parent::div[contains(., ' Inactive ')]");
	 private By NameTextBox = By.xpath("//input[@id = 'programName']");
	 private By DescriptionTextBox = By.xpath("//input[@id = 'programDescription']");
	 private By SaveButton = By.xpath("//button[@id = 'saveProgram']");
	 private By MandatoryRequiredNameMessage = By.xpath("//small[contains(text(), 'Program name is required.')]");
	 private By MandatoryRequiredStatusMessage =  By.xpath("//small[contains(text(), 'Status is required.')]");
	 private By CancelButton = By.xpath("//span[contains(text(), 'Cancel')]");
	 private By XIcon = By.xpath("//span[contains(@class,'p-dialog-header-close-icon') and contains(@class,'pi-times')]");
	 String filepath = ConfigReader.getProperty("TestData");
	 private By Successprogrammessage = By.xpath("//div[contains(text(), 'Program Created Successfully')]");
	 private By ActiveButton = By.xpath("//p-radiobutton[@ng-reflect-input-id = 'Active']");
	 private By ErrorMessage = By.xpath("//small[contains(text(), 'This field should start with an alphabet, no special char other than a hyphen and have min 4 char.')]");
	 private By SearchInput = By.xpath("//input[@class = 'p-inputtext p-component']");
	 private By ProgramRowFilter = By.xpath("//tbody[contains(@class,'p-datatable-tbody')]//tr[contains(@class,'ng-star-inserted')]");
	 private By ProgramNameRow = By.xpath("//tbody[contains(@class,'p-datatable-tbody')]//tr[contains(@class,'ng-star-inserted')]//td[2]");
	 private By ProgramDescriptionRow = By.xpath("//tbody[contains(@class,'p-datatable-tbody')]//tr[contains(@class,'ng-star-inserted')]//td[3]");
	 private By ProgramStatusRow = By.xpath("//tbody[contains(@class,'p-datatable-tbody')]//tr[contains(@class,'ng-star-inserted')]//td[4]");
	 
	 public ProgramPage(WebDriver driver) {
	        this.driver = driver;
	        this.elementsUtil = new ElementsUtil(driver);
	    } 
	 
	 public void DoLogin()
	 {
		    driver.get(url);
	        elementsUtil.doSendKeys(Username, "Lmshackathon@gmail.com");
	        elementsUtil.doSendKeys(Password, "lmsAug@2026");
	        elementsUtil.doClick(SelectRole);
	        elementsUtil.doClick(RoleName);
	        elementsUtil.doClick(Loginbutton);
	 }
	  
	 public boolean OnHomepage()
	 {
		 return elementsUtil.isElementDisplayed(HomePage);
	 }
	 public void ClickProgramMenu()
	 {
		 elementsUtil.doClick(ProgramMenu);
	 }
	 
	 public boolean GetManageProgram()
	 { 
		 return elementsUtil.isElementDisplayed(ManageProgram);
	 }
	 
	 public String AddNewProgramMenu()
	 {
		 return elementsUtil.doGetText(AddNewProgram);
	 }
	 
	 public String GetProgramTitle() 
	 {
		 return elementsUtil.doGetText(ManageProgram);
	 }
	 
	 public boolean isManageProgramLeftAligned()
	 {
		 WebElement ProgramHeading = elementsUtil.waitForElementToBeVisible(ManageProgram);
		 int heading = ProgramHeading.getLocation().getX();
		 int Threshold = 500; //Threshold value 
		 if (Threshold<=500) {
		        log.info("Manage Program heading is left-aligned : " + heading);
		    } else {
		        log.info("Manage Program heading is not left-aligned : " + heading);
		    }
		 return false;
		}
	 
	 public boolean isDeletebuttonLeftDisabled()
	 {
		 return elementsUtil.isElementDisplayed(LeftDeletebutton);
	 }
	 
	 public boolean isSearchBoxDisplay()
	 {
	     return elementsUtil.isElementDisplayed(SearchBox);
	 }
	 
	 public boolean Searchplaceholdertext()
	 {
		 return elementsUtil.isElementDisplayed(SearchPlaceholder);
	 }

	 public String GetDataTableHeader(String Columnheader)
	 {
		if(Columnheader.equalsIgnoreCase("Program Name")) {
			elementsUtil.doGetText(ProgramNameColumn);
			log.info("Admin is able to see the header name as : "+ Columnheader);
		}
		else if(Columnheader.equalsIgnoreCase("Program Description"))
		{
			elementsUtil.doGetText(ProgramDescriptionColumn);
			log.info("Admin is able to see the header name as : "+ Columnheader);
		}
		else if(Columnheader.equalsIgnoreCase("Program Status"))
		{
			elementsUtil.doGetText(ProgramStatusColumn);
			log.info("Admin is able to see the header name as : "+ Columnheader);
		}
		else if(Columnheader.equalsIgnoreCase("Edit/Delete"))
		{
			elementsUtil.doGetText(EditDeleteColumn);
			log.info("Admin is able to see the header name as : "+ Columnheader);
		}
        else {
            throw new IllegalArgumentException("Unknown Columnheader : " + Columnheader);
        }
		return Columnheader;	 
	 }
	 
	 public boolean isProgramNameCheckboxdisplay()
	 {
		 return elementsUtil.isElementDisplayed(ProgramNameCheckbox);
	 }
	 
	 public boolean isProgramNameCheckboxUnchecked()
	 {
		 WebElement checkbox = elementsUtil.waitForElementToBeVisible(ProgramNameCheckbox);
		 String ariaChecked = checkbox.getAttribute("aria-checked");
	     String classAttribute = checkbox.getAttribute("class");
	        if (ariaChecked != null) {
	            return "false".equalsIgnoreCase(ariaChecked);      
	        }
	        return classAttribute == null || !classAttribute.contains("p-highlight");
	 }
	 
	 public boolean isSortIconPresent()
	 {
		 List<WebElement> ProgramNameIcon = elementsUtil.waitForElementsToBeVisible(ProgramNameSortIcon);
		 boolean isProgramNameIconPresent = ProgramNameSortIcon != null && !ProgramNameIcon.isEmpty();
		 log.info("Sort icon beside Program Name is present: {}", isProgramNameIconPresent);
		 
		 List<WebElement> ProgramDescriptionIcon = elementsUtil.waitForElementsToBeVisible(ProgramDescriptionSortIcon);
		 boolean isProgramDescriptionIconPresent = ProgramDescriptionSortIcon != null && !ProgramDescriptionIcon.isEmpty();
		 log.info("Sort icon beside Program Description is present: {}", isProgramDescriptionIconPresent);
		 
		 List<WebElement> ProgramStausIcon = elementsUtil.waitForElementsToBeVisible(ProgramStatusSortIcon);
		 boolean isProgramStatusIconPresent = ProgramStatusSortIcon != null && !ProgramStausIcon.isEmpty();
		 log.info("Sort icon beside Program Status is present: {}", isProgramStatusIconPresent);
		 
         return isProgramNameIconPresent && isProgramDescriptionIconPresent && isProgramStatusIconPresent;       
	 }	 
	 
	 public String GetPaginationControl(String Controls)
	 {       String SwitchKey = Controls;
	         if(Controls.matches("(?i)Showing x to y of z entries")) {
	         SwitchKey = "Showing Entries";
	     }
	     switch(SwitchKey.toLowerCase())
	     {
	         case "showing entries":
	             String ActualText = elementsUtil.doGetText(Paginationshowingentries);
	             log.info("Admin is able to see the pagination text as : " + ActualText);
	             break;

	         case "double left icon":
	             elementsUtil.isElementDisplayed(PaginationDoubleLeftIcon);
	             log.info("Admin is able to see the pagination control as : " + Controls);
	             break;

	         case "single left icon":
	             elementsUtil.isElementDisplayed(PaginationSingleLeftIcon);
	             log.info("Admin is able to see the pagination control as : " + Controls);
	             break;

	         case "pagination pages":
	             elementsUtil.isElementDisplayed(PaginationPages);
	             log.info("Admin is able to see the pagination control as : " + Controls);
	             break;

	         case "single right icon":
	             elementsUtil.isElementDisplayed(PaginationSingleRightIcon);
	             log.info("Admin is able to see the pagination control as : " + Controls);
	             break;

	         case "double right icon":
	             elementsUtil.isElementDisplayed(PaginationDoubleRightIcon);
	             log.info("Admin is able to see the pagination control as : " + Controls);
	             break;

	         default:
	             log.info("Unknown Pagination Control : " + Controls);
	             break;
	     }
	     return Controls;
	 }
	 
	 public List<String> GetPaginationControls(List<String> controls) {

		    List<String> actualControls = new ArrayList<>();

		    for (String control : controls) {
		        String actualControl = GetPaginationControl(control);
		        actualControls.add(actualControl);
		    }

		    return actualControls;
		}
	 
	 public String getFooter()
	 {
		 return elementsUtil.doGetText(FooterText);
	 }
	 
	 public void ClickAddNewProgram()
	 {
		 elementsUtil.doClick(AddNewProgram);
	 }
	 public String GetProgramDetailsText()
	 {
		return elementsUtil.doGetText(ProgramDetailsText);
		 
	 }
	 
	 public boolean isProgramDetailsDiaplogBoxDisplayed()
	 {
		 return elementsUtil.isElementDisplayed(ProgramDetailsDialogBox);
	 }
	 

	 public By getRedAsteriskXPath(String fieldName) {
		    Map<String, By> fieldToXPath = new HashMap<>();
		    fieldToXPath.put("Name", RedAsterikName);
		    fieldToXPath.put("Status", RedAsterikStatus);

		    if (!fieldToXPath.containsKey(fieldName)) {
		        throw new IllegalArgumentException("No XPath mapped for mandatory field: " + fieldName);
		    }

		    return fieldToXPath.get(fieldName);
		}

		public boolean isRedAsterikdisplayed(String fieldName) {
		    By locator = getRedAsteriskXPath(fieldName);
		    boolean isDisplayed = elementsUtil.isElementDisplayed(locator);
		    log.info("Mandatory Red Asterisk displayed for " + fieldName + ": " + isDisplayed);
		    return isDisplayed;
		}

		public By getRadioButtonoption(String radioMap) {
		    Map<String, By> optionToXPath = new HashMap<>();
		    optionToXPath.put("Active", ActiveRadioButton);
		    optionToXPath.put("Inactive", InactiveRadioButton);
		    if (!optionToXPath.containsKey(radioMap)) {
		        throw new IllegalArgumentException("No XPath mapped for radio button option: " + radioMap);
		    }
		    return optionToXPath.get(radioMap);
		}

		public boolean isRadioButtonDisplayed(String option) {
		    By locator = getRadioButtonoption(option);
		    boolean isDisplayed = elementsUtil.isElementDisplayed(locator);
		    log.info("Admin is able to see the " + option + " radio button: " + isDisplayed);
		    return isDisplayed;
		}
		
	     public void selectStatus(String status) {

	         JavascriptExecutor js = (JavascriptExecutor) driver;

	         if (status.equalsIgnoreCase("Active")) {
	             WebElement activeElement  = elementsUtil.waitForElementToBeClickable(ActiveButton);
	            		 //wait.until(ExpectedConditions.presenceOfElementLocated(activeStatus));             
	             js.executeScript("arguments[0].click();", activeElement); 
	             log.info("Admin is selected : " + activeElement);
	         } else if (status.equalsIgnoreCase("Inactive")) {
	             //System.out.println("Waiting for Inactive status to be present...");
	             WebElement inactiveElement = elementsUtil.waitForElementToBeClickable(InactiveRadioButton);
	            		 //wait.until(ExpectedConditions.presenceOfElementLocated(inactiveStatus));
	             //System.out.println("Inactive status is present. Attempting to click...");
	             js.executeScript("arguments[0].click();", inactiveElement);
	             //System.out.println("Inactive status clicked using JavaScript.");
	             log.info("Admin is selected : " + inactiveElement);
	         }

	    }
		
		private By isInputTextBoxavailable(String fieldTextBoxOption) {
		    switch (fieldTextBoxOption.toLowerCase()) {
		        case "nametextbox":
		            return NameTextBox;          
		        case "descriptiontextbox":
		            return DescriptionTextBox;
		        default:
		            throw new IllegalArgumentException("No XPath mapped for Text Box option: " + fieldTextBoxOption);
		    }
		}

		public boolean isTextBoxDisplayed(String fieldTextBox) {
		    By locator = isInputTextBoxavailable(fieldTextBox);
		    boolean isDisplayed = elementsUtil.isElementDisplayed(locator);
		    log.info("Admin is able to see : " + fieldTextBox + " is displayed: " + isDisplayed);
		    return isDisplayed;
		}
		
		public void OnClickSaveButton()
		{
			elementsUtil.doClick(SaveButton);
		}
		
		private By isMandatoryRequiredMessageDisplay(String Field)
		{
			switch (Field.toLowerCase()) {
	        case "program name":
	            return MandatoryRequiredNameMessage;          
	        case "status":
	            return MandatoryRequiredStatusMessage;
	        default:
	            throw new IllegalArgumentException("No XPath mapped for Text Box option: " + Field);
	      }
		}
		
		public boolean isRequiredMessageDisplayed(String fieldmessage) {
		    By locator = isMandatoryRequiredMessageDisplay(fieldmessage);
		    boolean isDisplayed = elementsUtil.isElementDisplayed(locator);
		    log.info("Admin is able to see : " + fieldmessage + " is displayed: " + isDisplayed);
		    log.info("Admin is able to see : " + fieldmessage + " "+ isDisplayed);
		    return isDisplayed;
		}
		
		public void OnClickCancelButton()
		{
			elementsUtil.doClick(CancelButton);
		}
		
		public boolean isProgramDetailsDialogDisappeared() { 
		return elementsUtil.isElementDisplayed(ProgramDetailsDialogBox);
		
		}
		
		public void OnClickXIcon()
		{
			elementsUtil.waitForElementToBeClickable(XIcon);
		}
		
		public void getValidProgramDetails()
		{
			log.info("Performing AddNewProgram with TestData from Excel:");
	     	Map<String, String> ProgramData = ExcelReader.getRowByTestCaseId(filepath, "AddNewProgram", "ValidMandatoryDetails");
	     	String ExcelDataName = ProgramData.get("Name");
	     	String ExcelDataDescription = ProgramData.get("Description");
	     	driver.findElement(NameTextBox).sendKeys(ExcelDataName);
	     	driver.findElement(DescriptionTextBox).sendKeys(ExcelDataDescription);
	     	//driver.findElement(ActiveButton).isSelected();
	     	selectStatus("Active");
	     	driver.findElement(SaveButton).click();
	     	log.info("Name : " + ExcelDataName);
	     	log.info("Description : " + ExcelDataDescription);
		}
		
		public String isSuccessProgramMessageDisplay()
		{
			return elementsUtil.doGetText(Successprogrammessage);
		}
		
		public void getInValidProgramDetails()
		{
			log.info("Performing AddNewProgram with TestData from Excel:");
	     	Map<String, String> ProgramData = ExcelReader.getRowByTestCaseId(filepath, "AddNewProgram", "InvalidProgramDetails");
	     	String ExcelDataName = ProgramData.get("Name");
	     	driver.findElement(NameTextBox).sendKeys(ExcelDataName);
	     	log.info("Name : " + ExcelDataName);
		}
		
		public String isErrorProgramMessageDisplay()
		{
			return elementsUtil.doGetText(ErrorMessage);
		}

		public void searchProgramByTestCaseId(String TestCaseID) {
		    log.info("Performing Search with TestData from Excel: " + TestCaseID);
		    Map<String, String> SearchData = ExcelReader.getRowByTestCaseId(filepath, "ManageProgramSearch", TestCaseID);
		    String ExcelSearchValue = SearchData.get("SearchValue");

		    if (ExcelSearchValue == null) {
		        throw new IllegalStateException("SearchValue is null for TestCaseID: " + TestCaseID);
		    }

		    driver.findElement(SearchInput).sendKeys(ExcelSearchValue);
		    log.info("Search Value : " + ExcelSearchValue);
		}

		public Map<String, String> getSearchedProgramDetails() {
		    WebElement row = elementsUtil.waitForElementToBeVisible(ProgramRowFilter);//driver.findElement(ProgramRowFilter);
		    String name = row.findElement(ProgramNameRow).getText();
		    String description = row.findElement(ProgramDescriptionRow).getText();
		    String status = row.findElement(ProgramStatusRow).getText();

		    Map<String, String> details = new HashMap<>();
		    details.put("Name", name);
		    details.put("Description", description);
		    details.put("Status", status);
		    return details;
		}
		
		public boolean isSearchedProgramDetailsValid() {
		    Map<String, String> details = getSearchedProgramDetails();

		    boolean isValid = !details.get("Name").isEmpty()
		            && !details.get("Description").isEmpty()
		            && !details.get("Status").isEmpty();

		    log.info("Search result — Name: " + details.get("Name")
		            + ", Description: " + details.get("Description")
		            + ", Status: " + details.get("Status"));

		    return isValid;
		}
		
		
}
	 


	 

	