package base;

import appium.Client;
import appium.Server;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import settings.Settings;

/**
 * Base test class for all mobile tests.
 */
public class MobileTest {

    protected static AppiumDriver<?> driver;

    private static Client client;
    private static Server server;

    @BeforeAll
    public static void beforeAll() {
        Settings settings = new Settings();
        server = new Server();
        server.start();
        client = new Client(settings);
        client.start(server.getUrl());
        driver = client.getDriver();
    }

    @BeforeEach
    public void beforeEach() {
    }

    @AfterEach
    public void afterEach() {
    }

    @AfterAll
    public static void afterAll() {
        client.stop();
        server.stop();
    }
}
