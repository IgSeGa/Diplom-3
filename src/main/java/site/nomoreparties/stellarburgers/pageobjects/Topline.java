package site.nomoreparties.stellarburgers.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Topline {
    private WebDriver driver;
    public Topline(WebDriver driver){
        this.driver = driver;
    }
    private By topLogo = By.xpath("(//a[@href=\"/\"])[2]");
    private By constructor = By.xpath("(//a[@href=\"/\"])[1]");
    private By cabinetButton = By.xpath("//a[@href=\"/account\"]");

    public WebElement getConstructor(){
        return  new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(constructor));
    }
    public WebElement getLogo(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(topLogo));
    }
    public WebElement getLK(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(cabinetButton));
    }
    public void clickLK(){
        getLK().click();
    }

}
