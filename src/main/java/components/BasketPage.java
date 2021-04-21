package components;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import static components.ProductPage.productPrice;

public class BasketPage {
    WebDriver driver;


    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }
    public void ComparePrices(){
        String productPriceBasket = driver.findElement(By.cssSelector(".real-discounted-price")).getText();
        Assert.assertEquals(productPriceBasket, productPrice);
        System.out.println("Karşılaştırma çalıştı.....");
    }
    public void ChangeQuantitiy(){
        WebElement selectAmount = driver.findElement(By.xpath("/html//div[@id='cart-items-container']/div//select[@class='amount']"));
        selectAmount.click();
        WebElement selectQuantity = driver.findElement(By.xpath("//div[@class='products-container']/div/div//select[@class='amount']/option[@value='2']"));
        selectQuantity.click();
        driver.findElement(By.xpath("//div[@id='cart-items-container']//div[@class='product-group-box']/div[1]")).click();
        String quantity = driver.findElement(By.xpath("//div[@class='products-container']/div/div//select[@class='amount']/option[@value='2']")).getText();
        Assert.assertEquals(quantity,"2");
        System.out.println("2 Adet Olduğu Doğrulandı....");
    }
    public void DeleteItems() throws InterruptedException {
        WebElement deleteButton = driver.findElement(By.xpath("//div[@class='row']/a[@title='Sil']/i[@class='gg-icon gg-icon-bin-medium']"));
        deleteButton.click();
        Thread.sleep(3000);
        String nullBasket = driver.findElement(By.cssSelector(".gg-w-22>h2")).getText();
        String text = "Sepetinizde ürün bulunmamaktadır.";
        Assert.assertEquals(nullBasket, text);
        System.out.println("Sepetin boş olduğu doğrulandı.....");
    }
}
