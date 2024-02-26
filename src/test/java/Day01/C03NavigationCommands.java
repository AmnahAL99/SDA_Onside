package Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03NavigationCommands {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // BROWSER CONTROL COMMANDS
        // Opening Google website
        driver.get("https://google.com");
        // Opening Clarusway website
        driver.get("https://clarusway.com");

        // Opening Stack Overflow website


        // NAVIGATION COMMANDS

        // back() opens the previous page

        driver.navigate().back();
        // forward() opens the next page after going back
        driver.navigate().forward();

        // refresh() refreshes the page
       driver.navigate().refresh();

        // to() - performs the same function as the get() method


    }
}
