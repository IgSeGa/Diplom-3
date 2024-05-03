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
        Assert.assertTrue(objMain.getLastSuaceName().isDisplayed());
    }
    public void goToIngreds(){
        objMain.getIngredButton().click();
        Assert.assertTrue(objMain.getFourthIngredName().isDisplayed());
    }
    public void gotToBuns(){
        objMain.getBunButton().click();
        Assert.assertTrue(objMain.getFirstBun().isDisplayed());
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