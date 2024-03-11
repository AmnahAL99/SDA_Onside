package Day13;

import Utilities.TestBase;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
public class BMICalculatorTest extends TestBase {
    private static Logger log = Logger.getLogger(BMICalculatorTest.class);
   // PropertyConfigurator.configure("log4j.properties");

    @Test
    public void testBMICalculator() {


        try {
            driver.get("https://healthunify.com/bmicalculator/");
            driver.findElement(By.name("wg")).sendKeys("70"); // Enter weight
            new Select(driver.findElement(By.name("opt1"))).selectByVisibleText("kilograms"); // Select kilograms
            new Select(driver.findElement(By.name("opt2"))).selectByVisibleText("5"); // Select height in feet
            new Select(driver.findElement(By.name("opt3"))).selectByVisibleText("10"); // Select height in inches
            driver.findElement(By.name("cc")).click(); // Click calculate
            // Extract BMI values and description
            String siUnit = driver.findElement(By.name("si")).getAttribute("value");
            String usUnit = driver.findElement(By.name("us")).getAttribute("value");
            String ukUnit = driver.findElement(By.name("uk")).getAttribute("value");
            String description = driver.findElement(By.name("desc")).getAttribute("value");

            log.info("SI Unit: " + siUnit);
            log.info("US Unit: " + usUnit);
            log.info("UK Unit: " + ukUnit);
            log.info("Description: " + description);
            // Assert.assertEquals(expectedValue, siUnit);
        } finally {
            if (driver != null) {
                driver.quit(); // Close the browser
            }
        }
    }
}
