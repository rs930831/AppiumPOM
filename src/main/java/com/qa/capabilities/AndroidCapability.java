package com.qa.capabilities;

/**
* The AndroidCapabilities class contains the android capabilities that
* simply returns the String representation of respective capability.
* These Capabilities are available only on Android-based drivers (like UiAutomator2 for example)
*
* @author  Rajshekhar Salimath
* @email rs930831@gmail.com
* @version 1.0
* @since   2020-08-26 
*/
public class AndroidCapability {
	
	private AndroidCapability() {}
	
	public final static String appActivity = "appActivity";
	public final static String appPackage = "appPackage";
	public final static String appWaitActivity = "appWaitActivity";
	public final static String appWaitPackage = "appWaitPackage";
	public final static String appWaitDuration = "appWaitDuration";
	public final static String deviceReadyTimeout = "deviceReadyTimeout";
	public final static String allowTestPackages = "allowTestPackages";
	public final static String androidCoverage = "androidCoverage";
	public final static String androidCoverageEndIntent = "androidCoverageEndIntent";
	public final static String androidDeviceReadyTimeout = "androidDeviceReadyTimeout";
	public final static String androidInstallTimeout = "androidInstallTimeout";
	public final static String androidInstallPath = "androidInstallPath";
	public final static String adbPort = "adbPort";
	public final static String systemPort = "systemPort";
	public final static String remoteAdbHost = "remoteAdbHost";
	public final static String androidDeviceSocket = "androidDeviceSocket";
	public final static String avd = "avd";
	public final static String avdLaunchTimeout = "avdLaunchTimeout";
	public final static String avdReadyTimeout = "avdReadyTimeout";
	public final static String avdArgs = "avdArgs";
	public final static String useKeystore = "useKeystore";
	public final static String keystorePath = "keystorePath";
	public final static String keystorePassword = "keystorePassword";
	public final static String keyAlias = "keyAlias";
	public final static String keyPassword = "keyPassword";
	public final static String chromedriverExecutable = "chromedriverExecutable";
	public final static String chromedriverArgs = "chromedriverArgs";
	public final static String chromedriverExecutableDir = "chromedriverExecutableDir";
	public final static String chromedriverChromeMappingFile = "chromedriverChromeMappingFile";
	public final static String chromedriverUseSystemExecutable = "chromedriverUseSystemExecutable";
	public final static String autoWebviewTimeout = "autoWebviewTimeout";
	public final static String chromedriverPort = "chromedriverPort";
	public final static String chromedriverPorts = "chromedriverPorts";
	public final static String ensureWebviewsHavePages = "ensureWebviewsHavePages";
	public final static String webviewDevtoolsPort = "webviewDevtoolsPort";
	public final static String enableWebviewDetailsCollection = "enableWebviewDetailsCollection";
	public final static String dontStopAppOnReset = "dontStopAppOnReset";
	public final static String unicodeKeyboard = "unicodeKeyboard";
	public final static String resetKeyboard = "resetKeyboard";
	public final static String noSign = "noSign";
	public final static String ignoreUnimportantViews = "ignoreUnimportantViews";
	public final static String disableAndroidWatchers = "disableAndroidWatchers";
	public final static String chromeOptions = "chromeOptions";
	public final static String recreateChromeDriverSessions = "recreateChromeDriverSessions";
	public final static String nativeWebScreenshot = "nativeWebScreenshot";
	public final static String androidScreenshotPath = "androidScreenshotPath";
	public final static String autoGrantPermissions = "autoGrantPermissions";
	public final static String networkSpeed = "networkSpeed";
	public final static String gpsEnabled = "gpsEnabled";
	public final static String isHeadless = "isHeadless";
	public final static String adbExecTimeout = "adbExecTimeout";
	public final static String localeScript = "localeScript";
	public final static String skipDeviceInitialization = "skipDeviceInitialization";
	public final static String chromedriverDisableBuildCheck = "chromedriverDisableBuildCheck";
	public final static String skipUnlock = "skipUnlock";
	public final static String unlockType = "unlockType";
	public final static String unlockKey = "unlockKey";
	public final static String autoLaunch = "autoLaunch";
	public final static String skipLogcatCapture = "skipLogcatCapture";
	public final static String uninstallOtherPackages = "uninstallOtherPackages";
	public final static String disableWindowAnimation = "disableWindowAnimation";
	public final static String remoteAppsCacheLimit = "remoteAppsCacheLimit";
	public final static String buildToolsVersion = "buildToolsVersion";
	public final static String androidNaturalOrientation = "androidNaturalOrientation";
	public final static String enforceAppInstall = "enforceAppInstall";
	public final static String ignoreHiddenApiPolicyError = "ignoreHiddenApiPolicyError";
	public final static String mockLocationApp = "mockLocationApp";
	public final static String logcatFormat = "logcatFormat";
	public final static String logcatFilterSpecs = "logcatFilterSpecs";
}
