package Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Point;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Dimension;
import java.time.Duration;

public class C05WindowsCommands02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");

        // 🡪 Print the position and size of the page.
        System.out.println(driver.manage().window().getPosition().toString());
        System.out.println(driver.manage().window().getSize().toString());

        // 🡪 Adjust the position and size of the page as desired.
        Point newPosition = new Point(-1600,150);
        Dimension newSize = new Dimension(1500,800);

        driver.manage().window().setSize(newSize);
        driver.manage().window().setPosition(newPosition);
        // 🡪 Test that the page is in the position and size you want.
       // if (expecturl.equle(aculeurl)){



        driver.quit();
    }
}
