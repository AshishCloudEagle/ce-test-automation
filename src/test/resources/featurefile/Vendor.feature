Feature: Vendor Scenarios 

#CE-655
Scenario: Verify vendor page
	Given user logged in successfully  
	When user navigate to vendor page
	Then user must be able to view vendors header
	And user must be able to view vendor table
