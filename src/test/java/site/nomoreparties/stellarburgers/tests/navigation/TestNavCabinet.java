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

public class TestNavCabinet extends BaseTest implements TestData {

    private WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        driver = getDriver();
        createTestUser(TESTMAIL, TESTPASS, TESTNAME);
        driver.get(TESTURL);
    }
    @Step("Логин пользователя")
    public void logIn(WebDriver driver) {
        EnterAccount objEnt = new EnterAccount(driver);
        MainPage objMain = new MainPage(driver);
        objMain.mainPageButton().click();
        compareString("Войти", objEnt.submitButton().getText());
        compareString(TESTURL+"login", driver.getCurrentUrl());
        objEnt.enterAccount(TESTMAIL, TESTPASS);
        compareString("Оформить заказ", objMain.mainPageButton().getText());
        compareString(TESTURL, driver.getCurrentUrl());
    }
    @Step("Вход в личный Кабинет")
    public void enterLK(WebDriver driver){
        Topline objTop = new Topline(driver);
        objTop.clickLK();
        compareString(TESTURL+"account", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет с главной страницы")
    public void testNavCabinet() throws InterruptedException {
        logIn(driver);
        enterLK(driver);
    }
    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
