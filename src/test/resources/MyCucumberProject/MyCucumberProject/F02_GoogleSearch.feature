Feature: Google Search

Scenario: To validate Google search functionality

Given User launch Google
When User enters any keyword to search
And User press enter key
Then Valid search result should display
