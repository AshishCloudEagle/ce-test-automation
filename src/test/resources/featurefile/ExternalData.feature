Feature: External Data Scenarios 

Scenario: Verify external data - on demand sync scenario
	Given user logged in successfully  
	When user navigate to on demand sync page
	Then user must be landing on on-demand sync page
	And user must be able to view side bar options

Scenario: Verify external data - transactions excel upload scenario
	Given user logged in successfully  
	When user navigate to transactions excel data upload page
	Then user must be able to view transactions data upload table
	When user click on upload button for transactions	
	Then user must be able to view upload model for transactions
	
Scenario: Verify external data - vendor metadata excel upload scenario
	Given user logged in successfully  
	When user navigate to vendor metadata upload page
	Then user must be able to view vendor metadata upload table
	When user click on upload button for vendor metadata	
	Then user must be able to view upload model for vendor metadata
	
Scenario: Verify external data - application metadata excel upload scenario
	Given user logged in successfully  
	When user navigate to application metadata upload page
	Then user must be able to view application metadata upload table
	When user click on upload button for application metadata	
	Then user must be able to view upload model for application metadata
	
Scenario: Verify external data - on demand sync - single sign on scenario
	Given user logged in successfully  
	When user navigate to on demand sync single sign on page
	Then user must be landing on on-demand sync single sign on page
	And user must be able to view single sign on header	
	
Scenario: Verify external data - on demand sync - finance systems scenario
	Given user logged in successfully  
	When user navigate to on demand sync finance systems page
	Then user must be landing on on-demand sync finance systems page
	And user must be able to view finance systems header	
	
Scenario: Verify external data - data from finance systems - new vendors found
	Given user logged in successfully  
	When user navigate to data from finance systems new vendors found page
	Then user must be landing on data from finance systems new vendors found page
	And user must be able to view new vendors found table
	When user click on match not found tab
	Then user must be able to view match not found vendor table
	When user click on existing vendor
	Then user must be able to view slider
	And user must be able to view existing vendor records
	And user close the slider
	
Scenario: Verify external data - data from finance systems - confirmed vendors
	Given user logged in successfully  
	When user navigate to data from finance systems confirmed vendors page
	Then user must be landing on data from finance systems confirmed vendors page
	And user must be able to view confirmed vendors table
	
Scenario: Verify external data - data from finance systems - rejected vendors
	Given user logged in successfully  
	When user navigate to data from finance systems rejected vendors page
	Then user must be landing on data from finance systems rejected vendors page
	And user must be able to view rejected vendors table
	When user click on existing vendor
	Then user must be able to view slider
	And user must be able to view existing vendor records
	And user close the slider

Scenario: Verify external data - data from sso systems - new apps found
	Given user logged in successfully  
	When user navigate to data from sso systems new apps found page
	Then user must be landing on data from sso systems new apps found page
	And user must be able to view new apps found table
	When user click on existing vendor
	Then user must be able to view slider
	And user must be able to view existing vendor records
	And user close the slider
	When user click on existing application for new app found page
	Then user must be able to view slider of application for new app found page
	And user must be able to view existing application records for new app found page
	
Scenario: Verify external data - data from sso systems - confirmed apps
	Given user logged in successfully  
	When user navigate to data from sso systems confirmed apps page
	Then user must be landing on data from sso systems confirmed apps page
	And user must be able to view confirmed apps table
	
Scenario: Verify external data - data from sso systems - rejected apps
	Given user logged in successfully  
	When user navigate to data from sso systems rejected apps page
	Then user must be landing on data from sso systems rejected apps page
	And user must be able to view rejected apps table
	When user click on existing vendor
	Then user must be able to view slider
	And user must be able to view existing vendor records
	And user close the slider
	When user click on existing application for rejected app page
	Then user must be able to view slider of application for rejected app page 
	And user must be able to view existing application records for rejected apps