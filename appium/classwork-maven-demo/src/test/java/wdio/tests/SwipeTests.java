package wdio.tests;

import com.pragmatic.framework.base.MobileTest;
import com.pragmatic.framework.enums.Direction;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wdio.screens.SwipeScreen;

public class SwipeTests extends MobileTest {

    private SwipeScreen swipeScreen;

    @BeforeMethod
    public void beforeMethod() {
        driver.resetApp();
        swipeScreen = new SwipeScreen(driver);
        swipeScreen.navigateTo();
    }

    @Test
    public void smokeTest() {
        Assert.assertTrue(swipeScreen.findByText("FULLY OPEN SOURCE").isDisplayed());

        swipeScreen.swipe(Direction.LEFT);
        Assert.assertTrue(swipeScreen.findByText("CREAT COMMUNITY").isDisplayed());

        swipeScreen.swipe(Direction.RIGHT);
        Assert.assertTrue(swipeScreen.findByText("FULLY OPEN SOURCE").isDisplayed());
    }
}
