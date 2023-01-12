package tests;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Day11_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
//        workbook>worksheet>row>cell
//        Store the path of the  file in a string
        String path = "src/test/java/resources/Capitals.xlsx";
//        ".\\src\\test\\java\\resources\\Capitals.xlsx" //WINDOWS
//        Open the file
        FileInputStream fileInputStream = new FileInputStream(path);
//        Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        Open the first worksheet
        Sheet sheet1 = workbook.getSheet("Sheet1");
//        workbook.getSheetAt(0);//ALTERNATIVELY
//        Go to first row
        Row row1 = sheet1.getRow(0);//index starts at 0. going to the first row
//        Go to first cell on that first row and print
        Cell cell1 = row1.getCell(0);//index starts at 0. reading the first cell data that is on the first row
        System.out.println(cell1);
// We can convert the cell data to string
        String cell1Data = cell1.toString();
        System.out.println(cell1Data);
//        Go to second cell on that first row and print
        Cell cell2 = row1.getCell(1);
        System.out.println(cell2);
//        Go to 2nd row first cell  and assert if the data equal to USA
        String r2c1 = sheet1.getRow(1).getCell(0).toString();  // Short Way chaining the methods
        assertEquals("USA", r2c1);

//        Go to 3rd row 2nd cell-chain the row and cell

        String r3c2 = sheet1.getRow(2).getCell(1).toString();
        System.out.println(r3c2);
//        Find the number of row
        int numberOfRows = sheet1.getLastRowNum() + 1;//Index starts at 0 , so add1 to find total number of row.
        System.out.println("Row Count : " + numberOfRows);
//        Find the number of used row
        int numberOfData = sheet1.getPhysicalNumberOfRows(); // This will return the row numbers which is not empty
//        Print country, capitol key value pairs as map object
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < numberOfData; i++) {
            for (int k = 0; k < 1; k++) {
                map.put(sheet1.getRow(i).getCell(k).toString(), sheet1.getRow(i).getCell(k + 1).toString());
            }
        }
        System.out.println(map);
        //2.WAY
        //        Create a Map that will store the country, capital pairs

        Map<String, String> countryCapitals = new HashMap<>();
        for (int rowNum = 1; rowNum < numberOfRows; rowNum++) {//row index starts at 1, ends at 11
            String county = sheet1.getRow(rowNum).getCell(0).toString();
            String capital = sheet1.getRow(rowNum).getCell(1).toString();
            countryCapitals.put(county, capital);
            System.out.println(countryCapitals);


        }








    }
}