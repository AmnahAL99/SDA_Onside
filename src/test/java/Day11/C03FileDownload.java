package Day11;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static junit.framework.TestCase.assertTrue;

public class C03FileDownload extends TestBase {

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("selenium-snapshot.png")).click();
        String s =    System.getProperty("user.home")+ "/Download/selenium-snapshot.png";
        boolean isExist =  Files.exists(Path.of(System.getProperty("user.home") + "/Download/selenium-snapshot.png"));
        assertTrue(Boolean.parseBoolean(s));
       // assertTrue(isExist);
    }

//   / /    Go to URL: https://the-internet.herokuapp.com/download
////    Download selenium-snapshot.png
////    Verify if the file downloaded successfully.


//mr-sh

@Test
public void test2() throws InterruptedException {
    //    Go to URL: https://the-internet.herokuapp.com/download
    driver.get("https://the-internet.herokuapp.com/download");

    //    Download selenium-snapshot.png
    driver.findElement(By.linkText("selenium-snapshot.png")).click();
    Thread.sleep(500);
    //    Verify if the file downloaded successfully.

    String s = "/Users/mr-sh/Downloads";
    String separater = System.getProperty("file.separator");
    String pathOfFile = System.getProperty("user.home")+ separater+"Downloads"+separater+"selenium-snapshot.png";

    boolean isExist = Files.exists(Paths.get(pathOfFile));
    Assert.assertTrue(isExist);

}
}