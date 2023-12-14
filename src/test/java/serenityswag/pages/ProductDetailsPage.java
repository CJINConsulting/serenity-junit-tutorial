package serenityswag.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;

import java.util.List;

public class ProductDetailsPage extends PageObject {

    public String getProductName() {
        return $(".inventory_details_name").getText();
    }

    public WebElementState getProductImageWithAltValueOf(String itemName) {
        return $(".inventory_details_container img[alt='{0}']", itemName);
    }
}
