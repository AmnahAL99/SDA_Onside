package HW.Day07;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Task1 {

    @Test
    public void testBasicAuth() {
        // Initialize the WebDriver instance
        WebDriver driver = new EdgeDriver();

        try {
            // Navigate to the URL with basic authentication credentials
            driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

            // Locate the element containing the congratulations message
            WebElement messageElement = driver.findElement(By.cssSelector("p"));

            // Verify the message text
            String expectedMessage = "Congratulations! You must have the proper credentials.";
            Assert.assertEquals("The congratulations message is not as expected", expectedMessage, messageElement.getText());
        }
        finally {
            // Close the browser
            driver.quit();
        }
    }

}
