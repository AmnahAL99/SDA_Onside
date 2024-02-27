package Day05;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;
import java.util.List;

public class C04RadioButtons {


    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        EdgeOptions option = new EdgeOptions();
        option.addArguments("disable-popup-blocking");
        driver = new EdgeDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        // driver.quit();
    }

    @Test
    public void test() {
        // Go to URL: https://demoqa.com/
        driver.get("https://www.facebook.com/");
        // id dy create account
        //Click on Create an Account button.
        driver.findElement(By.xpath("//*[starts-with(@id,'u_0_0_')]")).click();
        //Then click on the radio buttons.
     //   List<WebElement> radButtons=driver.findElements(By.xpath("//*[@class='_5k_2 _5dba']"));
        List<WebElement> radioButtons= driver.findElements(By.name("sex"));
       // radButtons.get(0).click();
      //  Assert.assertTrue(radButtons.get(0);

        for (WebElement button : radioButtons) {
            button.click();
            Assert.assertTrue(button.isSelected());
        }
    }
}