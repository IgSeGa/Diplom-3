package site.nomoreparties.stellarburgers.tests.navigation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.model.Constants;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;

public class TestConstructorSections implements Constants {
    WebDriver driver = new ChromeDriver();
    MainPage objMain = new MainPage(driver);

    public void gotToSauce(){
        objMain.getSauceButton().click();
        Assert.assertEquals("Соусы", objMain.getSelectedButton().getText());
    }
    public void goToIngreds(){
        objMain.getIngredButton().click();
        Assert.assertEquals("Начинки", objMain.getSelectedButton().getText());
    }
    public void gotToBuns(){
        objMain.getBunButton().click();
        Assert.assertTrue(objMain.getFirstBun().isDisplayed());
        Assert.assertEquals("Булки", objMain.getSelectedButton().getText());
    }
    @Test
    public void testConstructor() {
        driver.get(TESTURL);
        gotToSauce();
        goToIngreds();
        gotToBuns();
    }
    @After
    public void clearUp(){
        driver.quit();
    }
}