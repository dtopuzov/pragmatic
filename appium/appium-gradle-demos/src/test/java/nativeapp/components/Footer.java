package nativeapp.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import nativeapp.enums.FooterItem;

public class Footer {
    private final AppiumDriver<?> driver;

    public Footer(AppiumDriver<?> driver) {
        this.driver = driver;
    }

    public void navigateTo(FooterItem footerItem) {
        driver.findElement(MobileBy.AccessibilityId(footerItem.toString())).click();
    }
}
