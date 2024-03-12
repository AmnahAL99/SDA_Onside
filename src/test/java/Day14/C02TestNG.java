package Day14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class C02TestNG {
    private WebDriver driver;
    //Create beforeClass and set up settings.
    //By creating interdependent tests;
    @BeforeClass
    public void setUp() {

        // Initialize the ChromeDriver
        driver = new ChromeDriver();
    }
    //First go to Facebook.
    @Test
    public void openFacebook() {
        // Go to Facebook
        driver.get("https://www.facebook.com");
    }
    //Then go to Google depending on Facebook,Create tests that depend on each other
    @Test(dependsOnMethods = {"openFacebook"})
    public void openGoogle() {
        // Go to Google
        driver.get("https://www.google.com");
    }
    //Then go to Amazon depending on Google
    @Test(dependsOnMethods = {"openGoogle"})
    public void openAmazon() {
        // Go to Amazon
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    //Close the driver.
    public void tearDown() {
        // Close the WebDriver
        driver.quit();
    }
}
