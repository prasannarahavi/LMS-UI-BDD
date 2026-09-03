package Pages;

import java.util.List;

import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import DriverFactory.DriverFactory;
import Utilities.BaseLogger;
import Utilities.ConfigReader;
import Utilities.ElementsUtil;

public class BatchPage extends BaseLogger {
	WebDriver driver = DriverFactory.getDriver();
	ElementsUtil elementsUtil = new ElementsUtil(driver);
	String url = ConfigReader.getProperty("baseurl");

	// WebElement
	private By BatchMenu = By.xpath("//span[contains(text(), 'Batch')]");
	private By AddNewBatch = By.xpath("//button[contains(text(), 'Add New')]");
	private By Heading = By.xpath("//div[contains(text(), 'Manage Batch')]");
	private By deleteIcon = By.xpath("//span[@class ='p-button-icon pi pi-trash']");
	private By pagination = By.xpath("//div[@class ='p-paginator-bottom p-paginator p-component ng-star-inserted']");
	private	List<WebElement> editIcons = driver.findElements(By.xpath("//tbody/tr//span[contains(@class,'pi-pencil')]"));
	private List<WebElement> deleteIcons = driver.findElements(By.xpath("//button[contains(@class,'p-button-danger')]"));
	private List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@role='checkbox']"));
	//private By editIcon = By.xpath("//div[@class='cdk-overlay-container']");
	//private By rowdeleteIcon = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	//private By rowCheckbox = By.xpath("//div[@role='checkbox']");
	private By checkbox = By.xpath("//div[@class='p-hidden-accessible']");
	private By headerBatchName = By.xpath("//th[@psortablecolumn='batchName']");
	private By headerBatchDescription = By.xpath("//th[@psortablecolumn='batchDescription']");
	private By headerBatchStatus = By.xpath("//th[@psortablecolumn='batchStatus']");
	private By headerNoofclasses = By.xpath("//th[@psortablecolumn='batchNoOfClasses']");
	private By headerprogramName = By.xpath("//th[@psortablecolumn='programName']");
	private By headerEditNDelete = By.xpath("//th[contains(text(), ' Edit / Delete ')]");
	private By sortIcon = By.xpath("//i[@class = 'p-sortable-column-icon pi pi-fw pi-sort-alt']");
	private By DialogueBox = By.xpath("//div[@class = 'p-dialog-header ng-tns-c81-8 ng-star-inserted']");
	private By DBprogramNamefield = By.xpath("//label[@for = 'programName']"); // DB=DialogueBox
	private By DBbatchNamefield = By.xpath("//label[@for = 'batchName']");
	private By DBdescriptionfield = By.xpath("//label[@for = 'programDescription']");
	private By DBstatusfield = By.xpath("//lable[@for = 'online']");
	private By DBnoofclassesfield = By.xpath("//label[@for = 'batchNoOfClasses']");
	private By DBcloseicon = By.xpath("//span[contains(@class,'p-dialog-header-close-icon') and contains(@class,'pi-times')]");
	private By DBCancelbtn = By.xpath("//span[contains(text(), 'Cancel')]");
	private By DBsavebtn = By.xpath("//span[contains(text(), 'Save')]");
	private By DBdropDownfield = By.xpath("//span[@class = 'p-button-icon pi pi-chevron-down']");
	private By DBradioBtn = By.xpath("//p-radiobutton[@ng-reflect-value='Active']");
	private By bropdownText = By.xpath("//input[@placeholder='Select or type a program']");
	private By ProgNameSearchbox = By.xpath("//input[@role = 'searchbox']");
	private By BatchNameSearchbox = By.xpath("//input[@id='batchName' and @pattern='^[0-9]{0,5}$']");
	private By DescriptionSearchbox = By.xpath("//input[@class='p-inputtext p-component ng-pristine ng-valid ng-touched']");
	private By NoOfClassesSearchBox = By.xpath("//input[@class='ng-pristine ng-invalid ng-touched']");
	private By DBErrorMsg = By.xpath("//small[contains(text(), 'This field accept only numbers and max 5 count.') ]");
	
	public BatchPage(WebDriver driver) {
		this.driver = driver;
		this.elementsUtil = new ElementsUtil(driver);
	}

	public void ClickBatchMenu() {
		elementsUtil.doClick(BatchMenu);
	}
	
	public void ClickAddBatch() {
		elementsUtil.doClick(AddNewBatch);
	}
	
	public void ClickCloseIcon() {

		elementsUtil.waitForElementToBeVisible(DBcloseicon);
		elementsUtil.doClick(DBcloseicon);
	}
	
	public void ClickCloseBtn() throws InterruptedException {

		elementsUtil.doClick(DBCancelbtn);
Thread.sleep(2000);		
	}
	
	public void ClickSaveBtn() {
		elementsUtil.doClick(DBsavebtn);
	}
	
	public boolean Getbox() {
		return elementsUtil.isElementDisplayed(DialogueBox);
	}
	
	public String GetboxText() {
		return elementsUtil.doGetText(DialogueBox);
	}
	

	public boolean GetManageBatch() {
		return elementsUtil.isElementDisplayed(Heading);
	}

	public boolean GetChkBox() {
		return elementsUtil.isElementDisplayed(checkbox);
	}
	
	public boolean GetsortIcon() {
		return elementsUtil.isElementDisplayed(sortIcon);
	}

	public boolean Getdropdown() {
		return elementsUtil.isElementDisplayed(DBdropDownfield);
	}
	
	public void selectdropdownText() throws InterruptedException {
		Thread.sleep(3000);
		elementsUtil.doClick(ProgNameSearchbox);
		elementsUtil.doClick(DBdropDownfield);
		elementsUtil.doSendKeys(ProgNameSearchbox, "JavaSel-DependInjectn");
	}

	public String getdropdownText() throws InterruptedException {
		System.out.println("Mothod called");
		Thread.sleep(3000);
		elementsUtil.waitForElementToBeVisible(bropdownText);
		System.out.println(elementsUtil.getAttribute(bropdownText, "value"));
		return elementsUtil.getAttribute(bropdownText, "value");
		
	}

	
	public boolean GetradioBtn() {
		System.out.println("Radio page class Done");
		return elementsUtil.isElementDisplayed(DBradioBtn);
	}

	public String GetHeaadingText() {
		return elementsUtil.doGetText(Heading);
	}

	public String GetsubMenuText() {
		return elementsUtil.doGetText(AddNewBatch);
	}

	public boolean getIcons(String icon) {

		switch (icon.toLowerCase()) {

		case "delete icon":
			return elementsUtil.isElementDisplayed(deleteIcon);

		case "pagination controls":
			return elementsUtil.isElementDisplayed(pagination);

		default:
			throw new IllegalArgumentException("Invalid icon: " + icon);
		}
	}


	public String getheaderText(String headerText) {

		switch (headerText) {

		case "Batch Name":
			return elementsUtil.doGetText(headerBatchName);
			
		case "Batch Description":
			return elementsUtil.doGetText(headerBatchDescription);
			
		case "Batch Status":
			return elementsUtil.doGetText(headerBatchStatus);
			
		case "No Of Classes":
			return elementsUtil.doGetText(headerNoofclasses);
			
		case "Edit / Delete":
			return elementsUtil.doGetText(headerEditNDelete);
			
		case "Program Name":
			return elementsUtil.doGetText(headerprogramName);
			
		default:
			throw new IllegalArgumentException("Invalid HeaderText: " + headerText);
		}
	}

	public String getDBFieldText(String fieldText) {

		switch (fieldText) {

		case "Program Name":
			return elementsUtil.doGetText(DBprogramNamefield);
			
		case "Description":
			return elementsUtil.doGetText(DBdescriptionfield);
			
		case "Status :":
			return elementsUtil.doGetText(DBstatusfield);
			
		case "Number of Classes":
			return elementsUtil.doGetText(DBnoofclassesfield);
			
		case "Batch Name":
			return elementsUtil.doGetText(DBbatchNamefield);
			
		default:
			throw new IllegalArgumentException("Invalid fieldText: " + fieldText);
		}
	}
	
	
	public boolean getEditIcon(String editIcon) {
		 //if (editIcons.isEmpty()) {
		   //     return false;
		    //}

		    for (WebElement icon : editIcons) {
		        if (!icon.isDisplayed()) {
		            return false;
		        }
		    }
		    return true;	
		    }
	
	
	public boolean getRowIcons(String rowIcon) {

		    List<WebElement> icons;
		    System.out.println("Edit Icons: " + editIcons.size());
		    switch (rowIcon.toLowerCase()) {
		        case "edit":
		            icons = editIcons;
		            break;
		        case "delete":
		            icons = deleteIcons;
		            break;
		        case "checkbox":
		            icons = checkBoxes;
		            break;
		        default:
		            throw new IllegalArgumentException("Unknown row icon: " + rowIcon);
		    }

		    System.out.println("Icons found: " + icons.size());

		    if (icons.isEmpty()) {
		        return false;   // Fail if no matching icons are found
		    }

		    for (WebElement icon : icons) {
		        if (!icon.isDisplayed()) {
		            return false;
		        }
		    }

		    return true;
		}
}
