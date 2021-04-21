package weather.api;

import weather.objects.Weather;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.hasKey;

public class WeatherApi {
    private static String baseUrl = "https://goweather.herokuapp.com/weather/";

    public static double getTemperature(String location) {
        String temperature =
                when().
                        get(baseUrl + location).
                        then().
                        contentType(JSON).
                        body("$", hasKey("temperature")).
                        extract().
                        path("temperature");

        return Double.parseDouble(temperature.replace(" °C", ""));
    }

    public static Weather getWeather(String location) {
        return get(baseUrl + location).as(Weather.class);
    }
}
