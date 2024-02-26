package Day04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectMenuTest {
    WebDriver driver;

    @Before
    public void setup() {
        // Setting up Edge WebDriver

        EdgeOptions  options = new EdgeOptions();
       // ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSelectMenu() {
        // Navigate to the URL
        driver.get("https://demoqa.com/select-menu");

        // Locate the multiple select dropdown
        WebElement multiSelectDropdown = driver.findElement(By.id("cars"));

        // Create a Select object for the dropdown
        Select select = new Select(multiSelectDropdown);

        // Selecting multiple options from the dropdown
        select.selectByVisibleText("Volvo");
        select.selectByVisibleText("Audi");
        select.selectByVisibleText("Opel");

        // Retrieve all selected options and print them
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        for (WebElement option : selectedOptions) {
            System.out.println("Selected option: " + option.getText());
        }
    }

    @After
    public void tearDown() {
        // Closing the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }
}
//1how to creat test case
//2how to write test case