
package com.cloudeagle.constants;

import com.cloudeagle.framework.settings.ObjectRepo;

public class Constants {
	public static final int WAIT_EXPLICIT_SEC = ObjectRepo.reader.getExplicitWait();
	public static final int WAIT_POLLING_MS = ObjectRepo.reader.getPollingTime();
	public static final String URL = ObjectRepo.reader.getURL() + "app/";
	public static final int LOADER_WAIT = 180;
	public static final boolean IS_HEADLESS = Boolean.parseBoolean(System.getProperty("isHeadless"));
}