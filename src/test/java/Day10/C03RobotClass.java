package Day10;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class C03RobotClass extends TestBase {


    @Test
    public void test1() throws AWTException {
        driver.get("https://www.ebay.com/");
        Robot  robot = new Robot();
        WebElement box = driver.findElement(By.id("gh-ac"));
        box.click();
        robot.mouseWheel(4);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        robot.mouseWheel(-6);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_F4);

    }
    @Test
    public void test() throws AWTException, InterruptedException {

        driver.get("https://www.ebay.com");

        Robot robot = new Robot();
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.click();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_A);

        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.mouseWheel(30);
    }

}
