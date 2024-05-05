package site.nomoreparties.stellarburgers.tests.register;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.model.BaseTest;
import site.nomoreparties.stellarburgers.model.TestData;
import site.nomoreparties.stellarburgers.pageobjects.EnterAccount;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import site.nomoreparties.stellarburgers.pageobjects.RegisterPage;

public class TestPasswordError extends BaseTest implements TestData {

    private WebDriver driver;
    @Before
    public void setUp(){
        driver = getDriver();
        driver.get(TESTURL);
    }
    @Step("Переход к форме логина")
    public void enterLK(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        EnterAccount objEnt = new EnterAccount(driver);
        objMain.mainPageButton().click();
        compareString("Войти", objEnt.submitButton().getText());
        compareString(TESTURL+"login", driver.getCurrentUrl());
    }
    @Step("Переход к форме регистрации")
    public void goToRegister(WebDriver driver){
        EnterAccount objEnter = new EnterAccount(driver);
        objEnter.registerButton().click();
        compareString(driver.getCurrentUrl(), TESTURL+"register");
    }
    @Step("Проверка сообщения об ошибке пароля")
    public void checkRegisterError(WebDriver driver){
        RegisterPage objReg = new RegisterPage(driver);
        objReg.register(TESTNAME,TESTMAIL,"12345");
        compareString("Некорректный пароль", objReg.getPassError());
    }

    @Test
    @DisplayName("Проверка вызова ошибки пароля")
    public void testPassLenght(){
        enterLK(driver);
        goToRegister(driver);
        checkRegisterError(driver);
    }
    @After
    public void clearUp(){
        driver.quit();
    }
}
