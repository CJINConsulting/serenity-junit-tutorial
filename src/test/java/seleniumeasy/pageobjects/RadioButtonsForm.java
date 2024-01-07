package seleniumeasy.pageobjects;

import common.pageobjects.FormButton;


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
