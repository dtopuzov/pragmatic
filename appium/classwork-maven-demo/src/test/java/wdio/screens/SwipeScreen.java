package wdio.screens;

import com.pragmatic.framework.base.MobileScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class SwipeScreen extends MobileScreen {
    public SwipeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void navigateTo() {
        driver.findElement(MobileBy.AccessibilityId("Swipe")).click();
    }
}
