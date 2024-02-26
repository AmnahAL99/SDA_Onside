package websites_practive;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearchTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        // Initialize the driver. Ensure the 'webdriver.chrome.driver' system property is correctly set.
        driver = new EdgeDriver();
    }

    @AfterClass
    public static void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void searchAndPrintResults() {
        searchGoogle("Green Mile");
        searchGoogle("Premonition");
        searchGoogle("The Curious Case of Benjamin Button");
    }

    private void searchGoogle(String query) {
        // Navigate to Google
        driver.get("https://www.google.com");

        // Find the search box, clear it, enter the search term, and submit
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys(query);
        searchBox.submit();

        // Adjusted wait condition: Wait for the presence of search results container
       // new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#search")));

        // Attempt to extract and print the number of results
        // This step may need adjustment based on the actual results page structure
        try {
            WebElement resultsStats = driver.findElement(By.id("result-stats"));
            String resultsText = resultsStats.getText();
            System.out.println("Search Results for \"" + query + "\": " + resultsText);
        } catch (Exception e) {
            System.out.println("Could not find the results count for \"" + query + "\". Please check the page structure.");
        }
    }
}
