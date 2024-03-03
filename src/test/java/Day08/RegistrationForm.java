package Day08;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class RegistrationForm extends TestBase {

    @Test
    public void test() {
        driver.get("https://clarusway.getlearnworlds.com/sda-test-registration-form");
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//li[@id='Name-li']//span[1]//input[1]")).sendKeys("Amnah");
        driver.findElement(By.xpath("//li[@id='Name-li']//span[2]//input[1]")).sendKeys("Almutari");
      driver.findElement(By.xpath("//label[@for='Radio_1']")).click();


        WebElement footerLink = driver.findElement(By.xpath("//p[contains(@id,'error-Name')]"));
      //Assert.assertTrue(footerLink.isDisplayed());
      Assert.assertFalse(footerLink.isDisplayed());

        WebElement element = driver.findElement(By.xpath("//span[@role='presentation']"));
          element.click();
        element.sendKeys("Second Choice" , Keys.ENTER);


        WebElement checkBox = driver.findElement(By.id("Checkbox_2"));

        checkBox.click();
        Assert.assertTrue(checkBox.isSelected());
       // element.click();


    }




}
