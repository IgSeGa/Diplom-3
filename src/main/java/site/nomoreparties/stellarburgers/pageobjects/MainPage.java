package site.nomoreparties.stellarburgers.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
     WebDriver driver;

    private By mainPageButton = By.xpath("//button[contains(@class, \"button_button_size_large__G21Vg\")]");
    private By bunButton = By.xpath("(//div[contains(@class,\"tab_tab__1SPyG \")])[1]");
    private By sauceButton = By.xpath("(//div[contains(@class,\"tab_tab__1SPyG \")])[2]");
    private By ingredButton = By.xpath("(//div[contains(@class,\"tab_tab__1SPyG \")])[3]");
    private By selectedButton = By.xpath("//div[contains(@class,\"tab_tab_type_current__2BEPc\")]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getSelectedButton(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(selectedButton));
    }
    public WebElement mainPageButton(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(mainPageButton));
    }
    public WebElement getBunButton(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(bunButton));
    }
    public WebElement getSauceButton(){
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(sauceButton));
    }
    public WebElement getIngredButton() {
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(ingredButton));
    }
}
