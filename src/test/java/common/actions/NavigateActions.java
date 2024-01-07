package common.actions;

import net.serenitybdd.core.steps.UIInteractions;
import common.pageobjects.FormPages;

public class NavigateActions extends UIInteractions {

    public void to(FormPages page) {
        openPageNamed(page.name());
    }
}
