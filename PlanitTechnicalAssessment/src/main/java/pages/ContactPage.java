package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
    WebDriver driver;
    private By submitButton = By.xpath("//a[text()= 'Submit']");
    private By headerErrorMessage = By.xpath("//div[@class='alert alert-error ng-scope']");
    private By foreNameErrorMessage = By.xpath("//span[@id='forename-err']");
    private By emailErrorMessage = By.xpath("//span[@id='email-err']");
    private By messageBoxErrorMessage = By.xpath("//span[@id='message-err']");
    private By forenameField = By.xpath("//input[@id='forename']");
    private By emailField = By.xpath("//input[@id='email']");
    private By messageField = By.xpath("//textarea[@id='message']");
    private By successMessage = By.xpath("//div[@class='alert alert-success']");

    public ContactPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSubmit(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        driver.findElement(submitButton).click();
    }
    public String getHeaderErrorMessage(){
        return driver.findElement(headerErrorMessage).getText();
    }
    public String getForeNameErrorMessage(){
        return driver.findElement(foreNameErrorMessage).getText();
    }
    public String getEmailErrorMessage(){
        return driver.findElement(emailErrorMessage).getText();
    }
    public String getMessageBoxErrorMessage(){
        return driver.findElement(messageBoxErrorMessage).getText();
    }
    public void setForeName(String foreName){
        driver.findElement(forenameField).clear();
        driver.findElement(forenameField).sendKeys(foreName);
    }
    public void setEmailName(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void setMessage(String message){
        driver.findElement(messageField).sendKeys(message);
    }

    public String successMessage(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).getText();
    }

    public boolean pageText(String errorMessage){
        System.out.println(driver.getPageSource());
        return driver.getPageSource().contains(errorMessage);
    }



}
