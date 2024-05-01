package site.nomoreparties.stellarburgers.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cabinet {
    private WebDriver driver;
    public Cabinet(WebDriver driver){
        this.driver = driver;
    }
    private By profile = By.xpath("//a[@href=\"/account/profile\"]");
    private By history = By.xpath("//a[@href=\"/account/order-history\"]");
    private By exit = By.xpath("//button[contains(text(), \"Выход\")]");
    private By name = By.xpath("(//div[contains(@class, \"input_status_disabled\")])[1]//input");
    private By email = By.xpath("(//div[contains(@class, \"input_status_disabled\")])[2]");
    private By message = By.xpath("//p[contains(@class, \"Account_text__fZAIn\")]");
//    public String historyTest(){
//        String x = driver.findElement(history).getText();
//        return x;
//    }
    public String nameTest(){
        String x = driver.findElement(name).getAttribute("value").toString();
        return x;
    }
    public String emailTest(){
        String x = driver.findElement(email).getAttribute("value").toString();
        return x;
    }
    public String checkText(){
        String x = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(message)).getText();
        return x;
    }
}
