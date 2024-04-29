package site.nomoreparties.stellarburgers;
import org.openqa.selenium.By;

public class EnterAccount {
    private By login = By.xpath("//input[@name=\"name\"]");
    private By password = By.xpath("//input[@name=\"Пароль\"]");
    private By eyeButton = By.className("input__icon input__icon-action");
    private By submit = By.className("\"button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa\"");
    private By register = By.xpath("//a[@href=\"/register\"]");
}
