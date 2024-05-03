package site.nomoreparties.stellarburgers.tests.navigation;
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

public class TestNavCabinet extends BaseTest implements Constants {
    WebDriver driver = new ChromeDriver();
    Topline objTop = new Topline(driver);
    Cabinet objCab = new Cabinet(driver);
    MainPage objMain = new MainPage(driver);
    EnterAccount objEnt = new EnterAccount(driver);

    @Before
    public void setUp() throws InterruptedException {
        createTestUser(TESTMAIL, TESTPASS, TESTNAME);
    }
    public void logIn() throws InterruptedException {
        objMain.mainPageButton().click();
        objEnt.enterAccount(TESTMAIL, TESTPASS);
    }
    public void enterLK(){
        objTop.clickLK();
        checkString(TESTURL+"account", driver.getCurrentUrl());
    }
    public void checkUserData() {
        checkString(TESTNAME, objCab.nameTest());
        checkString(TESTMAIL, objCab.emailTest());
    }

    @Test
    public void testNavCabinet() throws InterruptedException {
        driver.get(TESTURL);
        logIn();
        enterLK();
        checkUserData();
    }
    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
