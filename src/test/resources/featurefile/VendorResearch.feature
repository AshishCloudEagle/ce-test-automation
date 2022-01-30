Feature: Vendor Research Scenarios 

Scenario: Verify vendor research page
	Given user logged in successfully  
	When user navigate to vendor research page
	Then user must be able to view vendors research header
	When user search by vendor name
	Then user must be able to view related results
