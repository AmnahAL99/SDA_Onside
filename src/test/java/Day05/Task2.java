package Day05;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import static org.junit.Assert.assertEquals;

public class Task2 {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/v1/inventory.html");
    }

    @Test
    public void addFirstItemToCartAndVerify() {
        // Add the first item to the cart
        WebElement firstItemAddToCartButton = driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
        String expectedItemName = driver.findElement(By.className("inventory_item_name")).getText();
        firstItemAddToCartButton.click();

        // Open the cart
        WebElement cartButton = driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]"));
        cartButton.click();

        // Assert that the item name is correct inside the cart
        String actualItemName = driver.findElement(By.className("inventory_item_name")).getText();
        assertEquals("The item name in the cart does not match the expected name.", expectedItemName, actualItemName);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
