package websites_practive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class FileUploadTest {

    private WebDriver driver;
    private static final String FILE_PATH = "\"C:\\Users\\mr-sh\\Desktop\\AmnahAL99.docx\""; // Update with the actual file path

    @Before
    public void setUp() {

        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testFileUpload() {
        // Open the web application
        driver.get("https://the-internet.herokuapp.com/upload");

        // Find the file input element and locate the file to upload
        WebElement fileInput = driver.findElement(By.id("file-upload"));
        File file = new File(FILE_PATH);

        // Enter the file path in the file input element
        fileInput.sendKeys(file.getAbsolutePath());

        // Click on the Upload button
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        // Wait for the upload to complete (you may need to add a wait here)
    }

    @After
    public void tearDown() {
        // Close WebDriver
        driver.quit();
    }

    public static class Dropdown {

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
            dropdown.selectByIndex(4);

            // Select 'Magenta' by visible text
            dropdown.selectByVisibleText("Magenta");

            // Select an option by value (replace "value" with the actual value attribute of the option you want to select)
            //dropdown.selectByValue("red");

        }
      /*


        @After
        public void tearDown() {
            // Close the browser
            driver.quit();
        }

       */
    }
}

