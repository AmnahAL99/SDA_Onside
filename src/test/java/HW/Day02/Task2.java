package HW.Day02;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task2 {
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
        System.out.println("testCase02() is running");
        //it will be created in beforeTest() method ..

        // Go to www.yahoo.com
        driver.navigate().to("https://de.yahoo.com/?p=us");
        // Maximize Window
        driver.manage().window().maximize();
        String yahooTitle= driver.getTitle();
        System.out.println("yahooTitle = " + yahooTitle);
        boolean Test1= yahooTitle.contains("Yahoo");
        if (Test1){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }
        // Go to www.amazon.com
        Thread.sleep(1000);
        String amazonUrl= "https://www.amazon.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.navigate().to(amazonUrl);

        String amazonTitle= driver.getTitle();
        System.out.println("amazonTitle.toString() = " + amazonTitle);
        boolean Test2= amazonTitle.contains("Amazon");
        if (Test2){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }
        // Maximize Window
        driver.manage().window().maximize();
        // Navigate Back
        //Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.navigate().back();
        String yahooTitle2= driver.getTitle();
        boolean Test3= yahooTitle2.contains("Yahoo");
        if (Test3){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }
        // Navigate Forward
        //Thread.sleep(1000); or
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.navigate().forward();
        String amazonTitle2= driver.getTitle();
        boolean Test4= amazonTitle2.contains("Amazon");
        if (Test4){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }
        // Refresh The Page
        // Thread.sleep(1000);or
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.navigate().refresh();

    }

}
