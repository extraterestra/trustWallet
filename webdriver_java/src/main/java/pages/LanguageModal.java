package pages.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LanguageModal {

    private WebDriver driver;

    private By britishLanguage = By.xpath("//div[@class='modal-body']//span[@title='United Kingdom flag']");

    public LanguageModal(WebDriver driver){
        this.driver = driver;
    }

    public SportHomePage chooseBritishLanguage(){
        driver.findElement(britishLanguage).click();
        return new SportHomePage(driver);
    }

}
