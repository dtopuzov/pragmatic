package helloworld.basics;

import org.junit.jupiter.api.*;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTests {

    @Test
    public void testSimple() {
        // Examples of assert statements.
        assertTrue(true);
        assertEquals(1, 1);
        assertNotEquals("pass", "fail");
        // fail("force test to fail");
    }

    @Test
    @Disabled("Ignore because of issue #123")
    public void testSkip() {
        // When test fails due to known temporary issues
        // you may skip it instead of delete it.
    }

    @Test
    @Timeout(value = 10, unit = SECONDS)
    @DisplayName("User friendly name of the test")
    @Tag("android")
    public void testAttributes() {
        // JUnit 5 provides additional attributes.
        // They are all optional.
    }
}
