package nativeapp.pages;

import base.MobilePage;
import io.appium.java_client.AppiumDriver;
import nativeapp.components.Footer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.fail;

public class WebViewPage extends MobilePage {
    public Footer footer;

    public WebViewPage(AppiumDriver<?> driver) {
        super(driver);
        footer = new Footer(driver);
    }

    public void searchExists() {
        try {
            switchToWebContext();
            By locator = By.cssSelector("button[aria-label='Search']");
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            fail("Failed to find search box.");
        } finally {
            switchToNativeContext();
        }
    }
}
