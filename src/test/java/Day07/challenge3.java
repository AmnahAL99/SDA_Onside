package Day07;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

import java.time.Duration;

public class challenge3 {


    @Test
    public void testChercherTechPracticePage() {
        // Set the path to the chromedriver executable

        WebDriver driver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds (20));

        // 1. Navigate to the URL
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // 2. Click on the button to open an alert after 5 seconds
        driver.findElement(By.id("alert")).click();

        // Wait for the alert to be present and accept it
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
             /*

        // 3. Click on "Change Text to Selenium Webdriver" and verify the text
        WebElement changeTextButton = driver.findElement(By.id("populate-text"));
        changeTextButton.click();

        WebElement textElement = driver.findElement(By.id("h2"));
        assert textElement.getText().equals("Selenium Webdriver") : "Text does not match";
         */
        // 4. Click on "Display button after 10 seconds" and verify it's displayed
        driver.findElement(By.id("display-other-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));
        assert driver.findElement(By.id("hidden")).isDisplayed() : "Button is not displayed";

        // 5. Click on "Enable button after 10 seconds" and verify it's enabled
        driver.findElement(By.id("enable-button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("disable")));
        assert driver.findElement(By.id("disable")).isEnabled() : "Button is not enabled";

        // 6. Click on "Check Checkbox after 10 seconds" and verify it's checked
        driver.findElement(By.id("checkbox")).click();
        wait.until(ExpectedConditions.elementToBeSelected(By.id("ch")));
        assert driver.findElement(By.id("ch")).isSelected() : "Checkbox is not checked";

        // Close the browser
        driver.quit();
    }





}
