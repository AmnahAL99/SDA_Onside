package HW.Day02;

import org.junit.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task5 {
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
    public void test() throws InterruptedException {
        System.out.println("testCase05() is running");
        // Invoke Chrome Browser
        //it will be created in beforeTest() method ..

        // Open URL: https: https://www.w3schools.com/
        String w3schoolUrl="https://www.w3schools.com/";
        driver.get(w3schoolUrl);
        // Maximize the window.
        driver.manage().window().maximize();
        // Print the position and size of the page.
        Point positionOfThePage =driver.manage().window().getPosition();
        Dimension sizeOfThePage =driver.manage().window().getSize();
        System.out.println("sizeOfThePage = " + sizeOfThePage);
        System.out.println("positionOfThePage = " + positionOfThePage);
        // Minimize the page.
        driver.manage().window().minimize();
        // Wait 7 seconds in the icon state and maximize the page.
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        Thread.sleep(7000);
        driver.manage().window().maximize();
        // Print the position and dimensions of the page in maximized state.
        Point positionOfThePage1 =driver.manage().window().getPosition();
        Dimension sizeOfThePage1 =driver.manage().window().getSize();
        System.out.println("sizeOfThePage = " + sizeOfThePage1);
        System.out.println("positionOfThePage = " + positionOfThePage1);
        // Make the page fullscreen.
        driver.manage().window().fullscreen();
        // Close the Browser.



    }
}
