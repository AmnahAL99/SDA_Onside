package Day05;

/*
Go to https://the-internet.herokuapp.com/checkboxes
Locate the elements of checkboxes.
Then click on checkbox 1 if box is not selected.
Then click on checkbox 2 if box is not selected.
Then verify that checkbox 1 is checked.
 */
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.util.List;
public class C02Checkboxes {
    /*

Go to https://the-internet.herokuapp.com/checkboxes
Locate the elements of checkboxes.
Then click on checkbox 1 if box is not selected.
Then click on checkbox 2 if box is not selected.
Then verify that checkbox 1 is checked.
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        driver = new EdgeDriver(options);
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @AfterClass
    public static void tearDown(){
        // driver.quit();
    }

    @Test
    public void checkboxTest(){
        List<WebElement>  checkboxes = driver.findElements(By.xpath("//*[@type='checkbox']"));
        if(!checkboxes.get(0).isSelected()){
            checkboxes.get(0).click();
            System.out.println("check box 1 is selected...");
        } else {
            System.out.println("check box 1 is already selected...");

        }
        //
        if(!checkboxes.get(1).isSelected()){
            checkboxes.get(1).click();
            System.out.println("check box 2 is selected...");
        } else {
            System.out.println("check box 2 is already selected...");

        }
        Assert.assertTrue(checkboxes.get(0).isSelected());
        Assert.assertTrue(checkboxes.get(1).isSelected());

    }

}
