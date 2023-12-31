package serenityswag.inventory;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.actions.CartActions;
import serenityswag.actions.LoginActions;
import serenityswag.actions.ProductListActions;
import serenityswag.pages.CartPage;
import serenityswag.pages.ProductListPage;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingAnItemToTheCart {

    @Managed
    private WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    ProductListActions productList;

    @Steps
    CartActions cart;

    ProductListPage productListPage;

    CartPage cartPage;

    @BeforeEach
    public void login() {
        login.as(STANDARD_USER);
    }

    @Test
    public void theCorrectItemCountShouldBeShown() {

        // check that the shopping cart badge is empty
        Serenity.reportThat("Then the shopping cart badge should be empty",
                () -> assertThat(cartPage.getCartBadgeCount()).isEmpty()
        );

        // Add 1 item to the cart
        cart.addItem("Sauce Labs Backpack");

        // The shopping cart badge should be "1"
        Serenity.reportThat("Then the shopping cart badge should now be '1'",
                () -> assertThat(cartPage.getCartBadgeCount()).isEqualTo("1")
        );

    }

    @Test
    public void allTheItemsShouldAppearInTheCart() {

        List<String> selectedItems = productListPage.getProductTitles();
        int numberOfProducts = selectedItems.size();

        // check that the shopping cart badge is empty
        Serenity.reportThat("Then the shopping cart badge should be empty",
                () -> assertThat(cartPage.getCartBadgeCount()).isEmpty()
        );

        // Add several items to the cart
        cart.addItems(selectedItems);

        cartPage.open();

        Serenity.reportThat("Then the shopping cart badge should now be '" + numberOfProducts + "'",
                () -> assertThat(cartPage.getCartBadgeCount()).isEqualTo(String.valueOf(selectedItems.size()))
        );

        Serenity.reportThat("Then the number of items in the cart should be '" + numberOfProducts + "'",
                () -> assertThat(cart.displayedItems().size()).isEqualTo(selectedItems.size())
        );

        Serenity.reportThat("Then the shopping cart item names should match the selected items",
                () -> assertThat(cart.displayedItems()).containsExactlyElementsOf(selectedItems)
        );
    }

    @Test
    public void pricesForEachItemShouldBeShownInTheCart() {

        // add items to the shopping cart
        List<String> selectedItems = productListPage.getProductTitles();
        int numberOfProducts = selectedItems.size();

        // Add several items to the cart
        cart.addItems(selectedItems);

        // open the cart
        cartPage.open();

        // check that each item in the cart has a price
        List<CartItem> items = cartPage.items();

        Serenity.reportThat("Then the number of items in the cart should be '" + numberOfProducts + "'",
                () -> assertThat(items)
                        .hasSize(selectedItems.size())
                        .allMatch(item -> item.price() > 0.0)
                        .allMatch(item -> !item.title().isEmpty())
                        .allMatch(item -> !item.description().isEmpty())
        );
    }
}
