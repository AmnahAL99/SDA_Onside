package HW.Day02;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task9 {
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
        System.out.println("testCase09() is running");
        // Go to w3school homepage
        String w3schoolUrl="https://www.w3schools.com/";
        driver.get(w3schoolUrl);

        // Test if the title contains "w3school" when the page window is minimize
        driver.manage().window().minimize();
        String w3schoolTitle= driver.getTitle();
        //I used toLowerCase() to simplify the comparison
        if (w3schoolTitle.toLowerCase().contains("w3school")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
        // Test if the title does not contain "boss" when the page window is fullscreen
        driver.manage().window().fullscreen();
        String w3schoolTitle1= driver.getTitle();
        if (!(w3schoolTitle1.toLowerCase().contains("boss"))){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }


    }
}
