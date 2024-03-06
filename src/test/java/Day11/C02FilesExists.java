package Day11;

import Utilities.TestBase;
import com.sun.source.tree.AssertTree;
import org.junit.Assert;

import java.nio.file.DirectoryIteratorException;
import java.nio.file.Files;
import java.nio.file.Path;

import static junit.framework.TestCase.assertTrue;

public class C02FilesExists extends TestBase {

    public static void main(String[] args) {

        boolean isExist = Files.exists(Path.of("C:\\Users\\mr-sh\\IdeaProjects\\SDA2024_Selenium\\FileExist"));

        boolean isExist2 = Files.exists(Path.of(System.getProperty("user.home") + "\\Desktop\\new"));
        // String userDir = System.getProperty("user.dir");
        //  String path = userDir + "\\"+ "FileExist";
//        System.out.println("isExist" + isExist);
       System.out.println("isExist" + isExist2);
        //   assertTrue(isExist);


//        String userDir = System.getProperty("user.dir");
//        String sepertor = System.getProperty("file.separator");
//        System.out.println("userDir = " + userDir);
//        System.out.println("sepertor = " + sepertor);
//
//
//        String path = userDir + sepertor + "FileExist";
//
//        System.out.println("path = " + path);
//        boolean isExists = Files.exists(Path.of(path));
//        System.out.println("isExists = " + isExists);


    }


    // @Test

}