Feature: External Data Scenarios 

#CE-662
Scenario: Verify external data - on demand sync scenario
	Given user logged in successfully  
	When user navigate to on demand sync page
	Then user must be landing on on-demand sync page
	And user must be able to view side bar options

#CE-672
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
	
#CE-666
Scenario: Verify external data - data from finance systems - new vendors found
	Given user logged in successfully  
	When user navigate to data from finance systems new vendors found page
	Then user must be landing on data from finance systems new vendors found page
	And user must be able to view new vendors found table
	When user click on existing vendor
	Then user must be able to view slider
	And user must be able to view existing vendor records
	And user close the slider
	
#CE-667	
Scenario: Verify external data - data from finance systems - confirmed vendors
	Given user logged in successfully  
	When user navigate to data from finance systems confirmed vendors page
	Then user must be landing on data from finance systems confirmed vendors page
	And user must be able to view confirmed vendors table
	
#CE-668	
Scenario: Verify external data - data from finance systems - rejected vendors
	Given user logged in successfully  
	When user navigate to data from finance systems rejected vendors page
	Then user must be landing on data from finance systems rejected vendors page
	And user must be able to view rejected vendors table
	
#CE-669
Scenario: Verify external data - data from sso systems - new apps found
	Given user logged in successfully  
	When user navigate to data from sso systems new apps found page
	Then user must be landing on data from sso systems new apps found page
	And user must be able to view new apps found table
	When user click on existing vendor
	Then user must be able to view slider
	And user must be able to view existing vendor records
	And user close the slider
	When user click on existing application
	Then user must be able to view slider of application
	And user must be able to view existing application records
	
#CE-670	
Scenario: Verify external data - data from sso systems - confirmed apps
	Given user logged in successfully  
	When user navigate to data from sso systems confirmed apps page
	Then user must be landing on data from sso systems confirmed apps page
	And user must be able to view confirmed apps table
	
#CE-671
Scenario: Verify external data - data from sso systems - rejected apps
	Given user logged in successfully  
	When user navigate to data from sso systems rejected apps page
	Then user must be landing on data from sso systems rejected apps page
	And user must be able to view rejected apps table
	When user click on existing vendor
	Then user must be able to view slider
	And user must be able to view existing vendor records
	And user close the slider
	When user click on existing application
	Then user must be able to view slider of application
	And user must be able to view existing application records