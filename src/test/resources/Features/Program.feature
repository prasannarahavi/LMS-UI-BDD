@Programuivalidation
Feature: Program Navigation Validation

Background: Admin is logged in to LMS Portal
Given Admin is on home page after Login
When Admin clicks Program on the navigation bar

@ProgramPageNavigation
Scenario:
Then Admin should be navigated to Program page

@SubMenuDisplay
Scenario:
Then Admin should see sub menu in menu bar as "Add New Program"

@ManageProgramHeading
Scenario:
Then Admin should see the heading "Manage Program"

@ManageProgramAlignment
Scenario:
Then Admin should see manage program heading aligned on the left side

@DeleteButtonState
Scenario:
Then Admin should see a Delete button in left top is disabled

@SearchBoxDisplay
Scenario:
Then Admin should see Search bar

@SearchPlaceholder
Scenario:
Then Admin should see search... placeholder text

@ColumnHeaderName
Scenario Outline:
Then Admin should see data table with '<columnheader>' on Manage Program Page
Examples:
|columnheader|
|Program Name|
|Program Description|
|Program Status|
|Edit/Delete|

@CheckboxHeaderState
Scenario:
Then Admin should see checkbox default state as unchecked beside Program Name column header

@SortIconPrescence
Scenario:
Then Admin should see the sort arrow icon beside to each column header except Edit and Delete

#@Edit/DeleteIcon
#Scenario:
#Then Admin should see the Edit and Delete buttons on each row of the data table

@PaginationControl
Scenario:
Then Admin should see the following pagination controls below the table:
  | Showing x to y of z entries |
  | Double Left Icon            |
  | Single Left Icon            |
  | Pagination Pages            |
  | Single Right Icon           |
  | Double Right Icon           |

@FooterMessage
Scenario:
Then Admin should see the footer as "In total there are z programs"
 
