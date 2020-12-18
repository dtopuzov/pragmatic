package nativeapp.pages;

import base.MobilePage;
import io.appium.java_client.AppiumDriver;
import nativeapp.components.Footer;
import nativeapp.enums.WDIOMenuItems;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.fail;

public class WebViewPage extends MobilePage {
    public Footer footer;

    public WebViewPage(AppiumDriver<?> driver) {
        super(driver);
        footer = new Footer(driver);
    }

    public void openTab(WDIOMenuItems tab) {
        try {
            switchToWebContext();
            By locator = By.xpath(String.format("//a[text()='%s']", tab.toString()));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
        } finally {
            switchToNativeContext();
        }
    }

    public void verityTextVisible(String text) {
        try {
            switchToWebContext();
            By locator = By.xpath("//*[text()='" + text + "']");
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            fail(String.format("Failed to find '%s' text.", text));
        } finally {
            switchToNativeContext();
        }
    }
}
