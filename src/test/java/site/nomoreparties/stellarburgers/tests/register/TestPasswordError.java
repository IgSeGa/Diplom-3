package site.nomoreparties.stellarburgers.tests.register;
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
import site.nomoreparties.stellarburgers.pageobjects.RegisterPage;

public class TestPasswordError extends BaseTest{

    private WebDriver driver = getDriver();
    private MainPage objMain = new MainPage(driver);
    private EnterAccount objEnt = new EnterAccount(driver);
    private RegisterPage objReg = new RegisterPage(driver);

    @Before
    public void setUp(){
        driver.get(TESTURL);
    }
    @Step("Переход к форме логина")
    public void enterLK(){
        objMain.mainPageButton().click();
        Assert.assertEquals("Войти", objEnt.submitButton().getText());
        Assert.assertEquals(TESTURL+"login", driver.getCurrentUrl());
    }
    @Step("Переход к форме регистрации")
    public void goToRegister(){
        objEnt.registerButton().click();
        Assert.assertEquals(driver.getCurrentUrl(), TESTURL+"register");
    }
    @Step("Проверка сообщения об ошибке пароля")
    public void checkRegisterError(){
        objReg.register(TESTNAME,TESTMAIL,"12345");
        Assert.assertEquals("Некорректный пароль", objReg.getPassError());
    }

    @Test
    @DisplayName("Проверка вызова ошибки пароля")
    public void testPassLength(){
        enterLK();
        goToRegister();
        checkRegisterError();
    }
    @After
    public void clearUp(){
        driver.quit();
    }
}
