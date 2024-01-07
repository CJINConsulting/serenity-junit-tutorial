package seleniumeasy.pageobjects;

import common.pageobjects.FormButton;


public class MultipleRadioButtonsForm extends SeleniumEasyForm{

    public void selectGender(String gender) {
        inRadioButtonGroup("gender").selectByValue(gender);
    }

    public void selectAgeGroup(String ageGroup) {
        inRadioButtonGroup("ageGroup").selectByValue(ageGroup);
    }

    public void getValues() {
        $(FormButton.withLabel("Get values")).click();
    }

    public String getResult() {
        return $(".groupradiobutton").getText();
    }
}
