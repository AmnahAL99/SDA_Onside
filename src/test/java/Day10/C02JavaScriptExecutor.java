package Day10;

import Utilities.JScriptUtilities;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class C02JavaScriptExecutor  extends TestBase {

    @Test
    public void test(){
        By doubleClick = By.xpath("/html[1]/body[1]/div[1]");
       // By v =  By.id("//a[@href='/']");
       driver.get("https://api.jquery.com/dblclick/");
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        WebElement color = driver.findElement(By.cssSelector("input[placeholder='Search']"));
        js.executeScript("arguments[0].style.background='yellow'", color);
       // js.executeScript("document.body.style.backgroundColor = 'blue'");
        driver.switchTo().frame(0);
        WebElement doubleClickE = driver.findElement(doubleClick);
        actions
                .doubleClick(doubleClickE).perform();

//        driver.switchTo().parentFrame();
//        WebElement vClick = driver.findElement(v);
//        actions.click(vClick).perform();
//-------------------------------------------------

        Object title = js.executeScript("return document.title");
        System.out.println("title" + title);

        js.executeScript("window.scroll(0,document.body.scrollHeight)");


    }


    @Test
    public void test2(){

        driver.get("https://api.jquery.com/dblclick/");
        driver.switchTo().frame(0);
        WebElement colouredButton =driver.findElement(By.cssSelector("body>div"));

        JScriptUtilities.scrollIntoViewJS(driver,colouredButton);

        actions
                .doubleClick(colouredButton)
                .perform();

        String colorCode = colouredButton.getCssValue("background-color");

        driver.switchTo().defaultContent();

        JScriptUtilities.scrollAllUpByJS(driver);

        driver.findElement(By.name("s")).sendKeys(colorCode);

        JScriptUtilities.scrollDownByJS(driver);
        driver.findElement(By.xpath("//a[@href = 'https://www.manning.com/books/jquery-in-action-third-edition']")).click();

    }

    @Test
    public void MusicSearch (){

            try {
                driver.get("https://www.youtube.com");

                WebElement searchBox = driver.findElement(By.name("search_query"));
                searchBox.sendKeys("music");
                searchBox.submit();
                Thread.sleep(5000);
                // Click on the first video
                WebElement firstVideo = driver.findElement(By.id("video-title"));
                firstVideo.click();
                Thread.sleep(5000);
                WebElement videoTitle = driver.findElement(By.cssSelector("h1.title"));
                Assert.assertTrue("Video title is not displayed",videoTitle.isDisplayed());
                // Further actions or assertions can be added here
            } catch (Exception e) {
                e.printStackTrace();
            }
            }

}

