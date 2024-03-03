package Personal_training;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.*;

public class C14_IFrame {
    private static WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your chromedriver.exe
        // Initialize the driver
        driver = new EdgeDriver();
        // Navigate to the URL for the iframe test
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);
       WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("Hello World");

       driver.switchTo().parentFrame();
        driver.findElement(By.linkText("Elemental Selenium")).click();

    }

    @Test
    public void test2(){


    }




}
// extends TestBase