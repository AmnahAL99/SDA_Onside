package Day02;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/*
* *****ANNOTATIONS******
"There are 6 annotations commonly used:
@Test: Allows us to create an independent test that can run on its own. Return type -> void
@Before: Used for the method where preparations to be done before the test starts. It runs before each method.
@BeforeClass: Similar to @Before but runs only once at the beginning of the class, unlike @Before. Must be static.
@After: Runs after each test, performing functions such as closing after the test is done.
@AfterClass: Runs once at the end of each class, must be static.
@Ignore: Ensures that the annotated method is not executed. When the test is run, the report shows that this method is marked as ignored."

*/
public class C02JunitAnnotations {
    WebDriver driver;
@Before
    public void beforeEachTest(){
    WebDriver driver = new EdgeDriver();
    System.out.println("hi");
   // driver.get("https://www.facebook.com/");
   // driver.quit();
}
    @After
    public void afterEachTest(){
       // WebDriver driver = new EdgeDriver();
        System.out.println("bay");
    }
  @Test
  public void test1(){
    driver.get("https://www.facebook.com");
      System.out.println("test1 is  done...");
      driver.quit();
  }
    @Test
    public void test2(){
        driver.get("https://demo.nopcommerce.com");
        System.out.println("test2 is  done...");
        driver.quit();
    }
}
