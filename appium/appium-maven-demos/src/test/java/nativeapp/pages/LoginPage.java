package nativeapp.pages;

import base.MobilePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import nativeapp.components.Footer;
import nativeapp.components.Popup;
import org.springframework.util.Assert;
import org.testng.asserts.SoftAssert;

/**
 * Sample page abstraction using PageObject pattern in Appium world.
 * <p>
 * You can read more at:
 * https://github.com/appium/java-client/blob/master/docs/Page-objects.md
 */
@SuppressWarnings("unused")
public class LoginPage extends MobilePage {
    @AndroidFindBy(accessibility = "input-email")
    @iOSXCUITFindBy(accessibility = "input-email")
    private MobileElement loginEmailInput;

    @AndroidFindBy(accessibility = "input-password")
    @iOSXCUITFindBy(accessibility = "input-password")
    private MobileElement loginPassword;

    @AndroidFindBy(accessibility = "button-LOGIN")
    @iOSXCUITFindBy(accessibility = "button-LOGIN")
    private MobileElement loginFormLoginButton;

    @AndroidFindBy(accessibility = "input-email")
    @iOSXCUITFindBy(accessibility = "input-email")
    private MobileElement signUpEmailInput;

    @AndroidFindBy(accessibility = "input-password")
    @iOSXCUITFindBy(accessibility = "input-password")
    private MobileElement signUpPassword;

    @AndroidFindBy(accessibility = "input-repeat-password")
    @iOSXCUITFindBy(accessibility = "input-repeat-password")
    private MobileElement signUpConfirmPassword;

    @AndroidFindBy(accessibility = "button-SIGN UP")
    @iOSXCUITFindBy(accessibility = "button-SIGN UP")
    private MobileElement signUpFormSignUpButton;

    public Footer footer;

    public LoginPage(AppiumDriver<?> driver) {
        super(driver);
        footer = new Footer(driver);
    }

    public void focusLoginTab() {
        // FindBy annotations are not mandatory, we can do it like this:
        driver.findElement(MobileBy.AccessibilityId("button-login-container")).click();
    }

    public void focusSignUpTab() {
        driver.findElement(MobileBy.AccessibilityId("button-sign-up-container")).click();
    }

    public void login(String email, String password) {
        loginEmailInput.clear();
        loginEmailInput.sendKeys(email);
        loginPassword.clear();
        loginPassword.sendKeys(password);
        driver.hideKeyboard();
        loginFormLoginButton.click();
    }

    public void signUp(String email, String password, String confirmPassword) {
        signUpEmailInput.clear();
        signUpEmailInput.sendKeys(email);
        signUpPassword.clear();
        signUpPassword.sendKeys(password);
        signUpConfirmPassword.clear();
        signUpConfirmPassword.sendKeys(confirmPassword);
        driver.hideKeyboard();
        signUpFormSignUpButton.click();
    }

    public void verifySuccessfulLogin() {
        verifyDialog("Success", "You are logged in!");
    }

    public void verifySuccessfulSignUp() {
        verifyDialog("Signed Up!", "You successfully signed up!");
    }

    public void verifyErrorDialog() {
        verifyDialog("Failure", "Some fields are not valid!");
    }

    public void verifyErrorMessage(String message) {
        String errorMessage = String.format("Failed to find '%s' message on the page.", message);
        Assert.notNull(findByText(message), errorMessage);
    }

    private void verifyDialog(String title, String message) {
        Popup popup = new Popup(driver);

        // Handle popup
        String actualTitle = popup.getTitle();
        String actualMessage = popup.getMessage();

        // Close the popup
        popup.close();

        // Assert popup and page messages
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(title, actualTitle);
        softAssertion.assertEquals(message, actualMessage);
        softAssertion.assertAll();
    }
}
