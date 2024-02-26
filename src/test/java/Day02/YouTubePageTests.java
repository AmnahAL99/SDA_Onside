package Day02;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.Arrays;

public class YouTubePageTests {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new FirefoxDriver();
    }

    @Test
    public void testPageTitleContainsVideo_MaximizedWindow() {
        // Opening YouTube homepage
        driver.get("https://www.youtube.com/");
        // Maximizing the window
        driver.manage().window().maximize();
        // Verifying the page title contains "video" (different approach)
        assert pageTitleContainsWord("video", driver.getTitle()) : "Page title does not contain 'video' when window is maximized";
    }

    @Test
    public void testPageTitleContainsVideo_MinimizedWindow() {
        // Minimizing the window
        driver.manage().window().setPosition(new Point(-2000, 0));
        // Verifying the page title contains "video" (different approach)
        assert pageTitleContainsWord("video", driver.getTitle()) : "Page title does not contain 'video' when window is minimized";
    }

    @Test
    public void testPageTitleContainsVideo_FullscreenWindow() {
        // Making the window fullscreen
        driver.manage().window().fullscreen();
        // Verifying the page title contains "video" (different approach)
        assert pageTitleContainsWord("video", driver.getTitle()) : "Page title does not contain 'video' when window is in fullscreen";
    }

    @AfterClass
    public void tearDown() {
        // Closing the driver
        if (driver != null) {
            driver.quit();
        }
    }

    private boolean pageTitleContainsWord(String word, String pageTitle) {
        // Split the page title into individual words
        String[] words = pageTitle.split("\\s+");
        // Check if the word is contained in the array of words
        return Arrays.asList(words).contains(word);
        /*
          In this approach, the pageTitleContainsWord method splits the page
          title into individual words using the split("\\s+") method,
          which splits the string based on whitespace characters. Then,
          it checks if the word "video" is contained in the array of words
          obtained from the page title. This achieves the same result as the regular
          expression approach. Make sure to replace "path_to_geckodriver" with the actual
          path to your GeckoDriver executable.
         */
    }
}


