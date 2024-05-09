package site.nomoreparties.stellarburgers.tests;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.setup.ForClearUp;
import site.nomoreparties.stellarburgers.setup.ForSetUp;
import static io.restassured.RestAssured.given;

public class BaseTest {
    public static final String TESTURL = "https://stellarburgers.nomoreparties.site/";
    public static final String TESTMAIL = "diplomauser@praktikum.ru";
    public static final String TESTPASS = "123456";
    public static final String TESTNAME = "Vasya";

    public void deleteTestUser(String email, String password){
        RestAssured.baseURI = TESTURL;
        ForClearUp login = new ForClearUp(email, password);
        String x = given().header("Content-type", "application/json")
                .and().body(login).post("api/auth/login").then().extract().body().path("accessToken");
        StringBuilder sb = new StringBuilder(x);
        sb.delete(0,7);
        String token = sb.toString();
        given().auth().oauth2(token).delete("api/auth/user").then().assertThat().statusCode(202);
    }
    public void createTestUser(String email, String password, String name){
        RestAssured.baseURI = TESTURL;
        ForSetUp params = new ForSetUp(email, password, name);
        given().header("Content-type", "application/json").and().body(params).post("api/auth/register")
                .then().assertThat().statusCode(200);
    }
    public WebDriver getDriver() {
        String broswerName = System.getProperty("browser");
        if (broswerName != null && broswerName.equals("yandex")){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
            return new ChromeDriver();
        }
        return new ChromeDriver();
    }
}
