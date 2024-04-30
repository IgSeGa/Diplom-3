package site.nomoreparties.stellarburgers.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Topline {
    private WebDriver driver;
    public Topline(WebDriver driver){
        this.driver = driver;
    }
    private By topLogo = By.xpath("(//a[@href=\"/\"])[2]");
    private By constructor = By.xpath("(//a[@href=\"/\"])[1]");
    private By feed = By.xpath("//a[@href=\"/feed\"]");
    private By cabinetButton = By.xpath("//a[@href=\"/account\"]");

    public void clickLK(){
        driver.findElement(cabinetButton).click();
    }
    public void clickLogo(){
        driver.findElement(topLogo).click();
    }

}
