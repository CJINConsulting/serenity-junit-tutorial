package seleniumeasy;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import seleniumeasy.actions.NavigateActions;
import seleniumeasy.pageobjects.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This is a series of exercises designed to explore how to use
 * Serenity BDD to test various kinds of HTML elements
 */

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenCalculatingValues {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    NavigateActions navigate;

    TwoInputFieldForm twoInputFieldForm;

    /**
     * Basic form fields:
     * Enter a message and check that the message is correctly displayed
     * https://www.seleniumeasy.com/test/basic-first-form-demo.html
     */

    @ParameterizedTest(name = "Should correctly sum the values {0} and {1}, to equal {2}")
    @CsvFileSource(resources = "/test-data/numbers.csv")
    /*@CsvSource({
            "1, 2, 3",
            "3, 4, 7",
            "7, 8, 15"
    })*/
    public void basicFormsWithMultipleFields(String value1, String value2, String total) {

        navigate.to(FormPages.TwoInputFieldForm);

        twoInputFieldForm.enterA(value1);
        twoInputFieldForm.enterB(value2);
        twoInputFieldForm.getTotal();

        assertThat(twoInputFieldForm.displayedTotal()).isEqualTo(total);

    }

}
