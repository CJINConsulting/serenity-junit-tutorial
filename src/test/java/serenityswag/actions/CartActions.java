package serenityswag.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import serenityswag.pages.CartPage;
import serenityswag.pages.ProductListPage;

import java.util.List;

public class CartActions extends UIInteractionSteps {

    CartPage cartPage;

    @Step("Add {0} to the cart")
    public void addItem(String itemName) {
        $(ProductListPage.addToCartButtonFor(itemName)).click();
    }

    @Step("Add {0} to the cart")
    public void addItems(List<String> items) {
        items.forEach(this::addItem);
    }

    public List<String> displayedItems() {
        return $$(".inventory_item_name").texts();
    }
}
