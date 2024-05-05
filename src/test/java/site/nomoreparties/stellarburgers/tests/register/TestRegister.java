package site.nomoreparties.stellarburgers.tests.register;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.pageobjects.*;
import site.nomoreparties.stellarburgers.model.BaseTest;
import site.nomoreparties.stellarburgers.model.TestData;

public class TestRegister extends BaseTest implements TestData {

    private WebDriver driver;
    @Before
    public void setUp(){
        driver = getDriver();
        driver.get(TESTURL);
    }
    @Step("Переход к форме логина через шапку")
    public void enterLogin(WebDriver driver){
        Topline objTop = new Topline(driver);
        EnterAccount objEnt = new EnterAccount(driver);
        objTop.clickLK();
        compareString("Зарегистрироваться", objEnt.registerButton().getText());
        compareString(TESTURL+"login", driver.getCurrentUrl());
    }

    @Step("Переход к форме логина через кнопку на главной")
    public void clickEnter(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        EnterAccount objEnt = new EnterAccount(driver);
        objMain.mainPageButton().click();
        compareString("Зарегистрироваться", objEnt.registerButton().getText());
        compareString(TESTURL+"login", driver.getCurrentUrl());
    }
    @Step("Переход к форме регистрации")
    public void goToRegister(WebDriver driver){
        EnterAccount objEnter = new EnterAccount(driver);
        RegisterPage objReg = new RegisterPage(driver);
        objEnter.registerButton().click();
        compareString("Зарегистрироваться", objReg.getSubmitButton().getText());
        compareString(TESTURL+"register", driver.getCurrentUrl());
    }
    @Step("Регистрация")
    public void register(WebDriver driver) {
        RegisterPage objReg = new RegisterPage(driver);
        EnterAccount objEnter = new EnterAccount(driver);
        objReg.register(TESTNAME,TESTMAIL,TESTPASS);
        compareString("Войти", objEnter.submitButton().getText());
        compareString(TESTURL+"login", driver.getCurrentUrl());
        objEnter.enterAccount(TESTMAIL, TESTPASS);
    }
    @Step("Проверка данных зарегистрированного пользователя")
    public void verifyRegister(WebDriver driver) {
        MainPage objMain = new MainPage(driver);
        Topline objTop = new Topline(driver);
        Cabinet objCab = new Cabinet(driver);
        compareString("Оформить заказ", objMain.mainPageButton().getText());
        objTop.clickLK();
        compareString(TESTMAIL, objCab.emailTest());
        compareString(TESTNAME, objCab.nameTest());
    }

    @Test
    @DisplayName("Проверка регистрации")
    public void checkRegisterViaMainPageButton() {
        enterLogin(driver);
        driver.navigate().back();
        clickEnter(driver);
        goToRegister(driver);
        register(driver);
        verifyRegister(driver);
    }

    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
