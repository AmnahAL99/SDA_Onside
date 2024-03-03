package Day08;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class C01IFrame {

        static WebDriver driver;

    @Before
    public void setUp() {
        // Initialize the driver
        driver = new EdgeDriver();
        // Navigate to the URL for the iframe test
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

        @Test
        public void test()  {
            WebElement textBox = driver.findElement(By.tagName("h3"));
            assertTrue(textBox.getText().contains("Editor"));
            driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M7.8 19c-.')]")).click();
            driver.switchTo().frame(0);
            WebElement textBox2 = driver.findElement(By.id("tinymce"));
            textBox2.clear();
            textBox2.sendKeys("Hello SDA");

          // switch by id  ==> driver.switchTo().frame();

            driver.switchTo().parentFrame();
             WebElement text =  driver.findElement(By.linkText("Elemental Selenium"));
            Assert.assertTrue(text.isDisplayed());

            //Go to URL: https://the-internet.herokuapp.com/iframe

        //Verify the Bolded text contains "Editor"
        //  xpath : //h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']  , //h3  ,  tagName : h3

        //Locate the text box

        // To access the textBox web element, we need to switch to the iframe; otherwise, we will encounter a NoSuchElementExcepion.

        // Switching to the iframe

        // Using index (starts at 0)
        // Using id or name
        // Using webElement

        //WebElement textBox1 = driver.findElement(textBox);

        // Delete the text in the text box

        // Type "Hi everyone"


        // If we want to perform operations outside the iframe again
        // Brings it up by one level


        // Verify that the text "Elemental Selenium" is displayed on the page.
        //driver.quit();
    }

        }
