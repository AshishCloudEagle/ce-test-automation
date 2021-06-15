Feature: Request Access Scenarios 

#CE-659
Scenario: Verify request access page
	Given user logged in successfully  
	When user navigate to request access page
	Then user must be able to view request access table