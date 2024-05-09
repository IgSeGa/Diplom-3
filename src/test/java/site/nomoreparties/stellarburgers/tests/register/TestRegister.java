package site.nomoreparties.stellarburgers.tests.register;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.pageobjects.*;
import site.nomoreparties.stellarburgers.tests.BaseTest;

public class TestRegister extends BaseTest{
    private WebDriver driver = getDriver();
    private Topline objTop = new Topline(driver);
    private MainPage objMain = new MainPage(driver);
    private EnterAccount objEnt = new EnterAccount(driver);
    private Cabinet objCab = new Cabinet(driver);
    private RegisterPage objReg = new RegisterPage(driver);

    @Before
    public void setUp(){
        driver.get(TESTURL);
    }
    @Step("Переход к форме логина через шапку")
    public void enterLogin(){
        objTop.clickLK();
        Assert.assertEquals("Зарегистрироваться", objEnt.registerButton().getText());
        Assert.assertEquals(TESTURL+"login", driver.getCurrentUrl());
    }

    @Step("Переход к форме логина через кнопку на главной")
    public void clickEnter(){
        objMain.mainPageButton().click();
        Assert.assertEquals("Зарегистрироваться", objEnt.registerButton().getText());
        Assert.assertEquals(TESTURL+"login", driver.getCurrentUrl());
    }
    @Step("Переход к форме регистрации")
    public void goToRegister(){
        objEnt.registerButton().click();
        Assert.assertEquals("Зарегистрироваться", objReg.getSubmitButton().getText());
        Assert.assertEquals(TESTURL+"register", driver.getCurrentUrl());
    }
    @Step("Регистрация")
    public void register() {
        objReg.register(TESTNAME,TESTMAIL,TESTPASS);
        Assert.assertEquals("Войти", objEnt.submitButton().getText());
        Assert.assertEquals(TESTURL+"login", driver.getCurrentUrl());
        objEnt.enterAccount(TESTMAIL, TESTPASS);
    }
    @Step("Проверка данных зарегистрированного пользователя")
    public void verifyRegister() {
        Assert.assertEquals("Оформить заказ", objMain.mainPageButton().getText());
        objTop.clickLK();
        Assert.assertEquals(TESTMAIL, objCab.emailTest());
        Assert.assertEquals(TESTNAME, objCab.nameTest());
    }

    @Test
    @DisplayName("Проверка регистрации")
    public void checkRegisterViaMainPageButton() {
        enterLogin();
        driver.navigate().back();
        clickEnter();
        goToRegister();
        register();
        verifyRegister();
    }

    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
