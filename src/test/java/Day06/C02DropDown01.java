package Day06;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class C02DropDown01 {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to the chromedriver executable


        // Initialize a ChromeDriver instance
        driver = new EdgeDriver();

        // Open the specified URL
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();

    }

    @Test
    public void testSelectDropdown() {
        WebElement element = driver.findElement(By.xpath("//*[text()='Select Option']"));
      //  Select select = new Select(element);
        element.click();
      //  select.selectByIndex(1);




    }
}
// Dropdown: a drop-down menu
// Since dropdowns require special interactions, Selenium has created a separate class for dropdowns.
// Class -> Select

/* When working with dropdowns:
   * Locate the <select> element: //select[@id='oldSelectMenu']
   * Create a Select object using the select element:
       Select select = new Select(webElement)
   * Use methods through the select object:
       1- selectByIndex(): index of the option element
       2- selectByValue(): value attribute of the option element
       3- selectByVisibleText(): visible text of the option element

// Methods used for informational purposes in Select elements:
   select.getAllSelectedOptions(); -> Returns all selected values in a multi-select dropdown.
   select.getFirstSelectedOption(); -> Returns the first selected option.
   select.getOptions(); -> Returns all options of the select element in a list.
   select.isMultiple(); -> Returns a boolean indicating whether the select element allows multiple selections.

// Deselection methods:
   1- deselectByIndex() -> Deselects an option by its index.
   2- deselectByValue() -> Deselects an option by its value attribute.
   3- deselectByVisibleText() -> Deselects an option by its visible text (content).
   4- deselectAll() -> Deselects all options.
*/