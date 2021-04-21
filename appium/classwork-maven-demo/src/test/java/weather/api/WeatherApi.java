package weather.api;

import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.hasKey;

public class WeatherApi {
    public static double getTemperature() {
        String temperature =
                when().
                        get("https://goweather.herokuapp.com/weather/Sofia,bg").
                        then().
                        contentType(JSON).
                        body("$", hasKey("temperature")).
                        extract().
                        path("temperature");

        return Double.parseDouble(temperature.replace(" °C", ""));
    }
}
