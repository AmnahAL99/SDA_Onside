package websites_practive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;

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
}

