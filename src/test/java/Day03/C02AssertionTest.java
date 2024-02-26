package Day03;


import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

    public class C02AssertionTest {
        private static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        driver = new EdgeDriver();
        driver.get("(\"https://www.google.com/\");");}



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

        private String getTitle() {
            // Returning the title of the page
            return driver.getTitle();
        }
    }








        /*
    Go to Google homepage
    Do the following tasks by creating 3 different test methods.
    1- Test if the URL contains google.
    2- Test if the title does not contain Facebook.
    3- Test that the Google logo appears on the page.
     */