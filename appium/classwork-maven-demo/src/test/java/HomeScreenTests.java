import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeScreenTests extends MobileTest {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to home page.");
    }

    @Test
    public void homeTest1() {
        Assert.assertTrue(true);
    }

    @Test
    public void homeTest2() {
        Assert.assertTrue(true);
    }
}
