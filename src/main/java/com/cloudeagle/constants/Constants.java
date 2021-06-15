
package com.cloudeagle.constants;

import com.cloudeagle.framework.settings.ObjectRepo;

public class Constants {

	public static final int WAIT_EXPLICIT_SEC = ObjectRepo.reader.getExplicitWait();
	public static final int WAIT_POLLING_MS = ObjectRepo.reader.getPollingTime();
}