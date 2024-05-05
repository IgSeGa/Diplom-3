package site.nomoreparties.stellarburgers.tests.navigation;
import com.google.acai.Acai;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.model.BaseTest;
import site.nomoreparties.stellarburgers.model.Constants;
import site.nomoreparties.stellarburgers.model.WebTestConfigModule;
import site.nomoreparties.stellarburgers.pageobjects.Cabinet;
import site.nomoreparties.stellarburgers.pageobjects.EnterAccount;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import site.nomoreparties.stellarburgers.pageobjects.Topline;

import javax.inject.Inject;

public class TestNavCabinet extends BaseTest implements Constants {
    @Rule
    public Acai acai = new Acai(WebTestConfigModule.class);
    @Inject
    private WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
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
    public void checkUserData(WebDriver driver) {
        Cabinet objCab = new Cabinet(driver);
        checkString(TESTNAME, objCab.nameTest());
        checkString(TESTMAIL, objCab.emailTest());
    }

    @Test
    public void testNavCabinet() throws InterruptedException {
        driver.get(TESTURL);
        logIn(driver);
        enterLK(driver);
        checkUserData(driver);
    }
    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
