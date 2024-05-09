package site.nomoreparties.stellarburgers.tests.account;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.tests.BaseTest;
import site.nomoreparties.stellarburgers.pageobjects.Cabinet;
import site.nomoreparties.stellarburgers.pageobjects.EnterAccount;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import site.nomoreparties.stellarburgers.pageobjects.Topline;


public class TestExitAccount extends BaseTest {
    private WebDriver driver = getDriver();
    private MainPage objMain = new MainPage(driver);
    private Topline objTop = new Topline(driver);
    private EnterAccount objEnt = new EnterAccount(driver);
    private Cabinet objCab = new Cabinet(driver);

    @Before
    public void setUp(){
        createTestUser(TESTMAIL, TESTPASS, TESTNAME);
        driver.get(TESTURL);
    }

    @Step("Вход в аккаунт")
    public void logIn() {
        objMain.mainPageButton().click();
        Assert.assertEquals("Войти",objEnt.submitButton().getText());
        objEnt.enterAccount(TESTMAIL, TESTPASS);
    }
    @Step("Вход в личный кабинет")
    public void enterLK(){
        objTop.clickLK();
        Assert.assertEquals(TESTMAIL, objCab.emailTest());
    }
    @Step("Выход из учетной записи")
    public void exitAcoount() {
        objCab.getExit().click();
        Assert.assertEquals("Войти", objEnt.submitButton().getText());
        Assert.assertEquals(TESTURL+"login", driver.getCurrentUrl());
    }
    @Test
    @DisplayName("Проверка выхода из аккаунта")
    public void testExit() {
        logIn();
        enterLK();
        exitAcoount();
    }
    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
