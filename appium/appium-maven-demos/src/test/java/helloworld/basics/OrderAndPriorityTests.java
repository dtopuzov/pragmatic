package helloworld.basics;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Example for setting priority and dependsOn.
 */
public class OrderAndPriorityTests {

    @Test(priority = 1, dependsOnMethods = "test4")
    public void test1() {
        /*
        This test has highest priority,
        but will be executed last because it depends on test4().
         */
        Assert.assertTrue(true);
    }

    @Test(priority = 2)
    public void test2() {
        /*
        Will be executed first, because test1() depends on test3().
         */
        Assert.assertTrue(true);
    }

    @Test(priority = 3)
    public void test3() {
        /*
        Priority gets lower as we increase the value.
        This test will be executed after test2().
         */
        Assert.assertTrue(true);
    }

    @Test(priority = 4)
    public void test4() {
        Assert.assertTrue(true);
    }
}
