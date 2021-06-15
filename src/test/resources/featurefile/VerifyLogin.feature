Feature: Login Scenarios 

Scenario: Verify user must able to login into the application 
	Given user reached on login screen 
	When  user enters credentials and click on Sign in button 
	Then  user must reached to landing page validate by title
