package demo01.appium.server;

import appium.AppiumServer;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppiumServerTests {

    private AppiumDriverLocalService service;
    private AppiumDriverLocalService concurrentService;

    @BeforeClass
    public void testSimplex() {
        service = AppiumServer.getService("debug");
        service.start();
    }

    @AfterMethod
    public void afterMethod() {
        if (concurrentService != null) {
            concurrentService.stop();
        }
    }

    @AfterClass
    public void afterClass() {
        service.stop();
    }

    @Test
    public void testIsRunning() {
        Assert.assertTrue(service.isRunning());
    }

    @Test
    public void testGetUrl() {
        String url = service.getUrl().toString();
        Assert.assertTrue(url.startsWith("http://"));
        Assert.assertTrue(url.endsWith("/wd/hub"));
    }

    @Test
    public void testGetStdOut() {
        String stdOut = service.getStdOut();
        Assert.assertNotNull(stdOut);
        Assert.assertTrue(stdOut.contains("Welcome to Appium"));
        Assert.assertTrue(stdOut.contains("relaxedSecurityEnabled: true"));
    }

    @Test
    public void testMultipleConcurrentServers() {
        concurrentService = AppiumServer.getService("info");
        concurrentService.start();
        Assert.assertTrue(concurrentService.isRunning());
        Assert.assertTrue(service.isRunning());
        Assert.assertNotEquals(service.getUrl(), concurrentService.getUrl());
        concurrentService.start();
    }
}
