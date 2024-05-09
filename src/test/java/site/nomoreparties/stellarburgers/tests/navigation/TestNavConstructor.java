package site.nomoreparties.stellarburgers.tests.navigation;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.tests.BaseTest;
import site.nomoreparties.stellarburgers.pageobjects.EnterAccount;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import site.nomoreparties.stellarburgers.pageobjects.Topline;

public class TestNavConstructor extends BaseTest{

    private WebDriver driver = getDriver();
    private EnterAccount objEnt = new EnterAccount(driver);
    private MainPage objMain = new MainPage(driver);
    private Topline objTop = new Topline(driver);


    @Before
    public void setUp(){
        createTestUser(TESTMAIL, TESTPASS, TESTNAME);
        driver.get(TESTURL);
    }
    @Step("Вход в систему")
    public void logIn(WebDriver driver) throws InterruptedException {
        objMain.mainPageButton().click();
        Assert.assertEquals("Войти", objEnt.submitButton().getText());
        Assert.assertEquals(TESTURL+"login", driver.getCurrentUrl());
        objEnt.enterAccount(TESTMAIL, TESTPASS);
        Assert.assertEquals("Оформить заказ", objMain.mainPageButton().getText());
        Assert.assertEquals(TESTURL, driver.getCurrentUrl());
    }
    @Step("Переход в личный кабинет")
    public void enterLK(WebDriver driver){
        objTop.clickLK();
        Assert.assertEquals(TESTURL+"account", driver.getCurrentUrl());
    }
    @Step("Переход к на главную через кнопку Конструктор")
    public void backToMainConst(WebDriver driver){
        objTop.getConstructor().click();
        Assert.assertEquals("Оформить заказ", objMain.mainPageButton().getText());
        Assert.assertEquals(TESTURL, driver.getCurrentUrl());
    }
    @Step("Переход к на главную через клик на логотип")
    public void backToMainLogo(WebDriver driver){
        objTop.getLogo().click();
        Assert.assertEquals("Оформить заказ", objMain.mainPageButton().getText());
        Assert.assertEquals(TESTURL, driver.getCurrentUrl());
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
