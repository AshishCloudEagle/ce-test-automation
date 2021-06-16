package com.cloudeagle.framework.configreader;

import java.util.Properties;

import org.apache.log4j.Level;

import com.cloudeagle.framework.configuration.browser.BrowserType;
import com.cloudeagle.framework.interfaces.IconfigReader;
import com.cloudeagle.framework.utility.ResourceHelper;

public class PropertyFileReader implements IconfigReader {

	private Properties prop = null;

	public PropertyFileReader() {
		prop = new Properties();
		try {
			prop.load(ResourceHelper.getResourcePathInputStream("configfile/" + "config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUserName() {
		return prop.getProperty("UserName");
	}

	public String getPassword() {
		return prop.getProperty("Password");
	}

	public String hoverUserName() {
		return prop.getProperty("Username");
	}

	public String hoverPassword() {
		return prop.getProperty("Password");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	public String getWaitTime() {
		String time = prop.getProperty("wait.explicit.seconds");
		if (time != null)
			return time;
		else
			throw new RuntimeException("Time  is  not specified in the Configuration.properties file.");

	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	public String getDbType() {
		return prop.getProperty("DataBase.Type");
	}

	public String getDbConnStr() {
		return prop.getProperty("DtaBase.ConnectionStr");
	}

	public BrowserType getBrowser() {
		return BrowserType.valueOf(prop.getProperty("Browser"));
	}

	public String getFirstName() {
		return prop.getProperty("firstName");
	}

	public String getLastName() {
		return prop.getProperty("lastName");
	}

	public String getGender() {
		return prop.getProperty("gender");
	}

	public String getDOB() {
		return prop.getProperty("dob");
	}

	public Level getLoggerLevel() {

		switch (prop.getProperty("Logger.Level")) {

		case "DEBUG":
			return Level.DEBUG;
		case "INFO":
			return Level.INFO;
		case "WARN":
			return Level.WARN;
		case "ERROR":
			return Level.ERROR;
		case "FATAL":
			return Level.FATAL;
		}
		return Level.ALL;
	}

	@Override
	public String getServerInstanceName() {
		return prop.getProperty("ServerInstanceName");
	}

	@Override
	public String getURL() {
		return prop.getProperty("URL");
	}

	@Override
	public String getFileName() {
		return prop.getProperty("FileName");
	}

	@Override
	public String getProcessedBy() {
		return prop.getProperty("ProcessedBy");
	}

	@Override
	public String getStatus() {
		return prop.getProperty("Status");
	}

	@Override
	public String getRecordUploaded() {
		return prop.getProperty("RecordUploaded");
	}

	@Override
	public String getRecordInserted() {
		return prop.getProperty("RecordInserted");
	}

	@Override
	public String getRecordFailed() {
		return prop.getProperty("RecordFailed");
	}

	@Override
	public String getVendorName() {
		return prop.getProperty("VendorName");
	}

	@Override
	public String getApplicationName() {
		return prop.getProperty("ApplicationName");
	}

	@Override
	public String getApplicationVendorName() {
		return prop.getProperty("ApplicationVendor");
	}

	@Override
	public String getPublishedDocumentVendorName() {
		return prop.getProperty("PublishedDocumentVendorName");
	}

	@Override
	public int getPollingTime() {
		return Integer.parseInt(prop.getProperty("PollingTime"));
	}

	@Override
	public String getUploadedDocumentVendorName() {
		return prop.getProperty("UploadedDocumentVendorName");
	}

	@Override
	public String getRequestAccessApplicationName() {
		return prop.getProperty("RequestAccessApplicationName");
	}

	@Override
	public String getDashboardURL() {
		return prop.getProperty("DashboardURL");
	}

	@Override
	public String getExternalDataUploadURL() {
		return prop.getProperty("ExternalDataUploadURL");
	}

	@Override
	public String getExternalDataOnDemandSyncURL() {
		return prop.getProperty("ExternalDataOnDemandSyncURL");
	}

	@Override
	public String getVendorURL() {
		return prop.getProperty("VendorURL");
	}

	@Override
	public String getApplicationURL() {
		return prop.getProperty("ApplicationURL");
	}

	@Override
	public String getPublishedDocumentURL() {
		return prop.getProperty("PublishedDocumentURL");
	}

	@Override
	public String getUploadedDocumentURL() {
		return prop.getProperty("UploadedDocumentURL");
	}

	@Override
	public String getRequestAccessURL() {
		return prop.getProperty("RequestAccessURl");
	}

	@Override
	public String getSaaSDirectoryURL() {
		return prop.getProperty("SaaSDirectoryURL");
	}

	@Override
	public String getSaaSDirectoryProductName() {
		return prop.getProperty("SaaSDirectoryProductName");
	}

	@Override
	public String getVendorResearchURL() {
		return prop.getProperty("VendorResearchURL");
	}

	@Override
	public String getVendorResearchProductName() {
		return prop.getProperty("VendorResearchProductName");
	}
}
