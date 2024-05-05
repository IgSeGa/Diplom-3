package site.nomoreparties.stellarburgers.tests.navigation;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.model.BaseTest;
import site.nomoreparties.stellarburgers.model.TestData;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;

public class TestConstructorSections extends BaseTest implements TestData {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = getDriver();
        driver.get(TESTURL);
    }
    @Step("Проверка перехода к соусам по кнопке")
    public void gotToSauce(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        objMain.getSauceButton().click();
        compareString("Соусы", objMain.getSelectedButton().getText());
    }
    @Step("Проверка перехода к ингредиентам по кнопке")
    public void goToIngreds(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        objMain.getIngredButton().click();
        compareString("Начинки", objMain.getSelectedButton().getText());
    }
    @Step("Проверка перехода к булочкам по кнопке")
    public void gotToBuns(WebDriver driver){
        MainPage objMain = new MainPage(driver);
        objMain.getBunButton().click();
        compareString("Булки", objMain.getSelectedButton().getText());
    }
    @Step("Скролл до соусов")
    public void checkScrollToSauce(WebDriver driver) throws InterruptedException {
        MainPage objMain = new MainPage(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(objMain.getFirstSauce()));
        Thread.sleep(500);
        compareString("Соусы", objMain.getSelectedButton().getText());
    }
    @Step("Скролл до соусов")
    public void checkScrollToIngreds(WebDriver driver) throws InterruptedException {
        MainPage objMain = new MainPage(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(objMain.getFirstIngred()));
        Thread.sleep(500);
        compareString("Начинки", objMain.getSelectedButton().getText());
    }
    @Step("Скролл до булок")
    public void checkScrollToBuns(WebDriver driver) throws InterruptedException {
        MainPage objMain = new MainPage(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(objMain.getFirstBun()));
        Thread.sleep(500);
        compareString("Булки", objMain.getSelectedButton().getText());
    }
    @Test
    @DisplayName("Проверка перехода к разделам")
    public void testConstructor() throws InterruptedException {
        gotToSauce(driver);
        goToIngreds(driver);
        gotToBuns(driver);
        checkScrollToSauce(driver);
        checkScrollToIngreds(driver);
        checkScrollToBuns(driver);
    }
    @After
    public void clearUp(){
        driver.quit();
    }
}