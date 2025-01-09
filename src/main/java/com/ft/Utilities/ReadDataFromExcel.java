package com.ft.Utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.*;

public class ReadDataFromExcel {

/*
    @Test(dataProvider = "loginDetails")
    public void getData(String number, String email, String password) throws IOException {
        System.out.println(number + " :: " + email + " :: " + password);
    }
*/

    @DataProvider(name="loginDetails")
    public Object[][] readData() throws IOException {
        File file = new File(System.getProperty("user.dir")+"/src/main/resources/testData.xlsx");

        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("userIds");

        //Cell cellValue = xssfSheet.getRow(1).getCell(2);
        //System.out.println(cellValue);

        int numberOfRows = xssfSheet.getPhysicalNumberOfRows();
        System.out.println("numberOfRows :: " + numberOfRows);

        int numberOfColumns = xssfSheet.getRow(0).getLastCellNum();
        System.out.println("numberOfColumns :: " + numberOfColumns);

        String[][] dataSet = new String[numberOfRows][numberOfColumns];
        DataFormatter dataFormatter = new DataFormatter();

        for(int i=0; i<numberOfRows-1; i++){
            for (int j=0; j<numberOfColumns; j++){
               // System.out.println(xssfSheet.getRow(i).getCell(j));
                dataSet[i][j] = dataFormatter.formatCellValue(xssfSheet.getRow(i+1).getCell(j));
            }
        }

        for (String[] data:dataSet){
            System.out.println(Arrays.toString(data));
        }

        return dataSet;
    }
}
