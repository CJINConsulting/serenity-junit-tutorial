package seleniumeasy;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.actions.NavigateActions;
import seleniumeasy.pageobjects.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This is a series of exercises designed to explore how to use
 * Serenity BDD to test various kinds of HTML elements
 */

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenWaitingForElements {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    NavigateActions navigate;

    ModalDialogPage modalDialogPage;

    @Test
    public void waitingForAModalDialog() {
        navigate.to(FormPages.ModalDialogPage);

        modalDialogPage.saveChangesButton().shouldNotBeVisible();

        modalDialogPage.openModal();
        modalDialogPage.saveChangesButton().shouldBeVisible();

        modalDialogPage.saveChanges();
        modalDialogPage.saveChangesButton().shouldNotBeVisible();

    }

    AlertMessagePage alertMessagePage;

    @Test
    public void waitingForAMessageToClose() {
        navigate.to(FormPages.AlertMessagePage);

        alertMessagePage.openAutocloseableSuccessMessage();

        assertThat(alertMessagePage.autocloseableSuccessAlertMessageText())
                .contains("I'm an autocloseable success message.");

        alertMessagePage.waitForMessageToDisappear();

        assertThat(alertMessagePage.autocloseableSuccessAlert().shouldNotBeVisible());

    }

    DynamicDataPage dynamicDataPage;

    @Test
    public void waitingForElementsToAppear() {
        navigate.to(FormPages.DynamicDataPage);

        dynamicDataPage.getNewUser();

        assertThat(dynamicDataPage.userDescription())
                .contains("First Name")
                .contains("Last Name");
    }

    @Test
    public void waitingForElementsToDisappear() {

    }
}