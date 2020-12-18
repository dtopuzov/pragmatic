package nativeapp.tests;

import base.MobileTest;
import nativeapp.enums.FooterItem;
import nativeapp.enums.WDIOMenuItems;
import nativeapp.pages.HomePage;
import nativeapp.pages.WebViewPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WebViewTests extends MobileTest {

    private WebViewPage webViewPage;

    @BeforeEach
    public void beforeEachWebViewTest() {
        HomePage homePage = new HomePage(driver);
        homePage.footer.navigateTo(FooterItem.WEBVIEW);
        webViewPage = new WebViewPage(driver);
    }

    @Test
    void smokeWebViewTest() {
        webViewPage.openTab(WDIOMenuItems.DOCS);
        webViewPage.openTab(WDIOMenuItems.API);
        webViewPage.openTab(WDIOMenuItems.HELP);
        webViewPage.openTab(WDIOMenuItems.BLOG);
        webViewPage.verityTextVisible("WebdriverIO");
    }
}