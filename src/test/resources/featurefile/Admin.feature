Feature: Vendor Scenarios 

#CE-673
Scenario: Verify admin page
	Given user logged in successfully  
	When user navigate to admin page
	Then user must be landing on admin page
	And user must be able to view admin sidebar menus
