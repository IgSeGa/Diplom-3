package site.nomoreparties.stellarburgers.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private By mainPageButton = By.xpath("//button[contains(@class, \"button_button_size_large__G21Vg\")]");
    public By lastSuaceName = By.xpath("(//p[@class=\"BurgerIngredient_ingredient__text__yp3dH\"])[6]");
    public By fourthIngredName = By.xpath("(//p[@class=\"BurgerIngredient_ingredient__text__yp3dH\"])[10]");
    public By firstBun = By.cssSelector("[href=\"/ingredient/61c0c5a71d1f82001bdaaa6d\"]");
    public By bunButton = By.xpath("(//div[contains(@class,\"tab_tab__1SPyG \")])[1]");
    public By sauceButton = By.xpath("(//div[contains(@class,\"tab_tab__1SPyG \")])[2]");
    public By ingredButton = By.xpath("(//div[contains(@class,\"tab_tab__1SPyG \")])[3]");
    public By selectedButton = By.xpath("//div[contains(@class,\"tab_tab_type_current__2BEPc\")]");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSelectedButton(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(selectedButton));
        return x;
    }
    public WebElement mainPageButton(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(mainPageButton));
        return x;
    }
    public WebElement getLastSuaceName(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(lastSuaceName));
        return x;
    }
    public WebElement getFourthIngredName(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(fourthIngredName));
        return x;
    }
    public WebElement getFirstBun(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(firstBun));
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
