package com.qa.webdriver.manage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qa.util.DesiredCapabilitiesUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {
	static Properties properties = new Properties();
	private static WebDriver appiumDriver;
	private static final long DEFAULT_TIME = 10L;
	
	public static WebDriver getAppiumDriver() throws Exception {
		if (appiumDriver == null) {
			throw new Exception("Appium Driver has not yet Initialized, Kindly do call 'getAppiumDriver(String testType, String platformName, String platformVersion, String deviceName)' before this get call");
		}
		return appiumDriver;
	}

	public static WebDriver getDriver(String testType, String platformName, String platformVersion, String deviceName) throws FileNotFoundException, IOException {
		
		properties.load(new FileReader("src/test/resources/config/config.properties"));
		
		switch (testType) {
		case "androidApp":
			appiumDriver = getDriverForAndroidApp(platformName, platformVersion, deviceName, properties);
			appiumDriver.manage().timeouts().implicitlyWait(DEFAULT_TIME, TimeUnit.SECONDS);
			break;
		
		case "androidWeb":
			appiumDriver = getDriverForAndroidWeb(platformName, platformVersion, deviceName, properties);
			appiumDriver.manage().timeouts().implicitlyWait(DEFAULT_TIME, TimeUnit.SECONDS);
			break;

		default:
			throw new IllegalArgumentException("Failed to set Capabilities. As Provided 'testType' "+testType+" is not identified. Kindly provide provide one among in the given below\n"
					+ "androidApp\n"
					+ "androidWeb\n");
		}
		
		return appiumDriver;
	}

	private static AppiumDriver<WebElement> getDriverForAndroidWeb(String platformName, String platformVersion, String deviceName, Properties properties) throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = DesiredCapabilitiesUtil.setBasicCapabilities(platformName, platformVersion, deviceName);
		//desiredCapabilities.setCapability(GeneralCapabilities.browserName.name(), "Chrome");
		System.out.println("[BaseTest][beforeTest]");desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		
		URL appiumUrl = getAppiumHubUrl(properties);
		//return new AppiumDriver<WebElement>(appiumUrl, desiredCapabilities);
		return new AndroidDriver<WebElement>(appiumUrl, desiredCapabilities);
	}

	private static URL getAppiumHubUrl(Properties properties2) throws MalformedURLException {
		return new URL(properties.getProperty("appium.server.url"));
	}

	private static AppiumDriver<WebElement> getDriverForAndroidApp(String platformName, String platformVersion, String deviceName, Properties properties) throws FileNotFoundException, IOException {
		DesiredCapabilities desiredCapabilities = DesiredCapabilitiesUtil.setBasicCapabilities(platformName, platformVersion, deviceName);
		DesiredCapabilitiesUtil.setAppCapabilities(properties.getProperty("android.app.packageName"), properties.getProperty("android.app.activityName"));
		URL appiumUrl = getAppiumHubUrl(properties);
		//return new AppiumDriver<WebElement>(appiumUrl, desiredCapabilities);
		return new AndroidDriver<WebElement>(appiumUrl, desiredCapabilities);
	}
	
	
}
