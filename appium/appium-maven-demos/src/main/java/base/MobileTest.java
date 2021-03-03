package base;

import appium.Client;
import appium.Server;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import settings.Settings;

/**
 * Base test class for all mobile tests.
 */
public class MobileTest {
    protected static Settings settings;
    protected static AppiumDriver<?> driver;

    private static Client client;
    private static Server server;

    @BeforeTest
    public static void beforeAll() {
        settings = new Settings();
        server = new Server();
        server.start();
        client = new Client(settings);
        client.start(server.getUrl());
        driver = client.getDriver();
    }

    @BeforeMethod
    public void beforeEach() {
    }

    @AfterMethod(alwaysRun = true)
    public void afterEach(ITestResult result) {
    }

    @AfterTest(alwaysRun = true)
    public static void afterAll() {
        client.stop();
        server.stop();
    }
}
