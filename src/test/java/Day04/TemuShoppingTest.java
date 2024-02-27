package Day04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TemuShoppingTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your chromedriver executable

        // Initialize the ChromeDriver
        driver = new FirefoxDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void completeShopping() throws InterruptedException {
        // 1. Go to the Temu website
        driver.get("https://www.temu.com");

        // 2. Search for "iphone"
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("iphone" + Keys.ENTER);
/*
        // Wait for search results to load. This is not best practice; ideally, use WebDriverWait.
        Thread.sleep(5000); // Wait for 5 seconds

        // 3. Print the result number (Assuming a specific element holds this info, this will need adjustment)
        WebElement resultStats = driver.findElement(By.className("result-stats"));
        System.out.println("Search results number: " + resultStats.getText());

        // 4. Click on the first product
        WebElement firstProduct = driver.findElement(By.cssSelector("selector-for-first-product")); // Adjust selector
        firstProduct.click();

        // Wait for product page to load
        Thread.sleep(5000); // Wait for 5 seconds

        // 5. Add to cart
        WebElement addToCartButton = driver.findElement(By.cssSelector("button-add-to-cart")); // Adjust selector
        addToCartButton.click();

        // 6. Click on the cart icon
        WebElement cartIcon = driver.findElement(By.cssSelector("icon-cart")); // Adjust selector
        cartIcon.click();

        // Wait for cart to load
        Thread.sleep(5000); // Wait for 5 seconds

        // 7. Print the product price
        WebElement productPrice = driver.findElement(By.cssSelector("product-price")); // Adjust selector
        System.out.println("Product Price: " + productPrice.getText());

        // 8. Complete shopping - This step is too vague without specific actions or buttons to interact with
*/
    }




    }



