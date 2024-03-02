package Personal_training;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C16_WondowHandle {


    WebDriver driver;

    @Before
    public void setUp() {
        // Set up WebDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        String w1 = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);

       // driver.get("https://www.linkedin.com/");
        String w2 = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        String w3 = driver.getWindowHandle();
        driver.switchTo().window(w2).get("https://www.linkedin.com/");

        driver.switchTo().window(w3).get("https://clarusway.getlearnworlds.com/");

        driver.switchTo().window(w1).get("https://www.google.com/");

    }

    @Test
    public void test2() {
        //  Try without WindowHandle
        driver.get("https://www.google.com/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com/");
        String currentWH = driver.getWindowHandle();
        Set<String> WindowHandle = driver.getWindowHandles();
        //1.Way
        for (String w : WindowHandle) {
            if (!w.equals(currentWH)) {
                driver.switchTo().window(w);

            }
        }
    }
    @Test
    public void test3(){
        //  Try without WindowHandle
        driver.get("https://www.google.com/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com/");
        String currentWH = driver.getWindowHandle();
        Set<String> WindowHandle = driver.getWindowHandles();
        System.out.printf(driver.getTitle());
       //2.Way
        List<String> strWH = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(strWH.get(0));
        System.out.printf(driver.getTitle());

    }



}
