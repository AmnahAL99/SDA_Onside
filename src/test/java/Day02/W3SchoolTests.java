package Day02;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
public class W3SchoolTests {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new EdgeDriver();
        System.out.println("Test has started");
    }

    @BeforeMethod
    public void printStarted() {
        // Indicating the start of each test method
        System.out.println("STARTED");
    }

    @Test
    public void testTitleContainsW3School_MinimizedWindow() {
        // Minimizing the browser window
        //System.out.println("testTitleContainsW3School_MinimizedWindow running");
        driver.get("https://google.com/");
        driver.findElement(By.id("APjFqb")).sendKeys("Green Mile");

        driver.manage().window().setPosition(new Point(-2000, 0)); // Off-screen position
     //   String title = driver.getTitle();
       // assert title.contains("w3school") : "Title does not contain 'w3school'";
    }

    @Test
    public void testTitleDoesNotContainBoss_FullscreenWindow() throws InterruptedException {
        // Maximizing the browser window
        //  System.out.println("testTitleDoesNotContainBoss_FullscreenWindow running");
      /*  driver.get("https://id.heroku.com/login");
        driver.findElement(By.id("email")).sendKeys("Amnah@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.className("btn btn-primary btn-lg btn-block")).click();
        driver.manage().window().fullscreen();

       */

        // String title = driver.getTitle();
        // assert !title.contains("boss") : "Title contains 'boss' when it should not";

        driver.get("https://testpages.eviltester.com/styled/index.html");
        driver.findElement(By.id("calculatetest")).click();
        driver.findElement(By.id("number1")).sendKeys("3");
        driver.findElement(By.id("number2")).sendKeys("3");
        driver.findElement(By.id("calculate")).click();
        Thread.sleep(Long.parseLong("3000"));
        driver.findElement(By.id("answer")).isDisplayed();

    }





    @AfterMethod
    public void printFinished() {
        // Indicating the end of each test method
        System.out.println("FINISHED");
    }

    @AfterClass
    public void tearDown() {
        // Cleaning up after all tests are finished
        if (driver != null) {
            driver.quit();
            System.out.println("Test finished");
        }
    }
}

