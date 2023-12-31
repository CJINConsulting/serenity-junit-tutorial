package seleniumeasy.pageobjects;

import net.serenitybdd.annotations.DefaultUrl;


public class RadioButtonsForm extends SeleniumEasyForm {
    public void getCheckedValue() {
        $(FormButton.withLabel("Get Checked value")).click();
    }

    public String getResult() {
        return $(".radiobutton").getText();
    }

    public void selectOption(String value) {
        inRadioButtonGroup("optradio").selectByValue(value);
    }
}
