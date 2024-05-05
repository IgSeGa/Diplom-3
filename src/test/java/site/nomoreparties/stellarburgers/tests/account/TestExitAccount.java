package site.nomoreparties.stellarburgers.tests.account;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.model.BaseTest;
import site.nomoreparties.stellarburgers.model.TestData;
import site.nomoreparties.stellarburgers.pageobjects.Cabinet;
import site.nomoreparties.stellarburgers.pageobjects.EnterAccount;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import site.nomoreparties.stellarburgers.pageobjects.Topline;


public class TestExitAccount extends BaseTest implements TestData {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = getDriver();
        createTestUser(TESTMAIL, TESTPASS, TESTNAME);
    }

    @Step("Вход в аккаунт")
    public void logIn(WebDriver driver) {
        MainPage objMain = new MainPage(driver);
        EnterAccount objEnt = new EnterAccount(driver);
        objMain.mainPageButton().click();
        compareString("Войти", objEnt.submitButton().getText());
        objEnt.enterAccount(TESTMAIL, TESTPASS);
    }
    @Step("Вход в личный кабинет")
    public void enterLK(WebDriver driver){
        Topline objTop = new Topline(driver);
        Cabinet objCab = new Cabinet(driver);
        objTop.clickLK();
        compareString(TESTMAIL, objCab.emailTest());
    }
    @Step("Выход из учетной записи")
    public void exitAcoount(WebDriver driver) {
        Cabinet objCab = new Cabinet(driver);
        EnterAccount objEnt = new EnterAccount(driver);
        objCab.getExit().click();
        compareString("Войти", objEnt.submitButton().getText());
        compareString(TESTURL+"login", driver.getCurrentUrl());
    }
    @Test
    @DisplayName("Проверка выхода из аккаунта")
    public void testExit() {
        driver.get(TESTURL);
        logIn(driver);
        enterLK(driver);
        exitAcoount(driver);
    }
    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
