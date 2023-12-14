package serenityswag.pages;

import lombok.Getter;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

@Getter
public class InventoryPage extends PageObject {

    public String getHeading() {
        return $(".title").getText();
    }

}
