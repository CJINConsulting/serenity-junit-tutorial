package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;

import java.time.Duration;

public class AlertMessagePage extends SeleniumEasyForm {

    public static final By AUTOCLOSEABLE_SUCCESS_MESSAGE = By.id("autoclosable-btn-success");
    public static final By AUTOCLOSEABLE_SUCCESS_ALERT = By.className("alert-autocloseable-success");

    public void openAutocloseableSuccessMessage() {
        $(AUTOCLOSEABLE_SUCCESS_MESSAGE).click();
    }

    public String autocloseableSuccessAlertMessageText() {
        return $(AUTOCLOSEABLE_SUCCESS_ALERT).getText();
    }

    public WebElementState autocloseableSuccessAlert() {
        return $(AUTOCLOSEABLE_SUCCESS_ALERT);
    }

    public void waitForMessageToDisappear() {
        withTimeoutOf(Duration.ofSeconds(10)).waitForElementsToDisappear(AUTOCLOSEABLE_SUCCESS_ALERT);
    }
}
