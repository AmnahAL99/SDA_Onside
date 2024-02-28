package Personal_training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class MultipleWindowTest {

    WebDriver driver;

    @Before
    public void setUp() {
        // Set up WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testMultipleWindows() {
        // Open main window
        driver.get("https://example.com");

        // Click a link/button that opens a new window
        driver.findElement(By.linkText("Open New Window")).click();

        // Get handles of all windows
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new window
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Perform actions on the new window
        driver.findElement(By.id("elementId")).sendKeys("Data to fill");

        // Close the new window
        driver.close();

        // Switch back to the main window
        driver.switchTo().window((String) windowHandles.toArray()[0]);
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

