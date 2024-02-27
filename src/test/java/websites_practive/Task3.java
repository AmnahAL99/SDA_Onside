package websites_practive;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;
public class Task3 {

        private static WebDriver driver;

        @BeforeClass
        public static void setUp() {

            driver = new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        @Test
        public void testCalculatorAndLinkedIn() {
            // Navigate to the calculator page
            driver.get("https://testpages.herokuapp.com/styled/index.html");

            // Click on Simple Calculator
            driver.findElement(By.id("calculatetest")).click();

            // Enter numbers in the inputs
            driver.findElement(By.id("number1")).sendKeys("10");
            driver.findElement(By.id("number2")).sendKeys("5");

            // Click on Calculate
            driver.findElement(By.cssSelector("input[value='Calculate']")).click();

            // Get the result and print it
            WebElement resultElement = driver.findElement(By.id("answer"));
            String result = resultElement.getText();
            System.out.println("Result of calculation: " + result);

            // Go to LinkedIn
            driver.get("https://www.linkedin.com/");

            // Locate elements on LinkedIn using absolute and relative XPaths
            WebElement emailOrPhone = driver.findElement(By.xpath("//input[@id='session_key']"));
            WebElement password = driver.findElement(By.xpath("//input[@id='session_password']"));
            WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        }


        @AfterClass
        public static void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }





