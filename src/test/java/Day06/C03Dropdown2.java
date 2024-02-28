package Day06;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03Dropdown2 {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }

    @AfterClass
    public static void tearDown(){
        //  driver.quit();
    }

    @Test
    public void dropdownTest(){
        // locate WebElement with select tag
        WebElement element = driver.findElement(By.id("oldSelectMenu"));

        // Create select object by passing select element into constructor
        Select select = new Select(element);

        // Select by index:
        select.selectByIndex(3); // index 3 = 4th elemnt ---> yellow

        // Select by value ---> we sholud inspect and see the value on POM then can select
        select.selectByValue("4");

        // Select by visible text
        select.selectByVisibleText("Purple");

        // isMultiple() method returns true if we can select multiple options return false otherwise.
        System.out.println("select.isMultiple() = " + select.isMultiple());
        WebElement elemnt2 = driver.findElement(By.id("cars"));  // false --> cannot select multiple options
        Select select2 = new Select(elemnt2);
        System.out.println("select2.isMultiple() = " + select2.isMultiple());  // true --> can select multiple options
    }













}