package weather.tests;

import com.pragmatic.framework.base.MobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import weather.api.WeatherApi;
import weather.pages.HomePage;

public class WeatherTests extends MobileTest {
    @Test
    public void searchForTemperature() {
        double apiTemp = WeatherApi.getTemperature();

        HomePage homePage = new HomePage(driver);
        homePage.visit();
        homePage.acceptCookies();
        homePage.search("temperature");
        double webTemp = homePage.getTemperature();
        Assert.assertTrue(Math.abs(apiTemp - webTemp) < 2.0, "Web shows incorrect temperature");
    }
}
