package helloworld.inheritance;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;


/**
 * Base test class that each test class will inherit.
 * <p>
 * Example of how to use JUnit 5 hooks
 * to run something before and after tests.
 */
@ExtendWith({Resolver.class, Watcher.class})
public class BaseTest {

    /*
    Unlike TestNG there is no attribute that will allow method to run only once before all classes.
    It is still possible to implement such logic, please see:
    https://stackoverflow.com/questions/43282798/in-junit-5-how-to-run-code-before-all-tests
     */

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Executed before each class.");
    }

    @BeforeEach
    public void beforeEach() {
        // Test start is logged by `Watcher` class.
    }

    @AfterEach
    public void afterEach(ExtensionContext extensionContext) {
        // Unlike TestNG here we do not have `ITestResult` object that give us info for test outcome.
        // In JUnit 5 we use watchers, please see Watcher.class
        Method testMethod = extensionContext.getRequiredTestMethod();
        boolean testFailed = extensionContext.getExecutionException().isPresent();
        if (testFailed) {
            collectArtifacts(testMethod.getName());
        }
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("Executed after each class.");
    }

    private void collectArtifacts(String testMethodName) {
        // Some helper method that perform actions on test fail.
        // For example take screenshots.
    }
}
