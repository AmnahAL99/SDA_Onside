package HW.Day11;
import POM.DataImportPage;
import POM.LoginPage;
import POM.PIMPage;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;

public class Task3 extends TestBase {

    @Test
    public void test() {
        // Navigate to the URL
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Login
        POM.LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        // Navigate to PIM > Configuration > Data Import
        POM.PIMPage pimPage = new PIMPage(driver);
        pimPage.navigateToDataImport();

        // Click to download sample CSV
        POM.DataImportPage dataImportPage = new DataImportPage(driver);
        dataImportPage.downloadSampleCSV();

        String downloadDir = System.getProperty("user.home") + System.getProperty("file.separator") + "Downloads";
        // Configure Edge with preferences
        HashMap<String, Object> edgePrefs = new HashMap<>();
        edgePrefs.put("profile.default_content_settings.popups", 0);
        edgePrefs.put("download.default_directory", downloadDir);

        // Wait for the download to complete. Consider a more robust wait mechanism.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        // Verify the download
        String fileName = "importData.csv"; //  file name
        boolean isExist = Files.exists(Paths.get(downloadDir, fileName));
        Assert.assertTrue("The sample CSV file was not downloaded successfully.", isExist);
    }
}

