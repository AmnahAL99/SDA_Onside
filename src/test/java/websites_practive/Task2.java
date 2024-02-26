package websites_practive;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class Task2 {


        private static WebDriver driver;

        @BeforeClass
        public static void setUp() {

            driver = new EdgeDriver();
           // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    @Test
    public void testHerokuLogin() {
        driver.get("https://id.heroku.com/login");

        // Enter email and password
        driver.findElement(By.id("email")).sendKeys("Amnah@example.com");
        driver.findElement(By.id("password")).sendKeys("1234");

        // Click on Login button
        driver.findElement(By.cssSelector("button[value='Log In']")).click();
        // Check for error message and return true or false
        assertTrue(isErrorMessageVisible());

    }

    private boolean isErrorMessageVisible() {
        boolean isVisible = !driver.findElements(By.xpath("//div[contains(text(),'There was a problem with your login.')]")).isEmpty();

        if (isVisible) {
            System.out.println("Registration Failed");
        } else {
            System.out.println("Registered");
        }
        return isVisible;
    }



    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}




