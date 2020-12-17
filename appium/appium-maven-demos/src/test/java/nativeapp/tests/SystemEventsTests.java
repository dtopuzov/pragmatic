package nativeapp.tests;

import base.MobileTest;
import nativeapp.enums.FooterItem;
import nativeapp.pages.HomePage;
import nativeapp.pages.SwipePage;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SystemEventsTests extends MobileTest {
    private HomePage homePage;

    @BeforeMethod
    public void beforeSmokeTest() {
        driver.resetApp();

        // Ensure correct orientation
        if (driver.getOrientation() == ScreenOrientation.LANDSCAPE) {
            driver.rotate(ScreenOrientation.PORTRAIT);
        }

        homePage = new HomePage(driver);
    }

    @Test
    public void restartTest() {
        homePage.footer.navigateTo(FooterItem.SWIPE);
        SwipePage swipePage = new SwipePage(driver);
        Assert.assertTrue(swipePage.loaded());

        // Restart app and verify you are back at home page
        driver.resetApp();
        Assert.assertTrue(homePage.loaded());
    }

    @Test
    public void runInBackgroundTest() {
        homePage.footer.navigateTo(FooterItem.SWIPE);
        SwipePage swipePage = new SwipePage(driver);
        Assert.assertTrue(swipePage.loaded());

        // Run app in background and verify it is again on swipe page
        driver.runAppInBackground(Duration.ofSeconds(5));
        Assert.assertTrue(swipePage.loaded());
    }

    @Test(expectedExceptions = InvalidElementStateException.class)
    public void rotationShouldBeDisabled() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }
}
