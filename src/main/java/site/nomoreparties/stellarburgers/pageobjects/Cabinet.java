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
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(name));
        return x;
    }
    public String nameTest(){
        String x = getName().getAttribute("Value").toString();
        return x;
    }
    public WebElement getMail(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(email));
        return x;
    }
    public WebElement getExit(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(exit));
        return x;
    }
    public String emailTest(){
        String x = getMail().getAttribute("Value").toString();
        return x;
    }
}
