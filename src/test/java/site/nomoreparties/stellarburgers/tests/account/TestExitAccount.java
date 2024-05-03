package site.nomoreparties.stellarburgers.tests.account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.model.BaseTest;
import site.nomoreparties.stellarburgers.model.Constants;
import site.nomoreparties.stellarburgers.pageobjects.Cabinet;
import site.nomoreparties.stellarburgers.pageobjects.EnterAccount;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import site.nomoreparties.stellarburgers.pageobjects.Topline;

public class TestExitAccount extends BaseTest implements Constants {
    WebDriver driver = new ChromeDriver();
    MainPage objMain = new MainPage(driver);
    EnterAccount objEnt = new EnterAccount(driver);
    Topline objTop = new Topline(driver);
    Cabinet objCab = new Cabinet(driver);

    @Before
    public void setUp(){
        createTestUser(TESTMAIL, TESTPASS, TESTNAME);
    }
    public void logIn() throws InterruptedException {
        objMain.mainPageButton().click();
        objEnt.enterAccount(TESTMAIL, TESTPASS);
    }
    public void enterLK(){
        objTop.clickLK();
        checkString(TESTMAIL, objCab.emailTest());
    }
    public void exitLK() throws InterruptedException {
        objCab.getExit().click();
        objEnt.userName();
        checkString(TESTURL+"login", driver.getCurrentUrl());
    }
    @Test
    public void testExit() throws InterruptedException {
        driver.get(TESTURL);
        logIn();
        enterLK();
        exitLK();
    }
    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
