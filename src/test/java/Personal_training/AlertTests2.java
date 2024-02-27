package Personal_training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class AlertTests2 {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set path to your chromedriver.exe
        // Initialize the driver
        driver = new ChromeDriver();
        // Navigate to the page with the JavaScript alerts
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void testAlert() {
        // Click the button that opens the alert
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Check the text on the alert
        assertEquals("I am a JS Alert", alert.getText());

        // Accept the alert (clicks "OK")
        alert.accept();

        // Verify the result text after accepting the alert
        String result = driver.findElement(By.id("result")).getText();
        assertTrue(result.contains("You successfully clicked an alert"));
    }

    @Test
    public void testConfirm() {
        // Click the button that opens the confirm dialog
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();

        // Switch to the confirm dialog
        Alert confirm = driver.switchTo().alert();

        // Dismiss the confirm (clicks "Cancel")
        confirm.dismiss();

        // Verify the result text after dismissing the confirm
        String result = driver.findElement(By.id("result")).getText();
        assertTrue(result.contains("You clicked: Cancel"));
    }

    @Test
    public void testPrompt() {
        // Click the button that opens the prompt
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();

        // Switch to the prompt
        Alert prompt = driver.switchTo().alert();

        // Send some text to the prompt
        prompt.sendKeys("Selenium Test");

        // Accept the prompt (clicks "OK")
        prompt.accept();

        // Verify the result text after accepting the prompt
        String result = driver.findElement(By.id("result")).getText();
        assertTrue(result.contains("You entered: Selenium Test"));
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

