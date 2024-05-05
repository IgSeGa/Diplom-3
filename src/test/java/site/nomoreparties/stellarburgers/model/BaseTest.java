package site.nomoreparties.stellarburgers.model;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import site.nomoreparties.stellarburgers.setup.ForClearUp;
import site.nomoreparties.stellarburgers.setup.ForSetUp;
import org.openqa.selenium.WebDriver;

import static io.restassured.RestAssured.given;

public class BaseTest implements Constants {

    public void checkString(String string1, String string2){
        Assert.assertEquals(string1, string2);
    }
    public void deleteTestUser(String email, String password){
        RestAssured.baseURI = TESTURL;
        ForClearUp login = new ForClearUp(email, password);
        String x = given().header("Content-type", "application/json")
                .and().body(login).post("api/auth/login").then().extract().body().path("accessToken");
        StringBuilder sb = new StringBuilder(x);
        sb.delete(0,7);
        String token = sb.toString();;
        given().auth().oauth2(token).delete("api/auth/user").then().assertThat().statusCode(202);
    }
    public void createTestUser(String email, String password, String name){
        RestAssured.baseURI = TESTURL;
        ForSetUp params = new ForSetUp(email, password, name);
        given().header("Content-type", "application/json").and().body(params).post("api/auth/register")
                .then().assertThat().statusCode(200);
    }

}
