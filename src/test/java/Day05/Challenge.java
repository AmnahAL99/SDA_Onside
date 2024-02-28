package Day05;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Optional;


public class Challenge {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
       // wait = new WebDriverWait(driver, 10);
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testToDoList() {
        final String todoText = "Complete Selenium Test";
        addTodoItem(todoText);
        assertTodoPresent(todoText, true);

        markTodoAsCompleted(todoText);
        assertTodoCompleted(todoText, true);

        removeTodoItem(todoText);
        assertTodoPresent(todoText, false);
    }

    private void addTodoItem(String itemText) {
        WebElement inputField = driver.findElement(By.cssSelector("input[type='text']"));
        inputField.sendKeys(itemText + Keys.RETURN);
    }

    private void assertTodoPresent(String itemText, boolean expected) {
        List<WebElement> todos = driver.findElements(By.cssSelector("ul.list-unstyled li"));
        boolean isPresent = todos.stream().anyMatch(todo -> todo.getText().equals(itemText));
        Assert.assertEquals(isPresent, expected, "Todo item presence does not match expectation.");
    }

    private void markTodoAsCompleted(String itemText) {
        Optional<WebElement> todoOptional = driver.findElements(By.cssSelector("ul.list-unstyled li"))
                .stream()
                .filter(todo -> todo.getText().equals(itemText))
                .findFirst();
        todoOptional.ifPresent(WebElement::click);
    }

    private void assertTodoCompleted(String itemText, boolean expected) {
        Optional<WebElement> todoOptional = driver.findElements(By.cssSelector("ul.list-unstyled li.completed"))
                .stream()
                .filter(todo -> todo.getText().equals(itemText))
                .findFirst();
        Assert.assertEquals(todoOptional.isPresent(), expected, "Todo completion status does not match expectation.");
    }

    private void removeTodoItem(String itemText) {
        Optional<WebElement> todoOptional = driver.findElements(By.xpath("//li[contains(text(), '" + itemText + "')]/span/i"))
                .stream()
                .findFirst();
        todoOptional.ifPresent(WebElement::click);
    }


}
