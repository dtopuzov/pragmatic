package helloworld.inheritance;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * Base test class that each test class will inherit.
 * <p>
 * Example of how to use TestNG hooks
 * to run something before and after tests.
 */
public class BaseTest {

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        System.out.println("Executed once before all classes.");
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println("Executed before each class.");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
        // Demo how to get test name before test
        System.out.println("Start test: " + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethodBaseTest(ITestResult result) {
        // Demo how to get test name after test
        String testCase = result.getMethod().getMethodName();
        System.out.println("End test: " + testCase);

        // Demo how to get test status and other properties
        System.out.println("Test Status: " + result.getStatus());
        // int SUCCESS = 1;
        // int FAILURE = 2;
        // int SKIP = 3;
        // int SUCCESS_PERCENTAGE_FAILURE = 4;
        // int STARTED = 16;
        System.out.println("Test Started: " + convertTime(result.getStartMillis()));
        System.out.println("Test Ended: " + convertTime(result.getEndMillis()));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("Executed after each class.");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        System.out.println("Executed after all classes.");
    }

    private String convertTime(long millis) {
        DateFormat simple = new SimpleDateFormat("HH:mm:ss:SSS");
        return simple.format(millis);
    }
}
