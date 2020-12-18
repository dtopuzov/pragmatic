package nativeapp.tests;

import base.MobileTest;
import enums.Direction;
import nativeapp.enums.FooterItem;
import nativeapp.pages.HomePage;
import nativeapp.pages.SwipePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example how to swipe on page.
 * <p>
 * For more details, please read this tutorials:
 * http://appium.io/docs/en/writing-running-appium/tutorial/swipe-tutorial/
 */
public class SwipeTests extends MobileTest {
    private SwipePage swipePage;

    @BeforeEach
    public void beforeEachSwipeTest() {
        HomePage homePage = new HomePage(driver);
        homePage.footer.navigateTo(FooterItem.SWIPE);
        swipePage = new SwipePage(driver);
        assertTrue(swipePage.loaded());
    }

    @Test
    void smokeSwipeTests() {
        assertTrue(swipePage.findByText("FULLY OPEN SOURCE").isDisplayed());

        swipePage.swipeFromCenterToScreenEdge(Direction.LEFT);
        assertTrue(swipePage.findByText("CREAT COMMUNITY").isDisplayed());

        swipePage.swipeFromCenterToScreenEdge(Direction.RIGHT);
        assertTrue(swipePage.findByText("FULLY OPEN SOURCE").isDisplayed());
    }
}