package Personal_training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class HMW {


    private WebDriver driver;
    private Select dropdown;

    @Before
    public void setUp() {

        // Initialize the WebDriver and open the browser
        driver = new EdgeDriver();

        // Navigate to the URL
        driver.get("https://demoqa.com/select-menu");

        // Initialize the dropdown select element
        dropdown = new Select(driver.findElement(By.id("oldSelectMenu")));
    }

    @Test
    public void testDropdown() {
        // Print all the options of the dropdown
        System.out.println("All options in the dropdown:");
        for (WebElement option : dropdown.getOptions()) {
            System.out.println(option.getText());
        }

        // Select 'Purple' using the index (assuming 'Purple' is at index 4)
        dropdown.selectByIndex(4); // The index value should be adjusted based on actual dropdown
        System.out.println("Selected by index: " + dropdown.getFirstSelectedOption().getText());

        // Assert 'Purple' is selected
        assertTrue("Purple".equals(dropdown.getFirstSelectedOption().getText()));

        // Select 'Magenta' using visible text
        dropdown.selectByVisibleText("Magenta");
        System.out.println("Selected by visible text: " + dropdown.getFirstSelectedOption().getText());

        // Assert 'Magenta' is selected
        assertTrue("Magenta".equals(dropdown.getFirstSelectedOption().getText()));

        // Select an option using value (assuming 'OptionValue' is a valid value attribute for an option)
        dropdown.selectByValue("OptionValue"); // Replace 'OptionValue' with actual value attribute
        System.out.println("Selected by value: " + dropdown.getFirstSelectedOption().getText());

        // Assert the correct option is selected
        assertTrue("ExpectedOptionText".equals(dropdown.getFirstSelectedOption().getText())); // Replace 'ExpectedOptionText' with the expected text of the option
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

/*
----------------------------OR-----------------------
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class DropdownTestWithJUnit {

    private WebDriver driver;
    private Select dropdown;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/your/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        dropdown = new Select(driver.findElement(By.id("oldSelectMenu")));
    }

    @Test
    public void testSelectByIndex() {
        dropdown.selectByIndex(4); // Replace with the actual index of 'Purple'
        assertEquals("Purple", dropdown.getFirstSelectedOption().getText());
    }

    @Test
    public void testSelectByVisibleText() {
        dropdown.selectByVisibleText("Magenta");
        assertEquals("Magenta", dropdown.getFirstSelectedOption().getText());
    }

    @Test
    public void testSelectByValue() {
        // Assuming 'OptionValue' corresponds to the value attribute of the option you want to select
        dropdown.selectByValue("OptionValue");
        assertEquals("ExpectedOptionText", dropdown.getFirstSelectedOption().getText()); // Replace with the expected text
    }

    @Test
    public void testPrintAllOptions() {
        System.out.println("All options in the dropdown:");
        for (WebElement option : dropdown.getOptions()) {
            System.out.println(option.getText());
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


 */