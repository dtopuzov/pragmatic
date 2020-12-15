package helloworld.datadriven;

import org.testng.annotations.Test;

/**
 * Example for data driven test where test data is in CSV file.
 */
public class CSVDataSourceTests {
    /**
     * Example for data driven tests with external data source class.
     * <p>
     * Note that when dataProvider method is from another class
     * then class should be specified in "dataProviderClass" attribute.
     *
     * @param name name of employee.
     * @param age  of the employee.
     */
    @Test(dataProviderClass = CSVDataProvider.class, dataProvider = "csvDataProvider")
    public void verifyNameAndAgeFromCsv(String name, String age) {
        System.out.println(name + " age is " + age);
    }
}
