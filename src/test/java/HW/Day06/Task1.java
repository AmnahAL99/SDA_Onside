package HW.Day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task1 {

    @Test
    public void dropdownTest() {
        // Set path to your ChromeDriver

        WebDriver driver = new EdgeDriver();
        try {
            // Go to URL
            driver.get("https://the-internet.herokuapp.com/dropdown");

            // Find the dropdown element
            WebElement dropdownElement = driver.findElement(By.id("dropdown"));
            Select dropdown = new Select(dropdownElement);

            // Select Option 1 by index
            dropdown.selectByIndex(1);
            // Select Option 2 by value
            dropdown.selectByValue("2");
            // Select Option 1 by visible text
            dropdown.selectByVisibleText("Option 1");

            // Print all dropdown options
            List<WebElement> options = dropdown.getOptions();
            for (WebElement option : options) {
                System.out.println(option.getText());
            }

            // Verify the dropdown contains "Option 2" text
            boolean hasOption2 = options.stream().anyMatch(option -> option.getText().equals("Option 2"));
            Assert.assertTrue("Dropdown does not contain Option 2", hasOption2);

            // Print the first selected option
            System.out.println("First selected option: " + dropdown.getFirstSelectedOption().getText());

            // Verify the dropdown size
            int expectedSize = 3; // Including the default "Please select an option"
            int actualSize = options.size();
            if (actualSize != expectedSize) {
                System.out.println("Expected Is Not Equal Actual");
            }

        } finally {
            // Close browser
            driver.quit();
        }
    }
}
