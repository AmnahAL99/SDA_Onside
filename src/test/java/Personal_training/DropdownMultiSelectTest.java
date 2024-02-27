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

import static org.junit.Assert.assertTrue;

public class DropdownMultiSelectTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to the chromedriver executable


        // Initialize a ChromeDriver instance
        driver = new EdgeDriver();

        // Open the specified URL
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void testMultiSelectDropdown() {
        // Find the multi-select dropdown element by its ID
        WebElement multiSelectElement = driver.findElement(By.id("cars"));
        Select multiSelectDropdown = new Select(multiSelectElement);

        // Verify that the element is a multi-select
        assertTrue(multiSelectDropdown.isMultiple());

        // Select 'Opel' by index
        multiSelectDropdown.selectByIndex(2); // Assuming 'Opel' is at index 2

        // Deselect 'Opel' by index
        multiSelectDropdown.deselectByIndex(2);

        // Select 'Saab' by value
        multiSelectDropdown.selectByValue("saab");

        // Deselect 'Saab' by value
        multiSelectDropdown.deselectByValue("saab");

        // Deselect all options
        multiSelectDropdown.deselectAll();
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
