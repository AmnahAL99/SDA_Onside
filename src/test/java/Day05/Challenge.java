package Day05;

import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

public class Challenge {

    private static WebDriver driver;

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
-------------------------------------------------------------------------
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
        System.setProperty("webdriver.chrome.driver", "path/to/your/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
    }

    @Test
    public void testAddAndRemoveTodo() {
        // Add a TODO
        WebElement addTodoInput = driver.findElement(By.xpath("//input[@type='text']"));
        addTodoInput.sendKeys("New Todo");
        addTodoInput.submit();

        // Verify TODO is added
        List<WebElement> todos = driver.findElements(By.className("ng-binding"));
        boolean isTodoAdded = todos.stream().anyMatch(todo -> todo.getText().equals("New Todo"));
        assertTrue("TODO should be added", isTodoAdded);

        // Remove the TODO
        WebElement removeTodoButton = driver.findElement(By.xpath("//li[contains(text(), 'New Todo')]/span"));
        removeTodoButton.click();

        // Verify TODO is removed
        todos = driver.findElements(By.className("ng-binding"));
        boolean isTodoRemoved = todos.stream().noneMatch(todo -> todo.getText().equals("New Todo"));
        assertTrue("TODO should be removed", isTodoRemoved);
    }

    @Test
    public void testMarkTodoAsCompleted() {
        // Assuming there's an existing TODO to be marked as completed
        WebElement todoToMark = driver.findElement(By.xpath("//li[contains(text(), 'existing TODO text')]/input"));
        if (!todoToMark.isSelected()) {
            todoToMark.click();
        }

        // Verify TODO is marked as completed
        assertTrue("TODO should be marked as completed", todoToMark.isSelected());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

 */



