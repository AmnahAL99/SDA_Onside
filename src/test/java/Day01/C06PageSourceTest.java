package Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C06PageSourceTest {
    public static void main(String[] args) {

       // WebDriverManager.FirefoxDriver.setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.youtube.com");
        String expectedTitle = "video";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Page title contains 'video'.");
        } else {
            System.out.println("Page title does not contain 'video'.");
        }

        driver.quit();
    }
}
