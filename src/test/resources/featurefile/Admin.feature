Feature: Vendor Scenarios 

#CE-673
Scenario: Verify admin page
	Given user logged in successfully  
	When user navigate to admin page
	Then user must be landing on admin page
	And user must be able to view admin sidebar menus

#CE-674
Scenario: Verify admin - single sign on scenario
	Given user logged in successfully  
	When user navigate to on admin single sign on page
	Then user must be landing on admin single sign on page
	And user must be able to view integration tools list