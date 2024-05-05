package site.nomoreparties.stellarburgers.tests.register;
import com.google.acai.Acai;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.model.WebTestConfigModule;
import site.nomoreparties.stellarburgers.pageobjects.*;
import site.nomoreparties.stellarburgers.model.BaseTest;
import site.nomoreparties.stellarburgers.model.Constants;
import javax.inject.Inject;

public class Register extends BaseTest implements Constants {
    @Rule
    public Acai acai = new Acai(WebTestConfigModule.class);
    @Inject
    private WebDriver driver;

    public void enterLK(WebDriver driver){
        Topline objTop = new Topline(driver);
        objTop.clickLK();
    }
    public void goBack(WebDriver driver){
        Topline objTop = new Topline(driver);
        objTop.clickLogo();
        checkString(driver.getCurrentUrl(), TESTURL);
    }
    public void clickEnter(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        objMain.mainPageButton().click();
    }
    public void goToRegister(WebDriver driver){
        EnterAccount objEnter = new EnterAccount(driver);
        objEnter.goToRegister();
    }
    public void register(WebDriver driver) throws InterruptedException {
        RegisterPage objReg = new RegisterPage(driver);
        EnterAccount objEnter = new EnterAccount(driver);
        objReg.register(TESTNAME,TESTMAIL,TESTPASS);
        objEnter.enterAccount(TESTMAIL, TESTPASS);
    }
    public void verifyRegister(WebDriver driver) throws InterruptedException {
        MainPage objMain = new MainPage(driver);
        Topline objTop = new Topline(driver);
        Cabinet objCab = new Cabinet(driver);
        checkString("Оформить заказ", objMain.mainPageButton().getText());
        objTop.clickLK();
        objCab.emailTest();
        objCab.nameTest();
    }

    @Test
    public void checkRegister() throws InterruptedException {
        driver.get(TESTURL);
        enterLK(driver);
        goBack(driver);
        clickEnter(driver);
        goToRegister(driver);
        register(driver);
        verifyRegister(driver);
    }
    @After
    public void clearUp(){
        deleteTestUser(TESTMAIL, TESTPASS);
        driver.quit();
    }
}
