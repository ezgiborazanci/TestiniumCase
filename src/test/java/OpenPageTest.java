import components.BasketPage;
import components.HomePage;
import components.ProductPage;
import components.Search;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;



public class OpenPageTest extends BaseTest{

        @Test
        public void correctOpen() throws InterruptedException {
            HomePage homePage = new HomePage(driver);
            homePage.Assertion();
            homePage.LoginCase();
            homePage.SearchAnElement();

            Search search = new Search(driver);
            search.SearchPage();

            ProductPage productPage = new ProductPage(driver);
            productPage.AddToBasket();

            BasketPage basketPage = new BasketPage(driver);
            basketPage.ComparePrices();
            basketPage.ChangeQuantitiy();
            basketPage.DeleteItems();
        }
    }

