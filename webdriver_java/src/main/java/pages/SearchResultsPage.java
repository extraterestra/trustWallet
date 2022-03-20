package pages;

import org.openqa.selenium.*;

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
        elements.get(1).click();
        return new ProductPage(driver);
    }

    public ProductPage chooseProductByName(String prodName){
        WebElement prodListElement = driver.findElement(productContainerList);
        List<WebElement> elements = prodListElement.findElements(By.tagName("li"));


        for (WebElement el : elements){
            if (el.getText().contains(prodName)){el.click();}
        }

        return new ProductPage(driver);
    }

}
