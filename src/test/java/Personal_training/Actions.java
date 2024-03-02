package Personal_training;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Actions {

    WebDriver driver;

    @Before
    public void setUp() {
        // Set up WebDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test(){

    }
}
