package Day12;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.io.File.separator;

public class C04TakeScreenShots extends TestBase {


    @Test
    public void test() throws IOException {
        driver.get("https://www.google.com");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String data = new SimpleDateFormat("yyyy_MM_dd_hh_m_ss").format(new Date());
        File des = new File(System.getProperty("user.dir") + separator + "resources" + separator + "screenshot"+ data + ".png") ;
        FileUtils.copyFile(source,des);
    }
}
