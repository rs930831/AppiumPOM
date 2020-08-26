package com.qa.util;

import java.util.Map;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.qa.capabilities.AndroidCapability;
import com.qa.capabilities.GeneralCapabilities;



public class DesiredCapabilitiesUtil {
private static DesiredCapabilities DS = new DesiredCapabilities();
	
    
	public static DesiredCapabilities getDesiredCapabilities(final Map<String, Object> capabilities) {
		Set<String> keyset = capabilities.keySet();
		keyset.forEach(key -> DS.setCapability(key, capabilities.get(key)));
		return DS;
	}
	
	
	public static DesiredCapabilities setBasicCapabilities(final String platformName,final String platformVersion, String deviceName) {
		DS.setCapability(GeneralCapabilities.platformName, platformName);
		DS.setCapability(GeneralCapabilities.platformVersion, platformVersion);
		DS.setCapability(GeneralCapabilities.deviceName, deviceName);
		return DS;
		
		
	}
	
	public static DesiredCapabilities setAppCapabilities(final String appPackage,final String appActivity) {
		DS.setCapability(AndroidCapability.appPackage, appPackage);
		setAppActivity(appActivity);
		return DS;
	}
	
	public  static DesiredCapabilities setAppCapabilities(final String appActivity) {
		setAppActivity(appActivity);
		return DS;
	}
	
	private static void setAppActivity(String appActivity) {
		DS.setCapability(AndroidCapability.appActivity, appActivity);
	}
			
}
