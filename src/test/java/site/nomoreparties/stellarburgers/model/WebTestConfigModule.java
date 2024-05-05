package site.nomoreparties.stellarburgers.model;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTestConfigModule  extends AbstractModule {
    @Provides
    ChromeOptions getOptions(){
        return new ChromeOptions();
    }
    @Provides
    WebDriver getDriver() {
        String broswerName = System.getProperty("browser");
        if (broswerName != null && broswerName.equals("yandex")){
            System.setProperty("webdriver.chrome.driver", "C:/Webdriver/bin/yandexdriver.exe");
            return new ChromeDriver();
        }
        return new ChromeDriver();
    }
}
