Feature: Dashboard Scenarios 

Scenario: Verify dashboard page 
	Given user logged in successfully  
	When user navigate to dashboard page
	Then user must be able to view user details
	And user must be able to view page headers 	
	And user must be able to view sidebar menus

Scenario: Verify dashboard tables 
	Given user logged in successfully  
	When user navigate to dashboard page
	Then User must be able to view tables from dashboard
	
Scenario: Verify inProgress tab 
	Given user logged in successfully  
	When user navigate to inPogress tab
	Then User must be able to view inPogress table
	 
Scenario: Verify resolved tab 
	Given user logged in successfully  
	When user navigate to resolved tab
	Then User must be able to view resolved table	

Scenario: Verify snoozed page 
	Given user logged in successfully  
	When user navigate to snoozed tab
	Then User must be able to view snoozed table	