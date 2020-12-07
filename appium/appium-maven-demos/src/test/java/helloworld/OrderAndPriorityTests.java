package helloworld;

import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Example for setting proproty and
 */
public class OrderAndPriorityTests {

    @Test(priority = 1, dependsOnMethods = "test3")
    public void test1() {
        Assert.assertTrue(true);
    }

    @Test(priority = 2)
    public void test2() {
        Assert.assertTrue(true);
    }

    @Test(priority = 3)
    public void test3() {
        Assert.assertTrue(true);
    }
}
