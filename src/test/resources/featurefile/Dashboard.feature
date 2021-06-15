Feature: Dashboard Scenarios 

#CE-654
Scenario: Verify dashboard page 
	Given user logged in successfully  
	When user navigate to dashboard page
	Then user must be able to view user details
	And user must be able to view page headers 	
	And user must be able to view sidebar menus
