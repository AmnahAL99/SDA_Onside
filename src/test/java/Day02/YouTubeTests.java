package Day02;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class YouTubeTests {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new EdgeDriver();
    }

    @BeforeMethod
    public void printTestStart() {
        // Printing test start message
        System.out.println("Test is running");
    }

    @Test
    public void testCurrentURLContainsYouTube() {
        // Opening YouTube homepage
        driver.get("https://www.youtube.com/");
        // Getting current URL
        String url = driver.getCurrentUrl();
        // Verifying URL contains "youtube"
        assert url.contains("youtube") : "Current URL does not contain 'youtube'";
    }

    @Test
    public void testTitleDoesNotContainVideo() {
        // Opening YouTube homepage
        driver.get("https://www.youtube.com/");
        // Getting title
        String title = getTitle();
        // Verifying title does not contain "Video"
        assert !title.contains("Video") : "Title contains 'Video' when it should not";
    }

    @Test
    public void testURLContainsYouTube() {
        // Opening YouTube homepage
        driver.get("https://www.youtube.com/");
        // Getting current URL
        String url = driver.getCurrentUrl();
        // Verifying URL contains "youtube"
        assert url.contains("youtube") : "URL does not contain 'youtube'";
    }

    @Test
    public void testSourcePageContainsYouTube() {
        // Opening YouTube homepage
        driver.get("https://www.youtube.com/");
        // Getting page source
        String sourcePage = driver.getPageSource();
        // Verifying page source contains "youtube"
        assert sourcePage.contains("youtube") : "Page source does not contain 'youtube'";
    }

    @AfterMethod
    public void printTestFinish() {
        // Printing test finish message
        System.out.println("Test finished");
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
}

