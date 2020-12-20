package morseapp;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.Callable;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class MorseApp {
    private App app;

    private Pattern cleanEnglishButton = new Pattern("cleanEnglishButton.png");
    private Pattern cleanMorseButton = new Pattern("cleanMorseButton.png");
    private Pattern translateToEnglish = new Pattern("translateToEnglish.png");
    private Pattern translateToMorse = new Pattern("translateToMorse.png");
    private Pattern tabEnglish = new Pattern("tabTitleEnglish.png").targetOffset(0, 25);
    private Pattern tabMorse = new Pattern("tabTitleMorse.png").targetOffset(0, 25);

    public MorseApp() {
    }

    public void start() {
        // Start app with `getRuntime()`.
        // In case it was normal app we can do it much easier with Sikuli build-in methods.
        // Please see:
        // http://doc.sikuli.org/globals.html#App
        // https://sikulix-2014.readthedocs.io/en/latest/appclass.html
        try {
            Runtime.getRuntime().exec("java -jar testapp\\morsecodetranslator.jar");
        } catch (IOException e) {
            throw new RuntimeException("Failed to start morse app!");
        }

        // Wait until app start
        Callable<Boolean> titleFound = () -> App.getApps()
                .stream()
                .anyMatch(t -> t.getTitle().equalsIgnoreCase("Morse Translator"));
        await()
                .atMost(10, SECONDS)
                .until(titleFound);

        // Find the app based on title and assign the `app` local private variable.
        Optional<App> app = App.getApps()
                .stream()
                .filter(t -> t.getTitle().equalsIgnoreCase("Morse Translator"))
                .findFirst();

        if (app.isPresent()) {
            this.app = app.get();
        } else {
            throw new RuntimeException("Failed to find test app!");
        }
    }

    public void stop() {
        app.close();
    }

    public void cleanMorse() throws FindFailed {
        app.window().wait(cleanMorseButton).click();
    }

    public void cleanEnglish() throws FindFailed {
        app.window().wait(cleanEnglishButton).click();
    }

    public void translateToMorse() throws FindFailed {
        app.window().wait(translateToMorse).click();
    }

    public void translateToEnglish() throws FindFailed {
        app.window().wait(translateToEnglish).click();
    }

    public void typeEnglish(String text) throws FindFailed {
        app.window().wait(tabEnglish).click();
        app.window().type(text);
    }

    public void typeMorse(String text) throws FindFailed {
        app.window().wait(tabMorse).click();
        app.window().type(text);
    }

    public boolean exists(Pattern pattern) {
        return app.window().exists(pattern) != null;
    }
}
