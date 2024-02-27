package Personal_training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dropdown {

    private WebDriver driver;

    @Before
    public void setUp() {

        // Initialize a ChromeDriver instance
        driver = new EdgeDriver();

        // Implicitly wait for elements to be ready before attempting interactions
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the specified URL
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void testSelectDropdown() {
        // Find the dropdown element by its ID
        WebElement selectElement = driver.findElement(By.id("oldSelectMenu"));
        Select dropdown = new Select(selectElement);

        // Print all options in the dropdown
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        // Select 'Purple' by index
        dropdown.selectByIndex(3); // Assuming 'Purple' is at index 3

        // Select 'Magenta' by visible text
        dropdown.selectByVisibleText("Magenta");

        // Select an option by value (replace "value" with the actual value attribute of the option you want to select)
       // dropdown.selectByValue("value");
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

