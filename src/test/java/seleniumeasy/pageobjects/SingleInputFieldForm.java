package seleniumeasy.pageobjects;


import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;

/**
 * Use this class as a base class for your page component objects so that the popup window is closed correctly
 * if it appears.
 */

public class SingleInputFieldForm extends SeleniumEasyForm {


    public void enterMessage(String message) {
        $("#user-message").type(message);
    }

    public void showMessage() {
        $(FormButton.withLabel("Show Message")).click();
    }

    public String displayedMessage() {
        return $("#display").getText();
    }
}
