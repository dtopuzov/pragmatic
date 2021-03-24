import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends MobileTest {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to login page.");
    }

    @Test
    public void loginTest1() {
        Assert.assertTrue(true);
    }

    @Test
    public void loginTest2() {
        Assert.assertTrue(true);
    }
}
