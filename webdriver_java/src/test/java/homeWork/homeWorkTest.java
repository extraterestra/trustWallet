package homeWork;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.SearchResultsPage;
import pages.SportHomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class homeWorkTest extends BaseTests {

    @Test
    public void testAddBootsProductToCart(){
        SportHomePage sportHomePage = languageModal.chooseBritishLanguage();
        SearchResultsPage searchResultsPage = sportHomePage.searchForProduct("Nike Flex Runner Little Kids' Shoe");
        ProductPage productPage = searchResultsPage.chooseProduct();
        productPage.addProductToCart("C11 (28.5)");
        assertEquals(productPage.getProdNumberInCart(), 1);

    }

    @Test
    public void testAddTShirtProductToCart(){
        SportHomePage sportHomePage = languageModal.chooseBritishLanguage();
        SearchResultsPage searchResultsPage = sportHomePage.searchForProduct("Nike T-Shirt");
        ProductPage productPage = searchResultsPage.chooseProduct();
        productPage.addProductToCart("7-8 Yrs");
        assertEquals(productPage.getProdNumberInCart(), 1);

    }
}
