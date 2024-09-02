package utility;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDataProvider {
    @DataProvider(name = "csvValidDataProvider")
    public Iterator<Object[]> csvValidDataProvider() throws IOException {
        String csvFilePath  = "D:/riham/ITI/MobileTesting/project/SwagLabs/dataFiles/successfulLoginDataFile.csv";

        List<Object[]> testData = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            String[] arrayCsvCell;

            // Read CSV and add data to the testData list
            while ((arrayCsvCell = csvReader.readNext()) != null) {
                String userName = arrayCsvCell[0];
                String password = arrayCsvCell[1];
                testData.add(new Object[]{userName, password});
            }
        }
        return testData.iterator();
    }
    @DataProvider(name = "csvInvalidDataProvider")
    public Iterator<Object[]> csvInvalidDataProvider() throws IOException {
        String csvFilePath  = "D:/riham/ITI/MobileTesting/project/SwagLabs/dataFiles/invalidUserDataFile.csv";

        List<Object[]> testData = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            String[] arrayCsvCell;

            // Read CSV and add data to the testData list
            while ((arrayCsvCell = csvReader.readNext()) != null) {
                String userName = arrayCsvCell[0];
                String password = arrayCsvCell[1];
                String errorMassage = arrayCsvCell[2];
                testData.add(new Object[]{userName, password,errorMassage});
            }
        }
        return testData.iterator();
    }
}
