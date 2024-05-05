package site.nomoreparties.stellarburgers.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnterAccount {
    private WebDriver driver;
    public EnterAccount(WebDriver driver){
        this.driver = driver;
    }
    private By login = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private By password = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private By submit = By.xpath("//button[contains(text(), \"Войти\")]");
    private By register = By.xpath("//a[@href=\"/register\"]");
    private By rememberPassword = By.xpath("//a[@href=\"/forgot-password\"]");

    public WebElement registerButton(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(register));
        return x;
    }
    public WebElement userName(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(login));
        return x;
    }
    public WebElement userPass(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(password));
        return x;
    }
    public WebElement submitButton(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(submit));
        return x;
    }
    public WebElement forgotPassword(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(rememberPassword));
        return x;
    }
    public void enterAccount(String username, String userpass) {
        userName().click();
        userName().sendKeys(username);
        userPass().click();
        userPass().sendKeys(userpass);
        submitButton().click();
    }
}
