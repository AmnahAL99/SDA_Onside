package Personal_training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GetOptionTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new EdgeDriver();
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void testDropdownOptions() {
        WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(dropdown);

        List<WebElement> options = select.getOptions();
        System.out.println("Number of options in the dropdown: " + options.size());

        System.out.println("Options in the dropdown:");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        // Verify if the dropdown has the option "black"
        boolean blackOptionPresent = false;
        for (WebElement option : options) {
            if (option.getText().equals("Black")) {
                blackOptionPresent = true;
                break;
            }
        }
        System.out.println("Dropdown has option 'Black': " + blackOptionPresent);
    }

    @Test
    public void testSelectYellowOption() {
        WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Yellow");

        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println("First selected option: " + firstSelectedOption.getText());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

