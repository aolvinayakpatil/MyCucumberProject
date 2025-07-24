#Understand data driven framework in Cucumber
Feature: Login to Practice Test

Scenario Outline: Validate Login process with multiple test data

Given Launch page "https://practice.expandtesting.com/login"
When User enter username as "<UserName>"
When User enter password as "<PassWord>"
And Click on Login button
Then Home page should display

Examples:
|UserName|PassWord|
|practice|SuperSecretPassword!|
|Vinayak|Vinayak123|
|Vijay|Vijay123|
|practice|SuperSecretPassword!|