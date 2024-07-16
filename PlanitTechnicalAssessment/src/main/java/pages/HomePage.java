package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private By contactLink = By.xpath("//a[@href = '#/contact']");
    private By shopPageLink = By.xpath("//a[@href = '#/shop']");
    WebDriver driver;
    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public ContactPage clickContactPage (){
        driver.findElement(contactLink).click();
        return new ContactPage (driver);
    }
    public ShopPage clickShopPage(){
        driver.findElement(shopPageLink).click();
        return new ShopPage(driver);
    }
}
