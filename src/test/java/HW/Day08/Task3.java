package HW.Day08;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.Set;
import org.junit.Assert;
public class Task3 {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testMultipleWindows() throws InterruptedException {
        // Go to the URL
        driver.get("https://demoqa.com/browser-windows");

        // Click on the "WindowButton" to open new windows
        WebElement windowButton = driver.findElement(By.id("windowButton"));
        windowButton.click();

        // Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        // Store all currently open windows
        Set<String> allWindows = driver.getWindowHandles();

        // Loop through the window handles
        for (String windowHandle : allWindows) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);

                // Print the text from the child window
                System.out.println("Text in child window: " + driver.findElement(By.tagName("body")).getText());

                // Close the current window
                driver.close();
            }
        }

        // Switch back to the original window
        driver.switchTo().window(originalWindow);

        // Print the heading of the parent window
        System.out.println("Heading of the parent window: " + driver.findElement(By.tagName("h1")).getText());


        // Verify if the operation was successful (Optional assertion)
       // Assert.assertEquals("Parent Window Heading: Sample", driver.findElement(By.tagName("h1")).getText());
    }


    @After
    public void tearDown() {
        driver.quit(); // Close the browser
    }


}
