package com.qa.locator;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


/**
* The BaseLocator class contains an inner class 'BaseLocaterLoader' whose objects are mapped to basepage.yaml
* 
* Modify this class accordingly to your project need (yaml file)
*
* @author  Rajshekhar Salimath
* @email rs930831@gmail.com
* @version 1.0
* @since   2020-08-26 
*/
public class BaseLocator {
	private Map<String, Map<String, String>> elements;
	
	public BaseLocator(String platform) {
		BaseLocaterLoader loader = BaseLocaterLoader.loadBaseLocator();
		this.elements = loader.enUS.get("elements");
	}
	
	public Map<String, Map<String, String>> getElements() {
		return this.elements;
	}
	
	public static class BaseLocaterLoader {
		// TODO let file path be at config file 
		private static final String filename = "src/test/resources/locators/basepage.yaml";
		static final BaseLocaterLoader baselocatorloader = loadBaseLocator();
		
		private BaseLocaterLoader() {}
		private static BaseLocaterLoader loadBaseLocator() {
			ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
			BaseLocaterLoader localbaselocator = null;
			try {
				localbaselocator = mapper.readValue(new File(filename), BaseLocaterLoader.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return localbaselocator;
		}
		private String defaultClient;
		private String defaultLocale;
		private Map<String, Map<String, Map<String, String>>> enUS;
		public String getDefaultClient() {
			return defaultClient;
		}
		public void setDefaultClient(String defaultClient) {
			this.defaultClient = defaultClient;
		}
		public String getDefaultLocale() {
			return defaultLocale;
		}
		public void setDefaultLocale(String defaultLocale) {
			this.defaultLocale = defaultLocale;
		}
		public Map<String, Map<String, Map<String, String>>> getEnUS() {
			return enUS;
		}
		public void setEn_US(Map<String, Map<String, Map<String, String>>> en_US) {
			this.enUS = en_US;
		}
		public static BaseLocaterLoader getBaselocator() {
			return baselocatorloader;
		}
	}

	
	public static void doSomething() {
		BaseLocaterLoader loader = BaseLocaterLoader.loadBaseLocator();
		System.out.println(loader.defaultClient);
	}
		
}	

