@LoginPage
Feature: Login Page - UI Verification

Background:


@ValidURL
Scenario:
Given Admin is on the browser
When Admin enters the Valid LMS app URL
Then Admin should land on the login page

@LoginWithValidCredentials
Scenario:
Given Admin is on login Page
When Admin clicks login in button after entering  a valid credential
Then Admin should land on home page