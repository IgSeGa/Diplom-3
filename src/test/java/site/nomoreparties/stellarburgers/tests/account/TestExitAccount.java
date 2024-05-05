package site.nomoreparties.stellarburgers.tests.account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.model.BaseTest;
import site.nomoreparties.stellarburgers.model.Constants;
import site.nomoreparties.stellarburgers.pageobjects.Cabinet;
import site.nomoreparties.stellarburgers.pageobjects.EnterAccount;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import site.nomoreparties.stellarburgers.pageobjects.Topline;


public class TestExitAccount extends BaseTest implements Constants {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = getDriver();
        createTestUser(TESTMAIL, TESTPASS, TESTNAME);
    }
    public void logIn(WebDriver driver) throws InterruptedException {
        MainPage objMain = new MainPage(driver);
        EnterAccount objEnt = new EnterAccount(driver);
        objMain.mainPageButton().click();
        objEnt.enterAccount(TESTMAIL, TESTPASS);
    }
    public void enterLK(WebDriver driver){
        Topline objTop = new Topline(driver);
        Cabinet objCab = new Cabinet(driver);
        objTop.clickLK();
        checkString(TESTMAIL, objCab.emailTest());
    }
    public void exitLK(WebDriver driver) throws InterruptedException {
        Cabinet objCab = new Cabinet(driver);
        EnterAccount objEnt = new EnterAccount(driver);
        objCab.getExit().click();
        objEnt.userName();
        checkString(TESTURL+"login", driver.getCurrentUrl());
    }
    @Test
    public void testExit() throws InterruptedException {
        driver.get(TESTURL);
        logIn(driver);
        enterLK(driver);
        exitLK(driver);
    }
    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
