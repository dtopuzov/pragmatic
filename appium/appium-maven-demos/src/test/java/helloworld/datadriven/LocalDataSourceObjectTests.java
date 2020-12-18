package helloworld.datadriven;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Example for data driven test with local data source object.
 */
public class LocalDataSourceObjectTests {

    /**
     * Local test data object.
     *
     * @return test data object.
     */
    @DataProvider(name = "simpleDataProvider")
    public Object[][] createData() {
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
    @Test(dataProvider = "simpleDataProvider")
    public void verifyNameAndAge(String name, Integer age) {
        Assert.assertTrue(age > 18);
        System.out.println(name + " age is " + age);
    }
}
