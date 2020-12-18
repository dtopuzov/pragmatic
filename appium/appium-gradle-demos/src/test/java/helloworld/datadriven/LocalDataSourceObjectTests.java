package helloworld.datadriven;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example for data driven test with local data source object.
 */
public class LocalDataSourceObjectTests {

    /**
     * Local test data object.
     *
     * @return test data object.
     */
    public static Object[][] createData() {
        return new Object[][]{
                {"Dimitar", 31},
                {"Vasil", 27},
        };
    }

    /**
     * Example for data driven test.
     *
     * @param name name of employee.
     * @param age  of the employee.
     */
    @ParameterizedTest
    @MethodSource("createData")
    void testsForSum(String name, Integer age) {
        assertTrue(age > 18);
        System.out.println(name + " age is " + age);
    }
}
