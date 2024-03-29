package Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02BrowserControlCommands {
    public static void main(String[] args) {

        /*
    Selenium automates browsers. That's it!
    What you do with that power is entirely up to you.
     */
   //If we want to open a website with a driver, we use the get() method of our driver object.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // BROWSER CONTROL COMMANDS
       driver.get("https://google.com");
        //getTitle() returns the title of the current tab. It returns a String.
     String title =  driver.getTitle();
        System.out.println("title = " + title);
        //getCurrentURL() returns the URL of the current tab. It returns a String.
      String url =  driver.getCurrentUrl();
        System.out.println("url = " + url);

        // getPageSource() retrieves the source HTML code of the current page. It returns a String.
      String pageSource = driver.getPageSource();
      System.out.println("pageSource = " + pageSource);
        // close() closes the current tab. If it's the only tab open, it also closes the browser.
          driver.close();

        // quit() closes all tabs and the browser.

        driver.quit();


    }


}
