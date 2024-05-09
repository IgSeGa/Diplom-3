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

public class TestNavCabinet extends BaseTest {

    private WebDriver driver = getDriver();
    private EnterAccount objEnt = new EnterAccount(driver);
    private MainPage objMain = new MainPage(driver);
    private Topline objTop = new Topline(driver);

    @Before
    public void setUp() {
        driver.get(TESTURL);
        createTestUser(TESTMAIL, TESTPASS, TESTNAME);
    }
    @Step("Логин пользователя")
    public void logIn(WebDriver driver) {

        objMain.mainPageButton().click();
        Assert.assertEquals("Войти", objEnt.submitButton().getText());
        Assert.assertEquals(TESTURL+"login", driver.getCurrentUrl());
        objEnt.enterAccount(TESTMAIL, TESTPASS);
        Assert.assertEquals("Оформить заказ", objMain.mainPageButton().getText());
        Assert.assertEquals(TESTURL, driver.getCurrentUrl());
    }
    @Step("Вход в личный Кабинет")
    public void enterLK(WebDriver driver){
        objTop.clickLK();
        Assert.assertEquals(TESTURL+"account", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет с главной страницы")
    public void testNavCabinet() {
        logIn(driver);
        enterLK(driver);
    }
    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
