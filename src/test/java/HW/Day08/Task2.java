package HW.Day08;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Set;
public class Task2 {

    @Test
    public void test1() {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/your/chromedriver");

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            // Go to the URL
            driver.get("https://the-internet.herokuapp.com/windows");

            // Verify the text "Opening a new window"
            WebElement textElement = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
            Assert.assertEquals("Opening a new window", textElement.getText());

            // Verify the title of the page is "The Internet"
            Assert.assertEquals("The Internet", driver.getTitle());

            // Click on the “Click Here” button
            driver.findElement(By.linkText("Click Here")).click();

            // Switch to the new window
            String originalWindow = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();
            for (String windowHandle : allWindows) {
                if (!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            // Verify the new window title is “New Window”
         //   wait.until(ExpectedConditions.titleIs("New Window"));
            Assert.assertEquals("New Window", driver.getTitle());

            // Go back to the previous window
            driver.close(); // Close the new window
            driver.switchTo().window(originalWindow);

            // Then verify the title: “The Internet”
            Assert.assertEquals("The Internet", driver.getTitle());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
