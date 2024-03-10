package HW.Day02;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task8 {
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
        System.out.println("testCase08() is running");
        // Go to google homepage
        String googleUrl = "https://google.com";
        driver.get(googleUrl);
        driver.manage().window().maximize();
        String pageTitleMax = driver.getTitle();
        driver.manage().window().minimize();
        String pageTitleMin= driver.getTitle();
        if(pageTitleMax.equals(pageTitleMin)){
            System.out.println("Title is the same when the page window is maximize and minimize");
        }else {
            System.out.println("Title is not the same when the page window is maximize and minimize");
        }

        // Test if the title does not contain "Video" when the page window is fullscreen
        driver.manage().window().fullscreen();
        String pageTitle = driver.getTitle();
        if (pageTitle.contains("Video")){
            System.out.println("Title does contains \"Video\" word");
        }else {
            System.out.println("Title doesn't contains \"Video\" word");
        }
        // Test if the URL contains "google"
        String pageUrl = driver.getCurrentUrl();
        if (pageUrl.contains("google")){
            System.out.println("the URL contains \"google\"");
        }else {
            System.out.println("the URL doesn't contains \"google\"");
        }


    }
}
