@AddNewProgramFunctional
Feature: Add New Program Functional validation 

Background: 
Given Admin is on Program details dialog box

@EmptyFormSubmission
Scenario Outline:
When Admin clicks save button without entering mandatory
Then Admin gets message "<fieldmessage>" is required
Examples:
|fieldmessage|
|Program name|
|Status|

@CancelButtonFunction
Scenario:
When Admin clicks Cancel button
Then Admin can see Program Details form disappears

@CloseButtonFunction
Scenario:
When Admin clicks X button
Then Admin can see Program Details form disappears

@ValidMandatoryDetails
Scenario:
When Admin enter valid details for mandatory fields and Click on save button
Then Admin gets message 'Successful Program created'

@InvalidProgramDetails
Scenario:
When Admin enters a numeric value as the Program Name
Then Admin should see error message as "This field should start with an alphabet"




