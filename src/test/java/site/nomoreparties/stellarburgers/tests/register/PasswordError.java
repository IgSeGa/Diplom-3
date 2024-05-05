package site.nomoreparties.stellarburgers.tests.register;
import com.google.acai.Acai;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.model.BaseTest;
import site.nomoreparties.stellarburgers.model.Constants;
import site.nomoreparties.stellarburgers.model.WebTestConfigModule;
import site.nomoreparties.stellarburgers.pageobjects.EnterAccount;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import site.nomoreparties.stellarburgers.pageobjects.RegisterPage;

import javax.inject.Inject;

public class PasswordError  extends BaseTest implements Constants {
    @Rule
    public Acai acai = new Acai(WebTestConfigModule.class);
    @Inject
    private WebDriver driver;

    public void enterLK(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        objMain.mainPageButton().click();
        checkString(TESTURL+"login", driver.getCurrentUrl());
    }
    public void goToRegister(WebDriver driver){
        EnterAccount objEnter = new EnterAccount(driver);
        objEnter.goToRegister();
        checkString(driver.getCurrentUrl(), TESTURL+"register");
    }
    public void checkRegisterError(WebDriver driver){
        RegisterPage objReg = new RegisterPage(driver);
        objReg.register(TESTNAME,TESTMAIL,"12345");
        checkString("Некорректный пароль", objReg.getPassError());
    }

    @Test
    public void testPassLenght(){
        driver.get(TESTURL);
        enterLK(driver);
        goToRegister(driver);
        checkRegisterError(driver);
    }
    @After
    public void clearUp(){
        driver.quit();
    }
}
