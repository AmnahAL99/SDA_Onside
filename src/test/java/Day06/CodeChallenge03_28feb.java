package Day06;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CodeChallenge03_28feb {

    WebDriver driver;
    @Before
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com");
    }


    @Test
    public void test01() {
        driver.findElement(By.id("email")).sendKeys("ekarsli61@gmail.com");
        driver.findElement(By.id("password")).sendKeys("1234567890");
        driver.findElement(By.id("submit")).click();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(driver.getCurrentUrl(), "https://thinking-tester-contact-list.herokuapp.com/contactList");

        driver.findElement(By.id("add-contact")).click();

        Assert.assertEquals("https://thinking-tester-contact-list.herokuapp.com/addContact", driver.getCurrentUrl());


        //I create a contact from the class that I created below.
        Contact contact = new Contact();

        driver.findElement(By.id("firstName")).sendKeys(contact.firstName);
        driver.findElement(By.id("lastName")).sendKeys(contact.lastName);
        driver.findElement(By.id("birthdate")).sendKeys(contact.birthDate);
        driver.findElement(By.id("email")).sendKeys(contact.email);
        driver.findElement(By.id("phone")).sendKeys(contact.phone);
        driver.findElement(By.id("street1")).sendKeys(contact.street1);
        driver.findElement(By.id("street2")).sendKeys(contact.street2);
        driver.findElement(By.id("city")).sendKeys(contact.city);
        driver.findElement(By.id("stateProvince")).sendKeys(contact.stateProvince);
        driver.findElement(By.id("postalCode")).sendKeys(contact.postalCode);
        driver.findElement(By.id("country")).sendKeys(contact.country);

        driver.findElement(By.id("submit")).click();

        List<WebElement> tableContent = driver.findElements(By.xpath("//*[@class='contactTableBodyRow']"));
        List<String> tableToCheck = new ArrayList<>();
        for (WebElement row : tableContent){
            tableToCheck.add(row.getText());
        }

        Assert.assertTrue(tableToCheck.retainAll(contact.toList()));

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

class Contact{
    String firstName;
    String lastName;
    String birthDate;
    String email;
    String phone;
    String street1;
    String street2;
    String city;
    String stateProvince;
    String postalCode;
    String country;


    static Faker faker;
    public Contact() {
        faker = new Faker();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.birthDate = new SimpleDateFormat("yyyy-MM-dd").format(faker.date().birthday());
        this.email = faker.internet().emailAddress();

        //Using Random() class to generate an 8 digits phone number.
        //Note that n will never be 9 digits (10000000) since nextInt(90000000) can at most return 89999999.
        Random rnd = new Random();
        int phoneNumber = 10000000 + rnd.nextInt(90000000);
        this.phone = phoneNumber + "";

        this.street1 = faker.address().streetAddress();
        this.street2 = faker.address().buildingNumber();
        this.city = faker.address().city();
        this.stateProvince = faker.address().state();
        this.postalCode = faker.address().zipCode();
        this.country = faker.address().country();
    }

    public List<String> toList(){
        List<String> resultList = new ArrayList<>();
        resultList.add(this.firstName);
        resultList.add(this.lastName);
        resultList.add(this.phone);
        resultList.add(this.stateProvince);
        resultList.add(this.postalCode);
        resultList.add(this.city);
        resultList.add(this.country);
        resultList.add(this.email);
        resultList.add(this.street1);
        resultList.add(this.street2);
        resultList.add(this.birthDate);
        return resultList;
    }
}