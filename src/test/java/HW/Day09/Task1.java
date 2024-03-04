package HW.Day09;

import Utilities.TestBase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.junit.Assert.assertTrue;

public class Task1 extends TestBase {


    @Test
    public void testDragAndDrop() {
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
}
// Perform drag and drop for the first 5000 button
//  WebElement first5000Button = driver.findElement(By.xpath("//a[contains(text(),'5000')]"));
//        WebElement first5000Button = driver.findElement(By.cssSelector("section[id='g-container-main'] li:nth-child(2) a:nth-child(1)"));
//        WebElement amount = driver.findElement(By.id("amt8"));
//
//       actions.dragAndDrop(first5000Button, amount).perform();