package site.nomoreparties.stellarburgers.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    private By name = By.xpath("(//input[@name=\"name\"])[1]");
    private By email = By.xpath("(//input[@name=\"name\"])[2]");
    private By password = By.xpath("//input[@name=\"Пароль\"]");
    private By error = By.xpath("//p[contains(@class, \"input__error\")]");
    private By submit = By.xpath("//button[contains(@class, button_button_size_medium__3zxIa) and contains(text(), \"Зарегистрироваться\")]");
    public void setName(String username){
        driver.findElement(name).sendKeys(username);
    }
    public void setemail(String usermail){
        driver.findElement(email).sendKeys(usermail);
    }
    public void setpass(String userpass){
        driver.findElement(password).sendKeys(userpass);
    }

    public void register(String username, String usermail, String userpass){
        setName(username);
        setemail(usermail);
        setpass(userpass);
        driver.findElement(submit).click();
    }

    public String getPassError(){
        String x = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(error)).getText();
        return x;
    }
}
