package com.cloudeagle.framework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * @author krana
 *
 */
public class ResourceHelper {

	public static String getResourcePath(String resource) {
		String path = getBaseResourcePath() + resource;
		return path;
	}

	public static String getBaseResourcePath() {
		String path = ResourceHelper.class.getResource("/").getPath();
		return path;
	}

	public static InputStream getResourcePathInputStream(String resource) throws FileNotFoundException {
		String abc=ResourceHelper.getResourcePath(resource);
		System.out.println(abc);
		abc.substring(0);
		System.out.println(abc);
		return new FileInputStream(abc);
	}

}
