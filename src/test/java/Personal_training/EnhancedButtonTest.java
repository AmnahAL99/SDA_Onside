package Personal_training;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class EnhancedButtonTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }



    @Test
    public void addAndDeleteButtons() {
        int numberOfButtonsToAdd = 100;
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        WebElement deleteButton;

        // Add buttons
        for (int i = 0; i < numberOfButtonsToAdd; i++) {
            addButton.click();
        }

        // Delete buttons and validate
        for (int i = 0; i < numberOfButtonsToAdd; i++) {
            deleteButton = driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
            deleteButton.click();
        }

        List<WebElement> buttons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(0, buttons.size());
    }

        @After
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }



