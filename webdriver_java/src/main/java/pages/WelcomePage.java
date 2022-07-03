package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends PageBase {

    @FindBy(xpath = "//div[@class='chakra-stack css-utigf0']")
    WebElement welcomeLabel;

    @FindBy(xpath = "//div[@class='css-1a8tyed']//button[@class='chakra-button css-9kk5h'and text()='Create wallet']")
    WebElement createWalletButton;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public boolean welcomePageIsLoaded() {
        return (createWalletButton).isDisplayed();
    }

    public ShareDataPage getShareDataPage(WebDriver driver) {
        (createWalletButton).click();
        return new ShareDataPage(driver);
    }


}
