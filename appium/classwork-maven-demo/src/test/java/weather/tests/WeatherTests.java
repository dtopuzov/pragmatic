package weather.tests;

import com.pragmatic.framework.base.MobileTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import weather.api.WeatherApi;
import weather.pages.HomePage;

public class WeatherTests extends MobileTest {
    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        homePage = new HomePage(driver);
        homePage.visit();
        homePage.acceptCookies();
    }

    @Test
    public void searchForTemperature() {
        double apiTemp = WeatherApi.getTemperature("Sofia,bg");

        homePage.search("temperature Sofia,bg C");
        double webTemp = homePage.getTemperature();
        Assert.assertTrue(Math.abs(apiTemp - webTemp) < 3.0, "Web shows incorrect temperature");
    }

    @Test
    public void searchForTemperature2() {
        String apiTempString = WeatherApi
                .getWeather("Sofia,bg")
                .getTemperature();
        double apiTemp = Double.parseDouble(apiTempString.replace(" °C", ""));

        homePage.search("temperature Sofia,bg C");
        double webTemp = homePage.getTemperature();
        Assert.assertTrue(Math.abs(apiTemp - webTemp) < 3.0, "Web shows incorrect temperature");
    }
}
