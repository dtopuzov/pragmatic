package mobileweb.tests;


import base.MobileTest;
import io.appium.java_client.remote.AutomationName;
import mobileweb.pages.KeyPressPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Demo of web tests using PageObject pattern.
 */
public class KeyPressesTests extends MobileTest {
    private KeyPressPage keyPressPage;

    @BeforeMethod
    public void beforeKeyPressesTest() {
        keyPressPage = new KeyPressPage(driver);
        keyPressPage.navigateTo();
    }

    @Test
    public void enterKeysTest() {
        // Type value and verify result changed too
        keyPressPage.typeText("test");
        Assert.assertEquals(keyPressPage.getText(), "test");
        String automationName = driver.getCapabilities().getCapability("automationName").toString();
        if (!automationName.equalsIgnoreCase(AutomationName.IOS_XCUI_TEST)) {
            Assert.assertEquals(keyPressPage.getResult(), "You entered: T");
        }

        // Clean value of the input
        keyPressPage.clearText();
        Assert.assertEquals(keyPressPage.getText(), "");
        if (!automationName.equalsIgnoreCase(AutomationName.IOS_XCUI_TEST)) {
            Assert.assertEquals(keyPressPage.getResult(), "You entered: T");
        }
    }
}
