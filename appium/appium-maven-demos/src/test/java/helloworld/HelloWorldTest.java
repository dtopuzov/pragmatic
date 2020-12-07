package helloworld;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloWorldTest {

    @Test
    public void testSimple() {
        Assert.assertTrue(true);
    }

    @Test(enabled = false)
    public void testSkip() {
        // When test fails due to known temporary issues
        // you may skip it instead of delete it.
    }

    @Test(timeOut = 10,
            description = "User friendly name of the test",
            testName = "TestNG Attributes",
            suiteName = "Smoke Tests"
    )
    public void testAttributes() {
        // TestNG provides additional attributes.
        // They are all optional.
    }
}
