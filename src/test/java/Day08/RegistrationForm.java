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


    @Test
    public void test2() {
        driver.get("https://clarusway.getlearnworlds.com/sda-test-registration-form");

        // Switch to the iframe by identifying it using its unique attributes
        driver.switchTo().frame(0);

        // Fill the first name
        WebElement firstNameInput = driver.findElement(By.xpath("//*[@elname='First']"));
        firstNameInput.sendKeys("Amnah");

        // Fill the last name
        WebElement lastNameInput = driver.findElement(By.xpath("//*[@elname='Last']"));
        lastNameInput.sendKeys("ALmutari");

        //Check the radio button
        List<WebElement> radio = driver.findElements(By.className("tempContDiv"));
        radio.get(1).click();

        // Drop down Selection
        WebElement dropdown = driver.findElement(By.id("Dropdown-arialabel"));
        Select select = new Select(dropdown);
        select.selectByIndex(2);

        // check box
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@for='Checkbox_1']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@for='Checkbox_2']"));
        WebElement checkbox3 = driver.findElement(By.xpath("//*[@for='Checkbox_3']"));
        checkbox1.click();
        checkbox2.click();
        checkbox3.click();

        // Rating
        WebElement star5 = driver.findElement(By.xpath("//*[@aria-label='5 Star']"));
        star5.click();

        // Submit button
        driver.findElement(By.xpath("//*[@elname='submit']")).click();

        // Assertions
        Assert.assertNotNull("First name should not be null", firstNameInput.getAttribute("value"));
        Assert.assertTrue("Dropdown should be chosen", select.getFirstSelectedOption().getText().equals("Second Choice"));


        // Assertions for Rating

        // Get the current value of the selected rating
        String selectedRating = star5.getAttribute("aria-label");

             // Extract the numeric value from the rating
        int numericValue = Integer.parseInt(selectedRating.split(" ")[0]);

             // Assertion for Rating
        Assert.assertEquals(5, numericValue);

    }




}
