package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage {
    private WebDriver driver;

    private By addToBagButtonBy = By.xpath("//div[@id='ProductStandardAddToBag']");
    private By sizeListBy = By.xpath("//div[@id='divSize']");
    private By itemsInBag = By.xpath("//span[@id='bagQuantityContainer']//span[@id='bagQuantity']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String size) {
        selectSize(size);
        driver.findElement(addToBagButtonBy).click();

    }

    public void selectSize(String size) {
        WebElement sizeListElement = driver.findElement(sizeListBy);
        List<WebElement> elements = sizeListElement.findElements(By.tagName("li"));
        for (WebElement el:elements){
            if(el.getText().equals(size)){el.click();}
        }
        System.out.println("Product added with size " + size);

    }

    public int getProdNumberInCart() {
        String value = driver.findElement(itemsInBag).getText();
        int result = Integer. valueOf(value);
        return result;

    }

}
