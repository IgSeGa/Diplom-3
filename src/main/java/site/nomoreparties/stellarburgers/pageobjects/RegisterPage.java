package site.nomoreparties.stellarburgers.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    private By name = By.xpath("(//input[@name=\"name\"])[1]");
    private By email = By.xpath("(//input[@name=\"name\"])[2]");
    private By password = By.xpath("//input[@name=\"Пароль\"]");
    private By error = By.xpath("//p[contains(@class, \"input__error\")]");
    private By submit = By.xpath("//button[contains(@class, button_button_size_medium__3zxIa) and contains(text(), \"Зарегистрироваться\")]");
    private By enterAccount = By.xpath("//a[@href=\"/login\"]");

    public WebElement getEmailForm(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(email));
    }
    public WebElement getPasswordForm(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(password));
    }
    public WebElement getNameForm(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(name));
    }
    public WebElement getSubmitButton(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(submit));
    }
    public WebElement getEnterAccount(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(enterAccount));
    }
    public WebElement getError(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(error));
    }

    public void register(String username, String usermail, String userpass){
        getNameForm().sendKeys(username);
        getEmailForm().sendKeys(usermail);
        getPasswordForm().sendKeys(userpass);
        getSubmitButton().click();
    }
    public void enterAccount(){
        getEnterAccount().click();
    }

    public String getPassError(){
        return getError().getText();
    }
}
