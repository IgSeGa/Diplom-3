package site.nomoreparties.stellarburgers.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Cabinet {
    WebDriver driver;

    private By exit = By.xpath("//button[contains(text(), \"Выход\")]");
    private By name = By.xpath("(//div[contains(@class, \"input_status_disabled\")]//input)[1]");
    private By email = By.xpath("(//div[contains(@class, \"input_status_disabled\")]//input)[2]");

    public Cabinet(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getName(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(name));
    }
    public String nameTest(){
        return getName().getAttribute("Value").toString();
    }
    public WebElement getMail(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(email));
    }
    public WebElement getExit(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(exit));
    }
    public String emailTest(){
        return getMail().getAttribute("Value").toString();
    }
}
