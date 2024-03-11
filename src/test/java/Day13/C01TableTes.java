package Day13;
import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
public class C01TableTes extends TestBase {
    @Test
    public void test() {

        driver.get("http://demo.guru99.com/test/web-table-element.php");
        // Get 3rd row's 2nd column data....
        WebElement cell = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[3]/td[2]"));
        System.out.println(cell.getText());
        // Get all values from the table.....
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText() + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test2() {

        //Go to URL: http://demo.guru99.com/test/web-table-element.php
        driver.get("http://demo.guru99.com/test/web-table-element.php");
        //To find third row of table
        WebElement thirdRow = driver.findElement(By.xpath("//table[@class = 'dataTable']//tbody//tr[3]"));


        //To get 3rd row's 2nd column data
        WebElement thirdRowSecondData = thirdRow.findElement(By.xpath(".//td[2]"));
        System.out.println(thirdRowSecondData.getText());

        //Get all the values of a Dynamic Table
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class = 'dataTable']//tbody//tr"));
        List<WebElement> cells = new ArrayList<>();

        List<String> allData = new ArrayList<>();

        for (WebElement w : rows) {
            cells = w.findElements(By.xpath(".//td"));
            for (WebElement y : cells)
                allData.add(y.getText());
        }
        System.out.println(allData);


    }


    @Test
    public void test3() {

        driver.get("http://demo.guru99.com/test/web-table-element.php");

        // Get all values from the table
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            for (int n = 0; n < cols.size(); n++) {
                System.out.print(cols.get(n).getText() + " ");
            }
            System.out.println();
        }

    }
}
