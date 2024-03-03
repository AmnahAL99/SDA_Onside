package HW.Day08;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class Task1 {

        private WebDriver driver;
        private String baseUrl;

        @Before
        public void setUp() throws Exception {
            driver = new EdgeDriver();
            // Maximize the browser's window
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            baseUrl = "http://demo.guru99.com/test/guru99home/";
        }

        @Test
        public void testIframes() throws Exception {
            driver.get(baseUrl);

            // Find all iframes on the page
            List<WebElement> iframes = driver.findElements(By.tagName("Iframe"));
            System.out.println("Number of iframes on the page: " + iframes.size());

            // Switch to the third iframe (index starts from 0) OR driver.switchTo().frame(3);

            driver.switchTo().frame(iframes.get(3));

            // Click the link inside the third iframe
            // the link text or another identifiable attribute to locate the link
            //driver.findElement(By.linkText("JMeter Made Easy")).click();

            List<WebElement> links = driver.findElements(By.tagName("a"));
            boolean linkClicked = false;
            for (WebElement link : links) {
                if (link.getAttribute("href").contains("live-selenium-project.html")) {
                    link.click();
                    linkClicked = true;
                    break;
                }
            }

            if (!linkClicked) {
                System.out.println("The specified link was not found in the iframe.");
            }

// if the link was successfully clicked, switch back to the main document
            driver.switchTo().defaultContent();


            // Switch back to the main (parent) page
            driver.switchTo().defaultContent();
        }

        @After
        public void tearDown() throws Exception {
            driver.quit();
        }

    }



