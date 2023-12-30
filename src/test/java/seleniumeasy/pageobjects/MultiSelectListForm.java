package seleniumeasy.pageobjects;

import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html")
public class MultiSelectListForm extends SeleniumEasyForm {

    private static final By STATES = By.id("multi-select");

    public void selectStates(String... states ) {
        selectMultipleItemsFromDropdown($(STATES), states);
    }

    public List<String> getSelectedStates() {
        return $(STATES).getSelectedValues();
    }
}