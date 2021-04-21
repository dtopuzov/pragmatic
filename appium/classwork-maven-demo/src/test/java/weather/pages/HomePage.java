package weather.pages;

import com.pragmatic.framework.base.MobileScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class HomePage extends MobileScreen {
    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public void visit() {
        driver.navigate().to("https://www.google.com/");
    }

    public void acceptCookies() {
        MobileElement accept = driver.findElement(By.id("zV9nZe"));
        driver.executeScript("arguments[0].click();", accept);
    }

    public void search(String text) {
        MobileElement input = driver.findElement(By.cssSelector("input[name=q]"));
        input.clear();
        input.sendKeys(text + Keys.ENTER);
    }

    public double getTemperature() {
        MobileElement temp = driver.findElement(By.id("wob_tm"));
        return Double.parseDouble(temp.getText());
    }
}
