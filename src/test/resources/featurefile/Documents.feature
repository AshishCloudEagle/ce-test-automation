Feature: Documents Scenarios 


Scenario: Documents Page Published Documents
	Given user logged in successfully  
	When user navigate to documents page
	And user click on published documents
	Then user must be able to view documents table
