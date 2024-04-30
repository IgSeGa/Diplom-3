package site.nomoreparties.stellarburgers.tests.login;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.model.BaseTest;
import site.nomoreparties.stellarburgers.model.Constants;
import site.nomoreparties.stellarburgers.pageobjects.EnterAccount;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;

@RunWith(Parameterized.class)
public class TestLoginPositive extends BaseTest implements Constants {
    WebDriver driver = new ChromeDriver();
    MainPage objMain = new MainPage(driver);
    EnterAccount objEnter = new EnterAccount(driver);

    private WebElement x;
    public TestLoginPositive(WebElement x){
        this.x = x;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {}
        };
    }
}
