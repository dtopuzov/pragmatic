package helloworld.datadriven;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

/**
 * Util to read data source from CSV file.
 */
public class CSVDataProvider {


    /**
     * Read test data from csv file.
     *
     * @return test data object.
     * @throws IOException  when fail to find data source file.
     * @throws CsvException when fail to read data source file.
     */
    @DataProvider(name = "csvDataProvider")
    public static Object[][] createData() throws CsvException, IOException {
        // Read CSV file from resources folder
        ClassLoader classLoader = CSVDataProvider.class.getClassLoader();
        InputStream resource = classLoader.getResourceAsStream("test-data.csv");

        // Parse the file with CSVReader
        Reader reader = new InputStreamReader(resource);
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> dataList = csvReader.readAll();
        csvReader.close();

        // Generate Object[][] and return it
        Object[][] data = new Object[dataList.size()][2];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                String[] line = dataList.get(i);
                data[i][j] = line[j];
            }
        }

        return data;
    }
}