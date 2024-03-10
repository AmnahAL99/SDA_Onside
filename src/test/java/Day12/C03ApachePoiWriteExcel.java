package Day12;

import Utilities.TestBase;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class C03ApachePoiWriteExcel  {
    //Store the path of the file as string and open the file.
    //Open the workbook.
    //Open the first worksheet.
    //Go to the first row.
    //Create a cell on the 3rd column (2nd index) on the first row.
    //Write "POPULATION" on that cell.
    //Create a cell on the 2nd row 3rd cell(index2), and write data.
    //Create a cell on the 3rd row 3rd cell(index2), and write data.
    //Create a cell on the 4th row 3rd cell(index2), and write data.
    //Write and save the workbook.
    //Close the file.
    //Close the workbook.

    @Test
    public void test1() throws IOException {
        String separator = System.getProperty("file.separator");
        String path = System.getProperty("user.dir") + separator + "resources" + separator + "excelfile.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet1 = wb.getSheet("Sheet1");
        Row row1 = sheet1.getRow(0);
        Row row17 = sheet1.getRow(16);
        row17.createCell(2).setCellValue("new_cell");
        row1.createCell(2).setCellValue("new cell");
        //===
        Row row3 = sheet1.getRow(2);
        row3.createCell(2).setCellValue("new_cell3");
        //===
        sheet1.createRow(16).createCell(0).setCellValue("POPULATION");
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        wb.write(fileOutputStream);
        wb.close();
        fis.close();

    }


    @Test
    public void test02() throws IOException {

        //Store the path of the file as string and open the file.
        //Open the workbook.
        //Open the first worksheet.
        String separator = System.getProperty("file.separator");
        String path = System.getProperty("user.dir") + separator + "resources" + separator + "excelfile.xlsx";

        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);

        Sheet sheet2 = wb.createSheet("credentials");
        Row row17 = sheet2.createRow(16);

        Cell r17c7 = row17.createCell(6);
        r17c7.setCellValue("NAME");

        Cell r17c8 = row17.createCell(7);
        r17c8.setCellValue("EMAIL");

        Cell r17c9 = row17.createCell(8);
        r17c9.setCellValue("PASSWORD");

        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);

        wb.close();
        fis.close();
        fos.close();
    }

    @Test
    public void test03() throws IOException {


        //Store the path of the file as string and open the file.
        String separator = System.getProperty("file.separator");
        String path = System.getProperty("user.dir") + separator + "resources" + separator + "excelfile.xlsx";

        //Open the workbook.
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);

        //Open the first worksheet.
        Sheet sheet1 = wb.getSheetAt(0);

        //Go to the first row.
        Row row1 = sheet1.getRow(0);

        //Create a cell on the 3rd column (2nd index) on the first row.
        //Write “POPULATION” on that cell.
        Cell cell13 = row1.createCell(2);
        cell13.setCellValue("POPULATION");

        //Create a cell on the 2nd row 3rd cell(index2), and write data.
        Row row2 = sheet1.getRow(1);
        Cell cell23 = row2.createCell(2);
        cell23.setCellValue(1234);

        //Create a cell on the 3rd row 3rd cell(index2), and write data.
        Row row3 = sheet1.getRow(2);
        Cell cell33 = row3.createCell(2);
        cell33.setCellValue(123456);

        //Create a cell on the 4th row 3rd cell(index2), and write data.
        Row row4 = sheet1.getRow(3);
        Cell cell43 = row4.createCell(2);
        cell43.setCellValue(123456789);


        //Write and save the workbook.
        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);

        //Close the file.
        //Close the workbook.
        wb.close();
        fos.close();
        fis.close();
    }

    @Test
    public void test0() throws IOException {

        //Create an object of File class to open xlsx file.
        //Create an object of FileInputStream class to read excel file.
        //Create an object of FileInputStream class to read excel file.
        //Creating workbook instance that refers to .xlsx file.
        String separator = System.getProperty("file.separator");
        String path = System.getProperty("user.dir") + separator + "resources" + separator + "excelfile.xlsx";

        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);

        //Creating a Sheet object.
        Sheet sheet1 = wb.getSheetAt(0);

        //Get all rows in the sheet.
        int rowsUsed = 0;
        while(true){
            if ( sheet1.getRow(rowsUsed).getCell(0) == null ){
                rowsUsed--;
                break;
            }
            rowsUsed++;
        }
        List<Row> rowsList = new ArrayList<>();
        for (int i = 0; i <= rowsUsed; i++){
            rowsList.add(sheet1.getRow(i));
        }
        System.out.println(rowsList.size());

        //Create a row object to retrieve row at index 3.
        Row row3 = sheet1.getRow(2);

        //Create a cell object to enter value in it using cell Index.
        Cell cell3 = row3.createCell(2);
        cell3.setCellValue("test");

        //Write the data in excel using output stream.
        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);

        wb.close();
        fis.close();
        fos.close();

    }
//===================================================
    @Test
    public void test7() throws IOException {
        String separator = System.getProperty("file.separator");
        String path = System.getProperty("user.dir") + separator + "resources" + separator + "excelfile.xlsx";

        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);

        Sheet sheet1 = wb.getSheetAt(0);

        int rowsUsed = 0;
        while(true){
            if ( sheet1.getRow(rowsUsed).getCell(0) == null ){
                break;
            }
            rowsUsed++;
        }
        for (int i = 1; i < rowsUsed; i++){
            sheet1.getRow(i).createCell(2).setCellValue(i + "" + i + "" + i + "" + i);
        }

        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);


    }
}



