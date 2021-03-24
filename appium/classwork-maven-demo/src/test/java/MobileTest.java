import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class MobileTest {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Start emulator.");
    }

    @AfterSuite()
    public void afterSuite() {
        System.out.println("Stop emulator.");
    }
}
