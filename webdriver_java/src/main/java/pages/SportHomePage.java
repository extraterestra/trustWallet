package pages.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SportHomePage {

    private WebDriver driver;

    private By searchFieldBy = By.xpath("//div[@class='col-xs-12 col-sm-4 search']//input[@type='search']");

    public SportHomePage(WebDriver driver){
        this.driver = driver;
    }

    public SearchResultsPage searchForProduct(String productName){
        WebElement searchField = driver.findElement(searchFieldBy);
        searchField.sendKeys(productName);
        searchField.sendKeys(Keys.ENTER);
        System.out.println("Search done");

        return new SearchResultsPage(driver);

    }


}
