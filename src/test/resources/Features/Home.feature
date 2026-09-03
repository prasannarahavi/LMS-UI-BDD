@HomePage
Feature: Home Page

Background: Admin gives the valid LMS portal URL

@HomePageTitle
Scenario:
Given Admin is on LoginPage
When Admin clicks login button after entering a valid credential
Then Admin should see "LMS - Learning Management System" as title