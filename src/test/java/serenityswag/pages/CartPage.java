package serenityswag.pages;

import lombok.Getter;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import serenityswag.inventory.CartItem;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPage extends PageObject {

    @FindBy(id = "checkout")
    WebElementFacade checkoutButton;

    @FindBy(className = "title")
    WebElementFacade title;

    @FindBy(className = "cart_item")
    List<WebElementFacade> cartItemElements;

    public static By CART_BADGE = By.cssSelector(".shopping_cart_link");
    public static By CART_ITEM = By.cssSelector(".cart_item");
    public static By CART_ITEM_PRICE = By.cssSelector(".cart_item .inventory_item_price");

    public void checkout() {
        checkoutButton.click();
    }

    public String getCartBadgeCount() {
        return $(CART_BADGE).getText();
    }

    public List<CartItem> items() {
        List<CartItem> cartItems = new ArrayList<>();
        for(WebElementFacade cartItemElement : cartItemElements) {
            String name = cartItemElement.findBy(".inventory_item_name").getText();
            String description = cartItemElement.findBy(".inventory_item_desc").getText();
            Double price = priceFrom(cartItemElement.findBy(".inventory_item_price").getText());
            cartItems.add(new CartItem(name, description, price));
        }
        return cartItems;
    }

    private Double priceFrom(String textValue) {
        return Double.parseDouble(textValue.replace("$", ""));
    }
}
