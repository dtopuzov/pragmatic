package rbb.tests;

import com.pragmatic.framework.base.MobileTest;
import org.testng.annotations.Test;

public class SmokeTests extends MobileTest {
    @Test
    public void testMobileAppSuggestion() {
        driver.getPageSource();
    }
}
