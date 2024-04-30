package site.nomoreparties.stellarburgers.tests.register;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.pageobjects.*;
import site.nomoreparties.stellarburgers.model.BaseTest;
import site.nomoreparties.stellarburgers.model.Constants;

public class Register extends BaseTest implements Constants {
    WebDriver driver = new ChromeDriver();
    MainPage objMain = new MainPage(driver);
    EnterAccount objEnter = new EnterAccount(driver);
    RegisterPage objReg = new RegisterPage(driver);
    Topline objTop = new Topline(driver);
    Cabinet objCab = new Cabinet(driver);

    public void enterLK(){
        objTop.clickLK();
//        checkUrl(driver.getCurrentUrl(), TESTURL+"login");
    }
    public void goBack(){
        objTop.clickLogo();
        checkUrl(driver.getCurrentUrl(), TESTURL);
    }
    public void clickEnter(){
        objMain.clickEnter();
//        checkUrl(driver.getCurrentUrl(), TESTURL+"login");
    }
    public void goToRegister(){
        objEnter.goToRegister();
//        checkUrl(driver.getCurrentUrl(), TESTURL+"register");
    }
    public void register() throws InterruptedException {
        objReg.register(TESTNAME,TESTMAIL,TESTPASS);
        objEnter.enterAccount(TESTMAIL, TESTPASS);
    }
    public void verifyRegister() throws InterruptedException {
        enterLK();
        Thread.sleep(1000);
        objCab.checkText();
//        checkUrl(driver.getCurrentUrl(), TESTURL+"account/profile");
        checkFeature(TESTMAIL, objCab.emailTest());
        checkFeature(TESTNAME, objCab.nameTest());
    }

    @Test
    public void checkRegister() throws InterruptedException {
        driver.get(TESTURL);
        enterLK();
        goBack();
        clickEnter();
        goToRegister();
        register();
        verifyRegister();
    }
    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
