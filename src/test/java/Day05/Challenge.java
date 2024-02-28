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

<<<<<<< HEAD
    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
       // wait = new WebDriverWait(driver, 10);
=======
    @BeforeClass

    public static void setUp() {
        driver = new EdgeDriver();
        driver.get("(\"https://webdriveruniversity.com/To-Do-List/index.html/\");");
    }
    @Test
    public void testAddAndRemoveTodo() {
        // Add a TODO
        WebElement addTodoField = driver.findElement(By.xpath("//input[@placeholder='Add new todo']"));
        String newTodo = "New Selenium Todo";
        addTodoField.sendKeys(newTodo + Keys.ENTER);

        // Assert the TODO was added successfully
        WebElement addedTodoItem = driver.findElement(By.xpath("//li[contains(text(), '" + newTodo + "')]"));
        assertTrue(addedTodoItem.isDisplayed(), "New TODO item should be displayed in the list");

        // Remove the added TODO
        WebElement deleteButton = driver.findElement(By.xpath("//li[contains(text(), '" + newTodo + "')]/span/i"));
        deleteButton.click();

        // Assert the TODO was removed successfully
        // Here, you might need to add some logic to wait for the element to be removed or check the absence differently
        boolean isTodoPresentAfterDeletion;
        try {
            driver.findElement(By.xpath("//li[contains(text(), '" + newTodo + "')]"));
            isTodoPresentAfterDeletion = true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            isTodoPresentAfterDeletion = false;
        }
        assertFalse(isTodoPresentAfterDeletion, "TODO item should be removed from the list");
    }

    @Test
    public void testMarkTodoAsCompleted() {
        // Assuming an existing TODO with a specific text
        String todoText = "Some Other Todo";
        WebElement todoItem = driver.findElement(By.xpath("//li[contains(text(), '" + todoText + "')]"));
        todoItem.click();

        // Assert the TODO item is marked as completed
        // This assertion depends on how the application visually indicates a completed TODO. Here's a generic example.
        String completedTodoClass = todoItem.getAttribute("class");
        assertTrue(completedTodoClass.contains("completed"), "TODO item should be marked as completed");
    }


}

/*
------------------------------OR-------------------------------------------
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import static org.junit.Assert.*;

public class TodoListTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set path to your WebDriver
        driver = new ChromeDriver();
>>>>>>> e8ebcc687d0f64ac3440348b1506de2fd47fb67b
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
