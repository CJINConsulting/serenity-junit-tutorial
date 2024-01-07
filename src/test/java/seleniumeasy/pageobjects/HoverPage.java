package seleniumeasy.pageobjects;

import io.cucumber.java.en_old.Ac;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class HoverPage extends PageObject {

    public static final String FIGURE_IMAGE = "(//*[@class='figure'])[{0}]";
    public static final String FIGURE_CAPTION = "(//*[@class='figcaption']/h5)[{0}]";

    @FindBy(xpath = "(//*[@class='figure'])")
    private List<WebElementFacade> LIST_OF_FIGURES;

    public void hoverOverFigure(int number) {
        WebElementFacade figure = $(FIGURE_IMAGE, number);

        withAction()
                .moveToElement(figure)
                .perform();
    }
    public WebElementState captionForFigure(int number) {
        return $(FIGURE_CAPTION, number);
    }

    public List<WebElementFacade> getFigures() {
        return LIST_OF_FIGURES;
    }
}
