package Day02;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.junit.Test;

public class AutomationExerciseTests {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    @Test(description = "Task 01 - Navigate to Home")
    public void navigateToHome() {
        navigateTo("Home");
    }

    @Test(description = "Task 02 - Navigate to Products")
    public void navigateToProducts() {
        navigateTo("Products");
    }

    @Test(description = "Task 03 - Navigate to Cart")
    public void navigateToCart() {
        navigateTo("Cart");
    }

    @Test(description = "Task 04 - Navigate to Signup / Login")
    public void navigateToSignupLogin() {
        navigateTo("Signup / Login");
    }

    @Test(description = "Task 05 - Navigate to Test Cases")
    public void navigateToTestCases() {
        navigateTo("Test Cases");
    }

    @Test(description = "Task 06 - Navigate to API Testing")
    public void navigateToAPITesting() {
        navigateTo("API Testing");
    }

    @Test(description = "Task 07 - Navigate to Video Tutorials")
    public void navigateToVideoTutorials() {
        navigateTo("Video Tutorials");
    }

    @Test(description = "Task 08 - Navigate to Contact Us")
    public void navigateToContactUs() {
        navigateTo("Contact us");
    }

    private void navigateTo(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        link.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


