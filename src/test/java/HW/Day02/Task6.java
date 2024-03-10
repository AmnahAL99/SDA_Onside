package HW.Day02;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task6 {
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
        System.out.println("testCase06() is running");
        // Invoke FireFox Driver
        //it will be created in beforeTest() method ..
        // Go to https://www.youtube.com/
        String youtubeUrl="https://www.youtube.com/";
        driver.get(youtubeUrl);
        // Maximize the window
        driver.manage().window().maximize();
        // Verify the page title contains the word video.
        String youtubePageTitle = driver.getTitle();
        System.out.println("youtubePageTitle = " + youtubePageTitle);
        if(youtubePageTitle.contains("video")){
            System.out.println("Title page contains \"video\"");
        }else {
            System.out.println("Title page doesn't contains \"video\"");
        }
        // Minimize the window
        driver.manage().window().minimize();
        // Verify the page title contains the word video.
        String youtubePageTitle1 = driver.getTitle();
        if(youtubePageTitle1.contains("video")){
            System.out.println("Title page contains \"video\"");
        }else {
            System.out.println("Title page doesn't contains \"video\"");
        }
        // Make the page fullscreen
        driver.manage().window().fullscreen();
        // Close the driver.
        // Closed by afterTest() method ..

    }
}
