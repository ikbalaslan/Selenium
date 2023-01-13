package practices_with_group.Practice06;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q01 {
    ///*
    //    Given
    //        Save EarningList.xlsx file into your project
    //    When
    //        In the row column, write the row numbers according to the earnings amount.
    //    Then
    //        Assert that row number of Wednesday is 1
    //     */
    @Test
    public void test() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("./src/test/java/resources/EarningList.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        List<Double> list = new ArrayList<>();
        Cell x =  sheet.getRow(1).getCell(1);
        for (int i = 1;i<=sheet.getLastRowNum();i++){
            list.add(Double.valueOf(String.valueOf(sheet.getRow(i).getCell(1))));
        }
        Collections.sort(list);
        list.get(0);


    }
}
