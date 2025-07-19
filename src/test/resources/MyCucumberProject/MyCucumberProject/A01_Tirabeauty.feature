Feature: Tira Beauty menu pages validation
Background: 
Given User should launch tirabeauty

Scenario: Validate Makeup page url
When User click on Makeup
Then Makeup url should display

Scenario: Validate Skin page url
When User click on Skin
Then Skin url should display

Scenario: Validate Men page url
When User click on Men
Then Men url should display

Scenario: Validate Mom&Beauty page url
When User click on Mom&Beauty
Then Mom&Beauty url should display