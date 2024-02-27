package Day04;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.*;

public class Challenge {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        driver = new EdgeDriver();
    }
    @Test
    public void test1() {
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        // Enter email and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("sda@test.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("sdainclasstask");

        // Click on Login button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        // Check for error message and return true or false
        assertTrue(isErrorMessageVisible());


    }

    private boolean isErrorMessageVisible() {
        boolean isVisible = !driver.getCurrentUrl().isEmpty();

        return isVisible;
    }


    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
