package appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {
    public static AppiumDriverLocalService getService(String logLevel) {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.LOG_LEVEL, logLevel)
                .withArgument(GeneralServerFlag.RELAXED_SECURITY);

        return AppiumDriverLocalService.buildService(serviceBuilder);
    }
}