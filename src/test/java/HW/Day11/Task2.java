package HW.Day11;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static junit.framework.TestCase.assertTrue;

public class Task2 extends TestBase {

    @Test
            public void test(){
        // Step 1: Set up the file path
        String userDesktop = System.getProperty("user.home") + "\\Desktop\\";
        String fileName = "File.txt";
        String filePath = userDesktop + fileName;
        // Step 2: Create the file
        File file = new File(filePath);
        try {
            boolean isFileCreated = file.createNewFile(); // This will create the file if it doesn't exist
            if (isFileCreated) {
                System.out.println(fileName + " has been created on the Desktop.");
            } else {
                System.out.println(fileName + " already exists on the Desktop.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while creating the file: " + e.getMessage());
        }
        // Step 3: Verify the file exists
        if (file.exists()) {
            System.out.println(fileName + " exists on the Desktop.");
        } else {
            System.out.println(fileName + " does not exist on the Desktop.");
        }
      //  Verify with Assert
        boolean isExist = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isExist);
    }
}

