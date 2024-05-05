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
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(email));
        return x;
    }
    public WebElement getPasswordForm(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(password));
        return x;
    }
    public WebElement getNameForm(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(name));
        return x;
    }
    public WebElement getSubmitButton(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(submit));
        return x;
    }
    public WebElement getEnterAccount(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(enterAccount));
        return x;
    }
    public WebElement getError(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(error));
        return x;
    }
    public void setName(String username){
        getNameForm().sendKeys(username);
    }
    public void setemail(String usermail){
        getEmailForm().sendKeys(usermail);
    }
    public void setpass(String userpass){
        getPasswordForm().sendKeys(userpass);
    }

    public void register(String username, String usermail, String userpass){
        setName(username);
        setemail(usermail);
        setpass(userpass);
        getSubmitButton().click();
    }
    public void enterAccount(){
        getEnterAccount().click();
    }

    public String getPassError(){
        String x = getError().getText();
        return x;
    }
}
