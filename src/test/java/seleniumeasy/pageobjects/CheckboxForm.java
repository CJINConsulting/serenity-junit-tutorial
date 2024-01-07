package seleniumeasy.pageobjects;

import common.pageobjects.FormCheckbox;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Use this class as a base class for your page component objects so that the popup window is closed correctly
 * if it appears.
 */

public class CheckboxForm extends SeleniumEasyForm {

    public void setAgeSelected() {
        $(FormCheckbox.withLabel("Click on this check box")).click();
    }

    public String ageText() {
        return $("#txtAge").getText();
    }

    public WebElementFacade getCheckboxWithLabel(String label) {
        return $(FormCheckbox.withLabel(label));
    }

    public boolean optionIsCheckedFor(String option) {
        return $(FormCheckbox.withLabel(option)).isSelected();
    }

    public void checkAll() {
        $("css:input[value='Check All']").click();
    }
}
