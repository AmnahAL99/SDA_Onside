package HW.Day06;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

     public class DropdownTests {
    private WebDriver driver;
    private Select dropdown;

    @Before
    public void setUp() {
        // Set up ChromeDriver path, this needs to be set according to your system
        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        dropdown = new Select(driver.findElement(By.id("dropdown")));
        driver.findElement(By.id("firstName"));
        driver.findElement((By.id("lastName")));
        driver.findElement(By.id("birthdate"));
        driver.findElement(By.id("email"));
        driver.findElement(By.id("phone"));


    }

    @Test
    public void testDropdown() {
        // Select by index
        dropdown.selectByIndex(1);
        System.out.println("Selected by index: " + dropdown.getFirstSelectedOption().getText());

        // Select by value
        dropdown.selectByValue("2");
        System.out.println("Selected by value: " + dropdown.getFirstSelectedOption().getText());

        // Select by visible text
        dropdown.selectByVisibleText("Option 1");
        System.out.println("Selected by visible text: " + dropdown.getFirstSelectedOption().getText());

        // Print all options
        System.out.println("All dropdown options:");
        for (WebElement option : dropdown.getOptions()) {
            System.out.println(option.getText());
        }

        // Verify Option 2 exists
        boolean hasOption2 = dropdown.getOptions().stream().anyMatch(option -> option.getText().equals("Option 2"));
        System.out.println("Dropdown has Option 2: " + hasOption2);

        // Print first selected option
        System.out.println("First selected option: " + dropdown.getFirstSelectedOption().getText());

        // Check dropdown size
        int size = dropdown.getOptions().size();
        if (size != 3) {
            System.out.println("Expected Is Not Equal Actual");
        } else {
            System.out.println("Dropdown size is as expected: " + size);
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
