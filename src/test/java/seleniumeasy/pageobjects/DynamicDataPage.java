package seleniumeasy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class DynamicDataPage extends SeleniumEasyForm {

    private static final By USER_DETAILS_PANEL = By.id("loading");
    public void getNewUser() {
        $(FormButton.withLabel("Get New User")).click();
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(
                invisibilityOfElementWithText(USER_DETAILS_PANEL, "loading...")
        );
    }

    public String userDescription() {
        return $(USER_DETAILS_PANEL).getText();
    }
}
