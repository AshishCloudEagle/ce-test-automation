Feature: Applications Scenarios 


Scenario: Applications Page
	Given user logged in successfully  
	When user navigate to Applications page
	Then user must be able to view Applications header
	And user must be able to view Applications table
