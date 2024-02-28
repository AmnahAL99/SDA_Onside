package HW.Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {

  public static void main(String[] args) {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.facebook.com/");
    String expectedUrl = "https://demo.nopcommerce.com/";
    //1 Print Title on page 2 Print Current URL on page
    String title =  driver.getTitle();
    System.out.println("title = " + title);
    String url =  driver.getPageSource();
    System.out.println("url = " + url);
  //Verify expected URL equals to the actual URL.
  // Verify pagesource of FaceBook contains "Facebook"
    String actualUrl = driver.getPageSource();
    if (expectedUrl.equals(actualUrl)){
        System.out.println("They are the same");
    } else {
        System.out.println("They are different");

    }
    // Close the browser
        driver.quit();
}}
/*
 Differences between get() method and navigate to() method?
 get() method: Opens a webpage at a given URL.
 navigate.to() method: Also opens a webpage at a given URL
 but provides additional navigation functionalities like going back,
 forward, or refreshing the page.

 */

