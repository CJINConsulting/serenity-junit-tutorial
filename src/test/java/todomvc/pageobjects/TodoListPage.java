package todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class TodoListPage extends PageObject {

    public static final By NEW_TODO_FIELD = By.className("new-todo");
    public static final By ITEM_LABELS = By.cssSelector(".todo-list label");
    public static String ITEM_LABEL = "//label[.='{0}']";
    public static final String COMPLETE_CHECKBOX = "//label[.='{0}']/preceding-sibling::input[@type='checkbox']";
    public static final String FILTER_BUTTON = "//ul[@class='filters']//a[.='{0}']";
    public static final String REMOVE_TODO_BUTTON = "//label[.='{0}']//following-sibling::button[@class='destroy']";

}
