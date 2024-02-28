package HW.Day01;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.time.Duration;

public class WikipediaTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigate to Wikipedia homepage
        driver.get("https://www.wikipedia.org");

        // Click on the English link

       driver.findElement(By.id("js-link-box-en")).click();
        // Verify that the page title contains "Wikipedia, the free encyclopedia"
        String expectedTitle = "Wikipedia, the free encyclopedia";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Page title contains 'Wikipedia, the free encyclopedia'.");
        } else {
            System.out.println("Page title does not contain 'Wikipedia, the free encyclopedia'.");
        }
       Thread.sleep(3000);
        // Navigate back to the previous page
        driver.navigate().back();

        // Verify that you are back on the original Wikipedia page
        String originalUrl = "https://www.wikipedia.org/";
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(originalUrl)) {
            System.out.println("Navigated back to the original Wikipedia page.");
        } else {
            System.out.println("Did not navigate back to the original Wikipedia page.");
        }
        Thread.sleep(3000);
        // Close the browser
       driver.quit();
     // ------------------------------------//
        driver.get("https://clarusway.com/");
        driver.findElement(By.id("sm-17085177859114053-1")).click();
        driver.findElement(By.className("elementor-sub-item")).click();


        //---------------------------------//

    }
}
