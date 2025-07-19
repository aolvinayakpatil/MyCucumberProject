Feature: Orange HRM login
Background: 
Given User should launch browser
Scenario: Verify login functionality with valid credentials
When User enters valid userid
When User enters valid password
And User clicks on Login button
Then Dashboard page should display

Scenario: Verify login functionality with invalid credentials

When User enters invalid userid
When User enters invalid password
And Clicks on Login button
Then Error message should display

