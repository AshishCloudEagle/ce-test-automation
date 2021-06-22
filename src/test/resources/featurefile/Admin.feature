Feature: Admin Scenarios 

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
	
#CE-675
Scenario: Verify admin - integration - finance systems scenario
	Given user logged in successfully  
	When user navigate to on admin integration finance systems page
	Then user must be landing on admin integration finance systems page
	And user must be able to view finance systems integration tools list
	
#CE-676
Scenario: Verify admin - alert
	Given user logged in successfully  
	When user navigate to on admin alert page
	Then user must be landing on admin alert page
	
#CE-677
Scenario: Verify admin - roles and users
	Given user logged in successfully  
	When user navigate to on admin roles and users page
	Then user must be landing on roles and users page
	And user must be able to view roles and users table
	When user click on add new user
	Then user must be able to view add new user model
	
#CE-678
Scenario: Verify admin - roles and users - roles
	Given user logged in successfully  
	When user navigate to on admin roles and users roles page
	Then user must be landing on roles and users roles page
	And user must be able to view roles and users roles table
	When user click on create role
	Then user must be able to view create role model
	
#CE-679
Scenario: Verify admin - roles and users - departments
	Given user logged in successfully  
	When user navigate to on admin roles and users departments page
	Then user must be landing on roles and users departments page
	And user must be able to view roles and users department table
	When user click on create department
	Then user must be able to view create department model

#CE-680
Scenario: Verify admin - settings
	Given user logged in successfully  
	When user navigate to on admin settings page
	Then user must be landing on admin settings page