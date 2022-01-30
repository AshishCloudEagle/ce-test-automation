Feature: SaaS Directory Scenarios 

Scenario: Verify saas directory page and search by Vendor name
	Given user logged in successfully  
	When user navigate to saas directory page
	Then user must be able to view saas directory header
	When user search with vendor name  
	And user must be able to view product list for searched vendor
	And verify one product under the searched vendor
	
Scenario: Verify search by Category
	Given user logged in successfully  
	When user navigate to saas directory page
	Then user must be able to view saas directory header
  When user search with category name  
	And user must be able to view product list for searched category
	And verify one product under the searched category