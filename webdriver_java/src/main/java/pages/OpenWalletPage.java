package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class OpenWalletPage extends PageBase {

    @FindBy(xpath = "//button[@class='chakra-button css-m3r3po'and text()='Open wallet']")
    WebElement openWalletButton;

    public OpenWalletPage(WebDriver driver) {
        super(driver);
    }

    public boolean openWalletPageIsLoaded() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return (openWalletButton).isDisplayed();
    }

}
