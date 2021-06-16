Feature: External Data Scenarios 

#CE-662
Scenario: Verify external data - on demand sync scenario
	Given user logged in successfully  
	When user navigate to on demand sync page
	Then user must be landing on on-demand sync page
	And user must be able to view sidebar options

#CE-672
Scenario: Verify external data - excel upload scenario
	Given user logged in successfully  
	When user navigate to external data upload page
	Then user must be able to view external data upload table
	When user click on upload button 	
	Then user must be able to view upload model
	
#CE-663
Scenario: Verify external data - on demand sync - single sign on scenario
	Given user logged in successfully  
	When user navigate to on demand sync single sign on page
	Then user must be landing on on-demand sync single sign on page
	And user must be able to view single sign on header	
	
#CE-665
Scenario: Verify external data - on demand sync - finance systems scenario
	Given user logged in successfully  
	When user navigate to on demand sync finance systems page
	Then user must be landing on on-demand sync finance systems page
	And user must be able to view finance systems header	
