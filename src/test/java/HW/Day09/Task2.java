package HW.Day09;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Task2 extends TestBase {

    @Test
    public void test2(){
        By slider = By.cssSelector("div[id='js-rangeslider-0'] div[class='rangeslider__handle']");
        driver.get("https://rangeslider.js.org");
        WebElement sliderButton = driver.findElement(slider);
        actions
                .dragAndDropBy(sliderButton,300,0)
                .pause(Duration.ofSeconds(2))
                .dragAndDropBy(sliderButton,-300,0)
                .build()
                .perform();
    }

}
