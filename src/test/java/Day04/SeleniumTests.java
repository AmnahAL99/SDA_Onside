package Day04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;



    public class SeleniumTests {
    WebDriver driver;

    @Before
    public void setup() {
        // Setting up Chrome WebDriver
      //  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

       // ChromeOptions options = new ChromeOptions();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("disable-popup-blocking");
        driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testDropDownSynchronization() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("disable-popup-blocking");
        driver = new EdgeDriver(options);
        driver.get("https://www.google.com");
        // Example: Select dropdown option
      //  WebElement dropdown = driver.findElement(By.id("dropdown"));
        // Wait until dropdown is clickable
       // WebDriverWait wait = new WebDriverWait(driver, 10);
      //  wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        //Select select = new Select(dropdown);
       // select.selectByVisibleText("Option 1");
        // Perform further actions...
    }

    @Test
    public void testAlerts() {
        driver.get("https://www.google.com");
        // Example: Handle JavaScript alert
        WebElement alertButton = driver.findElement(By.id("alert-button"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        // Perform further actions...
    }

    @Test
    public void testBasicAuthentication() {
        // Example: Handling Basic Authentication
        String username = "username";
        String password = "password";
        String url = "http://" + username + ":" + password + "@example.com";
        driver.get(url);
        // Perform further actions...
    }

    @Test
    public void testIFrame() {
        driver.get("https://www.example.com");
        // Switch to iFrame
        driver.switchTo().frame("iframe_id");
        // Perform actions within iFrame
        WebElement elementInFrame = driver.findElement(By.id("element_id"));
        elementInFrame.click();
        // Switch back to default content
        driver.switchTo().defaultContent();
        // Perform further actions...
    }

    @After
    public void tearDown() {
        // Closing the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}


