package pages.homeWork;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage {

    private WebDriver driver;

    private By searchFieldBy = By.xpath("//div[@class='col-xs-12 col-sm-4 search']//input[@type='search']");

    private By productContainerList = By.xpath("//div[@id='productlistcontainer']//ul [@class = 's-productscontainer2 ']");

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductPage chooseProduct(){
        WebElement prodListElement = driver.findElement(productContainerList);
        List<WebElement> elements = prodListElement.findElements(By.tagName("li"));
        System.out.println(elements.size());
        elements.get(0).click();
        return new ProductPage(driver);
    }

}
