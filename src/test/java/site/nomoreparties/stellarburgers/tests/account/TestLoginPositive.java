package site.nomoreparties.stellarburgers.tests.account;
import com.google.acai.Acai;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import site.nomoreparties.stellarburgers.model.BaseTest;
import site.nomoreparties.stellarburgers.model.Constants;
import site.nomoreparties.stellarburgers.model.WebTestConfigModule;
import site.nomoreparties.stellarburgers.pageobjects.*;
import javax.inject.Inject;

public class TestLoginPositive extends BaseTest implements Constants {
    @Rule
    public Acai acai = new Acai(WebTestConfigModule.class);
    @Inject
    private WebDriver driver;

    @Before
    public void setUp(){
        createTestUser(TESTMAIL, TESTPASS, TESTNAME);
    }

    public void enterThroughTopline(WebDriver driver){
        Topline objTop = new Topline(driver);
        objTop.clickLK();
        checkString(TESTURL+"login", driver.getCurrentUrl());
    }
    public void enetrThroughButton(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        objMain.mainPageButton().click();
        checkString(TESTURL+"login", driver.getCurrentUrl());
    }
    public void enterThoughRegister(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        EnterAccount objEnter = new EnterAccount(driver);
        RegisterPage objReg = new RegisterPage(driver);
        objMain.mainPageButton().click();
        objEnter.goToRegister();
        objReg.enterAccount();
        checkString(TESTURL+"login", driver.getCurrentUrl());
    }
    public void enterThroughForgot(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        EnterAccount objEnter = new EnterAccount(driver);
        ForgotPassword objForgot = new ForgotPassword(driver);
        objMain.mainPageButton().click();
        objEnter.forgotPassword().click();
        objForgot.accountFromForgot().click();
        checkString(TESTURL+"login", driver.getCurrentUrl());

    }
    public void enterAccount(WebDriver driver) throws InterruptedException {
        EnterAccount objEnter = new EnterAccount(driver);
        MainPage objMain = new MainPage(driver);
        objEnter.enterAccount(TESTMAIL, TESTPASS);
        checkString("Оформить заказ", objMain.mainPageButton().getText());
        checkString(TESTURL, driver.getCurrentUrl());
    }

    @Test
    public void checkEnterMain() throws InterruptedException {
        driver.get(TESTURL);
        enetrThroughButton(driver);
        enterAccount(driver);
    }
    @Test
    public void checkEnterTop() throws InterruptedException {
        driver.get(TESTURL);
        enterThroughTopline(driver);
        enterAccount(driver);
    }
    @Test
    public void checkEnterForgot() throws InterruptedException {
        driver.get(TESTURL);
        enterThroughForgot(driver);
        enterAccount(driver);
    }
    @Test
    public void checkEnterRegister() throws InterruptedException {
        driver.get(TESTURL);
        enterThoughRegister(driver);
        enterAccount(driver);
    }
    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
