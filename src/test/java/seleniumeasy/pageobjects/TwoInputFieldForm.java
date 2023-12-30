package seleniumeasy.pageobjects;


import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;

/**
 * Use this class as a base class for your page component objects so that the popup window is closed correctly
 * if it appears.
 */
@DefaultUrl("https://demo.seleniumeasy.com/basic-first-form-demo.html")
public class TwoInputFieldForm extends SeleniumEasyForm {

    public void enterA(String value) {
        $("#value1").type(value);
    }

    public void enterB(String value) {
        $("#value2").type(value);
    }

    public void getTotal() {
        $(FormButton.withLabel("Get Total")).click();
    }

    public String displayedTotal() {
        return $("#displayvalue").getText();
    }
}
