package HW.Day05;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Task1 {
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;
    @Before
    public void setUp() {

        driver = new EdgeDriver();
        jsExecutor = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/radio-button");
    }

    @Test
    public void testRadioButtonsWithJS() {
        String[] radioButtonScripts = {
                "document.getElementById('yesRadio').click();",
                "document.getElementById('impressiveRadio').click();",
                // Assuming 'noRadio' is available for interaction in an actual test scenario
                "document.getElementById('noRadio').click();"
        };

        for (String script : radioButtonScripts) {
            jsExecutor.executeScript(script);
            // Add a sleep to see the effect on the UI, if necessary
            try {
                Thread.sleep(1000); // 1 second sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

