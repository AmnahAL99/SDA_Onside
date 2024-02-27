package Personal_training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class IframeTest2 {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your chromedriver.exe

        // Initialize the driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testIframeInteraction() throws InterruptedException {
        // Navigate to the URL
        driver.get("http://demo.guru99.com/test/guru99home/");

        // Find the number of iframes on the page
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        int numberOfIframes = iframes.size();
        System.out.println("Number of iframes on the page: " + numberOfIframes);

        // Assert if the number of iframes is as expected
        assertTrue("Number of iframes should be at least 3", numberOfIframes >= 3);

        // Switch to the third iframe
        driver.switchTo().frame(iframes.get(2));

        // Click on the link inside the third iframe
        WebElement link = driver.findElement(By.linkText("click here"));
        link.click();

        // Switch back to the main window
        driver.switchTo().defaultContent();

        // More actions can be performed on the main page after this
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

