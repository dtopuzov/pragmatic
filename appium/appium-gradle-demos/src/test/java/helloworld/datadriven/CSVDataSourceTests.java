package helloworld.datadriven;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example for data driven test where test data is in CSV file.
 */
public class CSVDataSourceTests {
    /**
     * JUnit 5 provides build in mechanism to read test data from CSV files.
     * No need to use helper libs as we do with TestNG in `appium-maven-demo` project.
     *
     * @param name name of employee.
     * @param age  of the employee.
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv")
    void testsForSum(String name, Integer age) {
        assertTrue(age > 18);
        System.out.println(name + " age is " + age);
    }
}
