package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    private By checkOutButton = By.xpath("//a[text()= 'Check Out']");
    private By totalPrice = By.xpath("//strong[@class='total ng-binding']");

    public String productPrice(String product){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutButton));
        return driver.findElement(By.xpath("//td[text()=' "+product+"']/following-sibling::td[1]")).getText();
    }

    public double subtotal(String product){
        String subtotalText = driver.findElement(By.xpath("//td[text()=' "+product+"']/following-sibling::td[3]")).getText().replace("$","");
        double subtotalPrice = Double.valueOf(subtotalText);
        return subtotalPrice;
    }

    public double getTotalPrice(){
        String totalText = driver.findElement(totalPrice).getText().replace("Total: ","");
        double totalPrice = Double.valueOf(totalText);
        return totalPrice;
    }

}
