package site.nomoreparties.stellarburgers.tests.account;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.tests.BaseTest;
import site.nomoreparties.stellarburgers.pageobjects.*;

public class TestLoginPositive extends BaseTest{

    private WebDriver driver = getDriver();
    private Topline objTop = new Topline(driver);
    private EnterAccount objEnt = new EnterAccount(driver);
    private RegisterPage objReg = new RegisterPage(driver);
    private ForgotPassword objForg = new ForgotPassword(driver);
    private MainPage objMain = new MainPage(driver);
    private Cabinet objCab = new Cabinet(driver);

    @Before
    public void setUp(){
        createTestUser(TESTMAIL, TESTPASS, TESTNAME);
        driver.get(TESTURL);
    }
    @Step("Переход к авторизации через ЛК")
    public void enterThroughTopline(){
        objTop.clickLK();
        Assert.assertEquals("Войти", objEnt.submitButton().getText());
        Assert.assertEquals(TESTURL+"login", driver.getCurrentUrl());
    }
    @Step("Переход к авторизации через кнопку Войти")
    public void enetrThroughButton(){
        objMain.mainPageButton().click();
        Assert.assertEquals("Войти", objEnt.submitButton().getText());
        Assert.assertEquals(TESTURL+"login", driver.getCurrentUrl());
    }
    @Step("Переход к авторизации через форму регистрации")
    public void enterThoughRegister(){
        objMain.mainPageButton().click();
        objEnt.registerButton().click();
        objReg.enterAccount();
        Assert.assertEquals("Войти", objEnt.submitButton().getText());
        Assert.assertEquals(TESTURL+"login", driver.getCurrentUrl());
    }
    @Step("Переход к авторизации через восстановление пароля")
    public void enterThroughForgot(){
        objMain.mainPageButton().click();
        objEnt.forgotPassword().click();
        objForg.accountFromForgot().click();
        Assert.assertEquals("Войти", objEnt.submitButton().getText());
        Assert.assertEquals(TESTURL+"login", driver.getCurrentUrl());

    }
    @Step("Авторизация")
    public void enterAccount() {
        objEnt.enterAccount(TESTMAIL, TESTPASS);
        Assert.assertEquals("Оформить заказ", objMain.mainPageButton().getText());
        Assert.assertEquals(TESTURL, driver.getCurrentUrl());
    }
    @Step("Проверка данных аккаунта")
    public void checkAccountData(){
        objTop.clickLK();
        Assert.assertEquals(TESTMAIL,objCab.emailTest());
        Assert.assertEquals(TESTNAME, objCab.nameTest());
        Assert.assertEquals(TESTURL+"account/profile", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка авторизации через кнопку на главной")
    public void checkEnterMain() {
        enetrThroughButton();
        enterAccount();
        checkAccountData();
    }
    @Test
    @DisplayName("Проверка авторизации через кнопку ЛК")
    public void checkEnterTop() {
        enterThroughTopline();
        enterAccount();
        checkAccountData();
    }
    @Test
    @DisplayName("Проверка авторизации через восстановление пароля")
    public void checkEnterForgot() {
        enterThroughForgot();
        enterAccount();
        checkAccountData();
    }
    @Test
    @DisplayName("Проверка авторизации через страницу Регистрации")
    public void checkEnterRegister(){
        enterThoughRegister();
        enterAccount();
        checkAccountData();
    }
    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
