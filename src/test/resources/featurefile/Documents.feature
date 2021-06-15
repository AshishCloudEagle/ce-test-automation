Feature: Documents Scenarios 

#CE-657
Scenario: Verify documents page - published document scenario
	Given user logged in successfully  
	When user navigate to documents page
	And user click on published documents
	Then user must be able to view published documents table

#CE-658
Scenario: Verify documents page - uploaded document scenario
	Given user logged in successfully  
	When user navigate to documents page
	And user click on uploaded documents
	Then user must be able to view uploaded documents table
