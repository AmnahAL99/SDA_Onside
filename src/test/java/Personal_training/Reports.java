package Personal_training;

import Utilities.TestBase;
import Utilities.TestBaseReport;
import org.junit.Test;
import org.openqa.selenium.By;

public class Reports extends TestBaseReport {
    @Test
    public void test(){
       // extentTest =  extentReportsSetUp().creatTest("LinkedIn","This is the report for the LinkedIn Test");
        extentTest = extentReports.createTest(getClass().getSimpleName() + " - " + Thread.currentThread().getStackTrace()[2].getMethodName());

     //   extentReports.pass("User Goes to homepage");
        driver.get("https://www.linkedin.com/");
        extentTest.pass("User in homepage");
        driver.findElement(By.partialLinkText("Sign in")).click();
        extentTest.pass("User click sign in homepage");
        driver.navigate().back();
        extentTest.pass("User in homepage again");
        extentReports.flush();

    }


}
