package site.nomoreparties.stellarburgers.model;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTestConfigModule  extends AbstractModule {
    @Provides
    ChromeOptions getChromeOptions(){
        return new ChromeOptions();
    }

    @Provides
    WebDriver getDriver(ChromeOptions options){
        String browserName = System.getProperty("browser");
        if (browserName != null && browserName.equals("yandex")){
            System.setProperty("webdriver.chrome.driver", "/Users/andreykhodyrev/ydriver/yandexdriver");
            WebDriver driver = new ChromeDriver();
        }
        return new ChromeDriver(options);
    }
}
