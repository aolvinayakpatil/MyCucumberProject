#Demo for understanding the concept of passing data to step definition
@AllTest
Feature: Rediff Registration

Background:
Given Open rediff registration page

@Sanity
Scenario: Validate registration process with Valid data

When User enters valid full name as "Vishal Patil"
When User enters valid rediffid as "VPatil1238"
When User enters valid password as "Vishal_123"
When User re-enters password as "Vishal_123"
When User Select birth date as
|29|JAN|1979|
And User click on Check availability button
Then Rediff id available message should display

@Regression
Scenario: Validate registration process with Invalid data

When User enters Invalid full name as "Vinayak Patil"
When User enters Invalid rediffid as "VinayakPatil123"
When User enters Invalid password as "Vishal_123"
When User re-enters Invalid password as "Vishal_123"
When User Selects DOB as
|Day|Month|Year|
|18|MAY|1992|
And User clicks on Check availability button
Then Rediff id not available message should display