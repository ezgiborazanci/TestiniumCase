package components;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void Assertion(){
        Assert.assertEquals(driver.getTitle(), "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi");// JUnit'in AssertionEquals'i kullandık.
    }
    public void LoginCase(){
        //Direkt Giriş Sayfasına Geçildi.
        driver.navigate().to("https://www.gittigidiyor.com/uye-girisi");

        // Kullanıcı adı alanı doldurulur.
        WebElement username =  driver.findElement(By.xpath("/html//input[@id='L-UserNameField']"));
        username.sendKeys("ezgiborazanci@outlook.com");
        // Kullanıcı şifresi girildi.
        WebElement password = driver.findElement(By.xpath("/html//input[@id='L-PasswordField']"));
        password.sendKeys("2201050**E");

        WebElement clicklogin = driver.findElement(By.xpath("/html//input[@id='gg-login-enter']"));
        clicklogin.click();

        WebElement logincontrol = driver.findElement(By.xpath("/html//header[@id='main-header']/div[3]/div/div/div/div[3]/div/div[1]/div[@title='Hesabım']/div[2]"));

        Assert.assertEquals(logincontrol.getText(),"Hesabım\n" +
                "ezgiborazanci6646");
    }
    public void SearchAnElement(){
        WebElement searchWord = driver.findElement(By.xpath("/html//header[@id='main-header']/div[3]/div/div/div//form[@action='https://www.gittigidiyor.com/arama']//input[@name='k']"));
        searchWord.sendKeys("Bilgisayar");

        WebElement searchbutton = driver.findElement(By.xpath("/html//header[@id='main-header']/div[3]/div/div/div//form[@action='https://www.gittigidiyor.com/arama']//button[@type='submit']"));
        searchbutton.click();
    }
}
