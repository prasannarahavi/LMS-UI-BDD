@AddNewProgram
Feature: Add New Program UI validation 

Background: Admin is on Program Page after login
Given Admin is on Program Page
When Admin clicks on Add New Program under the Program menu bar

@ProgramPopupDisplay
Scenario:
Then Admin should see Program Details dialog box

@ProgramDetailTitle
Scenario:
Then Admin should see  title as "Program Details"

@MandatoryFields
Scenario Outline:
Then Admin should see red  asterisk mark beside mandatory field "<FieldName>"
Examples:
|FieldName|
|Name|
|Status|

@FieldTextBox
Scenario Outline:
Then Admin should see the "<FieldTextBox>"
Examples:
|FieldTextBox|
|NameTextBox|
|DescriptionTextBox|

@StatusRadioButton
Scenario Outline:
Then Admin should see "<Options>" radio buttons
Examples:
|Options|
|Active|
|Inactive|





