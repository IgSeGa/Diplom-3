package site.nomoreparties.stellarburgers.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ForgotPassword {
    private WebDriver driver;
    public ForgotPassword(WebDriver driver){
        this.driver = driver;
    }
    private By enterAccount = By.xpath("//a[@href=\"/login\"]");

    public WebElement accountFromForgot(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(enterAccount));
        return x;
    }
}
