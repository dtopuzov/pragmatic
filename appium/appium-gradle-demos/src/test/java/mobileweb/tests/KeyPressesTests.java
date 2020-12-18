package mobileweb.tests;


import base.MobileTest;
import mobileweb.pages.KeyPressPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Demo of web tests using PageObject pattern.
 */
public class KeyPressesTests extends MobileTest {
    private KeyPressPage keyPressPage;

    @BeforeEach
    public void beforeKeyPressesTest() {
        keyPressPage = new KeyPressPage(driver);
        keyPressPage.navigateTo();
    }

    @Test
    public void enterKeysTest() {
        // Type value and verify result changed too
        keyPressPage.typeText("test");
        assertEquals(keyPressPage.getText(), "test");
        assertEquals(keyPressPage.getResult(), "You entered: T");

        // Clean value of the input
        keyPressPage.clearText();
        assertEquals(keyPressPage.getText(), "");
        assertEquals(keyPressPage.getResult(), "You entered: T");
    }
}
