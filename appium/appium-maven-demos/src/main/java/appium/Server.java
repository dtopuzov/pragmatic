package appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.net.URL;

/**
 * Appium server utils.
 */
public class Server {
    private AppiumDriverLocalService service;

    public Server() {
    }

    public void start() {
        // Construct AppiumServiceBuilder
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.LOG_LEVEL, "warn")
                .withArgument(GeneralServerFlag.RELAXED_SECURITY);

        // Start Appium Server
        service = AppiumDriverLocalService.buildService(serviceBuilder);
        service.start();
    }

    public URL getUrl() {
        return service.getUrl();
    }

    public void stop() {
        if (service != null) {
            service.stop();
        }
    }
}
