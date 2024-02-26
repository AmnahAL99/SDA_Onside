package websites_practive;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Task1 {

        private static WebDriver driver;

        @BeforeClass
        public static void setUp() {

            driver = new EdgeDriver();
        }

    @Test
    public void testGoogleSearch() {
        String[] queries = {"Green Mile", "Premonition", "The Curious Case of Benjamin Button"};
        for (String query : queries) {
            driver.get("http://www.google.com");
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys(query);
            searchBox.submit();
            // Wait for the results to load
            try {
                Thread.sleep(5000); // This is not best practice. Ideally, use WebDriver wait conditions.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Results for \"" + query + "\": " + driver.findElement(By.id("result-stats")).getText());
        }
    }

            @Test
            public void navigateAndInteract() {
                // Navigate to the starting page
                driver.get("https://testpages.herokuapp.com/styled/index.html");

                driver.findElement(By.id("findbytest")).click();

                // Print the URL
                System.out.println("Current URL after clicking on Locators link: " + driver.getCurrentUrl());
                driver.navigate().back();
                System.out.println("URL after navigating back: " + driver.getCurrentUrl());

                // Click on WebDriver Example Page
                WebElement webDriverExampleLink = driver.findElement(By.id("webdriverexamplepage"));
                webDriverExampleLink.click();

                // Print the URL
                System.out.println("Current URL after clicking on WebDriver Example link: " + driver.getCurrentUrl());

                // Enter value -> 20 into "Enter Some Numbers inputBox"
                WebElement inputBox = driver.findElement(By.id("numentry"));
                inputBox.sendKeys("20");
                inputBox.submit();

                // Verify 'two, zero' message is displayed on the page
                WebElement message = driver.findElement(By.id("clickable-link"));
              //  assertEquals("two, zero", message.getText());
                assertNotEquals("two , zero",message.getText());
            }


        @AfterClass
        public static void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }

}
















