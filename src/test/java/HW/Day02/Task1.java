package HW.Day02;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1 {
    WebDriver driver;

    @BeforeClass
    public static void beforeClassTest() {
        System.out.println("beforeClassTest() is running");
        System.out.println("Test has started");
    }

    @AfterClass
    public static void afterClassTest() {
        System.out.println("afterClassTest() is running");
        System.out.println("Test finished");
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
    public void test() {
        System.out.println("testCase01() is running");
        // Invoke Chrome Browser
        //it will be created in beforeTest() method ..

        // Navigate to URL: https://www.w3schools.com/
        driver.get("https://www.w3schools.com/");
        System.out.println("driver.getTitle().toString() = " + driver.getTitle());
        // Navigate to URL: https://stackoverflow.com/
        driver.navigate().to("https://stackoverflow.com/");
        System.out.println("driver.getTitle().toString() = " + driver.getTitle());
        // Come back to the w3schools using the back command.
        driver.navigate().back();
        System.out.println("driver.getTitle().toString() = " + driver.getTitle());
        // Again go back to the stackoverflow website using forward command
        driver.navigate().forward();
        System.out.println("driver.getTitle().toString() = " + driver.getTitle());
        // Refresh the Browser using refresh command.
        //wait 2 Second before refresh the page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //refresh the page
        driver.navigate().refresh();
        System.out.println("driver.getTitle().toString() = " + driver.getTitle());
        // Close the Browser.
        // Closed by afterTest() method ..


    }
}
