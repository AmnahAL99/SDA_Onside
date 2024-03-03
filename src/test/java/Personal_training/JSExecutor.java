package Personal_training;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class JSExecutor {




    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new EdgeDriver();
        driver.get("https://clarusway.com/");
    }


    @Test
    public void test(){

      JavascriptExecutor js =  (JavascriptExecutor) driver;
      js.executeScript("document.body.style.backgroundColor = 'blue'");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

     Object title = js.executeScript("return document.title");
        System.out.println("title" + title);

     js.executeScript("window.scroll(0,document.body.scrollHeight)");


    }

    @Test
    public void test2() throws AWTException {
     Robot  robot = new Robot();
      robot.mouseWheel(4);

      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        robot.mouseWheel(-6);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_F4);
    }



}
