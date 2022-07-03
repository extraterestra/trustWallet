package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SecretPhrasePage extends PageBase{

    @FindBy(xpath = "//div[@class='css-1o8v09g']")
    WebElement secretPhraseField;

    @FindBy(xpath = "//div[@class='chakra-button__group css-1486y4u']//button[text()='Next']")
    WebElement nextButton;

    @FindBy(xpath = "//button[@class='chakra-button css-1gkj047' and text()='Reveal']")
    WebElement revealButton;

    public SecretPhrasePage(WebDriver driver) {
        super(driver);
    }

    public boolean secretPhraseIsLoaded() {
        return (nextButton).isDisplayed();
    }

    public void revealPhrase() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
         (revealButton).click();
    }

    public List<String> getSecretPhrase() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);

        String phrase = (secretPhraseField).getText();
        List<String> list = Arrays.asList(phrase.split(" "));

        for(String str:list ){
            System.out.println(str);
        }

        return list;
    }

    public ConfirmSecretPhrasePage getConfirmSecretPhrasePage(WebDriver driver) {
        (nextButton).click();
        return new ConfirmSecretPhrasePage(driver);
    }

}
