package com.qa.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


/**
* The UiUtil class contains general methods like click, waitforelement, etc to reduce the code redundency
* and also for the easy maintainance of the business logic.
* 
* Have a look at this class before writing invoking the driver methods
* 
* Modify this class accordingly to your project need (yaml file)
*
* @author  Rajshekhar Salimath
* @email rs930831@gmail.com
* @version 1.0
* @since   2020-08-26 
*/
public class UiUtil {
	private WebDriver driver;
	private static final long DEFAULT_WAIT = 10L;
	
	public UiUtil(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
	}
	
	
	public boolean checkElementPresent(By searchBy, long timeOutInSeconds) {
		try {
			waitUntilVisibilityOfElement(searchBy,timeOutInSeconds);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	private void waitUntilVisibilityOfElement(By searchBy, long timeOutInSeconds) {
		System.out.println("[AppiumUiUtil][waitUntilVisibilityOfElement][With searchBy and Explicit Timeout ]"+ timeOutInSeconds + " Seconds");
		System.out.println("[AppiumUiUtil][waitUntilVisibilityOfElement] is driver null "+ (this.driver == null));
		WebDriverWait wait = new WebDriverWait(this.driver, timeOutInSeconds);
		System.out.println("[AppiumUiUtil][waitUntilVisibilityOfElement] Waiting... ");
		WebElement elementwaitingfor = wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchBy)));
		System.out.println("[AppiumUiUtil][waitUntilVisibilityOfElement] Wait Completed, Elemenet Found "+ (elementwaitingfor != null));
	}


	public void waitUntilVisibilityOfElement(MobileElement me) {
		waitUntilVisibilityOfElement(me ,DEFAULT_WAIT);
	}
	
	
	public void waitUntilVisibilityOfElement(final MobileElement me ,final long timeOutInSeconds) {
		System.out.println("[AppiumUiUtil][waitUntilVisibilityOfElement][With Explicit Timeout ]"+ timeOutInSeconds + " Seconds");
		System.out.println("[AppiumUiUtil][waitUntilVisibilityOfElement] is driver null "+ (this.driver == null));
		WebDriverWait wait = new WebDriverWait(this.driver, timeOutInSeconds);
		System.out.println("[AppiumUiUtil][waitUntilVisibilityOfElement] Waiting... ");
		
		WebElement elementwaitingfor = wait.until(ExpectedConditions.visibilityOf(me));
		System.out.println("[AppiumUiUtil][waitUntilVisibilityOfElement] Wait Completed, Elemenet Found "+ (elementwaitingfor != null));
	}
	
	public void click(final MobileElement me,final  long timeOutInSeconds) {
		waitUntilVisibilityOfElement(me, timeOutInSeconds);
		me.click();
	}
	
	public void click(final MobileElement me) {
		click(me, DEFAULT_WAIT);
	}
	
	public void clickIfPresent(final MobileElement me ,final long timeOutInSeconds) {
		System.out.println("[AppiumUiUtil][clickIfPresent]");
		if(checkElementPresent(me, timeOutInSeconds))
			click(me, timeOutInSeconds);
	}
	
	public void clickIfPresent(final MobileElement me) {
		System.out.println("[AppiumUiUtil][clickIfPresent] With Default wait time");
		clickIfPresent(me, DEFAULT_WAIT);
	} 

	public void sendKeys(final MobileElement me,final String keyToSend ,final long timeOutInSeconds) {
		waitUntilVisibilityOfElement(me, timeOutInSeconds);
		me.sendKeys(keyToSend);
	}
	
	public void sendKeys(final MobileElement me, final String keyToSend) {
		waitUntilVisibilityOfElement(me, DEFAULT_WAIT);
		sendKeys(me, keyToSend ,DEFAULT_WAIT);
	}
	
	@SuppressWarnings("rawtypes")
	public void scrollForAndroidTillResourceId(String resourceId) {
		((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""+resourceId+"\").instance(0));");
	}
	
	public boolean checkElementPresent(final MobileElement me,final long timeOutInSeconds) {
		System.out.println("[AppiumUiUtil][checkElementPresent]");
		try {
			System.out.println("[AppiumUiUtil][checkElementPresent][invoking explicit wait untill visibility of element]");
			waitUntilVisibilityOfElement(me,timeOutInSeconds);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void clickAndroidKey(final AndroidKey key) {
		((AndroidDriver<WebElement>) driver).pressKey(new KeyEvent(key));
	}
    
	public String getText(final MobileElement me,final long timeOutInSeconds) {
		waitUntilVisibilityOfElement(me, timeOutInSeconds);
		return me.getText();
	}
	
	public String getText(final MobileElement me) {
		return getText(me, DEFAULT_WAIT);
	}


	public void click(By searchBy) {
		click(searchBy, DEFAULT_WAIT);
	}


	public void click(By searchBy, long timeOutInSeconds) {
		waitUntilVisibilityOfElement(searchBy, timeOutInSeconds);
		driver.findElement(searchBy).click();
	}
}
