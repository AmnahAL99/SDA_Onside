package Personal_training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.*;

public class EmojiIFrameTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your chromedriver.exe
        // Initialize the driver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testEmojiSelection() {
        // Navigate to the URL
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // Switch to the iframe to interact with the emoji picker
        driver.switchTo().frame("emoojis");

        // Click on the second emoji
        WebElement secondEmoji = driver.findElement(By.id("tooltip-tjwf8"));

        //secondEmoji.click();
// ========================================================================================
        // Click on all second emoji items - assuming you mean click on each emoji in the second row
        /*
        WebElement emojiContainer = secondEmoji.findElement(By.xpath("./../.."));
        java.util.List<WebElement> secondRowEmojis = emojiContainer.findElements(By.xpath(".//div[@class='emojis'][2]//span"));

        for (WebElement emoji : secondRowEmojis) {
            emoji.click();
        }

        // Return to the parent frame
        driver.switchTo().defaultContent();

        // Fill out the form - assuming the form is outside the iframe
        driver.findElement(By.id("your-form-element-id")).sendKeys("Some text");

        // Click the apply button
        driver.findElement(By.id("apply-button-id")).click();

        // Assertions can be added here to validate the test
 =============================================================================

         */
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
