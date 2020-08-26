package com.qa.page;

import java.util.Map;

import org.openqa.selenium.By;

import com.qa.locator.BaseLocator;
import com.qa.test.BaseTest;
import com.qa.util.UiUtil;

/**
* The BasePO class contains the By variables which are getting their locators from BaseLocator
* 
* Modify this class accordingly to your project need
*
* @author  Rajshekhar Salimath
* @email rs930831@gmail.com
* @version 1.0
* @since   2020-08-26 
*/
public class BasePO extends BaseTest {
	
	private static final Map<String, Map<String, String>> baselocatorelements = (new BaseLocator(platformTesttype)).getElements();
	
	final By noConnectionRetry = By.id(baselocatorelements.get("noConnectionRetry").get(platformTesttype));
	final By appBar = By.id(baselocatorelements.get("appBar").get(platformTesttype));
	final By searchIcon = By.id(baselocatorelements.get("searchIcon").get(platformTesttype));
	final By bellNotificationIcon = By.id(baselocatorelements.get("bellNotificationIcon").get(platformTesttype));
	final By cartIcon = By.id(baselocatorelements.get("cartIcon").get(platformTesttype));
	final By drawerOpen = By.id(baselocatorelements.get("drawerOpen").get(platformTesttype));
	final By drawerOptionsAll = By.id(baselocatorelements.get("drawerOptionsAll").get(platformTesttype));
	final By searchTextBox = By.id(baselocatorelements.get("searchTextBox").get(platformTesttype));
	final By searchInput = By.id(baselocatorelements.get("searchInput").get(platformTesttype));
	final By searchCancel = By.id(baselocatorelements.get("searchCancel").get(platformTesttype));
	final By androidNoneOfTheAbove = By.id(baselocatorelements.get("androidNoneOfTheAbove").get(platformTesttype));
	
	
	UiUtil uiUtil;
	
	BasePO() throws Exception {
		System.out.println("[BassePO][No Arg Constructor] Getting Reference of UiUtil");
		this.uiUtil = BaseTest.uiutil;
	}
	
	
	
}
