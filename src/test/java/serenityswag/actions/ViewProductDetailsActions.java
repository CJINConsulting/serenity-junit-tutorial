package serenityswag.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import serenityswag.pages.ProductListPage;

public class ViewProductDetailsActions extends UIInteractionSteps {

    ProductListPage productList;

    @Step("View product details for product '{0}'")
    public void forProductWithName(String firstItemName) {
        $(productList.productDetailsLinkFor(firstItemName)).click();
    }

}
