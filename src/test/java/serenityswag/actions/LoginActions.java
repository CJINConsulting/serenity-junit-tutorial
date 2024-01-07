package serenityswag.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.core.Serenity;
import org.fluentlenium.core.annotation.Page;
import serenityswag.authentication.User;
import serenityswag.pages.LoginFormPage;

public class LoginActions extends UIInteractionSteps {

    @Step("Login as {0}")
    public void as(User user) {

        openUrl("https://www.saucedemo.com/");

        // Login as a standard user
        $(LoginFormPage.USER_NAME).sendKeys("standard_user");
        $(LoginFormPage.PASSWORD).sendKeys(user.getPassword());
        $(LoginFormPage.LOGIN_BUTTON).click();

        // $("[data-test='username']").sendKeys(user.getUsername());
        // $("[data-test='password']").sendKeys(user.getPassword());
        // $("[data-test='login-button']").click();

        // find by ID (using UI Interactions)
        // find(By.id("username")).sendKeys("standard_user");
        // $(By.id("username")).sendKeys("standard_user");
        // find("#username").sendKeys("standard_user");
        // $("#username").sendKeys("standard_user");

        // find by Name (using UI Interactions)
        // find(By.name("username")).sendKeys("standard_user");
        // $(By.name("username")).sendKeys("standard_user");
        // find("[name=username]").sendKeys("standard_user");
        // $("[name=username]").sendKeys("standard_user");

        // using UIInteractions extension methods

        //find("[data-test='username']").sendKeys("standard_user");
        //find("[data-test='password']").sendKeys("secret_sauce");
        //find("[data-test='login-button']").click();

        // using the driver directly

        //driver.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
        //driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        //driver.findElement(By.cssSelector("[data-test='login-button']")).click();
    }
}
