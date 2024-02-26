package Day02;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.concurrent.TimeUnit;

public class W3SchoolsPageTestSuite {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new EdgeDriver();
        EdgeOptions options = new EdgeOptions();

    }

    @Test
    public void testW3SchoolsPage() throws InterruptedException {
        // Open URL: https://www.w3schools.com/
        driver.get("https://www.w3schools.com/");

        // Maximize the window
        driver.manage().window().maximize();

        // Print the position and size of the page
        Point position = driver.manage().window().getPosition();
        Dimension size = driver.manage().window().getSize();
        System.out.println("Position of the page: " + position);
        System.out.println("Size of the page: " + size);

        // Minimize the page
        driver.manage().window().setPosition(new Point(-2000, 0));

        // Wait for 7 seconds
        TimeUnit.SECONDS.sleep(7);

        // Maximize the page
        driver.manage().window().maximize();

        // Print the position and dimensions of the page in maximized state
        Point maximizedPosition = driver.manage().window().getPosition();
        Dimension maximizedSize = driver.manage().window().getSize();
        System.out.println("Position of the page in maximized state: " + maximizedPosition);
        System.out.println("Size of the page in maximized state: " + maximizedSize);

        // Make the page fullscreen
        driver.manage().window().fullscreen();
    }

    @After
    public void tearDown() {
        // Close the Browser
        if (driver != null) {
            driver.quit();
        }
    }
}

/*

import org.junit.jupiter.api.AfterEach;
 import org.junit.jupiter.api.BeforeEach;
  import org.junit.jupiter.api.Test;
   import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement
 ; import org.openqa.selenium.chrome.ChromeDriver;
 import static org.junit.jupiter.api.Assertions.assertTrue;
public class LoginTest { private WebDriver driver;
@BeforeEach public void setUp() {
// تعيين مسار تشغيل WebDriver System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // إنشاء instance من WebDriver driver = new ChromeDriver(); } @Test public void testIncorrectLogin() { // فتح الصفحة driver.get("https://example.com/login"); // إدخال بيانات الاعتماد الخاطئة driver.findElement(By.id("username")).sendKeys("testUser"); driver.findElement(By.id("password")).sendKeys("incorrectPassword"); driver.findElement(By.id("loginButton")).click(); // التحقق من وجود رسالة الخطأ WebElement errorMessage = driver.findElement(By.id("errorMessage")); String errorMessageText = errorMessage.getText(); // التأكد من أن رسالة الخطأ تظهر assertTrue(errorMessageText.contains("Error"),
 "The error message should be displayed for incorrect login."); } @AfterEach public void tearDown()
  { // إغلاق المتصفح بعد كل اختبار
 if (driver != null) { driver.quit(); } } }
—————
import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;
 public class SeleniumTest { public static void main(String[] args) {
 // تعيين مسار تشغيل WebDriver الخاص بك System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // إنشاء instance من WebDriver WebDriver driver = new ChromeDriver(); try { // فتح الصفحة الرئيسية للموقع الذي تريد اختباره driver.get("https://example.com/login"); // إيجاد عناصر الإدخال وإدخال بيانات الاعتماد WebElement usernameInput = driver.findElement(By.id("username")); WebElement passwordInput = driver.findElement(By.id("password")); WebElement loginButton = driver.findElement(By.id("loginButton")); // إدخال بيانات المستخدم usernameInput.sendKeys("testUser"); passwordInput.sendKeys("incorrectPassword"); // الضغط على زر تسجيل الدخول loginButton.click(); // الانتظار للتأكد من تحميل الصفحة (يمكن استخدام WebDriverWait لطريقة أكثر فعالية) Thread.sleep(2000); // يفضل استخدام WebDriverWait بدلاً من Thread.sleep // التحقق من وجود رسالة الخطأ وطباعتها WebElement errorMessage = driver.findElement(By.id("errorMessage"));
 String errorMessageText = errorMessage.getText(); System.out.println("Error Message: " + errorMessageText); }
  catch (Exception e) { e.printStackTrace(); }
 finally { // إغلاق المتصفح driver.quit(); } } }
 */