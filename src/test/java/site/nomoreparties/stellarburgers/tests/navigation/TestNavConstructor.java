package site.nomoreparties.stellarburgers.tests.navigation;
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
import site.nomoreparties.stellarburgers.pageobjects.Topline;

public class TestNavConstructor extends BaseTest implements TestData {

    private WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        driver = getDriver();
        createTestUser(TESTMAIL, TESTPASS, TESTNAME);
        driver.get(TESTURL);
    }
    @Step("Вход в систему")
    public void logIn(WebDriver driver) throws InterruptedException {
        EnterAccount objEnt = new EnterAccount(driver);
        MainPage objMain = new MainPage(driver);
        objMain.mainPageButton().click();
        compareString("Войти", objEnt.submitButton().getText());
        compareString(TESTURL+"login", driver.getCurrentUrl());
        objEnt.enterAccount(TESTMAIL, TESTPASS);
        compareString("Оформить заказ", objMain.mainPageButton().getText());
        compareString(TESTURL, driver.getCurrentUrl());
    }
    @Step("Переход в личный кабинет")
    public void enterLK(WebDriver driver){
        Topline objTop = new Topline(driver);
        objTop.clickLK();
        compareString(TESTURL+"account", driver.getCurrentUrl());
    }
    @Step("Переход к на главную через кнопку Конструктор")
    public void backToMainConst(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        Topline objTop = new Topline(driver);
        objTop.getConstructor().click();
        compareString("Оформить заказ", objMain.mainPageButton().getText());
        compareString(TESTURL, driver.getCurrentUrl());
    }
    @Step("Переход к на главную через клик на логотип")
    public void backToMainLogo(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        Topline objTop = new Topline(driver);
        objTop.getLogo().click();
        compareString("Оформить заказ", objMain.mainPageButton().getText());
        compareString(TESTURL, driver.getCurrentUrl());
    }
    @Test
    @DisplayName("Переход к главной через лого")
    public void testNavToLogo() throws InterruptedException {
        logIn(driver);
        enterLK(driver);
        backToMainLogo(driver);
    }
    @Test
    @DisplayName("Переход к главной через конструктор")
    public void testNavToConstructor() throws InterruptedException {
        logIn(driver);
        enterLK(driver);
        backToMainConst(driver);
    }
    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
