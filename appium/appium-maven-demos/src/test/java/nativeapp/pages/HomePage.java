package nativeapp.pages;

import base.MobilePage;
import io.appium.java_client.AppiumDriver;
import nativeapp.components.Footer;

public class HomePage extends MobilePage {
    public Footer footer;

    public HomePage(AppiumDriver<?> driver) {
        super(driver);
        footer = new Footer(driver);
    }
}
