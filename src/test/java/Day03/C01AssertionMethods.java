package Day03;

import org.junit.Assert;
import org.junit.Test;
import org.testng.internal.junit.ArrayAsserts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
public class C01AssertionMethods {


    @Test
    public void assertEqualsTest() {
        // If the method takes two parameters, they are compared, and if they are equal, the test is PASSED,
        // otherwise, it throws an AssertionError.
      //  assertEquals(3,toString());
        assertEquals("the",3,3);


    }

    @Test
    public void assertTrueTest() {
        // If the method takes one parameter and the parameter is true, the test is PASSED,
        // if it is false, the test is FAILED.
       // Assert.assertTrue(2==5);
    }

    @Test
    public void assertFalseTest() {
        // If the method takes one parameter and the parameter is false, the test is PASSED,
        // if it is true, the test is FAILED.
      Assert.assertFalse(4==2);
    }

    @Test
    public void assertNullTest() {
        // If the method takes one parameter, the test is PASSED if the parameter is null,
        // otherwise, the test is FAILED.
        Integer a = null;
        String b = "";
        Assert.assertNull("Fail", a); //this method take null
    }

    @Test
    public void assertNotNullTest() {
        // If the method takes one parameter, the test is PASSED if the parameter is not null,
        // otherwise, the test is FAILED.
        Integer a = null;
        String b = "";
        Assert.assertNotNull("Fail", b); //this method take not null
    }

    @Test
    public void assertSameTest() {
        // This method uses the == operator internally to verify if two objects are equal.
        // assertSame also compares reference values.
        // In object comparison, both values and references must be the same.

         Assert.assertSame(new String("Hi"), new String("Hi")); // failed

    }

    @Test
    public void assertNotSameTest() {
        // It is valid for objects where both values and references are not the same.
        Assert.assertSame(new String("Hi"), new String("Hi"));
    }

    @Test
    public void assertArrayEquals() {
        // Takes two parameters and the lengths and elements at the same index of the given arrays must be the same.
      String [] arr ={"a","b"};
        String [] brr ={"a","b"};
        Assert.assertArrayEquals(arr,brr);

    }
}

 /*
    import static org. junit. Assert. *;
    assertSame

     import org. junit. Assert;
     Assert.assertSame

    "The advantage of static import for the Assert class is as follows:

    To eliminate the unnecessary use of the Assert class name with Assert methods.
    It saves time.
    Improves readability and makes writing better code."
     */
