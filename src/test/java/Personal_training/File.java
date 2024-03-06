package Personal_training;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

public class File extends TestBase {
    @Test
    public void test() {


    }
    }

//      boolean isExist =  Files.exists("  ");
//        boolean isExist2 =  Files.exists(Path.of(System.getProperty("user.home")+ "/D/"));
//        System.out.println("isExist"+ isExist);
//        assertTrue(isExist);
//    }
/*
    @Test
    public void googleSearchTest() throws IOException {
        // Load the Excel file
        FileInputStream file = new FileInputStream(new File("path/to/your/excel/file.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            String searchQuery = row.getCell(1).getStringCellValue();

            // Use Selenium to perform the search on Google
            driver.get("http://www.google.com");
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys(searchQuery);
            searchBox.submit();

            // Add your verification logic here
            // For example, you could verify that the search results page contains expected text
        }

        workbook.close();
        file.close();
    }

 */

