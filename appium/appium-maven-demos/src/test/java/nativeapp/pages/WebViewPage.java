package nativeapp.pages;

import base.MobilePage;
import io.appium.java_client.AppiumDriver;
import nativeapp.components.Footer;
import org.openqa.selenium.By;
import org.testng.Assert;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;


public class WebViewPage extends MobilePage {
    public Footer footer;

    public WebViewPage(AppiumDriver<?> driver) {
        super(driver);
        footer = new Footer(driver);
    }

    public void searchIsVisible() {
        try {
            switchToWebContext();
            await().atMost(30, SECONDS).until(() -> driver.getPageSource().contains("aria-label"));
            By locator = By.cssSelector("button[aria-label='Search']");
            driver.findElement(locator);
        } catch (Exception e) {
            Assert.fail("Failed to find search button." + System.lineSeparator() + driver.getPageSource());
        } finally {
            switchToNativeContext();
        }
    }
}
