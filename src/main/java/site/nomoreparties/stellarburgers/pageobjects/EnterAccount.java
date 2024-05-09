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
    private By login = By.xpath("//input[@name=\"name\"]");
    private By password = By.xpath("//input[@name=\"Пароль\"]");
    private By submit = By.xpath("//button[contains(text(), \"Войти\")]");
    private By register = By.xpath("//a[@href=\"/register\"]");
    private By rememberPassword = By.xpath("//a[@href=\"/forgot-password\"]");

    public WebElement registerButton(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(register));
    }
    public WebElement userName(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(login));
    }
    public WebElement userPass(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(password));
    }
    public WebElement submitButton(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(submit));
    }
    public WebElement forgotPassword(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(rememberPassword));
    }
    public void enterAccount(String username, String userpass) {
        userName().click();
        userName().sendKeys(username);
        userPass().click();
        userPass().sendKeys(userpass);
        submitButton().click();
    }
}
