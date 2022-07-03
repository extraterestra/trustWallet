package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShareDataPage extends PageBase {

    public ShareDataPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='chakra-button__group css-1486y4u']//button[@class='chakra-button css-26mrqh' and text() = 'Share data']")
    WebElement shareDataButton;


    public boolean shareDataPageIsLoaded() {
        return (shareDataButton).isDisplayed();
    }

    public  SetPasswordPage getPasswordPage (WebDriver driver) {
         (shareDataButton).click();
         return new SetPasswordPage(driver);
    }

}
