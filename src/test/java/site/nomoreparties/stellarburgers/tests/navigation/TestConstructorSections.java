package site.nomoreparties.stellarburgers.tests.navigation;
import com.google.acai.Acai;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.model.Constants;
import site.nomoreparties.stellarburgers.model.WebTestConfigModule;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;

import javax.inject.Inject;

public class TestConstructorSections implements Constants {
    @Rule
    public Acai acai = new Acai(WebTestConfigModule.class);
    @Inject
    private WebDriver driver;

    public void gotToSauce(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        objMain.getSauceButton().click();
        Assert.assertEquals("Соусы", objMain.getSelectedButton().getText());
    }
    public void goToIngreds(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        objMain.getIngredButton().click();
        Assert.assertEquals("Начинки", objMain.getSelectedButton().getText());
    }

    public void gotToBuns(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        objMain.getBunButton().click();
        Assert.assertTrue(objMain.getFirstBun().isDisplayed());
        Assert.assertEquals("Булки", objMain.getSelectedButton().getText());
    }
    @Test
    public void testConstructor() {
        driver.get(TESTURL);
        gotToSauce(driver);
        goToIngreds(driver);
        gotToBuns(driver);
    }
    @After
    public void clearUp(){
        driver.quit();
    }
}