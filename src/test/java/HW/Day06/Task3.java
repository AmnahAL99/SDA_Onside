package HW.Day06;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertTrue;

public class Task3 {

    @Test
    public void multiSelectTest() {


        WebDriver driver = new EdgeDriver();
        try {
            // Open the URL
            driver.get("https://demoqa.com/select-menu");

            // Select the Standard Multi-Select using the element id
            WebElement multiSelectElement = driver.findElement(By.id("cars"));
            Select multiSelectDropdown = new Select(multiSelectElement);

            // Verifying that the element is multi-select
            assertTrue("The dropdown is not a multi-select", multiSelectDropdown.isMultiple());

            // Select 'Opel' using the index and deselect the same using index
            multiSelectDropdown.selectByIndex(2);
            multiSelectDropdown.deselectByIndex(2);

            // Select 'Saab' using value and deselect the same using value
            multiSelectDropdown.selectByValue("saab");
            multiSelectDropdown.deselectByValue("saab");

            // Deselect all the options
            multiSelectDropdown.deselectAll();

        }
        finally {
            // Close the browser
            driver.quit();
        }
    }
}

