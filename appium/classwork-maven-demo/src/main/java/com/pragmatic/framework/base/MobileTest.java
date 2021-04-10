package com.pragmatic.framework.base;

import com.pragmatic.framework.appium.Client;
import com.pragmatic.framework.appium.Server;
import com.pragmatic.framework.settings.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class MobileTest {
    private static Server server;
    private static Client client;
    protected static AppiumDriver<MobileElement> driver;

    @BeforeTest(alwaysRun = true)
    public void beforeSuite() {
        Settings settings = new Settings();
        server = new Server(settings);
        server.start();

        client = new Client(settings);
        client.start(server.getUrl());
        driver = client.getDriver();
    }

    @AfterTest(alwaysRun = true)
    public void afterSuite() {
        client.stop();
        server.stop();
    }
}
