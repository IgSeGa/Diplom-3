package site.nomoreparties.stellarburgers.model;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTestConfigModule  extends AbstractModule {
    @Provides
    WebDriver getDriver(){
        return new ChromeDriver();
    }
}
