package nativeapp.tests;

import base.MobileTest;
import enums.Direction;
import nativeapp.enums.FooterItem;
import nativeapp.pages.HomePage;
import nativeapp.pages.SwipePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Example how to swipe on page.
 * <p>
 * For more details, please read this tutorials:
 * http://appium.io/docs/en/writing-running-appium/tutorial/swipe-tutorial/
 */
public class SwipeTests extends MobileTest {
    private SwipePage swipePage;

    @BeforeMethod
    public void beforeEachSwipeTest() {
        HomePage homePage = new HomePage(driver);
        homePage.footer.navigateTo(FooterItem.SWIPE);
        swipePage = new SwipePage(driver);
        Assert.assertTrue(swipePage.loaded());
    }

    @Test
    void smokeSwipeTests() {
        Assert.assertTrue(swipePage.findByText("FULLY OPEN SOURCE").isDisplayed());

        swipePage.swipeFromCenterToScreenEdge(Direction.LEFT);
        Assert.assertTrue(swipePage.findByText("CREAT COMMUNITY").isDisplayed());

        swipePage.swipeFromCenterToScreenEdge(Direction.RIGHT);
        Assert.assertTrue(swipePage.findByText("FULLY OPEN SOURCE").isDisplayed());
    }
}