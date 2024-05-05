package site.nomoreparties.stellarburgers.tests.navigation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.model.BaseTest;
import site.nomoreparties.stellarburgers.model.Constants;
import site.nomoreparties.stellarburgers.pageobjects.EnterAccount;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import site.nomoreparties.stellarburgers.pageobjects.Topline;

public class TestNavConstructor extends BaseTest implements Constants {

    private WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        driver = getDriver();
        createTestUser(TESTMAIL, TESTPASS, TESTNAME);
    }
    public void logIn(WebDriver driver) throws InterruptedException {
        EnterAccount objEnt = new EnterAccount(driver);
        MainPage objMain = new MainPage(driver);
        objMain.mainPageButton().click();
        objEnt.enterAccount(TESTMAIL, TESTPASS);
    }
    public void enterLK(WebDriver driver){
        Topline objTop = new Topline(driver);
        objTop.clickLK();
        checkString(TESTURL+"account", driver.getCurrentUrl());
    }

    public void backToMainConst(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        Topline objTop = new Topline(driver);
        objTop.getConstructor().click();
        checkString("Оформить заказ", objMain.mainPageButton().getText());
        checkString(TESTURL, driver.getCurrentUrl());
    }
    public void backToMainLogo(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        Topline objTop = new Topline(driver);
        objTop.getLogo().click();
        checkString("Оформить заказ", objMain.mainPageButton().getText());
        checkString(TESTURL, driver.getCurrentUrl());
    }
    @Test
    public void testNavToLogo() throws InterruptedException {
        driver.get(TESTURL);
        logIn(driver);
        enterLK(driver);
        backToMainLogo(driver);
    }
    @Test
    public void testNavToConstructor() throws InterruptedException {
        driver.get(TESTURL);
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
