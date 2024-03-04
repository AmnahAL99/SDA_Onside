package HW.Day09;

import Utilities.TestBase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.junit.Assert.assertTrue;

public class Task1 extends TestBase {


    @Test
    public void testDragAndDrop1() {
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        // Create object of Actions class

        // Perform drag and drop for BANK button
        WebElement bankButton = driver.findElement(By.xpath("//a[contains(text(),'BANK')]"));
        WebElement debitSideAccount = driver.findElement(By.id("bank")); //  for the DEBIT SIDE Account
        actions.dragAndDrop(bankButton, debitSideAccount).perform();

        // Perform drag and drop for SALES button
        WebElement salesButton = driver.findElement(By.xpath("//a[contains(text(),'SALES')]"));
        WebElement creditSideAccount = driver.findElement(By.id("loan")); //  for the CREDIT SIDE Account
        actions.dragAndDrop(salesButton, creditSideAccount).perform();

        WebElement second5000Button = driver.findElement(By.xpath("(//a[contains(text(),'5000')])[2]"));
        WebElement creditSideAmount = driver.findElement(By.xpath("//ol[@id='amt8']/li"));
        actions.dragAndDrop(second5000Button, creditSideAmount).build().perform();

        //Verify the visibility of Perfect text.
        WebElement perfect = driver.findElement(By.xpath("//a[contains(@class,'button-green')][1]"));
        Assert.assertTrue(perfect.isDisplayed());


    }



    @Test
    public void testDragAndDrop() {
        // Navigate to the demo page
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        // Define locators
        By bankButtonLocator = By.xpath("//a[contains(text(),'BANK')]");
        By debitSideAccountLocator = By.xpath("//ol[@id='bank']/li");
        By salesButtonLocator = By.xpath("//a[contains(text(),'SALES')]");
        By creditSideAccountLocator = By.xpath("//ol[@id='loan']/li");
        By first5000ButtonLocator = By.xpath("(//a[contains(text(),'5000')])[1]");
        By debitSideAmountLocator = By.xpath("//ol[@id='amt7']/li");
        By second5000ButtonLocator = By.xpath("(//a[contains(text(),'5000')])[2]");
        By creditSideAmountLocator = By.xpath("//ol[@id='amt8']/li");
      //  By perfectLocator = By.xpath("//a[contains(@class,'button-green')][1]");


        // Perform drag and drop actions using defined locators
        actions.dragAndDrop(driver.findElement(bankButtonLocator), driver.findElement(debitSideAccountLocator)).perform();
        actions.dragAndDrop(driver.findElement(salesButtonLocator), driver.findElement(creditSideAccountLocator)).perform();
        actions.dragAndDrop(driver.findElement(first5000ButtonLocator), driver.findElement(debitSideAmountLocator)).perform();
        actions.dragAndDrop(driver.findElement(second5000ButtonLocator), driver.findElement(creditSideAmountLocator)).perform();

// Define locator for the "Perfect" text
        By perfectLocator = By.xpath("//a[contains(text(),'Perfect')]");

// Use JavascriptExecutor to check if the element is visible
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Boolean isDisplayed = (Boolean) js.executeScript(
                "var elem = arguments[0],                 " +
                        "    box = elem.getBoundingClientRect(), " +
                        "    cx = box.left + box.width / 2,      " +
                        "    cy = box.top + box.height / 2,      " +
                        "    e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {        " +
                        "    if (e === elem) return true;        " +
                        "}" +
                        "return false;                           ",
                driver.findElement(perfectLocator));

// Assert that the "Perfect" text is displayed
        assertTrue("The 'Perfect' text is not displayed as expected.", isDisplayed);

    }


}
