package Day04;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertTrue;

public class Challenge {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        driver = new EdgeDriver();
    }




    @Test
    public void test1() {
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        System.out.println("URL Current  url: " + driver.getCurrentUrl());

    }




    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
/*                Tthis method for print result
            // Get the result and print it
            WebElement resultElement = driver.findElement(By.id("answer"));
            String result = resultElement.getText();
            ----------------------------------
                and this for print url
  System.out.println("URL after navigating back: " + driver.getCurrentUrl());
           ----------------------------------
           and this be more helpfull

 */