Feature: Applications Scenarios 

#CE-656
Scenario: Verify applications page
	Given user logged in successfully  
	When user navigate to applications page
	Then user must be able to view applications header
	And user must be able to view applications table
