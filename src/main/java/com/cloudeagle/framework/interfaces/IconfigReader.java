
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

	public String getExternalDataUploadURL();

	public String getExternalDataOnDemandSyncURL();

	public String getVendorURL();

	public String getApplicationURL();

	public String getPublishedDocumentURL();

	public String getUploadedDocumentURL();

	public String getRequestAccessURL();
	
	public String getSaaSDirectoryURL();
	
	public String getSaaSDirectoryProductName();
	
	public String getVendorResearchURL();
	
	public String getVendorResearchProductName();
	
	public String getExternalDataFinanceSystemsURL();
}
