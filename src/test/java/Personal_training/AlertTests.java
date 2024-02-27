package Personal_training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class AlertTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        //wait = new WebDriverWait(driver, 10);
        driver.get("http://demo.automationtesting.in/Alerts.html");
    }

    @Test
    public void testAlerts() {
        // Alert with OK
        driver.findElement(By.xpath("//button[contains(text(),'display an alert box:')]")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("I am an alert box!", alert.getText());
        alert.accept();

        // Alert with OK & Cancel
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'display a confirm box')]")).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Press a Button !", alert.getText());
        alert.dismiss();

        // Alert with Textbox
        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'demonstrate the prompt box')]")).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Please enter your name", alert.getText());
        alert.sendKeys("Bootcamp");
        alert.accept();

        // Get the result text
        String resultText = driver.findElement(By.id("demo1")).getText();
        assertEquals("Hello Bootcamp How are you today", resultText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
/*
------------------------------OR---------------------------------
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class AlertTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        // Assuming you have set the path to the driver executable correctly in your system properties
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://demo.automationtesting.in/Alerts.html");
    }

    @Test
    public void testAlertWithOK() {
        driver.findElement(By.xpath("//button[contains(text(),'display an alert box:')]")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("I am an alert box!", alert.getText());
        alert.accept();
    }

    @Test
    public void testAlertWithOkAndCancel() {
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'display a confirm box')]")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Press a Button !", alert.getText());
        alert.dismiss();
    }

    @Test
    public void testAlertWithTextbox() {
        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'demonstrate the prompt box')]")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Please enter your name", alert.getText());
        alert.sendKeys("Bootcamp");
        alert.accept();

        // Get the result text
        String resultText = driver.findElement(By.id("demo1")).getText();
        assertEquals("Hello Bootcamp How are you today", resultText);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

 */