@Logout
Feature: Logout Functionality

Background: Admin is logged into the application

@LogoutFunction
Scenario:
Given Admin is in home page
When Admin clicks on the logout in the menu bar
Then Admin should be redirected to login page
