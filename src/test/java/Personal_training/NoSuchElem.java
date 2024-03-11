package Personal_training;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoSuchElem extends TestBase {
    @Test
    public void test() {
        driver.get("");
        driver.findElement(By.id("")).click();
    }

    @Test
    public void test2() {
        driver.get("");
        driver.switchTo().frame(0);
        String text = driver.findElement(By.id("")).getText();

    }

    @Test
    public void test3() {

    }

    @Test
    public void testElementPresenceWithTimeout() {
        try {
           // WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout
           // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("someElementId")));

            // Element is found and visible, proceed with further actions
        } catch (TimeoutException e) {
            // Handle timeout exception, e.g., log an error or take alternative actions
            System.out.println("Element not found within the specified timeout.");

            // For JUnit, assert a fail condition or perform other logic as needed
            Assert.fail("TimeoutException: Element not found within the specified timeout.");
        }
    }




}
