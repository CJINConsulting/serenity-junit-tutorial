package seleniumeasy.pageobjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html")
public class SelectListForm extends SeleniumEasyForm {


    private static final By DAYS_OF_THE_WEEK = By.id("#select-demo");

    public void selectDay(String day) {
        $(DAYS_OF_THE_WEEK).select().byValue(day);
    }

    public String selectedDay() {
        return $(DAYS_OF_THE_WEEK).getSelectedValue();
    }

    public String getSelectedValue() {
        return $(".selected-value").getText();
    }
}
