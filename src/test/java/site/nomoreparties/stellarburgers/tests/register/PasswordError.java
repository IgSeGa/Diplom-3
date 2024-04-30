package site.nomoreparties.stellarburgers.tests.register;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.model.BaseTest;
import site.nomoreparties.stellarburgers.model.Constants;
import site.nomoreparties.stellarburgers.pageobjects.EnterAccount;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import site.nomoreparties.stellarburgers.pageobjects.RegisterPage;
import site.nomoreparties.stellarburgers.pageobjects.Topline;

public class PasswordError  extends BaseTest implements Constants {
    WebDriver driver = new ChromeDriver();
    MainPage objMain = new MainPage(driver);
    EnterAccount objEnter = new EnterAccount(driver);
    RegisterPage objReg = new RegisterPage(driver);
    Topline objTop = new Topline(driver);

    public void enterLK(){
        objMain.clickEnter();
        checkUrl(TESTURL+"login", driver.getCurrentUrl());
    }
    public void goToRegister(){
        objEnter.goToRegister();
        checkUrl(driver.getCurrentUrl(), TESTURL+"register");
    }
    public void checkRegisterError(){
        objReg.register(TESTNAME,TESTMAIL,"12345");
        checkFeature("Некорректный пароль", objReg.getPassError());
    }

    @Test
    public void testPassLenght(){
        driver.get(TESTURL);
        enterLK();
        goToRegister();
        checkRegisterError();
    }
    @After
    public void clearUp(){
        driver.quit();
    }
}
