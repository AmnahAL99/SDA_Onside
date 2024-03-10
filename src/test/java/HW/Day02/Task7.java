package HW.Day02;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task7 {
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
        System.out.println("testCase07() is running");
        // Go to YouTube homepage
        String youtubeUrl="https://www.youtube.com/";
        driver.get(youtubeUrl);
        // Do the following tasks by creating 4 different test methods.
        //*- Print "Test is running" before each test() method
        //beforeTest();
        //*- Print "Test finished" after each test() method
        //afterTest();
        // Test if the currentURL contains "youtube"
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("youtube")){
            System.out.println("currentURL contains \"youtube\"");
        }else{
            System.out.println("currentURL doesn't contains \"youtube\"");
        }
        // Test if the title does not contain "Video".
        String currentTitle = driver.getTitle();
        if(currentTitle.contains("Video")){
            System.out.println("current Title contains \"Video\"");
        }else{
            System.out.println("current Title doesn't contains \"Video\"");
        }
        // Test if the URL contains "youtube".
        if(youtubeUrl.contains("youtube")) {
            System.out.println("youtube Url contains \"youtube\"");
        }else{
            System.out.println("youtube Url doesn't contains \"youtube\"");
        }
        // Test if the sourcePage contains "youtube".
        String youtubeSourcePage=driver.getPageSource();
        if(youtubeSourcePage.contains("youtube")) {
            System.out.println("youtube SourcePage contains \"youtube\"");
        }else{
            System.out.println("youtube Source Page doesn't contains \"youtube\"");
        }



    }
}
