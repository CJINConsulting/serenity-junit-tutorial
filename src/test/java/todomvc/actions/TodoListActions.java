package todomvc.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import todomvc.pageobjects.TodoListPage;
import java.util.List;

import static todomvc.pageobjects.TodoListPage.*;

public class TodoListActions extends UIInteractionSteps {

    TodoListPage todoListPage;

    @Step("Adding item '{0}'")
    public void addItem(String item) {
        $(NEW_TODO_FIELD).typeAndEnter(item);
    }

    public List<String> items() {
        return $$(ITEM_LABELS).texts();
    }

    @Step("Add items {0}")
    public void addItems(String... items) {
        for (String item : items) {
            addItem(item);
        }
    }

    @Step("Add items {0}")
    public void addItems(List<String> items) {
        items.forEach(this::addItem);
    }

    @Step("Completing item '{0}'")
    public void completeItem(String item) {
        $(COMPLETE_CHECKBOX, item).click();
    }

    @Step("Complete items {0}")
    public void completeItems(String... items) {
        for (String item : items) {
            completeItem(item);
        }
    }

    @Step("Filter by '{0}'")
    public void filterBy(String filter) {
        $(FILTER_BUTTON, filter).click();
    }

    @Step("Deleting item {0}")
    public void deleteItem(String item) {
        $(ITEM_LABEL, item).click();
        $(REMOVE_TODO_BUTTON, item).click();

    }

    @Step("Delete items {0}")
    public void deleteItems(String... items) {
        for (String item : items) {
            deleteItem(item);
        }
    }
}
