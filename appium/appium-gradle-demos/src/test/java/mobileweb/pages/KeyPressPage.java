package mobileweb.pages;

import base.MobilePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("unused")
public class KeyPressPage extends MobilePage {

    @FindBy(id = "target")
    private WebElement input;

    @FindBy(id = "result")
    private WebElement result;

    public KeyPressPage(AppiumDriver<?> driver) {
        super(driver);
    }

    public void navigateTo() {
        driver.navigate().to("https://the-internet.herokuapp.com/key_presses");
        assertAll("Popup title and message not correct!",
                () -> assertTrue(input.isDisplayed(), "Failed to load 'key_presses' page."),
                () -> assertTrue(result.isEnabled(), "Failed to load 'key_presses' page.")
        );
    }

    public void typeText(String text) {
        input.sendKeys(text);
    }

    public void clearText() {
        input.clear();
    }

    public String getText() {
        return input.getAttribute("value");
    }

    public String getResult() {
        return result.getText();
    }
}
