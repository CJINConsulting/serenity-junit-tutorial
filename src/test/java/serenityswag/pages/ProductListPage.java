package serenityswag.pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPage extends PageObject {

    public String getHeading() {
        return $(".title").getText();
    }

    public List<String> getProductTitles() {
        return $$(".inventory_item_name").textContents();
    }

    public void openProductDetailsFor(String itemName) {
        find(By.linkText(itemName)).click();
    }

    public By productDetailsLinkFor(String itemName) {
        return By.linkText(itemName);
    }

    public static By addToCartButtonFor(String itemName) {
        return By.xpath("//a[.='" + itemName + "']/ancestor::*[@class='inventory_item']//button[text()='Add to cart']");
    }
}
