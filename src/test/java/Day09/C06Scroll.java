package Day09;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class C06Scroll extends TestBase {

    @Test
    public void scrollPageUpDown() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://www.linkedin.com/");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    @Test
    public void scrollArrowUpDown() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://demoqa.com/auto-complete");

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();

    }

}
