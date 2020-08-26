package com.qa.test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.util.UiUtil;
import com.qa.webdriver.manage.DriverManager;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
* The BaseTest class initiates the WebDriver as per the capabilities and type provided by the testng.xml.
* also initiates the UiUtil class by passing the driver so that Ui Actions can be performed with same driver
* 
* Modify this class only after complete understanding of this framework
*
* @author  Rajshekhar Salimath
* @email rs930831@gmail.com
* @version 1.0
* @since   2020-08-26 
*/
public class BaseTest {
	private static WebDriver driver;
	//protected static Properties properties;
	protected static UiUtil uiutil;
	protected static String platformTesttype = null;
	
	public BaseTest() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@Parameters({"testType", "platformName", "platformVersion", "deviceName"})
	  @BeforeClass
	  public void beforeTest(final String testType,final String platformName,final String platformVersion,final String deviceName) throws IOException, InterruptedException {
		System.out.println("[BaseTest][beforeTest]");
		setPlatformTestType(testType);
		if (driver == null) {
			driver = DriverManager.getDriver(testType, platformName, platformVersion, deviceName);
			System.out.println("[BaseTest][beforeTest][AppiumDriver has been assigned]");
			uiutil = new UiUtil(driver);
			System.out.println("[BaseTest][beforeTest][AppiumUiUtil has been assigned]");
		  }
		}
	  
	  private void setPlatformTestType(String testType) {
		  System.out.println("[BaseTest][setPlatformTestType]");
		  switch (testType) {
			case "androidApp":
				System.out.println("[BaseTest][setPlatformTestType] Setting platformTesttype to 'android'");
				platformTesttype = "android";
				break;
			
			case "androidWeb":
				System.out.println("[BaseTest][setPlatformTestType] Setting platformTesttype to 'mweb'");
				platformTesttype = "mweb";
				break;

			default:
				throw new IllegalArgumentException("[BaseTest][setPlatformTestType] Failed to set platformTesttype. As Provided 'testType' "+testType+" is not identified. Kindly provide provide one among in the given below\n"
						+ "androidApp\n"
						+ "androidWeb\n");
			}
	}


	@AfterClass
	  public void afterTest() throws InterruptedException {
		  driver.quit();
	}
}
