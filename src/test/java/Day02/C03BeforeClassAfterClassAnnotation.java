package Day02;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;

import java.sql.SQLOutput;
public class C03BeforeClassAfterClassAnnotation {
    WebDriver driver;
    @BeforeClass
    public static void beforeClass(){
        WebDriver driver = new EdgeDriver();
        System.out.println("Before class method is executed...");
    }

    @AfterClass
    public static void afterClass(){

        System.out.println("After Classs method is executed...");
    }

}


