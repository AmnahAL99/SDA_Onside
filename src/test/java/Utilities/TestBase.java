package Utilities;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public abstract class TestBase {

  protected static WebDriver driver;


    @BeforeClass
    public static void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

/*
    @AfterClass
    public static void teardown(){
        driver.quit();
    }


 */
}
