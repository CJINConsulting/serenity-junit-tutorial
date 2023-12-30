package seleniumeasy;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This is a series of exercises designed to explore how to use
 * Serenity BDD to test various kinds of HTML elements
 */

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenInteractingWithInputForms {

    @Managed(driver = "chrome")
    WebDriver driver;

    SingleInputFieldForm singleInputFieldForm;

    TwoInputFieldForm twoInputFieldForm;

    CheckboxForm checkboxForm;

    RadioButtonsForm radioButtonsForm;

    SelectListForm selectListForm;

    MultiSelectListForm multiSelectListForm;

    /**
     * Basic form fields:
     * Enter a message and check that the message is correctly displayed
     * https://www.seleniumeasy.com/test/basic-first-form-demo.html
     */

    @Test
    public void basicForms() {
        singleInputFieldForm.open();

        singleInputFieldForm.enterMessage("Hi there!");
        singleInputFieldForm.showMessage();

        assertThat(singleInputFieldForm.displayedMessage()).isEqualTo("Hi there!");

    }

    /**
     * Basic form fields (part 2)
     * Enter two values and calculate the result
     * https://www.seleniumeasy.com/test/basic-first-form-demo.html
     */

    @Test
    public void basicFormsWithMultipleFields() {

        twoInputFieldForm.open();

        twoInputFieldForm.enterA("2");
        twoInputFieldForm.enterB("3");
        twoInputFieldForm.getTotal();

        assertThat(twoInputFieldForm.displayedTotal()).isEqualTo("5");

    }

    /**
     * Checkboxes
     * Check that a message appears when you click the checkbox
     * https://www.seleniumeasy.com/test/basic-checkbox-demo.html
     */
    @Test
    public void singleCheckbox() {
        checkboxForm.open();
        assertThat(checkboxForm.getCheckboxWithLabel("Click on this check box").isSelected()).isFalse();
        checkboxForm.setAgeSelected();

        assertThat(checkboxForm.ageText()).isEqualTo("Success - Check box is checked");
        assertThat(checkboxForm.getCheckboxWithLabel("Click on this check box").isSelected()).isTrue();
    }

    private static final List<String> ALL_THE_OPTIONS = Arrays.asList(
            "Option 1", "Option 2", "Option 3", "Option 4");

    @Test
    public void multipleCheckboxes() {
        checkboxForm.open();

        assertThat(ALL_THE_OPTIONS).allMatch(
                option -> !checkboxForm.optionIsCheckedFor(option)
        );

        checkboxForm.checkAll();

        assertThat(ALL_THE_OPTIONS).allMatch(
                option -> checkboxForm.optionIsCheckedFor(option)
        );
    }

    @Test
    public void isDefaultChecked() {
        checkboxForm.open();
        assertThat(checkboxForm.getCheckboxWithLabel("Click on this check box").isSelected()).isFalse();
        assertThat(checkboxForm.getCheckboxWithLabel("Default Checked").isSelected()).isTrue();
        assertThat(checkboxForm.getCheckboxWithLabel("Default Disabled").isSelected()).isTrue();

    }

    @Test
    public void isDisabled() {

        checkboxForm.open();
        assertThat(checkboxForm.getCheckboxWithLabel("Click on this check box").isEnabled()).isTrue();
        assertThat(checkboxForm.getCheckboxWithLabel("Default Checked").isEnabled()).isTrue();
        assertThat(checkboxForm.getCheckboxWithLabel("Default Disabled").isDisabled()).isTrue();

    }

    /**
     * Radio buttons
     * Check that a message appears when you click the radio button
     * https://www.seleniumeasy.com/test/basic-radiobutton-demo.html
     */
    @Test
    public void radioButtons() {

        radioButtonsForm.open();

        radioButtonsForm.getCheckedValue();
        assertThat(radioButtonsForm.getResult()).isEqualTo("Radio button is Not checked");

        radioButtonsForm.selectOption("Male");
        radioButtonsForm.getCheckedValue();
        assertThat(radioButtonsForm.getResult()).isEqualTo("Radio button 'Male' is checked");

        radioButtonsForm.selectOption("Female");
        radioButtonsForm.getCheckedValue();
        assertThat(radioButtonsForm.getResult()).isEqualTo("Radio button 'Female' is checked");
    }

    MultipleRadioButtonsForm multipleRadioButtonsForm;

    @Test
    public void multipleRadioButtons() {

        multipleRadioButtonsForm.open();
        assertThat(multipleRadioButtonsForm.getResult()).isEmpty();

        multipleRadioButtonsForm.getValues();
        assertThat(multipleRadioButtonsForm.getResult())
                .contains("Sex :")
                .contains("Age group:");


        multipleRadioButtonsForm.selectGender("Male");
        multipleRadioButtonsForm.selectAgeGroup("0 - 5");
        multipleRadioButtonsForm.getValues();

        assertThat(multipleRadioButtonsForm.getResult())
                .contains("Sex : Male")
                .contains("Age group: 0 - 5");

        multipleRadioButtonsForm.selectGender("Female");
        multipleRadioButtonsForm.selectAgeGroup("15 - 50");
        multipleRadioButtonsForm.getValues();

        assertThat(multipleRadioButtonsForm.getResult())
                .contains("Sex : Female")
                .contains("Age group: 15 - 50");
    }

    /**
     * Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */
    @Test
    public void selectList() {
        selectListForm.open();

        assertThat(selectListForm.selectedDay()).isEmpty();
        selectListForm.selectDay("Sunday");
        assertThat(selectListForm.selectedDay()).isEqualTo("Sunday");
        assertThat(selectListForm.getSelectedValue()).isEqualTo("Day selected :- Sunday");

    }

    /**
     * Multi-Select Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */
    @Test
    public void multiSelectList() {

        multiSelectListForm.open();

        assertThat(multiSelectListForm.getSelectedStates()).isEmpty();
        multiSelectListForm.selectStates("Florida", "Ohio", "Texas");

        assertThat(multiSelectListForm.getSelectedStates()).containsExactly("Florida", "Ohio", "Texas");

    }

    HoverPage hoverPage;
    @Test
    public void hover() {
        hoverPage.open();

        hoverPage.hoverOverFigure(1);
        hoverPage.captionForFigure(1).shouldBeVisible();

    }

    @Test
    public void hoverAll() {
        hoverPage.open();
        List<WebElementFacade> figureList = hoverPage.getFigures();

        for (int i = 1; i <= figureList.size(); i++) {
            hoverPage.hoverOverFigure(i);
            hoverPage.captionForFigure(i)
                    .shouldBeVisible()
                    .shouldContainText("user" + i);
        }
    }
}
