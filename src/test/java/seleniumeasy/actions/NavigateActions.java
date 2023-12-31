package seleniumeasy.actions;

import net.serenitybdd.core.steps.UIInteractions;
import seleniumeasy.pageobjects.FormPages;

public class NavigateActions extends UIInteractions {

    public void to(FormPages page) {
        openPageNamed(page.name());
    }
}
