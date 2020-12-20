package morsetests;

import morseapp.MorseApp;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sikuli.Sikuli;

public class MorseTests {
    private MorseApp morseApp;

    @BeforeClass
    public void beforeMorseTests() {
        Sikuli.init();
        morseApp = new MorseApp();
        morseApp.start();
    }

    @AfterClass
    public void afterMorseTests() {
        morseApp.stop();
    }

    @Test
    public void testMorseToEnglishTranslation() throws FindFailed {
        morseApp.cleanMorse();
        morseApp.typeMorse("--.- .-  / ");
        morseApp.translateToEnglish();

        Pattern pattern = new Pattern("test-data-qa.png");
        Assert.assertTrue(morseApp.exists(pattern));
    }

    @Test
    public void testEnglishToMorseTranslation() throws FindFailed {
        morseApp.cleanEnglish();
        morseApp.typeEnglish("test");
        morseApp.translateToMorse();

        Pattern pattern = new Pattern("test-in-morse-code.png");
        Assert.assertTrue(morseApp.exists(pattern));
    }
}
