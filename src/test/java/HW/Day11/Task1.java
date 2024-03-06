package HW.Day11;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Task1 extends TestBase {


    @Test
    public void test2(){
        driver.get("https://www.facebook.com/");

        Set<Cookie> allCookies = driver.manage().getCookies();
        allCookies.forEach(System.out::println); //lambda Way

        //Add Cookie.
        Cookie cookieSuger = new Cookie("low","sager");
        driver.manage().addCookie(cookieSuger);
        System.out.println(cookieSuger);

        //Delete Cookie.
        driver.manage().deleteCookie(cookieSuger);
        driver.manage().deleteCookieNamed("low");
        driver.manage().getCookies().forEach(System.out::println);
        System.out.println("------------------------------");

        //Delete All Cookies.
        driver.manage().deleteAllCookies();
        driver.manage().getCookies().forEach(System.out::println);
        System.out.println("end here...");
    }



}
