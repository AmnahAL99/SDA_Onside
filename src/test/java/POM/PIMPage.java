package POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")
    private WebElement pimModule;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/header[1]/div[2]/nav[1]/ul[1]/li[1]/span[1]")
    private WebElement configurationMenu;

    @FindBy(xpath = "//a[normalize-space()='Data Import']")
    private WebElement dataImport;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToDataImport() {
        pimModule.click();
        configurationMenu.click();
        dataImport.click();
    }
}
