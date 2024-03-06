package Day11;

import Utilities.TestBase;
import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.title;
import static org.junit.Assert.assertTrue;

public class C04FileUpload extends TestBase {

 @Test
    public void test() {
     By s = By.id("file-upload");
     String userDir = System.getProperty("user.dir");
     String sepertor = System.getProperty("file.separator");
     String filename = "new";
     String path = userDir + sepertor + filename;
     driver.get("https://the-internet.herokuapp.com/upload");
     WebElement uplode = driver.findElement(s);
     uplode.sendKeys("C:\\Users\\mr-sh\\Desktop\\new.docx");

 }


 }


//Go to URL: https://the-internet.herokuapp.com/upload
//Find the path of the file that you want to upload.
//Click on Upload button.
//Verify the upload message.