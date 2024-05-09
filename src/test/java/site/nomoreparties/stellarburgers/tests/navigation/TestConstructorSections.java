package site.nomoreparties.stellarburgers.tests.navigation;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.pageobjects.*;
import site.nomoreparties.stellarburgers.tests.BaseTest;

public class TestConstructorSections extends BaseTest {

    private WebDriver driver = getDriver();
    private MainPage objMain = new MainPage(driver);


    @Before
    public void setUp(){
        driver.get(TESTURL);
    }
    @Step("Проверка перехода к соусам по кнопке")
    public void gotToSauce(){
        objMain.getSauceButton().click();
        Assert.assertEquals("Соусы", objMain.getSelectedButton().getText());
    }
    @Step("Проверка перехода к ингредиентам по кнопке")
    public void goToIngreds(){
        objMain.getIngredButton().click();
        Assert.assertEquals("Начинки", objMain.getSelectedButton().getText());
    }
    @Step("Проверка перехода к булочкам по кнопке")
    public void gotToBuns(){
        objMain.getBunButton().click();
        Assert.assertEquals("Булки", objMain.getSelectedButton().getText());
    }
    @Test
    @DisplayName("Проверка перехода к разделам")
    public void testConstructorNavigation() throws InterruptedException {
        gotToSauce();
        goToIngreds();
        gotToBuns();
    }
    @After
    public void clearUp(){
        driver.quit();
    }
}