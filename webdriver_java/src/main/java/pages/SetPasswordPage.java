package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SetPasswordPage extends PageBase{

    @FindBy(xpath = "//div[@class='chakra-input__group css-4302v8']//input[@placeholder='Password']")
    WebElement passwordField;

    @FindBy(xpath = "//div[@class='chakra-input__group css-4302v8']//input[@placeholder='Confirm password']")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//span[@class='chakra-checkbox__control css-1llrcga']")
    WebElement confirmCheckbox;

    @FindBy(xpath = "//div[@class='chakra-button__group css-1486y4u']//button[text()='Next']")
    WebElement nextButton;

    public SetPasswordPage(WebDriver driver) {
        super(driver);
    }

    public boolean setPasswordPageIsLoaded() {
        return (passwordField).isDisplayed();
    }

    public  void setPassword(String password) {
        (passwordField).sendKeys(password);
    }

    public  void confirmPassword(String password) {
        (confirmPasswordField).sendKeys(password);
    }

    public  void confirmCheckbox() {
        (confirmCheckbox).click();
    }

    public BackUpInstructionPage getBackUpInstructionPage (WebDriver driver){
        (nextButton).click();
        return new BackUpInstructionPage(driver);
    }





}
