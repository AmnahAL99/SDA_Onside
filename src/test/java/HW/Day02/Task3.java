package HW.Day02;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
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
        System.out.println("testCase03() is running");
        // Expected Title
        String ExpectedTitle="Online IT Bootcamp; Learn Coding, " +
                "Data Science, AWS, DevOps, " +
                "Cyber Security & Salesforce";
        // Set Path of the Chrome driver

        String url="https://clarusway.com";
        // Launch Chrome browser
        //it will be created in beforeTest() method ..
        // Open URL of Website
        driver.get(url);
        // Maximize Window
        driver.manage().window().maximize();
        // Get Title of current Page
        String currentTitle=driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);
        // Validate/Compare Page Title
        if (currentTitle.equals(ExpectedTitle)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
        // Close Browser
        // Closed by afterTest() method ..



    }
}
