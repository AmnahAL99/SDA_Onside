package Personal_training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.*;

public class IframeTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Initialize the driver
        driver = new EdgeDriver();
        // Navigate to the URL for the iframe test
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void testIframe() {
        // Verify the Bolded text contains "Editor"
        WebElement boldedText = driver.findElement(By.cssSelector("h3"));
        assertTrue(boldedText.getText().contains("Editor"));

        // Switch to the iframe to interact with the text box
        driver.switchTo().frame("mce_0_ifr");

        // Locate the text box and clear any existing text
        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();

        // Type "Hi everyone" into the text box
        textBox.sendKeys("Hi everyone");

        // Switch back to the main document
        driver.switchTo().defaultContent();

        // Verify the text "Elemental Selenium" is displayed on the page
        WebElement footerLink = driver.findElement(By.linkText("Elemental Selenium"));
        assertTrue(footerLink.isDisplayed());
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
 /*
 --------------------------------OR-------------------------------
 import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        // Initialize the driver
        driver = new ChromeDriver();
        // Navigate to the URL for the iframe test
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void testIframeWithXpath() {
        // Verify the Bolded text contains "Editor" using XPath
        WebElement boldedText = driver.findElement(By.xpath("//h3[contains(text(), 'Editor')]"));
        Assert.assertNotNull(boldedText);

        // Switch to the iframe to interact with the text box using XPath to locate the iframe
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);

        // Locate the text box by tag name (as there's usually only one body tag inside an iframe)
        WebElement textBox = driver.findElement(By.tagName("body"));
        textBox.clear(); // Clear the text box
        textBox.sendKeys("Hi everyone"); // Type the message

        // Switch back to the main document
        driver.switchTo().defaultContent();

        // Verify the text "Elemental Selenium" is displayed on the page using XPath
        WebElement footerText = driver.findElement(By.xpath("//a[contains(text(), 'Elemental Selenium')]"));
        Assert.assertTrue(footerText.isDisplayed());
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

  */
