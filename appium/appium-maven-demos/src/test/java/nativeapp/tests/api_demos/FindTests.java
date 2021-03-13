package nativeapp.tests.api_demos;

import base.MobileTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import nativeapp.enums.FooterItem;
import nativeapp.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Demos of Appium APIs for locate elements.
 * <p>
 * Recommended readings:
 * https://appium.io/docs/en/commands/element/find-elements/index.html#selector-strategies
 * https://appiumpro.com/editions/20-making-your-appium-tests-fast-and-reliable-part-2-finding-elements
 * https://appiumpro.com/editions/8-how-to-find-elements-in-ios-not-by-xpath
 */
public class FindTests extends MobileTest {
    @BeforeMethod
    void beforeLoginTests() {
        HomePage homePage = new HomePage(driver);
        homePage.footer.navigateTo(FooterItem.HOME);
        Assert.assertTrue(homePage.loaded());
    }

    @Test(description = "Find single element.")
    void findElement() {
        if (settings.getPlatform() == Platform.ANDROID) {
            // Login tab element in page source:
            //
            // <android.view.ViewGroup index="2" package="com.wdiodemoapp" class="android.view.ViewGroup" text=""
            // content-desc="Login" checkable="false" checked="false" clickable="false" enabled="true" focusable="true"
            // focused="false" long-clickable="false" password="false" scrollable="false" selected="false"
            // bounds="[432,1626][648,1776]" displayed="true">
            //

            // content-desc is mapped to AccessibilityId when Appium runs in Android context.
            MobileElement loginTab = (MobileElement) driver.findElementByAccessibilityId("Login");
            Assert.assertEquals("Login", loginTab.getAttribute("content-desc"));

            // We can do absolutely the same with a bit different syntax (the preferred one):
            loginTab = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Login"));
            Assert.assertEquals("Login", loginTab.getAttribute("content-desc"));
        } else {
            // Login tab element in page source:
            //
            // <XCUIElementTypeOther type="XCUIElementTypeOther" name="Login" label="Login" enabled="true"
            // visible="true" x="150" y="728" width="75" height="50" index="2"/>
            //
            // In iOS context name is mapped to AccessibilityId.
            MobileElement loginTab = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Login"));
            Assert.assertEquals("Login", loginTab.getAttribute("name"));
        }
    }

    @Test(description = "Find element that is under UI tree of other element.")
    void findElementInsideElement() {
        if (settings.getPlatform() == Platform.ANDROID) {
            By locator = MobileBy.xpath("//android.widget.FrameLayout/android.view.ViewGroup[@index='2']");
            MobileElement parentElement = (MobileElement) driver.findElement(locator);
            MobileElement loginTab = parentElement.findElement(MobileBy.AccessibilityId("Login"));
            Assert.assertEquals("Login", loginTab.getAttribute("content-desc"));
        } else {
            By locator = MobileBy.AccessibilityId("Home WebView Login Forms Swipe");
            MobileElement parentElement = (MobileElement) driver.findElement(locator);
            MobileElement loginTab = parentElement.findElement(MobileBy.AccessibilityId("Login"));
            Assert.assertEquals("Login", loginTab.getAttribute("name"));
        }
    }

    @Test(description = "Find all elements that match specified locator.")
    void findElements() {
        if (settings.getPlatform() == Platform.ANDROID) {
            By locator = By.xpath("//android.widget.FrameLayout/android.view.ViewGroup[@index='2']/android.view.ViewGroup");
            Assert.assertEquals(5, driver.findElements(locator).size());
        } else {
            // More on iOS find strategies:
            // https://appiumpro.com/editions/8-how-to-find-elements-in-ios-not-by-xpath
            String selector = "**/XCUIElementTypeOther[`name BEGINSWITH \"Home WebView Login\"`]/XCUIElementTypeOther";
            Assert.assertEquals(5, driver.findElements(MobileBy.iOSClassChain(selector)).size());
        }
    }
}
