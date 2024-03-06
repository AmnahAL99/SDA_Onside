package Personal_training;

import Utilities.TestBase;

import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Cookies  extends TestBase {


    @Test
    public void test(){
        driver.get("https://www.linkedin.com");
        Set<Cookie> allCookies = driver.manage().getCookies();
        allCookies.forEach(System.out::println); //lambda
      //  driver.manage().getCookieNamed("");
        // add
        Cookie cookieSuger = new Cookie("karb","sager");
        driver.manage().addCookie(cookieSuger);

        // delete
        driver.manage().deleteCookie(cookieSuger);



    }


}
