package demo02.appium.capabilities;

import appium.AppiumServer;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Network;

public class AndroidCapabilitiesTests {

    private static final String deviceName = "Samsung A21s";
    private static final String deviceID = "RF8N715NJ0B";
    private static final String emuName = "PixelApi27";
    private static final String apkPath = "https://github.com/dtopuzov/pragmatic-mobile-testing/" +
            "raw/main/appium/testapps/Android-NativeDemoApp-0.2.1.apk";
    private static AppiumDriverLocalService service;
    private static AndroidDriver<?> driver;

    @BeforeClass
    public void beforeClass() {
        service = AppiumServer.getService("debug");
        service.start();
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void afterClass() {
        service.stop();
    }

    @Test
    public void testEmulatorCapabilitiesWithAPK() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID.name());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, emuName);
        capabilities.setCapability(AndroidMobileCapabilityType.AVD, emuName);
        capabilities.setCapability(MobileCapabilityType.APP, apkPath);

        driver = new AndroidDriver<AndroidElement>(service.getUrl(), capabilities);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        By locator = MobileBy.AccessibilityId("Login");
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Assert.assertEquals(element.getAttribute("content-desc"), "Login");
    }

    @Test
    public void testEmulatorCapabilitiesWithInstalledPackage() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID.name());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, emuName);
        capabilities.setCapability(AndroidMobileCapabilityType.AVD, emuName);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.settings");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".Settings");

        driver = new AndroidDriver<AndroidElement>(service.getUrl(), capabilities);
        Assert.assertEquals(driver.getCurrentPackage(), "com.android.settings");
        Assert.assertEquals(driver.currentActivity(), ".Settings");
    }

    @Test
    public void testBrowserSession() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID.name());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, emuName);
        capabilities.setCapability(AndroidMobileCapabilityType.AVD, emuName);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);

        // We need to set different SYSTEM_PORT to
        // enable two or more simultaneous Android test sessions (valid both for web and mobile).
        // Reference: https://appium.io/docs/en/advanced-concepts/parallel-tests/
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, Network.nextFreePort(5200, 5299));

        // We need to set different CHROMEDRIVER_PORT to
        // enable two or more simultaneous WebView sessions.
        // Reference: https://appium.io/docs/en/advanced-concepts/parallel-tests/
        capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_PORT, Network.nextFreePort(58500, 58599));

        // Note that we do not need to download and setup Chrome driver!
        // Appium automatically detect version of the browser on the
        // mobile device and download appropriate driver.
        //
        // Reference:
        // http://appium.io/docs/en/writing-running-appium/web/chromedriver/

        driver = new AndroidDriver<>(service.getUrl(), capabilities);

        driver.navigate().to("https://www.pragmatic.bg");

        By locator = By.id("dt-menu-toggle");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Assert.assertEquals(element.getText(), "MENU");
    }

    @Test(enabled = false, description = "Can not attach my local device on GitHub Actions.")
    public void testOnRealDevice() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID.name());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, deviceID);
        capabilities.setCapability(MobileCapabilityType.APP, apkPath);

        driver = new AndroidDriver<AndroidElement>(service.getUrl(), capabilities);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        By locator = MobileBy.AccessibilityId("Login");
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Assert.assertEquals(element.getAttribute("content-desc"), "Login");
    }
}
