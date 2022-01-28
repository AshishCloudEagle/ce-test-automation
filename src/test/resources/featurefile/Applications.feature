Feature: Applications Scenarios 

Scenario: Verify applications page
	Given user logged in successfully  
	When user navigate to applications page
	Then user must be landing on applicatios page
	And user must be able to view applications page header and table
