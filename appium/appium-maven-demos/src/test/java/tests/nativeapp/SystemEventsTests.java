package tests.nativeapp;

import base.MobileTest;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SystemEventsTests extends MobileTest {
    @BeforeMethod
    public void beforeSmokeTest() {
        driver.resetApp();
        if (driver.getOrientation() == ScreenOrientation.LANDSCAPE) {
            driver.rotate(ScreenOrientation.PORTRAIT);
        }
    }

    @Test
    public void restartTest() {

    }

    @Test
    public void runInBackgroundTest() {
    }

    @Test
    public void rotateTest() {
    }
}
