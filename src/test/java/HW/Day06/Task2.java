package HW.Day06;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task2 {

    @Test
    public void selectMenuTest() {
        // Set path to your ChromeDriver


        WebDriver driver = new EdgeDriver();
        try {
            // Open the URL
            driver.get("https://demoqa.com/select-menu");

            // Select the Old Style Select Menu using the element id
            WebElement oldStyleSelectMenu = driver.findElement(By.id("oldSelectMenu"));
            Select dropdown = new Select(oldStyleSelectMenu);

            // Print all the options of the dropdown
            System.out.println("Options in the dropdown:");
            dropdown.getOptions().forEach(option -> System.out.println(option.getText()));

            // Select 'Purple' using the index (assuming 'Purple' is at a specific index; adjust as needed)
            dropdown.selectByIndex(3);

            // After that, select 'Magenta' using visible text
            dropdown.selectByVisibleText("Magenta");

            // Select an option using value (assuming options have values; adjust value as needed)
            // dropdown.selectByValue("valueOfOption");
            // Uncomment and use the actual value attribute of the option you want to select

        }
        finally {
            // Close the browser
            driver.quit();
        }
    }
}

