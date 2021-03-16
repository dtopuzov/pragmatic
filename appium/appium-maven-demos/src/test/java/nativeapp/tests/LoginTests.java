package nativeapp.tests;

import base.MobileTest;
import nativeapp.enums.FooterItem;
import nativeapp.pages.HomePage;
import nativeapp.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Sample tests demonstrating PageObject pattern in Appium world.
 * <p>
 * You can read more at:
 * https://github.com/appium/java-client/blob/master/docs/Page-objects.md
 */
public class LoginTests extends MobileTest {
    private LoginPage loginPage;

    @BeforeMethod
    void beforeLoginTests() {
        HomePage homePage = new HomePage(driver);
        homePage.footer.navigateTo(FooterItem.LOGIN);
        loginPage = new LoginPage(driver);
        loginPage.focusLoginTab();
    }

    @Test
    void loginWithValidAccount() {
        loginPage.login("dtopuzov@gmail.com", "password");
        loginPage.verifySuccessfulLogin();
    }

    @Test
    void loginWithInvalidAccount() {
        loginPage.login("dtopuzovgmail.com", "password");
        loginPage.verifyErrorMessage("Please enter a valid email address");
    }

    @Test
    void loginWithShortPassword() {
        loginPage.login("dtopuzov@gmail.com", "pass");
        loginPage.verifyErrorMessage("Please enter at least 8 characters");
    }
}
