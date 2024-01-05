package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;

public class ModalDialogPage extends SeleniumEasyForm {

    private static final By LAUNCH_MODAL_BUTTON = By.linkText("Launch modal");
    private static final By SAVE_CHANGES_BUTTON = By.linkText("Save changes");

    public void openModal() {
        $(LAUNCH_MODAL_BUTTON).click();
    }

    public WebElementState saveChangesButton() {
        return $(SAVE_CHANGES_BUTTON);
    }

    public void saveChanges() {
        $(SAVE_CHANGES_BUTTON).click();
    }
}