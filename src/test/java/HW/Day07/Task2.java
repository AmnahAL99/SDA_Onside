package HW.Day07;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Task2 {


    private WebDriver driver;

    @Before
    public void setUp() {
        // Initialize the driver
        driver = new EdgeDriver();
    }

    @Test
    public void testJavaScriptAlerts() {
        // Navigate to the alerts page
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Click for JS Alert and accept it
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        // Click for JS Confirm, accept it, and then try dismissing it
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.accept(); // or use confirmAlert.dismiss(); to cancel

        // Click for JS Prompt, enter text, and accept it
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Selenium Test");
        promptAlert.accept();
    }

    @After
    public void tearDown() {
        // Close the driver
        driver.quit();
    }

}
