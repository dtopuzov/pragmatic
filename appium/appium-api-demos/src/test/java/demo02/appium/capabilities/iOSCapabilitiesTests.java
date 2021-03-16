package demo02.appium.capabilities;

import appium.AppiumServer;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
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

public class iOSCapabilitiesTests {

    private static final String simulatorName = "iPhone 11";
    private static final String osVersion = "14.4";
    private static final String appPath = "https://github.com/dtopuzov/pragmatic-mobile-testing/" +
            "raw/main/appium/testapps/iOS-Simulator-NativeDemoApp-0.2.1.app.zip";
    private static AppiumDriverLocalService service;
    private static IOSDriver<?> driver;

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
    public void testNativeApp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS.name());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, simulatorName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, osVersion);
        capabilities.setCapability(MobileCapabilityType.APP, appPath);

        driver = new IOSDriver<IOSElement>(service.getUrl(), capabilities);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        By locator = MobileBy.AccessibilityId("Login");
        IOSElement element = (IOSElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Assert.assertEquals(element.getAttribute("name"), "Login");
    }

    @Test
    public void testBrowserSession() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS.name());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, simulatorName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, osVersion);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.SAFARI);

        driver = new IOSDriver<IOSElement>(service.getUrl(), capabilities);

        driver.navigate().to("https://www.pragmatic.bg");

        By locator = By.id("dt-menu-toggle");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Assert.assertEquals(element.getText(), "MENU");
    }
}
