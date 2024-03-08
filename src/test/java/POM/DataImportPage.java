package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataImportPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@class='download-link']")
    private WebElement downloadLink;

    public DataImportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void downloadSampleCSV() {
        downloadLink.click();
    }
}
