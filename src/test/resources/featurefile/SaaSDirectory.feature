Feature: SaaS Directory Scenarios 

#CE-660
Scenario: Verify saas directory page
	Given user logged in successfully  
	When user navigate to saas directory page
	Then user must be able to view saas directory header
	And CRM Software filter should be selected 
	And verify at least one result box from Product list