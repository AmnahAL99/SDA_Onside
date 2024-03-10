package HW.Day02;

import org.junit.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {
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
    public void test(){
        System.out.println("testCase04() is running");
        // Go to the w3school URL : https://www.w3schools.com/
        driver.get("https://www.w3schools.com/");
        // Print the position and size of the page.
        Point positionOfThePage =driver.manage().window().getPosition();
        Dimension sizeOfThePage =driver.manage().window().getSize();
        System.out.println("sizeOfThePage = " + sizeOfThePage);
        System.out.println("positionOfThePage = " + positionOfThePage);


        // Adjust the position and size of the page as desired.
        driver.manage().window().setSize(new Dimension(1554,882));
        driver.manage().window().setPosition(new Point(8,8));

        // Test that the page is in the position and size you want.
        Point positionOfThePage1 =driver.manage().window().getPosition();
        Dimension sizeOfThePage1 =driver.manage().window().getSize();
        System.out.println("sizeOfThePage = " + sizeOfThePage1);
        System.out.println("positionOfThePage = " + positionOfThePage1);
        //
        // Close the page.
        // Closed by afterTest() method ..


    }
}
