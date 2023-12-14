package serenityswag.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginFormPage extends PageObject {

    public static By USER_NAME = By.name("user-name");
    public static By PASSWORD = By.name("password");
    public static By LOGIN_BUTTON = By.name("login-button");

}
