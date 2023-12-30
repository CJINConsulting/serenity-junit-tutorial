package seleniumeasy.pageobjects;

import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("https://demo.seleniumeasy.com/basic-radiobutton-demo.html")
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
