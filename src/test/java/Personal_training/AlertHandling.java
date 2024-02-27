package Personal_training;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;
public class AlertHandling {


    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        // Set the path to the chromedriver executable

        // Create a new instance of the Chrome driver
        driver = new EdgeDriver();
        //wait = new WebDriverWait(driver, 10);

        // Navigate to the URL
        driver.get("http://demo.guru99.com/test/delete_customer.php");
    }

    @Test
    public void testDeleteCustomer() {
        // Input '123' into the 'Customer ID' field
        driver.findElement(By.name("cusid")).sendKeys("123");

        // Click on the 'Submit' button
        driver.findElement(By.name("submit")).click();

        // Wait for the alert to be present and switch to it
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        // Get text from alert and assert it is as expected
        assertTrue(alert.getText().contains("Do you really want to delete this Customer?"));
        // Accept the alert (click 'OK')
        alert.accept();

        // Wait for the second alert to be present and switch to it
        alert = wait.until(ExpectedConditions.alertIsPresent());
        // Get text from alert and assert it is as expected
        assertTrue(alert.getText().contains("Customer Successfully Delete!"));
        // Accept the second alert (click 'OK')
        alert.accept();
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }



}
