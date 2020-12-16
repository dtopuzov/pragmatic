package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.time.Duration;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public abstract class MobilePage {
    protected AppiumDriver<?> driver;
    protected WebDriverWait wait;

    public MobilePage(AppiumDriver<?> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Nullable
    private String getWebContext(AppiumDriver<?> driver) {
        await().atMost(30, SECONDS).until(() -> driver.getContextHandles().size() > 1);

        Set<String> handles = driver.getContextHandles();
        for (Object context : handles) {
            if (!String.valueOf(context).equals("NATIVE_APP")) {
                return String.valueOf(context);
            }
        }
        return null;
    }

    /**
     * Switch to WebContext to control WebViews.
     */
    public void switchToWebContext() {
        String webContext = this.getWebContext(driver);
        if (webContext != null) {
            driver.context(webContext);
        } else {
            throw new RuntimeException("Failed to switch to WebView context.");
        }
    }

    /**
     * Switch to context of native mobile app.
     */
    public void switchToNativeContext() {
        driver.context("NATIVE_APP");
    }

    public MobileElement findElement(By locator, Duration timeout) {
        try {
            driver.manage().timeouts().implicitlyWait(0, SECONDS);
            return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            return null;
        } finally {
            driver.manage().timeouts().implicitlyWait(30, SECONDS);
        }
    }

    public MobileElement findElement(By locator) {
        return findElement(locator, Duration.ofSeconds(30));
    }

    public MobileElement findByText(String text, boolean exactMatch) {
        By locator;
        String automation = driver.getCapabilities().getCapability("automationName").toString();
        if (automation.equalsIgnoreCase(AutomationName.ANDROID_UIAUTOMATOR2)) {
            if (exactMatch) {
                locator = MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + text + "\")");
            } else {
                locator = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + text + "\")");
            }
        } else if (automation.equalsIgnoreCase(AutomationName.IOS_XCUI_TEST)) {
            if (exactMatch) {
                String exactPredicate = "name == \"" + text + "\" OR label == \"" + text + "\"";
                locator = MobileBy.iOSNsPredicateString(exactPredicate);
            } else {
                String containsPredicate = "name contains '" + text + "' OR label contains '" + text + "'";
                locator = MobileBy.iOSNsPredicateString(containsPredicate);
            }
        } else {
            throw new RuntimeException("Unsupported automation technology: " + automation);
        }
        return (MobileElement) driver.findElement(locator);
    }

    public MobileElement findByText(String text) {
        return findByText(text, true);
    }
}