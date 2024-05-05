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
    private By firstSuace = By.xpath("(//p[@class=\"BurgerIngredient_ingredient__text__yp3dH\"])[3]");
    private By firstIngred = By.xpath("(//p[@class=\"BurgerIngredient_ingredient__text__yp3dH\"])[7]");
    private By firstBun = By.xpath("//img[@alt=\"Флюоресцентная булка R2-D3\"]");
    private By bunButton = By.xpath("(//div[contains(@class,\"tab_tab__1SPyG \")])[1]");
    private By sauceButton = By.xpath("(//div[contains(@class,\"tab_tab__1SPyG \")])[2]");
    private By ingredButton = By.xpath("(//div[contains(@class,\"tab_tab__1SPyG \")])[3]");
    private By selectedButton = By.xpath("//div[contains(@class,\"tab_tab_type_current__2BEPc\")]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public By getFirstSauce(){
        return firstSuace;
    }
    public By getFirstBun(){
        return firstBun;
    }
    public By getFirstIngred(){
        return firstIngred;
    }

    public WebElement getSelectedButton(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(selectedButton));
        return x;
    }
    public WebElement mainPageButton(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(mainPageButton));
        return x;
    }
    public WebElement getBunButton(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(bunButton));
        return x;
    }
    public WebElement getSauceButton(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(sauceButton));
        return x;
    }
    public WebElement getIngredButton() {
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(ingredButton));
        return x;
    }
}
