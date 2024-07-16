package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage {
    WebDriver driver;
    private By stuffedFrogBuyButton = By.xpath("(//a[@class='btn btn-success'][normalize-space()='Buy'])[2]");
    private By cartPage = By.xpath("//a[@href = '#/cart']");

    public ShopPage(WebDriver driver){
        this.driver = driver;
    }
    public double buyStuffedFrog(int quantity){
        double price = 0;
        for (int i=0; i<quantity;i++){
            buyButtons(2).click();
            String stuffedFrogPriceText = productPrices(2).replace("$","");
            double stuffedFrogPrice = Double.valueOf(stuffedFrogPriceText);
            price += stuffedFrogPrice;
        }
        return price;
    }
    public double buyFluffyBunny(int quantity){
        double price = 0;
        for (int i=0; i<quantity;i++){
            buyButtons(4).click();
            String fluffyBunnyPriceText = productPrices(4).replace("$","");
            double fluffyBunnyPrice = Double.valueOf(fluffyBunnyPriceText);
            price += fluffyBunnyPrice;
        }
        return price;
    }
    public double buyValentineBear(int quantity){
        double price = 0;
        for (int i=0; i<quantity;i++){
            buyButtons(7).click();
            String valentineBearPriceText = productPrices(7).replace("$","");
            double valentineBearPrice = Double.valueOf(valentineBearPriceText);
            price += valentineBearPrice;
        }
        return price;
    }

    public CartPage clickCartPage(){
        driver.findElement(cartPage).click();
        return new CartPage(driver);

    }




    public WebElement buyButtons(int index){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(stuffedFrogBuyButton));
        return driver.findElement(By.xpath("(//a[@class='btn btn-success'][normalize-space()='Buy'])["+index+"]"));
    }

    public String productPrices(int index){
        return  driver.findElement(By.xpath("(//span[@class='product-price ng-binding'])["+index+"]")).getText();
    }
}
