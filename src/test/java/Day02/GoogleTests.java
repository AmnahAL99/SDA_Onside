package Day02;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class GoogleTests {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Setting up EdgeDriver
        driver = new EdgeDriver();

    }

    @BeforeMethod
    public void printTestStart() {
        // Printing test start message
        System.out.println("Tests are starting to run");
    }

    @Test
    public void testTitleMaximizeMinimize() {
        // Opening Google homepage
        driver.get("https://www.google.com/");
        // Getting title when window is maximized
        String titleMaximize = getTitle();
        // Switching to fullscreen window
        driver.manage().window().fullscreen();
        // Getting title when window is in fullscreen
        String titleFullscreen = getTitle();
        // Maximizing the window again
        driver.manage().window().maximize();
        // Verifying titles are the same
        assert titleMaximize.equals(titleFullscreen) : "Titles are not the same when window is maximized and fullscreen";
    }

    @Test
    public void testTitleDoesNotContainVideo_FullscreenWindow() {
        // Opening Google homepage
        driver.get("https://www.google.com/");
        // Switching to fullscreen window
        driver.manage().window().fullscreen();
        // Getting title
        String title = getTitle();
        // Verifying title does not contain "Video"
        assert !title.contains("Video") : "Title contains 'Video' when it should not";
    }

    @Test
    public void testUrlContainsGoogle() {
        // Opening Google homepage
        driver.get("https://www.google.com/");
        // Getting current URL
        String url = driver.getCurrentUrl();
        // Verifying URL contains "google"
        assert url.contains("google") : "URL does not contain 'google'";
    }

    @AfterMethod
    public void printTestFinish() {
        // Printing test finish message
        System.out.println("Tests have finished running");
    }

    @AfterClass
    public void tearDown() {
        // Quitting the driver
        if (driver != null) {
            driver.quit();
        }
    }

    private String getTitle() {
        // Returning the title of the page
        return driver.getTitle();
    }


    /*

            String expectedTitle = "Wikipedia, the free encyclopedia";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Page title contains 'Wikipedia, the free encyclopedia'.");
        } else {
            System.out.println("Page title does not contain 'Wikipedia, the free encyclopedia'.");
        }
     */
}
