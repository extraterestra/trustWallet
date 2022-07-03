package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class BackUpInstructionPage extends PageBase {

    @FindBy(xpath = "//div[@class='chakra-button__group css-1486y4u']//button[text()='Start']")
    WebElement startButton;


    public BackUpInstructionPage(WebDriver driver) {
        super(driver);
    }

    public boolean backUpInstructionPageIsLoaded() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return (startButton).isDisplayed();
    }

    public SecretPhrasePage getSecretPhrasePage (WebDriver driver){
        (startButton).click();
        return new SecretPhrasePage(driver);
    }
}
