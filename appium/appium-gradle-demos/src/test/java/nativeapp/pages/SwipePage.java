package nativeapp.pages;

import base.MobilePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import nativeapp.components.Footer;
import org.openqa.selenium.By;

import java.util.List;

public class SwipePage extends MobilePage {
    public Footer footer;

    public SwipePage(AppiumDriver<?> driver) {
        super(driver);
        footer = new Footer(driver);
    }

    public boolean loaded() {
        return findElement(MobileBy.AccessibilityId("Swipe-screen")) != null;
    }

    public String getCarouselTitle() {
        By locator = By.xpath("//*[@content-desc='card']//android.widget.TextView[@index='1']");
        List<?> elements = driver.findElements(locator);
        return ((MobileElement) elements.get(elements.size() - 1)).getText();
    }
}
