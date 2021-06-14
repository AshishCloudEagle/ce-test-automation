Feature: External Data Scenarios 

Scenario: External Data 
	Given user logged in successfully  
	When user navigate to on demand sync page
	Then user must be landing on on-demand sync page
	And user must be able to view sidebar options

Scenario: External Data Upload
	Given user logged in successfully  
	When user navigate to external data upload page
	Then user must be able to view external data upload table
	When user click on upload button 	
	Then user must be able to view upload model
