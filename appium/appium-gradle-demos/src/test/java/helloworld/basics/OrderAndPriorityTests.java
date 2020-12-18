package helloworld.basics;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example for setting priority.
 * <p>
 * In this example we order via value of @Order attribute.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderAndPriorityTests {

    @Test
    @Order(1)
    public void test1() {
        /*
        This test has highest priority, will be executed first.
         */
        assertTrue(true);
    }

    @Test
    @Order(2)
    public void test2() {
    }

    @Test
    @Order(3)
    public void test3() {
    }
}
