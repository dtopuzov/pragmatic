package nativeapp.tests;

import base.MobileTest;
import nativeapp.enums.FooterItem;
import nativeapp.pages.HomePage;
import nativeapp.pages.SwipePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriverException;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SystemEventsTests extends MobileTest {
    private HomePage homePage;

    @BeforeEach
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
        assertTrue(swipePage.loaded());

        // Restart app and verify you are back at home page
        driver.resetApp();
        assertTrue(homePage.loaded());
    }

    @Test
    public void runInBackgroundTest() {
        homePage.footer.navigateTo(FooterItem.SWIPE);
        SwipePage swipePage = new SwipePage(driver);
        assertTrue(swipePage.loaded());

        // Run app in background and verify it is again on swipe page
        driver.runAppInBackground(Duration.ofSeconds(5));
        assertTrue(swipePage.loaded());
    }

    @Test
    public void rotationShouldBeDisabled() {
        assertThrows(WebDriverException.class, () -> {
            driver.rotate(ScreenOrientation.LANDSCAPE);
        });
    }
}
