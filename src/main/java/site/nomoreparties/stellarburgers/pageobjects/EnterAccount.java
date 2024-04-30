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
//    private By eyeButton = By.className("input__icon input__icon-action");
    private By submit = By.xpath("//button[contains(text(), \"Войти\")]");
    private By register = By.xpath("//a[@href=\"/register\"]");

    public void goToRegister(){
        driver.findElement(register).click();
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
    public void enterAccount(String username, String userpass) throws InterruptedException {
        Thread.sleep(500);//Без ожидания поля не успевают активироваться
        userName().click();
        userName().sendKeys(username);
        userPass().click();
        userPass().sendKeys(userpass);
        submitButton().click();
    }
}
