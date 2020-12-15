package helloworld;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloWorldTests {

    @Test
    public void testSimple() {
        // Examples of assert statements.
        Assert.assertTrue(true);
        Assert.assertEquals(1, 1);
        Assert.assertNotEquals("pass", "fail");
        // Assert.fail("force test to fail");
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
