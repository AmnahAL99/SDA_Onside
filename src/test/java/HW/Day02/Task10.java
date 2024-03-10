package HW.Day02;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task10 {
    WebDriver driver;

    @BeforeClass
    public static void beforeClassTest() {
        System.out.println("beforeClassTest() is running");
        System.out.println("Test started");
    }

    @AfterClass
    public static void afterClassTest() {
        System.out.println("afterClassTest() is running");
        System.out.println("Test done");
    }

    @Before
    public void beforeTest() {
        System.out.println("beforeTest() is running");
        driver = new ChromeDriver();
        System.out.println("Before test create new Chrome driver");
        System.out.println("Test is running");
        System.out.println("Tests are starting to run");
        System.out.println("STARTED");

    }

    @After
    public void afterTest() {
        System.out.println("afterTest() is running");
        driver.quit();
        System.out.println("After test close driver");
        System.out.println("Test finished");
        System.out.println("Tests have finished running");
        System.out.println("FINISHED");
    }
    @Test
    public void test(){
        System.out.println("testCase10() is running");

        // Go to Automation Exercises homepage
        String automationExercisesUrl="https://automationexercise.com/";
        driver.get(automationExercisesUrl);

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]"));
        // " Products "
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // " Cart "
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]"));
        //  " Signup / Login "

        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]"));
        // " Test Cases "

        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]"));
        //  API Testing

        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[6]"));
        //  " Video Tutorials "

        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[7]/a"));
        // " Contact us "

        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a"));

        //Extra
        driver.findElement(By.partialLinkText("Video Tutorials")).click();
        List<WebElement> webElement=driver.findElements(By.tagName("head"));
        System.out.println("webElement.size() = " + webElement.size());


    }
}
