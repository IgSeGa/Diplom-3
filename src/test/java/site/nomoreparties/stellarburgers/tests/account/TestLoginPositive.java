package site.nomoreparties.stellarburgers.tests.account;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.model.BaseTest;
import site.nomoreparties.stellarburgers.model.TestData;
import site.nomoreparties.stellarburgers.pageobjects.*;

public class TestLoginPositive extends BaseTest implements TestData {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = getDriver();
        createTestUser(TESTMAIL, TESTPASS, TESTNAME);
        driver.get(TESTURL);
    }
    @Step("Переход к авторизации через ЛК")
    public void enterThroughTopline(WebDriver driver){
        Topline objTop = new Topline(driver);
        EnterAccount objEnter = new EnterAccount(driver);
        objTop.clickLK();
        compareString("Войти", objEnter.submitButton().getText());
        compareString(TESTURL+"login", driver.getCurrentUrl());
    }
    @Step("Переход к авторизации через кнопку Войти")
    public void enetrThroughButton(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        EnterAccount objEnter = new EnterAccount(driver);
        objMain.mainPageButton().click();
        compareString("Войти", objEnter.submitButton().getText());
        compareString(TESTURL+"login", driver.getCurrentUrl());
    }
    @Step("Переход к авторизации через форму регистрации")
    public void enterThoughRegister(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        EnterAccount objEnter = new EnterAccount(driver);
        RegisterPage objReg = new RegisterPage(driver);
        objMain.mainPageButton().click();
        objEnter.registerButton().click();
        objReg.enterAccount();
        compareString("Войти", objEnter.submitButton().getText());
        compareString(TESTURL+"login", driver.getCurrentUrl());
    }
    @Step("Переход к авторизации через восстановление пароля")
    public void enterThroughForgot(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        EnterAccount objEnter = new EnterAccount(driver);
        ForgotPassword objForgot = new ForgotPassword(driver);
        objMain.mainPageButton().click();
        objEnter.forgotPassword().click();
        objForgot.accountFromForgot().click();
        compareString("Войти", objEnter.submitButton().getText());
        compareString(TESTURL+"login", driver.getCurrentUrl());

    }
    @Step("Авторизация")
    public void enterAccount(WebDriver driver) {
        EnterAccount objEnter = new EnterAccount(driver);
        MainPage objMain = new MainPage(driver);
        objEnter.enterAccount(TESTMAIL, TESTPASS);
        compareString("Оформить заказ", objMain.mainPageButton().getText());
        compareString(TESTURL, driver.getCurrentUrl());
    }
    @Step("Проверка данных аккаунта")
    public void checkAccountData(WebDriver driver){
        Topline objTop = new Topline(driver);
        Cabinet objCab = new Cabinet(driver);
        objTop.clickLK();
        compareString(TESTMAIL,objCab.emailTest());
        compareString(TESTNAME, objCab.nameTest());
        compareString(TESTURL+"account/profile", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка авторизации через кнопку на главной")
    public void checkEnterMain() {
        enetrThroughButton(driver);
        enterAccount(driver);
        checkAccountData(driver);
    }
    @Test
    @DisplayName("Проверка авторизации через кнопку ЛК")
    public void checkEnterTop() {
        enterThroughTopline(driver);
        enterAccount(driver);
        checkAccountData(driver);
    }
    @Test
    @DisplayName("Проверка авторизации через восстановление пароля")
    public void checkEnterForgot() {
        enterThroughForgot(driver);
        enterAccount(driver);
        checkAccountData(driver);
    }
    @Test
    @DisplayName("Проверка авторизации через страницу Регистрации")
    public void checkEnterRegister(){
        enterThoughRegister(driver);
        enterAccount(driver);
        checkAccountData(driver);
    }
    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
