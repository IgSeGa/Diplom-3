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
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(constructor));
        return x;
    }
    public WebElement getLogo(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(topLogo));
        return x;
    }
    public WebElement getLK(){
        WebElement x = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(cabinetButton));
        return x;
    }
    public void clickLK(){
        getLK().click();
    }
    public void clickLogo(){
        getLogo().click();
    }
    public void clickConstructor(){
        getConstructor().click();
    }

}
