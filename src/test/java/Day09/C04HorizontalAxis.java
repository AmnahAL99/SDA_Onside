package Day09;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class C04HorizontalAxis extends TestBase {

    @Test
    public void sliderTest(){
        By slider = By.xpath("//div[@class='range-slider vertical-range']/span[1]");

        driver.get("https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html");
        WebElement sliderButton = driver.findElement(slider);
        actions
                .dragAndDropBy(sliderButton,0,-32)
                .pause(Duration.ofSeconds(2))
                .dragAndDropBy(sliderButton,0,32)
                .build()
                .perform();
    }

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



