
package com.cloudeagle.framework.interfaces;

import com.cloudeagle.framework.configuration.browser.BrowserType;

public interface IconfigReader {

	public int getPageLoadTimeOut();

	public int getImplicitWait();

	public int getExplicitWait();

	public BrowserType getBrowser();

	public String getWaitTime();

	public String getServerInstanceName();

	public String getURL();

	public String getUserName();

	public String getPassword();

	public String getFileName();
	
	public String getVendorMetadataFileName();
	
	public String getApplicationMetadataFileName();

	public String getProcessedBy();

	public String getStatus();

	public String getRecordUploaded();

	public String getRecordInserted();

	public String getRecordFailed();

	public String getVendorName();

	public String getApplicationName();

	public String getApplicationVendorName();

	public String getPublishedDocumentVendorName();

	public int getPollingTime();

	public String getUploadedDocumentVendorName();

	public String getRequestAccessApplicationName();

	public String getDashboardURL();

	public String getExternalDataUploadTransactionsURL();

	public String getExternalDataVendorMetadataURL();
	
	public String getExternalDataApplicationMetadataURL();
	
	public String getExternalDataOnDemandSyncSingleSignOnURL();

	public String getVendorURL();

	public String getApplicationURL();

	public String getPublishedDocumentURL();

	public String getUploadedDocumentURL();

	public String getRequestAccessURL();

	public String getSaaSDirectoryURL();

	public String getSaaSDirectoryVendorName();
	
	public String getSaaSDirVendorProductName();
	
	public String getSaaSDirectoryCategoryName();
	
	public String getSaaSDirCategoryProductName();
	
	public String getVendorResearchURL();

	public String getVendorResearchProductName();

	public String getExternalDataOnDemandSyncFinanceSystemsURL();

	public String getExternalDataDataFinanceSystemsNewVendorFoundURL();

	public String getNewVendorName();

	public String getExternalDataDataFinanceSystemsConfirmedVendorsURL();

	public String getConfirmedVendorName();

	public String getExternalDataDataFinanceSystemsRejectedVendorsURL();

	public String getRejectedVendorName();

	public String getExternalDataDataFromSSOSystemsNewAppsFoundURL();

	public String getNewAppName();

	public String getExistingAppName();

	public String getExternalDataDataFromSSOSystemsConfirmedAppsURL();

	public String getConfirmedApp();

	public String getExternalDataDataFromSSOSystemsRejectedAppsURL();

	public String getRejectedApp();

	public String getAdminURL();

	public String getAdminFinanceSystemsURL();

	public String getAdminAlertURL();

	public String getAdminRolesAndUsersUsersURL();

	public String getAdminRolesAndUsersRolesURL();
	
	public String getUserEmail();

	public String getRole();

	public String getAdminRolesAndUsersDepartmentURL();

	public String getDepartment();

	public String getAdminSettingURL();

	public String getExistingVendorName();
}
