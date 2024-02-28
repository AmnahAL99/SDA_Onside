package Day06;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class C01JavaFakerClass {




    @Test
    public void testFaker(){
        Faker faker = new Faker();
     String fullname =   faker.name().fullName();
     String fullname2 =   faker.name().fullName();
     String fullname3 =   faker.name().fullName();
     System.out.println("fullname" + " " +fullname);
     System.out.println("fullname" + " " + fullname2);
     System.out.println("fullname" + " " +fullname3);

        System.out.println("number " + faker.number().digit());
       // System.out.println("address " + faker.address());
        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
        System.out.println("faker.internet().emailAddress() = " + faker.internet().emailAddress());
        System.out.println("faker.internet().password(6,8,true,true,false) = " + faker.internet().password(6, 8, true, true, false));
    }
}
