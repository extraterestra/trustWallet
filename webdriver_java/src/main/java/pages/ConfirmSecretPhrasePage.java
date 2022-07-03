package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConfirmSecretPhrasePage extends PageBase {

    By wordElement = By.xpath("//div[@class='css-1qlyzzw'] and text()=%s]");

    @FindBy(xpath = "//div[@class='chakra-button__group css-1486y4u']//button[text()='Next']")
    WebElement nextButton;

//    @FindBy(xpath = "//div[@class='css-1qlyzzw'] and text()=%s]")
//    WebElement wordElement;

    public ConfirmSecretPhrasePage(WebDriver driver) {
        super(driver);
    }

    public boolean confirmSecretPhrasePageIsLoaded() {
        return (nextButton).isDisplayed();
    }

    public void printSecretPhrase(List<String> phrase) throws InterruptedException {
        for (String word:phrase){
            TimeUnit.SECONDS.sleep(1);
            String wordXpath = String.format("//div[@class='css-1qlyzzw' and text()='%s']", word);
            WebElement wordElement = driver.findElement(By.xpath(wordXpath));
            wordElement.click();
        }
        TimeUnit.SECONDS.sleep(1);
    }

    public OpenWalletPage getOpenWalletPage(WebDriver driver) {
        (nextButton).click();
        return new OpenWalletPage(driver);
    }
}
