
package com.cloudeagle.framework.interfaces;

import com.cloudeagle.framework.configuration.browser.BrowserType;

public interface IconfigReader {

	public String getAdminWebsite();

	public String getAdminUserName();

	public String getAdminPassword();

	public String getMOVRWebsite();

	public String getMovrUserName();

	public String getMovrPassword();

	public int getPageLoadTimeOut();

	public int getImplicitWait();

	public int getExplicitWait();

	public BrowserType getBrowser();

	public String getHomePageTitle();

	public String getFindAgentTitle();

	public String getHomeSelectionTitle();

	public String getFaqPageTitle();

	public String getAgentProposalTitle();

	public String getBuyProcessTitle();

	public String getLoanApprovalTitle();

	public String getPriceRangeTitle();

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

}
